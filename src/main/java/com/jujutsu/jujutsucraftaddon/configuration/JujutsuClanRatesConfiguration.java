package com.jujutsu.jujutsucraftaddon.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class JujutsuClanRatesConfiguration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Double> SUKUNA;
    public static final ForgeConfigSpec.ConfigValue<Double> KENJAKU;
    public static final ForgeConfigSpec.ConfigValue<Double> GOJO;
    public static final ForgeConfigSpec.ConfigValue<Double> REJECTEDZENIN;
    public static final ForgeConfigSpec.ConfigValue<Double> ITADORI;
    public static final ForgeConfigSpec.ConfigValue<Double> FUJIWARA;
    public static final ForgeConfigSpec.ConfigValue<Double> SUGAWARA;
    public static final ForgeConfigSpec.ConfigValue<Double> HAKARI;
    public static final ForgeConfigSpec.ConfigValue<Double> URAUME;
    public static final ForgeConfigSpec.ConfigValue<Double> HIGURUMA;
    public static final ForgeConfigSpec.ConfigValue<Double> OKKOTSU;
    public static final ForgeConfigSpec.ConfigValue<Double> WU;
    public static final ForgeConfigSpec.ConfigValue<Double> KASHIMO;
    public static final ForgeConfigSpec.ConfigValue<Double> TSUKUMO;
    public static final ForgeConfigSpec.ConfigValue<Double> ZENIN;
    public static final ForgeConfigSpec.ConfigValue<Double> ABE;
    public static final ForgeConfigSpec.ConfigValue<Double> KAMO;
    public static final ForgeConfigSpec.ConfigValue<Double> FUSHIGURO;
    public static final ForgeConfigSpec.ConfigValue<Double> INUMAKI;
    public static final ForgeConfigSpec.ConfigValue<Double> GETO;

    static {
        BUILDER.push("Jujutsu Rates");
        SUKUNA = BUILDER.comment("Sukuna Chance Variable").define("Sukuna", 0.004);
        KENJAKU = BUILDER.comment("Kenjaku Chance Variable").define("Kenjaku", 0.005);
        GOJO = BUILDER.comment("Gojo Chance Variable").define("Gojo", 0.006);
        REJECTEDZENIN = BUILDER.comment("Rejected Zenin Chance Variable").define("RejectedZenin", 0.007);
        ITADORI = BUILDER.comment("Itadori Chance Variable").define("Itadori", 0.008);
        FUJIWARA = BUILDER.comment("Fujiwara Chance Variable").define("Fujiwara", 0.01);
        SUGAWARA = BUILDER.comment("Sugawara Chance Variable").define("Sugawara", 0.015);
        HAKARI = BUILDER.comment("Hakari Chance Variable").define("Hakari", 0.02);
        URAUME = BUILDER.comment("Uraume Chance Variable").define("Uraume", 0.025);
        HIGURUMA = BUILDER.comment("Higuruma Chance Variable").define("Higuruma", 0.03);
        OKKOTSU = BUILDER.comment("Okkotsu Chance Variable").define("Okkotsu", 0.04);
        WU = BUILDER.comment("Uraume Chance Variable").define("Wu", 0.1);
        KASHIMO = BUILDER.comment("Kashimo Chance Variable").define("Kashimo", 0.12);
        TSUKUMO = BUILDER.comment("Tsukumo Chance Variable").define("Tsukumo", 0.15);
        ZENIN = BUILDER.comment("Zenin Chance Variable").define("Zenin", 0.3);
        ABE = BUILDER.comment("Abe Chance Variable").define("Abe", 0.45);
        KAMO = BUILDER.comment("Kamo Chance Variable").define("Kamo", 0.55);
        FUSHIGURO = BUILDER.comment("Fushiguro Chance Variable").define("Fushiguro", 0.66);
        INUMAKI = BUILDER.comment("Inumaki Chance Variable").define("Inumaki", 0.77);
        GETO = BUILDER.comment("Geto Chance Variable").define("Geto", 0.89);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
