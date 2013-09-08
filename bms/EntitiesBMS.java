package bms;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntitiesBMS {
	public static boolean registerEntities(Bms BMS)
	{
		EntityRegistry.registerModEntity(EntityPebble.class, "Entity Pebble", 9000, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityFireRune.class, "Entity Fire Rune", 9100, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityWaterRune.class, "Entity Water Rune", 9200, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityIceRune.class, "Entity Ice Rune", 9300, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityEarthRune.class, "Entity Earth Rune", 9400, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntityCitrineRune.class, "Entity Citrine Rune", 9500, BMS, 128, 1, true);
		
		// (class, entityName, entityID, modClass, trackingRange, updateFrequency, sendVelocityUpdates)
		EntityRegistry.registerModEntity(EntitySkeletonMageFire.class, "Skeleton Mage Fire", 9600, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntitySkeletonMageWater.class, "Skeleton Mage Water", 9700, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntitySkeletonMageIce.class, "Skeleton Mage Ice", 9800, BMS, 128, 1, true);
		EntityRegistry.registerModEntity(EntitySkeletonMageEarth.class, "Skeleton Mage Earth", 9900, BMS, 128, 1, true);
		// (class, spawnChance, minGroupSize, maxGroupSize, mobType, spawnBiomes * n)
		EntityRegistry.addSpawn(EntitySkeletonMageFire.class, 4, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
			LanguageRegistry.instance().addStringLocalization("Bms.EntitySkeletonMageFire.name", "Skeleton Mage Fire");
		EntityRegistry.addSpawn(EntitySkeletonMageWater.class, 4, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
			LanguageRegistry.instance().addStringLocalization("Bms.EntitySkeletonMageWater.name", "Skeleton Mage Water");
		EntityRegistry.addSpawn(EntitySkeletonMageIce.class, 4, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
			LanguageRegistry.instance().addStringLocalization("Bms.EntitySkeletonMageIce.name", "Skeleton Mage Ice");
		EntityRegistry.addSpawn(EntitySkeletonMageEarth.class, 4, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland);
			LanguageRegistry.instance().addStringLocalization("Bms.EntitySkeletonMageEarth.name", "Skeleton Mage Earth");
			
		EntityRegistry.findGlobalUniqueEntityId();
		return true;
	}
}
