package com.moistmason.wonkypeople.entity.ai.goal;

import com.moistmason.wonkypeople.entity.passive.HappyWonky;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;

/**
 * This class creates a goal for the Happy Wonky's AI that will occasionally make it run up to and stand
 * in front of the player and stare at them.
 */
@Mod.EventBusSubscriber
public class RunInFrontOfPlayerGoal extends Goal {
    private final HappyWonky wonky;
    private final Level level;
    private final double speedModifier;

    public RunInFrontOfPlayerGoal(HappyWonky wonky, double speedModifier) {
        this.wonky = wonky;
        this.level = wonky.getLevel();
        this.speedModifier = speedModifier;
    }

    @Override
    public boolean canUse() {
        Player player = level.getNearestPlayer(wonky, 20);
        if (player != null) {
            // Wonky only targets player in survival/hardcore/adventure modes
            if (player.isCreative() || player.isSpectator()) {
                return false;
            }
            // goal can only be run if the Wonky's distance to the player is less than 20 blocks.
            return this.wonky.distanceTo(player) < 20.0F;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        // Continue to run as long as the pathfinding is ongoing.
        return !this.wonky.getNavigation().isDone();
    }

    @Override
    public void start() {
        Player player = wonky.getLevel().getNearestPlayer(wonky, 20);

        if (player != null) {
            // get front of player
            Vec3 playerLook = player.getLookAngle();

            // get coordinates matching immediate front of player
            double posX = player.position().x + playerLook.x;
            double posY = player.position().y + playerLook.y;
            double posZ = player.position().z + playerLook.z;

            // make Wonky navigate to new coordinates.
            wonky.getNavigation().moveTo(posX, posY, posZ, wonky.getSpeed() * speedModifier);

            // make Wonky look at the player dead in the eye.
            wonky.getLookAngle().add(playerLook.yRot(180F));
        }
    }

    @Override
    public void stop() {
        // Stop the wonky.
        wonky.getMoveControl().strafe(0, 0);
    }
}
