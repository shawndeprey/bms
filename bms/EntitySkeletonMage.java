package bms;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySkeletonMage extends EntitySkeleton {

	public EntitySkeletonMage(World world)
    {
        super(world);
    }
	
	protected void addRandomArmor()
    {
        if (this.rand.nextFloat() < 0.15F * this.worldObj.func_110746_b(this.posX, this.posY, this.posZ))
        {
            int i = this.rand.nextInt(2);
            float f = this.worldObj.difficultySetting == 3 ? 0.1F : 0.25F;
            if (this.rand.nextFloat() < 0.095F){++i;} // Wut
            if (this.rand.nextFloat() < 0.095F){++i;} // Notch
            if (this.rand.nextFloat() < 0.095F){++i;} // Do...
            for (int j = 2; j >= 0; --j){
                ItemStack itemstack = this.func_130225_q(j);
                if (j < 2 && this.rand.nextFloat() < f){
                    break;
                }
                if (itemstack == null){
                    Item item = getArmorItemForSlot(j + 1, i);

                    if (item != null){
                        this.setCurrentItemOrArmor(j + 1, new ItemStack(item));
                    }
                }
            }
        }
    }
	
	public static Item getArmorItemForSlot(int par0, int par1)
    {
        switch (par0){
            case 3: // Chest
                return ItemsBMS.linenChest;
            case 2: // Pants
                return ItemsBMS.linenPants;
            case 1: // Boots
                return ItemsBMS.linenBoots;
            default:
                return null;
        }
    }

}
