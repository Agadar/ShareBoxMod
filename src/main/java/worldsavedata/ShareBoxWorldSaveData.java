/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldsavedata;
import com.bartkneepkens.shareboxmod.block.ModBlocks;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.World;

/**
 *
 * @author BartKneepkens
 */
public class ShareBoxWorldSaveData extends WorldSavedData {
    
//    final static String key = "ShareBox.Key";
//
//    public ShareBoxWorldSaveData(String p_i2141_1_) {
//        super(p_i2141_1_);
//    }
//    
//    public int getal;
//    
//    public static ShareBoxWorldSaveData instance = new ShareBoxWorldSaveData("");
//
//    @Override
//    public void readFromNBT(NBTTagCompound nbt) {
//       
//        System.out.println("0009999000      READING NBT");
//        nbt.setInteger("nextId", getal);
//        
//        
//        
////        ObjectInputStream in = null;
////        try {
////            ByteArrayInputStream byteIn = new ByteArrayInputStream(cpd.getByteArray("Inventories"));
////            in = new ObjectInputStream(byteIn);
////            ModBlocks.map = (Map<Integer, ItemStack[]>) in.readObject();
////            
////        } catch (IOException ex) {
////            Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
////        } catch (ClassNotFoundException ex) {
////            Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
////        } finally {
////            try {
////                in.close();
////            } catch (IOException ex) {
////                Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
////            }
////        }
//    }
//
//    @Override
//    public void writeToNBT(NBTTagCompound nbt) {
//        System.out.println("0009999000      WRITING NBT");
//        getal  = nbt.getInteger("nextId");
//        
////        try {
////            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
////            ObjectOutputStream out = new ObjectOutputStream(byteOut);
////            out.writeObject(ModBlocks.map);
////            
////            cpd.setByteArray("Inventories", byteOut.toByteArray());
////            
////        } catch (IOException ex) {
////            Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
////        }
//    }
//    
//    public static ShareBoxWorldSaveData get(World world) {
//        System.out.println("GETTING WORLD DATA");
//		ShareBoxWorldSaveData data = (ShareBoxWorldSaveData)world.loadItemData(ShareBoxWorldSaveData.class, "kut");
//		if (data == null) {
//                    System.out.println("DATA IS NOT THERE");
//			data = new ShareBoxWorldSaveData("kut");
//			world.setItemData("kut", data);
//		}
//		return data;
//	}
    
    private static final String IDENTIFIER = "ShareBox";
	
	private Map<Integer, ItemStack[]> map;
	
	public ShareBoxWorldSaveData() {
		super(IDENTIFIER);
	}
	
	public ShareBoxWorldSaveData(String identifier) {
		super(identifier);
	}
        
        public Map<Integer, ItemStack[]> getMap(){
            this.markDirty();
            return map;
        }
        
        public void setMap(Map<Integer, ItemStack[]> map){
            this.map = map;
            this.markDirty();
        }

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
            System.out.println("0009999000      READING NBT");
            ObjectInputStream in = null;
            
            try {
                ByteArrayInputStream byteIn = new ByteArrayInputStream(nbt.getByteArray("Inventories"));
                in = new ObjectInputStream(byteIn);
                this.map = (Map<Integer, ItemStack[]>) in.readObject();
                
            } catch (IOException ex) {
                Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}

        @Override
        public void writeToNBT(NBTTagCompound nbt) {
            ObjectOutputStream out = null;
            
            try {
                System.out.println("0009999000      WRITING NBT");
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                out = new ObjectOutputStream(byteOut);
                out.writeObject(this.map);
                nbt.setByteArray("Inventories", byteOut.toByteArray());
            } catch (IOException ex) {
                Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(ShareBoxWorldSaveData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
	
	public static ShareBoxWorldSaveData get(World world) {
		ShareBoxWorldSaveData data = (ShareBoxWorldSaveData)world.loadItemData(ShareBoxWorldSaveData.class, IDENTIFIER);
		if (data == null) {
			data = new ShareBoxWorldSaveData();
			world.setItemData(IDENTIFIER, data);
		}
		return data;
	}
}
