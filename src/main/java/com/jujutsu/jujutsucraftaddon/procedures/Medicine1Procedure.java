package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.world.inventory.GojoTrainMenu;
import io.netty.buffer.Unpooled;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

@Mod.EventBusSubscriber
public class Medicine1Procedure {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.MEDICINE.get()) {
            if (entity.getPersistentData().getBoolean("JujutsuSorcerer")) {
                if (!entity.getPersistentData().getBoolean("Healed")) {
                    if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Healed < 99) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal("Medicine Applied Successful "), false);
                        entity.getPersistentData().putBoolean("Healed", true);
                        if (entity instanceof LivingEntity _entity)
                            _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Healed + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Healed = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (sourceentity instanceof Player _player) {
                            ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                    } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Healed >= 99) {
                        {
                            double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Healed + 1;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Healed = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal((Component.translatable("dialogueshoko1").getString())), false);
                        {
                            String _setval = "Reverse Cursed Technique Output Quest #2";
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.QuestActive = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        {
                            String _setval = "Talk With Shoko";
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Description = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        {
                            double _setval = 2;
                            sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.QuestOutput = _setval;
                                capability.syncPlayerVariables(sourceentity);
                            });
                        }
                        if (sourceentity instanceof Player _player) {
                            ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
                            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                    }
                } else {
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Find Another Sorcerer To Use Medicine"), false);
                }
            }
        }
        if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kusakabe_yatsuya")) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleQuest == 0) {
                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal((Component.translatable("dialoguekusakabe1").getString())), false);
                {
                    String _setval = "Simple Domain Mastery Quest #1";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Talk With Miwa";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    double _setval = 1;
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.SimpleQuest = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            } else if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleQuest == 3) {
                {
                    String _setval = "Simple Domain Mastery Quest #3";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Beat Kasumi Miwa and Yatsuya Kusakabe";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Goodluck!"), false);
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entityiterator == entity)) {
                            if (!(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get()))) {
                                if (!(ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("miwa")) {
                                    if (world instanceof ServerLevel _serverLevel) {
                                        Entity entitytospawn = JujutsucraftModEntities.MIWA_KASUMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 23, false, false));
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                (entitytospawn).saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putDouble("K1", 1);
                                                (entitytospawn).load(dataIndex);
                                            }
                                            if ((entitytospawn) instanceof LivingEntity _entity)
                                                _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                            _serverLevel.addFreshEntity(entitytospawn);
                                        }
                                    }
                                    if (world instanceof ServerLevel _serverLevel) {
                                        Entity entitytospawn = JujutsucraftModEntities.KUSAKABE_ATSUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                                        if (entitytospawn != null) {
                                            entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                            if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 23, false, false));
                                            {
                                                CompoundTag dataIndex = new CompoundTag();
                                                (entitytospawn).saveWithoutId(dataIndex);
                                                dataIndex.getCompound("ForgeData").putDouble("K1", 1);
                                                (entitytospawn).load(dataIndex);
                                            }
                                            if ((entitytospawn) instanceof LivingEntity _entity)
                                                _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                            _serverLevel.addFreshEntity(entitytospawn);
                                        }
                                    }
                                }
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get(), 3600, 1, false, false));
                            }
                        }
                    }
                }
            }
        } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:miwa_kasumi")) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleQuest == 1) {
                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal((Component.translatable("dialoguemiwa").getString())), false);
                {
                    String _setval = "Simple Domain Mastery Quest #2";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Meditate Passively Once";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    double _setval = 2;
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.SimpleQuest = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            }
        } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
            if (!(sourceentity instanceof ServerPlayer _plr46 && _plr46.level() instanceof ServerLevel
                    && _plr46.getAdvancements().getOrStartProgress(_plr46.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_burnout"))).isDone())) {
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CooldownExp >= 2500) {
                    if (sourceentity instanceof ServerPlayer _ent) {
                        BlockPos _bpos = BlockPos.containing(x, y, z);
                        NetworkHooks.openScreen(_ent, new MenuProvider() {
                            @Override
                            public Component getDisplayName() {
                                return Component.literal("GojoTrain");
                            }

                            @Override
                            public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                                return new GojoTrainMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
                            }
                        }, _bpos);
                    }
                }
            } else if (sourceentity instanceof ServerPlayer _plr48 && _plr48.level() instanceof ServerLevel
                    && _plr48.getAdvancements().getOrStartProgress(_plr48.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_output"))).isDone() && sourceentity instanceof ServerPlayer _plr49
                    && _plr49.level() instanceof ServerLevel && _plr49.getAdvancements().getOrStartProgress(_plr49.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_burnout"))).isDone()
                    && !(sourceentity instanceof ServerPlayer _plr50 && _plr50.level() instanceof ServerLevel
                    && _plr50.getAdvancements().getOrStartProgress(_plr50.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:reverse_cursed_mastery"))).isDone())) {
                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal((Component.translatable("dialoguegojo").getString())), false);
                {
                    String _setval = "RCT Mastery Quest #1";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Talk With Yuta";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    double _setval = 1;
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Mastery = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            }
        } else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta_culling_game")) {
            if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mastery == 1) {
                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal((Component.translatable("dialogueyuta").getString())), false);
                {
                    String _setval = "RCT Mastery Quest #2";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.QuestActive = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    String _setval = "Talk With Shoko";
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Description = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
                {
                    double _setval = 2;
                    sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Mastery = _setval;
                        capability.syncPlayerVariables(sourceentity);
                    });
                }
            }
        }
    }
}
