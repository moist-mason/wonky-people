package com.moistmason.wonkypeople.item;

import com.moistmason.wonkypeople.WonkyPeople;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WonkyPeople.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WonkyCreativeTabs {
    public static CreativeModeTab WONKY_ITEMS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        WONKY_ITEMS = event.registerCreativeModeTab(
                new ResourceLocation(WonkyPeople.MODID, "wonky_items_tab"),
                builder -> builder.icon(() -> new ItemStack(WonkyItems.HAPPY_DUST.get()))
                        .title(Component.translatable("creativetab.wonkypeople.items"))
                        .displayItems((parameters, output) -> WonkyItems.getAllItems().forEach(output::accept))
        );
    }
}
