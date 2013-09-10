package bms;

import java.util.Random;

import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCampfireLit extends BlockCampfire {
	
	float baseLife = 0.95f;
	public BlockCampfireLit(int par1)
    {
        this(par1, Material.wood);
    }
	
	public BlockCampfireLit(int par1, Material material)
    {
        super(par1, material);
        this.setTickRandomly(true);
    }
	
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		world.setBlock(par2, par3, par4, BlocksBMS.campfireUnlit.blockID);
        return true;
    }
	
	public void updateTick(World world, int par2, int par3, int par4, Random par5Random)
	{
		/*if (!world.isRemote)
        {
			int meta = world.getBlockMetadata(par2, par3, par4);
			meta++;
        	if(meta > 9){
        		world.spawnEntityInWorld(new EntityItem(world, (double)par2 + 0.5D, (double)par3 + 1.5D, (double)par4 + 0.5D, new ItemStack(Item.coal.itemID, (int)(1 + Math.random() * 5), 1)));
        		world.setBlockToAir(par2, par3, par4);
        	} else {
        		world.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
        	}
        }*/
	}
	
	public int idDropped(int metadata, Random random, int fortune){
		return BlocksBMS.campfireUnlit.blockID;
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int par2, int par3, int par4, Random par5Random)
    {
		int meta = world.getBlockMetadata(par2, par3, par4);
        double d0 = (double)((float)par2 + 0.5F);
        double d1 = (double)((float)par3 + 0.5F);
        double d2 = (double)((float)par4 + 0.5F);
        double x, y, z;
        
        if(Math.random() > 0.10f + (meta / 40)){
        	for(int i = (16 - meta); i > 0; i--){
	        	x = d0 + (Math.random() / 4) - (Math.random() / 4);
	        	y = d1 + (Math.random() / 4) - (Math.random() / 4);
	        	z = d2 + (Math.random() / 4) - (Math.random() / 4);
	        	world.spawnParticle("smoke", x, y, z, 0.0D, 0.0D, 0.0D);
		        world.spawnParticle("flame", x, y, z, 0.0D, 0.0D, 0.0D);
	        }
        }
    }
}
