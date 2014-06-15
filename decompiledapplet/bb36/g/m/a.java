// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.b;
import c.n;
import java.awt.*;

// Referenced classes of package g.m:
//            b, e

public class a extends b
{

    public void a(boolean flag)
    {
        i = flag;
    }

    public int c()
    {
        return 120;
    }

    public static int d()
    {
        return 0;
    }

    public void a(int ai[], String as[])
    {
    }

    public static void e()
    {
    }

    public final boolean f()
    {
        return i;
    }

    public a(e e1, g.m.b b1)
    {
        h = e1;
        g = b1;
        if(b1 != null)
            b1.a = this;
        m = c.n.a(5);
        n = c.n.a(1);
        e1 = e1.getBackground();
        setBackground(((Color) (e1 == null ? Color.white : ((Color) (e1)))));
    }

    public static int b(boolean flag)
    {
        return !flag ? 270 : 300;
    }

    public void b(int ai[], String as[])
    {
    }

    public final void a(Graphics g1)
    {
        String as[];
        if((as = o) == null || h.c())
            return;
        Dimension dimension = getSize();
        FontMetrics fontmetrics = null;
        int i1 = 0;
        int j1 = 0;
        do
        {
            if(j1 >= 2)
                break;
            g1.setFont(j1 != 0 ? n : m);
            fontmetrics = g1.getFontMetrics();
            i1 = 0;
            for(int l1 = 0; l1 < as.length; l1++)
            {
                int j2;
                if((j2 = fontmetrics.stringWidth(as[l1])) > i1)
                    i1 = j2;
            }

            if(i1 < (dimension.width * 90) / 100)
                break;
            j1++;
        } while(true);
        j1 = i1 + 2 * j;
        int i2 = c.n.b(g1);
        int k2 = as.length * i2 + (as.length - 1) * l + 2 * k;
        g1.setColor(Color.white);
        g1.drawRect((dimension.width - j1) / 2 - 1, (dimension.height - k2) / 2 - 1, j1 + 2, k2 + 2);
        g1.drawRect((dimension.width - j1) / 2 - 2, (dimension.height - k2) / 2 - 2, j1 + 4, k2 + 4);
        g1.setColor(Color.red);
        g1.fillRect((dimension.width - j1) / 2, (dimension.height - k2) / 2, j1 + 1, k2 + 1);
        g1.setColor(Color.white);
        i1 = (dimension.height - k2) / 2 + k + c.n.a(i2, fontmetrics);
        for(int k1 = 0; k1 < as.length; k1++)
        {
            g1.drawString(as[k1], (dimension.width - fontmetrics.stringWidth(as[k1])) / 2, i1);
            i1 += i2 + l;
        }

    }

    public void paint(Graphics g1)
    {
        if(g1 == null)
        {
            return;
        } else
        {
            super.paint(g1);
            a(g1);
            return;
        }
    }

    public Dimension preferredSize()
    {
        Dimension dimension = g();
        e _tmp = h;
        g.m.e.l();
        if(c.n.b())
        {
            int i1 = c();
            dimension.width = (dimension.width * i1) / 100;
            dimension.height = (dimension.height * i1) / 100;
        } else
        if(c.n.c())
        {
            dimension.width = (dimension.width * 3) / 4;
            dimension.height = (dimension.height * 3) / 4;
        }
        if(p > 0)
        {
            int j1 = p;
            int k1;
            if((k1 = (int)(((double)p * (double)dimension.height) / (double)dimension.width)) > q)
            {
                j1 = (int)(((double)q * (double)dimension.width) / (double)dimension.height);
                k1 = q;
            }
            dimension.width = j1;
            dimension.height = k1;
        }
        return dimension;
    }

    public void a(int i1)
    {
    }

    public final void a(int i1, int j1)
    {
        p = i1;
        q = j1;
    }

    public final void a(String as[])
    {
        o = as;
    }

    public Dimension g()
    {
        return new Dimension(500, 500);
    }

    public void h()
    {
    }

    public static void i()
    {
    }

    private static int j = 14;
    private static int k = 10;
    private static int l = 3;
    public static int e = 92;
    public static int f = 93;
    private Font m;
    private Font n;
    public g.m.b g;
    public e h;
    public boolean i;
    private String o[];
    private int p;
    private int q;

}
