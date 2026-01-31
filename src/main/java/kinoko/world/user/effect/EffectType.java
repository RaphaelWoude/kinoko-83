package kinoko.world.user.effect;

public enum EffectType {
    // UserEffect
    LevelUp(0),
    SkillUse(1),
    SkillAffected(2),
    Quest(3),
    Pet(4),
    SkillSpecial(5),
    ProtectOnDieItemUse(6),
    PlayPortalSE(7),
    JobChanged(8),
    QuestComplete(9),
    IncDecHPEffect(10),
    BuffItemEffect(11),
    SquibEffect(12),
    MonsterBookCardGet(13),
    LotteryUse(14),
    ItemLevelUp(15),
    ItemMaker(16),
    ExpItemConsumed(17),
    ReservedEffect(18),
    Buff(19),
    ConsumeEffect(20),
    UpgradeTombItemUse(21),
    BattlefieldItemUse(22),
    AvatarOriented(23),
    IncubatorUse(24),
    PlaySoundWithMuteBGM(25),
    SoulStoneUse(26),
    IncDecHPEffect_EX(27);

    private final int value;

    EffectType(int value) {
        this.value = value;
    }

    public final int getValue() {
        return value;
    }
}
