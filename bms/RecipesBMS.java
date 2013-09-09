package bms;

import net.minecraft.block.Block;
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
        
        // Campcraft
        GameRegistry.addRecipe(BlocksBMS.campfireUnlitStack, " x ", " y ", "yzy",'x', new ItemStack(Block.wood), 'y', Item.stick, 'z', Item.paper);
        GameRegistry.addRecipe(BlocksBMS.campfireUnlitStack, " x ", " y ", "yzy",'x', new ItemStack(Block.wood, 1, 1), 'y', Item.stick, 'z', Item.paper);
        GameRegistry.addRecipe(BlocksBMS.campfireUnlitStack, " x ", " y ", "yzy",'x', new ItemStack(Block.wood, 1, 2), 'y', Item.stick, 'z', Item.paper);
        GameRegistry.addRecipe(BlocksBMS.campfireUnlitStack, " x ", " y ", "yzy",'x', new ItemStack(Block.wood, 1, 3), 'y', Item.stick, 'z', Item.paper);
        
		return true;
    }
}
