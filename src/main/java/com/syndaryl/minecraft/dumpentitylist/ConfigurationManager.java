package com.syndaryl.minecraft.dumpentitylist;

import net.minecraftforge.common.config.Configuration;
import java.io.File;


public class ConfigurationManager {
	private static Configuration config;
	
	public static boolean
		masterDisable,
		modifyDeathDrops,
		compressedBlocks,
		compressedBlocksUseGCCompressor,
		newFood;

	public static int configurableTimeForEachFeather;


	public static void initConfig(File configFile) {
		config = new Configuration(configFile);
		
		//Load the Configuration File
		config.load();
				
		// Master switch to disable the mod
		masterDisable = config.get(Configuration.CATEGORY_GENERAL, "masterDisable", false, "Master switch to disable the mod. The default is false. Set to true to disable the mod.").getBoolean(false);
		
		// Modify animal drops on death? bones, leather.
		//modifyDeathDrops = config.get(Configuration.CATEGORY_GENERAL, "modifyDeathDrops", true, "Modify animal drops on death? Default is true. Set to false if you wish for chicken drops to be unaffected by the mod.").getBoolean(true);

		// compressed blocks.
		//compressedBlocks = config.get("Blocks", "compressedBlocks", true, "Add compressed blocks of dirt, cobblestone, sand, stone.").getBoolean(true);

		// compressed blocks.
		//compressedBlocksUseGCCompressor = config.get("Blocks", "compressedBlocksUseGCCompressor", true, "Block compression performed using the GalactiCraft compressor, not the crafting table.").getBoolean(true);
		
		//newFood = config.getBoolean(Configuration.CATEGORY_GENERAL, "newFood", true, "Add new food items, such as sugar-water.");

		// configurableTimeForEachFeather = config.get(Configuration.CATEGORY_GENERAL, "configurableTimeForEachFeather", 26000, "Changing this value determines how long it takes for feathers to drop. 6000 is added, and is thus the minimum. Default is 26000 (default total is 32000)").getInt(26000);
		
		//Save the configuration file		
		config.save();
	}

}
