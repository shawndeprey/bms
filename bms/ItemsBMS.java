package bms;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
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

public class ItemsBMS {
	// Items
	public static Item titaniumIngot;
	public static Item adamantiumIngot;
	public static Item ruby;
	public static Item sapphire;
	public static Item citrine;
	public static Item jadeite;
	public static Item rubyPowder;
	public static Item sapphirePowder;
	public static Item citrinePowder;
	public static Item jadeitePowder;
	public static Item diamondPowder;
	
	// Projectile Weapons
	public static Item slingshot;
	public static Item pebble;
    
	// Tools
	public static Item titaniumShovel;
	public static Item titaniumPickaxe;
	public static Item titaniumHatchet;
	public static Item titaniumHoe;
	public static Item adamantiumShovel;
	public static Item adamantiumPickaxe;
	public static Item adamantiumHatchet;
	public static Item adamantiumHoe;
	
	// Weapons
	public static Item titaniumSword;
	public static Item adamantiumSword;
	
	// Item Stacks
	public static ItemStack titaniumIngotStack;
    public static ItemStack adamantiumIngotStack;
    public static ItemStack titaniumBlockStack;
    public static ItemStack adamantiumBlockStack;
    public static ItemStack rubyStack;
    public static ItemStack sapphireStack;
    public static ItemStack citrineStack;
    public static ItemStack jadeiteStack;
    public static ItemStack diamondStack;
    public static ItemStack rubyPowderStack;
    public static ItemStack sapphirePowderStack;
    public static ItemStack citrinePowderStack;
    public static ItemStack jadeitePowderStack;
    public static ItemStack diamondPowderStack;
    public static ItemStack titaniumShovelStack;
    public static ItemStack titaniumPickaxeStack;
    public static ItemStack titaniumHatchetStack;
    public static ItemStack titaniumHoeStack;
    public static ItemStack adamantiumShovelStack;
    public static ItemStack adamantiumPickaxeStack;
    public static ItemStack adamantiumHatchetStack;
    public static ItemStack adamantiumHoeStack;
    public static ItemStack titaniumSwordStack;
    public static ItemStack adamantiumSwordStack;
    
    public static boolean initItems()
    {
    	// Items
    	titaniumIngot =						new ItemBMSIngots(9000, "titaniumIngot");
    	adamantiumIngot =					new ItemBMSIngots(9001, "adamantiumIngot");
    	ruby =								new ItemBMSGems(9002, "ruby");
    	sapphire =							new ItemBMSGems(9003, "sapphire");
    	citrine =							new ItemBMSGems(9004, "citrine");
    	jadeite =							new ItemBMSGems(9005, "jadeite");
    	rubyPowder =						new Item(9006).setUnlocalizedName("rubyPowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:rubyPowder");
    	sapphirePowder =					new Item(9007).setUnlocalizedName("sapphirePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:sapphirePowder");
    	citrinePowder =						new Item(9008).setUnlocalizedName("citrinePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:citrinePowder");
    	jadeitePowder =						new Item(9009).setUnlocalizedName("jadeitePowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:jadeitePowder");
    	diamondPowder =						new Item(9010).setUnlocalizedName("diamondPowder").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:diamondPowder");
    	
    	// Projectile Weapons
    	slingshot = 						new ItemSlingshot(9021).setUnlocalizedName("slingshot").func_111206_d("bms:slingshot");
    	pebble =							new Item(9022).setUnlocalizedName("pebble").setCreativeTab(CreativeTabs.tabMisc).func_111206_d("bms:pebble");
        
    	// Tools
    	titaniumShovel = 					(new ItemSpade(9011, EnumBMS.TITANIUM)).setUnlocalizedName("titaniumShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumShovel");
    	titaniumPickaxe = 					(new ItemPickaxe(9012, EnumBMS.TITANIUM)).setUnlocalizedName("titaniumPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumPickaxe");
    	titaniumHatchet = 					(new ItemAxe(9013, EnumBMS.TITANIUM)).setUnlocalizedName("titaniumHatchet").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumHatchet");
    	titaniumHoe = 						(new ItemHoe(9014, EnumBMS.TITANIUM)).setUnlocalizedName("titaniumHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:titaniumHoe");
    	adamantiumShovel = 					(new ItemSpade(9015, EnumBMS.ADAMANTIUM)).setUnlocalizedName("adamantiumShovel").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumShovel");
    	adamantiumPickaxe = 				(new ItemPickaxe(9016, EnumBMS.ADAMANTIUM)).setUnlocalizedName("adamantiumPickaxe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumPickaxe");
    	adamantiumHatchet = 				(new ItemAxe(9017, EnumBMS.ADAMANTIUM)).setUnlocalizedName("adamantiumHatchet").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumHatchet");
    	adamantiumHoe = 					(new ItemHoe(9018, EnumBMS.ADAMANTIUM)).setUnlocalizedName("adamantiumHoe").setCreativeTab(CreativeTabs.tabTools).func_111206_d("bms:adamantiumHoe");
    	
    	// Weapons
    	titaniumSword = 					(new ItemSword(9019, EnumBMS.TITANIUM)).setUnlocalizedName("titaniumSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("bms:titaniumSword");
    	adamantiumSword = 					(new ItemSword(9020, EnumBMS.ADAMANTIUM)).setUnlocalizedName("adamantiumSword").setCreativeTab(CreativeTabs.tabCombat).func_111206_d("bms:adamantiumSword");
    	
    	return true;
    }
    
	public static boolean registerItemStacks()
	{
		titaniumIngotStack = 				new ItemStack(titaniumIngot);
        adamantiumIngotStack = 				new ItemStack(adamantiumIngot);
        titaniumBlockStack = 				new ItemStack(BlocksBMS.titaniumBlock);
        adamantiumBlockStack = 				new ItemStack(BlocksBMS.adamantiumBlock);
        rubyStack = 						new ItemStack(ruby);
        sapphireStack = 					new ItemStack(sapphire);
        citrineStack = 						new ItemStack(citrine);
        jadeiteStack = 						new ItemStack(jadeite);
        diamondStack = 						new ItemStack(Item.diamond);
        rubyPowderStack = 					new ItemStack(rubyPowder, 4);
        sapphirePowderStack = 				new ItemStack(sapphirePowder, 4);
        citrinePowderStack = 				new ItemStack(citrinePowder, 4);
        jadeitePowderStack = 				new ItemStack(jadeitePowder, 4);
        diamondPowderStack = 				new ItemStack(diamondPowder, 4);
        titaniumShovelStack = 				new ItemStack(titaniumShovel);
        titaniumPickaxeStack = 				new ItemStack(titaniumPickaxe);
        titaniumHatchetStack = 				new ItemStack(titaniumHatchet);
        titaniumHoeStack = 					new ItemStack(titaniumHoe);
        adamantiumShovelStack =				new ItemStack(adamantiumShovel);
        adamantiumPickaxeStack = 			new ItemStack(adamantiumPickaxe);
        adamantiumHatchetStack = 			new ItemStack(adamantiumHatchet);
        adamantiumHoeStack = 				new ItemStack(adamantiumHoe);
        titaniumSwordStack = 				new ItemStack(titaniumSword);
        adamantiumSwordStack = 				new ItemStack(adamantiumSword);
        
        return true;
	}
	
	public static boolean registerItems()
	{
		GameRegistry.registerItem(ItemsBMS.titaniumIngot, "titaniumIngot");
	    	LanguageRegistry.addName(ItemsBMS.titaniumIngot, "Titanium Ingot");
	    GameRegistry.registerItem(ItemsBMS.adamantiumIngot, "adamantiumIngot");
	    	LanguageRegistry.addName(ItemsBMS.adamantiumIngot, "Adamantium Ingot");
	    GameRegistry.registerItem(ItemsBMS.ruby, "ruby");
	    	LanguageRegistry.addName(ItemsBMS.ruby, "Ruby");
	    GameRegistry.registerItem(ItemsBMS.sapphire, "sapphire");
	    	LanguageRegistry.addName(ItemsBMS.sapphire, "Sapphire");
	    GameRegistry.registerItem(ItemsBMS.citrine, "citrine");
	    	LanguageRegistry.addName(ItemsBMS.citrine, "Citrine");
	    GameRegistry.registerItem(ItemsBMS.jadeite, "jadeite");
	    	LanguageRegistry.addName(ItemsBMS.jadeite, "Jadeite");
	    GameRegistry.registerItem(ItemsBMS.rubyPowder, "rubyPowder");
	    	LanguageRegistry.addName(ItemsBMS.rubyPowder, "Ruby Powder");
	    GameRegistry.registerItem(ItemsBMS.sapphirePowder, "sapphirePowder");
	    	LanguageRegistry.addName(ItemsBMS.sapphirePowder, "Sapphire Powder");
	    GameRegistry.registerItem(ItemsBMS.citrinePowder, "citrinePowder");
	    	LanguageRegistry.addName(ItemsBMS.citrinePowder, "Citrine Powder");
	    GameRegistry.registerItem(ItemsBMS.jadeitePowder, "jadeitePowder");
	    	LanguageRegistry.addName(ItemsBMS.jadeitePowder, "Jadeite Powder");
	    GameRegistry.registerItem(ItemsBMS.diamondPowder, "diamondPowder");
	    	LanguageRegistry.addName(ItemsBMS.diamondPowder, "Diamond Powder");
	    	
		GameRegistry.registerItem(ItemsBMS.titaniumShovel, "titaniumShovel");
	    	LanguageRegistry.addName(ItemsBMS.titaniumShovel, "Titanium Shovel");
	    GameRegistry.registerItem(ItemsBMS.titaniumPickaxe, "titaniumPickaxe");
	    	LanguageRegistry.addName(ItemsBMS.titaniumPickaxe, "Titanium Pickaxe");
	    GameRegistry.registerItem(ItemsBMS.titaniumHatchet, "titaniumHatchet");
	    	LanguageRegistry.addName(ItemsBMS.titaniumHatchet, "Titanium Hatchet");
	    GameRegistry.registerItem(ItemsBMS.titaniumHoe, "titaniumHoe");
	    	LanguageRegistry.addName(ItemsBMS.titaniumHoe, "Titanium Hoe");
	    	
	    GameRegistry.registerItem(ItemsBMS.adamantiumShovel, "adamantiumShovel");
	    	LanguageRegistry.addName(ItemsBMS.adamantiumShovel, "Adamantium Shovel");
	    GameRegistry.registerItem(ItemsBMS.adamantiumPickaxe, "adamantiumPickaxe");
	    	LanguageRegistry.addName(ItemsBMS.adamantiumPickaxe, "Adamantium Pickaxe");
	    GameRegistry.registerItem(ItemsBMS.adamantiumHatchet, "adamantiumHatchet");
	    	LanguageRegistry.addName(ItemsBMS.adamantiumHatchet, "Adamantium Hatchet");
	    GameRegistry.registerItem(ItemsBMS.adamantiumHoe, "adamantiumHoe");
	    	LanguageRegistry.addName(ItemsBMS.adamantiumHoe, "Adamantium Hoe");
	    	
	    GameRegistry.registerItem(ItemsBMS.titaniumSword, "titaniumSword");
	    	LanguageRegistry.addName(ItemsBMS.titaniumSword, "Titanium Sword");
	    GameRegistry.registerItem(ItemsBMS.adamantiumSword, "adamantiumSword");
	    	LanguageRegistry.addName(ItemsBMS.adamantiumSword, "Adamantium Sword");
	    	
		// Projectile Weapons
	    GameRegistry.registerItem(ItemsBMS.slingshot, "slingshot");
	    	LanguageRegistry.addName(ItemsBMS.slingshot, "Slingshot");
	    GameRegistry.registerItem(ItemsBMS.pebble, "pebble");
	    	LanguageRegistry.addName(ItemsBMS.pebble, "Pebble");
	    	
    	return true;
	}
}
