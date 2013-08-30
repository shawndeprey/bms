package bms;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityCitrineRune extends EntityRune {
	
	public EntityCitrineRune(World par1World)
    {
        super(par1World);
        effectStr = "citrineRuneTrail";
    }
	
	public EntityCitrineRune(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        effectStr = "citrineRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, true);
    }
}
