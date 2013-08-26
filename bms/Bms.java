package bms;
 
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
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
	
	// Static Blocks
	//public final static Block genericDirt = new GenericBlock(2000, Material.ground).setHardness(0.5f).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("genericDirt").setCreativeTab(CreativeTabs.tabBlock);
	
	// Ores
	public final static Block titaniumOre =			new BlockBMSOre(2025, 2025, Material.rock, "titaniumOre");
	public final static Block adamantiumOre =		new BlockBMSOre(2026, 2026, Material.rock, "adamantiumOre");
	public final static Block rubyOre =				new BlockBMSOre(2027, 9002, Material.rock, "rubyOre");
	public final static Block sapphireOre =			new BlockBMSOre(2028, 9003, Material.rock, "sapphireOre");
	public final static Block citrineOre =			new BlockBMSOre(2029, 9004, Material.rock, "citrineOre");
	public final static Block jadeiteOre =			new BlockBMSOre(2030, 9005, Material.rock, "jadeiteOre");
	
	// Items
	private final static Item titaniumIngot =		new ItemBMSIngots(9000, "titaniumIngot");
	private final static Item adamantiumIngot =		new ItemBMSIngots(9001, "adamantiumIngot");
	private final static Item ruby =				new ItemBMSGems(9002, "ruby");
	private final static Item sapphire =			new ItemBMSGems(9003, "sapphire");
	private final static Item citrine =				new ItemBMSGems(9004, "citrine");
	private final static Item jadeite =				new ItemBMSGems(9005, "jadeite");
	private final static Item rubyPowder =			new Item(9006).setUnlocalizedName("rubyPowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("rubyPowder");
	private final static Item sapphirePowder =		new Item(9007).setUnlocalizedName("sapphirePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("sapphirePowder");
	private final static Item citrinePowder =		new Item(9008).setUnlocalizedName("citrinePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("citrinePowder");
	private final static Item jadeitePowder =		new Item(9009).setUnlocalizedName("jadeitePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("jadeitePowder");
 
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
        /*
        ItemStack dirtStack = new ItemStack(Block.dirt);
        
        GameRegistry.addShapelessRecipe(diamondStack, dirtStack);
        GameRegistry.addRecipe(diamondStack, "xy", "yx",'x',dirtStack,'y',stoneStack);
        
        // To get items with modified meta data
        FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15, blackWoolStack, 1.0f);
		*/
        
        ItemStack titaniumIngotStack = new ItemStack(Bms.titaniumIngot);
        ItemStack adamantiumIngotStack = new ItemStack(Bms.adamantiumIngot);
        ItemStack rubyStack = new ItemStack(Bms.ruby);
        ItemStack sapphireStack = new ItemStack(Bms.sapphire);
        ItemStack citrineStack = new ItemStack(Bms.citrine);
        ItemStack jadeiteStack = new ItemStack(Bms.jadeite);
        ItemStack rubyPowderStack = new ItemStack(Bms.rubyPowder);
        ItemStack sapphirePowderStack = new ItemStack(Bms.sapphirePowder);
        ItemStack citrinePowderStack = new ItemStack(Bms.citrinePowder);
        ItemStack jadeitePowderStack = new ItemStack(Bms.jadeitePowder);
        
        GameRegistry.addSmelting(Bms.titaniumOre.blockID, titaniumIngotStack, 0.5f);
        GameRegistry.addSmelting(Bms.adamantiumOre.blockID, adamantiumIngotStack, 0.5f);
        GameRegistry.addShapelessRecipe(rubyPowderStack, rubyStack);
        GameRegistry.addShapelessRecipe(sapphirePowderStack, sapphireStack);
        GameRegistry.addShapelessRecipe(citrinePowderStack, citrineStack);
        GameRegistry.addShapelessRecipe(jadeitePowderStack, jadeiteStack);
        
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
        	
    	GameRegistry.registerWorldGenerator(new BMSOreWorldGenerator());
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
   
}