package bms;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class ItemBMSArmor extends ItemArmor {
	
	private String armorPrefix;
	private final EnumArmorMaterial bmsMaterial;

	public ItemBMSArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String AP) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		bmsMaterial = par2EnumArmorMaterial;
		armorPrefix = AP;
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {	
		String path = armorPrefix + "_1";
		if(stack.itemID == ItemsBMS.titaniumPants.itemID || stack.itemID == ItemsBMS.adamantiumPants.itemID || 
		   stack.itemID == ItemsBMS.linenPants.itemID || stack.itemID == ItemsBMS.reinforcedLeatherPants.itemID){
			path = armorPrefix + "_2";
		}
		path += type == "overlay" ? "_" + type : "";
		return "bms:textures/models/armor/" + path + ".png";
    }
	
	// Set Color
	public void func_82813_b(ItemStack par1ItemStack, int par2)
    {
        if (this.bmsMaterial != EnumBMS.linenArmorMaterial)
        {
            throw new UnsupportedOperationException("Can\'t dye non-linen!");
        }
        else
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                nbttagcompound = new NBTTagCompound();
                par1ItemStack.setTagCompound(nbttagcompound);
            }

            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (!nbttagcompound.hasKey("display"))
            {
                nbttagcompound.setCompoundTag("display", nbttagcompound1);
            }
            
            System.out.println(par2);

            nbttagcompound1.setInteger("color", par2);
        }
    }
	
	public boolean hasColor(ItemStack par1ItemStack)
    {
        return this.bmsMaterial != EnumBMS.linenArmorMaterial ? false : (!par1ItemStack.hasTagCompound() ? false : (!par1ItemStack.getTagCompound().hasKey("display") ? false : par1ItemStack.getTagCompound().getCompoundTag("display").hasKey("color")));
    }
	
	public int getColor(ItemStack par1ItemStack)
    {
        if (this.bmsMaterial != EnumBMS.linenArmorMaterial)
        {
            return -1;
        }
        else
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                return 13092807;
            }
            else
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                return nbttagcompound1 == null ? 13092807 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 13092807);
            }
        }
    }
	
	/**
     * Remove the color from the specified armor ItemStack.
     */
    public void removeColor(ItemStack par1ItemStack)
    {
        if (this.bmsMaterial != EnumBMS.linenArmorMaterial)
        {
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound != null)
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

                if (nbttagcompound1.hasKey("color"))
                {
                    nbttagcompound1.removeTag("color");
                }
            }
        }
    }
}
