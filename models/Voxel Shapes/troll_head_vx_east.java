public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.25, 0.125, 0.4, 1, 0.75, 0.9));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.875, 0.3125, 0.29374999999999996, 0.96875, 0.4375, 0.38749999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.28125, 0.3125, 0.29374999999999996, 0.375, 0.4375, 0.38749999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0, 0.28125, 1.03125, 0.3125, 0.90625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5625, 0.5625, 1.0949187500000002, 0.6875, 0.75, 1.2199187500000002));

	return shape;
}