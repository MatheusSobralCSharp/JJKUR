package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.Scoreboard;

public class GojoRampageOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double particleRadius = 0;
        double particleAmount = 0;
        if (new Object() {
            public int getScore(String score, Entity _ent) {
                Scoreboard _sc = _ent.level().getScoreboard();
                Objective _so = _sc.getObjective(score);
                if (_so != null)
                    return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
                return 0;
            }
        }.getScore("CTNumber", entity) != 2) {
            for (int index0 = 0; index0 < 1; index0++) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~ ~ ~5 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~ ~ ~-5 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~5 ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~-5 ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~2 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~3 ~ ~2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~-3 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~-3 ~ ~2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~3 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(
                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                        _ent.level().getServer(), _ent),
                                "execute as @s run summon jujutsucraft:blue ~-2 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
                    }
                }
                break;
            }
            particleAmount = 1;
            particleRadius = 5;
            for (int index1 = 0; index1 < (int) particleAmount; index1++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.BLUE_PUNCH.get(), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
                        (y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
            }
            for (int index2 = 0; index2 < (int) particleAmount; index2++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.BLUE_PUNCH.get(), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
                        (y + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)),
                        (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)), (Mth.nextDouble(RandomSource.create(), -0.001, 0.001)));
            }
            for (int index3 = 0; index3 < (int) particleAmount; index3++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.THUNDER_BLUEE.get(), (x + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius),
                        (y + 0 + Mth.nextDouble(RandomSource.create(), 1, 2) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * particleRadius), 0, 0, 0);
            }
            for (int index4 = 0; index4 < (int) particleAmount; index4++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get(), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
                        (y + 0 + Mth.nextDouble(RandomSource.create(), 0.3, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), 1, 1) * particleRadius), 0, 0, 0);
            }
            for (int index5 = 0; index5 < (int) particleAmount; index5++) {
                world.addParticle(JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * particleRadius),
                        (y + 0 + Mth.nextDouble(RandomSource.create(), 0.3, 1) * particleRadius), (z + 0 + Mth.nextDouble(RandomSource.create(), 1, 1) * particleRadius), 0, 0, 0);
            }
        }
    }
}
