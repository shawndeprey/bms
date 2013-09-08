package bms;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMageFire extends EntitySkeletonMage {

	public EntitySkeletonMageFire(World world)
	{
		super(world);
		skeliType = 0;
		mageRuneDropID = ItemsBMS.fireRune.itemID;
		mageStaffDropID = ItemsBMS.fireStaff.itemID;
	}
	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.fireStaff));
    }

}
