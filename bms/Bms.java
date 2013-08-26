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
	public final static Block titaniumOre =		new BlockBMSOre(2025, 2025, Material.rock, "titaniumOre");
	public final static Block adamantiumOre =	new BlockBMSOre(2026, 2026, Material.rock, "adamantiumOre");
	public final static Block rubyOre =			new BlockBMSOre(2027, 2027, Material.rock, "rubyOre");
	public final static Block sapphireOre =		new BlockBMSOre(2028, 2028, Material.rock, "sapphireOre");
	public final static Block citrineOre =		new BlockBMSOre(2029, 2029, Material.rock, "citrineOre");
	public final static Block jadeiteOre =		new BlockBMSOre(2030, 2030, Material.rock, "jadeiteOre");
	
	// Items
	//private final static Item genericItem = new GenericItem(9000);
	//private final static Item genericIngot = new GenericItem(9001).setMaxStackSize(16).setCreativeTab(CreativeTabs.tabMisc).setUnlocalizedName("genericIngot");
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
        /*
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
		*/
        
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