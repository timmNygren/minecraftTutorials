package com.dragothmar.teleportmod;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

/**
 * Created by Dragothmar on 12/30/2015.
 */
public class CoordEntry
{
    private String name;
    private int dimension;
    private int x,y,z;

    public CoordEntry(String name, int dimension, int x, int y, int z)
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

    public int getDimension()
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
        nbt.setInteger("dimension", this.dimension);
        nbt.setInteger("posX", this.x);
        nbt.setInteger("posY", this.y);
        nbt.setInteger("posZ", this.z);
    }

    public static CoordEntry readEntryFromNBT(NBTTagCompound nbt)
    {
        String name = nbt.getString("name");
        int dim = nbt.getInteger("dimension");
        int pX = nbt.getInteger("posX");
        int pY = nbt.getInteger("posY");
        int pZ = nbt.getInteger("posZ");
        return new CoordEntry(name, dim, pX, pY, pZ );
    }

    @Override
    public String toString()
    {
        if (this.name.equals(""))
            return "Dimension: " + this.getDimName(this.dimension) + ",  x: " + this.x + ", y: " + this.y + ", z: " + this.z;
        else
            return "Name: " + this.name + ", Dimension: " + this.getDimName(this.dimension) + ", x: " + this.x + ", y: " + this.y + ", z: " + this.z;
    }

    public String getDimName(int dim)
    {
        String dimension;
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
            default:
                dimension = "Unknown (" + dim + ")";
                break;
        }
        return dimension;
    }

//    @Override
//    public int compareTo(CoordEntry o)
//    {
//        BlockPos pos= new BlockPos(this.x, this.y, this.z);
//        BlockPos oPos = new BlockPos(o.x, o.y, o.z);
//
//        return pos.compareTo(oPos) == 0 ? this.dimension.compareTo(o.dimension) : pos.compareTo(oPos);
//    }

    @Override
    public boolean equals(Object obj)
    {
        CoordEntry o = (CoordEntry)obj;
        boolean isEqualPos = this.x == o.x && this.y == o.y && this.z == o.z;
        boolean isEqualDim = this.dimension == o.dimension;
        return isEqualPos && isEqualDim;
    }
}
