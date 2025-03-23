package com.jujutsu.jujutsucraftaddon.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class JogoatConfiguration {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Double> GOJO;
    public static final ForgeConfigSpec.ConfigValue<Double> GETO;
    public static final ForgeConfigSpec.ConfigValue<Double> FUSHIGURO;
    public static final ForgeConfigSpec.ConfigValue<Double> MAKI;
    public static final ForgeConfigSpec.ConfigValue<Double> SUKUNA;
    public static final ForgeConfigSpec.ConfigValue<Double> INUMAKI;
    public static final ForgeConfigSpec.ConfigValue<Double> OKKOTSU;
    public static final ForgeConfigSpec.ConfigValue<Double> JOGO;
    public static final ForgeConfigSpec.ConfigValue<Double> KASHIMO;
    public static final ForgeConfigSpec.ConfigValue<Double> DAGON;
    public static final ForgeConfigSpec.ConfigValue<Double> TSUKUMO;
    public static final ForgeConfigSpec.ConfigValue<Double> CHOSO;
    public static final ForgeConfigSpec.ConfigValue<Double> MEIMEI;
    public static final ForgeConfigSpec.ConfigValue<Double> ISHIGORI;
    public static final ForgeConfigSpec.ConfigValue<Double> NANAMI;
    public static final ForgeConfigSpec.ConfigValue<Double> HANAMI;
    public static final ForgeConfigSpec.ConfigValue<Double> MAHITO;
    public static final ForgeConfigSpec.ConfigValue<Double> MAHORAGA;
    public static final ForgeConfigSpec.ConfigValue<Double> TAKABA;
    public static final ForgeConfigSpec.ConfigValue<Double> NAOYA;
    public static final ForgeConfigSpec.ConfigValue<Double> TODO;
    public static final ForgeConfigSpec.ConfigValue<Double> ITADORI;
    public static final ForgeConfigSpec.ConfigValue<Double> JINICHI;
    public static final ForgeConfigSpec.ConfigValue<Double> KUROURUSHI;
    public static final ForgeConfigSpec.ConfigValue<Double> URAUME;
    public static final ForgeConfigSpec.ConfigValue<Double> OGI;
    public static final ForgeConfigSpec.ConfigValue<Double> HIGURUMA;
    public static final ForgeConfigSpec.ConfigValue<Double> ANGEL;
    public static final ForgeConfigSpec.ConfigValue<Double> HAKARI;
    public static final ForgeConfigSpec.ConfigValue<Double> MIGUEL;
    public static final ForgeConfigSpec.ConfigValue<Double> KUSAKABE;
    public static final ForgeConfigSpec.ConfigValue<Double> CHOJURO;
    public static final ForgeConfigSpec.ConfigValue<Double> YAGA;
    public static final ForgeConfigSpec.ConfigValue<Double> KUGISAKI;
    public static final ForgeConfigSpec.ConfigValue<Double> JUNPE;
    public static final ForgeConfigSpec.ConfigValue<Double> NISHIMIYA;
    public static final ForgeConfigSpec.ConfigValue<Double> DHRUV;
    public static final ForgeConfigSpec.ConfigValue<Double> YOROZU;
    public static final ForgeConfigSpec.ConfigValue<Double> TAKAKOURO;
    public static final ForgeConfigSpec.ConfigValue<Double> SMALLPOXDEITY;
    public static final ForgeConfigSpec.ConfigValue<Double> INO;
    public static final ForgeConfigSpec.ConfigValue<Double> KAORI;

    static {
        BUILDER.push("Jujutsu Random Rates");
        GOJO = BUILDER.comment("Gojo").define("Gojo", (double) 1);
        GETO = BUILDER.comment("Geto").define("Geto", (double) 3);
        FUSHIGURO = BUILDER.comment("Fushiguro").define("Fushiguro", (double) 4);
        MAKI = BUILDER.comment("Maki").define("Maki", (double) 5);
        SUKUNA = BUILDER.comment("Sukuna").define("Sukuna", (double) 2);
        INUMAKI = BUILDER.comment("Inumaki").define("Inumaki", (double) 6);
        OKKOTSU = BUILDER.comment("Okkotsu").define("Okkotsu", (double) 7);
        JOGO = BUILDER.comment("Jogo").define("Jogo", (double) 8);
        KASHIMO = BUILDER.comment("Kashimo").define("Kashimo", (double) 9);
        DAGON = BUILDER.comment("Dagon").define("Dagon", (double) 10);
        TSUKUMO = BUILDER.comment("Tsukumo").define("Tsukumo", (double) 11);
        CHOSO = BUILDER.comment("Choso").define("Choso", (double) 12);
        MEIMEI = BUILDER.comment("Meimei").define("MeiMei", (double) 13);
        ISHIGORI = BUILDER.comment("Ishigori").define("Ishigori", (double) 14);
        NANAMI = BUILDER.comment("Nanami").define("Nanami", (double) 15);
        HANAMI = BUILDER.comment("Hanami").define("Hanami", (double) 16);
        MAHITO = BUILDER.comment("Mahito").define("Mahito", (double) 17);
        MAHORAGA = BUILDER.comment("Mahoraga").define("Mahoraga", (double) 18);
        TAKABA = BUILDER.comment("Takaba").define("Takaba", (double) 19);
        NAOYA = BUILDER.comment("Naoya").define("Naoya", (double) 20);
        TODO = BUILDER.comment("Todo").define("Todo", (double) 21);
        ITADORI = BUILDER.comment("Itadori").define("Itadori", (double) 22);
        JINICHI = BUILDER.comment("Jinichi").define("Jinichi", (double) 23);
        KUROURUSHI = BUILDER.comment("Kurourushi").define("Kurourushi", (double) 24);
        URAUME = BUILDER.comment("Uraume").define("Uraume", (double) 25);
        OGI = BUILDER.comment("Ogi").define("Ogi", (double) 26);
        HIGURUMA = BUILDER.comment("Higuruma").define("Higuruma", (double) 27);
        ANGEL = BUILDER.comment("Angel").define("Angel", (double) 28);
        HAKARI = BUILDER.comment("Hakari").define("Hakari", (double) 29);
        MIGUEL = BUILDER.comment("Miguel").define("Miguel", (double) 30);
        KUSAKABE = BUILDER.comment("Kusakabe").define("Kusakabe", (double) 31);
        CHOJURO = BUILDER.comment("Chojuro").define("Chojuro", (double) 32);
        YAGA = BUILDER.comment("Yaga").define("Yaga", (double) 33);
        KUGISAKI = BUILDER.comment("Kugisaki").define("Kugisaki", (double) 34);
        JUNPE = BUILDER.comment("Junpei").define("Junpei", (double) 35);
        NISHIMIYA = BUILDER.comment("Nishimiya").define("Nishimiya", (double) 36);
        DHRUV = BUILDER.comment("Dhruv").define("Dhruv", (double) 37);
        YOROZU = BUILDER.comment("Yorozu").define("Yorozu", (double) 38);
        TAKAKOURO = BUILDER.comment("Uro").define("TakakoUro", (double) 39);
        SMALLPOXDEITY = BUILDER.comment("SmallPox").define("SmallpoxDeity", (double) 40);
        INO = BUILDER.comment("Ino Chance").define("Ino Takuma", (double) 41);
        KAORI = BUILDER.comment("Kaori").define("Kaori", (double) 42);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

}
