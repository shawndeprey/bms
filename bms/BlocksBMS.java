package bms;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class BlocksBMS {
	// Stained Glass
	public final static Block stainedGlassRed = 		new BlockStainedGlass(2000, "stainedGlassRed");
	public final static Block stainedGlassPink = 		new BlockStainedGlass(2001, "stainedGlassPink");
	public final static Block stainedGlassOrange = 		new BlockStainedGlass(2002, "stainedGlassOrange");
	public final static Block stainedGlassYellow = 		new BlockStainedGlass(2003, "stainedGlassYellow");
	public final static Block stainedGlassPurple = 		new BlockStainedGlass(2004, "stainedGlassPurple");
	public final static Block stainedGlassLightPurple = new BlockStainedGlass(2005, "stainedGlassLightPurple");
	public final static Block stainedGlassGreen = 		new BlockStainedGlass(2006, "stainedGlassGreen");
	public final static Block stainedGlassLightGreen = 	new BlockStainedGlass(2007, "stainedGlassLightGreen");
	public final static Block stainedGlassBlue = 		new BlockStainedGlass(2008, "stainedGlassBlue");
	public final static Block stainedGlassLightBlue = 	new BlockStainedGlass(2009, "stainedGlassLightBlue");
	public final static Block stainedGlassGrey = 		new BlockStainedGlass(2010, "stainedGlassGrey");
	public final static Block stainedGlassLightGrey = 	new BlockStainedGlass(2011, "stainedGlassLightGrey");
	
	// Stained Glass Panes
	public static final Block thinGlassRed = 			new BlockStainedPane(2012, "stainedGlassRed", "thinGlassRed");
	public static final Block thinGlassPink = 			new BlockStainedPane(2013, "stainedGlassPink", "thinGlassPink");
	public final static Block thinGlassOrange = 		new BlockStainedPane(2014, "stainedGlassOrange", "thinGlassOrange");
	public final static Block thinGlassYellow = 		new BlockStainedPane(2015, "stainedGlassYellow", "thinGlassYellow");
	public final static Block thinGlassPurple = 		new BlockStainedPane(2016, "stainedGlassPurple", "thinGlassPurple");
	public final static Block thinGlassLightPurple = 	new BlockStainedPane(2017, "stainedGlassLightPurple", "thinGlassLightPurple");
	public final static Block thinGlassGreen = 			new BlockStainedPane(2018, "stainedGlassGreen", "thinGlassGreen");
	public final static Block thinGlassLightGreen = 	new BlockStainedPane(2019, "stainedGlassLightGreen", "thinGlassLightGreen");
	public final static Block thinGlassBlue = 			new BlockStainedPane(2020, "stainedGlassBlue", "thinGlassBlue");
	public final static Block thinGlassLightBlue = 		new BlockStainedPane(2021, "stainedGlassLightBlue", "thinGlassLightBlue");
	public final static Block thinGlassGrey = 			new BlockStainedPane(2022, "stainedGlassGrey", "thinGlassGrey");
	public final static Block thinGlassLightGrey = 		new BlockStainedPane(2023, "stainedGlassLightGrey", "thinGlassLightGrey");

	// Ores
	public final static Block titaniumOre =				new BlockBMSOre(2025, 2025, Material.rock, "titaniumOre");
	public final static Block adamantiumOre =			new BlockBMSOre(2026, 2026, Material.rock, "adamantiumOre");
	public final static Block rubyOre =					new BlockBMSOre(2027, 9002, Material.rock, "rubyOre");
	public final static Block sapphireOre =				new BlockBMSOre(2028, 9003, Material.rock, "sapphireOre");
	public final static Block citrineOre =				new BlockBMSOre(2029, 9004, Material.rock, "citrineOre");
	public final static Block jadeiteOre =				new BlockBMSOre(2030, 9005, Material.rock, "jadeiteOre");
	
	// Ore Blocks
	public final static Block titaniumBlock =			new BlockOreStorage(2031).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bms:titaniumBlock").func_111022_d("bms:titaniumBlock");
	public final static Block adamantiumBlock =			new BlockOreStorage(2032).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("adamantiumBlock").func_111022_d("bms:adamantiumBlock");
	
	// Tent Blocks
	public final static Block tentBlock =				new BlocksTent(2033, Material.rock, "tentBlock");
	
	public static boolean registerBlocks()
	{
		// Stained Glass
        GameRegistry.registerBlock(stainedGlassRed, "stainedGlassRed");
    		LanguageRegistry.addName(stainedGlassRed, "Red Stained Glass");
    	GameRegistry.registerBlock(stainedGlassPink, "stainedGlassPink");
    		LanguageRegistry.addName(stainedGlassPink, "Pink Stained Glass");
    	GameRegistry.registerBlock(stainedGlassOrange, "stainedGlassOrange");
    		LanguageRegistry.addName(stainedGlassOrange, "Orange Stained Glass");
    	GameRegistry.registerBlock(stainedGlassYellow, "stainedGlassYellow");
    		LanguageRegistry.addName(stainedGlassYellow, "Yellow Stained Glass");
    	GameRegistry.registerBlock(stainedGlassPurple, "stainedGlassPurple");
    		LanguageRegistry.addName(stainedGlassPurple, "Violet Stained Glass");
    	GameRegistry.registerBlock(stainedGlassLightPurple, "stainedGlassLightPurple");
    		LanguageRegistry.addName(stainedGlassLightPurple, "Light Violet Stained Glass");
    	GameRegistry.registerBlock(stainedGlassGreen, "stainedGlassGreen");
    		LanguageRegistry.addName(stainedGlassGreen, "Green Stained Glass");
    	GameRegistry.registerBlock(stainedGlassLightGreen, "stainedGlassLightGreen");
    		LanguageRegistry.addName(stainedGlassLightGreen, "Light Green Stained Glass");
    	GameRegistry.registerBlock(stainedGlassBlue, "stainedGlassBlue");
    		LanguageRegistry.addName(stainedGlassBlue, "Blue Stained Glass");
    	GameRegistry.registerBlock(stainedGlassLightBlue, "stainedGlassLightBlue");
    		LanguageRegistry.addName(stainedGlassLightBlue, "Light Blue Stained Glass");
    	GameRegistry.registerBlock(stainedGlassGrey, "stainedGlassGrey");
    		LanguageRegistry.addName(stainedGlassGrey, "Grey Stained Glass");
    	GameRegistry.registerBlock(stainedGlassLightGrey, "stainedGlassLightGrey");
    		LanguageRegistry.addName(stainedGlassLightGrey, "Light Grey Stained Glass");
    	GameRegistry.registerBlock(titaniumBlock, "blockTitanium");
    		LanguageRegistry.addName(titaniumBlock, "Block of Titanium");
    	GameRegistry.registerBlock(adamantiumBlock, "blockAdamantium");
    		LanguageRegistry.addName(adamantiumBlock, "Block of Adamantium");
    		
    	// Stained Panes
    	GameRegistry.registerBlock(thinGlassRed, "thinGlassRed");
    		LanguageRegistry.addName(thinGlassRed, "Red Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassPink, "thinGlassPink");
    		LanguageRegistry.addName(thinGlassPink, "Pink Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassOrange, "thinGlassOrange");
    		LanguageRegistry.addName(thinGlassOrange, "Orange Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassYellow, "thinGlassYellow");
    		LanguageRegistry.addName(thinGlassYellow, "Yellow Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassPurple, "thinGlassPurple");
    		LanguageRegistry.addName(thinGlassPurple, "Violet Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassLightPurple, "thinGlassLightPurple");
    		LanguageRegistry.addName(thinGlassLightPurple, "Light Violet Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassGreen, "thinGlassGreen");
    		LanguageRegistry.addName(thinGlassGreen, "Green Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassLightGreen, "thinGlassLightGreen");
    		LanguageRegistry.addName(thinGlassLightGreen, "Light Green Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassBlue, "thinGlassBlue");
    		LanguageRegistry.addName(thinGlassBlue, "Blue Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassLightBlue, "thinGlassLightBlue");
    		LanguageRegistry.addName(thinGlassLightBlue, "Light Blue Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassGrey, "thinGlassGrey");
    		LanguageRegistry.addName(thinGlassGrey, "Grey Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassLightGrey, "thinGlassLightGrey");
    		LanguageRegistry.addName(thinGlassLightGrey, "Light Grey Stained Glass Pane");
    		
    	// Ores
        GameRegistry.registerBlock(titaniumOre, "titaniumOre");
        	LanguageRegistry.addName(titaniumOre, "Titanium Ore");
        	MinecraftForge.setBlockHarvestLevel(titaniumOre, "pickaxe", 3); // 3 = diamond
    	GameRegistry.registerBlock(adamantiumOre, "adamantiumOre");
        	LanguageRegistry.addName(adamantiumOre, "Adamantium Ore");
        	MinecraftForge.setBlockHarvestLevel(adamantiumOre, "pickaxe", 3); // 3 = diamond
    	GameRegistry.registerBlock(rubyOre, "rubyOre");
        	LanguageRegistry.addName(rubyOre, "Ruby Ore");
        	MinecraftForge.setBlockHarvestLevel(rubyOre, "pickaxe", 3); // 3 = diamond
        GameRegistry.registerBlock(sapphireOre, "sapphireOre");
        	LanguageRegistry.addName(sapphireOre, "Sapphire Ore");
        	MinecraftForge.setBlockHarvestLevel(sapphireOre, "pickaxe", 3); // 3 = diamond
    	GameRegistry.registerBlock(citrineOre, "citrineOre");
        	LanguageRegistry.addName(citrineOre, "Citrine Ore");
        	MinecraftForge.setBlockHarvestLevel(citrineOre, "pickaxe", 3); // 3 = diamond
    	GameRegistry.registerBlock(jadeiteOre, "jadeiteOre");
        	LanguageRegistry.addName(jadeiteOre, "Jadeite Ore");
        	MinecraftForge.setBlockHarvestLevel(jadeiteOre, "pickaxe", 3); // 3 = diamond
        	
    	// Tent Block
    	GameRegistry.registerBlock(tentBlock, "tentBlock");
    		LanguageRegistry.addName(tentBlock, "Tent Block");
        	
		return true;
	}
}
