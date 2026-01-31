package kinoko.server.header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public enum OutHeader {
    // CLogin::OnPacket
    CheckPasswordResult(0),
    GuestIDLoginResult(1),
    AccountInfoResult(2),
    CheckUserLimitResult(3),
    SetAccountResult(4),
    ConfirmEULAResult(5),
    CheckPinCodeResult(6),
    UpdatePinCodeResult(7),
    ViewAllCharResult(8),
    SelectCharacterByVACResult(9),
    WorldInformation(10),
    SelectWorldResult(11),
    SelectCharacterResult(12),
    CheckDuplicatedIDResult(13),
    CreateNewCharacterResult(14),
    DeleteCharacterResult(15),

    // CClientSocket::ProcessPacket
    MigrateCommand(16),
    AliveRequest(17),
    AuthCodeChanged(18),
    AUTH_MESSAGE(19),
    SECURITY_PACKET(20),

    // CLogin::OnPacket
    LatestConnectedWorld(26),
    RecommendWorldMessage(27),
    OnEnableSPWResult(23),
    OnLatestConnectedWorld(26),
    CheckSPWResult(28),

    // CWvsContext::OnPacket
    InventoryOperation(29),
    InventoryGrow(30),
    StatChanged(31),
    TemporaryStatSet(32),
    TemporaryStatReset(33),
    ForcedStatSet(34),
    ForcedStatReset(35),
    ChangeSkillRecordResult(36),
    SkillUseResult(37),
    GivePopularityResult(38),
    Message(39),
    OpenFullClientDownloadLink(40),
    MemoResult(41),
    MapTransferResult(42),
    AntiMacroResult(43),

    ClaimResult(45),
    SetClaimSvrAvailableTime(46),
    ClaimSvrStatusChanged(47),
    SetTamingMobInfo(48),
    CWvsContext(49),
    EntrustedShopCheckResult(50),
    SkillLearnItemResult(51),

    GatherItemResult(52),
    SortItemResult(53),

    SueCharacterResult(55),

    TradeMoneyLimit(57),
    SetGender(58),
    GuildBBS(59),

    CharacterInfo(61),
    PartyResult(62),
    FriendResult(63),

    GuildResult(65),
    AllianceResult(66),
    TownPortal(67),
    BroadcastMsg(68),
    IncubatorResult(69),
    ShopScannerResult(70),
    ShopLinkResult(71),
    MarriageRequest(72),
    MarriageResult(73),
    WeddingGiftResult(74),
    NotifyMarriedPartnerMapTransfer(75),
    CashPetFoodResult(76),

    SetPotionDiscountRate(78),
    BridleMobCatchFail(79),
    ImitatedNPCResult(80),

    // CNpcPool::OnPacket
    ImitateNpcData(81),
    UpdateLimitedNpcDisableInfo(82),

    // CWvsContext::OnPacket
    OnMonsterBookSetCard(83),
    OnMonsterBookSetCover(84),
    HourChanged(85),
    MiniMapOnOff(86),
    ConsultAuthKeyUpdate(87),
    ClassCompetitionAuthKeyUpdate(88),
    WebBoardAuthKeyUpdate(89),
    SessionValue(90),
    FieldSetVariable(91),

    PotionDiscountRateChanged(93),
    FamilyChartRequest(94),
    FamilyInfoResult(95),
    FamilyResult(96),
    FamilyJoinRequest(97),
    FamilyJoinRequestResult(98),
    FamilyJoinAccepted(99),
    FamilyPrivilegeList(100),
    FamilyFamousPointIncResult(101),
    FamilyNotifyLoginOrLogout(102),
    FamilySetPrivilege(103),
    FamilySummonRequest(104),

    NotifyLevelUp(105),
    NotifyWedding(106),
    NotifyJobChange(107),

    MapleTVUseRes(109),
    AvatarMegaphoneRes(110),
    SetAvatarMegaphone(111),
    ClearAvatarMegaphone(112),
    CancelNameChangeResult(113),
    CancelTransferWorldResult(114),
    DestroyShopResult(115),
    FakeGMNotice(116),
    SuccessInUseGachaponBox(117),
    NewYearCardRes(118),

    RandomMorphRes(119),
    CancelNameChangebyOther(120),
    SetBuyEquipExt(121),
    ScriptProgressMessage(122),

    DataCRCCheckFailed(123),

    // CStage::OnPacket
    SetField(125),
    SetITC(126),
    SetCashShop(127),

    // CMapLoadable::OnPacket
    SetBackgroundEffect(128),
    SetMapObjectVisible(129),
    ClearBackgroundEffect(130),

    // CField::OnPacket
    TransferFieldReqIgnored(131),
    TransferChannelReqIgnored(132),
    FieldSpecificData(133),
    GroupMessage(134),
    Whisper(135),
    CoupleMessage(136),
    MobSummonItemUseResult(137),
    FieldEffect(138),
    FieldObstacleOnOff(139),
    FieldObstacleOnOffStatus(140),
    FieldObstacleAllReset(141),

    BlowWeather(142),
    PlayJukeBox(143),
    AdminResult(144),
    Quiz(145),
    Desc(146),
    ScriptEvent(147), // clock?

    // CField_ContiMove::OnPacket
    CONTIMOVE(148),
    CONTISTATE(149),

    // CField::OnPacket
    SetQuestClear(150),
    SetQuestTime(151),
    Warn(152),
    SetObjectState(153),
    DestroyClock(154),
    StalkResult(155),
    QuickslotMappedInit(159),

    // CUserPool::OnPacket
    UserEnterField(160),
    UserLeaveField(161),

    // CUserPool::OnUserCommonPacket
    UserChat(162),
    UserChatNLCPQ(163),
    UserADBoard(164),
    UserMiniRoomBalloon(165),
    UserConsumeItemEffect(166),
    UserItemUpgradeEffect(167),

    // CUser::OnPetPacket
    PetActivated(168),
    PetMove(170),
    PetAction(171),
    PetNameChanged(172),
    PetLoadExceptionList(173),
    PetActionCommand(174),


    // CSummonedPool::OnPacket
    SummonedEnterField(175),
    SummonedLeaveField(176),
    SummonedMove(177),
    SummonedAttack(178),
    SummonedSkill(179),
    SummonedHit(180),

    // CUser::OnDragonPacket
    DragonEnterField(181),
    DragonMove(182),
    DragonLeaveField(183),

    // CUserPool::OnUserRemotePacket
    UserMove(185),
    UserMeleeAttack(186),
    UserShootAttack(187),
    UserMagicAttack(188),
    UserBodyAttack(189),
    UserSkillPrepare(190),
    // UserMovingShootAttackPrepare(216), // ????
    UserSkillCancel(191),
    UserHit(192),
    UserEmotion(193),
    UserSetActiveEffectItem(194),
    // UserShowUpgradeTombEffect(221), // ????
    UserSetActivePortableChair(196),
    UserAvatarModified(197),
    UserEffectRemote(198),
    UserTemporaryStatSet(199),
    UserTemporaryStatReset(200),

    UserHP(201),
    UserGuildNameChanged(202),
    UserGuildMarkChanged(203),
    UserThrowGrenade(204),

    // CUserLocal::OnPacket
    UserSitResult(205),
    UserEffectLocal(206),
    UserTeleport(207),
    UserMesoGiveSucceeded(209),
    UserMesoGiveFailed(210),
    UserQuestResult(211),
    UserNotifyHPDecByField(212),
    UserBalloonMsg(214),
    UserPlayEventSound(215),
    UserPlayMinigameSound(216),
    UserMakerResult(217),
    UserOpenClassCompetitionPage(219),
    UserOpenUI(220),
    SetDirectionMode(221),
    SetStandAloneMode(222),
    UserHireTutor(223),
    UserTutorMsg(224),
    IncComboResponse(225),
    UserRandomEmotion(226),
    ResignQuestReturn(227),
    PassMateName(228),
    RadioSchedule(229),
    UserOpenSkillGuide(230),
    UserNoticeMsg(231),
    UserChatMsg(232),
    UserSayImage(233),
    UserSkillCooltimeSet(234),

    // CMobPool::OnPacket
    MobEnterField(236),
    MobLeaveField(237),
    MobChangeController(238),

    // CMobPool::OnMobPacket
    MobMove(239),
    MobCtrlAck(240),
    MobStatSet(242),
    MobStatReset(243),
    MobSuspendReset(244),
    MobAffected(245),
    MobDamaged(246),
    MobSpecialEffectBySkill(247),
    MobHPIndicator(250),
    MobCatchEffect(251),
    MobEffectByItem(252),
    MobSpeaking(253),
    MobIncChargeCount(254),
    MobAttackedByMob(255),

    // CNpcPool::OnPacket
    NpcEnterField(257),
    NpcLeaveField(258),
    NpcChangeController(259),

    // CNpcPool::OnNpcPacket
    NpcMove(260),
    NpcUpdateLimitedInfo(261),
    NpcSpecialAction(262),

    // CNpcPool::OnNpcTemplatePacket
    NpcSetScript(263),

    // CEmployeePool::OnPacket
    EmployeeEnterField(265),
    EmployeeLeaveField(266),
    EmployeeMiniRoomBalloon(267),

    // CDropPool::OnPacket
    DropEnterField(268),
    DropLeaveField(269),

    // CMessageBoxPool::OnPacket
    CreateMessgaeBoxFailed(270),
    MessageBoxEnterField(271),
    MessageBoxLeaveField(272),

    // CAffectedAreaPool::OnPacket
    AffectedAreaCreated(273),
    AffectedAreaRemoved(274),

    // CTownPortalPool::OnPacket
    TownPortalCreated(275),
    TownPortalRemoved(276),

    // CReactorPool::OnPacket
    ReactorChangeState(277),
    ReactorEnterField(279),
    ReactorLeaveField(280),

    // CField::OnPacket
    HorntailTimer(302),
    ZakumTimer(303),
    ScriptMessage(304),

    // CShopDlg::OnPacket
    OpenShopDlg(305),
    ShopResult(306),

    // CAdminShopDlg::OnPacket
    AdminShopResult(307),
    AdminShopCommodity(308),

    // CTrunkDlg::OnPacket
    TrunkResult(309),

    // CRPSGameDlg::OnPacket
    RPSGame(312),

    // CUIMessenger::OnPacket
    Messenger(313),

    // CMiniRoomBaseDlg::OnPacketBase
    MiniRoom(314),

    // CParcelDlg::OnPacket
    Parcel(322),

    // CFuncKeyMappedMan::OnPacket
    FuncKeyMappedInit(335),
    PetConsumeItemInit(336),
    PetConsumeMPItemInit(337),

    // CMapleTVMan::OnPacket
    MapleTVUpdateMessage(341),
    MapleTVClearMessage(342),
    MapleTVSendMessageResult(343),

    // CCashShop::OnPacket
    CashShopChargeParamResult(323),
    CashShopQueryCashResult(324),
    CashShopCashItemResult(325),
    CashShopPurchaseExpChanged(326),
    CashShopGiftMateInfoResult(327),
    CashShopCheckDuplicatedIDResult(328),
    CashShopCheckNameChangePossibleResult(329),
    CashShopCheckTransferWorldPossibleResult(331),
    CashShopGachaponStampItemResult(332),
    CashShopCashItemGachaponResult(333),

    NO(433);


    // -----------------------------------------------------------------------------------------------------------------


    private static final List<OutHeader> headers;
    private static final Set<OutHeader> ignoreHeaders = Set.of(
            MobMove,
            MobCtrlAck
//            CharacterInfo,
//            PartyResult,
//            StatChanged,
//            UserMove,
//            PetActivated,
//            PetMove,
//            PetAction,
//            DragonMove,
//            SummonedMove,
//            MobEnterField,
//            MobLeaveField,
//            MobChangeController,
//            MobMove,
//            MobCtrlAck,
//            MobHPIndicator,
//            NpcEnterField,
//            NpcLeaveField,
//            NpcChangeController,
//            NpcMove,
//            DropEnterField,
//            DropLeaveField,
//            ReactorEnterField,
//            ReactorLeaveField,
//            QuickslotMappedInit,
//            FuncKeyMappedInit
    );

    static {
        final List<OutHeader> headerList = new ArrayList<>(Collections.nCopies(NO.getValue() + 1, null));
        for (OutHeader header : values()) {
            headerList.set(header.getValue(), header);
        }
        headers = Collections.unmodifiableList(headerList);
    }

    private final short value;

    OutHeader(int value) {
        this.value = (short) value;
    }

    public final short getValue() {
        return value;
    }

    public final boolean isIgnoreHeader() {
        return ignoreHeaders.contains(this);
    }

    public static OutHeader getByValue(short op) {
        if (op >= 0 && op < NO.getValue()) {
            return headers.get(op);
        }
        return null;
    }
}
