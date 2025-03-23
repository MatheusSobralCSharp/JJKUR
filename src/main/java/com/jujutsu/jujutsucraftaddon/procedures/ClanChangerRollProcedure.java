package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.configuration.JujutsuClanRatesConfiguration;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.jujutsu.jujutsucraftaddon.world.inventory.ClanChangeMenu;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ClanChangerRollProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (Math.random() < JujutsuClanRatesConfiguration.SUKUNA.get()) {
            {
                String _setval = "Sukuna";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            {
                double _setval = Mth.nextInt(RandomSource.create(), 10, 20);
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.BFChance = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.KENJAKU.get()) {
            {
                String _setval = "Kenjaku";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.GOJO.get()) {
            {
                String _setval = "Gojo";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            {
                double _setval = Mth.nextInt(RandomSource.create(), 10, 20);
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.BFChance = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.REJECTEDZENIN.get()) {
            {
                String _setval = "Rejected Zenin";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.ITADORI.get()) {
            {
                String _setval = "Itadori";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            {
                double _setval = Mth.nextInt(RandomSource.create(), 10, 20);
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.BFChance = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.FUJIWARA.get()) {
            {
                String _setval = "Fujiwara";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.SUGAWARA.get()) {
            {
                String _setval = "Sugawara";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.HAKARI.get()) {
            {
                String _setval = "Hakari";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.URAUME.get()) {
            {
                String _setval = "Uraume";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.HIGURUMA.get()) {
            {
                String _setval = "Higuruma";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.OKKOTSU.get()) {
            {
                String _setval = "Okkotsu";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.WU.get()) {
            {
                String _setval = "Wu";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.KASHIMO.get()) {
            {
                String _setval = "Kashimo";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.TSUKUMO.get()) {
            {
                String _setval = "Tsukumo";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.ZENIN.get()) {
            {
                String _setval = "Zenin";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.ABE.get()) {
            {
                String _setval = "Abe";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.KAMO.get()) {
            {
                String _setval = "Kamo";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.FUSHIGURO.get()) {
            {
                String _setval = "Fushiguro";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.INUMAKI.get()) {
            {
                String _setval = "Inumaki";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (Math.random() < JujutsuClanRatesConfiguration.GETO.get()) {
            {
                String _setval = "Geto";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Clans = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
        ClanInformationProcedure.execute(entity);
        if (entity instanceof Player _player) {
            ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.CLAN_CHANGER.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
        }
        if (entity instanceof Player _plr24 && _plr24.containerMenu instanceof ClanChangeMenu) {
            if (entity instanceof Player _player)
                _player.closeContainer();
        }
    }
}
