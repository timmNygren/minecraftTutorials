package com.dragothmar.teleportmod.items;

import com.dragothmar.teleportmod.CoordEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Dragothmar on 12/23/15.
 */
public class ItemCoordinateCache extends Item
{
    public static final String NBT_TAG_COORDS = "coords";
    /**
     * Called when a Block is right-clicked with this Item
     *
     * @param pos The block being right-clicked
     * @param side The side being right-clicked
     */
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!playerIn.isSneaking())
        {
            if (stack.getTagCompound() == null)
            {
                stack.setTagCompound(new NBTTagCompound());
            }
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("dim", playerIn.dimension);
            nbt.setInteger("posX", pos.getX());
            nbt.setInteger("posY", pos.getY());
            nbt.setInteger("posZ", pos.getZ());
            stack.getTagCompound().setTag(NBT_TAG_COORDS, nbt);
            stack.setStackDisplayName(EnumChatFormatting.AQUA + "Coordinate Cache");
        }
        return false;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (playerIn.isSneaking())
        {
            if (itemStackIn.getTagCompound() != null)
            {
                itemStackIn.getTagCompound().removeTag(NBT_TAG_COORDS);
                itemStackIn.clearCustomName();
            }
        }
        return itemStackIn;
    }

    /**
     * allows items to add custom lines of information to the mouseover description
     *
     * @param tooltip All lines to display in the Item's tooltip. This is a List of Strings.
     * @param advanced Whether the setting "Advanced tooltips" is enabled
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
    {
        if (stack.getTagCompound() != null)
        {
            if (stack.getTagCompound().hasKey(NBT_TAG_COORDS))
            {
                NBTTagCompound nbt = (NBTTagCompound)stack.getTagCompound().getTag(NBT_TAG_COORDS);
                int dim = nbt.getInteger("dim");
                int posX = nbt.getInteger("posX");
                int posY = nbt.getInteger("posY");
                int posZ = nbt.getInteger("posZ");
                CoordEntry entry = new CoordEntry("", dim, posX, posY, posZ);
                tooltip.add("Block coordinates at");
                tooltip.add(entry.toString());
//                tooltip.add(dim);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        if (stack.getTagCompound() != null)
        {
            return stack.getTagCompound().hasKey(NBT_TAG_COORDS);
        }
        return false;
    }
}
