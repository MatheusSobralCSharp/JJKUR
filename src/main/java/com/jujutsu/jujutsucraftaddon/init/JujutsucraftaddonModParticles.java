
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.jujutsu.jujutsucraftaddon.init;

import com.jujutsu.jujutsucraftaddon.client.particle.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JujutsucraftaddonModParticles {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_BLUE.get(), ThunderBlueParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI.get(), KaiParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI.get(), HaitiParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get(), CursePowerBlueDarkParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), ThunderWhiteParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), ThunderBlackParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.THUNDER_BLUEE.get(), ThunderBlueeParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HIT_IMPACT.get(), HitImpactParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.IMPACT.get(), ImpactParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.RED.get(), RedParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.FISTS.get(), FistsParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.GOJO_IMBUED_THUNDER.get(), GojoImbuedThunderParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLUE_PUNCH.get(), BluePunchParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), BloodRedParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_MAHITO.get(), CursedPowerMahitoParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_ITADORI.get(), CursedPowerItadoriParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_OKKOTSU.get(), CursedPowerOkkotsuParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_SUKUNA.get(), CursedPowerSukunaParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_OKKOTSU_RING.get(), CursedPowerOkkotsuRingParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.SMOKE_WHITE.get(), SmokeWhiteParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.WATER.get(), WaterParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_2.get(), Kai2Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_2.get(), Haiti2Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_3.get(), Haiti3Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_3.get(), Kai3Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.FLASH_BANG.get(), FlashBangParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_4.get(), Haiti4Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_4.get(), Kai4Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLOOD.get(), BloodParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.PUNCH.get(), PunchParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.ICE.get(), IceParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.TSUKUMO_PUNCH.get(), TsukumoPunchParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_5.get(), Kai5Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_5.get(), Haiti5Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_6.get(), Haiti6Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_6.get(), Kai6Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.DASH_1.get(), Dash1Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_7.get(), Haiti7Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_8.get(), Haiti8Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_9.get(), Haiti9Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.WAFFLE.get(), WaffleParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH.get(), HorizontalSlashParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get(), HorizontalSlashBlackParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get(), HorizontalSlash2Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_KAI.get(), HorizontalKaiParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.VERTICAL_HAITI.get(), VerticalHaitiParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HAITI_10.get(), Haiti10Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KAI_10.get(), Kai10Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.CURSED_POWER_HAKARI.get(), CursedPowerHakariParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.BLUEE.get(), BlueeParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_1.get(), Kokusen1Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_2.get(), Kokusen2Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), Kokusen3Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_4.get(), Kokusen4Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), Kokusen5Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_1.get(), HorizontalSlash1Particle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.SUKUNA_SLASH.get(), SukunaSlashParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.SLASH.get(), SlashParticle::provider);
        event.registerSpriteSet(JujutsucraftaddonModParticleTypes.KOKUSEN_SPARK_1.get(), KokusenSpark1Particle::provider);
    }
}
