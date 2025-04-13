package com.jujutsu.jujutsucraftaddon.entity;

import com.jujutsu.jujutsucraftaddon.abilities.EarthWallAbility;
import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import com.jujutsu.jujutsucraftaddon.procedures.AIClonesProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.CloneEntityAIProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.CloneOnEntityTickUpdateProcedure;
import com.jujutsu.jujutsucraftaddon.procedures.ClonesAIGeneralProcedure;
import net.mcreator.jujutsucraft.procedures.AIItadoriYujiProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackTargetProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackTargetStartProcedure;
import net.mcreator.jujutsucraft.procedures.SetTagJujutsuSorcererProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
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

public class CloneEntity extends TamableAnimal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(CloneEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(CloneEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(CloneEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> DATA_Testing = SynchedEntityData.defineId(CloneEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Boolean> ATTACK_MODE = SynchedEntityData.defineId(CloneEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> MAJIMA = SynchedEntityData.defineId(CloneEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    public String prevAnim;

    public CloneEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(JujutsucraftaddonModEntities.CLONE.get(), world);

    }

    public CloneEntity(EntityType<CloneEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        this.setMaxUpStep(0.6F);
        setNoAi(false);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SHOOT, false);
        this.entityData.define(ANIMATION, "undefined");
        this.entityData.define(TEXTURE, "itadori_yuji");
        this.entityData.define(DATA_Testing, "");
        this.entityData.define(ATTACK_MODE, false);
        this.entityData.define(MAJIMA, false);
    }


    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 900);
        builder = builder.add(Attributes.ARMOR, 30);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
        builder = builder.add(Attributes.FOLLOW_RANGE, 256);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 2);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 8);
        return builder;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
            protected double getAttackReachSqr(LivingEntity entity) {
                return 0.0;
            }
            public boolean canUse() {
                double x = CloneEntity.this.getX();
                double y = CloneEntity.this.getY();
                double z = CloneEntity.this.getZ();
                Entity entity = CloneEntity.this;
                Level world = CloneEntity.this.level();
                return super.canUse() && LogicAttackTargetProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
            public boolean canUse() {
                double x = CloneEntity.this.getX();
                double y = CloneEntity.this.getY();
                double z = CloneEntity.this.getZ();
                Entity entity = CloneEntity.this;
                Level world = CloneEntity.this.level();
                return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }

            public boolean canContinueToUse() {
                double x = CloneEntity.this.getX();
                double y = CloneEntity.this.getY();
                double z = CloneEntity.this.getZ();
                Entity entity = CloneEntity.this;
                Level world = CloneEntity.this.level();
                return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }
        });
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
            public boolean canUse() {
                double x = CloneEntity.this.getX();
                double y = CloneEntity.this.getY();
                double z = CloneEntity.this.getZ();
                Entity entity = CloneEntity.this;
                Level world = CloneEntity.this.level();
                return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }

            public boolean canContinueToUse() {
                double x = CloneEntity.this.getX();
                double y = CloneEntity.this.getY();
                double z = CloneEntity.this.getZ();
                Entity entity = CloneEntity.this;
                Level world = CloneEntity.this.level();
                return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }
        });
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new FloatGoal(this));
        this.goalSelector.addGoal(8, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(9, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(10, new OpenDoorGoal(this, false));
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
        SetTagJujutsuSorcererProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        return retval;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        CloneEntity retval = JujutsucraftaddonModEntities.CLONE.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putString("DataTesting", this.entityData.get(DATA_Testing));
        compound.putBoolean("AttackMode", this.entityData.get(ATTACK_MODE));
        compound.putBoolean("Majima", this.entityData.get(MAJIMA));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture"))
            this.setTexture(compound.getString("Texture"));
        if (compound.contains("DataTesting"))
            this.entityData.set(DATA_Testing, compound.getString("DataTesting"));
        if (compound.contains("AttackMode"))
            this.entityData.set(ATTACK_MODE, compound.getBoolean("AttackMode"));
        if (compound.contains("Majima"))
            this.entityData.set(MAJIMA, compound.getBoolean("Majima"));
    }

    @Override
    public void baseTick() {
        super.baseTick();
        CloneOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        AIItadoriYujiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        if (this instanceof LivingEntity) {
            if (this.getOwner() != null) {
                if ((!this.getOwner().isAlive()) || this.getOwner().getHealth()<= 1) {
                    this.discard();
                }
            }
            if (this.getEntityData().get(ATTACK_MODE)) {
                if (this.getPersistentData().getDouble("cnt_x") != 0) {
                    if (Math.random() < (1) / ((float) 10)) {
                        AIClonesProcedure.execute(this.level(), this);
                    }
                    if (Math.random() < (1) / ((float) 3000)) {
                        EarthWallAbility.createEarthWall(this);
                    }
                }
            } else {
                CloneEntityAIProcedure.execute(this.level(), this);
                if (this.getPersistentData().getDouble("cnt_x") != 0) {
                    if (Math.random() < (1) / ((float) 10)) {
                        ClonesAIGeneralProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
                    }
                }
            }
        }
        this.refreshDimensions();
    }

    public static void init() {
    }

    @Override
    public EntityDimensions getDimensions(Pose p_33597_) {
        return super.getDimensions(p_33597_).scale(1.0F);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
        } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.isAggressive() && !this.isSprinting()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
        } else if (this.isDeadOrDying()) {
            return event.setAndContinue(RawAnimation.begin().thenPlay("death"));
        } else if (this.isShiftKeyDown()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("guard"));
        } else if (this.isSprinting()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("sprint"));
        } else {
            return this.isAggressive() && event.isMoving() ? event.setAndContinue(RawAnimation.begin().thenLoop("sprint")) : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
    }

    private PlayState attackingPredicate(AnimationState event) {
        double d1 = this.getX() - this.xOld;
        double d0 = this.getZ() - this.zOld;
        float velocity = (float) Math.sqrt(d1 * d1 + d0 * d0);
        if (this.getAttackAnim(event.getPartialTick()) > 0.0F && !this.swinging) {
            this.swinging = true;
            this.lastSwing = this.level().getGameTime();
        }

        if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
            this.swinging = false;
        }

        if (this.swinging && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
            event.getController().forceAnimationReset();
            return event.setAndContinue(RawAnimation.begin().thenPlay("punch_right"));
        } else {
            return PlayState.CONTINUE;
        }
    }

    private PlayState procedurePredicate(AnimationState event) {
        if ((this.animationprocedure.equals("empty") || event.getController().getAnimationState() != AnimationController.State.STOPPED) && (this.animationprocedure.equals(this.prevAnim) || this.animationprocedure.equals("empty"))) {
            if (this.animationprocedure.equals("empty")) {
                this.prevAnim = "empty";
                return PlayState.STOP;
            }
        } else {
            if (!this.animationprocedure.equals(this.prevAnim)) {
                event.getController().forceAnimationReset();
            }

            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        }

        this.prevAnim = this.animationprocedure;
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
        return this.entityData.get(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.entityData.set(ANIMATION, animation);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
        data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
