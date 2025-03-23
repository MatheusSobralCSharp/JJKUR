package com.jujutsu.jujutsucraftaddon.mixins;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.procedures.DismantleCutNerfed;
import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.item.HitenItem;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class HitenItemMixin {


    @Inject(method = "swing*", at = @At("HEAD"))
    private void onSwing(CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        boolean sukuna = false;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans.equals("Sukuna") && ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1)) {
           sukuna = true;
        }

        ItemStack mainHandItem = entity.getMainHandItem();
        if (mainHandItem.getItem() instanceof HitenItem) {
            if (entity instanceof SukunaPerfectEntity || entity instanceof SukunaFushiguroEntity) {
                if (Math.random() < (1) / ((float) 40)) {
                    if (!entity.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                        DismantleCutNerfed.execute(entity.level(), entity);
                    }
                }
            } else if (sukuna) {
                if (Math.random() < (1) / ((float) 40)) {
                    if (!entity.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                        DismantleCutNerfed.execute(entity.level(), entity);
                    }
                }
            }
        }

    }
}