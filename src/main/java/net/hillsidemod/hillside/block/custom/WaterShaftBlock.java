package net.hillsidemod.hillside.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WaterShaftBlock extends Block {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public WaterShaftBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient())
        {
            if(entity instanceof PlayerEntity p)
            {
                if(!p.hasStatusEffect(StatusEffects.SPEED))
                    p.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 3));

                if(p.isSubmergedInWater())
                {
                    if(!p.hasStatusEffect(StatusEffects.DOLPHINS_GRACE))
                        p.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 20, 4));
                }
            }
            else if(entity instanceof LivingEntity)
            {
                Direction shaftDirection = (Direction)state.get(FACING);
                if(shaftDirection==Direction.NORTH)
                {
                    entity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ()-0.4D, entity.getYaw(), entity.getPitch());
                }
                else if(shaftDirection==Direction.SOUTH)
                {
                    entity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ()+0.4D, entity.getYaw(), entity.getPitch());
                }
                else if(shaftDirection==Direction.EAST)
                {
                    entity.refreshPositionAndAngles(entity.getX()-0.4D, entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch());
                }
                else if(shaftDirection==Direction.WEST)
                {
                    entity.refreshPositionAndAngles(entity.getX()+0.4D, entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch());
                }
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
