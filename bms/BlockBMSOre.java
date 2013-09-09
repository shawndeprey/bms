package bms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBMSOre extends Block {
	private int ID;
	public BlockBMSOre(int id, int dropID, Material material, String blockName){
		super(id, material);
		ID = dropID;
		setHardness(4.0f);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(blockName);
		setCreativeTab(CreativeTabs.tabBlock);
		
		// Add Solid Block Texture
		func_111022_d(BasicInfo.ID.toLowerCase() + ":" + blockName);
	}
	
	public int idDropped(int metadata, Random random, int fortune){
		return ID;
	}
	
	public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        if (par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1)){
            int j = par2Random.nextInt(par1 + 2) - 1;
            j = j < 0 ? 0 : j;
            return this.quantityDropped(par2Random) * (j + 1);
        } else {
            return this.quantityDropped(par2Random);
        }
    }
	
	public int quantityDropped(Random par1Random)
    {
        return 1;
    }
}