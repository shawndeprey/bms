package bms;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
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
	
	public EntityFireRune(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World);
        setDirectionVariables(par2EntityLivingBase, par3EntityLivingBase, par4, par5);
        effectStr = "fireRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
		if(mop.entityHit != null){
			if(!mop.entityHit.isBurning()){
				mop.entityHit.setFire(5);
	        }
		} else {
			for(int y = (int)this.posY - 1; y < (int)this.posY + 5; y++){
				if(worldObj.getBlockId((int)posX, y + 1, (int)posZ) == 0 && worldObj.getBlockId((int)posX, y, (int)posZ) != 0){
					worldObj.setBlock((int)posX, y + 1, (int)posZ, Block.fire.blockID, 0, 2);
					break;
				}
			}
			
			for(int x = (int)this.posX - 3; x < (int)this.posX + 3; x++){
	    		for(int y = (int)this.posY; y < (int)this.posY + 1; y++){
	    			for(int z = (int)this.posZ - 3; z < (int)this.posZ + 3; z++){
	    				if(worldObj.getBlockId(x, y, z) == 0 && worldObj.getBlockId(x, y - 1, z) != 0){
	    					if(1 + (int)(Math.random() * 200) > 195){
	    						worldObj.setBlock(x, y, z, Block.fire.blockID, 0, 2);
	    					}
	    				}
	    			}
	    		}
			}
		}
    }
}
