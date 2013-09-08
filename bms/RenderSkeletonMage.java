package bms;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSkeletonMage extends RenderBiped
{
	private static final ResourceLocation fireTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_red.png");
	private static final ResourceLocation waterTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_blue.png");
	private static final ResourceLocation iceTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_light_blue.png");
	private static final ResourceLocation earthTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_green.png");

    public RenderSkeletonMage()
    {
        super(new ModelSkeletonMage(), 0.5F);
    }

    protected void func_82438_a(EntitySkeletonMage par1EntitySkeleton, float par2)
    {
        if (par1EntitySkeleton.getSkeletonType() == 1)
        {
            GL11.glScalef(1.2F, 1.2F, 1.2F);
        }
    }

    protected void func_82422_c()
    {
        GL11.glTranslatef(0.09375F, 0.1875F, 0.0F);
    }

    protected ResourceLocation func_110860_a(EntitySkeletonMage esm)
    {
		if(esm.skeliType == 0)
			return fireTexture;
		if(esm.skeliType == 1)
			return waterTexture;
		if(esm.skeliType == 2)
			return iceTexture;
		if(esm.skeliType == 3)
			return earthTexture;
		return fireTexture;
    }

    protected ResourceLocation func_110856_a(EntityLiving par1EntityLiving)
    {
        return this.func_110860_a((EntitySkeletonMage)par1EntityLiving);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.func_82438_a((EntitySkeletonMage)par1EntityLivingBase, par2);
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110860_a((EntitySkeletonMage)par1Entity);
    }
}
