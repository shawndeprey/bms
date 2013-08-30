package bms;

import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntitiesBMS {
	public static boolean registerEntities(Bms BMS)
	{
		EntityRegistry.registerModEntity(EntityPebble.class, "Entity Pebble", 9000, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityFireRune.class, "Entity Fire Rune", 9100, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityWaterRune.class, "Entity Water Rune", 9200, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityIceRune.class, "Entity Ice Rune", 9300, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityEarthRune.class, "Entity Earth Rune", 9400, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityCitrineRune.class, "Entity Citrine Rune", 9500, BMS, 128, 1, true);
		return true;
	}
}
