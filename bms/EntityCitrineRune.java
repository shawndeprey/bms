package bms;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
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
	
	public EntityCitrineRune(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World);
        setDirectionVariables(par2EntityLivingBase, par3EntityLivingBase, par4, par5);
        effectStr = "citrineRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
		if (!this.worldObj.isRemote) {
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, true);
		}
    }
}
