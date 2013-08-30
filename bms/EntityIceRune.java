package bms;

import net.minecraft.block.Block;
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
    	for(int x = (int)this.posX - 5; x < (int)this.posX + 5; x++){
    		for(int y = (int)this.posY - 5; y < (int)this.posY + 5; y++){
    			for(int z = (int)this.posZ - 5; z < (int)this.posZ + 5; z++){
    				if(worldObj.getBlockId(x, y, z) == Block.waterStill.blockID || 
    				   worldObj.getBlockId(x, y, z) == Block.waterMoving.blockID){
    					worldObj.setBlock(x, y, z, Block.ice.blockID, 0, 2);
    				} else
    				if(worldObj.getBlockId(x, y, z) == 0 && 
    				   worldObj.getBlockId(x, y - 1, z) != 0 && 
    				   worldObj.getBlockId(x, y - 1, z) != Block.snow.blockID &&
    				   worldObj.getBlockId(x, y - 1, z) != Block.ice.blockID){
    					worldObj.setBlock(x, y, z, Block.snow.blockID, 0, 2);
    				}
    			}
    		}
    	}
    }
}
