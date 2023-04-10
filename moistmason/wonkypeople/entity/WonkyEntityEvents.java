package com.moistmason.wonkypeople.entity;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.entity.passive.HappyWonky;
import com.moistmason.wonkypeople.entity.passive.Wonky;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WonkyPeople.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WonkyEntityEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(WonkyEntityTypes.WONKY_PERSON.get(), Wonky.setAttributes());
        event.put(WonkyEntityTypes.HAPPY_WONKY.get(), HappyWonky.setAttributes());
    }
}