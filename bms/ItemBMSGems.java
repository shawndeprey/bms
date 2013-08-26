package bms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBMSGems extends Item {

	public ItemBMSGems(int id, String itemName) {
		super(id);
		
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(itemName);
		
		// Sets item Texture
		func_111206_d(BasicInfo.ID.toLowerCase() + ":" + itemName);
	}
}
