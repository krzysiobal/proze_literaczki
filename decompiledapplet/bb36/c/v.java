// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import java.awt.*;
import java.util.Vector;

// Referenced classes of package c:
//            m, n, o, w

public final class v
{

    public v(App app, String s1, int i1, int ai[], int j1, int k1)
    {
        p = 3;
        r = 10;
        t = new FontMetrics[p];
        v = new int[p];
        x = new String[p];
        y = new Object();
        z = new Vector();
        m = app;
        c = s1;
        i = ai[j1++];
        h = m.a(i / g);
        j = (i1 & 1) == 0 || j1 >= k1 ? 0 : ai[j1++];
        k = (i1 & 2) == 0 || j1 >= k1 ? 0 : ai[j1++];
        l = (i1 & 4) == 0 || j1 >= k1 ? 0 : ai[j1];
        d();
    }

    public final int a(v v1)
    {
        return c.compareTo(v1.c);
    }

    public final void a(Graphics g1, Color color, int i1, int j1, int k1, boolean flag, int l1, 
            boolean flag1)
    {
        int i2 = i1 + 5;
        if(n != null)
        {
            i2--;
            g1.setColor(flag ? color : e);
            g1.drawLine(i2 + 2, j1 - 8 - 1, i2 + 8, j1 - 8 - 1);
            g1.drawLine(i2 + 2, j1 - 1, i2 + 8, j1 - 1);
            g1.drawLine(i2 + 1, j1 - 8, i2 + 1, j1 - 2);
            g1.drawLine(i2 + 1 + 8, j1 - 8, i2 + 1 + 8, j1 - 2);
            g1.setColor(flag ? color : n);
            g1.fillRect(i2 + 2, j1 - 8, 7, 7);
            i2 += 16;
        }
        if(h != null && q == 0)
        {
            flag = g1.getFont();
            g1.setFont(c.n.a(4));
            q = 1 + g1.getFontMetrics().stringWidth(h);
            g1.setFont(flag);
        }
        v v1;
        flag = ((v1 = this).i & a) != 0;
        boolean flag2 = false;
        String s1 = null;
        if((l1 & 2) != 0 && n != null)
            s1 = b(4);
        if(h != null && ((l1 & 1) != 0 && !h.equals("(" + m.s + ")") || flag1))
            flag2 = true;
        FontMetrics fontmetrics = g1.getFontMetrics();
        i1 = a(fontmetrics, ((l1 & 4) == 0 || (((v1 = this).i & f) == 0) ? 1 : -1) * ((i1 + k1) - i2 - (flag ? r : 0) - (flag2 ? q : 0) - (s1 == null ? 0 : 3 + fontmetrics.stringWidth(s1))));
        g1.setColor(color);
        g1.drawString(i1, i2, j1);
        color = color = fontmetrics.stringWidth(i1);
        if(flag)
        {
            i1 = g1.getFont();
            g1.setFont(c.n.a(1));
            g1.drawString("\u2605", i2 + color + 1, j1);
            color += r;
            g1.setFont(i1);
        }
        if(flag2)
        {
            i1 = g1.getFont();
            g1.setFont(c.n.a(4));
            g1.setColor(flag1 ? Color.white : Color.lightGray);
            g1.drawString(h, i2 + color + 1, j1);
            color += q;
            g1.setFont(i1);
        }
        if(s1 != null)
        {
            i1 = g1.getColor();
            g1.setColor(Color.white);
            g1.drawString(s1, i2 + color + 3, j1);
            g1.setColor(i1);
        }
    }

    public final void a(w w1)
    {
        synchronized(y)
        {
            z.addElement(w1);
        }
    }

    public final void b(w w1)
    {
        synchronized(y)
        {
            z.removeElement(w1);
        }
    }

    private String a(FontMetrics fontmetrics, int i1)
    {
        if(s == fontmetrics && u == i1)
            return w;
        s = fontmetrics;
        u = i1;
        for(int j1 = 0; j1 < p; j1++)
            if(t[j1] == fontmetrics && v[j1] == i1)
                return w = x[j1];

        if(p >= t.length)
        {
            int k1;
            FontMetrics afontmetrics[] = new FontMetrics[k1 = p << 1];
            int ai[] = new int[k1];
            String as[] = new String[k1];
            for(int i2 = 0; i2 < p; i2++)
            {
                afontmetrics[i2] = t[i2];
                ai[i2] = v[i2];
                as[i2] = x[i2];
            }

            t = afontmetrics;
            v = ai;
            x = as;
        }
        int l1 = i1 >= 0 ? i1 : -i1;
        String s1 = c;
        if(i1 < 0)
        {
            if(o == null)
                o = c + "*";
            s1 = o;
        }
        if(fontmetrics.stringWidth(s1) < l1)
            w = s1;
        else
            w = c.substring(0, c.m.a(c, fontmetrics, l1 - (i1 >= 0 ? 0 : fontmetrics.stringWidth("*")) - fontmetrics.stringWidth("..") - 2)) + ".." + (i1 >= 0 ? "" : "*");
        t[p] = fontmetrics;
        v[p] = i1;
        x[p] = w;
        p++;
        return w;
    }

    public final boolean a()
    {
        return (i & b) != 0;
    }

    public final boolean b()
    {
        return c.equals(m.r);
    }

    public final void c()
    {
        synchronized(y)
        {
            for(; z.size() > 0; ((w)z.elementAt(0)).b(this));
        }
    }

    private void d()
    {
        if(m.d != null)
        {
            int i1 = l;
            int j1;
            for(j1 = 0; j1 + 1 < m.d.length && i1 > m.d[j1]; j1++);
            n = m.c[j1];
        }
    }

    public final int a(int i1)
    {
        switch(i1)
        {
        case 1: // '\001'
            return j;

        case 4: // '\004'
            return l;

        case 2: // '\002'
            return k;

        case 16: // '\020'
            return j != 0 ? 0 : 1;
        }
        return 0;
    }

    final String b(int i1)
    {
        switch(i1)
        {
        case 1: // '\001'
            if(j != 0)
                return "#" + String.valueOf(j);
            else
                return "";

        case 4: // '\004'
            return m.c(l);

        case 2: // '\002'
            return m.d(k);

        case 16: // '\020'
            if(j != 0)
                return "#";
            else
                return "";
        }
        return "";
    }

    public final void a(int i1, int ai[], int j1, int k1)
    {
        int l1;
        int i2;
        int j2;
        j1++;
        i = ai[1];
        l1 = j;
        i2 = k;
        j2 = l;
        this;
        if((i1 & 1) == 0 || 2 >= k1) goto _L2; else goto _L1
_L1:
        j1++;
        ai[2];
          goto _L3
_L2:
        false;
_L3:
        j;
        k = (i1 & 2) == 0 || j1 >= k1 ? 0 : ai[j1++];
        l = (i1 & 4) == 0 || j1 >= k1 ? 0 : ai[j1];
        i1 = (j == l1 ? 0 : 1) | (k == i2 ? 0 : 2) | (l == j2 ? 0 : 4);
        if(l != j2)
            d();
        synchronized(y)
        {
            for(j1 = 0; j1 < z.size(); j1++)
                ((w)z.elementAt(j1)).a(this, false, i1);

        }
        return;
    }

    private static Color e = new Color(64, 64, 64);
    public static int a = 1;
    public static int b = 2;
    private static int f = 8;
    private static int g = 16;
    public String c;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private App m;
    private Color n;
    private String o;
    private int p;
    private int q;
    private int r;
    private FontMetrics s;
    private FontMetrics t[];
    private int u;
    private int v[];
    private String w;
    private String x[];
    private Object y;
    private Vector z;
    public Frame d;

    static 
    {
        new Color(112, 112, 112);
    }
}
