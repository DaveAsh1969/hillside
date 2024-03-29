package net.hillsidemod.hillside.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.hillsidemod.hillside.Hillside;
import net.hillsidemod.hillside.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<BrickOvenBlockEntity> BRICK_OVEN = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Hillside.MOD_ID, "brick_oven_entity"),
            FabricBlockEntityTypeBuilder.create(BrickOvenBlockEntity::new, ModBlocks.BRICK_OVEN).build(null));
    public static final BlockEntityType<TacoBellBlockEntity> TACO_BELL_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Hillside.MOD_ID, "taco_bell_entity"),
            FabricBlockEntityTypeBuilder.create(TacoBellBlockEntity::new, ModBlocks.TACO_BELL).build());
    public static final BlockEntityType<TrollHeadEntity> TROLL_HEAD_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Hillside.MOD_ID, "troll_head_entity"),
            FabricBlockEntityTypeBuilder.create(TrollHeadEntity::new, ModBlocks.TROLL_HEAD).build());
    public static void registerBlockEntities() {
        Hillside.LOGGER.info("Registering Block Entities for " + Hillside.MOD_ID);
    }
}
