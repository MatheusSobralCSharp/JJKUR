package com.jujutsu.jujutsucraftaddon.entity;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.procedures.AIRikaPartialProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.SetTagPartial;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class PartialRikaEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT;
    public static final EntityDataAccessor<String> ANIMATION;
    public static final EntityDataAccessor<String> TEXTURE;
    private final AnimatableInstanceCache cache;
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure;

    public PartialRikaEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(JujutsucraftaddonModEntities.PARTIAL_RIKA_ENTITY.get(), world);
    }

    public PartialRikaEntity(EntityType<PartialRikaEntity> type, Level world) {
        super(type, world);
        this.cache = GeckoLibUtil.createInstanceCache(this);
        this.animationprocedure = "empty";
        this.xpReward = 0;
        this.setNoAi(false);
        this.setMaxUpStep(0.6F);

    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "rika3");
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return (String)this.entityData.get(TEXTURE);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.5, false) {
            protected double getAttackReachSqr(LivingEntity entity) {
                return 0.0;
            }

            public boolean canUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canUse() && LogicAttackTargetProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
            public boolean canUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }

            public boolean canContinueToUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }
        });
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
            public boolean canUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }

            public boolean canContinueToUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }
        });
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false) {
            public boolean canUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canUse() && LogicAIProcedure.execute(entity);
            }

            public boolean canContinueToUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canContinueToUse() && LogicAIProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.5) {
            public boolean canUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canUse() && LogicAIProcedure.execute(entity);
            }

            public boolean canContinueToUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canContinueToUse() && LogicAIProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this) {
            public boolean canUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canUse() && LogicAIProcedure.execute(entity);
            }

            public boolean canContinueToUse() {
                double x = PartialRikaEntity.this.getX();
                double y = PartialRikaEntity.this.getY();
                double z = PartialRikaEntity.this.getZ();
                Entity entity = PartialRikaEntity.this;
                Level world = PartialRikaEntity.this.level();
                return super.canContinueToUse() && LogicAIProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(8, new FloatGoal(this));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        return source.is(DamageTypes.FALL) ? false : super.hurt(source, amount);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        DieRikaProcedure.execute(this.level(), this);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        SetTagPartial.execute(world, this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

    }

    @Override
    public void baseTick() {
        super.baseTick();
        AIRikaPartialProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        Entity entity = this;
        Level world = this.level();
        double x = this.getX();
        double y = entity.getY();
        double z = entity.getZ();
        return super.getDimensions(p_33597_).scale((float)SizeByNBTProcedure.execute(entity));
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 500.0);
        builder = builder.add(Attributes.ARMOR, 20.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 1.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
        return builder;
    }

    private PlayState movementPredicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
        } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.isAggressive()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
        } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
        } else if (this.isSprinting()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
        } else {
            return this.isAggressive() && event.isMoving() ? event.setAndContinue(RawAnimation.begin().thenLoop("sprint")) : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
    }

    private PlayState procedurePredicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
        }

        return PlayState.CONTINUE;
    }
    @Override
    protected void tickDeath() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
            this.dropExperience();
        }

    }

    public String getSyncedAnimation() {
        return (String)this.entityData.get(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.entityData.set(ANIMATION, animation);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    static {
        SHOOT = SynchedEntityData.defineId(PartialRikaEntity.class, EntityDataSerializers.BOOLEAN);
        ANIMATION = SynchedEntityData.defineId(PartialRikaEntity.class, EntityDataSerializers.STRING);
        TEXTURE = SynchedEntityData.defineId(PartialRikaEntity.class, EntityDataSerializers.STRING);
    }
}
