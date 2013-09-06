package bms;

import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntitySkeletonMage extends EntitySkeleton {
	
	protected byte runeNum;
	protected int mageRuneDropID;
	protected int mageStaffDropID;
	protected EntityAIRuneAttack aiRuneAttack = new EntityAIRuneAttack(this, 1.0D, 20, 60, 15.0F);
	protected EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);
	public EntitySkeletonMage(World world)
    {
        super(world);
        runeNum = 32;
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
	
	protected int getDropItemId()
    {
		return mageRuneDropID;
    }
	
	protected void dropFewItems(boolean par1, int par2)
    {
		if(runeNum > 1)
			this.dropItem(mageRuneDropID, (int)runeNum/2);
		
		if(1 + (int)(Math.random() * 100) > 95)
			this.dropItem(mageStaffDropID, 1);
    }
	
	public EntityLivingData func_110161_a(EntityLivingData par1EntityLivingData)
    {
		this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05D, 1));

        this.tasks.addTask(4, this.aiRuneAttack);
        this.addRandomArmor();
        this.enchantEquipment();

        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj.func_110746_b(this.posX, this.posY, this.posZ));

        if (this.getCurrentItemOrArmor(4) == null)
        {
            Calendar calendar = this.worldObj.getCurrentDate();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern : Block.pumpkin));
                this.equipmentDropChances[4] = 0.0F;
            }
        }

        return par1EntityLivingData;
    }
	
	public void setCombatTask()
    {
        this.tasks.removeTask(this.aiAttackOnCollide);
        this.tasks.removeTask(this.aiRuneAttack);
        ItemStack itemstack = this.getHeldItem();

        if (itemstack != null && itemstack.itemID == Item.bow.itemID)
        {
            this.tasks.addTask(4, this.aiRuneAttack);
        }
        else
        {
            this.tasks.addTask(4, this.aiAttackOnCollide);
        }
    }

}












