public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0, 0.125, 0.4, 0.75, 0.75, 0.9));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.625, 0.3125, 0.29374999999999996, 0.71875, 0.4375, 0.38749999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.03125, 0.3125, 0.29374999999999996, 0.125, 0.4375, 0.38749999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(-0.03125, 0, 0.28125, 0.78125, 0.3125, 0.90625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.3125, 0.5625, 1.0949187500000002, 0.4375, 0.75, 1.2199187500000002));

	return shape;
}