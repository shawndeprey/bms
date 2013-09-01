package bms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBMSIngots extends Item {

	public ItemBMSIngots(int id, String itemName) {
		super(id);
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(itemName);
		
		// Sets item Texture
		func_111206_d(BasicInfo.ID.toLowerCase() + ":" + itemName);
	}

}
