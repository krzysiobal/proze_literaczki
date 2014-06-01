// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.net.URL;
import java.util.StringTokenizer;

// Referenced classes of package c:
//            d, l

public final class n
{

    public static void a()
    {
        String s = "SansSerif";
        (h = new Font[7])[0] = new Font(s, 0, 11);
        h[1] = new Font(s, 0, 12);
        h[2] = new Font(s, 1, 11);
        h[3] = new Font(s, 1, 13);
        h[4] = new Font("Monospaced", 0, 12);
        h[5] = new Font(s, 1, 15);
        h[6] = new Font(s, 0, 14);
    }

    public static String[] a(String s)
    {
        String as[] = new String[(s = new StringTokenizer(s)).countTokens()];
        for(int i = 0; s.hasMoreTokens() && i < as.length;)
            as[i++] = s.nextToken();

        return as;
    }

    public static Panel a(Container container, int i)
    {
        String as[] = {
            "North", "South", "East", "West"
        };
        i = i;
        container = container;
        return a(container, i, as, i);
    }

    public static Panel a(Container container, int i, String as[])
    {
        return a(container, i, as, i);
    }

    public static Panel a(Container container, int i, String as[], int j)
    {
        container.setLayout(new BorderLayout(i, i));
        for(i = 0; i < as.length; i++)
        {
            Panel panel;
            (panel = new Panel()).setLayout(null);
            container.add(as[i], panel);
        }

        (i = new Panel()).setLayout(new BorderLayout(j, j));
        container.add("Center", i);
        return i;
    }

    public static Button a(String s, int i)
    {
        (s = new d(s)).setBackground(Color.lightGray);
        s.setForeground(Color.black);
        if(h != null)
            s.setFont(h[i]);
        return s;
    }

    public static Button b(String s)
    {
        return a(s, 1);
    }

    public static Button c(String s)
    {
        if(s.length() < 3)
            s = "  " + s + "  ";
        else
        if(s.length() == 3)
            s = " " + s + " ";
        return a(s = s, 1);
    }

    public static Checkbox d(String s)
    {
        s = new Checkbox(s);
        if(h != null)
            s.setFont(h[1]);
        return s;
    }

    public static Choice a(String as[])
    {
        Choice choice = new Choice();
        if(as == null)
            return choice;
        for(int i = 0; i < as.length; i++)
            choice.addItem(as[i]);

        return choice;
    }

    public static Color e(String s)
    {
        if(s.startsWith("#"))
            s = s.substring(1);
        return new Color(Integer.parseInt(s, 16));
        JVM INSTR pop ;
        return null;
    }

    public static Image a(long al[], byte abyte0[])
    {
        byte abyte1[];
        abyte1 = new byte[(al.length << 3) + abyte0.length];
        int i = 0;
        for(int j = 0; j < al.length; j++)
        {
            long l1 = al[j];
            for(int i1 = 56; i1 >= 0; i1 -= 8)
                abyte1[i++] = (byte)(int)(l1 >> i1 & 255L);

        }

        for(int k = 0; k < abyte0.length; k++)
            abyte1[i++] = abyte0[k];

        return Toolkit.getDefaultToolkit().createImage(abyte1);
        JVM INSTR pop ;
        return null;
    }

    public static Panel a(Component acomponent[], int i, int j)
    {
        Panel panel;
        (panel = new Panel()).setLayout(new FlowLayout(i, j, 0));
        for(i = 0; i < acomponent.length; i++)
            panel.add(acomponent[i]);

        return panel;
    }

    public static Panel a(Component acomponent[], int i)
    {
        return a(acomponent, 0, 0);
    }

    public static Panel a(Component acomponent[])
    {
        return a(acomponent, 0, 0);
    }

    public static int a(int i, FontMetrics fontmetrics)
    {
        return i - (((i + 1) - a(fontmetrics)) / 2 + fontmetrics.getMaxDescent());
    }

    public static int a(Graphics g1)
    {
        return (g1 = g1.getFontMetrics()).getDescent();
    }

    public static int a(FontMetrics fontmetrics)
    {
        int i;
        int j;
        i = fontmetrics.getFont().getSize();
        j = fontmetrics.getAscent();
        fontmetrics.getLeading();
        j;
        i + 2;
        JVM INSTR pop2 ;
        j;
        JVM INSTR iadd ;
        fontmetrics.getDescent();
        JVM INSTR iadd ;
        return;
    }

    public static int b(Graphics g1)
    {
        return a(g1.getFontMetrics());
    }

    public static String a(String s, String s1)
    {
        int i;
        if((i = s.indexOf("%s")) != -1)
            s = s.substring(0, i) + s1 + s.substring(i + 2);
        return s;
    }

    public static Panel a(Panel panel, Component component, int i)
    {
        Panel panel1;
        (panel1 = new Panel()).setLayout(new BorderLayout(0, i));
        panel.add("Center", panel1);
        panel.add("North", component);
        return panel1;
    }

    public static Panel a(Panel panel, Component component)
    {
        return a(panel, component, 2);
    }

    public static Label a(String s, int i, int j, int k)
    {
        s = new l(s, 1, j, k);
        if(h != null)
            s.setFont(h[3]);
        return s;
    }

    public static Label b(String s, int i)
    {
        s = new l(s, i);
        if(h != null)
            s.setFont(h[3]);
        return s;
    }

    public static Label f(String s)
    {
        return b(s, 1);
    }

    public static Label b(String s, int i, int j, int k)
    {
        s = new l(s, i, j, k);
        if(h != null)
            s.setFont(h[1]);
        return s;
    }

    public static Label c(String s, int i)
    {
        s = new l(s, i);
        if(h != null)
            s.setFont(h[1]);
        return s;
    }

    public static Label g(String s)
    {
        return c(s, 1);
    }

    public static void a(Applet applet, String s)
    {
        try
        {
            applet.getAppletContext().showDocument(new URL(applet.getDocumentBase(), s), "_blank");
            return;
        }
        catch(Throwable _ex)
        {
            return;
        }
    }

    public static String a(String s, String s1, String s2)
    {
        int i;
        while((i = s.indexOf(s1)) != -1) 
            s = s.substring(0, i) + s2 + s.substring(i + s1.length());
        return s;
    }

    public static Color a(Color color)
    {
        return new Color((color.getRed() * 85) / 100, (color.getGreen() * 85) / 100, (color.getBlue() * 85) / 100);
    }

    public static boolean b()
    {
        Dimension dimension;
        if((dimension = Toolkit.getDefaultToolkit().getScreenSize()) != null)
            return dimension.width > 800 && dimension.height > 600;
        else
            return false;
    }

    public static boolean c()
    {
        Dimension dimension;
        if((dimension = Toolkit.getDefaultToolkit().getScreenSize()) != null)
            return dimension.width < 760;
        else
            return false;
    }

    public static Font a(int i)
    {
        return h[i];
    }

    public static void a(Window window)
    {
        Dimension dimension = window.getSize();
        Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation((dimension1.width - dimension.width) / 2, (dimension1.height - dimension.height) / 2);
    }

    public static void a(Window window, Window window1)
    {
        if(!window1.isVisible())
        {
            a(window);
            return;
        }
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        if(((Rectangle) (window1 = window1.getBounds())).x < dimension.width && ((Rectangle) (window1)).y < dimension.height)
        {
            Dimension dimension1 = window.getSize();
            window.setLocation(((Rectangle) (window1)).x + (((Rectangle) (window1)).width - dimension1.width) / 2, ((Rectangle) (window1)).y + (((Rectangle) (window1)).height - dimension1.height) / 2);
            return;
        } else
        {
            window.setLocation(0, 0);
            return;
        }
    }

    public static Dimension a = new Dimension(54, 54);
    public static final Color b;
    public static final Color c;
    public static final Color d = new Color(16, 32, 176);
    public static final Color e = new Color(208, 214, 224);
    public static final Color f = new Color(232, 232, 232);
    public static final Color g = new Color(128, 128, 128);
    private static Font h[];

    static 
    {
        b = Color.black;
        c = Color.lightGray;
    }
}
