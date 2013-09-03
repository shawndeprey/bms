package bms;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMageIce extends EntitySkeletonMage {

		
	public EntitySkeletonMageIce(World world)
	{
		super(world);
		skeliType = 2;
	}
	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.iceStaff));
    }

}
