package bms;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMageWater extends EntitySkeletonMage {

	public EntitySkeletonMageWater(World world)
	{
		super(world);
		skeliType = 1;
	}
	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.waterStaff));
    }

}
