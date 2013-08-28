package bms;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlocksTent extends Block {

	public BlocksTent(int id, Material material, String name) {
		super(id, material);
		setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundClothFootstep);
        setUnlocalizedName(name);
        
        // Add Solid Block Texture
        func_111022_d(BasicInfo.ID.toLowerCase() + ":" + name);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if (par1World.isRemote)
        {
            return true;
        }
        else
        {
			
			buildTent(par1World, x, y, z, getDirection(Math.abs((int)par5EntityPlayer.rotationYaw)));
	        return false;
        }
    }
	
	public int getDirection(int direction)
	{
		return Math.round((float)(((direction + 45) % 360) / 90));
	}
	
	public void buildTent(World world, int x, int y, int z, int direction)
	{
		world.setBlock(x + 1, y, z, BlocksBMS.tentBlock.blockID, 0, 2);
	}
}
