package com.dragothmar.teleportmod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

/**
 * Created by Dragothmar on 12/30/2015.
 */
public class CoordEntry
{
    private String name;
    private String dimension;
    private int x,y,z;

    public CoordEntry(String name, String dimension, int x, int y, int z)
    {
        this.name = name;
        this.dimension = dimension;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDimension()
    {
        return dimension;
    }

    public BlockPos getPos()
    {
        return new BlockPos(this.x, this.y, this.z);
    }

    public void writeEntryToNBT(NBTTagCompound nbt)
    {
        nbt.setString("name", this.name);
        nbt.setString("dimension", this.dimension);
        nbt.setInteger("posX", this.x);
        nbt.setInteger("posY", this.y);
        nbt.setInteger("posZ", this.z);
    }

    public static CoordEntry readEntryFromNBT(NBTTagCompound nbt)
    {
        String name = nbt.getString("name");
        String dim = nbt.getString("dimension");
        int pX = nbt.getInteger("posX");
        int pY = nbt.getInteger("posY");
        int pZ = nbt.getInteger("posZ");
        return new CoordEntry(name, dim, pX, pY, pZ );
    }
}
