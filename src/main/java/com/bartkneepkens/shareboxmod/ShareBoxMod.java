/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.bartkneepkens.shareboxmod;

import com.bartkneepkens.shareboxmod.proxy.CommonProxy;
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
@Mod(modid = ShareBoxMod.MODID, name = ShareBoxMod.MODNAME, version = ShareBoxMod.VERSIONID)
public class ShareBoxMod{
    
    public static final String MODID = "ShareBoxmod";
    public static final String MODNAME = "ShareBox Mod";
    public static final String VERSIONID = "1.0.0";
    
    @SidedProxy(clientSide="com.bartkneepkens.shareboxmod.proxy.ClientProxy", serverSide="com.bartkneepkens.shareboxmod.proxy.ServerProxy")
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
