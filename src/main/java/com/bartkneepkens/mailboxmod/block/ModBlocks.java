/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bartkneepkens.mailboxmod.block;

import com.bartkneepkens.mailboxmod.tileentity.MailboxTileEntity;
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
    
    public static Block mailboxBlock;
    
    public static Map<Integer, ItemStack[]> map;
    
    public static int lastID = 0;
    public static boolean shouldUp = false;

    public static final void init() {
        map = new HashMap<Integer, ItemStack[]>();
        GameRegistry.registerBlock(mailboxBlock = new MailboxBlock("mailbox", Material.wood), "mailbox");
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mailboxBlock, 2), "###", "$ $", "###", '#', Blocks.planks, '$', Items.iron_ingot);
        GameRegistry.registerTileEntity(MailboxTileEntity.class, "mailboxEntity");
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
