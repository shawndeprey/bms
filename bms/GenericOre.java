package bms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericOre extends Block {
	public GenericOre(int id, Material material){
		super(id, material);
		
		setHardness(4.0f);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName("GenericOre");
		setCreativeTab(CreativeTabs.tabBlock);
		
		// Add Solid Block Texture
		func_111022_d(BasicInfo.ID.toLowerCase() + ":genericBlock");
	}
	
	public int idDropped(int metadata, Random random, int fortune){
		return Item.ingotIron.itemID;
	}
}