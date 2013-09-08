package bms;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityWaterRune extends EntityRune {
	
	public EntityWaterRune(World par1World)
    {
        super(par1World);
        effectStr = "waterRuneTrail";
    }
	
	public EntityWaterRune(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
        effectStr = "waterRuneTrail";
    }
	
	public EntityWaterRune(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World);
        setDirectionVariables(par2EntityLivingBase, par3EntityLivingBase, par4, par5);
        effectStr = "waterRuneTrail";
    }
	
	public void performRuneEffect(MovingObjectPosition mop)
    {
		int x = (int)posX;
		int z = (int)posZ;
		for(int y = (int)this.posY - 1; y < (int)this.posY + 5; y++){
			if(worldObj.getBlockId(x, y + 1, z) == 0 && worldObj.getBlockId(x, y, z) != 0 && 
			   worldObj.getBlockId(x, y, z) != Block.waterStill.blockID && worldObj.getBlockId(x, y, z) != Block.waterMoving.blockID){
				worldObj.setBlock(x, y + 1, z, Block.waterMoving.blockID, 0, 2);
				break;
			}
		}
    }
}
