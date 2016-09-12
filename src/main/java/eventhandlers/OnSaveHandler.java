/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventhandlers;

import com.bartkneepkens.shareboxmod.block.ModBlocks;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.util.HashMap;
import java.util.Map;
import worldsavedata.ShareBoxWorldSaveData;
import net.minecraft.item.ItemStack;

/**
 *
 * @author BartKneepkens
 */
public class OnSaveHandler {
    
    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        if(event.world != null){
            System.out.println("HELLO, getting inventory");
            //System.out.println(ShareBoxWorldSaveData.get(event.world).wasFracturerUsed());
            ModBlocks.map = ShareBoxWorldSaveData.get(event.world).getMap();
            
            if(ShareBoxWorldSaveData.get(event.world).getMap() == null){
                ModBlocks.map = new HashMap<Integer, ItemStack[]>();
            }
        }
    }
    
    @SubscribeEvent
    public void onWorldSave(WorldEvent.Save event) {
        if(event.world != null){
            System.out.println("HELLO, world isnt null");
            //ShareBoxWorldSaveData.get(event.world).requestNewId();
        }
    }
}
