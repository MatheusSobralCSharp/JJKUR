package com.jujutsu.jujutsucraftaddon.archived;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class GenericArmorLayerJJK<T extends LivingEntity & GeoAnimatable> extends ItemArmorGeoLayer<T> {
    public GenericArmorLayerJJK(GeoEntityRenderer<T> geoRenderer) {
        super(geoRenderer);
    }

    @Nullable
    protected ItemStack getArmorItemForBone(GeoBone bone, T animatable) {
        switch (bone.getName()) {
            case "LeftLeg2":
            case "RightLeg2":
            case "armorLeftBoot":
            case "armorRightBoot":
                return this.bootsStack;
            case "LeftLeg":
            case "RightLeg":
            case "armorLeftLeg":
            case "armorRightLeg":
                return this.leggingsStack;
            case "Body":
            case "LeftArm":
            case "RightArm":
            case "armorBody":
            case "armorLeftArm":
            case "armorRightArm":
                return this.chestplateStack;
            case "Head":
            case "hat":
            case "armorHead":
                return this.helmetStack;
            default:
                return null;
        }
    }

    @Nonnull
    protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, T animatable) {
        switch (bone.getName()) {
            case "LeftLeg2":
            case "RightLeg2":
            case "armorLeftBoot":
            case "armorRightBoot":
                return EquipmentSlot.FEET;
            case "LeftLeg":
            case "armorLeftLeg":
                return EquipmentSlot.LEGS;
            case "Body":
            case "armorBody":
                return EquipmentSlot.CHEST;
            case "Head":
            case "armorHead":
                return EquipmentSlot.HEAD;
            default:
                return super.getEquipmentSlotForBone(bone, stack, animatable);
        }
    }

    @Nonnull
    protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, T animatable, HumanoidModel<?> baseModel) {
        switch (bone.getName()) {
            case "LeftLeg":
            case "LeftLeg2":
            case "armorLeftLeg":
            case "armorLeftBoot":
                return baseModel.leftLeg;
            case "RightLeg":
            case "RightLeg2":
            case "armorRightLeg":
            case "armorRightBoot":
                return baseModel.rightLeg;
            case "RightArm":
            case "armorRightArm":
                return baseModel.rightArm;
            case "LeftArm":
            case "armorLeftArm":
                return baseModel.leftArm;
            case "Body":
            case "armorBody":
                return baseModel.body;
            case "Head":
            case "hat":
            case "armorHead":
                return baseModel.head;
            default:
                return super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
        }
    }
}
