package net.hillsidemod.hillside.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LampBlock extends Block {

    public VoxelShape makeShape(){
        VoxelShape shape = VoxelShapes.empty();
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.125, 0.8125));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.0625, 0.4375, 0.5625, 0.5, 0.5625));
        shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.3125, 0.25, 0.75, 0.9375, 0.75));

        return shape;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public LampBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(CLICKED, false));

    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            boolean clicked = state.get(CLICKED);
            world.setBlockState(pos, state.with(CLICKED, !clicked), 3);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}


