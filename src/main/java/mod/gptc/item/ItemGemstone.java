package mod.gptc.item;

import java.util.Optional;

import mod.gptc.entity.GemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class ItemGemstone extends Item {
	public String ID = "";
	private final EntityType<?> type;
	
	public ItemGemstone(Settings settings, String ID, EntityType<? extends GemEntity> type) {
		super(settings);
		this.ID = ID;
		this.type = type;
	}
    
    @SuppressWarnings({ "resource", "static-access" })
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        if(!context.getWorld().isClient && stack.hasNbt() && stack.getNbt().contains("bepis")) {
            ServerWorld serverWorld = (ServerWorld) context.getWorld();
            BlockPos pos = context.getBlockPos().offset(context.getSide());
            PlayerEntity player = (PlayerEntity) context.getPlayer();
            NbtCompound entityTag = context.getStack().getSubNbt("bepis");
            Optional<Entity> entity = this.type.getEntityFromNbt(entityTag, serverWorld);
            if(entity.isPresent()) {
                GemEntity entity2 = (GemEntity) entity.get();
                entity2.setHealth(entity2.getMaxHealth());
                if (entity2.getOwned() == true && entity2.getOwnerId() == player.getUuid()) {
                	entity2.setOwnerId(player.getUuid());
                }
                entity2.updatePositionAndAngles(pos.getX() + 0.5F, pos.getY() + 1F, pos.getZ() + 0.5F, player.getYaw(), player.getPitch());
                serverWorld.spawnEntity(entity2);
            }
            context.getPlayer().getStackInHand(context.getHand());
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
    
    public boolean setData(GemEntity host, ItemStack stack) {
    	NbtCompound entityTag = new NbtCompound();
        if(!host.saveSelfNbt(entityTag)) {
            return false;
        }
        stack.getOrCreateNbt().put("bepis", entityTag);
        stack.getOrCreateNbt().putString("name", host.getDisplayName().getString());
        return true;
    }

    public void clearData(ItemStack stack) {
        stack.setNbt(new NbtCompound());
    }
}