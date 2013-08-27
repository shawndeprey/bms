package bms;

import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntitiesBMS {
	
	public static boolean registerEntities(Bms instance)
	{
		EntityRegistry.registerModEntity(EntityPebble.class, "Entity Pebble", ModLoader.getUniqueEntityId(), instance, 128, 1, true);
		
		return true;
	}
}
