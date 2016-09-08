/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bartkneepkens.shareboxmod.block;

import com.bartkneepkens.shareboxmod.tileentity.ShareBoxTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 *
 * @author BartKneepkens
 */
public class ModBlocks {
    
    public static Block ShareBoxBlock;
    
    public static Map<Integer, ItemStack[]> map;
    
    public static int lastID = 0;
    public static boolean shouldUp = false;

    public static final void init() {
        map = new HashMap<Integer, ItemStack[]>();
        GameRegistry.registerBlock(ShareBoxBlock = new ShareBoxBlock("ShareBox", Material.wood), "ShareBox");
        GameRegistry.addRecipe(new ItemStack(ModBlocks.ShareBoxBlock, 2), "###", "$ $", "###", '#', Blocks.planks, '$', Items.iron_ingot);
        GameRegistry.registerTileEntity(ShareBoxTileEntity.class, "ShareBoxEntity");
    }
    
    public static int getUniqueID(){
        if(shouldUp){
            lastID = lastID + 1;
            shouldUp = false;
            return lastID - 1;
        }
        shouldUp = true;
        return lastID;
    }
    
}
