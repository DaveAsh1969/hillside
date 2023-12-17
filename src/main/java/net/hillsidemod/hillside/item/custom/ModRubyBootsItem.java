package net.hillsidemod.hillside.item.custom;

import net.hillsidemod.hillside.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

public class ModRubyBootsItem extends ArmorItem {
    BlockPos priorBlockPos;
    //BlockPos priorBlockPos2;

    public ModRubyBootsItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
        priorBlockPos = new BlockPos (0,-64,0);
        //priorBlockPos2 = new BlockPos (0,-64,0);

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            //check for player
            if (entity.isPlayer()) {
                PlayerEntity p = world.getClosestPlayer(entity.getBlockPos().getX(), entity.getBlockPos().getY(),
                        entity.getBlockPos().getZ(), 2, false);
                float playerHealth = p.getHealth();

                //if the player is wearing the boots
                if (p.getInventory().getArmorStack(0).getItem() == this)
                {
                    BlockPos blockPosBelowPlayer = new BlockPos(p.getBlockPos().getX(), p.getBlockPos().getY() - 1,
                            p.getBlockPos().getZ());

                    //if the player is trying to stand on lava set the lava block, clear old block back to lava
                    if (world.getBlockState(blockPosBelowPlayer).getBlock().equals(Blocks.LAVA) ||
                    (world.getBlockState(p.getBlockPos()).getBlock().equals(Blocks.LAVA)))
                    {
                        setBlocksForPlayer(world, blockPosBelowPlayer);

                        if (priorBlockPos != blockPosBelowPlayer)
                        {
                            returnBlocksForPlayer(world, priorBlockPos);
                            priorBlockPos = blockPosBelowPlayer;
                        }

                        //extinguish player if he's on fire
                        if(p.isOnFire()) {
                            p.teleport(p.getBlockPos().getX(),p.getBlockPos().getY()+1,p.getBlockPos().getZ());
                            p.setFireTicks(0);
                            p.setHealth(playerHealth);
                        }
                    }
                    //if the player left a lava block behind on dry ground, clear the lava block
                    else if (world.getBlockState(priorBlockPos).getBlock().equals(ModBlocks.LAVA_BLOCK) &&
                        !world.getBlockState(blockPosBelowPlayer).getBlock().equals(Blocks.LAVA) &&
                            !world.getBlockState(blockPosBelowPlayer).getBlock().equals(ModBlocks.LAVA_BLOCK))
                    {
                        returnBlocksForPlayer(world, priorBlockPos);
                    }
                    //make sure player has fire resistance for 10 seconds at a time.
                    if(!p.hasStatusEffect(StatusEffects.FIRE_RESISTANCE))
                        p.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200));
                }
                //if the player isn't wearing the boots anymore, clear the lava block, they now sink
                else if(world.getBlockState(priorBlockPos).getBlock().equals(ModBlocks.LAVA_BLOCK) &&
                        p.getInventory().getArmorStack(0).getItem() != this)
                {
                    returnBlocksForPlayer(world, priorBlockPos);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public boolean isFireproof() {
        return true;
    }

    private void setBlocksForPlayer(World world, BlockPos pos)
    {
         if(world.getBlockState(pos).getBlock().equals(Blocks.LAVA))
            world.setBlockState(pos, ModBlocks.LAVA_BLOCK.getDefaultState());
    }

    private void returnBlocksForPlayer(World world, BlockPos pos)
    {
        if(world.getBlockState(pos).getBlock().equals(ModBlocks.LAVA_BLOCK))
            world.setBlockState(pos, Blocks.LAVA.getDefaultState());
    }
}
