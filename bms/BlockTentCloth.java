package bms;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockTentCloth extends Block{
	public BlockTentCloth(int id, Material material, String name) {
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
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
	
	public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
        boolean N = this.getBlock(par1World, par2, par3, par4, NORTH);
        boolean E = this.getBlock(par1World, par2, par3, par4, EAST);
        boolean S = this.getBlock(par1World, par2, par3, par4, SOUTH);
        boolean W = this.getBlock(par1World, par2, par3, par4, WEST);
        boolean U = this.getBlock(par1World, par2, par3, par4, UP);
        boolean D = this.getBlock(par1World, par2, par3, par4, DOWN);
        
        float x1 = (float)(0);
        float x2 = (float)(0.4375);
        float x3 = (float)(0.5);
        float x4 = (float)(0.5625);
        float x5 = (float)(1);
        
        float y1 = (float)(0);
        float y2 = (float)(0.4375);
        float y3 = (float)(0.5);
        float y4 = (float)(0.5625);
        float y5 = (float)(1);
		
        float z1 = (float)(0);
        float z2 = (float)(0.4375);
        float z3 = (float)(0.5);
        float z4 = (float)(0.5625);
        float z5 = (float)(1);
		

        switch((int)Math.floor((double)meta / 4))
        {
	        case 0:
	        	// South
	    	break;
	        case 1:
	        	// West
	        	switch(meta % 4)
	        	{
		        	case 0:
			        	// Ridge
		        		if(W && E)
		        		{
		        			// Ridge Center
		        		}
		        		else if(W)
		        		{
		        			// Ridge Back
		        		}
		        		else if(E)
		        		{
		        			// Ridge Front
		        		}
			    	break;
			        case 1:
			        	// Right
			        	if(W && E)
		        		{
		        			// Right Center
			        		this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
			        		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
			        		super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
		        		}
		        		else if(W)
		        		{
		        			// Right Back
		        		}
		        		else if(E)
		        		{
		        			// Right Front
		        		}
			    	break;
			        case 2:
			        	// Left
			        	if(W && E)
		        		{
		        			// Left Center
		        		}
		        		else if(W)
		        		{
		        			// Left Back
		        		}
		        		else if(E)
		        		{
		        			// Left Front
		        		}
			    	break;
			        case 3:
			        	// Other
			        	//this.setBlockBounds(x2, y1, z1, x4, y5, z5);
			        	//super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			    	break;
	        	}
	    	break;
	        case 2:
	        	// North
	    	break;
	        case 3:
	        	// East
	        	switch(meta % 4)
	        	{
		        	case 0:
		        		// Ridge
		        		if(W && E)
		        		{
		        			// Ridge Center
		        		}
		        		else if(W)
		        		{
		        			// Ridge Front
		        		}
		        		else if(E)
		        		{
		        			// Ridge Back
		        		}
			    	break;
			        case 1:
			        	// Right
			        	if(W && E)
		        		{
		        			// Right Center
		        		}
		        		else if(W)
		        		{
		        			// Right Front
		        		}
		        		else if(E)
		        		{
		        			// Right Back
		        		}
			    	break;
			        case 2:
			        	// Left
			        	if(W && E)
		        		{
		        			// Left Center
		        		}
		        		else if(W)
		        		{
		        			// Left Front
		        		}
		        		else if(E)
		        		{
		        			// Left Back
		        		}
			    	break;
			        case 3:
			        	// Other
			        	this.setBlockBounds(x2, y1, z1, x4, y5, z5);
			        	super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
			    	break;
	        	}
	    	break;
        }
    }
}
