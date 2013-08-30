package bms;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTentCloth extends Block {
    
	public BlockTentCloth(int id, Material blockMaterial, String name) {
		super(id, blockMaterial);
        setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundClothFootstep);
        setUnlocalizedName(name);
        
        // Add Solid Block Texture
        func_111022_d(BasicInfo.ID.toLowerCase() + ":" + name);
	}
	
	public boolean getBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, ForgeDirection dir)
	{
		// Return true or false if block is next to this one, and if it is a tent block, or a tent cloth block
		if(par1IBlockAccess.getBlockId(par2 + dir.offsetX, par3 + dir.offsetY, par4 + dir.offsetZ) == BlocksBMS.tentClothBlock.blockID ||
		   par1IBlockAccess.getBlockId(par2 + dir.offsetX, par3 + dir.offsetY, par4 + dir.offsetZ) == BlocksBMS.tentBlock.blockID)
		{
			return true;
		}
		return false;
	}
	
	public int getRenderType()
    {
        return 41;
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	protected boolean canSilkHarvest()
    {
        return false;
    }
	
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
}
