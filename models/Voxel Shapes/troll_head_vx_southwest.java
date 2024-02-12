public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.0625, 0.125, 0.4625, 0.8125, 0.75, 0.9625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.6875, 0.3125, 0.35624999999999996, 0.78125, 0.4375, 0.44999999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.09375, 0.3125, 0.35624999999999996, 0.1875, 0.4375, 0.44999999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.03125, 0, 0.34375, 0.84375, 0.3125, 0.96875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.375, 0.5625, 1.1574187500000002, 0.5, 0.75, 1.2824187500000002));

	return shape;
}