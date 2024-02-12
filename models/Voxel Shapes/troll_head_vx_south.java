public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.125, 0.125, 0.525, 0.875, 0.75, 1.025));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.75, 0.3125, 0.41874999999999996, 0.84375, 0.4375, 0.5125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.15625, 0.3125, 0.41874999999999996, 0.25, 0.4375, 0.5125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.09375, 0, 0.40625, 0.90625, 0.3125, 1.03125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5625, 1.2199187500000002, 0.5625, 0.75, 1.3449187500000002));

	return shape;
}