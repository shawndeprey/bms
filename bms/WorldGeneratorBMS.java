package bms;

import net.minecraft.world.gen.feature.WorldGenFlowers;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGeneratorBMS {
	public static boolean registerGenerator()
	{
		GameRegistry.registerWorldGenerator(new BMSOreWorldGenerator());
		GameRegistry.registerWorldGenerator(new BMSFlowerWorldGenerator());
		return true;
	}
}
