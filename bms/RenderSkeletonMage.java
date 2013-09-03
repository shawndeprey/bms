package bms;

import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

public class RenderSkeletonMage extends RenderSkeleton {
	private static final ResourceLocation fireTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_red.png");
	private static final ResourceLocation waterTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_blue.png");
	private static final ResourceLocation iceTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_light_blue.png");
	private static final ResourceLocation earthTexture = new ResourceLocation("bms:textures/models/mobs/skeleton_mage_green.png");
	public RenderSkeletonMage() {
		super();
	}
	
	protected ResourceLocation func_110860_a(EntitySkeleton esm)
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

}
