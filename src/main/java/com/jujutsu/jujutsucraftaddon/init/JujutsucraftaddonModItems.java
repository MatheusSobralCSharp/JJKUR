
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.item.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftaddonModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, JujutsucraftaddonMod.MODID);
    public static final RegistryObject<Item> EVIDENCE = REGISTRY.register("evidence", () -> new EvidenceItem());
    public static final RegistryObject<Item> SEX_EYES = REGISTRY.register("sex_eyes", () -> new SexEyesItem());
    public static final RegistryObject<Item> WUKONG_STAFF = REGISTRY.register("wukong_staff", () -> new WukongStaffItem());
    public static final RegistryObject<Item> WUKONG_STAFF_TRUE = REGISTRY.register("wukong_staff_true", () -> new WukongStaffTrueItem());
    public static final RegistryObject<Item> WUKONG_SET_CHESTPLATE = REGISTRY.register("wukong_set_chestplate", () -> new WukongSetItem.Chestplate());
    public static final RegistryObject<Item> WUKONG_SET_LEGGINGS = REGISTRY.register("wukong_set_leggings", () -> new WukongSetItem.Leggings());
    public static final RegistryObject<Item> WUKONG_SET_BOOTS = REGISTRY.register("wukong_set_boots", () -> new WukongSetItem.Boots());
    public static final RegistryObject<WukongItem> WUKONG_HAT = REGISTRY.register("wukonghat", () -> new WukongItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RACE_CHANGER = REGISTRY.register("race_changer", () -> new RaceChangerItem());
    public static final RegistryObject<Item> MAKI_PREPARATION_SPAWN_EGG = REGISTRY.register("maki_preparation_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.MAKI_PREPARATION, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> SUKUNA_MANGA_SPAWN_EGG = REGISTRY.register("sukuna_manga_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.SUKUNA_MANGA, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> SUKUNA_NO_SHIRT_SPAWN_EGG = REGISTRY.register("sukuna_no_shirt_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.SUKUNA_NO_SHIRT, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> ITADORI_SHINJUKU_SPAWN_EGG = REGISTRY.register("itadori_shinjuku_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.ITADORI_SHINJUKU, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> YUTA_CULLING_GAMES_SPAWN_EGG = REGISTRY.register("yuta_culling_games_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.YUTA_CULLING_GAMES, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> JUJUTSU_SCHOOL = REGISTRY.register("jujutsu_school", () -> new JujutsuSchoolItem());
    public static final RegistryObject<Item> SWORD_OKKOTSU = REGISTRY.register("sword_okkotsu", () -> new SwordOkkotsuItem());
    public static final RegistryObject<Item> MEDICINE = REGISTRY.register("medicine", () -> new MedicineItem());
    public static final RegistryObject<Item> SWORD_WUKONG = REGISTRY.register("sword_wukong", () -> new SwordWukongItem());
    public static final RegistryObject<Item> GREAT_SWORD_WUKONG = REGISTRY.register("great_sword_wukong", () -> new GreatSwordWukongItem());
    public static final RegistryObject<Item> HAMMER_WUKONG = REGISTRY.register("hammer_wukong", () -> new HammerWukongItem());
    public static final RegistryObject<Item> HALBERD_WUKONG = REGISTRY.register("halberd_wukong", () -> new HalberdWukongItem());
    public static final RegistryObject<Item> WHEEL = REGISTRY.register("wheel", () -> new WheelItem());
    public static final RegistryObject<Item> FINGER = REGISTRY.register("finger", () -> new FingerItem());
    public static final RegistryObject<Item> STEEL_ARM = REGISTRY.register("steel_arm", () -> new SteelArmItem());
    public static final RegistryObject<Item> SWORD_OKKOTSU_TWO = REGISTRY.register("sword_okkotsu_two", () -> new SwordOkkotsuTwoItem());
    public static final RegistryObject<Item> SWORD_OKKOTSU_THREE = REGISTRY.register("sword_okkotsu_three", () -> new SwordOkkotsuThreeItem());
    public static final RegistryObject<Item> WARSTAFF = REGISTRY.register("warstaff", () -> new WarstaffItem());
    public static final RegistryObject<DecisiveItem> DECISIVE_CHESTPLATE = REGISTRY.register("decisive_chestplate", () -> new DecisiveItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<DecisiveItem> DECISIVE_LEGGINGS = REGISTRY.register("decisive_leggings", () -> new DecisiveItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<SukunaCoatItem> SUKUNA_COAT_BLACK = REGISTRY.register("sukunacoatblack_helmet", () -> new SukunaCoatItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<KiryuuOutfitItem> KIRYUU_CHESTPLATE = REGISTRY.register("kiryuu_chestplate", () -> new KiryuuOutfitItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<KiryuuOutfitItem> KIRYUU_LEGGINGS = REGISTRY.register("kiryuu_leggings", () -> new KiryuuOutfitItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SUKUNA_FUSHIGURO_SPAWN_EGG = REGISTRY.register("sukuna_fushiguro_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.SUKUNA_FUSHIGURO, -1, -1, new Item.Properties()));
    public static final RegistryObject<ArmoryItem> ARMORY_CHESTPLATE = REGISTRY.register("armory_chestplate", () -> new ArmoryItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GOJO_TRAINING_1 = REGISTRY.register("gojo_training_1", () -> new GojoTraining1Item());
    public static final RegistryObject<Item> GOJO_TRAINING_2 = REGISTRY.register("gojo_training_2", () -> new GojoTraining2Item());
    public static final RegistryObject<Item> GOJO_TRAINING_3 = REGISTRY.register("gojo_training_3", () -> new GojoTraining3Item());
    public static final RegistryObject<Item> GOJO_TRAINING_FINAL = REGISTRY.register("gojo_training_final", () -> new GojoTrainingFinalItem());
    public static final RegistryObject<Item> ITADORI_ARMS = REGISTRY.register("itadori_arms", () -> new ItadoriArmsItem());
    public static final RegistryObject<Item> GEGE_AKUTAMI_SPAWN_EGG = REGISTRY.register("gege_akutami_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.GEGE_AKUTAMI, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> SIMPLE_DOMAIN = REGISTRY.register("simple_domain", () -> new SimpleDomainItem());
    public static final RegistryObject<Item> CURSED_FIST = REGISTRY.register("cursed_fist", () -> new CursedFistItem());
    public static final RegistryObject<Item> CLAN_CHANGER = REGISTRY.register("clan_changer", () -> new ClanChangerItem());
    public static final RegistryObject<Item> SHOKO_IERI_SCHOOL_SPAWN_EGG = REGISTRY.register("shoko_ieri_school_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.SHOKO_IERI_SCHOOL, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> SHOKO = REGISTRY.register("shoko", () -> new ShokoItem());
    public static final RegistryObject<Item> GOJO_MANGA_SPAWN_EGG = REGISTRY.register("gojo_manga_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.GOJO_MANGA, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> RIKO_AMANAI_SPAWN_EGG = REGISTRY.register("riko_amanai_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.RIKO_AMANAI, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> KOKUSEN = REGISTRY.register("kokusen", () -> new KokusenItem());
    public static final RegistryObject<DecisiveBlackItem> DECISIVE_BLACK_CHESTPLATE = REGISTRY.register("decisive_black_chestplate", () -> new DecisiveBlackItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<DecisiveBlackItem> DECISIVE_BLACK_LEGGINGS = REGISTRY.register("decisive_black_leggings", () -> new DecisiveBlackItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<SungJinWooItem> SUNG_JIN_WOO_CHESTPLATE = REGISTRY.register("sung_jin_woo_chestplate", () -> new SungJinWooItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<SungJinWooItem> SUNG_JIN_WOO_LEGGINGS = REGISTRY.register("sung_jin_woo_leggings", () -> new SungJinWooItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SWORD_JIN_WOO = REGISTRY.register("sword_jin_woo", () -> new SwordJinWooItem());
    public static final RegistryObject<Item> SWORD_JIN_WOO_TWO = REGISTRY.register("sword_jin_woo_two", () -> new SwordJinWooTwoItem());
    public static final RegistryObject<Item> TANJERINA_SPAWN_EGG = REGISTRY.register("tanjerina_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.TANJERINA, -1, -1, new Item.Properties()));
    public static final RegistryObject<WhiteCapeItem> WHITE_CAPE_CHESTPLATE = REGISTRY.register("white_cape_chestplate", () -> new WhiteCapeItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<WhiteCapeItem> WHITE_CAPE_LEGGINGS = REGISTRY.register("white_cape_leggings", () -> new WhiteCapeItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<RedCapeItem> RED_CAPE_CHESTPLATE = REGISTRY.register("red_cape_chestplate", () -> new RedCapeItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<RedCapeItem> RED_CAPE_LEGGINGS = REGISTRY.register("red_cape_leggings", () -> new RedCapeItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<PurpleCapeItem> PURPLE_CAPE_CHESTPLATE = REGISTRY.register("purple_cape_chestplate", () -> new PurpleCapeItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<PurpleCapeItem> PURPLE_CAPE_LEGGINGS = REGISTRY.register("purple_cape_leggings", () -> new PurpleCapeItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<KimonoBlackItem> KIMONO_BLACK_CHESTPLATE = REGISTRY.register("kimono_black_chestplate", () -> new KimonoBlackItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<KimonoBlackItem> KIMONO_BLACK_LEGGINGS = REGISTRY.register("kimono_black_leggings", () -> new KimonoBlackItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SIMPLE_DOMAIN_SCROLL = REGISTRY.register("simple_domain_scroll", () -> new SimpleDomainScrollItem());
    public static final RegistryObject<Item> HEALTH_SCROLL = REGISTRY.register("health_scroll", () -> new HealthScrollItem());
    public static final RegistryObject<Item> MASTERY_SIMPLE_DOMAIN_ITEM = REGISTRY.register("mastery_simple_domain_item", () -> new MasterySimpleDomainItemItem());
    public static final RegistryObject<Item> KOKUSEN_SCROLL = REGISTRY.register("kokusen_scroll", () -> new KokusenScrollItem());
    public static final RegistryObject<KimonoWhiteItem> KIMONO_WHITE_CHESTPLATE = REGISTRY.register("kimono_white_chestplate", () -> new KimonoWhiteItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<KimonoWhiteItem> KIMONO_WHITE_LEGGINGS = REGISTRY.register("kimono_white_leggings", () -> new KimonoWhiteItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CLEAVE_WEBB = REGISTRY.register("cleave_webb", () -> new CleaveWebbItem());
    public static final RegistryObject<Item> RCT = REGISTRY.register("rct", () -> new RCTItem());
    public static final RegistryObject<Item> BARRIERLESSSYMBOL = REGISTRY.register("barrierlesssymbol", () -> new BarrierlesssymbolItem());
    public static final RegistryObject<Item> EXTENSION_TECHNIQUE_SYMBOL = REGISTRY.register("extension_technique_symbol", () -> new ExtensionTechniqueSymbolItem());
    public static final RegistryObject<Item> CELLPHONE = REGISTRY.register("cellphone", () -> new CellphoneItem());
    public static final RegistryObject<Item> SPECIAL_GRADE_1 = REGISTRY.register("special_grade_1", () -> new SpecialGrade1Item());
    public static final RegistryObject<Item> SPEICAL_GRADE_2 = REGISTRY.register("speical_grade_2", () -> new SpeicalGrade2Item());
    public static final RegistryObject<Item> SPECIAL_GRADE_3 = REGISTRY.register("special_grade_3", () -> new SpecialGrade3Item());
    public static final RegistryObject<Item> SPECIAL_GRADE_4 = REGISTRY.register("special_grade_4", () -> new SpecialGrade4Item());
    public static final RegistryObject<Item> SPECIAL_GRADE_5 = REGISTRY.register("special_grade_5", () -> new SpecialGrade5Item());
    public static final RegistryObject<Item> REVERSE_LEVEL_SCROLL = REGISTRY.register("reverse_level_scroll", () -> new ReverseLevelScrollItem());
    public static final RegistryObject<Item> CURSED_POWER_LEVEL_SCROLL = REGISTRY.register("cursed_power_level_scroll", () -> new CursedPowerLevelScrollItem());
    public static final RegistryObject<Item> CHANTS = REGISTRY.register("chants", () -> new ChantsItem());
    public static final RegistryObject<Item> SUKUNA_ARMOR_HELMET = REGISTRY.register("sukuna_armor_helmet", () -> new SukunaArmorItem.Helmet());
    public static final RegistryObject<Item> SUKUNA_ARMOR_CHESTPLATE = REGISTRY.register("sukuna_armor_chestplate", () -> new SukunaArmorItem.Chestplate());
    public static final RegistryObject<Item> SUKUNA_ARMOR_TWO_HELMET = REGISTRY.register("sukuna_armor_two_helmet", () -> new SukunaArmorTwoItem.Helmet());
    public static final RegistryObject<Item> SUKUNA_ARMOR_TWO_CHESTPLATE = REGISTRY.register("sukuna_armor_two_chestplate", () -> new SukunaArmorTwoItem.Chestplate());
    public static final RegistryObject<Item> SUKUNA_ARMOR_THREE_HELMET = REGISTRY.register("sukuna_armor_three_helmet", () -> new SukunaArmorThreeItem.Helmet());
    public static final RegistryObject<Item> SUKUNA_ARMOR_THREE_CHESTPLATE = REGISTRY.register("sukuna_armor_three_chestplate", () -> new SukunaArmorThreeItem.Chestplate());
    public static final RegistryObject<Item> KENJAKU_ARMOR_HELMET = REGISTRY.register("kenjaku_armor_helmet", () -> new KenjakuArmorItem.Helmet());
    public static final RegistryObject<Item> SWORD_DETECT = REGISTRY.register("sword_detect", () -> new SwordDetectItem());
    public static final RegistryObject<Item> SUKUNAA = REGISTRY.register("sukunaa", () -> new SukunaaItem());
    public static final RegistryObject<Item> HIGH_SPEED = REGISTRY.register("high_speed", () -> new HighSpeedItem());
    public static final RegistryObject<Item> UI_UI_SPAWN_EGG = REGISTRY.register("ui_ui_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.UI_UI, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> S_OULBOOK = REGISTRY.register("s_oulbook", () -> new SOulbookItem());
    public static final RegistryObject<Item> ITADORI_DRINK = REGISTRY.register("itadori_drink", () -> new ItadoriDrinkItem());
    public static final RegistryObject<Item> ITADORI_DRINKS = REGISTRY.register("itadori_drinks", () -> new ItadoriDrinksItem());
    public static final RegistryObject<Item> HISTORY_BOOK = REGISTRY.register("history_book", () -> new HistoryBookItem());
    public static final RegistryObject<Item> BULLET = REGISTRY.register("bullet", () -> new BulletItem());
    public static final RegistryObject<Item> KENJAKU_BALL = REGISTRY.register("kenjaku_ball", () -> new KenjakuBallItem());
    public static final RegistryObject<Item> ENCHAINDE = REGISTRY.register("enchainde", () -> new EnchaindeItem());
    public static final RegistryObject<Item> RANDOM_CT_CHANGER = REGISTRY.register("random_ct_changer", () -> new RandomCTChangerItem());
    public static final RegistryObject<Item> SPECIAL_GRADE_1_RECOMMENDATION = REGISTRY.register("special_grade_1_recommendation", () -> new SpecialGrade1RecommendationItem());
    public static final RegistryObject<Item> FAMOUS_GRADE_RECOMMENDATION = REGISTRY.register("famous_grade_recommendation", () -> new FamousGradeRecommendationItem());
    public static final RegistryObject<Item> STRONGEST_OF_HISTORY_RECOMMENDATION = REGISTRY.register("strongest_of_history_recommendation", () -> new StrongestOfHistoryRecommendationItem());
    public static final RegistryObject<Item> MODERN_ERA_SORCERER = REGISTRY.register("modern_era_sorcerer", () -> new ModernEraSorcererItem());
    public static final RegistryObject<Item> DISPLAY_SKILL = REGISTRY.register("display_skill", () -> new DisplaySkillItem());
    public static final RegistryObject<Item> RED_ENTITY_SPAWN_EGG = REGISTRY.register("red_entity_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.RED_ENTITY, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> BLUE_ENTITY_SPAWN_EGG = REGISTRY.register("blue_entity_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.BLUE_ENTITY, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> JUJUTSU_COIN = REGISTRY.register("jujutsu_coin", () -> new JujutsuCoinItem());
    public static final RegistryObject<Item> INUMAKIII = REGISTRY.register("inumakiii", () -> new InumakiiiItem());
    public static final RegistryObject<Item> JACKPOTO = REGISTRY.register("jackpoto", () -> new JackpotoItem());
    public static final RegistryObject<Item> INUMAKI_ARMOR_HELMET = REGISTRY.register("inumaki_armor_helmet", () -> new InumakiArmorItem.Helmet());
    public static final RegistryObject<Item> TRASH = REGISTRY.register("trash", () -> new TrashItem());
    public static final RegistryObject<Item> ANGEL = REGISTRY.register("angel", () -> new AngelItem());
    public static final RegistryObject<Item> TEST = REGISTRY.register("test", () -> new TestItem());
    public static final RegistryObject<Item> TESTO_2 = REGISTRY.register("testo_2", () -> new Testo2Item());
    public static final RegistryObject<Item> TESTO_3 = REGISTRY.register("testo_3", () -> new Testo3Item());
    public static final RegistryObject<Item> SWORD_KUSAKABE = REGISTRY.register("sword_kusakabe", () -> new SwordKusakabeItem());
    public static final RegistryObject<Item> NO_DOMAIN = block(JujutsucraftaddonModBlocks.NO_DOMAIN);
    public static final RegistryObject<Item> IRONKK_SPAWN_EGG = REGISTRY.register("ironkk_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.IRONKK, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> HUSSEIN_DONG_SPAWN_EGG = REGISTRY.register("hussein_dong_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.HUSSEIN_DONG, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> GOJO_SCHOOL_SPAWN_EGG = REGISTRY.register("gojo_school_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.GOJO_SCHOOL, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> HAKARI_SPAWN_EGG = REGISTRY.register("hakari_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.HAKARI, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> ANGELL_SPAWN_EGG = REGISTRY.register("angell_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.ANGELL, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> KASHIMO_FEMBOY_SPAWN_EGG = REGISTRY.register("kashimo_femboy_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.KASHIMO_FEMBOY, -1, -1, new Item.Properties()));
    public static final RegistryObject<MugiwaraItem> MUGIWARA_HELMET = REGISTRY.register("mugiwara_helmet", () -> new MugiwaraItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ER = REGISTRY.register("er", () -> new ErItem());
    public static final RegistryObject<GojoItem> GOJO_CHESTPLATE = REGISTRY.register("gojo_chestplate", () -> new GojoItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> URAUME_SPAWN_EGG = REGISTRY.register("uraume_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.URAUME, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> ADJUCHA_SPAWN_EGG = REGISTRY.register("adjucha_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.ADJUCHA, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_EDGE = REGISTRY.register("blood_edge", () -> new BloodEdgeItem());
    public static final RegistryObject<Item> CURSED_WOMB = REGISTRY.register("cursed_womb", () -> new CursedWombItem());
    public static final RegistryObject<Item> VIBRASLAP = REGISTRY.register("vibraslap", () -> new VibraslapItem());
    public static final RegistryObject<Item> VEIL_BLOCK = block(JujutsucraftaddonModBlocks.VEIL_BLOCK);
    public static final RegistryObject<Item> KOGANE_POINTS = REGISTRY.register("kogane_points", () -> new KoganePointsItem());
    public static final RegistryObject<Item> TENGEN = REGISTRY.register("tengen", () -> new TengenItem());
    public static final RegistryObject<Item> JJKU_CHECK_1 = REGISTRY.register("jjku_check_1", () -> new JjkuCheck1Item());
    public static final RegistryObject<Item> TRAIT_RECOMMENDATION = REGISTRY.register("trait_recommendation", () -> new TraitRecommendationItem());
    public static final RegistryObject<Item> JJKU_CHECKMARK_2 = REGISTRY.register("jjku_checkmark_2", () -> new JJKUCheckmark2Item());
    public static final RegistryObject<Item> MOB_TAMER = REGISTRY.register("mob_tamer", () -> new MobTamerItem());
    public static final RegistryObject<Item> JJKU = REGISTRY.register("jjku", () -> new JJKUItem());
    public static final RegistryObject<Item> SATUSHI_SPAWN_EGG = REGISTRY.register("satushi_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.SATUSHI, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> YUTA_RING = REGISTRY.register("yuta_ring", () -> new YutaRingItem());
    public static final RegistryObject<Item> TESTING_ITEM = REGISTRY.register("testing_item", () -> new TestingItemItem());
    public static final RegistryObject<Item> ITEM_TEST_2 = REGISTRY.register("item_test_2", () -> new ItemTest2Item());
    public static final RegistryObject<Item> VEIL_TALISMAN = REGISTRY.register("veil_talisman", () -> new VeilTalismanItem());
    public static final RegistryObject<Item> ANTI_VEIL_SPAWN_EGG = REGISTRY.register("anti_veil_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.ANTI_VEIL, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> ITEMMM_CHCEK = REGISTRY.register("itemmm_chcek", () -> new ItemmmChcekItem());
    public static final RegistryObject<Item> TEST_ITEM_1 = REGISTRY.register("test_item_1", () -> new TestItem1Item());
    public static final RegistryObject<Item> TEST_ITEM_2 = REGISTRY.register("test_item_2", () -> new TestItem2Item());
    public static final RegistryObject<Item> ANOTHER_ITE_MF_O_RC_CHECK = REGISTRY.register("another_ite_mf_o_rc_check", () -> new AnotherITEMfORcCheckItem());
    public static final RegistryObject<Item> DISPLAY_DOMAIN = REGISTRY.register("display_domain", () -> new DisplayDomainItem());
    public static final RegistryObject<Item> DISPLAY_CT_NUMBER = REGISTRY.register("display_ct_number", () -> new DisplayCTNumberItem());
    public static final RegistryObject<Item> YUUN = REGISTRY.register("yuun", () -> new YuunItem());
    public static final RegistryObject<Item> ITEM_DOMAIN_SIZE_SET = REGISTRY.register("item_domain_size_set", () -> new ItemDomainSizeSetItem());
    public static final RegistryObject<Item> NUH_UH = REGISTRY.register("nuh_uh", () -> new NuhUhItem());
    public static final RegistryObject<Item> TESTING_ENTITY_SPAWN_EGG = REGISTRY.register("testing_entity_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.TESTING_ENTITY, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> TROLOLOLO = REGISTRY.register("trolololo", () -> new TrolololoItem());
    public static final RegistryObject<Item> TESTING_VERSION_SPAWN_EGG = REGISTRY.register("testing_version_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.TESTING_VERSION, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> YES_I_AM = REGISTRY.register("yes_i_am", () -> new YesIAmItem());
    public static final RegistryObject<Item> NUH_UH_1 = REGISTRY.register("nuh_uh_1", () -> new NuhUh1Item());
    public static final RegistryObject<Item> YE_SPAWN_EGG = REGISTRY.register("ye_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.YE, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> PROFESSION = REGISTRY.register("profession", () -> new ProfessionItem());
    public static final RegistryObject<Item> ELEMENT_REST = REGISTRY.register("element_rest", () -> new ElementRestItem());
    public static final RegistryObject<Item> CLONER = REGISTRY.register("cloner", () -> new ClonerItem());
    public static final RegistryObject<Item> YOKU_BUCKET = REGISTRY.register("yoku_bucket", () -> new YokuItem());
    public static final RegistryObject<Item> FAKE_CLONES_SPAWN_EGG = REGISTRY.register("fake_clones_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.FAKE_CLONES, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> CLONE_SPAWN_EGG = REGISTRY.register("clone_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.CLONE, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> KYOKA = REGISTRY.register("kyoka", () -> new KyokaItem());
    public static final RegistryObject<Item> SNOW_DOMAIN = block(JujutsucraftaddonModBlocks.SNOW_DOMAIN);
    public static final RegistryObject<Item> NOZARASHI = REGISTRY.register("nozarashi", () -> new NozarashiItem());
    public static final RegistryObject<Item> NOZARASHI_SHIKAI = REGISTRY.register("nozarashi_shikai", () -> new NozarashiShikaiItem());
    public static final RegistryObject<Item> NOZARASHI_BANKAI = REGISTRY.register("nozarashi_bankai", () -> new NozarashiBankaiItem());
    public static final RegistryObject<Item> YAMATO = REGISTRY.register("yamato", () -> new YamatoItem());
    public static final RegistryObject<Item> YAMATO_2 = REGISTRY.register("yamato_2", () -> new Yamato2Item());
    public static final RegistryObject<Item> YAMATO_3 = REGISTRY.register("yamato_3", () -> new Yamato3Item());
    public static final RegistryObject<Item> TAGGING = REGISTRY.register("tagging", () -> new TaggingItem());
    public static final RegistryObject<VergilItem> VERGIL_CHESTPLATE = REGISTRY.register("vergil_chestplate", () -> new VergilItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<SukunaRobeItem> SUKUNA_ROBE_HELMET = REGISTRY.register("sukuna_robe_helmet", () -> new SukunaRobeItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<SukunaRobeItem> SUKUNA_ROBE_CHESTPLATE = REGISTRY.register("sukuna_robe_chestplate", () -> new SukunaRobeItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<SukunaRobeItem> SUKUNA_ROBE_LEGGINGS = REGISTRY.register("sukuna_robe_leggings", () -> new SukunaRobeItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<SukunaRobeItem> SUKUNA_ROBE_BOOTS = REGISTRY.register("sukuna_robe_boots", () -> new SukunaRobeItem(ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> ARTIFACT = REGISTRY.register("artifact", () -> new ArtifactItem());
    public static final RegistryObject<Item> ARTIFACT_2 = REGISTRY.register("artifact_2", () -> new Artifact2Item());
    public static final RegistryObject<Item> CURTAIN_BLOCK = block(JujutsucraftaddonModBlocks.CURTAIN_BLOCK);
    public static final RegistryObject<Item> YIN_YANG = REGISTRY.register("yin_yang", () -> new YinYangItem());
    public static final RegistryObject<Item> ARTIFACT_3 = REGISTRY.register("artifact_3", () -> new Artifact3Item());
    public static final RegistryObject<Item> ARTIFACT_4 = REGISTRY.register("artifact_4", () -> new Artifact4Item());
    public static final RegistryObject<Item> ARTIFACT_5 = REGISTRY.register("artifact_5", () -> new Artifact5Item());
    public static final RegistryObject<Item> MAKI_PREPARATION_2_SPAWN_EGG = REGISTRY.register("maki_preparation_2_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.MAKI_PREPARATION_2, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> ERRO_SPAWN_EGG = REGISTRY.register("erro_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.ERRO, -1, -1, new Item.Properties()));
    public static final RegistryObject<Item> CHOSO_ARMS = REGISTRY.register("choso_arms", () -> new ChosoArmsItem());
    public static final RegistryObject<Item> CHOSO_ARMOR_HELMET = REGISTRY.register("choso_armor_helmet", () -> new ChosoArmorItem.Helmet());
    public static final RegistryObject<Item> ERROR_SPAWN_EGG = REGISTRY.register("error_spawn_egg", () -> new ForgeSpawnEggItem(JujutsucraftaddonModEntities.ERROR, -1, -1, new Item.Properties()));

    // Start of user code block custom items
    // End of user code block custom items
    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
