package com.dragothmar.teleportmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class BlockCoordTransporter extends Block
{

    public BlockCoordTransporter(Material materialIn)
    {
        super(materialIn);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }


}
