package com.moistmason.wonkypeople.entity.ai.goal;

import com.moistmason.wonkypeople.entity.passive.HappyWonky;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class RunInFrontOfPlayerGoal extends Goal {
    private final HappyWonky wonky;
    private final Player player;
    private final double speedModifier;

    public RunInFrontOfPlayerGoal(HappyWonky wonky, Player player, double speedModifier) {
        this.wonky = wonky;
        this.player = player;
        this.speedModifier = speedModifier;
    }

    @Override
    public boolean canUse() {
        // Wonky only targets player in survival/hardcore/adventure modes
        if (this.player.isCreative() || this.player.isSpectator()) {
            return false;
        }

        // goal can only be run if the Wonky's distance to the player is less than 20 blocks.
        return this.wonky.distanceTo(this.player) < 20.0F;
    }

    @Override
    public void start() {
        // get front of player
        Vec3 playerLook = player.getLookAngle();

        // get coordinates matching immediate front of player
        double posX = player.position().x + playerLook.x;
        double posY = player.position().y + playerLook.y;
        double posZ = player.position().z + playerLook.z;

        // make Wonky navigate to new coordinates.
        wonky.getNavigation().moveTo(posX, posY, posZ, wonky.getSpeed() * speedModifier);

        // make Wonky look at the player dead in the eye.
        wonky.getLookAngle().add(playerLook.yRot(180));
    }

    @Override
    public void stop() {
        // Stop the wonky.
        wonky.getMoveControl().strafe(0, 0);
    }
}
