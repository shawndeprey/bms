package net.minecraft.client.main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.List;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

@SideOnly(Side.CLIENT)
public class Main
{
    public static void main(String[] par0ArrayOfStr)
    {
        System.setProperty("java.net.preferIPv4Stack", "true");
        OptionParser optionparser = new OptionParser();
        optionparser.allowsUnrecognizedOptions();
        optionparser.accepts("demo");
        optionparser.accepts("fullscreen");
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec = optionparser.accepts("server").withRequiredArg();
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec1 = optionparser.accepts("port").withRequiredArg().ofType(Integer.class).defaultsTo(Integer.valueOf(25565), new Integer[0]);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec2 = optionparser.accepts("gameDir").withRequiredArg().ofType(File.class).defaultsTo(new File("."), new File[0]);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec3 = optionparser.accepts("assetsDir").withRequiredArg().ofType(File.class);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec4 = optionparser.accepts("resourcePackDir").withRequiredArg().ofType(File.class);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec5 = optionparser.accepts("proxyHost").withRequiredArg();
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec6 = optionparser.accepts("proxyPort").withRequiredArg().defaultsTo("8080", new String[0]).ofType(Integer.class);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec7 = optionparser.accepts("proxyUser").withRequiredArg();
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec8 = optionparser.accepts("proxyPass").withRequiredArg();
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec9 = optionparser.accepts("username").withRequiredArg().defaultsTo("Player" + Minecraft.getSystemTime() % 1000L, new String[0]);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec10 = optionparser.accepts("session").withRequiredArg();
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec11 = optionparser.accepts("version").withRequiredArg().required();
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec12 = optionparser.accepts("width").withRequiredArg().ofType(Integer.class).defaultsTo(Integer.valueOf(854), new Integer[0]);
        ArgumentAcceptingOptionSpec argumentacceptingoptionspec13 = optionparser.accepts("height").withRequiredArg().ofType(Integer.class).defaultsTo(Integer.valueOf(480), new Integer[0]);
        NonOptionArgumentSpec nonoptionargumentspec = optionparser.nonOptions();
        OptionSet optionset = optionparser.parse(par0ArrayOfStr);
        List list = optionset.valuesOf(nonoptionargumentspec);
        String s = (String)optionset.valueOf(argumentacceptingoptionspec5);
        Proxy proxy = Proxy.NO_PROXY;

        if (s != null)
        {
            try
            {
                proxy = new Proxy(Type.SOCKS, new InetSocketAddress(s, ((Integer)optionset.valueOf(argumentacceptingoptionspec6)).intValue()));
            }
            catch (Exception exception)
            {
                ;
            }
        }

        String s1 = (String)optionset.valueOf(argumentacceptingoptionspec7);
        String s2 = (String)optionset.valueOf(argumentacceptingoptionspec8);

        if (!proxy.equals(Proxy.NO_PROXY) && func_110121_a(s1) && func_110121_a(s2))
        {
            Authenticator.setDefault(new MainProxyAuthenticator(s1, s2));
        }

        int i = ((Integer)optionset.valueOf(argumentacceptingoptionspec12)).intValue();
        int j = ((Integer)optionset.valueOf(argumentacceptingoptionspec13)).intValue();
        boolean flag = optionset.has("fullscreen");
        boolean flag1 = optionset.has("demo");
        String s3 = (String)optionset.valueOf(argumentacceptingoptionspec11);
        File file1 = (File)optionset.valueOf(argumentacceptingoptionspec2);
        File file2 = optionset.has(argumentacceptingoptionspec3) ? (File)optionset.valueOf(argumentacceptingoptionspec3) : new File(file1, "assets/");
        File file3 = optionset.has(argumentacceptingoptionspec4) ? (File)optionset.valueOf(argumentacceptingoptionspec4) : new File(file1, "resourcepacks/");
        Session session = new Session((String)argumentacceptingoptionspec9.value(optionset), (String)argumentacceptingoptionspec10.value(optionset));
        Minecraft minecraft = new Minecraft(session, i, j, flag, flag1, file1, file2, file3, proxy, s3);
        String s4 = (String)optionset.valueOf(argumentacceptingoptionspec);

        if (s4 != null)
        {
            minecraft.setServer(s4, ((Integer)optionset.valueOf(argumentacceptingoptionspec1)).intValue());
        }

        Runtime.getRuntime().addShutdownHook(new MainShutdownHook());

        if (!list.isEmpty())
        {
            System.out.println("Completely ignored arguments: " + list);
        }

        Thread.currentThread().setName("Minecraft main thread");
        minecraft.func_99999_d();
    }

    private static boolean func_110121_a(String par0Str)
    {
        return par0Str != null && !par0Str.isEmpty();
    }
}
