package bms;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

public class RenderSkeletonMage extends RenderSkeleton {
	private static final ResourceLocation texture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage.png");
	public RenderSkeletonMage() {
		super();
	}
	
	protected ResourceLocation func_110860_a(EntitySkeleton par1EntitySkeleton)
    {
        return texture;
    }

}
