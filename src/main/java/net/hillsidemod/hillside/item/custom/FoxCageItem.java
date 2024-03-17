package net.hillsidemod.hillside.item.custom;

import net.hillsidemod.hillside.mixin.FoxTrustedAccess;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class FoxCageItem extends Item {
    //declarations
    public static FoxEntity fox;
    public static List<UUID> foxOwner;
    public static String foxVariant;
    public static Text foxName;
    public static int foxAge;
    public FoxCageItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand)
    {
        if(!user.getWorld().isClient())
        {
            ItemStack foxCageInv = user.getStackInHand(hand);
            if(!foxCageInv.hasNbt())
            {
                if(entity instanceof FoxEntity)
                {
                    fox = (FoxEntity) entity;
                    foxVariant = fox.getVariant().asString();
                    foxOwner = ((FoxTrustedAccess) fox).getTrustedIds();
                    foxName = fox.getCustomName();
                    foxAge = fox.getBreedingAge();

                    int ownerLength = 0;

                    //write to NBT
                    NbtCompound nbtData = new NbtCompound();

                    for(int i=0;i<foxOwner.size();i++)
                    {
                        if(foxOwner.get(i)!=null)
                        {
                            nbtData.putUuid("UUID"+i, foxOwner.get(i));
                            ownerLength++;
                        }
                    }
                    nbtData.putInt("UUIDsize",ownerLength);
                    nbtData.putInt("foxAge", foxAge);

                    nbtData.putString("variant", foxVariant);
                    if(foxName!=null)
                        nbtData.putString("name", foxName.getString());

                    nbtData.putBoolean("displayName", fox.isCustomNameVisible());

                    foxCageInv.setNbt(nbtData);
                    foxCageInv.writeNbt(nbtData);
                    entity.discard();
                }
            }
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient())
        {
            ItemStack activeStack = Objects.requireNonNull(context.getPlayer()).getStackInHand(context.getPlayer().getActiveHand());
            FoxEntity newFox = new FoxEntity(EntityType.FOX, context.getWorld());

            // GetNBT and build fox
            if(activeStack.hasNbt())
            {
                NbtCompound nbtGet = activeStack.getNbt();
                int length = nbtGet.getInt("UUIDsize");
                if(length != 0) {
                    for (int i = 0; i < length; i++) {
                        if (nbtGet.getUuid("UUID" + i) != null) {
                            //populate owner UUIDs
                            ((FoxTrustedAccess) newFox).AddUuids(nbtGet.getUuid("UUID" + i));
                        }
                    }
                }
                //NBT Data
                newFox.setVariant(FoxEntity.Type.byName(nbtGet.getString("variant")));
                newFox.setBreedingAge(nbtGet.getInt("foxAge"));

                if(nbtGet.getString("name").length()!=0)
                {
                    newFox.setCustomName(Text.literal(nbtGet.getString("name")));
                    newFox.setCustomNameVisible(true);
                }

                BlockPos foxBlockPos = new BlockPos(context.getBlockPos().getX(), context.getBlockPos().getY()+1, context.getBlockPos().getZ());
                if(!context.getWorld().getBlockState(foxBlockPos).isAir())
                    return ActionResult.FAIL;

                //summon fox
                newFox.setPosition(foxBlockPos.getX(),foxBlockPos.getY()+1,foxBlockPos.getZ());
                context.getWorld().spawnEntity(newFox);

                activeStack.decrement(1);
            }
        }
        return ActionResult.FAIL;
    }

    public int setItemTexture(ItemStack stack)
    {
        if(!stack.hasNbt())
            return 1;
        if(Objects.equals(stack.getNbt().getString("variant"), "red"))
            return 2;
        else if(Objects.equals(stack.getNbt().getString("variant"), "snow"))
            return 3;
        else
            return 1;
    }
}
