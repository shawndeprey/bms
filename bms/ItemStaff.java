package bms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStaff extends Item
{
	int runeType;
    public ItemStaff(int id, int RT)
    {
        super(id);
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabCombat);
        this.runeType = RT;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (par3EntityPlayer.inventory.hasItem(getRuneItemID())) {
        	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        	par3EntityPlayer.swingItem();
        	if(!flag){
        		par3EntityPlayer.inventory.consumeInventoryItem(getRuneItemID());
        	}
        	if (!par2World.isRemote) {
        		if(getRuneItemID() == ItemsBMS.fireRune.itemID){
        			par2World.spawnEntityInWorld(new EntityFireRune(par2World, par3EntityPlayer));
        		} else
    			if(getRuneItemID() == ItemsBMS.waterRune.itemID){
        			par2World.spawnEntityInWorld(new EntityWaterRune(par2World, par3EntityPlayer));
        		} else
    			if(getRuneItemID() == ItemsBMS.iceRune.itemID){
        			par2World.spawnEntityInWorld(new EntityIceRune(par2World, par3EntityPlayer));
        		} else
    			if(getRuneItemID() == ItemsBMS.earthRune.itemID){
        			par2World.spawnEntityInWorld(new EntityEarthRune(par2World, par3EntityPlayer));
        		} else
    			if(getRuneItemID() == ItemsBMS.citrineRune.itemID){
        			par2World.spawnEntityInWorld(new EntityCitrineRune(par2World, par3EntityPlayer));
        		}
        	}
        }

        return par1ItemStack;
    }
    
    private int getRuneItemID()
    {
    	int[] types = {ItemsBMS.fireRune.itemID, ItemsBMS.waterRune.itemID, ItemsBMS.iceRune.itemID, ItemsBMS.earthRune.itemID, ItemsBMS.citrineRune.itemID};
    	return types[this.runeType];
    }
}
