package com.jujutsu.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.client.gui.SelectTechniqueScreen;
import net.mcreator.jujutsucraft.network.SelectTechniqueButtonMessage;
import net.mcreator.jujutsucraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;

@Mixin(value = SelectTechniqueScreen.class, priority = -10000)
public abstract class SelectTechniqueScreenMixin extends AbstractContainerScreen<SelectTechniqueMenu> {
    @Unique
    Button second_technique;
    @Unique
    Button sun_wukong;
    @Unique
    Button sung_jin_woo;



    /**
     * @author Satushi
     */

    public SelectTechniqueScreenMixin(SelectTechniqueMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
    }

    // Example: Inject into the init() method to add a custom button
    @Inject(
            method = {"init"},
            at = {@At("TAIL")}
    )
    public void onInit(CallbackInfo ci) {
        TechniqueGuiAccessorMixin accessor = (TechniqueGuiAccessorMixin) this;
        Level world = accessor.getWorld();
        int x = accessor.getX();
        int y = accessor.getY();
        int z = accessor.getZ();
        Player entity = accessor.getEntity();
        HashMap<String, Object> guistate = accessor.getGuistate();
        HashMap<String, String> textstate = accessor.textstate();
        this.second_technique = Button.builder(Component.literal("Second Technique"), (e) -> {
            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(1000, x, y, z, textstate));
            SelectTechniqueButtonMessage.handleButtonAction(entity, 1000, x, y, z, textstate);
        }).bounds(this.leftPos + 11, this.topPos + 180, 75, 20).build();
        guistate.put("button:second_technique", this.second_technique);
        this.addRenderableWidget(this.second_technique);
        this.sun_wukong = Button.builder(Component.literal("Sun Wukong"), (e) -> {
            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(100, x, y, z, textstate));
            SelectTechniqueButtonMessage.handleButtonAction(entity, 100, x, y, z, textstate);
        }).bounds(this.leftPos + 11, this.topPos + 155, 75, 20).build();
        guistate.put("button:sun_wukong", this.sun_wukong);
        this.addRenderableWidget(this.sun_wukong);
//        this.sung_jin_woo = Button.builder(Component.literal("Shadow Monarch"), (e) -> {
//            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(101, x, y, z, textstate));
//            SelectTechniqueButtonMessage.handleButtonAction(entity, 101, x, y, z, textstate);
//        }).bounds(this.leftPos + 11, this.topPos + 120, 75, 20).build();
//        guistate.put("button:sun_wukong", this.sung_jin_woo);
//        this.addRenderableWidget(this.sung_jin_woo);
    }

    @Inject(
            method = "render",
            at = @At("TAIL")
    )
    public void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        Checkbox cursedSpirit = TechniqueGuiAccessorMixin.getCursedSpirit();
        if (this.second_technique != null && this.second_technique.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("Usage: Click On The Button, Stores The Technique You Using, For Enable use /jjkuSecondTechnique @s true, For Storing Another You Need disable first"), mouseX, mouseY);
        }
        if (this.sun_wukong != null && this.sun_wukong.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(this.font, Component.literal("The Victorious Fighting Buddha, (斗战胜佛)"), mouseX, mouseY);
        }

        if (cursedSpirit != null && cursedSpirit.isMouseOver(mouseX, mouseY)) {
            guiGraphics.renderTooltip(font, Component.literal("CursedSpirits: Passive Regeneration, Less Cooldowns And More Resistance"), mouseX, mouseY);
        }
    }
}