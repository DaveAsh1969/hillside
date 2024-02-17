package net.hillsidemod.hillside.item.custom;

import net.hillsidemod.hillside.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionTypes;

public class ModRubyBootsItem extends ArmorItem {
    public ModRubyBootsItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(!world.isClient()) {
            //check for player
            if (entity.isPlayer() && !entity.isSpectator())
            {
                PlayerEntity p = (PlayerEntity) entity;
                //if the player is wearing Ruby boots
                if (p.getInventory().getArmorStack(0).getItem() == this)
                {
                    //blocks above and below player
                    BlockPos blockPosBelowPlayer = new BlockPos(p.getBlockPos().getX(), p.getBlockPos().getY() - 1,
                                                                p.getBlockPos().getZ());
                    BlockPos blockPosAbovePlayer = new BlockPos(p.getBlockPos().getX(), p.getBlockPos().getY() + 1,
                                                                p.getBlockPos().getZ());
                    Block blockBelow = world.getBlockState(blockPosBelowPlayer).getBlock();
                    Block blockAbove = world.getBlockState(blockPosAbovePlayer).getBlock();

                    //if the player is on lava (not under), give status effect.
                    if(blockBelow.equals(Blocks.LAVA) && !blockAbove.equals(Blocks.LAVA))
                    {
                        //no damage taken from lava
                        if (!p.hasStatusEffect(StatusEffects.FIRE_RESISTANCE))
                            p.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200));

                        //ability to jump out of lava to land
                        if (!p.hasStatusEffect(StatusEffects.JUMP_BOOST))
                            p.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200));

                        p.setFireTicks(0);  //ensure player isn't on fire
                    }
                    //If player is below lava because they ran into a lava stream, remove effect, player will die
                    if(blockAbove.equals(Blocks.LAVA) && p.hasStatusEffect(StatusEffects.FIRE_RESISTANCE))
                        p.removeStatusEffect(StatusEffects.FIRE_RESISTANCE);
                }
            }
        }
    }
    @Override
    public boolean isFireproof() {
        return true;
    }
}
