package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.entity.ErroEntity;
import com.jujutsu.jujutsucraftaddon.entity.layer.ErroLayer;
import com.jujutsu.jujutsucraftaddon.entity.model.ErroModel;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ErroRenderer extends GeoEntityRenderer<ErroEntity> {
    private static final MinecraftSessionService sessionService = Minecraft.getInstance().getMinecraftSessionService();
    private final TextureManager textureManager = Minecraft.getInstance().getTextureManager();
    private final GeoModel<ErroEntity> slimModel;
    private final GeoModel<ErroEntity> defaultModel;
    private GeoModel<ErroEntity> currentModel;

    public ErroRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ErroModel());
        this.shadowRadius = 0.5f;
        this.addRenderLayer(new ErroLayer(this));
        this.addRenderLayer(new ErroRenderer2(this, this));
        this.addRenderLayer(new ErroRenderer3(this, this));
        this.slimModel = new ErroModel();
        this.defaultModel = new ErroModel();
        this.currentModel = this.defaultModel;
    }

    @Override
    public ResourceLocation getTextureLocation(ErroEntity entity) {
        if (entity.getOwnerUUID() != null) {
            LivingEntity livingEntity = entity.getOwner();
            if (livingEntity != null) {
                EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
                return livingRenderer.getTextureLocation(livingEntity);
            }
        }

        return new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");
    }

    @Override
    public RenderType getRenderType(ErroEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, ErroEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

//    @Override
//    public void render(ErroEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
//        if (entity.getOwnerUUID() != null) {
//            UUID ownerUUID = entity.getOwnerUUID();
//            this.currentModel = getModel(ownerUUID);
//        }
//        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
//    }
//
//    private GeoModel<ErroEntity> getModel(UUID uuid) {
//        boolean isSlim = isSlimSkin(uuid);
//        return isSlim ? slimModel : defaultModel;
//    }
//
//    private ResourceLocation getPlayerSkin(UUID uuid) {
//        GameProfile profile = new GameProfile(uuid, null);
//        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> textures = sessionService.getTextures(sessionService.fillProfileProperties(profile, false), false);
//        if (textures.containsKey(MinecraftProfileTexture.Type.SKIN)) {
//            MinecraftProfileTexture profileTexture = textures.get(MinecraftProfileTexture.Type.SKIN);
//            String skinUrl = profileTexture.getUrl();
//            String skinHash = profileTexture.getHash();
//            ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash);
//            File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
//            File skinFile = new File(skinDir, skinHash + ".png");
//            if (!skinDir.exists()) {
//                skinDir.mkdirs();
//            }
//            if (!skinFile.exists()) {
//                try {
//                    downloadSkin(skinUrl, skinFile);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return DefaultPlayerSkin.getDefaultSkin(uuid);
//                }
//            }
//            // Register the texture with Minecraft's texture manager using HttpTexture
//            HttpTexture httpTexture = new HttpTexture(skinFile, skinUrl, DefaultPlayerSkin.getDefaultSkin(uuid), false, null);
//            textureManager.register(resourceLocation, httpTexture);
//            return resourceLocation;
//        } else {
//            return DefaultPlayerSkin.getDefaultSkin(uuid);
//        }
//    }
//
//    private void downloadSkin(String skinUrl, File skinFile) throws IOException {
//        HttpURLConnection connection = (HttpURLConnection) new URL(skinUrl).openConnection();
//        connection.setRequestMethod("GET");
//        connection.setConnectTimeout(5000);
//        connection.setReadTimeout(5000);
//        try (InputStream inputStream = connection.getInputStream()) {
//            Files.copy(inputStream, skinFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } finally {
//            connection.disconnect();
//        }
//    }
//
//    private boolean isSlimSkin(UUID uuid) {
//        GameProfile profile = new GameProfile(uuid, null);
//        profile = sessionService.fillProfileProperties(profile, false);
//        if (profile.getProperties().containsKey("textures")) {
//            for (Property property : profile.getProperties().get("textures")) {
//                String value = new String(java.util.Base64.getDecoder().decode(property.getValue()));
//                if (value.contains("\"slim\"")) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//}


}

class ErroRenderer2 extends BlockAndItemGeoLayer<ErroEntity> {

    private final ErroRenderer erroRenderer;

    public ErroRenderer2(ErroRenderer erroRenderer, GeoRenderer<ErroEntity> renderer) {
        super(renderer);
        this.erroRenderer = erroRenderer;
    }

    @Nullable
    @Override
    protected ItemStack getStackForBone(GeoBone bone, ErroEntity animatable) {
        return switch (bone.getName()) {
            case "HandLeft" -> erroRenderer.getAnimatable().getMainHandItem();
            case "HandRight" -> erroRenderer.getAnimatable().getOffhandItem();
            default -> null;
        };
    }

    @Override
    protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, ErroEntity animatable) {
        return switch (bone.getName()) {
            case "HandLeft", "HandRight" -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            default -> ItemDisplayContext.NONE;
        };
    }

    @Override
    protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, ErroEntity animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
        if (stack.equals(erroRenderer.getAnimatable().getMainHandItem())) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.125, -0.25);
            }
        } else if (stack.equals(erroRenderer.getAnimatable().getOffhandItem())) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.125, 0.25);
                poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            }
        }

        super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
    }
}

class ErroRenderer3 extends ItemArmorGeoLayer<ErroEntity> {
    private final ErroRenderer erroRenderer2;

    public ErroRenderer3(ErroRenderer erroRenderer2, GeoRenderer<ErroEntity> geoRenderer) {
        super(geoRenderer);
        this.erroRenderer2 = erroRenderer2;
    }

    @Nullable
    protected ItemStack getArmorItemForBone(GeoBone bone, ErroEntity animatable) {
        ItemStack var10000;
        switch (bone.getName()) {
            case "armorLeftFoot":
            case "armorRightFoot":
            case "left_leg_boot":
            case "right_leg_boot":
                var10000 = this.bootsStack;
                break;
            case "armorLeftLeg":
            case "armorRightLeg":
                var10000 = this.leggingsStack;
                break;
            case "armorBody":
            case "armorArmRight":
            case "armorArmLeft":
                var10000 = this.chestplateStack;
                break;
            case "armorHead":
                var10000 = this.helmetStack;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    @Nonnull
    protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, ErroEntity animatable) {
        EquipmentSlot var10000;
        switch (bone.getName()) {
            case "armorLeftFoot":
            case "armorRightFoot":
            case "left_leg_boot":
            case "right_leg_boot":
                var10000 = EquipmentSlot.FEET;
                break;
            case "armorLeftLeg":
            case "armorRightLeg":
                var10000 = EquipmentSlot.LEGS;
                break;
            case "armorArmRight":
                var10000 = EquipmentSlot.MAINHAND;
                break;
            case "armorArmLeft":
                var10000 = EquipmentSlot.OFFHAND;
                break;
            case "armorBody":
                var10000 = EquipmentSlot.CHEST;
                break;
            case "armorHead":
                var10000 = EquipmentSlot.HEAD;
                break;
            default:
                var10000 = super.getEquipmentSlotForBone(bone, stack, animatable);
        }

        return var10000;
    }

    @Nonnull
    protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, ErroEntity animatable, HumanoidModel<?> baseModel) {
        ModelPart var10000;
        if ((ForgeRegistries.ITEMS.getKey(((Object) animatable instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()).toString()).contains("zenin_boot") || ((ForgeRegistries.ITEMS.getKey(((Object) animatable instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()).toString()).contains("zenin_boot"))) {
            switch (bone.getName()) {
                case "armorLeftLeg":
                case "left_leg_boot":
                    var10000 = baseModel.leftLeg;
                    break;
                case "armorRightLeg":
                case "right_leg_boot":
                    var10000 = baseModel.rightLeg;
                    break;
                case "armorArmRight":
                    var10000 = baseModel.rightArm;
                    break;
                case "armorArmLeft":
                    var10000 = baseModel.leftArm;
                    break;
                case "armorBody":
                    var10000 = baseModel.body;
                    break;
                case "armorHead":
                    var10000 = baseModel.head;
                    break;
                default:
                    var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
            }
            return var10000;
        } else {
            switch (bone.getName()) {
                case "armorLeftFoot":
                case "armorLeftLeg":
                    var10000 = baseModel.leftLeg;
                    break;
                case "armorRightFoot":
                case "armorRightLeg":
                    var10000 = baseModel.rightLeg;
                    break;
                case "armorArmRight":
                    var10000 = baseModel.rightArm;
                    break;
                case "armorArmLeft":
                    var10000 = baseModel.leftArm;
                    break;
                case "armorBody":
                    var10000 = baseModel.body;
                    break;
                case "armorHead":
                    var10000 = baseModel.head;
                    break;
                default:
                    var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
            }
        }
        return var10000;
    }
}