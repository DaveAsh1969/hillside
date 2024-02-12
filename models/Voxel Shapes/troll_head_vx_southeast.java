public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.1875, 0.125, 0.4625, 0.9375, 0.75, 0.9625));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.8125, 0.3125, 0.35624999999999996, 0.90625, 0.4375, 0.44999999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.21875, 0.3125, 0.35624999999999996, 0.3125, 0.4375, 0.44999999999999996));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.15625, 0, 0.34375, 0.96875, 0.3125, 0.96875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.5, 0.5625, 1.1574187500000002, 0.625, 0.75, 1.2824187500000002));

	return shape;
}