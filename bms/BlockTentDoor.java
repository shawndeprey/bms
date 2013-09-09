package bms;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTentDoor extends BlockDoor{

    @SideOnly(Side.CLIENT)
    private Icon tex_upper;
    @SideOnly(Side.CLIENT)
    private Icon tex_lower;
    
    private String texName;
    
	protected BlockTentDoor(int par1, Material par2Material, String name)
	{
		super(par1, par2Material);
		setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundClothFootstep);
        setUnlocalizedName(name);
        texName = name;
        
        // Add Solid Block Texture
        //func_111022_d(BasicInfo.ID.toLowerCase() + ":" + name);
	}

	public int getRenderType()
    {
        return 43;
    }
	
	 public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return ItemsBMS.doorTent.itemID;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
    	return ItemsBMS.doorTent.itemID;
    }
    
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.tex_upper = par1IconRegister.registerIcon(BasicInfo.ID.toLowerCase() + ":" + texName + "_upper");
        this.tex_lower = par1IconRegister.registerIcon(BasicInfo.ID.toLowerCase() + ":" + texName + "_lower");
    }

    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
            return par5 == 0 ? tex_lower : tex_upper;
    }
}