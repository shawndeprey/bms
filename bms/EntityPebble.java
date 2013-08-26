package bms;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPebble extends EntityThrowable
{
    public EntityPebble(World par1World)
    {
        super(par1World);
    }

    public EntityPebble(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityPebble(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
    @Override
    public void onUpdate()
    {
    	this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    	super.onUpdate();
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null){
            byte b0 = 0;

            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze){
                b0 = 3;
            }
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2f);
        }

        for (int i = 0; i < 25; ++i){
        	this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        
        worldObj.playSoundAtEntity(this, "random.click", 0.5F, 0.4F / (16.0f * 0.4F + 0.8F));

        if (!this.worldObj.isRemote){
            this.setDead();
        }
    }
}
