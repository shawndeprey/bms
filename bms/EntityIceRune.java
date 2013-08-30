package bms;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIceRune extends EntityRune {
	
	public EntityIceRune(World par1World)
    {
        super(par1World);
        effectStr = "iceRuneTrail";
    }
	
	public EntityIceRune(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        effectStr = "iceRuneTrail";
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
