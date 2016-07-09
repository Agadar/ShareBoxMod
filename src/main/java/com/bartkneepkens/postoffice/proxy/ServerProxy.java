/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bartkneepkens.postoffice.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author BartKneepkens
 */
public class ServerProxy extends CommonProxy {
    
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        System.out.println("SERVER PROXY PREINIT");
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        System.out.println("SERVER PROXY INIT");
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        System.out.println("SERVER PROXY POSTINIT");
    }
}
