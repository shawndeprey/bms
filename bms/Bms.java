package bms;
 
import net.minecraft.block.Block;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
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
	
	// Static Blocks
	//public final static Block genericDirt = new GenericBlock(2000, Material.ground).setHardness(0.5f).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("genericDirt").setCreativeTab(CreativeTabs.tabBlock);
	
	// Ores
	public final static Block titaniumOre =				new BlockBMSOre(2025, 2025, Material.rock, "titaniumOre");
	public final static Block adamantiumOre =			new BlockBMSOre(2026, 2026, Material.rock, "adamantiumOre");
	public final static Block rubyOre =					new BlockBMSOre(2027, 9002, Material.rock, "rubyOre");
	public final static Block sapphireOre =				new BlockBMSOre(2028, 9003, Material.rock, "sapphireOre");
	public final static Block citrineOre =				new BlockBMSOre(2029, 9004, Material.rock, "citrineOre");
	public final static Block jadeiteOre =				new BlockBMSOre(2030, 9005, Material.rock, "jadeiteOre");
	
	public final static Block titaniumBlock =			new BlockOreStorage(2031).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("bms:titaniumBlock").func_111022_d("bms:titaniumBlock");
	public final static Block adamantiumBlock =			new BlockOreStorage(2032).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("adamantiumBlock").func_111022_d("bms:adamantiumBlock");
	
	// Items
	private static Item titaniumIngot =					new ItemBMSIngots(9000, "titaniumIngot");
	private static Item adamantiumIngot =				new ItemBMSIngots(9001, "adamantiumIngot");
	private static Item ruby =							new ItemBMSGems(9002, "ruby");
	private static Item sapphire =						new ItemBMSGems(9003, "sapphire");
	private static Item citrine =						new ItemBMSGems(9004, "citrine");
	private static Item jadeite =						new ItemBMSGems(9005, "jadeite");
	private static Item rubyPowder =					new Item(9006).setUnlocalizedName("rubyPowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:rubyPowder");
	private static Item sapphirePowder =				new Item(9007).setUnlocalizedName("sapphirePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:sapphirePowder");
	private static Item citrinePowder =					new Item(9008).setUnlocalizedName("citrinePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:citrinePowder");
	private static Item jadeitePowder =					new Item(9009).setUnlocalizedName("jadeitePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:jadeitePowder");
	private static Item diamondPowder =					new Item(9010).setUnlocalizedName("diamondPowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:diamondPowder");
 
	// EnumToolMaterials
	final static EnumToolMaterial TITANIUM = 			EnumHelper.addToolMaterial("TITANIUM", 3, 1561, 8.0F, 3.0F, 10);
	final static EnumToolMaterial ADAMANTIUM = 			EnumHelper.addToolMaterial("ADAMANTIUM", 4, 2500, 10.0F, 4.0F, 25);
    
	// Tools
	public static Item titaniumShovel = 				(new ItemSpade(9011, TITANIUM)).setUnlocalizedName("titaniumShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumShovel");
	public static Item titaniumPickaxe = 				(new ItemPickaxe(9012, TITANIUM)).setUnlocalizedName("titaniumPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumPickaxe");
	public static Item titaniumHatchet = 				(new ItemAxe(9013, TITANIUM)).setUnlocalizedName("titaniumHatchet").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumHatchet");
	public static Item titaniumHoe = 					(new ItemHoe(9014, TITANIUM)).setUnlocalizedName("titaniumHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumHoe");
	public static Item adamantiumShovel = 				(new ItemSpade(9015, ADAMANTIUM)).setUnlocalizedName("adamantiumShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumShovel");
	public static Item adamantiumPickaxe = 				(new ItemPickaxe(9016, ADAMANTIUM)).setUnlocalizedName("adamantiumPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumPickaxe");
	public static Item adamantiumHatchet = 				(new ItemAxe(9017, ADAMANTIUM)).setUnlocalizedName("adamantiumHatchet").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumHatchet");
	public static Item adamantiumHoe = 					(new ItemHoe(9018, ADAMANTIUM)).setUnlocalizedName("adamantiumHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumHoe");
	
	//Weapons
	public static Item titaniumSword = 					(new ItemSword(9019, TITANIUM)).setUnlocalizedName("titaniumSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("bms:titaniumSword");
	public static Item adamantiumSword = 				(new ItemSword(9020, ADAMANTIUM)).setUnlocalizedName("adamantiumSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("bms:adamantiumSword");
	
	
	
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
        // To get items with modified meta data
        //FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, blackWoolStack, 1.0f);
        
        ItemStack titaniumIngotStack = 					new ItemStack(Bms.titaniumIngot);
        ItemStack adamantiumIngotStack = 				new ItemStack(Bms.adamantiumIngot);
        ItemStack titaniumBlockStack = 					new ItemStack(Bms.titaniumBlock);
        ItemStack adamantiumBlockStack = 				new ItemStack(Bms.adamantiumBlock);
        ItemStack rubyStack = 							new ItemStack(Bms.ruby);
        ItemStack sapphireStack = 						new ItemStack(Bms.sapphire);
        ItemStack citrineStack = 						new ItemStack(Bms.citrine);
        ItemStack jadeiteStack = 						new ItemStack(Bms.jadeite);
        ItemStack diamondStack = 						new ItemStack(Item.diamond);
        ItemStack rubyPowderStack = 					new ItemStack(Bms.rubyPowder, 4);
        ItemStack sapphirePowderStack = 				new ItemStack(Bms.sapphirePowder, 4);
        ItemStack citrinePowderStack = 					new ItemStack(Bms.citrinePowder, 4);
        ItemStack jadeitePowderStack = 					new ItemStack(Bms.jadeitePowder, 4);
        ItemStack diamondPowderStack = 					new ItemStack(Bms.diamondPowder, 4);
        ItemStack titaniumShovelStack = 				new ItemStack(Bms.titaniumShovel);
        ItemStack titaniumPickaxeStack = 				new ItemStack(Bms.titaniumPickaxe);
        ItemStack titaniumHatchetStack = 				new ItemStack(Bms.titaniumHatchet);
        ItemStack titaniumHoeStack = 					new ItemStack(Bms.titaniumHoe);
        ItemStack adamantiumShovelStack = 				new ItemStack(Bms.adamantiumShovel);
        ItemStack adamantiumPickaxeStack = 				new ItemStack(Bms.adamantiumPickaxe);
        ItemStack adamantiumHatchetStack = 				new ItemStack(Bms.adamantiumHatchet);
        ItemStack adamantiumHoeStack = 					new ItemStack(Bms.adamantiumHoe);
        ItemStack titaniumSwordStack = 					new ItemStack(Bms.titaniumSword);
        ItemStack adamantiumSwordStack = 				new ItemStack(Bms.adamantiumSword);
        
        GameRegistry.addSmelting(Bms.titaniumOre.blockID, titaniumIngotStack, 0.5f);
        GameRegistry.addSmelting(Bms.adamantiumOre.blockID, adamantiumIngotStack, 0.5f);
        
        GameRegistry.addShapelessRecipe(rubyPowderStack, rubyStack);
        GameRegistry.addShapelessRecipe(sapphirePowderStack, sapphireStack);
        GameRegistry.addShapelessRecipe(citrinePowderStack, citrineStack);
        GameRegistry.addShapelessRecipe(jadeitePowderStack, jadeiteStack);
        GameRegistry.addShapelessRecipe(diamondPowderStack, diamondStack);
        
        GameRegistry.addRecipe(titaniumBlockStack, "xxx", "xxx", "xxx", 'x',titaniumIngotStack);
        GameRegistry.addRecipe(adamantiumBlockStack, "xxx", "xxx", "xxx", 'x',adamantiumIngotStack);
        GameRegistry.addRecipe(titaniumShovelStack, " x ", " y ", " y ", 'x',titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(titaniumPickaxeStack, "xxx", " y ", " y ", 'x',titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(titaniumHatchetStack, "xx ", "xy ", " y ", 'x',titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(titaniumHoeStack, "xx ", " y ", " y ", 'x',titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(adamantiumShovelStack, " x ", " y ", " y ", 'x',adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(adamantiumPickaxeStack, "xxx", " y ", " y ", 'x',adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(adamantiumHatchetStack, "xx ", "xy ", " y ", 'x',adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(adamantiumHoeStack, "xx ", " y ", " y ", 'x',adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(titaniumSwordStack, "x", "x", "y", 'x',titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(adamantiumSwordStack, "x", "x", "y", 'x',adamantiumIngotStack, 'y',Item.stick);
        
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
        // Items
        GameRegistry.registerItem(titaniumIngot, "titaniumIngot");
        	LanguageRegistry.addName(titaniumIngot, "Titanium Ingot");
        GameRegistry.registerItem(adamantiumIngot, "adamantiumIngot");
        	LanguageRegistry.addName(adamantiumIngot, "Adamantium Ingot");
        GameRegistry.registerItem(ruby, "ruby");
        	LanguageRegistry.addName(ruby, "Ruby");
        GameRegistry.registerItem(sapphire, "sapphire");
        	LanguageRegistry.addName(sapphire, "Sapphire");
        GameRegistry.registerItem(citrine, "citrine");
        	LanguageRegistry.addName(citrine, "Citrine");
        GameRegistry.registerItem(jadeite, "jadeite");
        	LanguageRegistry.addName(jadeite, "Jadeite");
        GameRegistry.registerItem(rubyPowder, "rubyPowder");
        	LanguageRegistry.addName(rubyPowder, "Ruby Powder");
        GameRegistry.registerItem(sapphirePowder, "sapphirePowder");
        	LanguageRegistry.addName(sapphirePowder, "Sapphire Powder");
        GameRegistry.registerItem(citrinePowder, "citrinePowder");
        	LanguageRegistry.addName(citrinePowder, "Citrine Powder");
        GameRegistry.registerItem(jadeitePowder, "jadeitePowder");
        	LanguageRegistry.addName(jadeitePowder, "Jadeite Powder");
        GameRegistry.registerItem(diamondPowder, "diamondPowder");
        	LanguageRegistry.addName(diamondPowder, "Diamond Powder");
        	
    	GameRegistry.registerItem(titaniumShovel, "titaniumShovel");
        	LanguageRegistry.addName(titaniumShovel, "Titanium Shovel");
        GameRegistry.registerItem(titaniumPickaxe, "titaniumPickaxe");
        	LanguageRegistry.addName(titaniumPickaxe, "Titanium Pickaxe");
        GameRegistry.registerItem(titaniumHatchet, "titaniumHatchet");
        	LanguageRegistry.addName(titaniumHatchet, "Titanium Hatchet");
        GameRegistry.registerItem(titaniumHoe, "titaniumHoe");
        	LanguageRegistry.addName(titaniumHoe, "Titanium Hoe");
        	
        GameRegistry.registerItem(adamantiumShovel, "adamantiumShovel");
        	LanguageRegistry.addName(adamantiumShovel, "Adamantium Shovel");
        GameRegistry.registerItem(adamantiumPickaxe, "adamantiumPickaxe");
        	LanguageRegistry.addName(adamantiumPickaxe, "Adamantium Pickaxe");
        GameRegistry.registerItem(adamantiumHatchet, "adamantiumHatchet");
        	LanguageRegistry.addName(adamantiumHatchet, "Adamantium Hatchet");
        GameRegistry.registerItem(adamantiumHoe, "adamantiumHoe");
        	LanguageRegistry.addName(adamantiumHoe, "Adamantium Hoe");
        	
        GameRegistry.registerItem(titaniumSword, "titaniumSword");
        	LanguageRegistry.addName(titaniumSword, "Titanium Sword");
        GameRegistry.registerItem(adamantiumSword, "adamantiumSword");
        	LanguageRegistry.addName(adamantiumSword, "Adamantium Sword");
        	

    	GameRegistry.registerWorldGenerator(new BMSOreWorldGenerator());
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
   
}