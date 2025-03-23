
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JujutsucraftaddonMod.MODID);
    public static final RegistryObject<CreativeModeTab> JUJUTSU_ADDON = REGISTRY.register("jujutsu_addon",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.jujutsu_addon")).icon(() -> new ItemStack(JujutsucraftaddonModItems.EVIDENCE.get())).displayItems((parameters, tabData) -> {
                tabData.accept(JujutsucraftaddonModItems.CELLPHONE.get());
                tabData.accept(JujutsucraftaddonModItems.ITADORI_DRINKS.get());
                tabData.accept(JujutsucraftaddonModBlocks.NO_DOMAIN.get().asItem());
                tabData.accept(JujutsucraftaddonModItems.VIBRASLAP.get());
                tabData.accept(JujutsucraftaddonModBlocks.VEIL_BLOCK.get().asItem());
                tabData.accept(JujutsucraftaddonModItems.KOGANE_POINTS.get());
                tabData.accept(JujutsucraftaddonModItems.MOB_TAMER.get());
                tabData.accept(JujutsucraftaddonModItems.VEIL_TALISMAN.get());
                tabData.accept(JujutsucraftaddonModItems.ITEM_DOMAIN_SIZE_SET.get());
                tabData.accept(JujutsucraftaddonModItems.NUH_UH_1.get());
                tabData.accept(JujutsucraftaddonModBlocks.SNOW_DOMAIN.get().asItem());
                tabData.accept(JujutsucraftaddonModItems.TAGGING.get());
                tabData.accept(JujutsucraftaddonModBlocks.CURTAIN_BLOCK.get().asItem());
            }).build());
    public static final RegistryObject<CreativeModeTab> JUJUTSU_ADDON_CREATURES = REGISTRY.register("jujutsu_addon_creatures",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.jujutsu_addon_creatures")).icon(() -> new ItemStack(Items.PANDA_SPAWN_EGG)).displayItems((parameters, tabData) -> {
                tabData.accept(JujutsucraftaddonModItems.MAKI_PREPARATION_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_MANGA_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_NO_SHIRT_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.ITADORI_SHINJUKU_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.YUTA_CULLING_GAMES_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_FUSHIGURO_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.GEGE_AKUTAMI_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.SHOKO_IERI_SCHOOL_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.GOJO_MANGA_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.RIKO_AMANAI_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.TANJERINA_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.UI_UI_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.IRONKK_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.HUSSEIN_DONG_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.GOJO_SCHOOL_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.HAKARI_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.ANGELL_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.KASHIMO_FEMBOY_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.URAUME_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.ADJUCHA_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.SATUSHI_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.ANTI_VEIL_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.FAKE_CLONES_SPAWN_EGG.get());
                tabData.accept(JujutsucraftaddonModItems.MAKI_PREPARATION_2_SPAWN_EGG.get());
            }).withTabsBefore(JUJUTSU_ADDON.getId()).build());
    public static final RegistryObject<CreativeModeTab> WEAPONS = REGISTRY.register("weapons",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.weapons")).icon(() -> new ItemStack(JujutsucraftaddonModItems.ARMORY_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
                tabData.accept(JujutsucraftaddonModItems.WUKONG_STAFF_TRUE.get());
                tabData.accept(JujutsucraftaddonModItems.SWORD_OKKOTSU.get());
                tabData.accept(JujutsucraftaddonModItems.SWORD_OKKOTSU_TWO.get());
                tabData.accept(JujutsucraftaddonModItems.SWORD_OKKOTSU_THREE.get());
                tabData.accept(JujutsucraftaddonModItems.WARSTAFF.get());
                tabData.accept(JujutsucraftaddonModItems.ITADORI_ARMS.get());
                tabData.accept(JujutsucraftaddonModItems.SWORD_JIN_WOO.get());
                tabData.accept(JujutsucraftaddonModItems.SWORD_JIN_WOO_TWO.get());
                tabData.accept(JujutsucraftaddonModItems.BULLET.get());
                tabData.accept(JujutsucraftaddonModItems.SWORD_KUSAKABE.get());
                tabData.accept(JujutsucraftaddonModItems.BLOOD_EDGE.get());
                tabData.accept(JujutsucraftaddonModItems.STEEL_ARM.get());
                tabData.accept(JujutsucraftaddonModItems.YUUN.get());
                tabData.accept(JujutsucraftaddonModItems.WUKONG_STAFF.get());
                tabData.accept(JujutsucraftaddonModItems.KYOKA.get());
                tabData.accept(JujutsucraftaddonModItems.NOZARASHI.get());
                tabData.accept(JujutsucraftaddonModItems.NOZARASHI_SHIKAI.get());
                tabData.accept(JujutsucraftaddonModItems.NOZARASHI_BANKAI.get());
                tabData.accept(JujutsucraftaddonModItems.YAMATO.get());
                tabData.accept(JujutsucraftaddonModItems.YAMATO_2.get());
                tabData.accept(JujutsucraftaddonModItems.YAMATO_3.get());
                tabData.accept(JujutsucraftaddonModItems.CHOSO_ARMS.get());
            }).withTabsBefore(JUJUTSU_ADDON_CREATURES.getId()).build());
    public static final RegistryObject<CreativeModeTab> ARMORS = REGISTRY.register("armors",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.armors")).icon(() -> new ItemStack(JujutsucraftaddonModItems.GOJO_TRAINING_FINAL.get())).displayItems((parameters, tabData) -> {
                tabData.accept(JujutsucraftaddonModItems.KIRYUU_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.KIRYUU_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_COAT_BLACK.get());
                tabData.accept(JujutsucraftaddonModItems.WUKONG_HAT.get());
                tabData.accept(JujutsucraftaddonModItems.WUKONG_SET_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.WUKONG_SET_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.WUKONG_SET_BOOTS.get());
                tabData.accept(JujutsucraftaddonModItems.DECISIVE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.DECISIVE_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.DECISIVE_BLACK_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.DECISIVE_BLACK_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.SUNG_JIN_WOO_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.SUNG_JIN_WOO_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.WHITE_CAPE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.WHITE_CAPE_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.RED_CAPE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.RED_CAPE_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.PURPLE_CAPE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.PURPLE_CAPE_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.KIMONO_BLACK_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.KIMONO_BLACK_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.KIMONO_WHITE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.KIMONO_WHITE_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_TWO_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_TWO_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.KENJAKU_ARMOR_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.INUMAKI_ARMOR_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.MUGIWARA_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.GOJO_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.VERGIL_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ROBE_HELMET.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ROBE_CHESTPLATE.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ROBE_LEGGINGS.get());
                tabData.accept(JujutsucraftaddonModItems.SUKUNA_ROBE_BOOTS.get());
                tabData.accept(JujutsucraftaddonModItems.CHOSO_ARMOR_HELMET.get());
            }).withTabsBefore(WEAPONS.getId()).build());
    public static final RegistryObject<CreativeModeTab> JUJUTSU_SCROLLS = REGISTRY.register("jujutsu_scrolls",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.jujutsu_scrolls")).icon(() -> new ItemStack(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get())).displayItems((parameters, tabData) -> {
                tabData.accept(JujutsucraftaddonModItems.SIMPLE_DOMAIN_SCROLL.get());
                tabData.accept(JujutsucraftaddonModItems.HEALTH_SCROLL.get());
                tabData.accept(JujutsucraftaddonModItems.KOKUSEN_SCROLL.get());
                tabData.accept(JujutsucraftaddonModItems.REVERSE_LEVEL_SCROLL.get());
                tabData.accept(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get());
            }).withTabsBefore(ARMORS.getId()).build());
    public static final RegistryObject<CreativeModeTab> ITEMS = REGISTRY.register("items",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.items")).icon(() -> new ItemStack(JujutsucraftaddonModItems.SPECIAL_GRADE_1_RECOMMENDATION.get())).displayItems((parameters, tabData) -> {
                tabData.accept(JujutsucraftaddonModItems.S_OULBOOK.get());
                tabData.accept(JujutsucraftaddonModItems.CURSED_WOMB.get());
                tabData.accept(JujutsucraftaddonModItems.KENJAKU_BALL.get());
                tabData.accept(JujutsucraftaddonModItems.JUJUTSU_COIN.get());
                tabData.accept(JujutsucraftaddonModItems.RACE_CHANGER.get());
                tabData.accept(JujutsucraftaddonModItems.CLAN_CHANGER.get());
                tabData.accept(JujutsucraftaddonModItems.PROFESSION.get());
                tabData.accept(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get());
                tabData.accept(JujutsucraftaddonModItems.SPECIAL_GRADE_1_RECOMMENDATION.get());
                tabData.accept(JujutsucraftaddonModItems.FAMOUS_GRADE_RECOMMENDATION.get());
                tabData.accept(JujutsucraftaddonModItems.STRONGEST_OF_HISTORY_RECOMMENDATION.get());
                tabData.accept(JujutsucraftaddonModItems.MODERN_ERA_SORCERER.get());
                tabData.accept(JujutsucraftaddonModItems.ARTIFACT.get());
                tabData.accept(JujutsucraftaddonModItems.ARTIFACT_2.get());
                tabData.accept(JujutsucraftaddonModItems.YIN_YANG.get());
                tabData.accept(JujutsucraftaddonModItems.ARTIFACT_3.get());
                tabData.accept(JujutsucraftaddonModItems.ARTIFACT_4.get());
                tabData.accept(JujutsucraftaddonModItems.ARTIFACT_5.get());
                tabData.accept(JujutsucraftaddonModItems.KOGANE_POINTS.get());
                tabData.accept(JujutsucraftaddonModItems.TENGEN.get());
                tabData.accept(JujutsucraftaddonModItems.TRAIT_RECOMMENDATION.get());
                tabData.accept(JujutsucraftaddonModItems.MOB_TAMER.get());
                tabData.accept(JujutsucraftaddonModItems.YUTA_RING.get());
                tabData.accept(JujutsucraftaddonModItems.YOKU_BUCKET.get());
                tabData.accept(JujutsucraftaddonModItems.ELEMENT_REST.get());
                tabData.accept(JujutsucraftaddonModItems.MEDICINE.get());
            }).withTabsBefore(JUJUTSU_SCROLLS.getId()).build());

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            tabData.accept(JujutsucraftaddonModItems.RED_ENTITY_SPAWN_EGG.get());
            tabData.accept(JujutsucraftaddonModItems.BLUE_ENTITY_SPAWN_EGG.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept(JujutsucraftaddonModItems.TESTING_VERSION_SPAWN_EGG.get());
            tabData.accept(JujutsucraftaddonModItems.YE_SPAWN_EGG.get());
        }
    }
}
