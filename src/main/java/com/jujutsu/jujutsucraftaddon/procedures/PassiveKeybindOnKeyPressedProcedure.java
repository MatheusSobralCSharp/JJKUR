package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class PassiveKeybindOnKeyPressedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
            PassiveSukunaProcedure.execute(world, x, y, z, entity);
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
            if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "pressure"))));
                        }
                    }
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide() && !_entity.hasEffect(JujutsucraftaddonModMobEffects.HWB.get()))
                     _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HWB.get(), 40, 1, false, false));
            }

        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
            if (entity instanceof ServerPlayer _plr9 && _plr9.level() instanceof ServerLevel
                    && _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:extension_technique"))).isDone()) {
                Buff2Procedure.execute(world, x, y, z, entity);
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Buffed Shikigamis"), false);
            }

//                {
//                    final Vec3 _center = new Vec3(x, y, z);
//                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
//                    for (Entity entityiterator : _entfound) {
//                        if ((new Object() {
//                            public String getValue() {
//                                CompoundTag dataIndex = new CompoundTag();
//                                entityiterator.saveWithoutId(dataIndex);
//                                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
//                            }
//                        }.getValue()).equals(entity.getStringUUID())) {
//                            if (entityiterator.getPersistentData().getDouble("NoAttac1") == 0) {
//                                entityiterator.getPersistentData().putDouble("NoAttac1", 1);
//                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
//                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.AI.get(), -1, 1, false, false));
//                                if (entity instanceof Player _player && !_player.level().isClientSide())
//                                    _player.displayClientMessage(Component.literal("Disabled Shikigami Attack"), false);
//                            } else if (entityiterator.getPersistentData().getDouble("NoAttac1") == 1) {
//                                entityiterator.getPersistentData().putDouble("NoAttac1", 0);
//                                if (entityiterator instanceof LivingEntity _entity)
//                                    _entity.removeEffect(JujutsucraftaddonModMobEffects.AI.get());
//                                if (entity instanceof Player _player && !_player.level().isClientSide())
//                                    _player.displayClientMessage(Component.literal("Enabled Shikigami Attack"), false);
//                            }
//                        }
//                    }
        }  else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
            if (entity instanceof ServerPlayer _plr56 && _plr56.level() instanceof ServerLevel
                    && _plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:extension_technique"))).isDone()) {
                Buff2Procedure.execute(world, x, y, z, entity);
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Buffed!!"), false);
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
            PassiveKashimoProcedure.execute(world, entity);
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 38) {
            if (!(entity instanceof LivingEntity _livEnt71 && _livEnt71.hasEffect(MobEffects.INVISIBILITY))) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Used Sky Manipulation To Hide Yourself"), false);
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, -1, 254, false, false));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.URO_SNEAKY.get(), -1, 254, false, false));
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Removed Sky Manipulation To Hide Yourself"), false);
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(MobEffects.INVISIBILITY);
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(JujutsucraftaddonModMobEffects.URO_SNEAKY.get());
            }
        }
    }
}
