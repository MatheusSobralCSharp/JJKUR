package com.jujutsu.jujutsucraftaddon.procedures;

import com.jujutsu.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;

@Mod.EventBusSubscriber
public class RenderFingerToolTipEvent {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        execute(event, event.getItemStack(), event.getToolTip());
    }

    public static void execute(ItemStack itemstack, List<Component> tooltip) {
        execute(null, itemstack, tooltip);
    }

    private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
        if (tooltip == null)
            return;

        if (itemstack.getItem() == JujutsucraftModItems.HITEN.get().asItem()) {
            tooltip.add(1, Component.literal("§f[Sukuna Clan&CT Ability] M1s Hiten Has Chance To Do True Damage Slash(20sec CD)"));
            tooltip.add(2, Component.literal("§f[Sukuna Clan&CT Ability] Right Click Will Allow You To Fly for 5 seconds"));
        }


        if (itemstack.getItem() == JujutsucraftModItems.SUKUNA_FINGER.get().asItem()) {
            tooltip.add(Component.literal("§f[Info] In The First Finger(Only) You Eat Has a Chance for Success"));
            tooltip.add(Component.literal("§f[Info] In Creative Mode Ignore The Chance and The CT"));
            tooltip.add(Component.literal("§f[Info] Sukuna Takes Over Of Your Body When You Eat It"));
            tooltip.add(Component.literal("§f[Info] Only Itadori, Sukuna, Megumi can use in survival"));
            tooltip.add(Component.literal("§f[Chances] Normal Chance: 10%"));
            tooltip.add(Component.literal("§f[Chances] Itadori Clan: 25%"));
            tooltip.add(Component.literal("§f[Chances] Sukuna Clan: 50%"));
            tooltip.add(Component.literal("§f[Chances] Fallen One Trait: 100%"));
            tooltip.add(Component.literal("§f[Important Info] You Can Disable Take Over in Gamerules(jjkuSukunaPossession)"));
            tooltip.add(Component.literal("§f[Important Info] Sukuna Can Also Take Over your Friends"));
        }

        if (itemstack.getItem() == JujutsucraftModItems.ITEM_MASTER_SIX_EYES.get().asItem()) {
            tooltip.add(Component.literal("§f[Info] Can Only Be Used In Creative Mode"));
        }

        if (itemstack.getItem() == JujutsucraftModItems.CURSED_TECHNIQUE_CHANGER.get()) {
            tooltip.add(Component.literal("§f[Info] Highly Recommend Using JujutsuCraft Visual Effects Mod For The Best Experience"));
            tooltip.add(Component.literal("§f[Important Info] Setup Your Keybinds"));
        }

        if (itemstack.getItem() == JujutsucraftaddonModItems.TRAIT_RECOMMENDATION.get().asItem()) {
            tooltip.add(Component.literal("§f[Info] Doesn't Give Special Traits That You Can Only Get When Starting"));
            tooltip.add(Component.literal("§f[Info] Also Gives Special Buffs That CAN Help you alot In The Game"));
        }


        if (itemstack.getItem() == JujutsucraftaddonModItems.CELLPHONE.get().asItem()) {
            tooltip.add(Component.literal("§f[Important Info] Check Keybinds and Setup"));
            tooltip.add(Component.literal("§f[Important Info] Gojo and Sukuna History Mode Progression Are At Second Page(Jujutsu Menu)"));
            tooltip.add(Component.literal("§f[Important Info] For Gojo And Sukuna History Mode you Need Both Gojo and Sukuna Clans"));
            tooltip.add(Component.literal("§f[Important Info] For Gojo And Sukuna History Mode you Need Both Gojo and Sukuna Clans"));
            tooltip.add(Component.literal("§f[Important Info] You Can Only Use Special Skills With Sukuna And Gojo BASE CT"));
            tooltip.add(Component.literal("§f[Important Info] Second Page Disable Fog, Impact Frames, The Blue Bar you see"));
            tooltip.add(Component.literal("§f[Important Info] Second Page Is Used For Configure Your Experience, Check it Out Later"));
        }

        if (itemstack.getItem() == JujutsucraftaddonModItems.RACE_CHANGER.get().asItem()) {
            tooltip.add(Component.literal("§f[Important Info] Changes Your Race, Has 3 Type Of Races"));
            tooltip.add(Component.literal("§f[Race] Sorcerer = Can Learn Output, RCT Mastery, RCT Burnout, Simple Domain Mastery"));
            tooltip.add(Component.literal("§f[Race] Cursed Spirit = Has Regeneration, More Resistance and Less Cooldowns(Can Get Cursed Spirit Subraces)"));
            tooltip.add(Component.literal("§f[Race] Vessel = Has Some Attributes Buffed, More Potential(Can Get Cursed Spirit Subraces)"));
        }

        if (itemstack.getItem() == JujutsucraftaddonModItems.CLAN_CHANGER.get().asItem()) {
            tooltip.add(Component.literal("§f[Important Info] All Rates Are Configurable Inside Of Config Files -> Jujutsu Clan Rates"));
            tooltip.add(Component.literal("§f[Important Info] Clans Give Special Buffs, Can Give Black Flash Chances or Even Abilities To Progression"));
        }

        if (itemstack.getItem() == JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get().asItem()) {
            tooltip.add(Component.literal("§f[Important Info] All Rates Are Configurable Inside Of Config Files -> Jujutsu Rates"));
            tooltip.add(Component.literal("§f[Important Info] Used With The Gamerule jjkuRandomCT, Enable it for let players only Use Random Changers"));
        }


    }

}
