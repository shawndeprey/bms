package bms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBMSTentDoor extends ItemDoor {
	
	private Material doorMaterial;
	
	public ItemBMSTentDoor(int id, Material par2Material, String itemName) {
		super(id, par2Material);
		this.doorMaterial = par2Material;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabRedstone);
		setUnlocalizedName(itemName);
		
		// Sets item Texture
		func_111206_d(BasicInfo.ID.toLowerCase() + ":" + itemName);
	}
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else
        {
            ++par5;
            Block block = BlocksBMS.tentBlockDoor;

            if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
            {
                if (!block.canPlaceBlockAt(par3World, par4, par5, par6))
                {
                    return false;
                }
                else
                {
                    int i1 = MathHelper.floor_double((double)((par2EntityPlayer.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(par3World, par4, par5, par6, i1, block);
                    --par1ItemStack.stackSize;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

    public static void placeDoorBlock(World par0World, int par1, int par2, int par3, int par4, Block par5Block)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par4 == 0)
        {
            b1 = 1;
        }

        if (par4 == 1)
        {
            b0 = -1;
        }

        if (par4 == 2)
        {
            b1 = -1;
        }

        if (par4 == 3)
        {
            b0 = 1;
        }

        int i1 = (par0World.isBlockNormalCube(par1 - b0, par2, par3 - b1) ? 1 : 0) + (par0World.isBlockNormalCube(par1 - b0, par2 + 1, par3 - b1) ? 1 : 0);
        int j1 = (par0World.isBlockNormalCube(par1 + b0, par2, par3 + b1) ? 1 : 0) + (par0World.isBlockNormalCube(par1 + b0, par2 + 1, par3 + b1) ? 1 : 0);
        boolean flag = par0World.getBlockId(par1 - b0, par2, par3 - b1) == par5Block.blockID || par0World.getBlockId(par1 - b0, par2 + 1, par3 - b1) == par5Block.blockID;
        boolean flag1 = par0World.getBlockId(par1 + b0, par2, par3 + b1) == par5Block.blockID || par0World.getBlockId(par1 + b0, par2 + 1, par3 + b1) == par5Block.blockID;
        boolean flag2 = false;

        if (flag && !flag1)
        {
            flag2 = true;
        }
        else if (j1 > i1)
        {
            flag2 = true;
        }

        par0World.setBlock(par1, par2, par3, par5Block.blockID, par4, 2);
        par0World.setBlock(par1, par2 + 1, par3, par5Block.blockID, 8 | (flag2 ? 1 : 0), 2);
        par0World.notifyBlocksOfNeighborChange(par1, par2, par3, par5Block.blockID);
        par0World.notifyBlocksOfNeighborChange(par1, par2 + 1, par3, par5Block.blockID);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ItemsBMS.doorTent.itemID;
    }
}