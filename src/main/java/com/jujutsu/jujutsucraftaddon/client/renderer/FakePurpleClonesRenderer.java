package com.jujutsu.jujutsucraftaddon.client.renderer;

import com.jujutsu.jujutsucraftaddon.archived.GenericArmorLayerJJK;
import com.jujutsu.jujutsucraftaddon.archived.GenericItemLayerJJK;
import com.jujutsu.jujutsucraftaddon.entity.FakePurpleClonesEntity;
import com.jujutsu.jujutsucraftaddon.entity.layer.CloneLayer;
import com.jujutsu.jujutsucraftaddon.entity.model.FakePurpleClonesModel;
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

public class FakePurpleClonesRenderer extends GeoEntityRenderer<FakePurpleClonesEntity> {
    private static final MinecraftSessionService sessionService = Minecraft.getInstance().getMinecraftSessionService();
    private static final ResourceLocation LAYER = new ResourceLocation("jujutsucraftaddon", "textures/entities/steve2.png");
    private final TextureManager textureManager = Minecraft.getInstance().getTextureManager();
    private static final ResourceLocation  ResourceLocation = new ResourceLocation("jujutsucraftaddon","geo/human1.geo.json");
    private GeoModel<FakePurpleClonesEntity> currentModel;
    private LivingEntity entity = animatable;

    public FakePurpleClonesRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FakePurpleClonesModel());
        this.shadowRadius = 0.5f;
        this.addRenderLayer(new CloneLayer(this));
        this.addRenderLayer(new GenericArmorLayerJJK<>(this));
        this.addRenderLayer(new GenericItemLayerJJK<>(this));

    }

    @Override
    public ResourceLocation getTextureLocation(FakePurpleClonesEntity entity) {
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
    public RenderType getRenderType(FakePurpleClonesEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void preRender(PoseStack poseStack, FakePurpleClonesEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

//    @Override
//    public void render(FakePurpleClonesEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
//        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
//    }
//
//    private GeoModel<FakePurpleClonesEntity> getModel(UUID uuid) {
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

class FakePurpleClonesRenderer2 extends BlockAndItemGeoLayer<FakePurpleClonesEntity> {

    private final FakePurpleClonesRenderer FakePurpleClonesRenderer;

    public FakePurpleClonesRenderer2(FakePurpleClonesRenderer FakePurpleClonesRenderer, GeoRenderer<FakePurpleClonesEntity> renderer) {
        super(renderer);
        this.FakePurpleClonesRenderer = FakePurpleClonesRenderer;
    }

    @Nullable
    @Override
    protected ItemStack getStackForBone(GeoBone bone, FakePurpleClonesEntity animatable) {
        return switch (bone.getName()) {
            case "HandLeft" -> FakePurpleClonesRenderer.getAnimatable().getMainHandItem();
            case "HandRight" -> FakePurpleClonesRenderer.getAnimatable().getOffhandItem();
            default -> null;
        };
    }

    @Override
    protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, FakePurpleClonesEntity animatable) {
        return switch (bone.getName()) {
            case "HandLeft", "HandRight" -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            default -> ItemDisplayContext.NONE;
        };
    }

    @Override
    protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, FakePurpleClonesEntity animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
        if (stack.equals(FakePurpleClonesRenderer.getAnimatable().getMainHandItem())) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.125, -0.25);
            }
        } else if (stack.equals(FakePurpleClonesRenderer.getAnimatable().getOffhandItem())) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.125, 0.25);
                poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            }
        }

        super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
    }
}

class FakePurpleClonesRenderer3 extends ItemArmorGeoLayer<FakePurpleClonesEntity> {
    private final FakePurpleClonesRenderer FakePurpleClonesRenderer2;

    public FakePurpleClonesRenderer3(FakePurpleClonesRenderer FakePurpleClonesRenderer2, GeoRenderer<FakePurpleClonesEntity> geoRenderer) {
        super(geoRenderer);
        this.FakePurpleClonesRenderer2 = FakePurpleClonesRenderer2;
    }

    @Nullable
    protected ItemStack getArmorItemForBone(GeoBone bone, FakePurpleClonesEntity animatable) {
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
    protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, FakePurpleClonesEntity animatable) {
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
    protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, FakePurpleClonesEntity animatable, HumanoidModel<?> baseModel) {
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