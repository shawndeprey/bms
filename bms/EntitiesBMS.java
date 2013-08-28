package bms;

import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntitiesBMS {
	public static boolean registerEntities(Bms BMS)
	{
		EntityRegistry.registerModEntity(EntityPebble.class, "Entity Pebble", ModLoader.getUniqueEntityId(), BMS, 128, 1, true);
		return true;
	}
}
