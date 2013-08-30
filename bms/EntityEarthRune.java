package bms;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEarthRune extends EntityRune {
	
	Random random = new Random();
	
	public EntityEarthRune(World par1World)
    {
        super(par1World);
        effectStr = "earthRuneTrail";
    }
	
	public EntityEarthRune(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        effectStr = "earthRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
		for(int x = (int)this.posX - 5; x < (int)this.posX + 5; x++){
    		for(int y = (int)this.posY - 5; y < (int)this.posY + 5; y++){
    			for(int z = (int)this.posZ - 5; z < (int)this.posZ + 5; z++){
    				
    				if(worldObj.getBlockId(x, y, z) == Block.dirt.blockID && worldObj.getBlockId(x, y + 1, z) == 0){
    					worldObj.setBlock(x, y, z, Block.grass.blockID, 0, 2);
    				}
    				
    				if(worldObj.getBlockId(x, y, z) == Block.grass.blockID && worldObj.getBlockId(x, y + 1, z) == 0){
    					if(1 + (int)(Math.random() * 100) > 98){
    						switch( 1 + (int)(Math.random() * 3)){
	    						case 1:{
									worldObj.setBlock(x, y + 1, z, Block.plantRed.blockID, 0, 2);
									break;
								}
	    						case 2:{
									worldObj.setBlock(x, y + 1, z, Block.plantYellow.blockID, 0, 2);
									break;
								}
	    						case 3:{
									worldObj.setBlock(x, y + 1, z, Block.tallGrass.blockID, 1, 2);
									break;
								}
    						}
    					}
    				} else
    				if(worldObj.getBlockId(x, y, z) == Block.sand.blockID && worldObj.getBlockId(x, y + 1, z) == 0){
    					if(1 + (int)(Math.random() * 100) > 98){
    						switch( 1 + (int)(Math.random() * 2)){
	    						case 1:{
									worldObj.setBlock(x, y + 1, z, Block.cactus.blockID, 0, 2);
									break;
								}
	    						case 2:{
									worldObj.setBlock(x, y + 1, z, Block.tallGrass.blockID, 0, 2);
									break;
								}
    						}
    					}
    				}
    				
    			}
    		}
    	}
    }
}
