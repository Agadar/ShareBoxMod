/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.bartkneepkens.mailboxmod.proxy;

import com.bartkneepkens.mailboxmod.block.ModBlocks;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author BartKneepkens
 */
public class CommonProxy{
    
    public void preInit(FMLPreInitializationEvent e) {
        ModBlocks.init();
    }
    
    public void init(FMLInitializationEvent e) {
        
    }
    
    public void postInit(FMLPostInitializationEvent e) {
        
    }
}
