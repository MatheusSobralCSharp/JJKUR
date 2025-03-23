package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.entity.UiUiEntity;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

@Mod.EventBusSubscriber
public class MeiMeiAxeProcedure {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mei_mei_axe")) {
                    {
                        final Vec3 _center = new Vec3(x, y, z);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                        for (Entity entityiterator : _entfound) {
                            if (!(entityiterator == entity)) {
                                if (!(entityiterator instanceof UiUiEntity)) {
                                    if (world.getEntitiesOfClass(UiUiEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
                                        if (world instanceof ServerLevel _serverLevel) {
                                            LevelAccessor _worldorig = world;
                                            world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                            if (world != null) {
                                                Entity entitytospawn = JujutsucraftaddonModEntities.UI_UI.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                                if (entitytospawn != null) {
                                                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.putString("Owner", (entity.getStringUUID()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    if ((entitytospawn) instanceof LivingEntity _entity)
                                                        _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                                                    if ((entitytospawn) instanceof LivingEntity _entity) {
                                                        ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
                                                        _setstack.setCount(1);
                                                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                                        if (_entity instanceof Player _player)
                                                            _player.getInventory().setChanged();
                                                    }
                                                    {
                                                        Entity _entity = (entitytospawn);
                                                        if (_entity instanceof Player _player) {
                                                            _player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                                            _player.getInventory().setChanged();
                                                        } else if (_entity instanceof LivingEntity _living) {
                                                            _living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                                                        }
                                                    }
                                                    {
                                                        Entity _entity = (entitytospawn);
                                                        if (_entity instanceof Player _player) {
                                                            _player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                                            _player.getInventory().setChanged();
                                                        } else if (_entity instanceof LivingEntity _living) {
                                                            _living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                                                        }
                                                    }
                                                    {
                                                        Entity _entity = (entitytospawn);
                                                        if (_entity instanceof Player _player) {
                                                            _player.getInventory().armor.set(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                                            _player.getInventory().setChanged();
                                                        } else if (_entity instanceof LivingEntity _living) {
                                                            _living.setItemSlot(EquipmentSlot.CHEST, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                                                        }
                                                    }
                                                    {
                                                        Entity _entity = (entitytospawn);
                                                        if (_entity instanceof Player _player) {
                                                            _player.getInventory().armor.set(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                                            _player.getInventory().setChanged();
                                                        } else if (_entity instanceof LivingEntity _living) {
                                                            _living.setItemSlot(EquipmentSlot.HEAD, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                                                        }
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                                            public double getValue() {
                                                                CompoundTag dataIndex = new CompoundTag();
                                                                entity.saveWithoutId(dataIndex);
                                                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                            }
                                                        }.getValue()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                                            public double getValue() {
                                                                CompoundTag dataIndex = new CompoundTag();
                                                                entity.saveWithoutId(dataIndex);
                                                                return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                            }
                                                        }.getValue()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putBoolean("Player", true);
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.putBoolean("Player", true);
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
                                                            public boolean getValue() {
                                                                CompoundTag dataIndex = new CompoundTag();
                                                                entity.saveWithoutId(dataIndex);
                                                                return dataIndex.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
                                                            }
                                                        }.getValue()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
                                                            public boolean getValue() {
                                                                CompoundTag dataIndex = new CompoundTag();
                                                                entity.saveWithoutId(dataIndex);
                                                                return dataIndex.getCompound("ForgeData").getBoolean("CursedSpirit");
                                                            }
                                                        }.getValue()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    {
                                                        CompoundTag dataIndex = new CompoundTag();
                                                        (entitytospawn).saveWithoutId(dataIndex);
                                                        dataIndex.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
                                                            public boolean getValue() {
                                                                CompoundTag dataIndex = new CompoundTag();
                                                                entity.saveWithoutId(dataIndex);
                                                                return dataIndex.getCompound("ForgeData").getBoolean("CurseUser");
                                                            }
                                                        }.getValue()));
                                                        (entitytospawn).load(dataIndex);
                                                    }
                                                    _serverLevel.addFreshEntity(entitytospawn);
                                                }
                                            }
                                            world = _worldorig;
                                        }
                                    }
                                } else if (entityiterator instanceof UiUiEntity) {
                                    if (entityiterator.getPersistentData().getDouble("UiUi") == 0) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entityiterator.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("UiUi", 1);
                                            entityiterator.load(dataIndex);
                                        }
                                        if (entity instanceof Player _player && !_player.level().isClientSide())
                                            _player.displayClientMessage(Component.literal("Ui Ui: Agressive"), false);
                                    } else if (entityiterator.getPersistentData().getDouble("UiUi") == 1) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entityiterator.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("UiUi", 0);
                                            entityiterator.load(dataIndex);
                                        }
                                        if (entity instanceof Player _player && !_player.level().isClientSide())
                                            _player.displayClientMessage(Component.literal("Ui Ui: Defensive"), false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        EquipSupremeProcedure.execute(entity);
        KenjakuClanProcedure.execute(entity);
        KusakabeSwordBrokenProcedure.execute(world, entity);
    }
}
