package bms;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGeneratorBMS {
	public static boolean registerGenerator()
	{
		GameRegistry.registerWorldGenerator(new BMSOreWorldGenerator());
		return true;
	}
}
