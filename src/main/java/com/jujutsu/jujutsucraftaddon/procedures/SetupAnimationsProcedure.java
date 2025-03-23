package com.jujutsu.jujutsucraftaddon.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = "jujutsucraftaddon", bus = Mod.EventBusSubscriber.Bus.MOD)
public class SetupAnimationsProcedure {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(
                new ResourceLocation("jujutsucraftaddon", "player_animation"),
                1000,
                SetupAnimationsProcedure::registerPlayerAnimations
        );
    }

    private static IAnimation registerPlayerAnimations(AbstractClientPlayer player) {
        return new ModifierLayer<>();
    }


    // Animations Named Resource workspace + animation name (Redução de bytes para 1 byte para evitar crashes)
    public enum AnimationType {

        AB_1("ab1player"),
        AB_2("ab2player"),
        AB_3("ab3player"),
        AB_4("ab4player"),
        ANIMATION_ATTACK_2("attack2"),
        ANIMATION_ATTACK_3("attack3"),
        ANIMATION_ATTACK_4("attack4"),
        ANIMATION_ATTACK_5("attack5"),
        ANIMATION_ATTACK_6("attack6"),
        ANIMATION_ATTACK_7("attack7"),
        ANIMATION_ATTACK_8("attack8"),
        ANIMATION_ATTACK_9("attack9"),
        ANIMATION_ATTACK_10("attack10"),
        ANIMATION_ATTACK_11("attack11"),
        ANIMATION_ATTACK_12("attack12"),
        ANIMATION_ATTACK_13("attack13"),
        ANIMATION_ATTACK_14("attack14"),
        ANIMATION_ATTACK_15("attack15"),
        ANIMATION_ATTACK_16("attack16"),
        ANIMATION_ATTACK_17("attack17"),
        ANIMATION_ATTACK_18("attack18"),
        ANIMATION_ATTACK_19("attack19"),
        ANIMATION_ATTACK_20("attack20"),
        ANIMATION_ATTACK_21("attack21"),
        ANIMATION_ATTACK_22("attack22"),
        ANIMATION_ATTACK_23("attack23"),
        ANIMATION_ATTACK_24("attack24"),
        ANIMATION_ATTACK_25("attack25"),
        ANIMATION_ATTACK_26("attack26"),
        ANIMATION_ATTACK_27("attack27"),
        ANIMATION_ATTACK_28("attack28"),
        ANIMATION_ATTACK_29("attack29"),
        ANIMATION_ATTACK_30("attack30"),
        ANIMATION_ATTACK_31("attack31"),
        ANIMATION_ATTACK_32("attack32"),
        ANIMATION_ATTACK_33("attack33"),
        ANIMATION_ATTACK_34("attack34"),
        ANIMATION_ATTACK_35("attack35"),
        ANIMATION_ATTACK_36("attack36"),
        ANIMATION_ATTACK_37("attack37"),
        ANIMATION_ATTACK_38("attack38"),
        ANIMATION_ATTACK_39("attack39"),
        ANIMATION_ATTACK_WS_1("worldslash1"),
        ANIMATION_ATTACK_WS_2("worldslash2"),
        ANIMATION_ATTACK_WS_3("worldslash3"),
        ANIMATION_ATTACK_WS_4("worldslash4"),
        ANIMATION_ATTACK_STAFF_1("wu1"),
        ANIMATION_ATTACK_STAFF_2("wu2"),
        ANIMATION_ATTACK_STAFF_3("wu3"),
        ANIMATION_ATTACK_STAFF_4("wu4"),
        ANIMATION_ATTACK_STAFF_5("wu5"),
        ANIMATION_ATTACK_STAFF_6("wu6"),
        ANIMATION_ATTACK_STAFF_7("wu7"),
        ANIMATION_ATTACK_STAFF_8("wu8"),
        ANIMATION_ATTACK_STAFF_9("wu9"),
        ANIMATION_ATTACK_STAFF_10("wu10"),
        ANIMATION_CURSED_FISTS("bluefist"),
        ANIMATION_DASH("dash"),
        ANIMATION_GREAT_ATTACK("greatattack"),
        ANIMATION_MURASAKI("murasaki"),
        ANIMATION_HUNT("hunt"),
        ANIMATION_SIMPLE_DOMAIN("simpledomain"),
        ANIMATION_YUDUKI("yuduki"),
        ANIMATION_TOJI_SPEAR("tojispear"),
        ANIMATION_TOJI_DOMAIN_BREAKER("tojidomainbreaker"),
        ANIMATION_FIRE_1("fire1"),
        ANIMATION_FURUBE_YURA_YURA("furubeyurayura"),
        ANIMATION_RAPID_DISMANTLE("rapiddismantle"),
        ANIMATION_SPIDER_WEB("spiderwebanim"),
        ANIMATION_MAXIMUM_3("maximum3"),
        ANIMATION_FIRE_2("fire2"),
        ANIMATION_SOKA_MONA("soka"),
        ANIMATION_NOZARASHI("nozarashishikai"),
        ANIMATION_HAKARI_DOMAIN("hakaridomain"),
        ANIMATION_GOJO_DOMAIN("infinitevoid"),
        ANIMATION_PLAYFUL("playful"),
        ANIMATION_SPEEDSWORD_1("speedsword1"),
        ANIMATION_SPEEDSWORD_2("speedsword2"),
        ANIMATION_TUCA_DONCA("tucadonca"),
        ANIMATION_LEFT_ARM_GONE("leftarmgone"),
        ANIMATION_RIGHT_ARM_RECOVER("rightarmrecover"),
        ANIMATION_LEFT_ARM_RECOVER("leftarmrecover"),
        ANIMATION_MEDITATION("meditation"),
        ANIMATION_LEFT_LEG_GONE("leftleggone"),
        ANIMATION_RIGHT_ARM_GONE("rightarmgone"),
        ANIMATION_RIGHT_LEG_GONE("rightleggone"),
        ANIMATION_MURASAKI2("murasaki2"),
        ANIMATION_RED_SKILL_2("redskill2"),
        ANIMATION_RED_SKILL_3("redskill3"),
        ANIMATION_RED_SKILL_4("redskill4"),
        ANIMATION_RED_UNLIMITED("redunlimited"),
        ANIMATION_AWAKENING_GOJO("awakeninggojo"),
        ANIMATION_BLUE_GOJO_ENCHANTED("blueenchanted"),
        ANIMATION_BLUE_GOJO_1("blue1"),
        ANIMATION_BLUE_GOJO_2("blue2"),
        ANIMATION_GOJO_BLUE("bluegojo"),
        ANIMATION_BLUE_BARRAGE("bluebarrage"),
        ANIMATION_DISMANTLE_BACK("dismantleback1"),
        ANIMATION_DISMANTLE_BACK_2("dismantleback2"),
        ANIMATION_FAINTED("fainted"),
        ANIMATION_ATTACK_KUSA_1("kusa1"),
        ANIMATION_ATTACK_KUSA_2("kusa2"),
        ANIMATION_ATTACK_KUSA_3("kusa3"),
        ANIMATION_ATTACK_KUSA_4("kusa4"),
        ANIMATION_ATTACK_KUSA_5("kusa5"),
        ANIMATION_ATTACK_KUSA_6("kusa6"),
        COUNTER_1("counterhr1"),
        COUNTER_2("counterhr2"),
        COUNTER_3("counterhr3"),
        COUNTER_4("counterhr4"),
        COUNTER_5("counterhr5"),
        COUNTER_6("counterhr6"),
        COUNTER_7("counterhr7"),
        ANIMATION_NYOI_1("nyoi1"),
        ANIMATION_NYOI_2("nyoi2"),
        ANIMATION_NYOI_3("nyoi3"),
        ANIMATION_NYOI_4("nyoi4"),
        ANIMATION_NYOI_5("nyoi5"),
        ANIMATION_NYOI_6("nyoi6"),
        ANIMATION_NYOI_7("nyoi7"),
        ANIMATION_NYOI_8("nyoi8"),
        ANIMATION_NYOI_9("nyoi9"),
        ANIMATION_SOUL_SPLIT_1("soul1"),
        ANIMATION_SOUL_SPLIT_2("soul2"),
        ANIMATION_SOUL_SPLIT_3("soul3"),
        ANIMATION_SOUL_SPLIT_4("soul4"),
        ANIMATION_SOUL_SPLIT_5("soul5"),
        ANIMATION_ATTACK_SUKUNA_1("sukuna1"),
        ANIMATION_ATTACK_SUKUNA_2("sukuna2"),
        ANIMATION_ATTACK_SUKUNA_3("sukuna3"),
        ANIMATION_ATTACK_SUKUNA_4("sukuna4"),
        ANIMATION_ATTACK_SUKUNA_5("sukuna5"),
        ANIMATION_ATTACK_SUKUNA_6("sukuna6"),
        ANIMATION_ATTACK_SUKUNA_7("sukuna7"),
        ANIMATION_ATTACK_SUKUNA_8("sukuna8"),
        ANIMATION_ATTACK_SUKUNA_9("sukuna9"),
        ANIMATION_ATTACK_SUKUNA_10("sukuna10"),
        ANIMATION_ATTACK_SUKUNA_11("sukuna11"),
        ANIMATION_ATTACK_SUKUNA_12("sukuna12"),
        ANIMATION_ATTACK_SUKUNA_13("sukuna13"),
        ANIMATION_ATTACK_SUKUNA_14("sukuna14"),
        ANIMATION_ATTACK_SUKUNA_15("sukuna15"),
        ANIMATION_ATTACK_SUKUNA_16("sukuna16"),
        ANIMATION_ATTACK_SUKUNA_17("sukuna17"),
        ANIMATION_ATTACK_SUKUNA_18("sukuna18"),
        ANIMATION_ATTACK_SUKUNA_19("sukuna19"),
        ANIMATION_ATTACK_SUKUNA_20("sukuna20"),
        ANIMATION_ATTACK_SUKUNA_21("sukuna21"),
        ANIMATION_ATTACK_SUKUNA_22("sukuna22"),
        ANIMATION_ATTACK_SUKUNA_23("sukuna23"),
        ANIMATION_ATTACK_SUKUNA_24("sukuna24"),
        ANIMATION_ATTACK_SUKUNA_25("sukuna25"),
        ANIMATION_ATTACK_SUKUNA_26("sukuna26"),
        ANIMATION_SWORD_1("sword1"),
        ANIMATION_SWORD_2("sword2"),
        ANIMATION_SWORD_3("sword3"),
        ANIMATION_SWORD_4("sword4"),
        ANIMATION_SWORD_5("sword5"),
        ANIMATION_SWORD_6("sword6"),
        ANIMATION_SWORD_7("sword7"),
        ANIMATION_SWORD_8("sword8"),
        ANIMATION_SWORD_9("sword9"),
        ANIMATION_SWORD_10("sword10"),
        ANIMATION_SWORD_11("sword11"),
        ANIMATION_SWORD_12("sword12"),
        ANIMATION_SWORD_13("sword13"),
        ANIMATION_SWORD_14("sword14"),
        ANIMATION_SWORD_15("sword15"),
        ANIMATION_SWORD_16("sword16"),
        ANIMATION_SWORD_17("sword17"),
        ANIMATION_SWORD_18("sword18"),
        ANIMATION_SWORD_19("sword19"),
        ANIMATION_SWORD_20("sword20"),
        ANIMATION_SWORD_21("sword21"),
        ANIMATION_SWORD_22("sword22"),
        ANIMATION_SWORD_23("sword23"),
        ANIMATION_SWORD_24("sword24"),
        ANIMATION_HEIAN("heianform"),
        ANIMATION_TOJI_GUN("tojigun"),
        ANIMATION_SPLIT_SOUL("splitsoulpierce"),
        ANIMATION_KASHIMO("kashimo"),
        ANIMATION_NOZARASHI_SHIKAI("nozarashishikai"),
        ANIMATION_NANAMI("nanami"),
        ANIMATION_COUNTER("counter"),
        ANIMATION_SWORD_NPC("swordnpc"),
        ANIMATION_DEFENSE_SWORD4("defensesword4"),
        ANIMATION_DEFENSE_SWORD3("defensesword3"),
        ANIMATION_DEFENSE_SWORD2("defensesword2"),
        ANIMATION_RED("red"),
        ANIMATION_RED_5("red5"),
        ANIMATION_REJECT("reject"),
        ANIMATION_CLEAVE_WEB("cleaveweb"),
        ANIMATION_BARRAGE_KICK("barragekick"),
        ANIMATION_SLICE_SUKUNA_1("sukunaslice1"),
        ANIMATION_SLICE_SUKUNA_2("sukunaslice2"),
        ANIMATION_SLICE_SUKUNA_3("sukunaslice3"),
        ANIMATION_SLICE_SUKUNA_4("sukunaslice4"),
        ANIMATION_SLICE_SUKUNA_5("sukunaslice5"),
        ANIMATION_SLICE_SUKUNA_6("sukunaslice6"),
        DODGE_1("dodge1"),
        DODGE_2("dodge2"),
        DODGE_3("dodge3"),
        DODGE_4("dodge4"),
        DODGE_5("dodge5"),
        DODGE_6("dodge6"),
        DODGE_7("dodge7"),
        DODGE_8("dodge8"),
        DODGE_9("dodge9"),
        DODGE_10("dodge10"),
        DODGE_11("dodge11"),
        DODGE_12("dodge12"),
        DODGE_13("dodge13"),
        DODGE_14("dodge14"),
        DODGE_15("dodge15"),
        DODGE_16("dodge16"),
        DODGE_17("dodge17"),
        DODGE_18("dodge18"),
        DODGE_19("dodge19"),
        DODGE_20("dodge20"),
        DODGE_21("dodge21");

        private final String animationString;


        AnimationType(String animationString) {
            this.animationString = animationString;
        }

        public String getAnimationString() {
            return animationString.toLowerCase();
        }

        // Method to convert string back to enum constant
        public static AnimationType fromString(String animationString) {
            for (AnimationType type : AnimationType.values()) {
                if (type.getAnimationString().equalsIgnoreCase(animationString)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("No enum constant found for " + animationString);
        }

    }
}