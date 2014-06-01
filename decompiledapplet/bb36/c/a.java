// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;
import java.util.Vector;

// Referenced classes of package c:
//            n

public final class a extends Canvas
{

    public a(Component component, int i1, boolean flag)
    {
        n = -1;
        x = true;
        e = false;
        z = -1;
        q = c.n.a(1);
        r = c.n.a(3);
        y = component;
        h = i1;
        o = flag ? -1 : 1;
        v = true;
        w = false;
        k = i1 != 0 ? 1 : 0;
        l = (i1 != 0 ? 14 : 0) + k;
        if(h == 0)
            setBackground(a);
        setForeground(f);
        a(new String[0], new double[0], new int[0], new boolean[0], 0);
    }

    public a(Component component)
    {
        this(component, 0, false);
    }

    public final boolean mouseDown(Event event, int i1, int j1)
    {
        if(!v && !w)
            return true;
        if(h == 1 && o == -1)
            i1 = i - i1 - 3;
        event = 0;
        j1 = 1;
        do
        {
            if(event >= b.length)
                break;
            if(i1 < j1 + b[event])
            {
                if(v || event == c && w)
                {
                    a(event, true);
                    repaint();
                }
                break;
            }
            j1 += b[event] + (h != 1 ? 0 : 4);
            event++;
        } while(true);
        return true;
    }

    public final boolean mouseUp(Event event, int i1, int j1)
    {
        return true;
    }

    public final void paint(Graphics g1)
    {
        Object obj;
        if(((Dimension) (obj = getSize())).width != i || ((Dimension) (obj)).height != j)
            a(g1, ((Dimension) (obj)).width, ((Dimension) (obj)).height);
        obj = getBackground();
        g1.setFont(q);
        int i1 = h != 0 ? o != 1 ? i : 0 : 1;
        for(int j1 = 0; j1 < p.length; j1++)
        {
            if(n != -1)
                g1.setFont(r);
            if(h == 0)
            {
                g1.setColor(getBackground());
                g1.drawLine(i1 - 1, 1, i1 - 1, j - 2);
                g1.setColor(j1 != n ? getBackground() : g);
                g1.fillRect(i1, 1, b[j1] - 1, j - (x ? 2 : 1));
                g1.setColor(getForeground());
                int l1 = g1.getFontMetrics().stringWidth(p[j1]);
                int k2 = i1 + (j1 != n ? 3 : (b[j1] - l1) / 2);
                g1.drawString(p[j1], k2, m);
                if(c == j1 && n == -1)
                    g1.drawString("\u2193", k2 + l1, m);
                i1 += b[j1];
                continue;
            }
            int i2 = b[j1];
            if(o == -1)
                i1 -= i2 + 3;
            else
                i1++;
            int l2;
            int i3 = (l2 = i1 - 1) + i2 + 1;
            int j3 = j - 4;
            g1.setColor(a);
            g1.drawLine(l2, j3, l2 - 1, j3);
            g1.drawLine(i3, j3, i3 + 1, j3);
            if(obj != null)
            {
                g1.setColor(((Color) (obj)));
                g1.drawLine(l2, 0, l2, 0);
                g1.drawLine(i3, 0, i3, 0);
                g1.fillRect(i3 + 1, 0, 2, j - 4);
            }
            if(obj != null || j1 == c)
            {
                g1.setColor(j1 == c ? a : ((Color) (obj)));
                g1.drawLine(l2, 1, l2, j - 5);
                g1.drawLine(i3, 1, i3, j - 5);
            }
            g1.drawLine(i1, 0, i3 - 1, 0);
            if(c != j1)
            {
                g1.setColor(getBackground());
                g1.drawLine(i1, 1, i3 - 1, 1);
            }
            g1.setColor(c == j1 ? g : a);
            g1.fillRect(i1, 1 + (c == j1 ? 0 : 1), i2, j - (c == j1 ? 4 : 5));
            g1.setColor(c == j1 ? Color.white : getForeground());
            g1.drawString(p[j1], i1 + (i2 - g1.getFontMetrics().stringWidth(p[j1])) / 2, m - (j1 != c ? 0 : 2));
            if(o == 1)
                i1 += i2 + 3;
            else
                i1--;
        }

        if(obj != null)
            g1.setColor(((Color) (obj)));
        if(h == 0)
        {
            g1.drawRect(0, 0, i - 1, j - (x ? 1 : 0));
            return;
        }
        int k1 = o != -1 ? i1 - 1 : 0;
        int j2 = o != -1 ? i : i1 - 1;
        if(obj != null)
            g1.fillRect(k1, 0, j2, j - 4);
        g1.setColor(a);
        g1.drawLine(k1, j - 4, j2, j - 4);
        g1.drawLine(0, j - 1, i, j - 1);
        g1.setColor(g);
        g1.drawLine(0, j - 3, i, j - 3);
        g1.drawLine(0, j - 2, i, j - 2);
    }

    public final Dimension preferredSize()
    {
        int i1 = 1;
        Graphics g1 = getGraphics();
        if(!e && g1 != null)
        {
            g1.setFont(q);
            i1 = c.n.b(g1) + l;
        }
        return new Dimension(z != -1 ? z : super.preferredSize().width, i1);
    }

    public final void a(int i1)
    {
        l = 0;
        n = 0;
        c = 0;
        w = true;
        v = true;
    }

    public final void a(boolean flag)
    {
        x = false;
    }

    public final void a(String as[], double ad[], int ai[], boolean aflag[], int i1)
    {
        p = as;
        t = ad;
        s = ai;
        u = aflag;
        b = new int[p.length];
        c = -1;
        if(as.length > 0)
            a(i1, false);
        i = -1;
        repaint();
    }

    public final void a(Vector vector, int i1)
    {
        i1 = new String[vector.size()];
        for(int j1 = 0; j1 < vector.size(); j1++)
            i1[j1] = (String)vector.elementAt(j1);

        int k1 = 0;
        i1 = i1;
        vector = this;
        a(i1, null, null, null, k1);
    }

    public final void b(int i1)
    {
        z = 20;
    }

    public final void a(int i1, boolean flag)
    {
        try
        {
            d = u[i1];
        }
        catch(Exception _ex)
        {
            d = false;
        }
        int j1 = c;
        c = i1;
        if(y != null && (!w || flag))
            y.update(null);
        if(flag && n != -1)
            c = j1;
    }

    public final void b(boolean flag)
    {
        v = false;
    }

    public final void update(Graphics g1)
    {
        paint(g1);
    }

    public final void a(Graphics g1, int i1, int j1)
    {
        i = i1;
        j = j1;
        g1.setFont(q);
        if(t != null)
        {
            int k1 = i1 - 1;
            j1 = b;
            i1 = this;
            int l1 = k1;
            double d1 = 0.0D;
            for(int j2 = 0; j2 < j1.length; j2++)
                if(((a) (i1)).s[j2] != -1)
                {
                    j1[j2] = (int)(((a) (i1)).t[j2] * (double)k1);
                    if(j1[j2] > ((a) (i1)).s[j2])
                        j1[j2] = ((a) (i1)).s[j2];
                    l1 -= j1[j2];
                } else
                {
                    d1 += ((a) (i1)).t[j2];
                }

            for(int k2 = 0; k2 < j1.length; k2++)
                if(((a) (i1)).s[k2] == -1)
                    j1[k2] = (int)((((a) (i1)).t[k2] / d1) * (double)l1);

        } else
        {
            Graphics g2 = g1;
            j1 = b;
            i1 = this;
            int i2 = 0;
            for(int l2 = 0; l2 < ((a) (i1)).p.length; l2++)
            {
                j1[l2] = g2.getFontMetrics().stringWidth(((a) (i1)).p[l2]);
                i2 += j1[l2];
            }

            if(((a) (i1)).p.length > 0)
            {
                int i3;
                if((i3 = (i1.getSize().width - i2 - (((a) (i1)).p.length + 5) * 3) / ((a) (i1)).p.length) > 11)
                    i3 = 11;
                if(i3 < 9)
                    i3 = 9;
                for(int j3 = 0; j3 < ((a) (i1)).p.length; j3++)
                    j1[j3] += i3;

            }
        }
        m = c.n.a(j - k, g1.getFontMetrics());
    }

    public static final Color a = new Color(16, 24, 32);
    private static Color f = new Color(170, 180, 190);
    private static Color g = new Color(96, 96, 96);
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private String p[];
    private Font q;
    private Font r;
    public int b[];
    private int s[];
    private double t[];
    private boolean u[];
    public int c;
    public boolean d;
    private boolean v;
    private boolean w;
    private boolean x;
    public boolean e;
    private Component y;
    private int z;

}
