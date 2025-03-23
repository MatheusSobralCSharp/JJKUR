package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;


public class SummonAllShadowsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex2 = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex2);
                    return dataIndex2.getCompound("ForgeData").getDouble("Started");
                }
            }.getValue() == 0) {
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_BLACK.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex5 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex5);
                    dataIndex5.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex5);
                    CompoundTag dataIndex8 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex8);
                    dataIndex8.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex7 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex7);
                            return dataIndex7.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex8);
                    CompoundTag dataIndex11 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex11);
                    dataIndex11.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex10 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex10);
                            return dataIndex10.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex11);
                    CompoundTag dataIndex14 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex14);
                    dataIndex14.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex13 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex13);
                            return dataIndex13.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex14);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex18 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex18);
                    dataIndex18.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex18);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_WHITE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex30 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex30);
                    dataIndex30.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex30);
                    CompoundTag dataIndex33 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex33);
                    dataIndex33.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex32 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex32);
                            return dataIndex32.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex33);
                    CompoundTag dataIndex36 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex36);
                    dataIndex36.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex35 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex35);
                            return dataIndex35.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex36);
                    CompoundTag dataIndex39 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex39);
                    dataIndex39.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex38 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex38);
                            return dataIndex38.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex39);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex43 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex43);
                    dataIndex43.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex43);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_TOTALITY.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex55 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex55);
                    dataIndex55.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex55);
                    CompoundTag dataIndex58 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex58);
                    dataIndex58.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex57 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex57);
                            return dataIndex57.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex58);
                    CompoundTag dataIndex61 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex61);
                    dataIndex61.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex60 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex60);
                            return dataIndex60.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex61);
                    CompoundTag dataIndex64 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex64);
                    dataIndex64.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex63 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex63);
                            return dataIndex63.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex64);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex68 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex68);
                    dataIndex68.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex68);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.TOAD.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex80 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex80);
                    dataIndex80.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex80);
                    CompoundTag dataIndex83 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex83);
                    dataIndex83.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex82 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex82);
                            return dataIndex82.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex83);
                    CompoundTag dataIndex86 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex86);
                    dataIndex86.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex85 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex85);
                            return dataIndex85.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex86);
                    CompoundTag dataIndex89 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex89);
                    dataIndex89.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex88 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex88);
                            return dataIndex88.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex89);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex93 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex93);
                    dataIndex93.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex93);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.TOAD_2.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex105 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex105);
                    dataIndex105.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex105);
                    CompoundTag dataIndex108 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex108);
                    dataIndex108.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex107 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex107);
                            return dataIndex107.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex108);
                    CompoundTag dataIndex111 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex111);
                    dataIndex111.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex110 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex110);
                            return dataIndex110.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex111);
                    CompoundTag dataIndex114 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex114);
                    dataIndex114.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex113 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex113);
                            return dataIndex113.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex114);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex118 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex118);
                    dataIndex118.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex118);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.MERGED_BEAST_AGITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex130 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex130);
                    dataIndex130.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex130);
                    CompoundTag dataIndex133 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex133);
                    dataIndex133.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex132 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex132);
                            return dataIndex132.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex133);
                    CompoundTag dataIndex136 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex136);
                    dataIndex136.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex135 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex135);
                            return dataIndex135.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex136);
                    CompoundTag dataIndex139 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex139);
                    dataIndex139.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex138 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex138);
                            return dataIndex138.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex139);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex143 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex143);
                    dataIndex143.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex143);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex155 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex155);
                    dataIndex155.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex155);
                    CompoundTag dataIndex158 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex158);
                    dataIndex158.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex157 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex157);
                            return dataIndex157.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex158);
                    CompoundTag dataIndex161 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex161);
                    dataIndex161.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex160 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex160);
                            return dataIndex160.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex161);
                    CompoundTag dataIndex164 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex164);
                    dataIndex164.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex163 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex163);
                            return dataIndex163.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex164);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex168 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex168);
                    dataIndex168.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex168);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.PIERCING_OX.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex180 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex180);
                    dataIndex180.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex180);
                    CompoundTag dataIndex183 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex183);
                    dataIndex183.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex182 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex182);
                            return dataIndex182.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex183);
                    CompoundTag dataIndex186 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex186);
                    dataIndex186.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex185 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex185);
                            return dataIndex185.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex186);
                    CompoundTag dataIndex189 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex189);
                    dataIndex189.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex188 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex188);
                            return dataIndex188.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex189);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex193 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex193);
                    dataIndex193.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex193);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.ROUND_DEER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex205 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex205);
                    dataIndex205.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex205);
                    CompoundTag dataIndex208 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex208);
                    dataIndex208.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex207 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex207);
                            return dataIndex207.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex208);
                    CompoundTag dataIndex211 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex211);
                    dataIndex211.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex210 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex210);
                            return dataIndex210.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex211);
                    CompoundTag dataIndex214 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex214);
                    dataIndex214.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex213 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex213);
                            return dataIndex213.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex214);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex218 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex218);
                    dataIndex218.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex218);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.TIGER_FUNERAL.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex230 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex230);
                    dataIndex230.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex230);
                    CompoundTag dataIndex233 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex233);
                    dataIndex233.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex232 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex232);
                            return dataIndex232.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex233);
                    CompoundTag dataIndex236 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex236);
                    dataIndex236.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex235 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex235);
                            return dataIndex235.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex236);
                    CompoundTag dataIndex239 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex239);
                    dataIndex239.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex238 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex238);
                            return dataIndex238.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex239);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex243 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex243);
                    dataIndex243.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex243);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.GREAT_SERPENT.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex255 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex255);
                    dataIndex255.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex255);
                    CompoundTag dataIndex258 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex258);
                    dataIndex258.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex257 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex257);
                            return dataIndex257.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex258);
                    CompoundTag dataIndex261 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex261);
                    dataIndex261.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex260 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex260);
                            return dataIndex260.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex261);
                    CompoundTag dataIndex264 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex264);
                    dataIndex264.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex263 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex263);
                            return dataIndex263.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex264);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex268 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex268);
                    dataIndex268.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex268);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.MAX_ELEPHANT.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex280 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex280);
                    dataIndex280.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex280);
                    CompoundTag dataIndex283 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex283);
                    dataIndex283.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex282 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex282);
                            return dataIndex282.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex283);
                    CompoundTag dataIndex286 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex286);
                    dataIndex286.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex285 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex285);
                            return dataIndex285.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex286);
                    CompoundTag dataIndex289 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex289);
                    dataIndex289.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex288 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex288);
                            return dataIndex288.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex289);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex293 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex293);
                    dataIndex293.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex293);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.GREAT_SERPENT.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex305 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex305);
                    dataIndex305.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex305);
                    CompoundTag dataIndex308 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex308);
                    dataIndex308.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex307 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex307);
                            return dataIndex307.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex308);
                    CompoundTag dataIndex311 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex311);
                    dataIndex311.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex310 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex310);
                            return dataIndex310.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex311);
                    CompoundTag dataIndex314 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex314);
                    dataIndex314.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex313 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex313);
                            return dataIndex313.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex314);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex318 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex318);
                    dataIndex318.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex318);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.NUE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex330 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex330);
                    dataIndex330.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex330);
                    CompoundTag dataIndex333 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex333);
                    dataIndex333.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex332 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex332);
                            return dataIndex332.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex333);
                    CompoundTag dataIndex336 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex336);
                    dataIndex336.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex335 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex335);
                            return dataIndex335.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex336);
                    CompoundTag dataIndex339 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex339);
                    dataIndex339.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex338 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex338);
                            return dataIndex338.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex339);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex343 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex343);
                    dataIndex343.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex343);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                    CompoundTag dataIndex355 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex355);
                    dataIndex355.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex355);
                    CompoundTag dataIndex358 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex358);
                    dataIndex358.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex357 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex357);
                            return dataIndex357.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex358);
                    CompoundTag dataIndex361 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex361);
                    dataIndex361.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex360 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex360);
                            return dataIndex360.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex361);
                    CompoundTag dataIndex364 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex364);
                    dataIndex364.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex363 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex363);
                            return dataIndex363.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex364);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get(), -1, 254, false, false));
                    CompoundTag dataIndex368 = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex368);
                    dataIndex368.getCompound("ForgeData").putBoolean("Buffed", true);
                    (entitytospawn).load(dataIndex368);
                    if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                                ((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1, false, false));
                    ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                            .setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2.5));
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("\u201CWhen did I say it\u2019s a fair fight? Now it's 10 vs 1\u201D"), false);
                CompoundTag dataIndex379 = new CompoundTag();
                sourceentity.saveWithoutId(dataIndex379);
                dataIndex379.getCompound("ForgeData").putDouble("Started", 1);
                sourceentity.load(dataIndex379);
            }
        }
    }
}
