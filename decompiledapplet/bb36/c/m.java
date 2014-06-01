// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;

// Referenced classes of package c:
//            n

public final class m extends Canvas
{

    public m(String s, int i1, int j1, int k1)
    {
        e = 4;
        f = s;
        g = i1;
        h = 0;
        i = k1;
    }

    public static int a(String s, FontMetrics fontmetrics, int i1)
    {
        int j1 = 0;
        for(int k1 = s.length(); j1 < k1;)
        {
            int l1 = 1 + (j1 + k1) / 2;
            if(fontmetrics.stringWidth(s.substring(0, l1)) >= i1)
                k1 = l1 - 1;
            else
                j1 = l1;
        }

        return j1;
    }

    public final void paint(Graphics g1)
    {
        Dimension dimension = getSize();
        FontMetrics fontmetrics = g1.getFontMetrics();
        String s = f;
        int j1 = fontmetrics.stringWidth(f);
        int k1 = 0;
        int l1 = n.a(dimension.height, fontmetrics);
        if(g == 0)
            k1 = e;
        else
        if(g == 1)
            k1 = (dimension.width - j1) / 2;
        else
        if(g == 2)
            k1 = dimension.width - e - j1;
        if(j1 > dimension.width - (e << 1))
        {
            k1 = e;
            int i1 = dimension.width - (e << 1) - fontmetrics.stringWidth(b);
            if(k == fontmetrics && i1 == l)
            {
                s = m;
            } else
            {
                s = f.substring(0, a(f, fontmetrics, i1)) + b;
                m = s;
                k = fontmetrics;
                l = i1;
            }
        }
        g1.drawString(s, k1, l1);
    }

    public final Dimension preferredSize()
    {
        Object obj;
        if((obj = getGraphics()) != null)
        {
            obj = ((Graphics) (obj)).getFontMetrics();
            return new Dimension(j <= 0 ? (((FontMetrics) (obj)).stringWidth(f) + (e << 1) + c) - h : j, (n.a(((FontMetrics) (obj))) + d) - i);
        } else
        {
            return a;
        }
    }

    public final void a(int i1)
    {
        e = 0;
    }

    public final void b(int i1)
    {
        j = 90;
    }

    public final void a(String s)
    {
        f = s;
        repaint();
    }

    private static Dimension a = new Dimension(1, 1);
    private static String b = "..";
    private static int c = 10;
    private static int d = 8;
    private int e;
    private String f;
    private int g;
    private int h;
    private int i;
    private int j;
    private FontMetrics k;
    private int l;
    private String m;

}
