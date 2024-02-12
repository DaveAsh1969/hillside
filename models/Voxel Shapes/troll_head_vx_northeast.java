public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.125, 0.3375, 0.9375, 0.75, 0.8375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.8125, 0.3125, 0.23124999999999996, 0.90625, 0.4375, 0.32499999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0.3125, 0.23124999999999996, 0.3125, 0.4375, 0.32499999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.15625, 0, 0.21875, 0.96875, 0.3125, 0.84375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.5625, 1.0324187500000002, 0.625, 0.75, 1.1574187500000002));

	return shape;
}