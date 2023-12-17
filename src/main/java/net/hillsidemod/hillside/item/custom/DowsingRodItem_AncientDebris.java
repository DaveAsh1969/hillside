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
                context.getPlayer().sendMessage(Text.translatable("This dowsing rod only works in the Nether!"), true);
                return super.useOnBlock(context);
            }

            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 22; i <= 22 && i >=8; i--) {
                for(int j= 0; j <= 10; j++) {
                    for (int k = 0; k <= 10; k++) {
                        int xMod=0;
                        int zMod=0;
                        if(positionClicked.getX()+j > 0)
                            xMod = -1;
                        else if(positionClicked.getX()+j < 0)
                            xMod = 1;
                        if(positionClicked.getZ()+k > 0)
                            zMod = -1;
                        else if(positionClicked.getZ()+k < 0)
                            zMod = 1;

                        BlockPos testPos = new BlockPos(positionClicked.getX()+j+xMod, i, positionClicked.getZ()+k+zMod);
                        Block testBlock = context.getWorld().getBlockState(testPos).getBlock();

                        if (isValuableBlock(testBlock))
                        {
                            outputValuableCoordinates(testPos, player, testBlock);
                            foundBlock = true;
                            break;
                        }
                    }
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.hillsidemod.dowsing_rod.no_valuables"), true);
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
        return block == Blocks.ANCIENT_DEBRIS;
    }
}