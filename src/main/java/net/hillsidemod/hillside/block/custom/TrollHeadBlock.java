package net.hillsidemod.hillside.block.custom;

import net.hillsidemod.hillside.block.entity.TrollHeadEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class TrollHeadBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public TrollHeadBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE_N = Stream.of(

            Block.createCuboidShape(0.125, 0.125, 0.275, 0.875, 0.75, 0.775),
            Block.createCuboidShape(0.75, 0.3125, 0.1687, 0.84375, 0.4375, 0.2625),
            Block.createCuboidShape(0.15625, 0.3125, 0.1687, 0.25, 0.4375, 0.2625),
            Block.createCuboidShape(0.09375, 0, 0.15625, 0.90625, 0.3125, 0.78125),
            Block.createCuboidShape(0.4375, 0.5625, 0.9699, 0.5625, 0.75, 1.0949)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(

            Block.createCuboidShape(0.125, 0.125, 0.525, 0.875, 0.75, 1.025),
            Block.createCuboidShape(0.75, 0.3125, 0.4187, 0.84375, 0.4375, 0.5125),
            Block.createCuboidShape(0.15625, 0.3125, 0.4187, 0.25, 0.4375, 0.5125),
            Block.createCuboidShape(0.09375, 0, 0.40625, 0.90625, 0.3125, 1.03125),
            Block.createCuboidShape(0.4375, 0.5625, 1.2199, 0.5625, 0.75, 1.34491)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(

            Block.createCuboidShape(0.25, 0.125, 0.4, 1, 0.75, 0.9),
            Block.createCuboidShape(0.875, 0.3125, 0.29374, 0.96875, 0.4375, 0.3874),
            Block.createCuboidShape(0.28125, 0.3125, 0.29374, 0.375, 0.4375, 0.3875),
            Block.createCuboidShape(0.21875, 0, 0.28125, 1.03125, 0.3125, 0.90625),
            Block.createCuboidShape(0.5625, 0.5625, 1.0949, 0.6875, 0.75, 1.21992)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(

            Block.createCuboidShape(0, 0.125, 0.4, 0.75, 0.75, 0.9),
            Block.createCuboidShape(0.625, 0.3125, 0.2937, 0.71875, 0.4375, 0.3875),
            Block.createCuboidShape(0.03125, 0.3125, 0.2937, 0.125, 0.4375, 0.3875),
            Block.createCuboidShape(-0.03125, 0, 0.28125, 0.78125, 0.3125, 0.90625),
            Block.createCuboidShape(0.3125, 0.5625, 1.0949, 0.4375, 0.75, 1.2199)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TrollHeadEntity(pos, state);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        if (direction == Direction.DOWN || direction == Direction.UP) {
            return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        } else {
            return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getShape(state);
    }

    private VoxelShape getShape(BlockState state) {
        return SHAPE_N;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
