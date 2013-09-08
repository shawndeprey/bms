package bms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
    public static ItemStack linenHelmetStack;
    public static ItemStack linenChestStack;
    public static ItemStack linenPantsStack;
    public static ItemStack linenBootsStack;
    public static ItemStack reinforcedLeatherHelmetStack;
    public static ItemStack reinforcedLeatherChestStack;
    public static ItemStack reinforcedLeatherPantsStack;
    public static ItemStack reinforcedLeatherBootsStack;
    public static ItemStack titaniumHelmetStack;
    public static ItemStack titaniumChestStack;
    public static ItemStack titaniumPantsStack;
    public static ItemStack titaniumBootsStack;
    public static ItemStack adamantiumHelmetStack;
    public static ItemStack adamantiumChestStack;
    public static ItemStack adamantiumPantsStack;
    public static ItemStack adamantiumBootsStack;
    public static ItemStack linenStack;
    public static ItemStack reinforcedLeatherStack;
    public static ItemStack lambchopStack;
    public static ItemStack cookedLambchopStack;
    
    // Magic
	public static Item fireStaff;
	public static Item waterStaff;
	public static Item iceStaff;
	public static Item earthStaff;
	public static Item citrineStaff;
	public static Item fireRune;
	public static Item waterRune;
	public static Item iceRune;
	public static Item earthRune;
	public static Item citrineRune;
	public static Item blankItem;
	
	// Armor
	public static Item linenHelmet;
	public static Item linenChest;
	public static Item linenPants;
	public static Item linenBoots;
	public static Item reinforcedLeatherHelmet;
	public static Item reinforcedLeatherChest;
	public static Item reinforcedLeatherPants;
	public static Item reinforcedLeatherBoots;
	public static Item titaniumHelmet;
	public static Item titaniumChest;
	public static Item titaniumPants;
	public static Item titaniumBoots;
	public static Item adamantiumHelmet;
	public static Item adamantiumChest;
	public static Item adamantiumPants;
	public static Item adamantiumBoots;
	
	public static Item linen;
	public static Item reinforcedLeather;
	public static Item flaxFiber;
	
	// Food
	public static Item lambchop;
	public static Item cookedLambchop;
    
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
    	
    	// Staves
    	fireStaff = new ItemStaff(9023, 0).setUnlocalizedName("fireStaff").func_111206_d("bms:fireStaff");
    	waterStaff = new ItemStaff(9024, 1).setUnlocalizedName("waterStaff").func_111206_d("bms:waterStaff");
    	iceStaff = new ItemStaff(9025, 2).setUnlocalizedName("iceStaff").func_111206_d("bms:iceStaff");
    	earthStaff = new ItemStaff(9026, 3).setUnlocalizedName("earthStaff").func_111206_d("bms:earthStaff");
    	citrineStaff = new ItemStaff(9027, 4).setUnlocalizedName("citrineStaff").func_111206_d("bms:citrineStaff");
    	fireRune = new Item(9028).setUnlocalizedName("fireRune").setCreativeTab(CreativeTabs.tabMisc).func_111206_d("bms:fireRune");
    	waterRune = new Item(9029).setUnlocalizedName("waterRune").setCreativeTab(CreativeTabs.tabMisc).func_111206_d("bms:waterRune");
    	iceRune = new Item(9030).setUnlocalizedName("iceRune").setCreativeTab(CreativeTabs.tabMisc).func_111206_d("bms:iceRune");
    	earthRune = new Item(9031).setUnlocalizedName("earthRune").setCreativeTab(CreativeTabs.tabMisc).func_111206_d("bms:earthRune");
    	citrineRune = new Item(9032).setUnlocalizedName("citrineRune").setCreativeTab(CreativeTabs.tabMisc).func_111206_d("bms:citrineRune");
    	blankItem = new Item(9033).setUnlocalizedName("blankItem").func_111206_d("bms:blankItem");
    	
    	// Armor reinforced
    	linenHelmet = new ItemBMSArmor(9034, EnumBMS.linenArmorMaterial, ModLoader.addArmor("linen"), 0, "linen").setUnlocalizedName("linenHelmet").func_111206_d("bms:linenHelmet").setCreativeTab(CreativeTabs.tabCombat);
    	linenChest = new ItemBMSArmor(9035, EnumBMS.linenArmorMaterial, ModLoader.addArmor("linen"), 1, "linen").setUnlocalizedName("linenChest").func_111206_d("bms:linenChest").setCreativeTab(CreativeTabs.tabCombat);
    	linenPants = new ItemBMSArmor(9036, EnumBMS.linenArmorMaterial, ModLoader.addArmor("linen"), 2, "linen").setUnlocalizedName("linenPants").func_111206_d("bms:linenPants").setCreativeTab(CreativeTabs.tabCombat);
    	linenBoots = new ItemBMSArmor(9037, EnumBMS.linenArmorMaterial, ModLoader.addArmor("linen"), 3, "linen").setUnlocalizedName("linenBoots").func_111206_d("bms:linenBoots").setCreativeTab(CreativeTabs.tabCombat);
    	reinforcedLeatherHelmet = new ItemBMSArmor(9038, EnumBMS.reinforcedLeatherArmorMaterial, ModLoader.addArmor("reinforcedLeather"), 0, "reinforcedLeather").setUnlocalizedName("reinforcedLeatherHelmet").func_111206_d("bms:reinforcedLeatherHelmet").setCreativeTab(CreativeTabs.tabCombat);
    	reinforcedLeatherChest = new ItemBMSArmor(9039, EnumBMS.reinforcedLeatherArmorMaterial, ModLoader.addArmor("reinforcedLeather"), 1, "reinforcedLeather").setUnlocalizedName("reinforcedLeatherChest").func_111206_d("bms:reinforcedLeatherChest").setCreativeTab(CreativeTabs.tabCombat);
    	reinforcedLeatherPants = new ItemBMSArmor(9040, EnumBMS.reinforcedLeatherArmorMaterial, ModLoader.addArmor("reinforcedLeather"), 2, "reinforcedLeather").setUnlocalizedName("reinforcedLeatherPants").func_111206_d("bms:reinforcedLeatherPants").setCreativeTab(CreativeTabs.tabCombat);
    	reinforcedLeatherBoots = new ItemBMSArmor(9041, EnumBMS.reinforcedLeatherArmorMaterial, ModLoader.addArmor("reinforcedLeather"), 3, "reinforcedLeather").setUnlocalizedName("reinforcedLeatherBoots").func_111206_d("bms:reinforcedLeatherBoots").setCreativeTab(CreativeTabs.tabCombat);
    	titaniumHelmet = new ItemBMSArmor(9042, EnumBMS.titaniumArmorMaterial, ModLoader.addArmor("titanium"), 0, "titanium").setUnlocalizedName("titaniumHelmet").func_111206_d("bms:titaniumHelmet").setCreativeTab(CreativeTabs.tabCombat);
    	titaniumChest = new ItemBMSArmor(9043, EnumBMS.titaniumArmorMaterial, ModLoader.addArmor("titanium"), 1, "titanium").setUnlocalizedName("titaniumChest").func_111206_d("bms:titaniumChest").setCreativeTab(CreativeTabs.tabCombat);
    	titaniumPants = new ItemBMSArmor(9044, EnumBMS.titaniumArmorMaterial, ModLoader.addArmor("titanium"), 2, "titanium").setUnlocalizedName("titaniumPants").func_111206_d("bms:titaniumPants").setCreativeTab(CreativeTabs.tabCombat);
    	titaniumBoots = new ItemBMSArmor(9045, EnumBMS.titaniumArmorMaterial, ModLoader.addArmor("titanium"), 3, "titanium").setUnlocalizedName("titaniumBoots").func_111206_d("bms:titaniumBoots").setCreativeTab(CreativeTabs.tabCombat);
    	adamantiumHelmet = new ItemBMSArmor(9046, EnumBMS.adamantiumArmorMaterial, ModLoader.addArmor("adamantium"), 0, "adamantium").setUnlocalizedName("adamantiumHelmet").func_111206_d("bms:adamantiumHelmet").setCreativeTab(CreativeTabs.tabCombat);
    	adamantiumChest = new ItemBMSArmor(9047, EnumBMS.adamantiumArmorMaterial, ModLoader.addArmor("adamantium"), 1, "adamantium").setUnlocalizedName("adamantiumChest").func_111206_d("bms:adamantiumChest").setCreativeTab(CreativeTabs.tabCombat);
    	adamantiumPants = new ItemBMSArmor(9048, EnumBMS.adamantiumArmorMaterial, ModLoader.addArmor("adamantium"), 2, "adamantium").setUnlocalizedName("adamantiumPants").func_111206_d("bms:adamantiumPants").setCreativeTab(CreativeTabs.tabCombat);
    	adamantiumBoots = new ItemBMSArmor(9049, EnumBMS.adamantiumArmorMaterial, ModLoader.addArmor("adamantium"), 3, "adamantium").setUnlocalizedName("adamantiumBoots").func_111206_d("bms:adamantiumBoots").setCreativeTab(CreativeTabs.tabCombat);
    	
    	linen =	new Item(9050).setUnlocalizedName("linen").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:linen");
    	reinforcedLeather =	new Item(9051).setUnlocalizedName("reinforcedLeather").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:reinforcedLeather");
    	flaxFiber = new Item(9052).setUnlocalizedName("flaxFiber").setCreativeTab(CreativeTabs.tabMaterials).func_111206_d("bms:flaxFiber");
    	
    	lambchop = (new ItemFood(9053, 3, 0.3F, true)).setUnlocalizedName("lambchop").func_111206_d("bms:lambchop").setCreativeTab(CreativeTabs.tabFood);
    	cookedLambchop = (new ItemFood(9054, 9, 0.8F, true)).setUnlocalizedName("cookedLambchop").func_111206_d("bms:cookedLambchop").setCreativeTab(CreativeTabs.tabFood);
    	
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
        linenHelmetStack = 					new ItemStack(linenHelmet);
        linenChestStack = 					new ItemStack(linenChest);
        linenPantsStack = 					new ItemStack(linenPants);
        linenBootsStack = 					new ItemStack(linenBoots);
        reinforcedLeatherHelmetStack = 		new ItemStack(reinforcedLeatherHelmet);
        reinforcedLeatherChestStack = 		new ItemStack(reinforcedLeatherChest);
        reinforcedLeatherPantsStack = 		new ItemStack(reinforcedLeatherPants);
        reinforcedLeatherBootsStack = 		new ItemStack(reinforcedLeatherBoots);
        titaniumHelmetStack = 				new ItemStack(titaniumHelmet);
        titaniumChestStack = 				new ItemStack(titaniumChest);
        titaniumPantsStack = 				new ItemStack(titaniumPants);
        titaniumBootsStack = 				new ItemStack(titaniumBoots);
        adamantiumHelmetStack = 			new ItemStack(adamantiumHelmet);
        adamantiumChestStack = 				new ItemStack(adamantiumChest);
        adamantiumPantsStack = 				new ItemStack(adamantiumPants);
        adamantiumBootsStack = 				new ItemStack(adamantiumBoots);
        linenStack = 						new ItemStack(linen);
        reinforcedLeatherStack = 			new ItemStack(reinforcedLeather);
        lambchopStack = 					new ItemStack(lambchop);
        cookedLambchopStack = 				new ItemStack(cookedLambchop);
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
	    	
	    // Staves
        GameRegistry.registerItem(fireStaff, "fireStaff");
	    	LanguageRegistry.addName(fireStaff, "Fire Staff");
	    GameRegistry.registerItem(fireRune, "fireRune");
	    	LanguageRegistry.addName(fireRune, "Fire Rune");
	    GameRegistry.registerItem(waterStaff, "waterStaff");
	    	LanguageRegistry.addName(waterStaff, "Water Staff");
	    GameRegistry.registerItem(waterRune, "waterRune");
	    	LanguageRegistry.addName(waterRune, "Water Rune");
	    GameRegistry.registerItem(iceStaff, "iceStaff");
	    	LanguageRegistry.addName(iceStaff, "Ice Staff");
	    GameRegistry.registerItem(iceRune, "iceRune");
	    	LanguageRegistry.addName(iceRune, "Ice Rune");
	    GameRegistry.registerItem(earthStaff, "Earth Staff");
	    	LanguageRegistry.addName(earthStaff, "earthStaff");
	    GameRegistry.registerItem(earthRune, "Earth Rune");
	    	LanguageRegistry.addName(earthRune, "Earth Rune");
	    GameRegistry.registerItem(citrineStaff, "citrineStaff");
	    	LanguageRegistry.addName(citrineStaff, "Citrine Staff");
	    GameRegistry.registerItem(citrineRune, "citrineRune");
	    	LanguageRegistry.addName(citrineRune, "Citrine Rune");
	    GameRegistry.registerItem(blankItem, "blankItem");
	    
	    // Armor
	    GameRegistry.registerItem(linenHelmet, "linenHelmet");
			LanguageRegistry.addName(linenHelmet, "Wizard Hat");
		GameRegistry.registerItem(linenChest, "linenChest");
			LanguageRegistry.addName(linenChest, "Wizard Robe");
		GameRegistry.registerItem(linenPants, "linenPants");
			LanguageRegistry.addName(linenPants, "Wizard Legs");
		GameRegistry.registerItem(linenBoots, "linenBoots");
			LanguageRegistry.addName(linenBoots, "Wizard Boots");
		GameRegistry.registerItem(reinforcedLeatherHelmet, "reinforcedLeatherHelmet");
			LanguageRegistry.addName(reinforcedLeatherHelmet, "Reinforced Leather Helmet");
		GameRegistry.registerItem(reinforcedLeatherChest, "reinforcedLeatherChest");
			LanguageRegistry.addName(reinforcedLeatherChest, "Reinforced Leather Chest");
		GameRegistry.registerItem(reinforcedLeatherPants, "reinforcedLeatherPants");
			LanguageRegistry.addName(reinforcedLeatherPants, "Reinforced Leather Pants");
		GameRegistry.registerItem(reinforcedLeatherBoots, "reinforcedLeatherBoots");
			LanguageRegistry.addName(reinforcedLeatherBoots, "Reinforced Leather Boots");
	    GameRegistry.registerItem(titaniumHelmet, "titaniumHelmet");
    		LanguageRegistry.addName(titaniumHelmet, "Titanium Helmet");
    	GameRegistry.registerItem(titaniumChest, "titaniumChest");
    		LanguageRegistry.addName(titaniumChest, "Titanium Chestplate");
    	GameRegistry.registerItem(titaniumPants, "titaniumPants");
    		LanguageRegistry.addName(titaniumPants, "Titanium Legs");
    	GameRegistry.registerItem(titaniumBoots, "titaniumBoots");
    		LanguageRegistry.addName(titaniumBoots, "Titanium Boots");
    	GameRegistry.registerItem(adamantiumHelmet, "adamantiumHelmet");
    		LanguageRegistry.addName(adamantiumHelmet, "Adamantium Helmet");
    	GameRegistry.registerItem(adamantiumChest, "adamantiumChest");
    		LanguageRegistry.addName(adamantiumChest, "Adamantium Chestplate");
    	GameRegistry.registerItem(adamantiumPants, "adamantiumPants");
    		LanguageRegistry.addName(adamantiumPants, "Adamantium Legs");
    	GameRegistry.registerItem(adamantiumBoots, "adamantiumBoots");
    		LanguageRegistry.addName(adamantiumBoots, "Adamantium Boots");
    	
    	GameRegistry.registerItem(linen, "linen");
    		LanguageRegistry.addName(linen, "Linen");
    	GameRegistry.registerItem(reinforcedLeather, "reinforcedLeather");
    		LanguageRegistry.addName(reinforcedLeather, "Reinforced Leather");
    	GameRegistry.registerItem(flaxFiber, "flaxFiber");
    		LanguageRegistry.addName(flaxFiber, "Flax Fibers");
    		
    	GameRegistry.registerItem(lambchop, "lambchop");
    		LanguageRegistry.addName(lambchop, "Raw Lambchop");
    	GameRegistry.registerItem(cookedLambchop, "cookedLambchop");
    		LanguageRegistry.addName(cookedLambchop, "Cooked Lambchop");
    		
	    	
    	return true;
	}
}
