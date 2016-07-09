/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.bartkneepkens.postoffice.block;

import com.bartkneepkens.postoffice.PostOfficeMod;
import net.minecraft.block.Block;
import static net.minecraft.block.Block.soundTypeWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

/**
 *
 * @author BartKneepkens
 */
public class MailboxBlock extends Block {
    
    public IIcon[] icons = new IIcon[6];
    
    protected MailboxBlock(String name, Material material) {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(PostOfficeMod.MODID + ":" + name);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeWood);
    }
    
    @Override
    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
            if(i <= 1){
                this.icons[i] = reg.registerIcon(this.textureName + "_planks");
            }
            else{
                this.icons[i] = reg.registerIcon(this.textureName + "_side");
            }
        }
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }
    
}
