/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bartkneepkens.mailboxmod.block;

import com.bartkneepkens.mailboxmod.tileentity.MailboxTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
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

    public static final void init() {
        GameRegistry.registerBlock(mailboxBlock = new MailboxBlock("mailbox", Material.wood), "mailbox");
        GameRegistry.addRecipe(new ItemStack(ModBlocks.mailboxBlock, 2), "###", "$ $", "###", '#', Blocks.planks, '$', Items.iron_ingot);
        GameRegistry.registerTileEntity(MailboxTileEntity.class, "mailboxEntity");
    }
    
}
