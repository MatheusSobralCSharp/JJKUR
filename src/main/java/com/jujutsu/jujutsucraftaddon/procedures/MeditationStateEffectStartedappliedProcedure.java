package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MeditationStateEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player _player && !_player.level().isClientSide())
            _player.displayClientMessage(Component.literal("Your Training With Your Inner-Spirit Starts Now... Good Luck!"), false);
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_TOJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.SUKUNA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.GOJO_SATORU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 3) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.INUMAKI_TOGE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 4) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.OKKOTSU_YUTA_CULLING_GAME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_MEGUMI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique14", (-2));
                        (entitytospawn).load(dataIndex);
                    }
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique13", (-2));
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.KASHIMO_HAJIME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 8) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.DAGON.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.TSUKUMO_YUKI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.CHOSO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.MEI_MEI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 12) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ISHIGORI_RYU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 13) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.NANAMI_KENTO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 14) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.HANAMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.MAHITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 17) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.TAKABA_FUMIHIKO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.GETO_SUGURU_CURSE_USER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ZENIN_NAOYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.TODO_AOI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        }
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 22) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ZENIN_JINICHI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.URAUME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 25) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_01.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ZENIN_OGI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.HIGURUMA_HIROMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 28) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.KURUSU_HANA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 29) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.HAKARI_KINJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.MIGUEL_DANCER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 31) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.KUSAKABE_ATSUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 32) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.ZENIN_CHOJURO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 33) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.YAGA_MASAMICHI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 34) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.NOBARA_KUGISAKI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 35) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.YOSHINO_JUNPEI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 36) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.NISHIMIYA_MOMO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 37) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.DHRUV_LAKDAWALLA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 38) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.URO_TAKAKO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 39) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftModEntities.YOROZU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        (entitytospawn).saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("Spirit", 1);
                        (entitytospawn).load(dataIndex);
                    }
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
                    if ((entitytospawn) instanceof LivingEntity _entity)
                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
                    LivingEntity livingEntity2 = (LivingEntity) entitytospawn;
                    AttributeInstance maxHealthAttr = livingEntity2.getAttribute(Attributes.MAX_HEALTH);
                    maxHealthAttr.setBaseValue(900);
                    livingEntity2.setHealth(livingEntity2.getMaxHealth());
                    _serverLevel.addFreshEntity(entitytospawn);
                }
            }
        }
    }
}
