/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldsavedata;
import com.bartkneepkens.shareboxmod.block.ModBlocks;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

/**
 *
 * @author BartKneepkens
 */
public class ShareBoxWorldSaveData extends WorldSavedData {
    
    final static String key = "ShareBox.Key";

    public ShareBoxWorldSaveData(String p_i2141_1_) {
        super(p_i2141_1_);
        
        
    }

    @Override
    public void readFromNBT(NBTTagCompound p_76184_1_) {
       
    }

    @Override
    public void writeToNBT(NBTTagCompound cpd) {
        
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(ModBlocks.map);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
