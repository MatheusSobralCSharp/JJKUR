
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.client.renderer.*;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JujutsucraftaddonModEntityRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(JujutsucraftaddonModEntities.MAKI_PREPARATION.get(), MakiPreparationRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.SUKUNA_MANGA.get(), SukunaMangaRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.SUKUNA_NO_SHIRT.get(), SukunaNoShirtRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get(), ItadoriShinjukuRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.YUTA_CULLING_GAMES.get(), YutaCullingGamesRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.RED_O.get(), RedORenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.CLEAVE_WEB.get(), CleaveWebRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.SUKUNA_FUSHIGURO.get(), SukunaFushiguroRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.GEGE_AKUTAMI.get(), GegeAkutamiRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.CIRCLE.get(), CircleRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.SHOKO_IERI_SCHOOL.get(), ShokoIeriSchoolRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.GOJO_MANGA.get(), GojoMangaRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.RIKO_AMANAI.get(), RikoAmanaiRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.TANJERINA.get(), TanjerinaRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.SHADOW_1.get(), Shadow1Renderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.IGRIS.get(), IgrisRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.PARTIAL_RIKA_ENTITY.get(), PartialRikaRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.UI_UI.get(), UiUiRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.BULLET_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.RED_ENTITY.get(), RedEntityRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.BLUE_ENTITY.get(), BlueEntityRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.IRONKK.get(), IronkkRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.HUSSEIN_DONG.get(), HusseinDongRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.GOJO_SCHOOL.get(), GojoSchoolRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.HAKARI.get(), HakariRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.ANGELL.get(), AngellRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.KASHIMO_FEMBOY.get(), KashimoFemboyRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.URAUME.get(), UraumeRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.ADJUCHA.get(), AdjuchaRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.VEIL.get(), VeilRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.SATUSHI.get(), SatushiRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.TEST_PROJECTILE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.ANTI_VEIL.get(), AntiVeilRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.MALENIA.get(), MaleniaRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.OUTLINE.get(), OutlineRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.TESTING_ENTITY.get(), TestingEntityRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.U.get(), URenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.TESTING_VERSION.get(), TestingVersionRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.YE.get(), YeRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.FAKE_CLONES.get(), FakeClonesRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.PURPLE_CLONES.get(), FakePurpleClonesRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.CLONE.get(), CloneRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.DISMANTLE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.DISMANTLE_VARIANT.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.MAKI_PREPARATION_2.get(), MakiPreparation2Renderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.ERRO.get(), ErroRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.CENTIPEDE.get(), CentipedeRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.MALEVOLENT_SHRINE.get(), MalevolentShrineRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.WORLD_SLASH_VARIANT.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.WORLD_SLASH_FINAL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(JujutsucraftaddonModEntities.ERROR.get(), ErrorRenderer::new);
    }
}
