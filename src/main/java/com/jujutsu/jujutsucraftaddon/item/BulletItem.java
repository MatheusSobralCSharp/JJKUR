package com.jujutsu.jujutsucraftaddon.item;

import com.jujutsu.jujutsucraftaddon.entity.BulletProjectileEntity;
import com.jujutsu.jujutsucraftaddon.procedures.BulletRangedItemShootsProjectileProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class BulletItem extends Item {
    public BulletItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
        return 0f;
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.translatable("item.jujutsucraftaddon.bullet.description_0"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = InteractionResultHolder.fail(entity.getItemInHand(hand));
        if (entity.getAbilities().instabuild || findAmmo(entity) != ItemStack.EMPTY) {
            ar = InteractionResultHolder.success(entity.getItemInHand(hand));
            entity.startUsingItem(hand);
        }
        BulletRangedItemShootsProjectileProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
        return ar;
    }

    @Override
    public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entity, int time) {
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            ItemStack stack = findAmmo(player);
            if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
                BulletProjectileEntity projectile = BulletProjectileEntity.shoot(world, entity, world.getRandom());
                if (player.getAbilities().instabuild) {
                    projectile.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                } else {
                    if (stack.isDamageableItem()) {
                        if (stack.hurt(1, world.getRandom(), player)) {
                            stack.shrink(1);
                            stack.setDamageValue(0);
                            if (stack.isEmpty())
                                player.getInventory().removeItem(stack);
                        }
                    } else {
                        stack.shrink(1);
                        if (stack.isEmpty())
                            player.getInventory().removeItem(stack);
                    }
                }
            }
        }
    }

    private ItemStack findAmmo(Player player) {
        ItemStack stack = ProjectileWeaponItem.getHeldProjectile(player, e -> e.getItem() == BulletProjectileEntity.PROJECTILE_ITEM.getItem());
        if (stack == ItemStack.EMPTY) {
            for (int i = 0; i < player.getInventory().items.size(); i++) {
                ItemStack teststack = player.getInventory().items.get(i);
                if (teststack != null && teststack.getItem() == BulletProjectileEntity.PROJECTILE_ITEM.getItem()) {
                    stack = teststack;
                    break;
                }
            }
        }
        return stack;
    }
}
