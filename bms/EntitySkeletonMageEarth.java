package bms;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMageEarth extends EntitySkeletonMage {

	public EntitySkeletonMageEarth(World world)
	{
		super(world);
		skeliType = 3;
		mageRuneDropID = ItemsBMS.earthRune.itemID;
		mageStaffDropID = ItemsBMS.earthStaff.itemID;
	}
	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.earthStaff));
    }

}
