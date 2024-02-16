package net.hillsidemod.hillside.block.custom;

import net.hillsidemod.hillside.block.entity.TrollHeadEntity;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class TrollHeadBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public TrollHeadBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
                    Block.createCuboidShape(2, 2, 4.4, 14, 12, 12.4),
                    Block.createCuboidShape(12, 5, 2.6999999999999993, 13.5, 7, 4.199999999999999),
                    Block.createCuboidShape(2.5, 5, 2.6999999999999993, 4, 7, 4.199999999999999),
                    Block.createCuboidShape(1.5, 0, 2.5, 14.5, 5, 12.5)
                   // Block.createCuboidShape(7, 9, 15.5187, 9, 12, 17.518700000000003)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(2.0000000000000018, 2, 3.4499999999999975, 13.999999999999998, 12, 11.449999999999998),
            Block.createCuboidShape(2.5000000000000018, 5, 11.649999999999999, 4, 7, 13.15),
            Block.createCuboidShape(12, 5, 11.649999999999999, 13.499999999999998, 7, 13.15),
            Block.createCuboidShape(1.5, 0, 3.349999999999996, 14.5, 5, 13.349999999999996)
           // Block.createCuboidShape(7.075000000000001, 4.78257470552, 11.28600183026619, 9.075000000000001, 7.78257470552, 13.286001830266192)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(3.5250000000000004, 2, 1.9250000000000007, 11.524999999999999, 12, 13.924999999999997),
            Block.createCuboidShape(11.725, 5, 11.924999999999999, 13.225000000000001, 7, 13.424999999999997),
            Block.createCuboidShape(11.725, 5, 2.4250000000000007, 13.225000000000001, 7, 3.924999999999999),
            Block.createCuboidShape(3.424999999999999, 0, 1.4250000000000007, 13.424999999999997, 5, 14.424999999999997)
           // Block.createCuboidShape(11.000000000000002, 4.588960809150148, 7.242908474525695, 13.000000000000002, 7.588960809150148, 9.242908474525695)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(4.475000000000001, 2, 1.9250000000000007, 12.475000000000001, 12, 13.924999999999997),
            Block.createCuboidShape(2.7749999999999986, 5, 2.4250000000000007, 4.275, 7, 3.924999999999999),
            Block.createCuboidShape(2.7749999999999986, 5, 11.924999999999999, 4.275, 7, 13.424999999999997),
            Block.createCuboidShape(2.575000000000003, 0, 1.424999999999999, 12.575000000000003, 5, 14.424999999999999)
           // Block.createCuboidShape(2.6398428167295087, 4.721671621678393, 7, 4.639842816729509, 7.721671621678393, 9)
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
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.TROLL_HURT, SoundCategory.BLOCKS, 0.5f, 1.0f, true);
        return ActionResult.SUCCESS;
    }
}
