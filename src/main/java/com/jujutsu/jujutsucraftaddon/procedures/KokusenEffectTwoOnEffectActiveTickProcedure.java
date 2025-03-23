package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class KokusenEffectTwoOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get()))) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen >= 1
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen < 21) {
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("punch" + Mth.nextInt(RandomSource.create(), 1, 10)))))));
                        }
                    }
                }
                if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_BLACK_FLASH_CUTSCENE)) {
                    {
                        double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen + 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Kokusen = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen >= 1
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen < 10) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get()))
                                && !(entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get()))) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("Kokusen");
                                }
                            }.getValue() == 1) {
                                entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                            }
                        }
                    }
                }
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen >= 11
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen < 12) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get()))
                                && !(entityiterator instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get()))) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("Kokusen");
                                }
                            }.getValue() == 1) {
                                entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                for (int index0 = 0; index0 < 20; index0++) {
                                    world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_3.get(), (entityiterator.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                                            (entityiterator.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5), (entityiterator.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                                            (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
                                }
                                for (int index1 = 0; index1 < 20; index1++) {
                                    world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_4.get(), (entityiterator.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                                            (entityiterator.getY() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5), (entityiterator.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                                            (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
                                }
                                for (int index2 = 0; index2 < 20; index2++) {
                                    world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_5.get(), (entityiterator.getX() + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * 5),
                                            (entityiterator.getY() + 0 + Mth.nextDouble(RandomSource.create(), 0.5, 1) * 5), (entityiterator.getZ() + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * 5), 0, 0, 0);
                                }
                                for (int index3 = 0; index3 < 20; index3++) {
                                    world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_1.get(), (entityiterator.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                                            (entityiterator.getY() + 0 + Mth.nextDouble(RandomSource.create(), 0.3, 1) * 5), (entityiterator.getZ() + 0 + Mth.nextDouble(RandomSource.create(), 1, 1) * 5), 0, 0, 0);
                                }
                                for (int index4 = 0; index4 < 20; index4++) {
                                    world.addParticle(JujutsucraftaddonModParticleTypes.KOKUSEN_2.get(), (entityiterator.getX() + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 5),
                                            (entityiterator.getY() + 0 + Mth.nextDouble(RandomSource.create(), 0.3, 1) * 5), (entityiterator.getZ() + 0 + Mth.nextDouble(RandomSource.create(), 1, 1) * 5), 0, 0, 0);
                                }
                                JujutsucraftaddonMod.queueServerWork(10, () -> {
                                    for (int index5 = 0; index5 < 1; index5++) {
                                        if (!(entityiterator instanceof LivingEntity _livEnt81 && _livEnt81.hasEffect(JujutsucraftaddonModMobEffects.RAMPAGE_ZONE.get()))) {
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entityiterator.saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putDouble("Kokusen", 0);
                                                entityiterator.load(dataIndex);
                                            }
                                        }
                                        {
                                            double _setval = 0;
                                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                capability.Kokusen = _setval;
                                                capability.syncPlayerVariables(entity);
                                            });
                                        }
                                    }
                                });
                                break;
                            }
                        } else {
                            if ((entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen <= 2) {
                                entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                            }
                        }
                    }
                }
            }
        } else if (entity instanceof LivingEntity _livEnt97 && _livEnt97.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get())) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen >= 1
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen < 21) {
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("punch" + Mth.nextInt(RandomSource.create(), 1, 10)))))));
                        }
                    }
                }
                if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_BLACK_FLASH_CUTSCENE)) {
                    {
                        double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen + 1;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.Kokusen = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen >= 11
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen < 12) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2 && entity instanceof LivingEntity _livEnt102
                                && _livEnt102.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get())) {
                            if (!((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2)
                                    && entityiterator instanceof LivingEntity _livEnt104 && _livEnt104.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get())) {
                                entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                {
                                    Entity _ent = entity;
                                    _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                JujutsucraftaddonMod.queueServerWork(10, () -> {
                                    for (int index6 = 0; index6 < 1; index6++) {
                                        if (!(entityiterator instanceof LivingEntity _livEnt118 && _livEnt118.hasEffect(JujutsucraftaddonModMobEffects.RAMPAGE_ZONE.get()))) {
                                            entityiterator.setDeltaMovement(new Vec3((100 * Math.cos((entity.getYRot() + 90) * (Math.PI / 180))), 0, (100 * Math.sin((entity.getYRot() + 90) * (Math.PI / 180)))));
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entityiterator.saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putDouble("Kokusen", 0);
                                                entityiterator.load(dataIndex);
                                            }
                                        }
                                        {
                                            double _setval = 0;
                                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                capability.Kokusen = _setval;
                                                capability.syncPlayerVariables(entity);
                                            });
                                        }
                                    }
                                });
                                break;
                            }
                        }
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen >= 1
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen < 10) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2 && entity instanceof LivingEntity _livEnt126
                                && _livEnt126.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get())) {
                            if (!((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2)
                                    && entityiterator instanceof LivingEntity _livEnt128 && _livEnt128.hasEffect(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get())) {
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entityiterator.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("Kokusen");
                                    }
                                }.getValue() == 1) {
                                    entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())));
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                    }
                                    {
                                        Entity _ent = entity;
                                        _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                                        if (_ent instanceof ServerPlayer _serverPlayer)
                                            _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                                    }
                                    if (world instanceof Level _level) {
                                        if (!_level.isClientSide()) {
                                            _level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusen")),
                                                    SoundSource.NEUTRAL, 1, 1);
                                        } else {
                                            _level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kokusen")),
                                                    SoundSource.NEUTRAL, 1, 1, false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
