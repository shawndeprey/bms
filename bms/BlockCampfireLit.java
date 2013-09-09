package bms;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
        
        if(Math.random() < 0.01f + (meta / 1000)){
        	meta++;
        	if(meta > 15){
        		//this.dropItem(mageRuneDropID, 6 + (int)(Math.random() * 14));
        		world.setBlockToAir(par2, par3, par4);
        	} else {
        		world.setBlockMetadataWithNotify(par2, par3, par4, meta, 2);
        	}
        }	
    }
}
