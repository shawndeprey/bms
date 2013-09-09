package bms;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockCampfire extends Block {
	
	public BlockCampfire(int par1)
    {
        this(par1, Material.wood);
    }
	
	public BlockCampfire(int par1, Material material)
    {
        super(par1, material);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 1F, 0.5F + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		world.setBlock(par2, par3, par4, BlocksBMS.campfireLit.blockID);
        return true;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
}
