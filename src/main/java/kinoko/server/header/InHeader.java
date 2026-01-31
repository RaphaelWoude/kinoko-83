package kinoko.server.header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum InHeader {
    // CP
    // BEGIN_SOCKET(0),
    CheckPassword(1),
    GuestIDLogin(2),
    AccountInfoRequest(3),
    WorldInfoRequest(4),
    SelectWorld(5),
    CheckUserLimit(6),
    ConfirmEULA(7),
    SetGender(8),
    CheckPinCode(9),
    UpdatePinCode(10),
    WorldRequest(11),
    LogoutWorld(12),
    ViewAllChar(13),
    SelectCharacterByVAC(14),
    VACFlagSet(15),
    CheckNameChangePossible(16),
    RegisterNewCharacter(17),
    CheckTransferWorldPossible(18),
    SelectCharacter(19),
    MigrateIn(20),
    CheckDuplicatedID(21),
    CreateNewCharacter(22),
    DeleteCharacter(23),
    Pong(24),
    ExceptionLog(26),
    CreateSecurityHandle(25),
    SSOErrorLog(26),
    ClientDumpLog(27),
    Relog(28),
    EnableSPWRequest(29),
    CheckSPWRequest(30),
    UserTransferFieldRequest(38),
    UserTransferChannelRequest(39),
    UserMigrateToCashShopRequest(40),
    UserMove(41),
    UserSitRequest(42),
    UserPortableChairSitRequest(43),

    UserMeleeAttack(44),
    UserShootAttack(45),
    UserMagicAttack(46),
    UserBodyAttack(47),
    // UserMovingShootAttackPrepare(27),
    UserHit(48),
    UserChat(49),
    UserADBoardClose(50),
    UserEmotion(51),
    UserActivateEffectItem(52),
    UserUpgradeTombEffect(53),
    UserSelectNpc(58),
    UserRemoteShopOpenRequest(59),
    UserScriptMessageAnswer(60),
    UserShopRequest(61),
    UserTrunkRequest(62),
    UserEntrustedShopRequest(63),
    UserStoreBankRequest(64),
    UserParcelRequest(65),
    //UserEffectLocal(71),
    ShopScannerRequest(66),
    ShopLinkRequest(67),
    AdminShopRequest(68),
    UserGatherItemRequest(69),
    UserSortItemRequest(70),
    UserChangeSlotPositionRequest(71),
    UserStatChangeItemUseRequest(72),
    UserStatChangeItemCancelRequest(73),
    UserStatChangeByPortableChairRequest(74),
    UserMobSummonItemUseRequest(75),
    UserPetFoodItemUseRequest(76),
    UserTamingMobFoodItemUseRequest(77),
    UserScriptItemUseRequest(78),
    UserConsumeCashItemUseRequest(79),
    UserSkillLearnItemUseRequest(81),
    UserSkillResetItemUseRequest(82),
    UserMapTransferItemUseRequest(84),
    UserPortalScrollUseRequest(85),
    UserUpgradeItemUseRequest(86),
    UserAbilityUpRequest(87),
    UserAbilityMassUpRequest(88),
    UserChangeStatRequest(89),

    UserSkillUpRequest(90),
    UserSkillUseRequest(91),
    UserSkillCancelRequest(92),
    UserSkillPrepareRequest(93),
    UserDropMoneyRequest(94),
    UserGivePopularityRequest(95),
    UserCharacterInfoRequest(97),
    UserActivatePetRequest(98),

    UserPortalScriptRequest(100),
    UserPortalTeleportRequest(101),
    UserMapTransferRequest(102),
    UserQuestRequest(107),
    UserCalcDamageStatSetRequest(108),
    UserThrowGrenade(109),
    UserMacroSysDataModified(110),
    UserLotteryItemUseRequest(111),

    PartyRequest(124),
    PartyResult(125),
    GuildRequest(126),
    GuildResult(127),

    UserItemMakeRequest(113),
    UserClientTimerEndRequest(133),
    GroupMessage(140),
    Whisper(141),
    CoupleMessage(142),
    Messenger(143),
    MiniRoom(144),
    FriendRequest(153),
    MemoRequest(154),
    EnterTownPortalRequest(156),
    EnterOpenGateRequest(157),
    FuncKeyMappedModified(135),
    StalkBegin(166),
    AllianceRequest(167),
    AllianceResult(168),

    SummonedMove(175),
    SummonedAttack(176),
    SummonedHit(177),
    SummonedSkill(178),
    SummonedRemove(179),
    GuildBBS(179),
    CashItemGachaponRequest(185),
    PetMove(199),
    PetAction(200),
    PetInteractionRequest(201),
    PetDropPickUpRequest(202),
    PetStatChangeItemUseRequest(203),
    PetUpdateExceptionListRequest(204),
    DragonMove(214),
    QuickslotKeyMappedModified(216),
    PassiveskillInfoUpdate(217),
    UpdateScreenSetting(218),
    MobMove(188),
    MobApplyCtrl(189),
    MobHitByMob(192),
    MobAttackMob(194),
    // NpcMove(197),
    DropPickUpRequest(202),
    ReactorHit(205),
    ReactorTouch(206),

    RequireFieldObstacleStatus(251),
    CONTISTATE(264),
    CANCEL_INVITE_PARTY_MATCH(267),
    CashShopQueryCashRequest(274),
    CashShopCashItemRequest(275),
    NO(314);

    private static final List<InHeader> headers;
    private static final Set<InHeader> ignoreHeaders = Set.of(
            UserMove,
            MobMove
//            CreateSecurityHandle,
//            UpdateScreenSetting,
//            FuncKeyMappedModified,
//            QuickslotKeyMappedModified,
//            UserEmotion,
//            UserChangeStatRequest,
//            RequestIncCombo,
//            PetMove,
//            PetAction,
//            DragonMove,
//            SummonedMove,
//            MobApplyCtrl,
//            NpcMove,
//            CANCEL_INVITE_PARTY_MATCH
    );

    static {
        final List<InHeader> headerList = new ArrayList<>(Collections.nCopies(NO.getValue() + 1, null));
        for (InHeader header : values()) {
            headerList.set(header.getValue(), header);
        }
        headers = Collections.unmodifiableList(headerList);
    }

    private final short value;

    InHeader(int value) {
        this.value = (short) value;
    }

    public final short getValue() {
        return value;
    }

    public final boolean isIgnoreHeader() {
        return ignoreHeaders.contains(this);
    }

    public static InHeader getByValue(short op) {
        if (op >= 0 && op < NO.getValue()) {
            return headers.get(op);
        }
        return null;
    }
}
