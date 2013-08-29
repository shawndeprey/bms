package bms;

import static net.minecraftforge.common.ForgeDirection.NORTH;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
}
