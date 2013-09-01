package bms;

import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockTentDoor extends BlockDoor{

	/*
		Meta Data
		0 =		North Open Right
		1 =		North Closed Right
		2 =		South Open Right
		3 =		South Open Left
		4 =		
		5 =		
		6 =		
		7 =		
		8 =		
		9 =		
		10 =	
		11 =	
		12 =	
		13 =	
		14 =	
		14 =	
	 */
	protected BlockTentDoor(int par1, Material par2Material, String name)
	{
		super(par1, par2Material);
		setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundClothFootstep);
        setUnlocalizedName(name);
        
        // Add Solid Block Texture
        func_111022_d(BasicInfo.ID.toLowerCase() + ":" + name);
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
}