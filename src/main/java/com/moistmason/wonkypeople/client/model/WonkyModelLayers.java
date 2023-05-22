package com.moistmason.wonkypeople.client.model;

import com.moistmason.wonkypeople.WonkyPeople;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Set;

public class WonkyModelLayers {
    private static final Set<ModelLayerLocation> ALL_MODELS = new HashSet<>();

    public static final ModelLayerLocation WONKY_PERSON = register("wonky_person");

    private static ModelLayerLocation register(String path) {
        return register(path, "main");
    }

    private static ModelLayerLocation register(String path, String model) {
        ModelLayerLocation location = new ModelLayerLocation(new ResourceLocation(WonkyPeople.MODID, path), model);
        if (!ALL_MODELS.add(location)) {
            throw new IllegalStateException("Duplicate registration for " + location);
        } else {
            return location;
        }
    }
}
