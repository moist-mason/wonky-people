package com.moistmason.wonkypeople.client.renderer;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.client.renderer.model.WonkyModelLayers;
import com.moistmason.wonkypeople.client.renderer.model.WonkyPersonModel;
import com.moistmason.wonkypeople.client.renderer.entity.HappyWonkyRenderer;
import com.moistmason.wonkypeople.client.renderer.entity.WonkyPersonRenderer;
import com.moistmason.wonkypeople.entity.WonkyEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WonkyPeople.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WonkyRendererEvents {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(WonkyEntityTypes.WONKY_PERSON.get(), WonkyPersonRenderer::new);
        event.registerEntityRenderer(WonkyEntityTypes.HAPPY_WONKY.get(), HappyWonkyRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(WonkyModelLayers.WONKY_PERSON, WonkyPersonModel::createLayer);
    }
}
