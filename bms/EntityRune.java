package bms;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityRune extends EntityThrowable
{
	public class Trail
	{
		double x, y, z, vX, vY, vZ;

		public void update()
		{
			this.x += this.vX;
			this.y += this.vY;
			this.z += this.vZ;
			this.drawParticle();
			this.vY -= 0.1;
		}

		private void drawParticle()
		{
			for (int i = 0; i < 5; ++i){
    			worldObj.spawnParticle(effectStr, this.x, this.y, this.z, rand.nextGaussian() * 0.05D, -this.vY * 0.5D, rand.nextGaussian() * 0.05D);
            }
		}
	}

	int deathTimer = -1;
	String effectStr = "magicCrit";
	Trail[] trail;
	
    public EntityRune(World par1World)
    {
        super(par1World);
    }

    public EntityRune(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityRune(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
    public void setDirectionVariables(EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
    	this.posY = par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
        double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
        double d1 = par3EntityLivingBase.boundingBox.minY + (double)(par3EntityLivingBase.height / 3.0F) - this.posY;
        double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if (d3 >= 1.0E-7D){
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double)f4, d2, par4, par5);
        }
    }
    
    public void onUpdate()
    {
    	if(deathTimer < 0){
    		super.onUpdate();
			this.spawnTrailParticles();
	    	
	    	Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
	        Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
	        MovingObjectPosition movingobjectposition = this.worldObj.clip(vec3, vec31);
	        vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
	        vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
	    	if (movingobjectposition != null){
	            vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
	        }
	    	
	    	Entity entity = null;
	        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
	        double d0 = 0.0D;
	
	        for (int j = 0; j < list.size(); ++j){
	            Entity entity1 = (Entity)list.get(j);
	            if(entity1.canBeCollidedWith()){
	                float f = 0.3F;
	                AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
	                MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);
	                if (movingobjectposition1 != null){
	                    double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
	                    if (d1 < d0 || d0 == 0.0D){
	                        entity = entity1;
	                        d0 = d1;
	                    }
	                }
	            }
	        }
	        
	        if (entity != null){
	        	DamageSource damagesource = null;
	        	damagesource = DamageSource.causeThornsDamage(entity);
	        	entity.attackEntityFrom(damagesource, 12.0f);
	            movingobjectposition = new MovingObjectPosition(entity);
	        }
	        
	        if (movingobjectposition != null){
	        	this.deathTimer = 20;
	        	this.initExplosion();
	        	this.performRuneEffect(movingobjectposition);
	        }
    	} else {
    		if(this.deathTimer > 0){
    			this.deathTimer--;
    			this.updateExplosionPositions();
    		} else {
    			if(!this.worldObj.isRemote){
            		this.setDead();
            	}
    		}
    	}
    }
    
    public void performRuneEffect(MovingObjectPosition mop)
    { }
    
    public void spawnTrailParticles()
    {
    	for (int i = 0; i < 5; ++i){
			this.worldObj.spawnParticle(effectStr, this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.05D, -this.motionY * 0.5D, this.rand.nextGaussian() * 0.05D);
			this.worldObj.spawnParticle(effectStr, this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.05D, (-this.motionY * 0.5D) + 0.3f, this.rand.nextGaussian() * 0.05D);
			this.worldObj.spawnParticle(effectStr, this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.05D, (-this.motionY * 0.5D) - 0.3f, this.rand.nextGaussian() * 0.05D);
			this.worldObj.spawnParticle(effectStr, this.posX, this.posY, this.posZ, this.rand.nextGaussian() * 0.05D, -this.motionY * 0.5D, (this.rand.nextGaussian() * 0.05D) + 0.3f);
			this.worldObj.spawnParticle(effectStr, this.posX, this.posY, this.posZ, (this.rand.nextGaussian() * 0.05D) + 0.3f, -this.motionY * 0.5D, this.rand.nextGaussian() * 0.05D);
        }
    }
    
    public void initExplosion()
    {
    	//double x, y, z, vX, vY, vZ;
    	int minTrails = 10; int maxTrails = 25;
    	int trailNum = (int)(minTrails + (Math.random() * maxTrails));
    	double randomNum;
    	trail = new Trail[trailNum];
    	for(int i = 0; i < trail.length; i++){
    		trail[i] = new Trail();
    		trail[i].x = this.posX;
    		trail[i].y = this.posY;
    		trail[i].z = this.posZ;
    		trail[i].vX = (Math.random() * 3.0d) - 1.5d;
    		trail[i].vY = (0.5d + (Math.random() * 1.0d));
    		trail[i].vZ = (Math.random() * 3.0d) - 1.5d;
    	}
    }
    
    public void updateExplosionPositions()
    {
    	for(int i = 0; i < trail.length; i++){
    		trail[i].update();
    	}
    }
    
    public void onImpact(MovingObjectPosition movingobjectposition)
    { }
    
    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return super.getBrightness(par1);
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1)
    {
        return super.getBrightnessForRender(par1);
    }
}


//magicCrit