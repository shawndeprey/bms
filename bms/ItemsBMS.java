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
	    	
		// Projectile Weapons
	    GameRegistry.registerItem(slingshot, "slingshot");
	    	LanguageRegistry.addName(slingshot, "Slingshot");
	    GameRegistry.registerItem(pebble, "pebble");
	    	LanguageRegistry.addName(pebble, "Pebble");
	    	
    	return true;
	}
}
