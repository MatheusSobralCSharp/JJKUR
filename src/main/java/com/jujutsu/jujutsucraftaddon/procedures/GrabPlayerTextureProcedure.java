package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

public class GrabPlayerTextureProcedure {
    public static void execute(Entity entity) {
        if (!(entity instanceof ServerPlayer player)) {
            return;
        }

        // Fetch the player's UUID
        UUID uuid = player.getUUID();

        // Fetch the session service to retrieve textures
        MinecraftSessionService sessionService = player.server.getSessionService();
        GameProfile profile = new GameProfile(uuid, null);
        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> textures =
                sessionService.getTextures(sessionService.fillProfileProperties(profile, false), false);

        String texturePath;

        // If the texture exists, process and store it
        if (textures.containsKey(MinecraftProfileTexture.Type.SKIN)) {
            MinecraftProfileTexture profileTexture = textures.get(MinecraftProfileTexture.Type.SKIN);
            String skinUrl = profileTexture.getUrl();
            String skinHash = profileTexture.getHash();
            ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash);
            File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
            File skinFile = new File(skinDir, skinHash + ".png");

            // Ensure skin directory exists
            if (!skinDir.exists()) {
                skinDir.mkdirs();
            }

            // Download the skin if it does not exist
            if (!skinFile.exists()) {
                try {
                    downloadSkin(skinUrl, skinFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    texturePath = DefaultPlayerSkin.getDefaultSkin(uuid).toString();
                }
            }

            texturePath = resourceLocation.toString();
        } else {
            // Fallback to default skin
            texturePath = DefaultPlayerSkin.getDefaultSkin(uuid).toString();
        }

        // Store the texture path in the capability
        String finalTexturePath = texturePath;
        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            capability.PlayerTexture = finalTexturePath;
            capability.syncPlayerVariables(entity);
        });
    }

    private static void downloadSkin(String skinUrl, File skinFile) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(skinUrl).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (var inputStream = connection.getInputStream()) {
            Files.copy(inputStream, skinFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } finally {
            connection.disconnect();
        }
    }
}

