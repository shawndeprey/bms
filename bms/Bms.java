package bms;
 
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid=BasicInfo.ID, name=BasicInfo.NAME, version=BasicInfo.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class Bms {
	
	// Stained Glass (id, name)
	public final static Block stainedGlassRed = new BlockStainedGlass(2000, "stainedGlassRed");
	public final static Block stainedGlassPink = new BlockStainedGlass(2001, "stainedGlassPink");
	public final static Block stainedGlassOrange = new BlockStainedGlass(2002, "stainedGlassOrange");
	public final static Block stainedGlassYellow = new BlockStainedGlass(2003, "stainedGlassYellow");
	public final static Block stainedGlassPurple = new BlockStainedGlass(2004, "stainedGlassPurple");
	public final static Block stainedGlassLightPurple = new BlockStainedGlass(2005, "stainedGlassLightPurple");
	public final static Block stainedGlassGreen = new BlockStainedGlass(2006, "stainedGlassGreen");
	public final static Block stainedGlassLightGreen = new BlockStainedGlass(2007, "stainedGlassLightGreen");
	public final static Block stainedGlassBlue = new BlockStainedGlass(2008, "stainedGlassBlue");
	public final static Block stainedGlassLightBlue = new BlockStainedGlass(2009, "stainedGlassLightBlue");
	public final static Block stainedGlassGrey = new BlockStainedGlass(2010, "stainedGlassGrey");
	public final static Block stainedGlassLightGrey = new BlockStainedGlass(2011, "stainedGlassLightGrey");
	// Stained Glass Panes
	public static final Block thinGlassRed = new BlockStainedPane(2012, "stainedGlassRed", "thinGlassRed");
	public static final Block thinGlassPink = new BlockStainedPane(2013, "stainedGlassPink", "thinGlassPink");
	public final static Block thinGlassOrange = new BlockStainedPane(2014, "stainedGlassOrange", "thinGlassOrange");
	public final static Block thinGlassYellow = new BlockStainedPane(2015, "stainedGlassYellow", "thinGlassYellow");
	public final static Block thinGlassPurple = new BlockStainedPane(2016, "stainedGlassPurple", "thinGlassPurple");
	public final static Block thinGlassLightPurple = new BlockStainedPane(2017, "stainedGlassLightPurple", "thinGlassLightPurple");
	public final static Block thinGlassGreen = new BlockStainedPane(2018, "stainedGlassGreen", "thinGlassGreen");
	public final static Block thinGlassLightGreen = new BlockStainedPane(2019, "stainedGlassLightGreen", "thinGlassLightGreen");
	public final static Block thinGlassBlue = new BlockStainedPane(2020, "stainedGlassBlue", "thinGlassBlue");
	public final static Block thinGlassLightBlue = new BlockStainedPane(2021, "stainedGlassLightBlue", "thinGlassLightBlue");
	public final static Block thinGlassGrey = new BlockStainedPane(2022, "stainedGlassGrey", "thinGlassGrey");
	public final static Block thinGlassLightGrey = new BlockStainedPane(2023, "stainedGlassLightGrey", "thinGlassLightGrey");
	
	// Static Blocks
	//public final static Block genericDirt = new GenericBlock(2000, Material.ground).setHardness(0.5f).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("genericDirt").setCreativeTab(CreativeTabs.tabBlock);
	
	// Ores
	//public final static Block genericOre = new GenericOre(2001, Material.rock);
	
	// Items
	private final static Item genericItem = new GenericItem(9000);
	private final static Item genericIngot = new GenericItem(9001).setMaxStackSize(16).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("genericIngot");
	// To get item id: genericItem.itemID; (Item ID is shifted by base item class.
 
    // The instance of your mod that Forge uses.
    @Instance("Bms")
    public static Bms instance;
   
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = BasicInfo.CLIENTPROXY, serverSide = BasicInfo.COMMONPROXY)
    public static CommonProxy proxy;
   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Stub Method
    }
   
    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
        // New Recipes
        ItemStack dirtStack = new ItemStack(Block.dirt);
        ItemStack diamondStack = new ItemStack(Item.diamond, 64);
        ItemStack blackWoolStack = new ItemStack(Block.cloth, 10, 15);
        ItemStack stoneStack = new ItemStack(1, 32, 0);
        GameRegistry.addShapelessRecipe(diamondStack, dirtStack);
        GameRegistry.addShapelessRecipe(stoneStack, dirtStack, diamondStack);
        GameRegistry.addRecipe(diamondStack, "xy", "yx",'x',dirtStack,'y',stoneStack);
        
        // Smelting
        GameRegistry.addSmelting(Block.dirt.blockID, diamondStack, 0.5f);
        // To get items with modified meta data
        FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, blackWoolStack, 1.0f);
        
        // Custom Blocks Forge Registry
        /*
        GameRegistry.registerBlock(genericDirt, "genericDirt");
        	LanguageRegistry.addName(genericDirt, "Generic Dirt");
        	MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 1);
       */
        //GameRegistry.registerBlock(genericOre, "genericOre");
        //	LanguageRegistry.addName(genericOre, "Generic Ore");
        //	MinecraftForge.setBlockHarvestLevel(genericOre, "pickaxe", 3); // 3 = diamond
        
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
    		LanguageRegistry.addName(thinGlassPurple, "Purple Stained Glass Pane");
    	GameRegistry.registerBlock(thinGlassLightPurple, "thinGlassLightPurple");
    		LanguageRegistry.addName(thinGlassLightPurple, "Light Purple Stained Glass Pane");
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
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
   
}