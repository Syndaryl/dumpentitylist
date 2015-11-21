package com.syndaryl.minecraft.dumpentitylist;

import net.minecraft.item.Item;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.message.StringFormatterMessageFactory;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.util.PropertiesUtil;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = DumpEntityList.MODID, version = DumpEntityList.VERSION)
public class DumpEntityList
{
    public static final String MODID = "dumpentitylist";
    public static final String VERSION = "1.0";
    
    @Instance(value = "DumpEntityList")
    public static DumpEntityList instance;
    
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="com.syndaryl.minecraft.dumpentitylist.client.ClientProxy", serverSide="com.syndaryl.minecraft.dumpentitylist.CommonProxy")
	public static CommonProxy proxy;
	public static final SimpleLogger LOG = new SimpleLogger(
			"DumpEntityList", Level.INFO, false, false, true, false, "yyyy/mm/dd hh:mm:ss", 
			new StringFormatterMessageFactory(), new PropertiesUtil(""), null
			);
	public static Item magicEntityListerWand;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ConfigurationManager.initConfig(event.getSuggestedConfigurationFile());
    	
    	magicEntityListerWand = new ItemEntityListerWand().setUnlocalizedName("Magic_Entity_List_Wand");
        GameRegistry.registerItem(magicEntityListerWand, "Magic_Entity_List_Wand");;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
            proxy.registerRenderers();
    }
   
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method

    }
}
