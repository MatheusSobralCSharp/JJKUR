package com.jujutsu.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class UiUiAIProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
            if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.DAMAGE_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)
                                    ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier()
                                    : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.MOVEMENT_SPEED)) && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt12
                    && _livEnt12.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED)
                                    ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier()
                                    : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.HEALTH_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0,
                            false, false));
            }
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("Follow");
                }
            }.getValue() == 1) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("skill", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() > 0) {
                    if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getPersistentData().getBoolean("PRESS_Z")) {
                        if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                                + 1,
                                        false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1,
                                        false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                                ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                                : 0),
                                        false, false));
                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                            if (!(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getPersistentData().getBoolean("PRESS_Z")) {
                                entity.getPersistentData().putBoolean("PRESS_Z", false);
                            }
                        }
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt1", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt2");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt2");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt2", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt2");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt3");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt3");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt3", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt3");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt4");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt4");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt4", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt4");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt7");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt7");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt7", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt7");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt8");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt8");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt8", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt8");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt9");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt9");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt9", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt9");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt10");
                    }
                }.getValue() != new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt10");
                    }
                }.getValue()) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("cnt10", (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt10");
                            }
                        }.getValue()));
                        entity.load(dataIndex);
                    }
                }
                if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).isShiftKeyDown()) {
                    entity.setShiftKeyDown(true);
                } else if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).isShiftKeyDown()) && entity.isShiftKeyDown()) {
                    entity.setShiftKeyDown(false);
                }
            } else {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() > 0) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("cnt4");
                        }
                    }.getValue() >= 1250) {
                        if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                                + 1,
                                        false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1,
                                        false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                                ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                                : 0),
                                        false, false));
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                }
                            }.getValue() < 45) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt1", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt3");
                                }
                            }.getValue() < 20) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt3", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                            entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                    } else {
                        if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1,
                                        false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                                ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                                : 0),
                                        false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                        (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
                                                + 1,
                                        false, false));
                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                }
                            }.getValue() < 6) {
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                    }
                                }.getValue() < 10) {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                            }
                                        }.getValue() + 1));
                                        entity.load(dataIndex);
                                    }
                                }
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                                    }
                                }.getValue() >= 1) {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                                            }
                                        }.getValue() + 1));
                                        entity.load(dataIndex);
                                    }
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                            }
                                        }.getValue() + 1));
                                        entity.load(dataIndex);
                                    }
                                }
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                    }
                                }.getValue() > 10) {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                            }
                                        }.getValue() + 1));
                                        entity.load(dataIndex);
                                    }
                                }
                                entity.getPersistentData().putBoolean("PRESS_Z", true);
                            } else {
                                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt4");
                    }
                }.getValue() >= 1250) {
                    if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1,
                                    false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1, false,
                                    false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                            : 0),
                                    false, false));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                            }
                        }.getValue() < 45) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("cnt1", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                    }
                                }.getValue() + 1));
                                entity.load(dataIndex);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt3");
                            }
                        }.getValue() < 20) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("cnt3", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                    }
                                }.getValue() + 1));
                                entity.load(dataIndex);
                            }
                        }
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                    } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                } else {
                    if (!(entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1, false,
                                    false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                            : 0),
                                    false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                    (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1,
                                    false, false));
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                    } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                            }
                        }.getValue() < 6) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                }
                            }.getValue() < 10) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                                }
                            }.getValue() >= 1) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                }
                            }.getValue() > 10) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else {
                            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                                entity.getPersistentData().putBoolean("PRESS_Z", false);
                            }
                        }
                    }
                }
            }
        }
        if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
            if ((ForgeRegistries.ENTITY_TYPES.getKey((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType()).toString()).contains("crow")) {
                if (entity instanceof Mob) {
                    try {
                        ((Mob) entity).setTarget(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
