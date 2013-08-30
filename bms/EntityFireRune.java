package bms;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFireRune extends EntityRune {
	
	public EntityFireRune(World par1World)
    {
        super(par1World);
        effectStr = "fireRuneTrail";
    }
	
	public EntityFireRune(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        effectStr = "fireRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
    	//worldObj.getBlockId(par1, par2, par3)
    	//worldObj.setBlock(par1, par2, par3, blockID, 0, 2)
    	/*if(!entity.isBurning()){
            entity.setFire(5);
        }*/
    }
}
