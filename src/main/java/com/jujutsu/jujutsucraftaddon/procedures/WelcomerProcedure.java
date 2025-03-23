package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class WelcomerProcedure {
    @SubscribeEvent
    public static void onAdvancement(AdvancementEvent event) {
        execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getAdvancement(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
        execute(null, world, x, y, z, advancement, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Advancement advancement, Entity entity) {
        if (advancement == null || entity == null || event == null)
            return;

        if (!(world instanceof Level _lvl0 && _lvl0.getServer() != null && Objects.equals(_lvl0.getServer().getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:are_you_satoru_gojo")), advancement))) {
            if (world instanceof Level _lvl0 && _lvl0.getServer() != null && Objects.equals(_lvl0.getServer().getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:start_jujutsu_craft")), advancement)) {
                if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:welcome_to_jujutsu_plus")))).isDone())) {
                    if (entity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:welcome_to_jujutsu_plus"));
                        assert _adv != null;
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                    if (entity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                    if (entity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RACE_CHANGER.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                    if (entity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.CELLPHONE.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                    if (entity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.PROFESSION.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }
                    if (entity instanceof Player _player) {
                        ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get()).copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                    }


                    if (Math.random() <= 0.0001) {
                        {
                            String _setval = "Perfect Vessel";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Subrace = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }

                    if (Math.random() <= 0.00001) {
                        {
                            String _setval = "The Fallen One";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.0001) {
                        {
                            String _setval = "The Honored One";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.05) {
                        {
                            String _setval = "Gifted";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.1) {
                        {
                            String _setval = "Cursed";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.2) {
                        {
                            String _setval = "Speedy";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.3) {
                        {
                            String _setval = "Strong";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.4) {
                        {
                            String _setval = "Resistant";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (Math.random() <= 0.5) {
                        {
                            String _setval = "Healthy";
                            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.Trait = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }

                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Welcome To JujutsuCraft Ultimate, I Hope you Enjoy"), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Credits: "), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§dStaffs: HusseinDong, MichaelAstrea, YouShouldAim, Hakari, Ironfist4657, TemiZilla, Rain(rainrememberade), Radari, UraumeTheCooker, ThatOneGuyTOG, Yami, Electro, Rosa Park, Manifestival, Giblet, CinOfPride, Jakson, M7mdosh, Knovius"), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§cDevs That Helped Me in the path: Xopi, Obama, Acery, Kujira, SaltyFrappuccino "), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§bSupporters: Chase, JL_PN, Pipe, StoneCoyote, Widgitcube, Coldshroud, Amgosu, Jydon, Kain, Nekocomrade, Peanutscout62, PoisonousNut, Quillther, Goomba, Absynthe, Zestiis, Saber (vados132), Sam_thing"), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§aArtists: Szei_art (szei_creator), JL_PN, Corvo, MalieHunsen, Gumelthemodeler, AidenMz, Maria, EGOATmeal, bred guy?, Daichi, Marvin031"), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§l§4Special Thanks: TechnoDagger, Shiro, Jão & Spacey & Sly & Billion ( Trello Makers )"), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§l§0In Memoriam: Akira Toriyama, Hyoryu Kyoshitsu, Hakari Family Member "), false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("§lYoutubers I would to thank everyone, don't know who played but here is some: 1ronkk, Shiny, Blakebolt, Bruno Diego, Ik there is more"), false);
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dandankokoro"))), SoundSource.MUSIC, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dandankokoro"))), SoundSource.MUSIC, 1, 1, false);
                        }
                    }
                    {
                        double _setval = (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? Objects.requireNonNull(_livingEntity12.getAttribute(Attributes.MAX_HEALTH)).getBaseValue() : 0);
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.HealthAttribute = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }
            }
        }
    }
}
