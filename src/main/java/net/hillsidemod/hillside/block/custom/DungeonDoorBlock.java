package net.hillsidemod.hillside.block.custom;

import net.hillsidemod.hillside.item.ModItems;
import net.hillsidemod.hillside.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DungeonDoorBlock extends DoorBlock {
    public DungeonDoorBlock(Settings settings, BlockSetType blockSetType)
    {
        super(settings, blockSetType);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        //return super.onUse(state, world, pos, player, hand, hit);
        //if(player.getInventory().main.contains(ModItems.DUNGEON_KEY))
        if(player.getMainHandStack().getItem() == ModItems.DUNGEON_KEY)
        {
            state = state.cycle(OPEN);
            if(this.isOpen(state))
            {
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), ModSounds.DUNGEON_DOOR_OPEN, SoundCategory.BLOCKS, 1f, 1f, true);
                player.getInventory().removeOne(player.getMainHandStack());
                world.setBlockState(pos, state, Block.NOTIFY_LISTENERS | Block.REDRAW_ON_MAIN_THREAD);
            }

            world.emitGameEvent((Entity)player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return ActionResult.SUCCESS;
        }
        else
        {
            if(!this.isOpen(state))
            {
                world.playSound(pos.getX(),pos.getY(),pos.getZ(), ModSounds.DUNGEON_DOOR_LOCKED, SoundCategory.BLOCKS, 1f, 1f, true);
                player.sendMessage(Text.literal("You need a key!"), true);
            }
            return ActionResult.PASS;
        }

    }
}
