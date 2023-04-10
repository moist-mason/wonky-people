package com.moistmason.wonkypeople.client.model;

import com.moistmason.wonkypeople.entity.passive.Wonky;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.checkerframework.checker.units.qual.C;

public class WonkyPersonModel<T extends Wonky> extends HumanoidModel<T> {
    public WonkyPersonModel(ModelPart root) {
        super(root);
    }

    // Model is identitical to base Humanoid Model.
    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
