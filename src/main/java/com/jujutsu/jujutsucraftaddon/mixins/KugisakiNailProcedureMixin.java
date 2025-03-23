package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.BulletNailEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraft.procedures.KugisakiNailProcedure;
import net.mcreator.jujutsucraft.procedures.RotateEntityProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KugisakiNailProcedure.class, priority = -10000)
public abstract class KugisakiNailProcedureMixin {

    /**
     * @author Satushi
     * @reason Buffs Nails and make them don't cost always every shot
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity) entity;
                _livEnt.swing(InteractionHand.MAIN_HAND, true);
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity) entity;
                var10000 = _livEnt.getMainHandItem();
            } else {
                var10000 = ItemStack.EMPTY;
            }

            Level projectileLevel;
            if (var10000.getItem() == JujutsucraftModItems.HAMMER.get()) {
                if (world instanceof Level) {
                    projectileLevel = (Level) world;
                    if (!projectileLevel.isClientSide()) {
                        projectileLevel.playSound((Player) null, BlockPos.containing(x, y, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                    } else {
                        projectileLevel.playLocalSound(x, y, z, (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                    }
                }

                if (Math.random() < 0.01) {
                    if (entity instanceof Player) {
                        Player _player = (Player) entity;
                        ItemStack _stktoremove = new ItemStack((ItemLike) JujutsucraftModItems.NAIL.get());
                        _player.getInventory().clearOrCountMatchingItems((p) -> {
                            return _stktoremove.getItem() == p.getItem();
                        }, 1, _player.inventoryMenu.getCraftSlots());
                    }
                }
            }

            LivingEntity var23;
            if (entity instanceof Mob) {
                Mob _mobEnt = (Mob) entity;
                var23 = _mobEnt.getTarget();
            } else {
                var23 = null;
            }

            if (var23 instanceof LivingEntity) {
                Mob _mobEnt;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var23 = _mobEnt.getTarget();
                } else {
                    var23 = null;
                }

                x_pos = var23.getX();
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var23 = _mobEnt.getTarget();
                } else {
                    var23 = null;
                }

                double var24 = var23.getY();
                LivingEntity var10001;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10001 = _mobEnt.getTarget();
                } else {
                    var10001 = null;
                }

                y_pos = var24 + (double) var10001.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var23 = _mobEnt.getTarget();
                } else {
                    var23 = null;
                }

                z_pos = var23.getZ();
                RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().putDouble("Damage", 0.5);
            DamageFixProcedure.execute(entity);
            Entity _shootFrom = entity;
            projectileLevel = _shootFrom.level();
            if (!projectileLevel.isClientSide()) {
                Projectile _entityToSpawn = ((new Object() {
                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new BulletNailEntity((EntityType) JujutsucraftModEntities.BULLET_NAIL.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double) damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setCritArrow(true);
                        entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
                        return entityToSpawn;
                    }
                })).getArrow(projectileLevel, entity, (float) entity.getPersistentData().getDouble("Damage"), 0);
                _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3.0F, 0.0F);
                projectileLevel.addFreshEntity(_entityToSpawn);
            }

            entity.getPersistentData().putDouble("skill", 0.0);
        }
    }
}

