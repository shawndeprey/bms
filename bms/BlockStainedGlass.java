package bms;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.jcraft.jorbis.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStainedGlass extends BlockBreakable
{
    public BlockStainedGlass(int id, String name)
    {
        super(id, BasicInfo.ID.toLowerCase() + ":" + name, Material.glass, false);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(0.2F);
        setLightOpacity(3);
        setStepSound(soundGlassFootstep);
        setUnlocalizedName(name);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }

    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        par2EntityPlayer.addStat(StatList.mineBlockStatArray[this.blockID], 1);
        par2EntityPlayer.addExhaustion(0.025F);

        if (this.canSilkHarvest() && EnchantmentHelper.getSilkTouchModifier(par2EntityPlayer))
        {
            ItemStack itemstack = this.createStackedBlock(par6);

            if (itemstack != null)
            {
                this.dropBlockAsItem_do(par1World, par3, par4, par5, itemstack);
            }
        }
        else
        {
        	par1World.setBlockToAir(par3, par4, par5);
            return;
        }
    }

    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    public int getMobilityFlag()
    {
        return 0;
    }
}
