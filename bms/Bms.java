package bms;
 
import net.minecraft.block.Block;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
 
@Mod(modid=BasicInfo.ID, name=BasicInfo.NAME, version=BasicInfo.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=true)
public class Bms {
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
        
        // New Items
        ItemsBMS.initItems();
        ItemsBMS.registerItems();
        
        // New Recipes
        ItemsBMS.registerItemStacks();
        RecipesBMS.registerRecipes();
        
        // New Blocks
        BlocksBMS.registerBlocks();
        
        // New Entities
        //EntityRegistry.registerModEntity(EntityPebble.class, "Entity Pebble", ModLoader.getUniqueEntityId(), instance, 128, 1, true);
        
        // New Renders
        //RenderingRegistry.registerEntityRenderingHandler(EntityPebble.class, new RenderSnowball(ItemsBMS.pebble));

    	GameRegistry.registerWorldGenerator(new BMSOreWorldGenerator());
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
   
}