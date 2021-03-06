/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.bartkneepkens.shareboxmod.tileentity;

import com.bartkneepkens.shareboxmod.block.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import worldsavedata.ShareBoxWorldSaveData;

/**
 *
 * @author BartKneepkens
 */
public class ShareBoxTileEntity extends TileEntity implements IInventory{
    
    //public ShareBoxWorldSaveData saveData = new ShareBoxWorldSaveData("kutje");
    
    private String customName;
    
    public int id;
    
    public ShareBoxTileEntity() {
        
    }
    
    public ItemStack[] getInventory() {
        return ModBlocks.map.get(this.id);
    }
    
    public void setInventory(ItemStack[] inventory) {
         ModBlocks.map.put(this.id, inventory);
    }
    
    public String getCustomName() {
        return customName;
    }
    
    public void setCustomName(String customName) {
        this.customName = customName;
    }
    
    
    @Override
    public int getSizeInventory() {
        return ModBlocks.map.get(this.id).length;
    }
    
    @Override
    public ItemStack getStackInSlot(int index) {
        //System.out.println("-------- Methode aangeroepen.");
        //saveData.markDirty();
        //System.out.println(saveData.isDirty());
        if (index < 0 || index >= this.getSizeInventory())
            return null;
        return ModBlocks.map.get(this.id)[index];
    }
    
    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;
            
            if (this.getStackInSlot(index).stackSize <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);
                
                if (this.getStackInSlot(index).stackSize <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }
                
                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }
    
    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }
    
    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory())
            return;
        
        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();
        
        if (stack != null && stack.stackSize == 0)
            stack = null;
        
        ModBlocks.map.get(this.id)[index] = stack;
        this.markDirty();
    }
    
    @Override
    public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customName : "ShareBoxxx";
    }
    
    @Override
    public boolean hasCustomInventoryName() {
        return this.customName != null && !this.customName.equals("");
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }
    
    @Override
    public void openInventory() {
        
    }
    
    @Override
    public void closeInventory() {
        
    }
    
    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return true;
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("ShareID", this.id);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.id = nbt.getInteger("ShareID");
    }
    
}
