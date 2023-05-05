package net.hillsidemod.hillside.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;


public class StarCompassItem extends Item {
    public StarCompassItem(Settings settings) {
        super(settings);
    }

   @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getPlayer().sendMessage(Text.translatable("Your current location:" + " (" + (int) context.getPlayer().getX() + ", "
                + (int) context.getPlayer().getY() + ", " + (int) context.getPlayer().getZ() + ")"),true);

        context.getStack().damage(1, context.getPlayer(), (p) -> p.sendToolBreakStatus(p.getActiveHand()));

        return super.useOnBlock(context);
    }

}
