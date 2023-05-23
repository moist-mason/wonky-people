package com.moistmason.wonkypeople.client.model;

import com.moistmason.wonkypeople.entity.passive.Wonky;
import com.moistmason.wonkypeople.entity.ai.bartering.WonkyBartering;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class WonkyPersonModel<T extends Wonky> extends HumanoidModel<T> {
    private final PartPose bodyDefault = this.body.storePose();
    private final PartPose headDefault = this.head.storePose();
    private final PartPose leftArmDefault = this.leftArm.storePose();
    private final PartPose rightArmDefault = this.rightArm.storePose();

    public WonkyPersonModel(ModelPart root) {
        super(root);
    }

    // Model is identitical to base Humanoid Model.
    public static LayerDefinition createLayer() {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public void setupAnim(T wonky, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.body.loadPose(this.bodyDefault);
        this.head.loadPose(this.headDefault);
        this.leftArm.loadPose(this.leftArmDefault);
        this.rightArm.loadPose(this.rightArmDefault);
        super.setupAnim(wonky, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        if (WonkyBartering.inspecting) {
            rightArm.yRot = 0.5F;
            rightArm.xRot = -0.9F;
        }
    }
}
