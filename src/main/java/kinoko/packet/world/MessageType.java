package kinoko.packet.world;

public enum MessageType {
    // MS
    DropPickUp(0),
    QuestRecord(1),
    CashItemExpire(2),
    IncEXP(3),
    IncSP(4),
    // IncPOP(5),
    IncMoney(5),
    IncGP(6),
    GiveBuff(7),
    GeneralItemExpire(8),
    System(9),
    QuestRecordEx(10),
    ItemProtectExpire(11),
    ItemExpireReplace(12),
    SkillExpire(13);

    private final byte value;

    MessageType(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }
}
