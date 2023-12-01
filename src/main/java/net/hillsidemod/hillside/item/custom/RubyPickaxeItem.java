package net.hillsidemod.hillside.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RubyPickaxeItem extends PickaxeItem {
    public RubyPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        for(int xx=0;xx<3;xx++) {
            for (int zz = 0; zz < 3; zz++)
            {
                for (int yy=0;yy<3;yy++)
                {
                    if(pos.getY()-1+yy > world.getBottomY() && pos.getY()-1+yy < world.getHeight())
                    {
                        BlockPos destroyBlockPos = new BlockPos(pos.getX() - 1 + xx, pos.getY()-1+yy, pos.getZ() - 1 + zz);
                        if(!world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.STONE) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.DEEPSLATE) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.GRASS_BLOCK) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.DIORITE) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.ANDESITE) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.GRAVEL) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.GRANITE) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.TUFF) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.NETHERRACK) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.SOUL_SAND) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.MAGMA_BLOCK) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.BLACKSTONE) &&
                                !world.getBlockState(destroyBlockPos).getBlock().equals(Blocks.DIRT))
                            world.breakBlock(destroyBlockPos, true, miner);
                        else
                        {
                            world.removeBlock(destroyBlockPos, true);
                        }
                    }
                }
            }
        }
        if(world.canSetBlock(miner.getBlockPos()))
        {
            if(miner.getBlockPos().getY() < 60)
            {
                if(world.getLightLevel(miner.getBlockPos()) < 4) {
                    world.setBlockState(miner.getBlockPos(), Blocks.TORCH.getDefaultState());
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
