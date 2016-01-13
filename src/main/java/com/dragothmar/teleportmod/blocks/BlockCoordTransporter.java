package com.dragothmar.teleportmod.blocks;

import com.dragothmar.teleportmod.TeleportMod;
import com.dragothmar.teleportmod.items.ItemCoordinateCache;
import com.dragothmar.teleportmod.network.GuiHandler;
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
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by Dragothmar on 12/22/15.
 */
public class BlockCoordTransporter extends Block implements ITileEntityProvider
{
    private String addCoordString = "";

    public BlockCoordTransporter(Material materialIn)
    {
        super(materialIn);
        this.isBlockContainer = true;
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
                if (tect.addEntry("Thing", stack) == 0)
                {
                    stack.stackSize--;
                    addCoordString = "Added coordinate cache to tile entity.";
                } else
                {
                    addCoordString = "That position is already stored!";
                }
                if (worldIn.isRemote)
                    playerIn.addChatMessage(new ChatComponentText(addCoordString));

            }
        } else if (playerIn.isSneaking() && stack == null)  // For testing
        {
            TileEntityCoordTransporter tile = (TileEntityCoordTransporter)worldIn.getTileEntity(pos);
            if (worldIn.isRemote)
            {
                System.out.println("Printing Coord Transporters locations!");
                tile.printEntryList();
                System.out.println("Done printing!");
            }
        } else if (worldIn.isRemote)
        {
            playerIn.openGui(TeleportMod.INSTANCE, GuiHandler.COORD_TRANSPORTER_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityCoordTransporter();
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity != null && tileentity.receiveClientEvent(eventID, eventParam);
    }
}
