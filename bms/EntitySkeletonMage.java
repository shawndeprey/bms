package bms;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMage extends EntitySkeleton {

	public EntitySkeletonMage(World world)
    {
        super(world);
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.fireStaff));
    }
	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(ItemsBMS.fireStaff));
    }

}
