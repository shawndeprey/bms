package bms;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderBMS {
	public static boolean registerRenderers()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new RenderSnowball(ItemsBMS.pebble));
		
		return true;
	}
}
