package com.jujutsu.jujutsucraftaddon.entity;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.procedures.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class UiUiEntity extends TamableAnimal {
    public UiUiEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(JujutsucraftaddonModEntities.UI_UI.get(), world);
    }

    public UiUiEntity(EntityType<UiUiEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
            }

            @Override
            public boolean canUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canUse() && ReturnDomainProcedure.execute(world, entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canContinueToUse() && ReturnDomainProcedure.execute(world, entity);
            }

        });
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4;
            }

            @Override
            public boolean canUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canUse() && ReturnDomainProcedure.execute(world, entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canContinueToUse() && ReturnDomainProcedure.execute(world, entity);
            }

        });
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canUse() && ReturnDomainProcedure.execute(world, entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canContinueToUse() && ReturnDomainProcedure.execute(world, entity);
            }
        }.setAlertOthers());
        this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canUse() && ReturnDomainProcedure.execute(world, entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canContinueToUse() && ReturnDomainProcedure.execute(world, entity);
            }
        });
        this.targetSelector.addGoal(5, new OwnerHurtTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canUse() && ReturnDomainProcedure.execute(world, entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canContinueToUse() && ReturnDomainProcedure.execute(world, entity);
            }
        });
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1, (float) 10, (float) 5, false) {
            @Override
            public boolean canUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canUse() && ReturnUi2Procedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = UiUiEntity.this.getX();
                double y = UiUiEntity.this.getY();
                double z = UiUiEntity.this.getZ();
                Entity entity = UiUiEntity.this;
                Level world = UiUiEntity.this.level();
                return super.canContinueToUse() && ReturnUi2Procedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new FloatGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public double getMyRidingOffset() {
        return -0.35D;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        UiUiOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
        return retval;
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        Item item = itemstack.getItem();
        if (itemstack.getItem() instanceof SpawnEggItem) {
            retval = super.mobInteract(sourceentity, hand);
        } else if (this.level().isClientSide()) {
            retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.sidedSuccess(this.level().isClientSide()) : InteractionResult.PASS;
        } else {
            if (this.isTame()) {
                if (this.isOwnedBy(sourceentity)) {
                    if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(sourceentity, hand, itemstack);
                        this.heal((float) item.getFoodProperties().getNutrition());
                        retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                    } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                        this.usePlayerItem(sourceentity, hand, itemstack);
                        this.heal(4);
                        retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                    } else {
                        retval = super.mobInteract(sourceentity, hand);
                    }
                }
            } else if (this.isFood(itemstack)) {
                this.usePlayerItem(sourceentity, hand, itemstack);
                if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
                    this.tame(sourceentity);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                } else {
                    this.level().broadcastEntityEvent(this, (byte) 6);
                }
                this.setPersistenceRequired();
                retval = InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
                retval = super.mobInteract(sourceentity, hand);
                if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
                    this.setPersistenceRequired();
            }
        }
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Entity entity = this;
        Level world = this.level();

        UiUiRightClickedOnEntityProcedure.execute(entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        UiUiAIProcedure.execute(this.level(), this);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        UiUiEntity retval = JujutsucraftaddonModEntities.UI_UI.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return Ingredient.of().test(stack);
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 400);
        builder = builder.add(Attributes.ARMOR, 20);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
        builder = builder.add(Attributes.FOLLOW_RANGE, 256);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 2);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 4);
        return builder;
    }
}
