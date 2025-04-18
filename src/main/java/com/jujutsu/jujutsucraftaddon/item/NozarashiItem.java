package com.jujutsu.jujutsucraftaddon.item;

import com.jujutsu.jujutsucraftaddon.procedures.NozarashiEntitySwingsItemProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.NozarashiLivingEntityIsHitWithToolProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.NozarashiRightclickedProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.NozarashiToolInHandTickProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

import java.util.List;

public class NozarashiItem extends SwordItem {
    public NozarashiItem() {
        super(new Tier() {
            public int getUses() {
                return 0;
            }

            public float getSpeed() {
                return 4f;
            }

            public float getAttackDamageBonus() {
                return 16f;
            }

            public int getLevel() {
                return 1;
            }

            public int getEnchantmentValue() {
                return 2;
            }

            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 3, -3f, new Properties().fireResistant());
    }

    @Override
    public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        NozarashiLivingEntityIsHitWithToolProcedure.execute(entity.level(), entity, sourceentity, itemstack);
        return retval;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        NozarashiRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
        return ar;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.translatable("item.jujutsucraftaddon.nozarashi.description_0"));
    }

    @Override
    public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
        boolean retval = super.onEntitySwing(itemstack, entity);
        NozarashiEntitySwingsItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
        return retval;
    }

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        if (selected)
            NozarashiToolInHandTickProcedure.execute(world, entity);
    }
}
