public VoxelShape makeShape(){
	VoxelShape shape = VoxelShapes.empty();
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.125, 0.125, 0.5875, 0.875, 0.75, 1.0875));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.75, 0.3125, 0.48124999999999996, 0.84375, 0.4375, 0.575));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.15625, 0.3125, 0.48124999999999996, 0.25, 0.4375, 0.575));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.09375, 0, 0.46875, 0.90625, 0.3125, 1.09375));
	shape = VoxelShapes.union(shape, VoxelShapes.cuboid(0.4375, 0.5625, 1.2824187500000002, 0.5625, 0.75, 1.4074187500000002));

	return shape;
}