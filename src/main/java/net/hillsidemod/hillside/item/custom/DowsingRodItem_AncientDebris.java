package net.hillsidemod.hillside.item.custom;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionTypes;

import java.awt.*;

public class DowsingRodItem_AncientDebris extends Item {
    public DowsingRodItem_AncientDebris(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            if (context.getWorld().getDimensionKey().getValue().equals(DimensionTypes.OVERWORLD_ID) ||
                    context.getWorld().getDimensionKey().getValue().equals(DimensionTypes.THE_END_ID))
            {
                context.getPlayer().sendMessage(Text.literal("This dowsing rod only works in the Nether!"));
                return super.useOnBlock(context);
            }

            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + Math.abs(context.getWorld().getChunk(positionClicked).getBottomY()); i++) {
                for(int j= 0; j <= 5; j++) {
                    for (int k = 0; k <= 5; k++) {
                        Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                        if (isValuableBlock(blockBelow)) {
                            outputValuableCoordinates(positionClicked.down(i), player, blockBelow);

                            foundBlock = true;
                            break;
                        }
                    }
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.hillsidemod.dowsing_rod.no_valuables"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
        player.sendMessage(Text.literal("Found " + blockBelow.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.ANCIENT_DEBRIS || block == Blocks.NETHER_QUARTZ_ORE || block == Blocks.NETHER_GOLD_ORE;
    }
}