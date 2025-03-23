package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.SetupAnimationsProcedure;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = SetupAnimationsProcedure.JujutsucraftModAnimationMessage.class, remap = false, priority = -10000)
public class JujutsucraftModAnimationMessageMixin {
//    @Inject(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At("TAIL"), remap = false, cancellable = true)
//    private void onDeserialize(FriendlyByteBuf buffer, CallbackInfo ci) {
//        ci.cancel();
//        CompoundTag tag = buffer.readNbt();
//        PacketAccessorMixin accessor = (PacketAccessorMixin) this;
//
//        if (tag != null) {
//            String json = tag.getString("animation");
//            if (json != null && !json.isEmpty()) {
//                accessor.setAnimation(Component.Serializer.fromJson(json));
//            } else {
//                accessor.setAnimation(Component.literal(""));  // Prevents crashes
//            }// Deserialize Component
//            accessor.setTarget(tag.getInt("target"));
//            accessor.setOverride(tag.getBoolean("override"));
//        }
//    }
//
//    @Inject(method = "buffer", at = @At("HEAD"), cancellable = true, remap = false)
//    private static void onBuffer(SetupAnimationsProcedure.JujutsucraftModAnimationMessage message, FriendlyByteBuf buffer, CallbackInfo ci) {
//        CompoundTag tag = new CompoundTag();
//        PacketAccessorMixin accessor = (PacketAccessorMixin) message;
//
//        tag.putString("animation", Component.Serializer.toJson(((PacketAccessorMixin) message).getAnimation()));// Serialize Component
//        tag.putInt("target", accessor.getTarget());
//        tag.putBoolean("override", accessor.isOverride());
//
//        buffer.writeNbt(tag);
//        ci.cancel();
//    }
//
//    @Inject(method = "handler", at = @At("HEAD"), cancellable = true, remap = false)
//    private static void onHandler(SetupAnimationsProcedure.JujutsucraftModAnimationMessage message, Supplier<NetworkEvent.Context> contextSupplier, CallbackInfo ci) {
//        PacketAccessorMixin accessor = (PacketAccessorMixin) message;
//        NetworkEvent.Context context = contextSupplier.get();
//
//        context.enqueueWork(() -> {
//            Level level = Minecraft.getInstance().level;
//            if (level == null) return;
//
//            Entity entity = level.getEntity(accessor.getTarget());
//            if (entity instanceof AbstractClientPlayer player) {
//                var animationLayer = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player)
//                        .get(new ResourceLocation("jujutsucraft", "player_animation"));
//
//                if (animationLayer != null && (accessor.isOverride() || !animationLayer.isActive())) {
//                    animationLayer.setAnimation(new KeyframeAnimationPlayer(
//                            (PlayerAnimationRegistry.getAnimation(
//                                    new ResourceLocation("jujutsucraft", accessor.getAnimation().toString().toLowerCase())
//                            ))
//                    ));
//                }
//            }
//        });
//
//        context.setPacketHandled(true);
//        ci.cancel();
//    }
}
