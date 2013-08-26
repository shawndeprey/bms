package bms;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStainedPane extends BlockPane
{
    protected BlockStainedPane(int id, String name, String sideName)
    {
        super(id, BasicInfo.ID.toLowerCase() + ":" + name, BasicInfo.ID.toLowerCase() + ":" + sideName, Material.glass, false);
        setHardness(0.3F);
        setStepSound(soundGlassFootstep);
        setUnlocalizedName(sideName);
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
}
