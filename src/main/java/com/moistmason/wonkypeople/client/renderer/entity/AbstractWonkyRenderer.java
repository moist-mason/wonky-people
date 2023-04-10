package com.moistmason.wonkypeople.client.renderer.entity;

import com.moistmason.wonkypeople.WonkyPeople;
import com.moistmason.wonkypeople.client.model.WonkyModelLayers;
import com.moistmason.wonkypeople.client.model.WonkyPersonModel;
import com.moistmason.wonkypeople.entity.passive.Wonky;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractWonkyRenderer<T extends Wonky, M extends HumanoidModel<T>> extends HumanoidMobRenderer<T, M> {

    public AbstractWonkyRenderer(EntityRendererProvider.Context context, M model, float shadowRadius) {
        super(context, model, shadowRadius);
    }
}
