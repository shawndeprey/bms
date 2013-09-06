package bms;
 
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
 
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
        EntitiesBMS.registerEntities(this);
        
        // New Renders
        RenderBMS.registerRenderers();

    	// World Generation
        WorldGeneratorBMS.registerGenerator();
        
        
        //System.out.println(10511680 >> 16 & 255);
        //System.out.println(10511680 >> 8 & 255);
        //System.out.println(10511680 & 255);
        System.out.println(159 << 16);
        System.out.println(100 << 8);
        //System.out.println( (220 << 16) + (220 << 8) + 220);
        //13041664 + 50944 + 199 11582703
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // Stub Method
    }
   
}