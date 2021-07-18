package mod.gptc.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import java.util.List;

import mod.gptc.entity.GemEntity;

public class EntityAIFollow extends Goal {
    public GemEntity follower;
    public LivingEntity owner;
    public double speed;

    public EntityAIFollow(GemEntity entityIn, double speedIn) {
        this.follower = entityIn;
        this.speed = speedIn;
    }

    @Override
    public boolean canStart() {
        List<PlayerEntity> list = this.follower.world.<PlayerEntity>getNonSpectatingEntities(PlayerEntity.class, this.follower.getBoundingBox().expand(20.0D, 10.0D, 20.0D));
        double maxDistance = Double.MAX_VALUE;
        for (PlayerEntity entity : list) {
            if (!entity.isSpectator() || !entity.isInvisible() && this.follower.getOwnerId() == owner.getUuid()) {
                double newDistance = entity.squaredDistanceTo(this.follower);
                if (newDistance <= maxDistance) {
                    maxDistance = newDistance;
                    this.owner = entity;
                }
            }
        }
        return this.owner != null && follower.getMovementType() == 2;
    }

    @Override
    public boolean shouldContinue() {
        return this.owner != null && !this.follower.getNavigation().isFollowingPath() == false && this.follower.getMovementType() == 2 && this.follower.squaredDistanceTo(this.owner) > Math.pow(7, 2);
    }

    @Override
    public void start(){
        super.start();
        this.follower.setPathfindingPenalty(PathNodeType.WATER, 0);
        this.follower.getNavigation().startMovingTo(this.owner.getX(), this.owner.getY(), this.owner.getZ(), this.speed);
        if(this.follower.squaredDistanceTo(this.owner) > Math.pow(16, 2)){
            this.follower.setPosition(this.owner.getX(), this.owner.getY(), this.owner.getZ());
        }
    }

    @Override
    public void stop() {
        this.follower.setPathfindingPenalty(PathNodeType.WATER, 0);
    }
}