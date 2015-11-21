package com.syndaryl.minecraft.dumpentitylist;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import org.reflections.Reflections;

import com.google.common.collect.Sets;

public class ItemEntityListerWand extends ItemTool {

	private static final String toolClass = "wand";
	private static final Set effectiveBlocks = Sets.newHashSet(new Block[] {Blocks.grass, Blocks.dirt});
	
    
	public ItemEntityListerWand(float damageVsEntity, ToolMaterial toolMaterial,
			Set effectiveAgainst) {
		super(damageVsEntity, toolMaterial, effectiveAgainst);
		// TODO Auto-generated constructor stub
		this.setMaxStackSize(1);
	    this.setCreativeTab(CreativeTabs.tabMisc); 
	}
	

    public ItemEntityListerWand() {
		// this is not a very good tool :)
    	this(0.5F, ToolMaterial.WOOD, effectiveBlocks);
	}


	/**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack itemWand, World minecraftWorld, EntityPlayer activatingPlayer)
    {
		// delay the player for 128 ticks with an animation.
		activatingPlayer.setItemInUse(itemWand, this.getMaxItemUseDuration(itemWand));
		//EntityRegistry joe = EntityRegistry.instance();
		//EnumCreatureType bob = EnumCreatureType.ambient;
		Reflections reflections = new Reflections("com.syndaryl.minecraft.dumpentitylist");
		Set<Class<? extends net.minecraft.entity.passive.IAnimals>> subTypes = reflections.getSubTypesOf(net.minecraft.entity.passive.IAnimals.class);
		java.util.Iterator<Class<? extends IAnimals>> itr = subTypes.iterator();
		while(itr.hasNext())
		{
			Class<? extends IAnimals> mobType = itr.next();
			DumpEntityList.LOG.info(mobType.getCanonicalName());
			//subTypes.forEach(y -> DumpEntityList.LOG.info(y.class.toGenericString()));
		}
        return itemWand;
    }
	
    /**
     * How long it takes to use or consume an item
     */
	@Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
		// food takes 32 ticks to eat - this is 4x as long.
        return 128;
    }
    
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }
}
