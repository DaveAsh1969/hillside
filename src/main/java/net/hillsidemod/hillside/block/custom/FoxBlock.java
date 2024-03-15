package net.hillsidemod.hillside.block.custom;

import net.hillsidemod.hillside.block.entity.FoxBlockEntity;
import net.hillsidemod.hillside.block.entity.ModBlockEntities;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FoxBlock extends BlockWithEntity implements BlockEntityProvider {
    public FoxBlockEntity foxBlockEntity;
    public FoxEntity foxEntity;
    public FoxBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        foxBlockEntity=new FoxBlockEntity(pos, state);
        return foxBlockEntity;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!world.isClient())
        {
          if(foxEntity != null)
          {
              foxEntity.setPosition(pos.getX(),pos.getY()+1,pos.getZ());
              world.spawnEntity(foxEntity);
          }
        }

        super.onBreak(world, pos, state, player);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.FOX_BLOCK_ENTITY, (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
