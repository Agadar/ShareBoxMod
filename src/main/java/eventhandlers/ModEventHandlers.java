/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventhandlers;

/**
 *
 * @author BartKneepkens
 */
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import worldsavedata.ShareBoxWorldSaveData;

/** Manages this mod's event handlers.  */
public class ModEventHandlers 
{
	/** Registers this mod's event handlers. */
	public static void registerModEventHandlers() 
	{
		// Register the event hook for increasing the drop rate of apples from leaves.
                MinecraftForge.EVENT_BUS.register(new OnSaveHandler());
	}
}