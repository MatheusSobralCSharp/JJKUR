package com.jujutsu.jujutsucraftaddon.network;

import com.jujutsu.jujutsucraftaddon.JujutsucraftaddonMod;
import com.jujutsu.jujutsucraftaddon.procedures.LockOnCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModVariables {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
        JujutsucraftaddonMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
    }

    @SubscribeEvent
    public static void init(RegisterCapabilitiesEvent event) {
        event.register(PlayerVariables.class);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide())
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (!event.getEntity().level().isClientSide())
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getEntity().level().isClientSide())
                event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()).syncPlayerVariables(event.getEntity());
        }

        @SubscribeEvent
        public static void clonePlayer(PlayerEvent.Clone event) {
            event.getOriginal().revive();
            PlayerVariables original = event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
            PlayerVariables clone = event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
            clone.Armorslot1 = original.Armorslot1;
            clone.Armorslot2 = original.Armorslot2;
            clone.Armorslot3 = original.Armorslot3;
            clone.Armorslot4 = original.Armorslot4;
            clone.Armorslot5 = original.Armorslot5;
            clone.InventoryArmorySlot1 = original.InventoryArmorySlot1;
            clone.slot0 = original.slot0;
            clone.slot1 = original.slot1;
            clone.slot10 = original.slot10;
            clone.slot11 = original.slot11;
            clone.slot12 = original.slot12;
            clone.slot13 = original.slot13;
            clone.slot14 = original.slot14;
            clone.slot15 = original.slot15;
            clone.slot16 = original.slot16;
            clone.slot17 = original.slot17;
            clone.slot18 = original.slot18;
            clone.slot19 = original.slot19;
            clone.slot2 = original.slot2;
            clone.slot3 = original.slot3;
            clone.slot4 = original.slot4;
            clone.slot5 = original.slot5;
            clone.slot6 = original.slot6;
            clone.slot7 = original.slot7;
            clone.slot8 = original.slot8;
            clone.slot9 = original.slot9;
            clone.lockOnCapability = original.lockOnCapability;
            clone.AgitoBeast = original.AgitoBeast;
            clone.BarrierlessDomain = original.BarrierlessDomain;
            clone.BGM = original.BGM;
            clone.BurnOutRCT = original.BurnOutRCT;
            clone.Dash = original.Dash;
            clone.InfusedDomain = original.InfusedDomain;
            clone.IsCursedSpirit = original.IsCursedSpirit;
            clone.IsInumaki = original.IsInumaki;
            clone.IsJujutsuSorcerer = original.IsJujutsuSorcerer;
            clone.IsVessel = original.IsVessel;
            clone.PVP = original.PVP;
            clone.RCTMasteryOn = original.RCTMasteryOn;
            clone.RCTOutput = original.RCTOutput;
            clone.RCTOutputActive = original.RCTOutputActive;
            clone.rctspirit = original.rctspirit;
            clone.save = original.save;
            clone.save1 = original.save1;
            clone.fog = original.fog;
            clone.bar = original.bar;
            clone.SimpleDomain = original.SimpleDomain;
            clone.WorldSlash = original.WorldSlash;
            clone.Ultimate = original.Ultimate;
            clone.SecondAllowed = original.SecondAllowed;
            clone.AnimationDefense = original.AnimationDefense;
            clone.AnimationSlash = original.AnimationSlash;
            clone.AnimationYuzuki = original.AnimationYuzuki;
            clone.AttackAnimation = original.AttackAnimation;
            clone.BarrierlessCount = original.BarrierlessCount;
            clone.BarrierlessDomainNumber = original.BarrierlessDomainNumber;
            clone.BFChance = original.BFChance;
            clone.blackflashmastery = original.blackflashmastery;
            clone.TechniqueMastery = original.TechniqueMastery;
            clone.CE = original.CE;
            clone.CECap = original.CECap;
            clone.CEFormer = original.CEFormer;
            clone.CEPlus = original.CEPlus;
            clone.CEShield = original.CEShield;
            clone.CooldownExp = original.CooldownExp;
            clone.Copy1 = original.Copy1;
            clone.Copy2 = original.Copy2;
            clone.Copy3 = original.Copy3;
            clone.Copy4 = original.Copy4;
            clone.CursedLevel = original.CursedLevel;
            clone.CursedSpiritsKilled = original.CursedSpiritsKilled;
            clone.friend_num = original.friend_num;
            clone.FutureSightNumber = original.FutureSightNumber;
            clone.GH = original.GH;
            clone.GojoQuest = original.GojoQuest;
            clone.gojosund = original.gojosund;
            clone.Healed = original.Healed;
            clone.HealthAttribute = original.HealthAttribute;
            clone.History = original.History;
            clone.HPCap = original.HPCap;
            clone.ImpactFramesVariable = original.ImpactFramesVariable;
            clone.ItadoriAwakening = original.ItadoriAwakening;
            clone.KenjakuCT1 = original.KenjakuCT1;
            clone.KenjakuCT2 = original.KenjakuCT2;
            clone.Kokusen = original.Kokusen;
            clone.Level = original.Level;
            clone.levelrct = original.levelrct;
            clone.Limb = original.Limb;
            clone.locker = original.locker;
            clone.Mahoraga = original.Mahoraga;
            clone.MahoragaCanAdapt = original.MahoragaCanAdapt;
            clone.Mastery = original.Mastery;
            clone.MimicryKatana = original.MimicryKatana;
            clone.Murasaki = original.Murasaki;
            clone.OstVariable = original.OstVariable;
            clone.Output = original.Output;
            clone.pressed = original.pressed;
            clone.ProfessionEXP = original.ProfessionEXP;
            clone.Purple = original.Purple;
            clone.QuestOutput = original.QuestOutput;
            clone.RadiusDomain = original.RadiusDomain;
            clone.random = original.random;
            clone.RCTCount = original.RCTCount;
            clone.RCTCount2 = original.RCTCount2;
            clone.RCTLimitLevel = original.RCTLimitLevel;
            clone.RCTMastery = original.RCTMastery;
            clone.RCTRegen = original.RCTRegen;
            clone.Run = original.Run;
            clone.Style = original.Style;
            clone.AttackNumber = original.AttackNumber;
            clone.SH = original.SH;
            clone.SimpleDomainLevel = original.SimpleDomainLevel;
            clone.SimpleQuest = original.SimpleQuest;
            clone.sokamona = original.sokamona;
            clone.sp = original.sp;
            clone.speedCount = original.speedCount;
            clone.SpeedValue = original.SpeedValue;
            clone.Vow2 = original.Vow2;
            clone.Vow3 = original.Vow3;
            clone.VowPower = original.VowPower;
            clone.water = original.water;
            clone.worldslashtimer = original.worldslashtimer;
            clone.YutaCheck = original.YutaCheck;
            clone.HistorySukuna = original.HistorySukuna;
            clone.SecondTechnique = original.SecondTechnique;
            clone.soka = original.soka;
            clone.PointsSpirit = original.PointsSpirit;
            clone.Clans = original.Clans;
            clone.ClanSlot1 = original.ClanSlot1;
            clone.ClanSlot2 = original.ClanSlot2;
            clone.ClanSlot3 = original.ClanSlot3;
            clone.Damage = original.Damage;
            clone.Description = original.Description;
            clone.Element = original.Element;
            clone.KenjakuName = original.KenjakuName;
            clone.MobTexture = original.MobTexture;
            clone.MobTexture2 = original.MobTexture2;
            clone.MobTexture3 = original.MobTexture3;
            clone.Mode = original.Mode;
            clone.Profession = original.Profession;
            clone.QuestActive = original.QuestActive;
            clone.Shadow = original.Shadow;
            clone.ShadowName = original.ShadowName;
            clone.SkinName1 = original.SkinName1;
            clone.SkinName2 = original.SkinName2;
            clone.SkinName3 = original.SkinName3;
            clone.Subrace = original.Subrace;
            clone.tag1 = original.tag1;
            clone.tag2 = original.tag2;
            clone.Team = original.Team;
            clone.TeamName = original.TeamName;
            clone.Technique = original.Technique;
            clone.Trait = original.Trait;
            clone.UUIDBattle = original.UUIDBattle;
            clone.PlayerTexture = original.PlayerTexture;
            clone.Moveset = original.Moveset;
            clone.TrueSpeed = original.TrueSpeed;
            clone.Effects = original.Effects;
            clone.FingerReset = original.FingerReset;
            if (!event.isWasDeath()) {
                clone.InventoryArmorySlot0 = original.InventoryArmorySlot0;
                clone.InventoryArmorySlot2 = original.InventoryArmorySlot2;
                clone.InventoryArmorySlot3 = original.InventoryArmorySlot3;
                clone.InventoryArmorySlot4 = original.InventoryArmorySlot4;
                clone.BrainDamage = original.BrainDamage;
                clone.DomainType = original.DomainType;
                clone.OutputLevel = original.OutputLevel;
                clone.CustceneDone = original.CustceneDone;
                clone.Points = original.Points;
                clone.TimeLeft = original.TimeLeft;
                clone.Timer1 = original.Timer1;
                clone.Vow4 = original.Vow4;
                clone.DataSixEyesOne = original.DataSixEyesOne;
            }
        }

        @SubscribeEvent
        public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                SavedData mapdata = MapVariables.get(event.getEntity().level());
                SavedData worlddata = WorldVariables.get(event.getEntity().level());
                if (mapdata != null)
                    JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
                if (worlddata != null)
                    JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
        }

        @SubscribeEvent
        public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getEntity().level().isClientSide()) {
                SavedData worlddata = WorldVariables.get(event.getEntity().level());
                if (worlddata != null)
                    JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
            }
        }
    }

    public static class WorldVariables extends SavedData {
        public static final String DATA_NAME = "jujutsucraftaddon_worldvars";

        public static WorldVariables load(CompoundTag tag) {
            WorldVariables data = new WorldVariables();
            data.read(tag);
            return data;
        }

        public void read(CompoundTag nbt) {
        }

        @Override
        public CompoundTag save(CompoundTag nbt) {
            return nbt;
        }

        public void syncData(LevelAccessor world) {
            this.setDirty();
            if (world instanceof Level level && !level.isClientSide())
                JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
        }

        static WorldVariables clientSide = new WorldVariables();

        public static WorldVariables get(LevelAccessor world) {
            if (world instanceof ServerLevel level) {
                return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
            } else {
                return clientSide;
            }
        }
    }

    public static class MapVariables extends SavedData {
        public static final String DATA_NAME = "jujutsucraftaddon_mapvars";
        public ItemStack PVPReward = ItemStack.EMPTY;
        public ItemStack PVPReward2 = ItemStack.EMPTY;
        public ItemStack PVPReward3 = ItemStack.EMPTY;
        public ItemStack PVPReward4 = ItemStack.EMPTY;
        public ItemStack PVPReward5 = ItemStack.EMPTY;
        public double PVPAmount1 = 0;
        public double PVPAmount2 = 0;
        public double PVPAmount3 = 0;
        public double PVPAmount4 = 0;
        public double PVPAmount5 = 0;
        public double PVPReward2Rate = 0;
        public double PVPReward3Rate = 0;
        public double PVPReward4Rate = 0;
        public double PVPReward5Rate = 0;
        public double PVPRewardRate = 0;
        public double Sukuna = 0;
        public double X = 0;
        public double X1 = 0;
        public double Y = 0;
        public double Y1 = 0.0;
        public double Z = 0;
        public double Z1 = 0;

        public static MapVariables load(CompoundTag tag) {
            MapVariables data = new MapVariables();
            data.read(tag);
            return data;
        }

        public void read(CompoundTag nbt) {
            PVPReward = ItemStack.of(nbt.getCompound("PVPReward"));
            PVPReward2 = ItemStack.of(nbt.getCompound("PVPReward2"));
            PVPReward3 = ItemStack.of(nbt.getCompound("PVPReward3"));
            PVPReward4 = ItemStack.of(nbt.getCompound("PVPReward4"));
            PVPReward5 = ItemStack.of(nbt.getCompound("PVPReward5"));
            PVPAmount1 = nbt.getDouble("PVPAmount1");
            PVPAmount2 = nbt.getDouble("PVPAmount2");
            PVPAmount3 = nbt.getDouble("PVPAmount3");
            PVPAmount4 = nbt.getDouble("PVPAmount4");
            PVPAmount5 = nbt.getDouble("PVPAmount5");
            PVPReward2Rate = nbt.getDouble("PVPReward2Rate");
            PVPReward3Rate = nbt.getDouble("PVPReward3Rate");
            PVPReward4Rate = nbt.getDouble("PVPReward4Rate");
            PVPReward5Rate = nbt.getDouble("PVPReward5Rate");
            PVPRewardRate = nbt.getDouble("PVPRewardRate");
            Sukuna = nbt.getDouble("Sukuna");
            X = nbt.getDouble("X");
            X1 = nbt.getDouble("X1");
            Y = nbt.getDouble("Y");
            Y1 = nbt.getDouble("Y1");
            Z = nbt.getDouble("Z");
            Z1 = nbt.getDouble("Z1");
        }

        @Override
        public CompoundTag save(CompoundTag nbt) {
            nbt.put("PVPReward", PVPReward.save(new CompoundTag()));
            nbt.put("PVPReward2", PVPReward2.save(new CompoundTag()));
            nbt.put("PVPReward3", PVPReward3.save(new CompoundTag()));
            nbt.put("PVPReward4", PVPReward4.save(new CompoundTag()));
            nbt.put("PVPReward5", PVPReward5.save(new CompoundTag()));
            nbt.putDouble("PVPAmount1", PVPAmount1);
            nbt.putDouble("PVPAmount2", PVPAmount2);
            nbt.putDouble("PVPAmount3", PVPAmount3);
            nbt.putDouble("PVPAmount4", PVPAmount4);
            nbt.putDouble("PVPAmount5", PVPAmount5);
            nbt.putDouble("PVPReward2Rate", PVPReward2Rate);
            nbt.putDouble("PVPReward3Rate", PVPReward3Rate);
            nbt.putDouble("PVPReward4Rate", PVPReward4Rate);
            nbt.putDouble("PVPReward5Rate", PVPReward5Rate);
            nbt.putDouble("PVPRewardRate", PVPRewardRate);
            nbt.putDouble("Sukuna", Sukuna);
            nbt.putDouble("X", X);
            nbt.putDouble("X1", X1);
            nbt.putDouble("Y", Y);
            nbt.putDouble("Y1", Y1);
            nbt.putDouble("Z", Z);
            nbt.putDouble("Z1", Z1);
            return nbt;
        }

        public void syncData(LevelAccessor world) {
            this.setDirty();
            if (world instanceof Level && !world.isClientSide())
                JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
        }

        static MapVariables clientSide = new MapVariables();

        public static MapVariables get(LevelAccessor world) {
            if (world instanceof ServerLevelAccessor serverLevelAcc) {
                return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
            } else {
                return clientSide;
            }
        }
    }


    public static class SavedDataSyncMessage {
        private final int type;
        private SavedData data;

        public SavedDataSyncMessage(FriendlyByteBuf buffer) {
            this.type = buffer.readInt();
            CompoundTag nbt = buffer.readNbt();
            if (nbt != null) {
                this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
                if (this.data instanceof MapVariables mapVariables)
                    mapVariables.read(nbt);
                else if (this.data instanceof WorldVariables worldVariables)
                    worldVariables.read(nbt);
            }
        }

        public SavedDataSyncMessage(int type, SavedData data) {
            this.type = type;
            this.data = data;
        }

        public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeInt(message.type);
            if (message.data != null)
                buffer.writeNbt(message.data.save(new CompoundTag()));
        }

        public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
                    if (message.type == 0)
                        MapVariables.clientSide = (MapVariables) message.data;
                    else
                        WorldVariables.clientSide = (WorldVariables) message.data;
                }
            });
            context.setPacketHandled(true);
        }
    }

    public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
    });

    @Mod.EventBusSubscriber
    private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
                event.addCapability(new ResourceLocation("jujutsucraftaddon", "player_variables"), new PlayerVariablesProvider());
        }

        private final PlayerVariables playerVariables = new PlayerVariables();
        private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public Tag serializeNBT() {
            return playerVariables.writeNBT();
        }

        @Override
        public void deserializeNBT(Tag nbt) {
            playerVariables.readNBT(nbt);
        }
    }

    public static class PlayerVariables {
        public ItemStack Armorslot1 = ItemStack.EMPTY;
        public ItemStack Armorslot2 = ItemStack.EMPTY;
        public ItemStack Armorslot3 = ItemStack.EMPTY;
        public ItemStack Armorslot4 = ItemStack.EMPTY;
        public ItemStack Armorslot5 = ItemStack.EMPTY;
        public ItemStack InventoryArmorySlot0 = ItemStack.EMPTY;
        public ItemStack InventoryArmorySlot1 = ItemStack.EMPTY;
        public ItemStack InventoryArmorySlot2 = ItemStack.EMPTY;
        public ItemStack InventoryArmorySlot3 = ItemStack.EMPTY;
        public ItemStack InventoryArmorySlot4 = ItemStack.EMPTY;
        public ItemStack slot0 = ItemStack.EMPTY;
        public ItemStack slot1 = ItemStack.EMPTY;
        public ItemStack slot10 = ItemStack.EMPTY;
        public ItemStack slot11 = ItemStack.EMPTY;
        public ItemStack slot12 = ItemStack.EMPTY;
        public ItemStack slot13 = ItemStack.EMPTY;
        public ItemStack slot14 = ItemStack.EMPTY;
        public ItemStack slot15 = ItemStack.EMPTY;
        public ItemStack slot16 = ItemStack.EMPTY;
        public ItemStack slot17 = ItemStack.EMPTY;
        public ItemStack slot18 = ItemStack.EMPTY;
        public ItemStack slot19 = ItemStack.EMPTY;
        public ItemStack slot2 = ItemStack.EMPTY;
        public ItemStack slot3 = ItemStack.EMPTY;
        public ItemStack slot4 = ItemStack.EMPTY;
        public ItemStack slot5 = ItemStack.EMPTY;
        public ItemStack slot6 = ItemStack.EMPTY;
        public ItemStack slot7 = ItemStack.EMPTY;
        public ItemStack slot8 = ItemStack.EMPTY;
        public ItemStack slot9 = ItemStack.EMPTY;
        public boolean AgitoBeast = false;
        public boolean BarrierlessDomain = false;
        public boolean BGM = false;
        public boolean BurnOutRCT = false;
        public boolean Dash = false;
        public boolean InfusedDomain = false;
        public boolean IsCursedSpirit = false;
        public boolean IsInumaki = false;
        public boolean IsJujutsuSorcerer = false;
        public boolean IsVessel = false;
        public boolean PVP = false;
        public boolean RCTMasteryOn = false;
        public boolean RCTOutput = false;
        public boolean RCTOutputActive = false;
        public boolean rctspirit = false;
        public boolean fog = true;
        public boolean bar = true;
        public boolean save = true;
        public boolean save1 = false;
        public boolean SimpleDomain = false;
        public boolean WorldSlash = false;
        public boolean Ultimate = false;
        public boolean SecondAllowed = false;
        public boolean FingerReset = false;
        public double AnimationDefense = 0;
        public double AnimationSlash = 0.0;
        public double AnimationYuzuki = 0;
        public double AttackAnimation = 0;
        public double BarrierlessCount = 0;
        public double BarrierlessDomainNumber = 0;
        public double BFChance = 0;
        public double blackflashmastery = 1.0;
        public double TechniqueMastery = 0.0;
        public double BrainDamage = 0;
        public double CE = 0;
        public double CECap = 0;
        public double CEFormer = 0;
        public double CEPlus = 0;
        public double CEShield = 0;
        public double CooldownExp = 0;
        public double Copy1 = 0;
        public double Copy2 = 0;
        public double Copy3 = 0.0;
        public double Copy4 = 0;
        public double CursedLevel = 0.0;
        public double CursedSpiritsKilled = 0;
        public double DomainType = 0;
        public double friend_num = 0;
        public double FutureSightNumber = 0;
        public double GH = 0;
        public double GojoQuest = 0;
        public double gojosund = 0;
        public double Healed = 0;
        public double HealthAttribute = 0;
        public double History = 0.0;
        public double HPCap = 0;
        public double ImpactFramesVariable = 0;
        public double ItadoriAwakening = 0;
        public double KenjakuCT1 = 0;
        public double KenjakuCT2 = 0;
        public double Kokusen = 0;
        public double Level = 0;
        public double levelrct = 0.0;
        public double Limb = 0;
        public double locker = 0.0;
        public double Mahoraga = 0;
        public double MahoragaCanAdapt = 0;
        public double Mastery = 0;
        public double MimicryKatana = 0;
        public double Murasaki = 9999.0;
        public double OstVariable = 0;
        public double Output = 0;
        public double OutputLevel = 1.0;
        public double CustceneDone = 0.0;
        public double Points = 0;
        public double pressed = 0;
        public double ProfessionEXP = 0;
        public double Purple = 9990.0;
        public double QuestOutput = 0;
        public double RadiusDomain = 0;
        public double random = 0;
        public double RCTCount = 0;
        public double RCTCount2 = 0;
        public double RCTLimitLevel = 0;
        public double RCTMastery = 0;
        public double RCTRegen = 0;
        public double Run = 0;
        public double Style = 0;
        public double AttackNumber = 0;
        public double SH = 0;
        public double SimpleDomainLevel = 0.0;
        public double SimpleQuest = 0.0;
        public double sokamona = 9999.0;
        public double sp = 0;
        public double speedCount = 0;
        public double SpeedValue = 0;
        public double TimeLeft = 6000.0;
        public double Timer1 = 1.0;
        public double Vow2 = 1.0;
        public double Vow3 = 1.0;
        public double Vow4 = 0.0;
        public double VowPower = 1.0;
        public double water = 0;
        public double worldslashtimer = 0;
        public double YutaCheck = 0;
        public double HistorySukuna = 0;
        public double SecondTechnique = 0;
        public double soka = 0;
        public double PointsSpirit = 0;
        public String Clans = "\"None\"";
        public String ClanSlot1 = "\"None\"";
        public String ClanSlot2 = "\"None\"";
        public String ClanSlot3 = "\"None\"";
        public String Damage = "\"None\"";
        public String DataSixEyesOne = "\"None\"";
        public String Description = "\"None\"";
        public String Element = "\"None\"";
        public String KenjakuName = "\"None\"";
        public String MobTexture = "\"None\"";
        public String MobTexture2 = "\"None\"";
        public String MobTexture3 = "\"None\"";
        public String Mode = "\"None\"";
        public String Profession = "\"None\"";
        public String QuestActive = "\"None\"";
        public String Shadow = "\"\"";
        public String ShadowName = "\"\"";
        public String SkinName1 = "\"None\"";
        public String SkinName2 = "\"None\"";
        public String SkinName3 = "\"None\"";
        public String Subrace = "\"E\"";
        public String tag1 = "\"E\"";
        public String tag2 = "\"E\"";
        public String Team = "\"E\"";
        public String TeamName = "\"E\"";
        public String Technique = "\"F\"";
        public String Trait = "\"Y\"";
        public String UUIDBattle = "\"F\"";
        public String PlayerTexture = "\"\"";
        public double Moveset = 0;
        public double TrueSpeed = 0;
        public boolean Effects = false;
        public LockOnCapability lockOnCapability = new LockOnCapability();


        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer)
                JujutsucraftaddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
        }

        public Tag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.put("Armorslot1", Armorslot1.save(new CompoundTag()));
            nbt.put("Armorslot2", Armorslot2.save(new CompoundTag()));
            nbt.put("Armorslot3", Armorslot3.save(new CompoundTag()));
            nbt.put("Armorslot4", Armorslot4.save(new CompoundTag()));
            nbt.put("Armorslot5", Armorslot5.save(new CompoundTag()));
            nbt.put("InventoryArmorySlot0", InventoryArmorySlot0.save(new CompoundTag()));
            nbt.put("InventoryArmorySlot1", InventoryArmorySlot1.save(new CompoundTag()));
            nbt.put("InventoryArmorySlot2", InventoryArmorySlot2.save(new CompoundTag()));
            nbt.put("InventoryArmorySlot3", InventoryArmorySlot3.save(new CompoundTag()));
            nbt.put("InventoryArmorySlot4", InventoryArmorySlot4.save(new CompoundTag()));
            nbt.put("slot0", slot0.save(new CompoundTag()));
            nbt.put("slot1", slot1.save(new CompoundTag()));
            nbt.put("slot10", slot10.save(new CompoundTag()));
            nbt.put("slot11", slot11.save(new CompoundTag()));
            nbt.put("slot12", slot12.save(new CompoundTag()));
            nbt.put("slot13", slot13.save(new CompoundTag()));
            nbt.put("slot14", slot14.save(new CompoundTag()));
            nbt.put("slot15", slot15.save(new CompoundTag()));
            nbt.put("slot16", slot16.save(new CompoundTag()));
            nbt.put("slot17", slot17.save(new CompoundTag()));
            nbt.put("slot18", slot18.save(new CompoundTag()));
            nbt.put("slot19", slot19.save(new CompoundTag()));
            nbt.put("slot2", slot2.save(new CompoundTag()));
            nbt.put("slot3", slot3.save(new CompoundTag()));
            nbt.put("slot4", slot4.save(new CompoundTag()));
            nbt.put("slot5", slot5.save(new CompoundTag()));
            nbt.put("slot6", slot6.save(new CompoundTag()));
            nbt.put("slot7", slot7.save(new CompoundTag()));
            nbt.put("slot8", slot8.save(new CompoundTag()));
            nbt.put("slot9", slot9.save(new CompoundTag()));
            nbt.putBoolean("AgitoBeast", AgitoBeast);
            nbt.putBoolean("BarrierlessDomain", BarrierlessDomain);
            nbt.putBoolean("BGM", BGM);
            nbt.putBoolean("BurnOutRCT", BurnOutRCT);
            nbt.putBoolean("Dash", Dash);
            nbt.putBoolean("InfusedDomain", InfusedDomain);
            nbt.putBoolean("IsCursedSpirit", IsCursedSpirit);
            nbt.putBoolean("IsInumaki", IsInumaki);
            nbt.putBoolean("IsJujutsuSorcerer", IsJujutsuSorcerer);
            nbt.putBoolean("IsVessel", IsVessel);
            nbt.putBoolean("PVP", PVP);
            nbt.putBoolean("RCTMasteryOn", RCTMasteryOn);
            nbt.putBoolean("RCTOutput", RCTOutput);
            nbt.putBoolean("RCTOutputActive", RCTOutputActive);
            nbt.putBoolean("rctspirit", rctspirit);
            nbt.putBoolean("save", save);
            nbt.putBoolean("save1", save1);
            nbt.putBoolean("bar", bar);
            nbt.putBoolean("fog", fog);
            nbt.putBoolean("SimpleDomain", SimpleDomain);
            nbt.putBoolean("WorldSlash", WorldSlash);
            nbt.putBoolean("Ultimate", Ultimate);
            nbt.putBoolean("SecondAllowed", SecondAllowed);
            nbt.putDouble("AnimationDefense", AnimationDefense);
            nbt.putDouble("AnimationSlash", AnimationSlash);
            nbt.putDouble("AnimationYuzuki", AnimationYuzuki);
            nbt.putDouble("AttackAnimation", AttackAnimation);
            nbt.putDouble("BarrierlessCount", BarrierlessCount);
            nbt.putDouble("BarrierlessDomainNumber", BarrierlessDomainNumber);
            nbt.putDouble("BFChance", BFChance);
            nbt.putDouble("blackflashmastery", blackflashmastery);
            nbt.putDouble("TechniqueMastery", TechniqueMastery);
            nbt.putDouble("BrainDamage", BrainDamage);
            nbt.putDouble("CE", CE);
            nbt.putDouble("CECap", CECap);
            nbt.putDouble("CEFormer", CEFormer);
            nbt.putDouble("CEPlus", CEPlus);
            nbt.putDouble("CEShield", CEShield);
            nbt.putDouble("CooldownExp", CooldownExp);
            nbt.putDouble("Copy1", Copy1);
            nbt.putDouble("Copy2", Copy2);
            nbt.putDouble("Copy3", Copy3);
            nbt.putDouble("Copy4", Copy4);
            nbt.putDouble("CursedLevel", CursedLevel);
            nbt.putDouble("CursedSpiritsKilled", CursedSpiritsKilled);
            nbt.putDouble("DomainType", DomainType);
            nbt.putDouble("friend_num", friend_num);
            nbt.putDouble("FutureSightNumber", FutureSightNumber);
            nbt.putDouble("GH", GH);
            nbt.putDouble("GojoQuest", GojoQuest);
            nbt.putDouble("gojosund", gojosund);
            nbt.putDouble("Healed", Healed);
            nbt.putDouble("HealthAttribute", HealthAttribute);
            nbt.putDouble("History", History);
            nbt.putDouble("HPCap", HPCap);
            nbt.putDouble("ImpactFramesVariable", ImpactFramesVariable);
            nbt.putDouble("ItadoriAwakening", ItadoriAwakening);
            nbt.putDouble("KenjakuCT1", KenjakuCT1);
            nbt.putDouble("KenjakuCT2", KenjakuCT2);
            nbt.putDouble("Kokusen", Kokusen);
            nbt.putDouble("Level", Level);
            nbt.putDouble("levelrct", levelrct);
            nbt.putDouble("Limb", Limb);
            nbt.putDouble("locker", locker);
            nbt.putDouble("Mahoraga", Mahoraga);
            nbt.putDouble("MahoragaCanAdapt", MahoragaCanAdapt);
            nbt.putDouble("Mastery", Mastery);
            nbt.putDouble("MimicryKatana", MimicryKatana);
            nbt.putDouble("Murasaki", Murasaki);
            nbt.putDouble("OstVariable", OstVariable);
            nbt.putDouble("Output", Output);
            nbt.putDouble("OutputLevel", OutputLevel);
            nbt.putDouble("CustceneDone", CustceneDone);
            nbt.putDouble("Points", Points);
            nbt.putDouble("pressed", pressed);
            nbt.putDouble("ProfessionEXP", ProfessionEXP);
            nbt.putDouble("Purple", Purple);
            nbt.putDouble("QuestOutput", QuestOutput);
            nbt.putDouble("RadiusDomain", RadiusDomain);
            nbt.putDouble("random", random);
            nbt.putDouble("RCTCount", RCTCount);
            nbt.putDouble("RCTCount2", RCTCount2);
            nbt.putDouble("RCTLimitLevel", RCTLimitLevel);
            nbt.putDouble("RCTMastery", RCTMastery);
            nbt.putDouble("RCTRegen", RCTRegen);
            nbt.putDouble("Run", Run);
            nbt.putDouble("Style", Style);
            nbt.putDouble("AttackNumber", AttackNumber);
            nbt.putDouble("SH", SH);
            nbt.putDouble("SimpleDomainLevel", SimpleDomainLevel);
            nbt.putDouble("SimpleQuest", SimpleQuest);
            nbt.putDouble("sokamona", sokamona);
            nbt.putDouble("sp", sp);
            nbt.putDouble("speedCount", speedCount);
            nbt.putDouble("SpeedValue", SpeedValue);
            nbt.putDouble("TimeLeft", TimeLeft);
            nbt.putDouble("Timer1", Timer1);
            nbt.putDouble("Vow2", Vow2);
            nbt.putDouble("Vow3", Vow3);
            nbt.putDouble("Vow4", Vow4);
            nbt.putDouble("VowPower", VowPower);
            nbt.putDouble("water", water);
            nbt.putDouble("worldslashtimer", worldslashtimer);
            nbt.putDouble("YutaCheck", YutaCheck);
            nbt.putDouble("HistorySukuna", HistorySukuna);
            nbt.putDouble("SecondTechnique", SecondTechnique);
            nbt.putDouble("soka", soka);
            nbt.putDouble("PointsSpirit", PointsSpirit);
            nbt.putString("Clans", Clans);
            nbt.putString("ClanSlot1", ClanSlot1);
            nbt.putString("ClanSlot2", ClanSlot2);
            nbt.putString("ClanSlot3", ClanSlot3);
            nbt.putString("Damage", Damage);
            nbt.putString("DataSixEyesOne", DataSixEyesOne);
            nbt.putString("Description", Description);
            nbt.putString("Element", Element);
            nbt.putString("KenjakuName", KenjakuName);
            nbt.putString("MobTexture", MobTexture);
            nbt.putString("MobTexture2", MobTexture2);
            nbt.putString("MobTexture3", MobTexture3);
            nbt.putString("Mode", Mode);
            nbt.putString("Profession", Profession);
            nbt.putString("QuestActive", QuestActive);
            nbt.putString("Shadow", Shadow);
            nbt.putString("ShadowName", ShadowName);
            nbt.putString("SkinName1", SkinName1);
            nbt.putString("SkinName2", SkinName2);
            nbt.putString("SkinName3", SkinName3);
            nbt.putString("Subrace", Subrace);
            nbt.putString("tag1", tag1);
            nbt.putString("tag2", tag2);
            nbt.putString("Team", Team);
            nbt.putString("TeamName", TeamName);
            nbt.putString("Technique", Technique);
            nbt.putString("Trait", Trait);
            nbt.putString("UUIDBattle", UUIDBattle);
            nbt.putString("PlayerTexture", PlayerTexture);
            nbt.putDouble("Moveset", Moveset);
            nbt.putDouble("TrueSpeed", TrueSpeed);
            nbt.putBoolean("Effects", Effects);
            nbt.putBoolean("FingerReset", FingerReset);
            nbt.putInt("targetEntityId", lockOnCapability.getTargetEntityId());
            return nbt;
        }

        public void readNBT(Tag tag) {
            CompoundTag nbt = (CompoundTag) tag;
            Armorslot1 = ItemStack.of(nbt.getCompound("Armorslot1"));
            Armorslot2 = ItemStack.of(nbt.getCompound("Armorslot2"));
            Armorslot3 = ItemStack.of(nbt.getCompound("Armorslot3"));
            Armorslot4 = ItemStack.of(nbt.getCompound("Armorslot4"));
            Armorslot5 = ItemStack.of(nbt.getCompound("Armorslot5"));
            InventoryArmorySlot0 = ItemStack.of(nbt.getCompound("InventoryArmorySlot0"));
            InventoryArmorySlot1 = ItemStack.of(nbt.getCompound("InventoryArmorySlot1"));
            InventoryArmorySlot2 = ItemStack.of(nbt.getCompound("InventoryArmorySlot2"));
            InventoryArmorySlot3 = ItemStack.of(nbt.getCompound("InventoryArmorySlot3"));
            InventoryArmorySlot4 = ItemStack.of(nbt.getCompound("InventoryArmorySlot4"));
            slot0 = ItemStack.of(nbt.getCompound("slot0"));
            slot1 = ItemStack.of(nbt.getCompound("slot1"));
            slot10 = ItemStack.of(nbt.getCompound("slot10"));
            slot11 = ItemStack.of(nbt.getCompound("slot11"));
            slot12 = ItemStack.of(nbt.getCompound("slot12"));
            slot13 = ItemStack.of(nbt.getCompound("slot13"));
            slot14 = ItemStack.of(nbt.getCompound("slot14"));
            slot15 = ItemStack.of(nbt.getCompound("slot15"));
            slot16 = ItemStack.of(nbt.getCompound("slot16"));
            slot17 = ItemStack.of(nbt.getCompound("slot17"));
            slot18 = ItemStack.of(nbt.getCompound("slot18"));
            slot19 = ItemStack.of(nbt.getCompound("slot19"));
            slot2 = ItemStack.of(nbt.getCompound("slot2"));
            slot3 = ItemStack.of(nbt.getCompound("slot3"));
            slot4 = ItemStack.of(nbt.getCompound("slot4"));
            slot5 = ItemStack.of(nbt.getCompound("slot5"));
            slot6 = ItemStack.of(nbt.getCompound("slot6"));
            slot7 = ItemStack.of(nbt.getCompound("slot7"));
            slot8 = ItemStack.of(nbt.getCompound("slot8"));
            slot9 = ItemStack.of(nbt.getCompound("slot9"));
            AgitoBeast = nbt.getBoolean("AgitoBeast");
            BarrierlessDomain = nbt.getBoolean("BarrierlessDomain");
            BGM = nbt.getBoolean("BGM");
            BurnOutRCT = nbt.getBoolean("BurnOutRCT");
            Dash = nbt.getBoolean("Dash");
            InfusedDomain = nbt.getBoolean("InfusedDomain");
            IsCursedSpirit = nbt.getBoolean("IsCursedSpirit");
            IsInumaki = nbt.getBoolean("IsInumaki");
            IsJujutsuSorcerer = nbt.getBoolean("IsJujutsuSorcerer");
            IsVessel = nbt.getBoolean("IsVessel");
            PVP = nbt.getBoolean("PVP");
            RCTMasteryOn = nbt.getBoolean("RCTMasteryOn");
            RCTOutput = nbt.getBoolean("RCTOutput");
            RCTOutputActive = nbt.getBoolean("RCTOutputActive");
            rctspirit = nbt.getBoolean("rctspirit");
            save = nbt.getBoolean("save");
            save1 = nbt.getBoolean("save1");
            bar = nbt.getBoolean("bar");
            fog = nbt.getBoolean("fog");
            SimpleDomain = nbt.getBoolean("SimpleDomain");
            WorldSlash = nbt.getBoolean("WorldSlash");
            Ultimate = nbt.getBoolean("Ultimate");
            SecondAllowed = nbt.getBoolean("SecondAllowed");
            AnimationDefense = nbt.getDouble("AnimationDefense");
            AnimationSlash = nbt.getDouble("AnimationSlash");
            AnimationYuzuki = nbt.getDouble("AnimationYuzuki");
            AttackAnimation = nbt.getDouble("AttackAnimation");
            BarrierlessCount = nbt.getDouble("BarrierlessCount");
            BarrierlessDomainNumber = nbt.getDouble("BarrierlessDomainNumber");
            BFChance = nbt.getDouble("BFChance");
            blackflashmastery = nbt.getDouble("blackflashmastery");
            TechniqueMastery = nbt.getDouble("TechniqueMastery");
            BrainDamage = nbt.getDouble("BrainDamage");
            CE = nbt.getDouble("CE");
            CECap = nbt.getDouble("CECap");
            CEFormer = nbt.getDouble("CEFormer");
            CEPlus = nbt.getDouble("CEPlus");
            CEShield = nbt.getDouble("CEShield");
            CooldownExp = nbt.getDouble("CooldownExp");
            Copy1 = nbt.getDouble("Copy1");
            Copy2 = nbt.getDouble("Copy2");
            Copy3 = nbt.getDouble("Copy3");
            Copy4 = nbt.getDouble("Copy4");
            CursedLevel = nbt.getDouble("CursedLevel");
            CursedSpiritsKilled = nbt.getDouble("CursedSpiritsKilled");
            DomainType = nbt.getDouble("DomainType");
            friend_num = nbt.getDouble("friend_num");
            FutureSightNumber = nbt.getDouble("FutureSightNumber");
            GH = nbt.getDouble("GH");
            GojoQuest = nbt.getDouble("GojoQuest");
            gojosund = nbt.getDouble("gojosund");
            Healed = nbt.getDouble("Healed");
            HealthAttribute = nbt.getDouble("HealthAttribute");
            History = nbt.getDouble("History");
            HPCap = nbt.getDouble("HPCap");
            ImpactFramesVariable = nbt.getDouble("ImpactFramesVariable");
            ItadoriAwakening = nbt.getDouble("ItadoriAwakening");
            KenjakuCT1 = nbt.getDouble("KenjakuCT1");
            KenjakuCT2 = nbt.getDouble("KenjakuCT2");
            Kokusen = nbt.getDouble("Kokusen");
            Level = nbt.getDouble("Level");
            levelrct = nbt.getDouble("levelrct");
            Limb = nbt.getDouble("Limb");
            locker = nbt.getDouble("locker");
            Mahoraga = nbt.getDouble("Mahoraga");
            MahoragaCanAdapt = nbt.getDouble("MahoragaCanAdapt");
            Mastery = nbt.getDouble("Mastery");
            MimicryKatana = nbt.getDouble("MimicryKatana");
            Murasaki = nbt.getDouble("Murasaki");
            OstVariable = nbt.getDouble("OstVariable");
            Output = nbt.getDouble("Output");
            OutputLevel = nbt.getDouble("OutputLevel");
            CustceneDone = nbt.getDouble("CustceneDone");
            Points = nbt.getDouble("Points");
            pressed = nbt.getDouble("pressed");
            ProfessionEXP = nbt.getDouble("ProfessionEXP");
            Purple = nbt.getDouble("Purple");
            QuestOutput = nbt.getDouble("QuestOutput");
            RadiusDomain = nbt.getDouble("RadiusDomain");
            random = nbt.getDouble("random");
            RCTCount = nbt.getDouble("RCTCount");
            RCTCount2 = nbt.getDouble("RCTCount2");
            RCTLimitLevel = nbt.getDouble("RCTLimitLevel");
            RCTMastery = nbt.getDouble("RCTMastery");
            RCTRegen = nbt.getDouble("RCTRegen");
            Run = nbt.getDouble("Run");
            Style = nbt.getDouble("Style");
            AttackNumber = nbt.getDouble("AttackNumber");
            SH = nbt.getDouble("SH");
            SimpleDomainLevel = nbt.getDouble("SimpleDomainLevel");
            SimpleQuest = nbt.getDouble("SimpleQuest");
            sokamona = nbt.getDouble("sokamona");
            sp = nbt.getDouble("sp");
            speedCount = nbt.getDouble("speedCount");
            SpeedValue = nbt.getDouble("SpeedValue");
            TimeLeft = nbt.getDouble("TimeLeft");
            Timer1 = nbt.getDouble("Timer1");
            Vow2 = nbt.getDouble("Vow2");
            Vow3 = nbt.getDouble("Vow3");
            Vow4 = nbt.getDouble("Vow4");
            VowPower = nbt.getDouble("VowPower");
            water = nbt.getDouble("water");
            worldslashtimer = nbt.getDouble("worldslashtimer");
            YutaCheck = nbt.getDouble("YutaCheck");
            HistorySukuna = nbt.getDouble("HistorySukuna");
            SecondTechnique = nbt.getDouble("SecondTechnique");
            soka = nbt.getDouble("soka");
            PointsSpirit = nbt.getDouble("PointsSpirit");
            Clans = nbt.getString("Clans");
            ClanSlot1 = nbt.getString("ClanSlot1");
            ClanSlot2 = nbt.getString("ClanSlot2");
            ClanSlot3 = nbt.getString("ClanSlot3");
            Damage = nbt.getString("Damage");
            DataSixEyesOne = nbt.getString("DataSixEyesOne");
            Description = nbt.getString("Description");
            Element = nbt.getString("Element");
            KenjakuName = nbt.getString("KenjakuName");
            MobTexture = nbt.getString("MobTexture");
            MobTexture2 = nbt.getString("MobTexture2");
            MobTexture3 = nbt.getString("MobTexture3");
            Mode = nbt.getString("Mode");
            Profession = nbt.getString("Profession");
            QuestActive = nbt.getString("QuestActive");
            Shadow = nbt.getString("Shadow");
            ShadowName = nbt.getString("ShadowName");
            SkinName1 = nbt.getString("SkinName1");
            SkinName2 = nbt.getString("SkinName2");
            SkinName3 = nbt.getString("SkinName3");
            Subrace = nbt.getString("Subrace");
            tag1 = nbt.getString("tag1");
            tag2 = nbt.getString("tag2");
            Team = nbt.getString("Team");
            TeamName = nbt.getString("TeamName");
            Technique = nbt.getString("Technique");
            Trait = nbt.getString("Trait");
            UUIDBattle = nbt.getString("UUIDBattle");
            PlayerTexture = nbt.getString("PlayerTexture");
            Moveset = nbt.getDouble("Moveset");
            TrueSpeed = nbt.getDouble("TrueSpeed");
            Effects = nbt.getBoolean("Effects");
            FingerReset = nbt.getBoolean("FingerReset");
            if (nbt.contains("targetEntityId")) {
                lockOnCapability.setTargetEntityId(nbt.getInt("targetEntityId"));
            }
        }
    }

    public static class PlayerVariablesSyncMessage {
        private final PlayerVariables data;

        public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
            this.data = new PlayerVariables();
            this.data.readNBT(buffer.readNbt());
        }

        public PlayerVariablesSyncMessage(PlayerVariables data) {
            this.data = data;
        }

        public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeNbt((CompoundTag) message.data.writeNBT());
        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerVariables variables = Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables());
                    variables.Armorslot1 = message.data.Armorslot1;
                    variables.Armorslot2 = message.data.Armorslot2;
                    variables.Armorslot3 = message.data.Armorslot3;
                    variables.Armorslot4 = message.data.Armorslot4;
                    variables.Armorslot5 = message.data.Armorslot5;
                    variables.InventoryArmorySlot0 = message.data.InventoryArmorySlot0;
                    variables.InventoryArmorySlot1 = message.data.InventoryArmorySlot1;
                    variables.InventoryArmorySlot2 = message.data.InventoryArmorySlot2;
                    variables.InventoryArmorySlot3 = message.data.InventoryArmorySlot3;
                    variables.InventoryArmorySlot4 = message.data.InventoryArmorySlot4;
                    variables.slot0 = message.data.slot0;
                    variables.slot1 = message.data.slot1;
                    variables.slot10 = message.data.slot10;
                    variables.slot11 = message.data.slot11;
                    variables.slot12 = message.data.slot12;
                    variables.slot13 = message.data.slot13;
                    variables.slot14 = message.data.slot14;
                    variables.slot15 = message.data.slot15;
                    variables.slot16 = message.data.slot16;
                    variables.slot17 = message.data.slot17;
                    variables.slot18 = message.data.slot18;
                    variables.slot19 = message.data.slot19;
                    variables.slot2 = message.data.slot2;
                    variables.slot3 = message.data.slot3;
                    variables.slot4 = message.data.slot4;
                    variables.slot5 = message.data.slot5;
                    variables.slot6 = message.data.slot6;
                    variables.slot7 = message.data.slot7;
                    variables.slot8 = message.data.slot8;
                    variables.slot9 = message.data.slot9;
                    variables.AgitoBeast = message.data.AgitoBeast;
                    variables.BarrierlessDomain = message.data.BarrierlessDomain;
                    variables.BGM = message.data.BGM;
                    variables.BurnOutRCT = message.data.BurnOutRCT;
                    variables.Dash = message.data.Dash;
                    variables.InfusedDomain = message.data.InfusedDomain;
                    variables.IsCursedSpirit = message.data.IsCursedSpirit;
                    variables.IsInumaki = message.data.IsInumaki;
                    variables.IsJujutsuSorcerer = message.data.IsJujutsuSorcerer;
                    variables.IsVessel = message.data.IsVessel;
                    variables.PVP = message.data.PVP;
                    variables.RCTMasteryOn = message.data.RCTMasteryOn;
                    variables.RCTOutput = message.data.RCTOutput;
                    variables.RCTOutputActive = message.data.RCTOutputActive;
                    variables.rctspirit = message.data.rctspirit;
                    variables.save = message.data.save;
                    variables.save1 = message.data.save1;
                    variables.bar = message.data.bar;
                    variables.fog = message.data.fog;
                    variables.SimpleDomain = message.data.SimpleDomain;
                    variables.WorldSlash = message.data.WorldSlash;
                    variables.Ultimate = message.data.Ultimate;
                    variables.SecondAllowed = message.data.SecondAllowed;
                    variables.AnimationDefense = message.data.AnimationDefense;
                    variables.AnimationSlash = message.data.AnimationSlash;
                    variables.AnimationYuzuki = message.data.AnimationYuzuki;
                    variables.AttackAnimation = message.data.AttackAnimation;
                    variables.BarrierlessCount = message.data.BarrierlessCount;
                    variables.BarrierlessDomainNumber = message.data.BarrierlessDomainNumber;
                    variables.BFChance = message.data.BFChance;
                    variables.blackflashmastery = message.data.blackflashmastery;
                    variables.TechniqueMastery = message.data.TechniqueMastery;
                    variables.BrainDamage = message.data.BrainDamage;
                    variables.CE = message.data.CE;
                    variables.CECap = message.data.CECap;
                    variables.CEFormer = message.data.CEFormer;
                    variables.CEPlus = message.data.CEPlus;
                    variables.CEShield = message.data.CEShield;
                    variables.CooldownExp = message.data.CooldownExp;
                    variables.Copy1 = message.data.Copy1;
                    variables.Copy2 = message.data.Copy2;
                    variables.Copy3 = message.data.Copy3;
                    variables.Copy4 = message.data.Copy4;
                    variables.CursedLevel = message.data.CursedLevel;
                    variables.CursedSpiritsKilled = message.data.CursedSpiritsKilled;
                    variables.DomainType = message.data.DomainType;
                    variables.friend_num = message.data.friend_num;
                    variables.FutureSightNumber = message.data.FutureSightNumber;
                    variables.GH = message.data.GH;
                    variables.GojoQuest = message.data.GojoQuest;
                    variables.gojosund = message.data.gojosund;
                    variables.Healed = message.data.Healed;
                    variables.HealthAttribute = message.data.HealthAttribute;
                    variables.History = message.data.History;
                    variables.HPCap = message.data.HPCap;
                    variables.ImpactFramesVariable = message.data.ImpactFramesVariable;
                    variables.ItadoriAwakening = message.data.ItadoriAwakening;
                    variables.KenjakuCT1 = message.data.KenjakuCT1;
                    variables.KenjakuCT2 = message.data.KenjakuCT2;
                    variables.Kokusen = message.data.Kokusen;
                    variables.Level = message.data.Level;
                    variables.levelrct = message.data.levelrct;
                    variables.Limb = message.data.Limb;
                    variables.locker = message.data.locker;
                    variables.Mahoraga = message.data.Mahoraga;
                    variables.MahoragaCanAdapt = message.data.MahoragaCanAdapt;
                    variables.Mastery = message.data.Mastery;
                    variables.MimicryKatana = message.data.MimicryKatana;
                    variables.Murasaki = message.data.Murasaki;
                    variables.OstVariable = message.data.OstVariable;
                    variables.Output = message.data.Output;
                    variables.OutputLevel = message.data.OutputLevel;
                    variables.CustceneDone = message.data.CustceneDone;
                    variables.Points = message.data.Points;
                    variables.pressed = message.data.pressed;
                    variables.ProfessionEXP = message.data.ProfessionEXP;
                    variables.Purple = message.data.Purple;
                    variables.QuestOutput = message.data.QuestOutput;
                    variables.RadiusDomain = message.data.RadiusDomain;
                    variables.random = message.data.random;
                    variables.RCTCount = message.data.RCTCount;
                    variables.RCTCount2 = message.data.RCTCount2;
                    variables.RCTLimitLevel = message.data.RCTLimitLevel;
                    variables.RCTMastery = message.data.RCTMastery;
                    variables.RCTRegen = message.data.RCTRegen;
                    variables.Run = message.data.Run;
                    variables.Style = message.data.Style;
                    variables.AttackNumber = message.data.AttackNumber;
                    variables.SH = message.data.SH;
                    variables.SimpleDomainLevel = message.data.SimpleDomainLevel;
                    variables.SimpleQuest = message.data.SimpleQuest;
                    variables.sokamona = message.data.sokamona;
                    variables.sp = message.data.sp;
                    variables.speedCount = message.data.speedCount;
                    variables.SpeedValue = message.data.SpeedValue;
                    variables.TimeLeft = message.data.TimeLeft;
                    variables.Timer1 = message.data.Timer1;
                    variables.Vow2 = message.data.Vow2;
                    variables.Vow3 = message.data.Vow3;
                    variables.Vow4 = message.data.Vow4;
                    variables.VowPower = message.data.VowPower;
                    variables.water = message.data.water;
                    variables.worldslashtimer = message.data.worldslashtimer;
                    variables.YutaCheck = message.data.YutaCheck;
                    variables.HistorySukuna = message.data.HistorySukuna;
                    variables.SecondTechnique = message.data.SecondTechnique;
                    variables.soka = message.data.soka;
                    variables.PointsSpirit = message.data.PointsSpirit;
                    variables.Clans = message.data.Clans;
                    variables.ClanSlot1 = message.data.ClanSlot1;
                    variables.ClanSlot2 = message.data.ClanSlot2;
                    variables.ClanSlot3 = message.data.ClanSlot3;
                    variables.Damage = message.data.Damage;
                    variables.DataSixEyesOne = message.data.DataSixEyesOne;
                    variables.Description = message.data.Description;
                    variables.Element = message.data.Element;
                    variables.KenjakuName = message.data.KenjakuName;
                    variables.MobTexture = message.data.MobTexture;
                    variables.MobTexture2 = message.data.MobTexture2;
                    variables.MobTexture3 = message.data.MobTexture3;
                    variables.Mode = message.data.Mode;
                    variables.Profession = message.data.Profession;
                    variables.QuestActive = message.data.QuestActive;
                    variables.Shadow = message.data.Shadow;
                    variables.ShadowName = message.data.ShadowName;
                    variables.SkinName1 = message.data.SkinName1;
                    variables.SkinName2 = message.data.SkinName2;
                    variables.SkinName3 = message.data.SkinName3;
                    variables.Subrace = message.data.Subrace;
                    variables.tag1 = message.data.tag1;
                    variables.tag2 = message.data.tag2;
                    variables.Team = message.data.Team;
                    variables.TeamName = message.data.TeamName;
                    variables.Technique = message.data.Technique;
                    variables.Trait = message.data.Trait;
                    variables.UUIDBattle = message.data.UUIDBattle;
                    variables.PlayerTexture = message.data.PlayerTexture;
                    variables.Moveset = message.data.Moveset;
                    variables.TrueSpeed = message.data.TrueSpeed;
                    variables.Effects = message.data.Effects;
                    variables.FingerReset = message.data.FingerReset;
                }
            });
            context.setPacketHandled(true);
        }
    }
}
