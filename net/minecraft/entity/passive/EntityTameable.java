package net.minecraft.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityOwnable;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Team;
import net.minecraft.world.World;

public abstract class EntityTameable extends EntityAnimal implements EntityOwnable
{
    protected EntityAISit aiSit = new EntityAISit(this);

    public EntityTameable(World par1World)
    {
        super(par1World);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(17, "");
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);

        if (this.getOwnerName() == null)
        {
            par1NBTTagCompound.setString("Owner", "");
        }
        else
        {
            par1NBTTagCompound.setString("Owner", this.getOwnerName());
        }

        par1NBTTagCompound.setBoolean("Sitting", this.isSitting());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        String s = par1NBTTagCompound.getString("Owner");

        if (s.length() > 0)
        {
            this.setOwner(s);
            this.setTamed(true);
        }

        this.aiSit.setSitting(par1NBTTagCompound.getBoolean("Sitting"));
        this.setSitting(par1NBTTagCompound.getBoolean("Sitting"));
    }

    /**
     * Play the taming effect, will either be hearts or smoke depending on status
     */
    protected void playTameEffect(boolean par1)
    {
        String s = "heart";

        if (!par1)
        {
            s = "smoke";
        }

        for (int i = 0; i < 7; ++i)
        {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(s, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 7)
        {
            this.playTameEffect(true);
        }
        else if (par1 == 6)
        {
            this.playTameEffect(false);
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public boolean isTamed()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 4) != 0;
    }

    public void setTamed(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 4)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -5)));
        }
    }

    public boolean isSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setSitting(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    public String getOwnerName()
    {
        return this.dataWatcher.getWatchableObjectString(17);
    }

    public void setOwner(String par1Str)
    {
        this.dataWatcher.updateObject(17, par1Str);
    }

    public EntityLivingBase func_130012_q()
    {
        return this.worldObj.getPlayerEntityByName(this.getOwnerName());
    }

    public EntityAISit func_70907_r()
    {
        return this.aiSit;
    }

    public boolean func_142018_a(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase)
    {
        return true;
    }

    public Team getTeam()
    {
        if (this.isTamed())
        {
            EntityLivingBase entitylivingbase = this.func_130012_q();

            if (entitylivingbase != null)
            {
                return entitylivingbase.getTeam();
            }
        }

        return super.getTeam();
    }

    public boolean func_142014_c(EntityLivingBase par1EntityLivingBase)
    {
        if (this.isTamed())
        {
            EntityLivingBase entitylivingbase1 = this.func_130012_q();

            if (par1EntityLivingBase == entitylivingbase1)
            {
                return true;
            }

            if (entitylivingbase1 != null)
            {
                return entitylivingbase1.func_142014_c(par1EntityLivingBase);
            }
        }

        return super.func_142014_c(par1EntityLivingBase);
    }

    public Entity getOwner()
    {
        return this.func_130012_q();
    }
}
