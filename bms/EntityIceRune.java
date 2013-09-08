package bms;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
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
	
	public EntityIceRune(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World);
        setDirectionVariables(par2EntityLivingBase, par3EntityLivingBase, par4, par5);
        effectStr = "iceRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
    	for(int x = (int)this.posX - 5; x < (int)this.posX + 5; x++){
    		for(int y = (int)this.posY - 5; y < (int)this.posY + 5; y++){
    			for(int z = (int)this.posZ - 5; z < (int)this.posZ + 5; z++){
    				
    				int j1 = worldObj.getBlockId(x, y, z);
    				int j2 = worldObj.getBlockId(x, y - 1, z);
    				if(j1 == Block.waterStill.blockID || j1 == Block.waterMoving.blockID){
    					worldObj.setBlock(x, y, z, Block.ice.blockID, 0, 2);
    				} else
    				if(j1 == 0 && j2 != 0 && j2 != Block.snow.blockID && j2 != Block.ice.blockID && Block.isNormalCube(j2)){
    					worldObj.setBlock(x, y, z, Block.snow.blockID, 0, 2);
    				}
    				
    			}
    		}
    	}
    }
}
