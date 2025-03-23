package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.CloneEntity;
import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.entity.ErrorEntity;
import com.jujutsu.jujutsucraftaddon.entity.FakeClonesEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class SukunaAttackAnimationsProcedure {
    public static void execute(Entity sourceentity, Entity entity, LevelAccessor world) {
        if (sourceentity == null || world == null)
            return;

        if (!(sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {

            if (sourceentity instanceof CloneEntity && ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.MAINHAND) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_STAFF_TRUE.get().asItem())) {
                ((CloneEntity) sourceentity).setAnimation(("wu" + Mth.nextInt(RandomSource.create(), 1, 17)));
            }

            if (sourceentity instanceof FakeClonesEntity && ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.MAINHAND) : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_STAFF_TRUE.get().asItem())) {
                ((FakeClonesEntity) sourceentity).setAnimation(("wu" + Mth.nextInt(RandomSource.create(), 1, 17)));
            }

            if (!(sourceentity.getPersistentData().getDouble("skill") == 105 || sourceentity.getPersistentData().getDouble("skill") == 106)) {
                if (sourceentity instanceof ErroEntity) {
                    ((ErroEntity) sourceentity).setAnimation(("animation.sukuna.attack" + Mth.nextInt(RandomSource.create(), 1, 9)));
                }

                if (sourceentity instanceof ErrorEntity) {
                    ((ErrorEntity) sourceentity).setAnimation(("animation.sukuna.attack" + Mth.nextInt(RandomSource.create(), 1, 9)));
                }
            } else {
                if (sourceentity.getPersistentData().getDouble("skill") == 105) {
                    if (sourceentity.onGround()) {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation(("animation.dismantle_maximum" + Mth.nextInt(RandomSource.create(), 1, 4)));
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation(("animation.dismantle_maximum" + Mth.nextInt(RandomSource.create(), 1, 4)));
                        }
                    } else {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation("animation.dismantle_backwards");
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation("animation.dismantle_backwards");
                        }
                    }
                }
                if (sourceentity.getPersistentData().getDouble("skill") == 106) {
                    if (sourceentity.onGround()) {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation(("animation.cleave.attack" + Mth.nextInt(RandomSource.create(), 1, 5)));
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation(("animation.cleave.attack" + Mth.nextInt(RandomSource.create(), 1, 5)));
                        }
                    } else {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation("animation.dissect");
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation("animation.dissect");
                        }
                    }
                }
            }
        } else {

        }
    }
}
