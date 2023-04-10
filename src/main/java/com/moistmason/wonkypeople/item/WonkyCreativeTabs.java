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
                builder -> builder.icon(() -> new ItemStack(Items.BRAIN_CORAL)).title(Component.translatable("itemGroup.wonkypeople.items"))
                        .displayItems((features, output) -> {
                            output.accept(WonkyItems.WONKY_PERSON_SPAWN_EGG.get());
                            output.accept(WonkyItems.HAPPY_WONKY_SPAWN_EGG.get());
                        })
        );
    }
}
