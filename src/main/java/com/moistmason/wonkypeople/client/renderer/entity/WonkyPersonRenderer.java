package com.moistmason.wonkypeople.client.renderer.entity;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.client.model.WonkyModelLayers;
import com.moistmason.wonkypeople.client.model.WonkyPersonModel;
import com.moistmason.wonkypeople.entity.passive.Wonky;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class WonkyPersonRenderer extends AbstractWonkyRenderer<Wonky, WonkyPersonModel<Wonky>> {
    public WonkyPersonRenderer(EntityRendererProvider.Context context) {
        super(context, new WonkyPersonModel<>(context.bakeLayer(WonkyModelLayers.WONKY_PERSON)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Wonky entity) {
        return new ResourceLocation(WonkyPeople.MODID, "textures/entity/wonky_person.png");
    }
}
