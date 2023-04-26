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
        Player player = getPlayer();
        if (player != null) {
            // Wonky following conditions
            if (!(player.isCreative() || player.isSpectator()) && !player.isInvisible()) {
                return wonky.distanceTo(player) < 20.0F;
            }
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        // Continue to run as long as the pathfinding is ongoing.
        return !wonky.getNavigation().isDone();
    }

    @Override
    public void start() {
        Player player = getPlayer();

        if (player != null) {
            // get front of player
            Vec3 playerLook = player.getLookAngle();

            // get coordinates matching immediate front of player
            double posX = player.position().x + playerLook.x;
            double posY = player.position().y + playerLook.y;
            double posZ = player.position().z + playerLook.z;

            // make Wonky look at the player dead in the eye.
            wonky.getLookControl().setLookAt(player);

            // make Wonky navigate to new coordinates.
            wonky.getNavigation().moveTo(posX, posY, posZ, wonky.getSpeed() * speedModifier);
        }
    }

    @Override
    public void stop() {
        wonky.getMoveControl().strafe(0, 0);
    }

    public Player getPlayer() {
        return level.getNearestPlayer(wonky, 20);
    }
}
