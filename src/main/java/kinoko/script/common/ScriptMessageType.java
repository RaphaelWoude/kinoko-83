package kinoko.script.common;

public enum ScriptMessageType {
    // SM
    SAY(0),
    ASKYESNO(1),
    ASKTEXT(2),
    ASKNUMBER(3),
    ASKMENU(4),
    ASKQUIZ(5),
    ASKSPEEDQUIZ(6),
    ASKAVATAR(7),
    ASKMEMBERSHOPAVATAR(8),
    ASKPET(9),
    ASKPETALL(10),
    ASKACCEPT(12),
    ASKBOXTEXT(13),
    ASKSLIDEMENU(14);

    private final byte value;

    ScriptMessageType(int value) {
        this.value = (byte) value;
    }

    public final byte getValue() {
        return value;
    }

    public static ScriptMessageType getByValue(int value) {
        for (ScriptMessageType type : values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        return null;
    }
}
