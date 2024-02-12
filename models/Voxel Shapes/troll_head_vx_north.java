public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.125, 0.125, 0.275, 0.875, 0.75, 0.775));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.75, 0.3125, 0.16874999999999996, 0.84375, 0.4375, 0.26249999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.15625, 0.3125, 0.16874999999999996, 0.25, 0.4375, 0.26249999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.09375, 0, 0.15625, 0.90625, 0.3125, 0.78125));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5625, 0.96991875, 0.5625, 0.75, 1.0949187500000002));

	return shape;
}