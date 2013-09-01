package bms;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipesBMS {
	
	public static boolean registerRecipes()
    {
		GameRegistry.addSmelting(BlocksBMS.titaniumOre.blockID, ItemsBMS.titaniumIngotStack, 0.5f);
        GameRegistry.addSmelting(BlocksBMS.adamantiumOre.blockID, ItemsBMS.adamantiumIngotStack, 0.5f);
        
		GameRegistry.addShapelessRecipe(ItemsBMS.rubyPowderStack, ItemsBMS.rubyStack);
        GameRegistry.addShapelessRecipe(ItemsBMS.sapphirePowderStack, ItemsBMS.sapphireStack);
        GameRegistry.addShapelessRecipe(ItemsBMS.citrinePowderStack, ItemsBMS.citrineStack);
        GameRegistry.addShapelessRecipe(ItemsBMS.jadeitePowderStack, ItemsBMS.jadeiteStack);
        GameRegistry.addShapelessRecipe(ItemsBMS.diamondPowderStack, ItemsBMS.diamondStack);
        GameRegistry.addShapelessRecipe(ItemsBMS.linenStack, ItemsBMS.flaxFiber);
        GameRegistry.addShapelessRecipe(ItemsBMS.reinforcedLeatherStack, Item.leather, ItemsBMS.pebble);
        
        for (int i = 0; i < 16; ++i) {
        	GameRegistry.addShapelessRecipe(ItemsBMS.linenHelmetStack, new ItemStack(Item.dyePowder.itemID, 1, i), ItemsBMS.linenHelmetStack);
        	GameRegistry.addShapelessRecipe(ItemsBMS.linenChestStack, new ItemStack(Item.dyePowder.itemID, 1, i), ItemsBMS.linenChestStack);
        	GameRegistry.addShapelessRecipe(ItemsBMS.linenPantsStack, new ItemStack(Item.dyePowder.itemID, 1, i), ItemsBMS.linenPantsStack);
        	GameRegistry.addShapelessRecipe(ItemsBMS.linenBootsStack, new ItemStack(Item.dyePowder.itemID, 1, i), ItemsBMS.linenBootsStack);
        }
        
        GameRegistry.addRecipe(ItemsBMS.titaniumBlockStack, "xxx", "xxx", "xxx", 'x',ItemsBMS.titaniumIngotStack);
        GameRegistry.addRecipe(ItemsBMS.adamantiumBlockStack, "xxx", "xxx", "xxx", 'x',ItemsBMS.adamantiumIngotStack);
        GameRegistry.addRecipe(ItemsBMS.titaniumShovelStack, " x ", " y ", " y ", 'x',ItemsBMS.titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.titaniumPickaxeStack, "xxx", " y ", " y ", 'x',ItemsBMS.titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.titaniumHatchetStack, "xx ", "xy ", " y ", 'x',ItemsBMS.titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.titaniumHoeStack, "xx ", " y ", " y ", 'x',ItemsBMS.titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.adamantiumShovelStack, " x ", " y ", " y ", 'x',ItemsBMS.adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.adamantiumPickaxeStack, "xxx", " y ", " y ", 'x',ItemsBMS.adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.adamantiumHatchetStack, "xx ", "xy ", " y ", 'x',ItemsBMS.adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.adamantiumHoeStack, "xx ", " y ", " y ", 'x',ItemsBMS.adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.titaniumSwordStack, "x", "x", "y", 'x',ItemsBMS.titaniumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.adamantiumSwordStack, "x", "x", "y", 'x',ItemsBMS.adamantiumIngotStack, 'y',Item.stick);
        GameRegistry.addRecipe(ItemsBMS.linenHelmetStack, "xxx", "x x", 'x',ItemsBMS.linen);
        GameRegistry.addRecipe(ItemsBMS.linenChestStack, "x x", "xxx", "xxx", 'x',ItemsBMS.linen);
        GameRegistry.addRecipe(ItemsBMS.linenPantsStack, "xxx", "x x", "x x", 'x',ItemsBMS.linen);
        GameRegistry.addRecipe(ItemsBMS.linenBootsStack, "x x", "x x", 'x',ItemsBMS.linen);
        GameRegistry.addRecipe(ItemsBMS.reinforcedLeatherHelmetStack, "xxx", "x x", 'x',ItemsBMS.reinforcedLeather);
        GameRegistry.addRecipe(ItemsBMS.reinforcedLeatherChestStack, "x x", "xxx", "xxx", 'x',ItemsBMS.reinforcedLeather);
        GameRegistry.addRecipe(ItemsBMS.reinforcedLeatherPantsStack, "xxx", "x x", "x x", 'x',ItemsBMS.reinforcedLeather);
        GameRegistry.addRecipe(ItemsBMS.reinforcedLeatherBootsStack, "x x", "x x", 'x',ItemsBMS.reinforcedLeather);
        GameRegistry.addRecipe(ItemsBMS.titaniumHelmetStack, "xxx", "x x", 'x',ItemsBMS.titaniumIngot);
        GameRegistry.addRecipe(ItemsBMS.titaniumChestStack, "x x", "xxx", "xxx", 'x',ItemsBMS.titaniumIngot);
        GameRegistry.addRecipe(ItemsBMS.titaniumPantsStack, "xxx", "x x", "x x", 'x',ItemsBMS.titaniumIngot);
        GameRegistry.addRecipe(ItemsBMS.titaniumBootsStack, "x x", "x x", 'x',ItemsBMS.titaniumIngot);
        GameRegistry.addRecipe(ItemsBMS.adamantiumHelmetStack, "xxx", "x x", 'x',ItemsBMS.adamantiumIngot);
        GameRegistry.addRecipe(ItemsBMS.adamantiumChestStack, "x x", "xxx", "xxx", 'x',ItemsBMS.adamantiumIngot);
        GameRegistry.addRecipe(ItemsBMS.adamantiumPantsStack, "xxx", "x x", "x x", 'x',ItemsBMS.adamantiumIngot);
        GameRegistry.addRecipe(ItemsBMS.adamantiumBootsStack, "x x", "x x", 'x',ItemsBMS.adamantiumIngot);
		return true;
    }
}
