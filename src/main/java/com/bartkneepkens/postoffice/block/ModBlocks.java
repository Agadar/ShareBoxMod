/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bartkneepkens.postoffice.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 *
 * @author BartKneepkens
 */
public class ModBlocks {
    
    public static Block mailboxBlock;

    public static final void init() {
        GameRegistry.registerBlock(mailboxBlock = new MailboxBlock("mailbox", Material.cloth), "mailbox");
    }
    
}
