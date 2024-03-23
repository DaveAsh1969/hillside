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

public class DowsingRodItem_Diamond_Lapis extends Item {
    public DowsingRodItem_Diamond_Lapis(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            if (context.getWorld().getDimensionKey().getValue().equals(DimensionTypes.THE_NETHER_ID) ||
                    context.getWorld().getDimensionKey().getValue().equals(DimensionTypes.THE_END_ID))
            {
                context.getPlayer().sendMessage(Text.literal("This dowsing rod only works in the Overworld!"));
                return super.useOnBlock(context);
            }
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + Math.abs(context.getWorld().getChunk(positionClicked).getBottomY()); i++) {
                Block blockBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(positionClicked.down(i), player, blockBelow);

                    foundBlock = true;
                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(Text.translatable("item.hillside.dowsing_rod.no_valuables"), true);
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
        return block == Blocks.DIAMOND_ORE ||  block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE;
    }
}