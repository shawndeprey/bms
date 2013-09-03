package bms;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMageFire extends EntitySkeletonMage {

	public EntitySkeletonMageFire(World world)
	{
		super(world);
		skeliType = 0;
	}
	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.fireStaff));
    }

}
