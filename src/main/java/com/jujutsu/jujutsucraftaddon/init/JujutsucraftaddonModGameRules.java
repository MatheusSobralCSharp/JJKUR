
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModGameRules {
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_DIFFICULTY = GameRules.register("jjkuMobDifficulty", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_GOJO_ONLY_SIX_EYES = GameRules.register("jjkuGojoOnlySixEyes", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_HARDCORE_MODE = GameRules.register("jjkuHardcoreMode", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_RATE = GameRules.register("jjkuMobSukunaSpawningRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_GOJO_RATE = GameRules.register("jjkuMobGojoSpawningRate", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_OPEN_FOR_SUKUNA = GameRules.register("jjkuNoOpenForSukuna", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_SPAWN_CHANGER = GameRules.register("jjkuMobSpawnChanger", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_CURSED_SPIRIT_RATE = GameRules.register("jjkuMobCursedSpiritSpawningRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_CURSE_USERS_RATE = GameRules.register("jjkuMobCurseUsersSpawningRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SORCERERS_RATE = GameRules.register("jjkuMobSorcerersSpawningRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_TOJI_RATE = GameRules.register("jjkuMobTojiSpawningRate", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_VANILLA = GameRules.register("jjkuNoVanilla", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_DOMAIN_NERF = GameRules.register("jjkuDomainNerf", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_KENJAKU_LIMIT = GameRules.register("jjkuKenjakuLimit", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_ZONE_STACK = GameRules.register("jjkuBlackFlashZoneStack", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_DROP_RATE = GameRules.register("jjkuItemDropRate", GameRules.Category.DROPS, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_BLACK_FLASH_CUTSCENE = GameRules.register("jjkuBlackFlashCutscene", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_STEVENSON = GameRules.register("jjkuNoStevenson", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_ARMORY_SPIRIT = GameRules.register("jjkuNoArmorySpirit", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_CULLING_GAMES = GameRules.register("jjkuCullingGames", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_RANDOM_CT = GameRules.register("jjkuRandomCTChanger", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_SUKUNA_POSSESSION_ENABLED = GameRules.register("jjkuSukunaPossession", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_OST_PLAYER = GameRules.register("jjkuOstPlayer", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_MOB_OSTS = GameRules.register("jjkuMobOsts", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NPC_FISTS = GameRules.register("jjkuMobFistsEffects", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_LIMB_LOSS = GameRules.register("jjkuLimbLoss", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_AIR_COMBAT = GameRules.register("jjkuAirCombat", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_LIMB_LOSS_SPEED = GameRules.register("jjkuLimbLossSpeed", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_CURSED_SPIRIT_REGEN = GameRules.register("jjkuCursedSpiritRegenRate", GameRules.Category.MOBS, GameRules.IntegerValue.create(0));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_OVERPOWERED_STUFF = GameRules.register("jjkuOverpoweredMangaStuff", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_TAME_SUKUNA = GameRules.register("jjkuCanTameSukuna", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_POSSESSION_RATE = GameRules.register("jjkuSukunaPossessionRate", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_RCT_LIMIT = GameRules.register("jjkuReverseCursedTechniqueLimit", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_TAKABA_REMOVE_ARMOR = GameRules.register("jjkuTakabaRemoveArmor", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_COOLDOWN = GameRules.register("jjkuNoCooldown", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_ZONE_STACK_CAP = GameRules.register("jjkuBlackFlashZoneStackCap", GameRules.Category.MISC, GameRules.IntegerValue.create(100));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_WATER_WALK = GameRules.register("jjkuWaterWalking", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_AUTO_RCT = GameRules.register("jjkuAutoRCT", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_STEAL_GOJO = GameRules.register("jjkuCanStealGojoBody", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_HEALTH_POSSESSION = GameRules.register("jjkuSukunaHealthPossession", GameRules.Category.MISC, GameRules.IntegerValue.create(40));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_MAHORAGA_CAN_ADAPT_EVERYTHING = GameRules.register("jjkuMahoragaCanAdaptEverything", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_HP_CAP = GameRules.register("jjkuHPCap", GameRules.Category.MISC, GameRules.IntegerValue.create(1000));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_RCT_LEVEL_CAP = GameRules.register("jjkuRCTLevelCap", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
    public static final GameRules.Key<GameRules.BooleanValue> ENABLE_SUKUNA_PVP = GameRules.register("jjkuEnableSukunaPVP", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_CAN_SUKUNA_GET_ADVANCEMENTS = GameRules.register("jjkuCanSukunaGetAdvancements", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_PURPLE_RANGE = GameRules.register("jjkuUnlimitedPurpleRange", GameRules.Category.MISC, GameRules.IntegerValue.create(15));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_DESTRUCTION_LEVEL = GameRules.register("jjkuSkillDestructionLevel", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SIX_EYES_LEVEL = GameRules.register("jjkuMultiplierSixEyes", GameRules.Category.MISC, GameRules.IntegerValue.create(5));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SUKUNA_LEVEL = GameRules.register("jjkuMultiplierSukunaCE", GameRules.Category.MISC, GameRules.IntegerValue.create(12));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_TUCA_DONCA = GameRules.register("jjkuPlayTucaDonca", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_YOROZU_SPHERE_LIMIT = GameRules.register("jjkuYorozuSphereSizeLimit", GameRules.Category.MISC, GameRules.IntegerValue.create(30));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_IDLE_TRANSFIGURATION_LEVEL = GameRules.register("jjkuIdleTransfigurationPowerMultiplier", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_BLACK_FLASH_REWORKED = GameRules.register("jjkuBlackFlashReworked", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_RIKA_PURE_LOVE = GameRules.register("jjkuRikaPureLove", GameRules.Category.PLAYER, GameRules.IntegerValue.create(2));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_FATIGUE_RATE = GameRules.register("jjkuReverseCursedTechniqueFatigueRate", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_CURSED_SPIRIT_RCT = GameRules.register("jjkuCursedSpiritRCT", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_HISTORY_MODE = GameRules.register("jjkuHistoryMode", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_CE_CAP = GameRules.register("jjkuCursedEnergyCap", GameRules.Category.MISC, GameRules.IntegerValue.create(2400));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_MOB_SPAWNING_RATE = GameRules.register("jjkuMobSpawningRateJJC", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(1));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_ONLY_ONE_SUKUNA = GameRules.register("jjkuOnlyOneSukunaVessel", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_GOJO_TP = GameRules.register("jjkuGojoTP", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_BF_MASTERY_CAP = GameRules.register("jjkuBlackFlashMasteryCap", GameRules.Category.MISC, GameRules.IntegerValue.create(50));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_DROPS = GameRules.register("jjkuNoDrops", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_NO_POWER_PROGRESS = GameRules.register("jjkuNoPowerProgress", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_WUKONG_BGM = GameRules.register("jjkuWukongBGM", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_SYSTEM_UPGRADE_DIFFICULTY = GameRules.register("jjkuSystemUpgradeDifficulty", GameRules.Category.MISC, GameRules.IntegerValue.create(1));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_AIR_COMBAT_RATE = GameRules.register("jjkuAirCombatChanceRate", GameRules.Category.MISC, GameRules.IntegerValue.create(20));
    public static final GameRules.Key<GameRules.IntegerValue> JJKU_POWER_CAP = GameRules.register("jjkuPowerCap", GameRules.Category.MISC, GameRules.IntegerValue.create(0));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_REGENERATE_SHIKIGAMI = GameRules.register("jjkuRegenerateShikigami", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_BLACK_FLASH_NERF = GameRules.register("jjkuBlackFlashNerf", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_FINGER_RESET = GameRules.register("jjkuFingerReset", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_DISABLE_BINDING_VOWS = GameRules.register("jjkuBindingVows", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
    public static final GameRules.Key<GameRules.BooleanValue> JJKU_EXTRACTOR_ALLOW = GameRules.register("jjkuExtractorAllow", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
}
