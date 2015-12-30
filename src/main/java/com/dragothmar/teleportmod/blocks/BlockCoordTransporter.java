package com.dragothmar.teleportmod.blocks;

import com.dragothmar.teleportmod.items.ItemCoordinateCache;
import com.dragothmar.teleportmod.tileentity.TileEntityCoordTransporter;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class BlockCoordTransporter extends Block implements ITileEntityProvider
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

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumFacing side, float hitX, float hitY, float hitZ)
    {
        ItemStack stack = playerIn.getCurrentEquippedItem();

        if (stack != null && stack.getItem() instanceof ItemCoordinateCache)
        {
            if (stack.getItem().hasEffect(stack))
            {
                TileEntityCoordTransporter tect = (TileEntityCoordTransporter) worldIn.getTileEntity(pos);
                tect.addEntry("Thing", stack);
                stack.stackSize--;
                playerIn.addChatMessage(new ChatComponentText("Added coordinate cache to tile entity."));
            }
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityCoordTransporter();
    }
}
