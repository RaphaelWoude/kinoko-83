package kinoko.packet.stage;

import kinoko.server.cashshop.CashShop;
import kinoko.server.header.OutHeader;
import kinoko.server.packet.OutPacket;
import kinoko.util.Util;
import kinoko.world.user.User;

import java.time.Instant;

public final class StagePacket {
    // CStage::OnPacket ------------------------------------------------------------------------------------------------

    public static OutPacket migrateToField(User user, int channelId) {
        final OutPacket outPacket = OutPacket.of(OutHeader.SetField);
        outPacket.encodeInt(channelId); // nChannelID
        outPacket.encodeByte(1);
        outPacket.encodeByte(1);
        outPacket.encodeShort(0);

        final int s1 = Util.getRandom().nextInt();
        final int s2 = Util.getRandom().nextInt();
        final int s3 = Util.getRandom().nextInt();
        user.getCalcDamage().setSeed(s1, s2, s3);
        user.getCalcDamage().setNextAttackCritical(false);
        outPacket.encodeInt(s1);
        outPacket.encodeInt(s2);
        outPacket.encodeInt(s3);

        // CharacterData::Decode
        user.getCharacterData().encode(outPacket);

        outPacket.encodeFT(Instant.now()); // ftServer
        return outPacket;
    }

    public static OutPacket setField(User user, int channelId, boolean isRevive) {
        final OutPacket outPacket = OutPacket.of(OutHeader.SetField);
        outPacket.encodeInt(channelId); // nChannelID
        outPacket.encodeInt(0);
        outPacket.encodeByte(0);
        outPacket.encodeInt(user.getCharacterStat().getPosMap());
        outPacket.encodeByte(user.getCharacterStat().getPortal());
        outPacket.encodeShort(user.getHp());
        outPacket.encodeByte(false); // bChaseEnable -> int, int

        outPacket.encodeFT(Instant.now()); // ftServer
        return outPacket;
    }

    public static OutPacket setCashShop(User user) {
        final OutPacket outPacket = OutPacket.of(OutHeader.SetCashShop);
        user.getCharacterData().encode(outPacket);

        // CCashShop::LoadData
        outPacket.encodeByte(true); // bCashShopAuthorized
        outPacket.encodeString(user.getAccount().getUsername()); // sNexonClubID
        CashShop.encode(outPacket);
        // ~CCashShop::LoadData

        outPacket.encodeByte(false); // bEventOn
        outPacket.encodeInt(user.getLevel()); // nHighestCharacterLevelInThisAccount
        return outPacket;
    }
}
