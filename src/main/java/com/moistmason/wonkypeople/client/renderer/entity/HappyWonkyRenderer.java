package com.moistmason.wonkypeople.client.renderer.entity;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.item.food.model.WonkyModelLayers;
import com.moistmason.wonkypeople.item.food.model.WonkyPersonModel;
import com.moistmason.wonkypeople.entity.passive.HappyWonky;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class HappyWonkyRenderer extends AbstractWonkyRenderer<HappyWonky, WonkyPersonModel<HappyWonky>> {
    public HappyWonkyRenderer(EntityRendererProvider.Context context) {
        super(context, new WonkyPersonModel<>(context.bakeLayer(WonkyModelLayers.WONKY_PERSON)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(HappyWonky entity) {
        return new ResourceLocation(WonkyPeople.MODID, "textures/entity/happy_wonky.png");
    }
}
