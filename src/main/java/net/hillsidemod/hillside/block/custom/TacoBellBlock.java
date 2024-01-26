package net.hillsidemod.hillside.block.custom;

import net.hillsidemod.hillside.block.entity.ModBlockEntities;
import net.hillsidemod.hillside.block.entity.TacoBellBlockEntity;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
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
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class TacoBellBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public TacoBellBlock(Settings settings) {
        super(settings);

    }
    private static final VoxelShape SHAPE_N = Stream.of(
            //body
            Block.createCuboidShape(5, 3.5, 5, 11, 10.75, 11),
            //lip
            Block.createCuboidShape(4, 1.7, 4, 12, 3.7, 12),
            //head
            Block.createCuboidShape(7, 9, 7, 9, 12, 9),
            //bar
            Block.createCuboidShape(0, 12, 7, 16, 14, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            //body
            Block.createCuboidShape(5, 3.5, 5, 11, 10.75, 11),
            //lip
            Block.createCuboidShape(4, 1.7, 4, 12, 3.7, 12),
            //head
            Block.createCuboidShape(7, 9, 7, 9, 12, 9),
            //bar
            Block.createCuboidShape(0, 12, 7, 16, 14, 9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            //body
            Block.createCuboidShape(5, 3.5, 5, 11, 10.75, 11),
            //lip
            Block.createCuboidShape(4, 1.7, 4, 12, 3.7, 12),
            //head
            Block.createCuboidShape(7, 9, 7, 9, 12, 9),
            //bar
            Block.createCuboidShape(7, 12, 0, 9, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            //body
            Block.createCuboidShape(5, 3.5, 5, 11, 10.75, 11),
            //lip
            Block.createCuboidShape(4, 1.7, 4, 12, 3.7, 12),
            //head
            Block.createCuboidShape(7, 9, 7, 9, 12, 9),
            //bar
            Block.createCuboidShape(7, 12, 0, 9, 14, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    //verified
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

    //verified
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TacoBellBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof TacoBellBlockEntity) {
            Direction direction = hit.getSide();
            ((TacoBellBlockEntity)blockEntity).activate(direction, player, state.get(FACING));
        }
        world.playSound(pos.getX(), pos.getY(), pos.getZ(), ModSounds.TACO_BELL, SoundCategory.BLOCKS, 0.5f, 1.0f, true);
        return ActionResult.SUCCESS;
    }

    //verified
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getShape(state);
    }

    //verified but state isn't used here.
    private VoxelShape getShape(BlockState state) {
        return SHAPE_N;
    }

    //different from BellBlock class
    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        //return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    //method not found in bell block, in Abstract Block
    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    //method not found in bell block, in Abstract Block
    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    //slightly different but both look like they work
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    //confirmed
    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        Entity entity = projectile.getOwner();
        PlayerEntity playerEntity = entity instanceof PlayerEntity ? (PlayerEntity)entity : null;
        this.ring(world, state, hit, playerEntity, true);
    }

    //made update from old code
    public boolean ring(World world, BlockState state, BlockHitResult hitResult, @Nullable PlayerEntity player, boolean checkHitPos)
    {
        Direction direction = hitResult.getSide();
        BlockPos blockPos = hitResult.getBlockPos();
        boolean bl = !checkHitPos || this.isPointOnBell(state, direction, hitResult.getPos().y - (double)blockPos.getY());
        if (bl) {
            boolean bl2 = this.ring(player, world, blockPos, direction);
            if (bl2 && player != null) {
                player.incrementStat(Stats.BELL_RING);
            }
            return true;
        } else {
            return false;
        }
    }
        /*boolean bl;
        Direction direction = hitResult.getSide();
        BlockPos blockPos = hitResult.getBlockPos();
        boolean bl2 = bl = !checkHitPos || this.isPointOnBell(state, direction, hitResult.getPos().y - (double)blockPos.getY());
        if (bl) {
            boolean bl22 = this.ring(player, world, blockPos, direction);
            if (bl22 && player != null) {
                player.incrementStat(Stats.BELL_RING);
            }
            return true;
        }
        return false;
    }*/

    //different than new code
    private boolean isPointOnBell(BlockState state, Direction side, double y) {
        if (side.getAxis() == Direction.Axis.Y || y > (double)0.8124f) {
            return false;
        }
        Direction direction = state.get(FACING);
        return direction.getAxis() == side.getAxis();

    }

    public boolean ring(@Nullable Entity entity, World world, BlockPos pos, @Nullable Direction direction) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!world.isClient && blockEntity instanceof TacoBellBlockEntity) {
            if (direction == null) {
                direction = world.getBlockState(pos).get(FACING);
            }

            ((TacoBellBlockEntity)blockEntity).activate(direction, world.getClosestPlayer(entity,4), direction);
            world.playSound(null, pos, ModSounds.TACO_BELL, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.emitGameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
            return true;
        }
        return false;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.TACO_BELL_ENTITY, TacoBellBlockEntity::tick);
    }
}
