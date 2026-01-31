package kinoko.world.user.stat;

import kinoko.provider.ItemProvider;
import kinoko.provider.item.ItemInfo;
import kinoko.provider.item.ItemInfoType;
import kinoko.world.GameConstants;
import kinoko.world.item.EquipData;
import kinoko.world.item.Item;
import kinoko.world.skill.PassiveSkillData;
import kinoko.world.skill.SkillManager;

import java.util.Map;
import java.util.Optional;

public final class BasicStat {
    private int gender;
    private int level;
    private int job;
    private int str;
    private int dex;
    private int int_;
    private int luk;
    private int pop;
    private int maxHp;
    private int maxMp;

    public int getGender() {
        return gender;
    }

    public int getLevel() {
        return level;
    }

    public int getJob() {
        return job;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getInt() {
        return int_;
    }

    public int getLuk() {
        return luk;
    }

    public int getPop() {
        return pop;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }


    // VALIDATE STAT METHODS -------------------------------------------------------------------------------------------

    public void setFrom(CharacterStat cs, ForcedStat fs, SecondaryStat ss, SkillManager sm, PassiveSkillData psd, Map<Integer, Item> realEquip) {
        this.gender = cs.getGender();
        this.level = cs.getLevel();
        this.job = cs.getJob();
        this.str = cs.getBaseStr();
        this.dex = cs.getBaseDex();
        this.int_ = cs.getBaseInt();
        this.luk = cs.getBaseLuk();
        this.pop = cs.getPop();
        this.maxHp = cs.getMaxHp();
        this.maxMp = cs.getMaxMp();

        int incMaxHpR = 0;
        int incMaxMpR = 0;

        // Equip stats
        for (var item : realEquip.values()) {
            final Optional<ItemInfo> itemInfoResult = ItemProvider.getItemInfo(item.getItemId());
            if (itemInfoResult.isEmpty()) {
                continue;
            }
            final ItemInfo ii = itemInfoResult.get();

            // Apply stats
            final EquipData ed = item.getEquipData();
            this.str += ed.getIncStr();
            this.int_ += ed.getIncInt();
            this.dex += ed.getIncDex();
            this.luk += ed.getIncLuk();
            this.maxHp += ed.getIncMaxHp();
            this.maxMp += ed.getIncMaxMp();

            incMaxHpR += ii.getInfo(ItemInfoType.incMHPr);
            incMaxMpR += ii.getInfo(ItemInfoType.incMMPr);
        }

        // BasicStatUp CTS (Maple Warrior)
        final int basicStatUp = ss.getOption(CharacterTemporaryStat.BasicStatUp).nOption;
        this.str += basicStatUp * cs.getBaseStr() / 100;
        this.dex += basicStatUp * cs.getBaseDex() / 100;
        this.int_ += basicStatUp * cs.getBaseInt() / 100;
        this.luk += basicStatUp * cs.getBaseLuk() / 100;

        // Forced Stat
        if (fs.getStr() > 0) {
            this.str = fs.getStr();
        }
        if (fs.getDex() > 0) {
            this.dex = fs.getDex();
        }
        if (fs.getInt() > 0) {
            this.int_ = fs.getInt();
        }
        if (fs.getLuk() > 0) {
            this.luk = fs.getLuk();
        }

        // EMHP/EMMP CTS
        this.maxHp += ss.getOption(CharacterTemporaryStat.EMHP).nOption;
        this.maxMp += ss.getOption(CharacterTemporaryStat.EMMP).nOption;

        int hpIncRateFromCts = ss.getOption(CharacterTemporaryStat.Conversion).nOption;
        hpIncRateFromCts = Math.max(hpIncRateFromCts, ss.getOption(CharacterTemporaryStat.MaxHP).nOption);
        hpIncRateFromCts = Math.max(hpIncRateFromCts, ss.getOption(CharacterTemporaryStat.MorewildMaxHP).nOption);
        int mpIncRateFromCts = ss.getOption(CharacterTemporaryStat.SwallowMaxMP).nOption;
        mpIncRateFromCts += ss.getOption(CharacterTemporaryStat.MaxMP).nOption;

        // Max hp/mp rate increases
        this.maxHp += this.maxHp * (incMaxHpR + hpIncRateFromCts + psd.getMhpR()) / 100;
        this.maxMp += this.maxMp * (incMaxMpR + mpIncRateFromCts + psd.getMmpR()) / 100;

        // Max hp/mp cap
        this.maxHp = Math.min(this.maxHp, GameConstants.HP_MAX);
        this.maxMp = Math.min(this.maxMp, GameConstants.MP_MAX);
    }

}
