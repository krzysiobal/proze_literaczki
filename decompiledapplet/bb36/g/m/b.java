// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.EventObject;
import java.util.Vector;

// Referenced classes of package g.m:
//            a, f, e

public final class b extends Canvas
    implements AdjustmentListener
{

    private b(e e1, Scrollbar scrollbar, Scrollbar scrollbar1)
    {
        s = new Object();
        f = e1;
        b = c.n.a(4);
        t = new Vector();
        p = -1;
        q = true;
        r = g.m.f.u();
        o = 1;
        if(scrollbar != null)
        {
            d = scrollbar;
            d.addAdjustmentListener(this);
        }
        if(scrollbar1 != null)
        {
            e = scrollbar1;
            e.addAdjustmentListener(this);
        }
        c();
        setBackground(Color.white);
    }

    public static Component[] a(e e1, int i1, Button button)
    {
        (i1 = new Panel()).setLayout(new BorderLayout(0, 3));
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        Scrollbar scrollbar = new Scrollbar();
        Scrollbar scrollbar1 = new Scrollbar(0);
        e1 = new b(e1, scrollbar, scrollbar1);
        panel.add("Center", e1);
        panel.add("North", e1.c = new a(e1));
        ((b) (e1)).c.b(false);
        e1.b(2);
        i1.add("Center", panel);
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        panel.add("North", new a(e1));
        panel.add("Center", scrollbar);
        i1.add("East", panel);
        (panel = new Panel()).setLayout(new BorderLayout(button == null ? 0 : 8, 0));
        panel.add(button == null ? "East" : "West", ((Component) (button == null ? ((Component) (new d())) : ((Component) (button)))));
        panel.add("Center", scrollbar1);
        i1.add("South", panel);
        return (new Component[] {
            i1, e1
        });
    }

    public final void a(String s1)
    {
        a(new String[0]);
    }

    public final void a(String as[])
    {
        synchronized(s)
        {
            int i1 = t.size();
            for(int j1 = 0; j1 < as.length; j1++)
            {
                if(r && t.size() % o == 0)
                    t.addElement(String.valueOf(1 + t.size() / o));
                t.addElement(as[j1]);
            }

            a(false, t.size() - i1);
        }
        c();
        repaint();
        b();
    }

    public final void adjustmentValueChanged(AdjustmentEvent adjustmentevent)
    {
label0:
        {
label1:
            {
                if(adjustmentevent.getSource() == d)
                {
                    m = d.getValue();
                    repaint();
                    return;
                }
                if(adjustmentevent.getSource() != e)
                    break label0;
                if(a.f())
                {
                    c();
                    return;
                }
                synchronized(s)
                {
                    int i1 = e.getValue();
                    p = i1 + (r ? 1 + i1 / (o - 1) : 0);
                }
                if((p / o) * l < m)
                {
                    m = (p / o) * l;
                } else
                {
                    if((p / o + 1) * l <= m + (h - 1))
                        break label1;
                    m = (p / o + 1) * l - (h - 1);
                    if(m < 0)
                        m = 0;
                }
                c();
            }
            repaint();
            b();
        }
    }

    private void a(boolean flag, int i1)
    {
        if(!flag && f.t() == -1 && p < t.size() - 1 - i1)
            return;
        p = t.size() - 1;
        m = (((t.size() + o) - 1) / o) * l - (h - 1);
        if(m < 0)
            m = 0;
    }

    public final boolean a()
    {
        return p == t.size() - 1;
    }

    public final boolean keyDown(Event event, int i1)
    {
        if(a.f())
            return true;
        if(i1 == 1007 || i1 == 1005)
        {
            event = p + 1;
            if(r && event % o == 0)
                event++;
        } else
        if(i1 == 1006 || i1 == 1004)
        {
            event = p - 1;
            if(r && event % o == 0)
                event--;
        } else
        {
            return true;
        }
        i1 = p;
        synchronized(s)
        {
            if(event >= 0 && event < t.size())
                p = event;
        }
        if(i1 != p)
        {
            if((p / o + 1) * l > (m + h) - 1)
                m = (p / o + 1) * l - (h - 1);
            if((p / o) * l < m)
                m = (p / o) * l;
            c();
            repaint();
            b();
        }
        return true;
    }

    public final boolean keyUp(Event event, int i1)
    {
        return super.keyUp(event, i1);
    }

    public final boolean mouseDown(Event event, int i1, int j1)
    {
        if(l == 0)
            return true;
        if(r && i1 <= c.b[0])
            return true;
        j1 = (j1 + m) / l;
        event = 0;
        int k1 = 0;
        do
        {
            if(event >= c.b.length)
                break;
            k1 += c.b[event];
            if(i1 <= k1)
                break;
            event++;
        } while(true);
        event = j1 * o + event;
        i1 = p;
        synchronized(s)
        {
            if(event >= 0 && event < t.size())
                p = event;
        }
        if(i1 != p)
        {
            c();
            repaint();
            b();
        }
        return true;
    }

    public final boolean mouseUp(Event event, int i1, int j1)
    {
        if(a.f())
        {
            a(true, 0);
            c();
            repaint();
            b();
        }
        return true;
    }

    public final void paint(Graphics g1)
    {
        if(c.b.length == 0)
            return;
        Dimension dimension;
        if((dimension = getSize()).width != g || dimension.height != h)
        {
            g = dimension.width;
            h = dimension.height;
            c.a(g1, g, h);
            if(l == 0)
            {
                g1.setFont(b);
                l = 2 + c.n.b(g1);
                n = c.n.a(l, g1.getFontMetrics());
                d.setUnitIncrement(l);
                d.setBlockIncrement(l * 5);
            }
            synchronized(s)
            {
                if(m > 0 && -m + (t.size() / o) * l < h)
                    m = (t.size() / o) * l - h;
                if(m < 0)
                    m = 0;
            }
            c();
            if(k < g || i == null)
            {
                if(i != null)
                    i.dispose();
                j = createImage(g, l);
                i = j.getGraphics();
                k = g;
            }
        }
        synchronized(s)
        {
            int i1 = -(m % l);
            int j1 = (m / l) * o;
            for(; i1 < h; i1 += l)
            {
                int k1 = 0;
                int l1 = 1;
                while(k1 < o) 
                {
                    String s1 = (String)(j1 >= t.size() ? null : t.elementAt(j1));
                    i.setColor(k1 != 0 ? n.e : n.g);
                    i.drawLine(l1 - 1, 0, l1 - 1, l);
                    i.setColor(j1 != p ? Color.white : n.e);
                    i.fillRect(l1, 0, c.b[k1], l);
                    if(s1 != null)
                    {
                        i.setFont(b);
                        i.setColor(j1 > p ? n.c : Color.black);
                        i.drawString(s1, l1 + 3, n);
                    }
                    l1 += c.b[k1];
                    k1++;
                    j1++;
                }
                i.setColor(n.g);
                i.drawLine(g - 1, 0, g - 1, l);
                if(i1 + l >= h)
                    i.drawLine(0, h - i1 - 1, g, h - i1 - 1);
                g1.drawImage(j, 0, i1, null);
            }

        }
    }

    private int a(int i1)
    {
        return i1 - (r ? ((i1 + o) - 1) / o : 0);
    }

    private void b()
    {
        a.a(a(p));
    }

    private void b(int i1)
    {
        i1 += r ? 1 : 0;
        if(o == i1)
            return;
        o = i1;
        String as[] = new String[i1];
        double ad[] = new double[i1];
        int ai[] = new int[i1];
        boolean aflag[] = new boolean[i1];
        for(int j1 = 0; j1 < i1; j1++)
        {
            if(r)
            {
                as[j1] = j1 != 0 ? f.c(j1 - 1) : "-";
                ad[j1] = j1 != 0 ? 0.88D / (double)(i1 - 1) : 0.12D;
            } else
            {
                as[j1] = f.c(j1);
                ad[j1] = 1.0D / (double)i1;
            }
            ai[j1] = j1 >= i1 - 1 ? -1 : 1024;
            aflag[j1] = true;
        }

        c.a(as, ad, ai, aflag, -1);
    }

    public final void b(String as[])
    {
        synchronized(s)
        {
            t.removeAllElements();
            for(int i1 = 0; i1 < as.length; i1++)
            {
                if(r && t.size() % o == 0)
                    t.addElement(String.valueOf(1 + t.size() / o));
                t.addElement(as[i1]);
            }

            if(q)
            {
                a(true, 0);
            } else
            {
                m = 0;
                p = r ? 1 : 0;
            }
        }
        c();
        repaint();
        b();
    }

    public final void update(Graphics g1)
    {
        if(g1 != null)
            paint(g1);
    }

    private void c()
    {
        d.setValues(m, h - 1, 0, (((t.size() + o) - 1) / o) * l);
        e.setValues(a(p), 1, 0, a(t.size()));
    }

    public g.m.a a;
    private Font b;
    private a c;
    private Scrollbar d;
    private Scrollbar e;
    private e f;
    private int g;
    private int h;
    private Graphics i;
    private Image j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private Object s;
    private Vector t;
}
