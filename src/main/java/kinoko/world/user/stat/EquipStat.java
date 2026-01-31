package kinoko.world.user.stat;

import kinoko.provider.EtcProvider;
import kinoko.provider.ItemProvider;
import kinoko.provider.item.ItemInfo;
import kinoko.provider.item.ItemInfoType;
import kinoko.world.item.*;
import kinoko.world.user.Pet;
import kinoko.world.user.User;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for resolving valid equipped items for a User. This is only instantiated for computing and checking the
 * stat requirements of equipped items.
 */
public final class EquipStat {
    private int incStr = 0;
    private int incDex = 0;
    private int incInt = 0;
    private int incLuk = 0;
    private int incStrR = 0;
    private int incDexR = 0;
    private int incIntR = 0;
    private int incLukR = 0;

    public EquipStat() {
    }

    public EquipStat(EquipStat stat) {
        this.incStr = stat.incStr;
        this.incDex = stat.incDex;
        this.incInt = stat.incInt;
        this.incLuk = stat.incLuk;
        this.incStrR = stat.incStrR;
        this.incDexR = stat.incDexR;
        this.incIntR = stat.incIntR;
        this.incLukR = stat.incLukR;
    }

    private int getStr(int baseStr) {
        final int totalStr = baseStr + incStr;
        return totalStr + (totalStr * incStrR / 100);
    }

    private int getDex(int baseDex) {
        final int totalDex = baseDex + incDex;
        return totalDex + (totalDex * incDexR / 100);
    }

    private int getInt(int baseInt) {
        final int totalInt = baseInt + incInt;
        return totalInt + (totalInt * incIntR / 100);
    }

    private int getLuk(int baseLuk) {
        final int totalLuk = baseLuk + incLuk;
        return totalLuk + (totalLuk * incLukR / 100);
    }


    public static Map<Integer, Item> getRealEquip(User user) {
        final CharacterStat cs = user.getCharacterStat();
        final int basicStatUp = user.getSecondaryStat().getOption(CharacterTemporaryStat.BasicStatUp).nOption;
        final int baseStr = cs.getBaseStr() + (basicStatUp * cs.getBaseStr() / 100);
        final int baseDex = cs.getBaseDex() + (basicStatUp * cs.getBaseDex() / 100);
        final int baseInt = cs.getBaseInt() + (basicStatUp * cs.getBaseInt() / 100);
        final int baseLuk = cs.getBaseLuk() + (basicStatUp * cs.getBaseLuk() / 100);

        EquipStat stat = new EquipStat();

        // Compute total stat
        final InventoryManager im = user.getInventoryManager();
        final Inventory equipped = im.getEquipped();
        for (var entry : equipped.getItems().entrySet()) {
            final BodyPart bodyPart = BodyPart.getByValue(entry.getKey());
            if (bodyPart == BodyPart.EXT_PENDANT1 && im.getExtSlotExpire().isBefore(Instant.now())) {
                continue;
            }
            final Item item = entry.getValue();
            if (item.getItemType() != ItemType.EQUIP) {
                continue;
            }

            final EquipData ed = item.getEquipData();
            stat.incStr += ed.getIncStr();
            stat.incDex += ed.getIncDex();
            stat.incInt += ed.getIncInt();
            stat.incLuk += ed.getIncLuk();
        }

        // Build real equip list
        final Map<Integer, Item> realEquip = new HashMap<>();
        final Item weapon = equipped.getItem(BodyPart.WEAPON.getValue());
        for (var entry : equipped.getItems().entrySet()) {
            // Resolve item info and equip data
            final int position = entry.getKey();
            final Item item = entry.getValue();
            if (item.getItemType() != ItemType.EQUIP) {
                continue;
            }
            final Optional<ItemInfo> itemInfoResult = ItemProvider.getItemInfo(item.getItemId());
            if (itemInfoResult.isEmpty()) {
                continue;
            }
            final ItemInfo ii = itemInfoResult.get();
            final EquipData ed = item.getEquipData();

            // Compute stat without this equip
            final EquipStat statWithout = new EquipStat(stat);
            statWithout.incStr -= ed.getIncStr();
            statWithout.incDex -= ed.getIncDex();
            statWithout.incInt -= ed.getIncInt();
            statWithout.incLuk -= ed.getIncLuk();

            // Find applicable pet
            final Pet pet;
            if (position == BodyPart.PETWEAR.getValue()) {
                pet = user.getPet(0);
            } else if (position == BodyPart.PETWEAR2.getValue()) {
                pet = user.getPet(1);
            } else if (position == BodyPart.PETWEAR3.getValue()) {
                pet = user.getPet(2);
            } else {
                pet = null;
            }

            // Check if able to equip
            if (ii.isAbleToEquip(
                    cs.getGender(),
                    cs.getLevel(),
                    cs.getJob(),
                    statWithout.getStr(baseStr),
                    statWithout.getDex(baseDex),
                    statWithout.getInt(baseInt),
                    statWithout.getLuk(baseLuk),
                    cs.getPop(),
                    ed.getDurability(),
                    weapon != null ? weapon.getItemId() : 0,
                    pet != null ? pet.getTemplateId() : 0
            )) {
                realEquip.put(position, item);
            } else {
                stat = statWithout;
            }
        }
        return Collections.unmodifiableMap(realEquip);
    }
}
