// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;
import java.util.Vector;

// Referenced classes of package c:
//            o, a, n, p, 
//            v

public final class w extends o
{

    private w(p p1, Scrollbar scrollbar, int i, int j, boolean flag, boolean flag1)
    {
        super(scrollbar);
        t = 4;
        u = Color.gray;
        v = "x";
        w = p1;
        y = flag;
        z = flag1;
        x = new Dimension(i, j);
        c();
    }

    public static Component[] a(p p1, Panel panel, int i, int j, boolean flag, boolean flag1)
    {
        return a(p1, panel, i, j, flag, flag1, false);
    }

    public static Component[] a(p p1, Panel panel, int i, int j, boolean flag, boolean flag1, boolean flag2)
    {
        Panel panel1;
        (panel1 = new Panel()).setLayout(new BorderLayout(0, 5));
        Scrollbar scrollbar = new Scrollbar();
        p1 = new w(p1, scrollbar, i, j, flag, flag1);
        (i = new Panel()).setLayout(new BorderLayout(0, 0));
        i.add("Center", p1);
        i.add("North", p1.b = new a(p1));
        panel1.add("Center", i);
        if(flag2)
            ((o) (p1)).b.e = true;
        (i = new Panel()).setLayout(new BorderLayout(0, 0));
        if(!flag2)
            i.add("North", new a(p1));
        i.add("Center", scrollbar);
        panel1.add("East", i);
        if(panel != null)
            panel1.add("South", panel);
        return (new Component[] {
            panel1, p1
        });
    }

    public final void a()
    {
        synchronized(super.p)
        {
            for(int i = super.o.size() - 1; i >= 0; i--)
            {
                v v1;
                (v1 = (v)super.o.elementAt(0)).b(this);
                super.o.removeElementAt(0);
            }

            if(super.j != null)
                super.j = null;
            super.c = 0;
        }
        c();
        repaint();
    }

    public final void a(Object obj, boolean flag, int i)
    {
        flag = false;
        int j;
        if((j = super.h) >= 0 && q != null && ((i & 4) != 0 && q[j] == 4 || (i & 2) != 0 && q[j] == 2 || (i & 1) != 0 && (q[j] == 1 || q[j] == 16)))
            flag = true;
        super.a(obj, flag);
    }

    public final void c(Object obj)
    {
        ((v)obj).b(this);
    }

    public final void d(Object obj)
    {
        ((v)obj).a(this);
    }

    public final void a(Object obj, int i)
    {
        obj = (v)obj;
        do
        {
            if(i <= 0)
                break;
            v v1 = (v)super.o.elementAt(i - 1);
            int j;
            if(super.h == 0)
            {
                j = v1.c.compareTo(((v) (obj)).c);
            } else
            {
                j = v1.a(q[super.h]);
                int k = ((v) (obj)).a(q[super.h]);
                j = j >= k ? ((int) (j <= k ? 0 : 1)) : -1;
            }
            if(super.i)
                j = -j;
            if(j >= 0 && (j != 0 || v1.a(((v) (obj))) <= 0))
                break;
            i--;
        } while(true);
        super.o.insertElementAt(obj, i);
    }

    public final Dimension minimumSize()
    {
        return x;
    }

    public final boolean mouseDown(Event event, int i, int j)
    {
        if(super.d == 0)
            return true;
        j = (super.c + j) / super.d;
        event = ((Event) (super.j));
        synchronized(super.p)
        {
            super.j = j < 0 || j >= super.o.size() ? null : super.o.elementAt(j);
        }
        if(event != super.j)
            repaint();
        if(super.j != null)
        {
            int k = 0;
            event = 0;
            j = 1;
            do
            {
                if(s == 0 || event >= super.b.b.length)
                    break;
                if(i <= j + super.b.b[event])
                {
                    k = event;
                    break;
                }
                j += super.b.b[event];
                event++;
            } while(true);
            w.a((v)super.j, k);
        }
        return true;
    }

    public final boolean mouseMove(Event event, int i, int j)
    {
        if(super.d == 0)
            return true;
        j = (super.c + j) / super.d;
        event = ((Event) (super.j));
        synchronized(super.p)
        {
            super.j = j < 0 || j >= super.o.size() ? null : super.o.elementAt(j);
        }
        if(event != super.j)
            repaint();
        return true;
    }

    public final boolean mouseExit(Event event, int i, int j)
    {
        if(super.j != null)
        {
            super.j = null;
            repaint();
        }
        return true;
    }

    public final void paint(Graphics g)
    {
        if(super.b.b.length == 0)
            return;
        Dimension dimension;
        if((dimension = getSize()).width != super.e || dimension.height != super.f)
        {
            if(dimension.width <= 0 || dimension.height <= 0)
                return;
            super.e = dimension.width;
            super.f = dimension.height;
            super.b.a(g, super.e, super.f);
            if(super.d == 0)
            {
                g.setFont(super.n);
                super.d = 4 + n.b(g);
                r = n.a(super.d, g.getFontMetrics());
                super.a.setUnitIncrement(super.d);
                super.a.setBlockIncrement(super.d * 5);
            }
            synchronized(super.p)
            {
                if(super.c > 0 && -super.c + super.o.size() * super.d < super.f)
                    super.c = super.o.size() * super.d - super.f;
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
            int i = -(super.c % super.d);
            for(int j = super.c / super.d; i < super.f; j++)
            {
                v v1;
                Color color = (v1 = (v)(j >= super.o.size() ? null : super.o.elementAt(j))) == null || v1 != super.j ? getBackground() : n.e;
                Color color1 = n.b;
                if(v1 != null)
                    if(v1.a())
                        color1 = n.c;
                    else
                    if(v1.b())
                        color1 = n.d;
                int k = 0;
                int l = 1;
                for(; k < super.b.b.length; k++)
                {
                    super.l.setFont(super.n);
                    int i1 = super.b.b[k];
                    if(k == 0)
                    {
                        super.l.setColor(k != 0 ? n.f : n.g);
                        super.l.drawLine(l - 1, 0, l - 1, super.d);
                    }
                    super.l.setColor(color);
                    super.l.fillRect(l, 0, i1, super.d);
                    if(v1 != null)
                        if(k == 0)
                        {
                            java.awt.Font _tmp = super.n;
                            v1.a(super.l, color1, l, r, i1 - 1, v1.a(), (z ? 1 : 0) | (y ? 4 : 0), color == n.e);
                        } else
                        if(i1 > 0)
                            if(s == 0 || q[k] != t)
                            {
                                super.l.setColor(color1);
                                super.l.drawString(v1.b(q[k]), l + 4, r);
                            } else
                            {
                                super.l.setColor(u);
                                super.l.fillRect(l + 3, 2, i1 - 6 - 1, super.d - 4);
                                super.l.setColor(Color.white);
                                super.l.setFont(super.m);
                                super.l.drawString(v, (l + i1 / 2) - super.l.getFontMetrics().stringWidth(v) / 2, r);
                            }
                    l += i1;
                    if(v1 != null)
                    {
                        super.l.setColor(color);
                        super.l.drawLine(l - 2, 0, l - 2, super.d);
                    }
                }

                super.l.setColor(n.g);
                super.l.drawLine(super.e - 1, 0, super.e - 1, super.d);
                if(i + super.d >= super.f)
                    super.l.drawLine(0, super.f - i - 1, super.e, super.f - i - 1);
                g.drawImage(super.k, 0, i, null);
                i += super.d;
            }

        }
    }

    public final Dimension preferredSize()
    {
        return x;
    }

    public final void a(String as[], int ai[], double ad[], int ai1[], boolean aflag[], int i)
    {
        q = ai;
        if(super.b != null)
            super.b.a(as, ad, ai1, aflag, i);
        super.e = -1;
        repaint();
    }

    public final void a(int i, Color color, String s1, int j)
    {
        if(s == i)
        {
            return;
        } else
        {
            s = i;
            u = color;
            v = s1;
            t = j;
            repaint();
            return;
        }
    }

    public final void a(int i)
    {
        if(s == i)
        {
            return;
        } else
        {
            s = i;
            repaint();
            return;
        }
    }

    public final int d()
    {
        return s;
    }

    public final void update(Graphics g)
    {
        if(g != null)
        {
            paint(g);
            return;
        }
        if(super.b != null)
        {
            a(super.b.c, super.b.d);
            repaint();
        }
    }

    private int q[];
    private int r;
    private int s;
    private int t;
    private Color u;
    private String v;
    private p w;
    private Dimension x;
    private boolean y;
    private boolean z;
}
