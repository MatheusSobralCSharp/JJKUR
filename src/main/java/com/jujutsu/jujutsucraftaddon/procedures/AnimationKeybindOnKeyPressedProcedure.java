package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.MergedBeastAgitoEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class AnimationKeybindOnKeyPressedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex0 = new CompoundTag();
                entity.saveWithoutId(dataIndex0);
                return dataIndex0.getCompound("ForgeData").getDouble("NBT_CursePowerAmount");
            }
        }.getValue() == 0) {
            if ((Objects.requireNonNull(ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem())).toString()).equals("jujutsucraft:split_soul_katana")) {
                if (!(entity.isShiftKeyDown() || entity.isSprinting() || entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
                    if (entity.onGround()) {
                        if (world.isClientSide()) {
                            if (entity instanceof AbstractClientPlayer player) {
                                var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(Objects.requireNonNull(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "idletoji")))));
                                }
                            }
                        }
                    }
                }
            }
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
            if (entity instanceof ServerPlayer _plr9 && _plr9.level() instanceof ServerLevel
                    && _plr9.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr9.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3")))).isDone()) {
                if (entity.isShiftKeyDown()) {
                    if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get()))) {
                        {
                            Entity _ent = entity;
                            _ent.teleportTo(
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
                                            + 1),
                                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport(
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getX()),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getY() + 1),
                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
                                                .getZ()),
                                        _ent.getYRot(), _ent.getXRot());
                        }
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get(), 80, 1, false, false));
                        {
                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cursed_technique");
                            }
                        }
                    }
                }
            }
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if (entity.isShiftKeyDown()) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex21 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex21);
                                    return dataIndex21.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue() == new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex22 = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex22);
                                    return dataIndex22.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()) {
                                {
                                    Entity _ent = entityiterator;
                                    _ent.teleportTo((entity.getX()), (entity.getY() + 1), (entity.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, -1, 1, false, false));
                                if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, -1, 254, false, false));
                                if (entityiterator instanceof GeoEntity) {
                                    if (entityiterator instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
                                        ((EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) entityiterator).setAnimation("guard");
                                    }
                                    if (entityiterator instanceof MergedBeastAgitoEntity) {
                                        ((MergedBeastAgitoEntity) entityiterator).setAnimation("guard");
                                    }
                                    entityiterator.setShiftKeyDown(true);
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Defense Mode"), false);
                            }
                        }
                    }
                } else if (!entity.isShiftKeyDown()) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex37 = new CompoundTag();
                                    entity.saveWithoutId(dataIndex37);
                                    return dataIndex37.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue() == new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex38 = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex38);
                                    return dataIndex38.getCompound("ForgeData").getDouble("friend_num");
                                }
                            }.getValue()) {
                                {
                                    Entity _ent = entityiterator;
                                    _ent.teleportTo((entity.getX()), (entity.getY() + 1), (entity.getZ()));
                                    if (_ent instanceof ServerPlayer _serverPlayer)
                                        _serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
                                }
                                if (entityiterator instanceof LivingEntity _entity)
                                    _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                                if (entityiterator instanceof LivingEntity _entity)
                                    _entity.removeEffect(MobEffects.BLINDNESS);
                                if (entityiterator instanceof GeoEntity) {
                                    entityiterator.setShiftKeyDown(false);
                                    entityiterator.setSprinting(true);
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Attack Mode"), false);
                            }
                        }
                    }
                }
            }
        }
    }
}
