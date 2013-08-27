package bms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSlingshot extends Item
{
    public ItemSlingshot(int id)
    {
        super(id);
        maxStackSize = 1;
        setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

        if (par3EntityPlayer.inventory.hasItem(ItemsBMS.pebble.itemID)) {
        	par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        	par3EntityPlayer.swingItem();
        	if(!flag){
        		par3EntityPlayer.inventory.consumeInventoryItem(ItemsBMS.pebble.itemID);
        	}
        	if (!par2World.isRemote) {
                par2World.spawnEntityInWorld(new EntityPebble(par2World, par3EntityPlayer));
            }
        }

        return par1ItemStack;
    }
}
