package net.minecraft.command;

import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class CommandEffect extends CommandBase
{
    public String getCommandName()
    {
        return "effect";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return "commands.effect.usage";
    }

    public void processCommand(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        if (par2ArrayOfStr.length < 2)
        {
            throw new WrongUsageException("commands.effect.usage", new Object[0]);
        }
        else
        {
            EntityPlayerMP entityplayermp = func_82359_c(par1ICommandSender, par2ArrayOfStr[0]);

            if (par2ArrayOfStr[1].equals("clear"))
            {
                if (entityplayermp.getActivePotionEffects().isEmpty())
                {
                    throw new CommandException("commands.effect.failure.notActive.all", new Object[] {entityplayermp.getEntityName()});
                }

                entityplayermp.clearActivePotions();
                notifyAdmins(par1ICommandSender, "commands.effect.success.removed.all", new Object[] {entityplayermp.getEntityName()});
            }
            else
            {
                int i = parseIntWithMin(par1ICommandSender, par2ArrayOfStr[1], 1);
                int j = 600;
                int k = 30;
                int l = 0;

                if (i < 0 || i >= Potion.potionTypes.length || Potion.potionTypes[i] == null)
                {
                    throw new NumberInvalidException("commands.effect.notFound", new Object[] {Integer.valueOf(i)});
                }

                if (par2ArrayOfStr.length >= 3)
                {
                    k = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 0, 1000000);

                    if (Potion.potionTypes[i].isInstant())
                    {
                        j = k;
                    }
                    else
                    {
                        j = k * 20;
                    }
                }
                else if (Potion.potionTypes[i].isInstant())
                {
                    j = 1;
                }

                if (par2ArrayOfStr.length >= 4)
                {
                    l = parseIntBounded(par1ICommandSender, par2ArrayOfStr[3], 0, 255);
                }

                if (k == 0)
                {
                    if (!entityplayermp.isPotionActive(i))
                    {
                        throw new CommandException("commands.effect.failure.notActive", new Object[] {ChatMessageComponent.func_111077_e(Potion.potionTypes[i].getName()), entityplayermp.getEntityName()});
                    }

                    entityplayermp.removePotionEffect(i);
                    notifyAdmins(par1ICommandSender, "commands.effect.success.removed", new Object[] {ChatMessageComponent.func_111077_e(Potion.potionTypes[i].getName()), entityplayermp.getEntityName()});
                }
                else
                {
                    PotionEffect potioneffect = new PotionEffect(i, j, l);
                    entityplayermp.addPotionEffect(potioneffect);
                    notifyAdmins(par1ICommandSender, "commands.effect.success", new Object[] {ChatMessageComponent.func_111077_e(potioneffect.getEffectName()), Integer.valueOf(i), Integer.valueOf(l), entityplayermp.getEntityName(), Integer.valueOf(k)});
                }
            }
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String[] par2ArrayOfStr)
    {
        return par2ArrayOfStr.length == 1 ? getListOfStringsMatchingLastWord(par2ArrayOfStr, this.getAllUsernames()) : null;
    }

    protected String[] getAllUsernames()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] par1ArrayOfStr, int par2)
    {
        return par2 == 0;
    }
}
