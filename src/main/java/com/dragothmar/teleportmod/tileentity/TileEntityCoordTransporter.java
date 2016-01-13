package com.dragothmar.teleportmod.tileentity;

import com.dragothmar.teleportmod.CoordEntry;
import com.dragothmar.teleportmod.items.ItemCoordinateCache;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dragothmar on 12/30/2015.
 */
public class TileEntityCoordTransporter extends TileEntity
{
    private List<CoordEntry> teleports = new ArrayList<CoordEntry>();


    /**
     *
     * @param name The name of the entry.
     * @param coordCache Contains the block coordinates and dimension value.
     * @return Returns 0 if the coordCache is successfully added to the teleports list
     *         Returns -1 if the entry is not added
     */
    public int addEntry(String name, ItemStack coordCache)
    {
        NBTTagCompound nbt = (NBTTagCompound)coordCache.getTagCompound().getTag(ItemCoordinateCache.NBT_TAG_COORDS);
        int dim = nbt.getInteger("dim");
        int posX = nbt.getInteger("posX");
        int posY = nbt.getInteger("posY");
        int posZ = nbt.getInteger("posZ");
        CoordEntry toAdd = new CoordEntry(name, dim, posX, posY, posZ);
        if (!teleports.contains(toAdd))
        {
            teleports.add(toAdd);
            return 0;
        }
        return -1;
    }

    public CoordEntry getEntry(int index)
    {
        if ( index < teleports.size() && index >= 0)
        {
            return teleports.get(index);
        }
        return null;
    }

    public int getSize()
    {
        return teleports.size();
    }

    public void deleteEntry(int index)
    {
        if ( index < teleports.size() && index >= 0)
        {
            teleports.remove(index);
        }
    }

    public void printEntryList()
    {
        for( CoordEntry entry : teleports)
        {
            System.out.println(entry.toString());
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        teleports.clear();

        NBTTagList entryList = (NBTTagList)compound.getTag("teleports");

        for (int i = 0; i < entryList.tagCount(); i++)
        {
            NBTTagCompound entryCompound = entryList.getCompoundTagAt(i);
            CoordEntry entry = CoordEntry.readEntryFromNBT(entryCompound);
            teleports.add(entry);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        NBTTagList entryList = new NBTTagList();
        for( CoordEntry entry : teleports)
        {
            NBTTagCompound entryCompound = new NBTTagCompound();
            entry.writeEntryToNBT(entryCompound);
            entryList.appendTag(entryCompound);
        }
        compound.setTag("teleports", entryList);
    }

}
