package net.hillsidemod.hillside.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<BrickOvenBlockEntity> BRICK_OVEN;

    public static void registerBlockEntities() {
        BRICK_OVEN = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Hillside.MOD_ID, "brick_oven"),
                FabricBlockEntityTypeBuilder.create(BrickOvenBlockEntity::new, ModBlocks.BRICK_OVEN).build(null));
    }
}
