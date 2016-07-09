/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.bartkneepkens.postoffice;

import com.bartkneepkens.postoffice.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author BartKneepkens
 */
@Mod(modid = PostOfficeMod.MODID, name = PostOfficeMod.MODNAME, version = PostOfficeMod.VERSIONID)
public class PostOfficeMod{
    
    public static final String MODID = "postoffice";
    public static final String MODNAME = "Post Office Mod";
    public static final String VERSIONID = "1.0.0";
    
    @SidedProxy(clientSide="com.bartkneepkens.postoffice.proxy.ClientProxy", serverSide="com.bartkneepkens.postoffice.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
