package bms;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderBMS {
	public static boolean registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new RenderSnowball(ItemsBMS.pebble));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireRune.class, new RenderSnowball(ItemsBMS.blankItem));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaterRune.class, new RenderSnowball(ItemsBMS.blankItem));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceRune.class, new RenderSnowball(ItemsBMS.blankItem));
		RenderingRegistry.registerEntityRenderingHandler(EntityEarthRune.class, new RenderSnowball(ItemsBMS.blankItem));
		RenderingRegistry.registerEntityRenderingHandler(EntityCitrineRune.class, new RenderSnowball(ItemsBMS.blankItem));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonMageFire.class, new RenderSkeletonMage());
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonMageWater.class, new RenderSkeletonMage());
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonMageIce.class, new RenderSkeletonMage());
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonMageEarth.class, new RenderSkeletonMage());
		
		return true;
	}
}
