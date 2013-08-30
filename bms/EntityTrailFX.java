package bms;

import java.util.Random;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityTrailFX extends EntityFX
{
    float field_70561_a;
    Random random = new Random();
    int brightness = 240;
    int updateTick = 0;

    public EntityTrailFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        this(par1World, par2, par4, par6, par8, par10, par12, 2.0F);
    }

    public EntityTrailFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, float par14)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += par8 * 0.4D;
        this.motionY += par10 * 0.4D;
        this.motionZ += par12 * 0.4D;
        this.particleRed = this.particleGreen = this.particleBlue = (float)(Math.random() * 0.30000001192092896D + 0.6000000238418579D);
        this.particleScale *= 0.75F;
        this.particleScale *= par14;
        this.field_70561_a = this.particleScale;
        this.particleMaxAge = (int)(6.0D / (Math.random() * 0.8D + 0.6D));
        this.particleMaxAge = (int)((float)this.particleMaxAge * par14);
        this.noClip = false;
        this.setParticleTextureIndex(65);
        this.onUpdate();
    }

    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    	
        float f6 = ((float)this.particleAge + par2) / (float)this.particleMaxAge * 32.0F;
        if (f6 < 0.0F){
            f6 = 0.0F;
        }
        if (f6 > 1.0F){
            f6 = 1.0F;
        }
        par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);
        
        par1Tessellator.setBrightness(brightness);

        this.particleScale = this.field_70561_a * f6;
        //super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
        float f15 = (float)this.particleTextureIndexX / 16.0F;
        float f7 = f15 + 0.0624375F;
        float f8 = (float)this.particleTextureIndexY / 16.0F;
        float f9 = f8 + 0.0624375F;
        float f10 = 0.1F * this.particleScale;

        if (this.particleIcon != null)
        {
        	f15 = this.particleIcon.getMinU();
            f7 = this.particleIcon.getMaxU();
            f8 = this.particleIcon.getMinV();
            f9 = this.particleIcon.getMaxV();
        }

        float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)par2 - interpPosX);
        float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)par2 - interpPosY);
        float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)par2 - interpPosZ);
        float f14 = 1.0F;
        par1Tessellator.setColorRGBA_F(this.particleRed * f14, this.particleGreen * f14, this.particleBlue * f14, this.particleAlpha);
        par1Tessellator.addVertexWithUV((double)(f11 - par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 - par5 * f10 - par7 * f10), (double)f7, (double)f9);
        par1Tessellator.addVertexWithUV((double)(f11 - par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 - par5 * f10 + par7 * f10), (double)f7, (double)f8);
        par1Tessellator.addVertexWithUV((double)(f11 + par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 + par5 * f10 + par7 * f10), (double)f15, (double)f8);
        par1Tessellator.addVertexWithUV((double)(f11 + par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 + par5 * f10 - par7 * f10), (double)f15, (double)f9);
    }
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	updateTick++;
    	
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.particleRed = (float)((double)this.particleRed * 0.9D);
        this.particleGreen = (float)((double)this.particleGreen * 0.9D);
        this.particleBlue = (float)((double)this.particleBlue * 0.9D);
        this.motionX *= 0.999999988079071D;
        this.motionY *= 0.999999988079071D;
        this.motionZ *= 0.999999988079071D;
        this.motionY -= 0.019999999552965164D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}
