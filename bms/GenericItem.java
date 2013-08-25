package bms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GenericItem extends Item {

	public GenericItem(int id) {
		super(id);
		
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("genericItem");
		// Sets item Texture
		func_111206_d(BasicInfo.ID.toLowerCase() + ":genericItem");
	}
	
	@Override
	public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase target){
		// Right Click Functionality
		if(!target.worldObj.isRemote){
			if(target instanceof EntityCreeper || target instanceof EntityZombie){
				if(player.isInWater()){
					player.addChatMessage("You're in water stupid!");
				} else {
					target.motionY = 2.5f;
				}
			} else {
				player.addChatMessage("This item only works on hostile mobs.");
			}
		}
		return false;
	}

}
