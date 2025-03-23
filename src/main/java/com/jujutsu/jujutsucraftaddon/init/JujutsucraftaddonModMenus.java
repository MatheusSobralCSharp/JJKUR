
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.world.inventory.*;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JujutsucraftaddonModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, JujutsucraftaddonMod.MODID);
    public static final RegistryObject<MenuType<EvidenceGUIMenu>> EVIDENCE_GUI = REGISTRY.register("evidence_gui", () -> IForgeMenuType.create(EvidenceGUIMenu::new));
    public static final RegistryObject<MenuType<RaceChangeMenu>> RACE_CHANGE = REGISTRY.register("race_change", () -> IForgeMenuType.create(RaceChangeMenu::new));
    public static final RegistryObject<MenuType<YutaStorageMenu>> YUTA_STORAGE = REGISTRY.register("yuta_storage", () -> IForgeMenuType.create(YutaStorageMenu::new));
    public static final RegistryObject<MenuType<AltarMenu>> ALTAR = REGISTRY.register("altar", () -> IForgeMenuType.create(AltarMenu::new));
    public static final RegistryObject<MenuType<StorageArmoryMenu>> STORAGE_ARMORY = REGISTRY.register("storage_armory", () -> IForgeMenuType.create(StorageArmoryMenu::new));
    public static final RegistryObject<MenuType<ClanChangeMenu>> CLAN_CHANGE = REGISTRY.register("clan_change", () -> IForgeMenuType.create(ClanChangeMenu::new));
    public static final RegistryObject<MenuType<TestrMenu>> TESTR = REGISTRY.register("testr", () -> IForgeMenuType.create(TestrMenu::new));
    public static final RegistryObject<MenuType<WorldSkillMenu>> WORLD_SKILL = REGISTRY.register("world_skill", () -> IForgeMenuType.create(WorldSkillMenu::new));
    public static final RegistryObject<MenuType<CTChangerMenu>> CT_CHANGER = REGISTRY.register("ct_changer", () -> IForgeMenuType.create(CTChangerMenu::new));
    public static final RegistryObject<MenuType<KenjakuBodySwapMenu>> KENJAKU_BODY_SWAP = REGISTRY.register("kenjaku_body_swap", () -> IForgeMenuType.create(KenjakuBodySwapMenu::new));
    public static final RegistryObject<MenuType<KoganeUIMenu>> KOGANE_UI = REGISTRY.register("kogane_ui", () -> IForgeMenuType.create(KoganeUIMenu::new));
    public static final RegistryObject<MenuType<CursedEnergySelectorMenu>> CURSED_ENERGY_SELECTOR = REGISTRY.register("cursed_energy_selector", () -> IForgeMenuType.create(CursedEnergySelectorMenu::new));
    public static final RegistryObject<MenuType<ProfessionGUIMenu>> PROFESSION_GUI = REGISTRY.register("profession_gui", () -> IForgeMenuType.create(ProfessionGUIMenu::new));
    public static final RegistryObject<MenuType<ElementsMenu>> ELEMENTS = REGISTRY.register("elements", () -> IForgeMenuType.create(ElementsMenu::new));
    public static final RegistryObject<MenuType<SkillTreeMenu>> SKILL_TREE = REGISTRY.register("skill_tree", () -> IForgeMenuType.create(SkillTreeMenu::new));
    public static final RegistryObject<MenuType<Quest1Menu>> QUEST_1 = REGISTRY.register("quest_1", () -> IForgeMenuType.create(Quest1Menu::new));
    public static final RegistryObject<MenuType<Quest2Menu>> QUEST_2 = REGISTRY.register("quest_2", () -> IForgeMenuType.create(Quest2Menu::new));
    public static final RegistryObject<MenuType<Quest3Menu>> QUEST_3 = REGISTRY.register("quest_3", () -> IForgeMenuType.create(Quest3Menu::new));
    public static final RegistryObject<MenuType<Quest4Menu>> QUEST_4 = REGISTRY.register("quest_4", () -> IForgeMenuType.create(Quest4Menu::new));
    public static final RegistryObject<MenuType<Quest5Menu>> QUEST_5 = REGISTRY.register("quest_5", () -> IForgeMenuType.create(Quest5Menu::new));
    public static final RegistryObject<MenuType<Quest6Menu>> QUEST_6 = REGISTRY.register("quest_6", () -> IForgeMenuType.create(Quest6Menu::new));
    public static final RegistryObject<MenuType<Quest7Menu>> QUEST_7 = REGISTRY.register("quest_7", () -> IForgeMenuType.create(Quest7Menu::new));
    public static final RegistryObject<MenuType<Quest8Menu>> QUEST_8 = REGISTRY.register("quest_8", () -> IForgeMenuType.create(Quest8Menu::new));
    public static final RegistryObject<MenuType<Quest9Menu>> QUEST_9 = REGISTRY.register("quest_9", () -> IForgeMenuType.create(Quest9Menu::new));
    public static final RegistryObject<MenuType<Quest10Menu>> QUEST_10 = REGISTRY.register("quest_10", () -> IForgeMenuType.create(Quest10Menu::new));
    public static final RegistryObject<MenuType<Quest11Menu>> QUEST_11 = REGISTRY.register("quest_11", () -> IForgeMenuType.create(Quest11Menu::new));
    public static final RegistryObject<MenuType<Quest12Menu>> QUEST_12 = REGISTRY.register("quest_12", () -> IForgeMenuType.create(Quest12Menu::new));
    public static final RegistryObject<MenuType<Quest13Menu>> QUEST_13 = REGISTRY.register("quest_13", () -> IForgeMenuType.create(Quest13Menu::new));
    public static final RegistryObject<MenuType<Quest14Menu>> QUEST_14 = REGISTRY.register("quest_14", () -> IForgeMenuType.create(Quest14Menu::new));
    public static final RegistryObject<MenuType<SkillTreeSPMenu>> SKILL_TREE_SP = REGISTRY.register("skill_tree_sp", () -> IForgeMenuType.create(SkillTreeSPMenu::new));
    public static final RegistryObject<MenuType<GojoTrainMenu>> GOJO_TRAIN = REGISTRY.register("gojo_train", () -> IForgeMenuType.create(GojoTrainMenu::new));
    public static final RegistryObject<MenuType<StoryModeGojo1Menu>> STORY_MODE_GOJO_1 = REGISTRY.register("story_mode_gojo_1", () -> IForgeMenuType.create(StoryModeGojo1Menu::new));
    public static final RegistryObject<MenuType<StoryModeGojo2Menu>> STORY_MODE_GOJO_2 = REGISTRY.register("story_mode_gojo_2", () -> IForgeMenuType.create(StoryModeGojo2Menu::new));
    public static final RegistryObject<MenuType<StoryModeGojo3Menu>> STORY_MODE_GOJO_3 = REGISTRY.register("story_mode_gojo_3", () -> IForgeMenuType.create(StoryModeGojo3Menu::new));
    public static final RegistryObject<MenuType<StoryModeGojo4Menu>> STORY_MODE_GOJO_4 = REGISTRY.register("story_mode_gojo_4", () -> IForgeMenuType.create(StoryModeGojo4Menu::new));
    public static final RegistryObject<MenuType<StoryModeGojo6Menu>> STORY_MODE_GOJO_6 = REGISTRY.register("story_mode_gojo_6", () -> IForgeMenuType.create(StoryModeGojo6Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna1Menu>> STORY_MODE_SUKUNA_1 = REGISTRY.register("story_mode_sukuna_1", () -> IForgeMenuType.create(StoryModeSukuna1Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna2Menu>> STORY_MODE_SUKUNA_2 = REGISTRY.register("story_mode_sukuna_2", () -> IForgeMenuType.create(StoryModeSukuna2Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna3Menu>> STORY_MODE_SUKUNA_3 = REGISTRY.register("story_mode_sukuna_3", () -> IForgeMenuType.create(StoryModeSukuna3Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna4Menu>> STORY_MODE_SUKUNA_4 = REGISTRY.register("story_mode_sukuna_4", () -> IForgeMenuType.create(StoryModeSukuna4Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna5Menu>> STORY_MODE_SUKUNA_5 = REGISTRY.register("story_mode_sukuna_5", () -> IForgeMenuType.create(StoryModeSukuna5Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna6Menu>> STORY_MODE_SUKUNA_6 = REGISTRY.register("story_mode_sukuna_6", () -> IForgeMenuType.create(StoryModeSukuna6Menu::new));
    public static final RegistryObject<MenuType<StoryModeSukuna7Menu>> STORY_MODE_SUKUNA_7 = REGISTRY.register("story_mode_sukuna_7", () -> IForgeMenuType.create(StoryModeSukuna7Menu::new));
    public static final RegistryObject<MenuType<EnchantYorozuMenu>> ENCHANT_YOROZU = REGISTRY.register("enchant_yorozu", () -> IForgeMenuType.create(EnchantYorozuMenu::new));
    public static final RegistryObject<MenuType<NewTabMenu>> NEW_TAB = REGISTRY.register("new_tab", () -> IForgeMenuType.create(NewTabMenu::new));
}
