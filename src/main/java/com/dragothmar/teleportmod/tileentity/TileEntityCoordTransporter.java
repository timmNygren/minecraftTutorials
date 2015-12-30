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

    public void addEntry(String name, ItemStack coordCache)
    {
        NBTTagCompound nbt = (NBTTagCompound)coordCache.getTagCompound().getTag(ItemCoordinateCache.NBT_TAG_COORDS);
        int dim = nbt.getInteger("dim");
        String dimension = "";
        switch(dim)
        {
            case 0:
                dimension = "Overworld";
                break;
            case -1:
                dimension = "Nether";
                break;
            case 1:
                dimension = "The End";
                break;
        }
        int posX = nbt.getInteger("posX");
        int posY = nbt.getInteger("posY");
        int posZ = nbt.getInteger("posZ");
        teleports.add(new CoordEntry(name, dimension, posX, posY, posZ));
    }

    public CoordEntry getEntry(int index)
    {
        if ( index < teleports.size() && index >= 0)
        {
            return teleports.get(index);
        }
        return null;
    }

    public void deleteEntry(int index)
    {
        if ( index < teleports.size() && index >= 0)
        {
            teleports.remove(index);
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
