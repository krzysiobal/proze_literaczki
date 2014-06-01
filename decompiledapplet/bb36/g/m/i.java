// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.*;
import g.App;
import java.awt.*;
import java.util.Vector;

// Referenced classes of package g.m:
//            AppMulti, h

public final class i extends o
{

    private i(AppMulti appmulti, Scrollbar scrollbar, boolean flag)
    {
        super(scrollbar);
        r = "\u2013";
        s = 8;
        t = 50;
        y = appmulti;
        x = flag ? 32000 : 140;
        z = appmulti.b("tl_join");
    }

    public static Component[] a(AppMulti appmulti, boolean flag)
    {
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 3));
        Scrollbar scrollbar = new Scrollbar();
        appmulti = new i(appmulti, scrollbar, flag);
        (flag = new Panel()).setLayout(new BorderLayout(0, 0));
        flag.add("Center", appmulti);
        appmulti.b = new a(appmulti);
        ((o) (appmulti)).b.a(new String[] {
            "   ", ""
        }, new double[] {
            0.40000000000000002D, 0.59999999999999998D
        }, new int[] {
            70, -1
        }, new boolean[] {
            true, false
        }, 1);
        flag.add("North", ((o) (appmulti)).b);
        panel.add("Center", flag);
        (flag = new Panel()).setLayout(new BorderLayout(0, 0));
        flag.add("Center", scrollbar);
        flag.add("North", new a(appmulti));
        panel.add("East", flag);
        return (new Component[] {
            panel, appmulti
        });
    }

    public final void a(int j)
    {
        super.b.a(0, false);
    }

    public final void a(Object obj, int j)
    {
        obj = (h)obj;
        int k = y.v;
        do
        {
            if(j <= 0)
                break;
            Object obj1 = (h)super.o.elementAt(j - 1);
            int k1 = k;
            int i1 = super.h;
            h h1 = ((h) (obj1));
            obj1 = obj;
            Object obj2;
            int l1 = ((h) (obj2 = h1)).b[1];
            int i2 = ((h) (obj2 = obj1)).b[1];
            l1 = l1 >= i2 ? ((int) (l1 <= i2 ? 0 : 1)) : -1;
            int l;
            if(i1 != 0)
            {
                int j1 = h1.b();
                int j2 = ((h) (obj1)).b();
                int k2 = h1.c();
                int l2 = ((h) (obj1)).c();
                l1 = -l1;
                l = j2 <= 0 || l2 != 0 ? j1 <= 0 || k2 != 0 ? !((h) (obj1)).c(k1) || j2 <= 0 ? !h1.c(k1) || j1 <= 0 ? ((h) (obj1)).d() ? h1.d() ? l1 : 1 : h1.d() ? -1 : l1 : 1 : !h1.c(k1) || j1 <= 0 ? -1 : l1 : -1 : j1 <= 0 || k2 != 0 ? 1 : l1;
            } else
            {
                l = l1;
            }
            if(super.i)
                l = -l;
            if(l >= 0)
                break;
            j--;
        } while(true);
        super.o.insertElementAt(obj, j);
    }

    public final boolean mouseDown(Event event, int j, int k)
    {
        if(super.d == 0)
            return true;
        k = (super.c + k) / super.d;
        event = ((Event) (super.j));
        synchronized(super.p)
        {
            super.j = k < 0 || k >= super.o.size() ? null : ((Object) ((h)super.o.elementAt(k)));
        }
        if(event != super.j)
            repaint();
        if(super.j != null)
            y.e(((h) (event = (h)super.j)).b[1]);
        return true;
    }

    public final boolean mouseExit(Event event, int j, int k)
    {
        if(super.j != null)
        {
            super.j = null;
            repaint();
        }
        return true;
    }

    public final boolean mouseMove(Event event, int j, int k)
    {
        if(super.d == 0)
            return true;
        k = (super.c + k) / super.d;
        event = ((Event) (super.j));
        synchronized(super.p)
        {
            super.j = k < 0 || k >= super.o.size() ? null : ((Object) ((h)super.o.elementAt(k)));
        }
        if(event != super.j)
            repaint();
        return true;
    }

    public final void paint(Graphics g)
    {
        if(super.b.b.length == 0)
            return;
        Dimension dimension = getSize();
        int k = y.v;
        if(dimension.width != super.e || dimension.height != super.f)
        {
            super.e = dimension.width;
            super.f = dimension.height;
            super.b.a(g, super.e, super.f);
            if(super.d == 0)
            {
                g.setFont(super.n);
                int j = 2 + n.b(g);
                u = (s + j) - n.a(g) - 1;
                super.d = 2 * s + j;
                super.d = super.d + super.d % 3;
                v = g.getFontMetrics().stringWidth(z);
                super.a.setUnitIncrement(super.d);
                super.a.setBlockIncrement(super.d * 5);
            }
            synchronized(super.p)
            {
                if(super.c > 0 && -super.c + super.o.size() * super.d < super.f)
                    super.c = super.o.size() * super.d - (super.f - 1);
                if(super.c < 0)
                    super.c = 0;
            }
            c();
            if(super.g < super.e || super.l == null)
            {
                if(super.l != null)
                    super.l.dispose();
                super.k = createImage(super.e, super.d);
                super.l = super.k.getGraphics();
                super.g = super.e;
            }
        }
        synchronized(super.p)
        {
            if(w == 0 && super.o.size() > 0)
            {
                super.l.setFont(super.n);
                FontMetrics fontmetrics = super.l.getFontMetrics();
                for(int i1 = super.o.size() - 1; i1 >= 0; i1--)
                {
                    int k1;
                    h h2;
                    if((k1 = fontmetrics.stringWidth((h2 = (h)super.o.elementAt(i1)).a[0])) > w)
                        w = k1;
                }

            }
            int l = w;
            int j1 = -(super.c % super.d);
            for(int l1 = super.c / super.d; j1 < super.f; l1++)
            {
                h h1;
                boolean flag;
                Color color = (flag = (h1 = (h)(l1 >= super.o.size() ? null : super.o.elementAt(l1))) != null && h1 == super.j) ? n.e : getBackground();
                super.l.setColor(h1 != null && h1 != super.j ? getBackground() : color);
                super.l.fillRect(0, 0, super.e, super.d);
                if(h1 != null)
                {
                    super.l.setFont(super.n);
                    h h3;
                    int i2 = (h3 = h1).b.length - 3;
                    int j2 = super.b.b[0] + w + t;
                    int l2 = i2 != 1 ? Math.min((super.b.b[1] - w - t) / i2, x) : super.b.b[1] - w - t;
                    for(int i3 = 0; i3 < i2; i3++)
                    {
                        int k2 = j2;
                        j2 += l2;
                        String s2 = h1.a(i3);
                        v v1;
                        if((v1 = y.k(s2)) != null)
                        {
                            java.awt.Font _tmp = super.n;
                            v1.a(super.l, v1.a() ? n.c : Color.black, k2 + 5, u, j2 - k2 - 5, v1.a(), flag ? 2 : 0, flag);
                            continue;
                        }
                        if(!s2.equals(""))
                        {
                            super.l.setColor(Color.black);
                            super.l.drawString(s2, k2 + 5 + 5, u);
                            continue;
                        }
                        if(h1.b(i3) == 0 && h1.e() && k >= h1.a())
                        {
                            super.l.setColor(Color.blue);
                            super.l.drawString(z, k2 + 9, u);
                            super.l.drawLine(k2 + 9, u + 1, k2 + 9 + v, u + 1);
                        } else
                        {
                            super.l.setColor(Color.lightGray);
                            super.l.drawString("-", k2 + 5 + 5, u);
                        }
                    }

                    super.l.setColor(Color.black);
                    super.l.setFont(super.n);
                    super.l.drawString(h1.d() ? r : h1.d, 20, u);
                    j2 = super.b.b[0];
                    String s1 = ((h) (i2 = h1)).a[0];
                    super.l.drawString(s1, j2 + 6, u);
                    int j3;
                    if((j3 = super.l.getFontMetrics().stringWidth(s1)) > l)
                        l = j3;
                }
                if(l > w)
                {
                    w = l;
                    repaint();
                }
                if(h1 != null)
                {
                    super.l.setColor(q);
                    super.l.drawLine(1, super.d - 1, super.e - 2, super.d - 1);
                }
                super.l.setColor(n.g);
                super.l.drawLine(0, 0, 0, super.d);
                super.l.drawLine(super.e - 1, 0, super.e - 1, super.d);
                if(j1 + super.d >= super.f)
                    super.l.drawLine(0, super.f - j1 - 1, super.e - 1, super.f - j1 - 1);
                g.drawImage(super.k, 0, j1, null);
                j1 += super.d;
            }

        }
    }

    private static Color q = new Color(224, 224, 224);
    private String r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private AppMulti y;
    private String z;

}
