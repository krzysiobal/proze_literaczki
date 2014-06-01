// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import java.awt.*;
import java.util.Vector;

// Referenced classes of package c:
//            o, a, n

public final class c extends o
{

    private c(App app, Scrollbar scrollbar)
    {
        super(scrollbar);
        v = new Dimension(190, 340);
        u = app;
    }

    public static Component[] a(App app)
    {
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        Object obj = new Scrollbar();
        c c1 = new c(app, ((Scrollbar) (obj)));
        Panel panel1;
        (panel1 = new Panel()).setLayout(new BorderLayout(0, 0));
        panel1.add("Center", c1);
        c1.b = new a(c1);
        ((o) (c1)).b.a(new String[] {
            ""
        }, new double[] {
            1.0D
        }, new int[] {
            -1
        }, new boolean[] {
            true
        }, 1);
        panel1.add("North", ((o) (c1)).b);
        panel.add("Center", panel1);
        (panel1 = new Panel()).setLayout(new BorderLayout(0, 0));
        panel1.add("Center", ((Component) (obj)));
        panel1.add("North", new a(c1));
        panel.add("East", panel1);
        ((Container) (obj = new Panel())).setLayout(new BorderLayout(0, 2));
        panel1 = c1.w = new Panel();
        Object obj1;
        if((obj1 = app.getBackground()) != null)
            panel1.setBackground(n.a(((Color) (obj1))));
        panel1.setLayout(c1.x = new CardLayout(4, 2));
        obj1 = new Panel();
        panel1.add(((Component) (obj1)), "-1");
        ((Container) (obj1 = new Panel())).setLayout(new GridLayout(2, 1, 0, 0));
        ((Container) (obj1)).add(c1.z = n.c("0000-00-00 00:00", 0));
        ((Container) (obj1)).add(n.c("", 0));
        panel1.add(((Component) (obj1)), "0");
        ((Container) (obj1 = new Panel())).setLayout(new GridLayout(2, 1, 0, 0));
        ((Container) (obj1)).add(n.b(app.b("st_st1"), 0));
        ((Container) (obj1)).add(c1.y = n.c("-", 0));
        panel1.add(((Component) (obj1)), "1");
        ((Container) (obj)).add("North", panel1);
        panel.add("South", ((Component) (obj)));
        return (new Component[] {
            panel, c1
        });
    }

    public final Dimension minimumSize()
    {
        return v;
    }

    public final Dimension preferredSize()
    {
        return v;
    }

    public final void a(Object obj, int i)
    {
        Object aobj[] = (Object[])obj;
        for(; i > 0; i--)
        {
            Object aobj1[] = (Object[])super.o.elementAt(i - 1);
            int j;
            try
            {
                j = ((Integer)aobj1[1]).intValue() == 0 ? 0 : 1;
                int k = ((Integer)aobj[1]).intValue() == 0 ? 0 : 1;
                j = j >= k ? ((int) (j <= k ? 0 : 1)) : -1;
            }
            catch(Exception _ex)
            {
                j = 0;
            }
            if(j < 0)
                continue;
            if(j != 0)
                break;
            Object aobj2[] = aobj;
            aobj1 = aobj1;
            if((((Integer)aobj1[1]).intValue() != 0 ? ((String)aobj1[0]).compareTo((String)aobj2[0]) : -((String)aobj1[2]).compareTo((String)aobj2[2])) <= 0)
                break;
        }

        super.o.insertElementAt(obj, i);
    }

    private void d()
    {
        if(super.j != null)
        {
            Object aobj[];
            int i;
            if((i = ((Integer)(aobj = (Object[])super.j)[1]).intValue()) == 0)
            {
                z.setText((String)aobj[2]);
            } else
            {
                String s1 = aobj[3] == null ? aobj[4] == null ? "-" : (String)aobj[4] : (String)aobj[3];
                y.setText(s1);
            }
            x.show(w, i == 0 ? "0" : "1");
            return;
        } else
        {
            x.show(w, "-1");
            return;
        }
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
            String s1 = (String)((Object[])super.j)[0];
            if(i > getSize().width - s)
                u.h(s1);
            else
                u.f(s1);
        }
        return true;
    }

    public final boolean mouseExit(Event event, int i, int j)
    {
        if(super.j != null)
        {
            super.j = null;
            d();
            repaint();
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
            super.j = ((Object) (j < 0 || j >= super.o.size() ? null : ((Object) ((Object[])super.o.elementAt(j)))));
        }
        if(event != super.j)
        {
            d();
            repaint();
        }
        return true;
    }

    public final void paint(Graphics g)
    {
        Dimension dimension;
        if((dimension = getSize()).width != super.e || dimension.height != super.f)
        {
            super.e = dimension.width;
            super.f = dimension.height;
            if(super.d == 0)
            {
                g.setFont(super.m);
                int i = 2 + n.b(g);
                t = (r + i) - n.a(g) - 1;
                super.d = 2 * r + i;
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
            int j = -(super.c % super.d);
            for(int k = super.c / super.d; j < super.f; k++)
            {
                Object aobj[] = (Object[])(k >= super.o.size() ? null : super.o.elementAt(k));
                super.l.setColor(aobj == null || aobj != super.j ? getBackground() : n.e);
                super.l.fillRect(0, 0, super.e, super.d);
                if(aobj != null)
                {
                    boolean flag = ((Integer)aobj[1]).intValue() != 0;
                    int i1 = t;
                    super.l.setColor(Color.gray);
                    super.l.drawRect(8, i1 - 7 - 1, 7, 7);
                    super.l.setColor(flag ? q : aobj != super.j ? Color.white : n.e);
                    super.l.fillRect(9, i1 - 7, 6, 6);
                    super.l.drawLine(11, i1 - 7 - 1, 12, i1 - 7 - 1);
                    super.l.drawLine(11, i1 - 1, 12, i1 - 1);
                    super.l.drawLine(8, (i1 - 7 - 1) + 3, 8, i1 - 1 - 3);
                    super.l.drawLine(15, (i1 - 7 - 1) + 3, 15, i1 - 1 - 3);
                    super.l.setColor(Color.black);
                    super.l.drawLine(8, i1 - 7, 9, i1 - 7 - 1);
                    super.l.drawLine(10, i1 - 7 - 2, 13, i1 - 7 - 2);
                    super.l.drawLine(14, i1 - 7 - 1, 15, i1 - 7);
                    super.l.drawLine(16, (i1 - 7) + 1, 16, i1 - 3);
                    super.l.drawLine(15, i1 - 2, 14, i1 - 1);
                    super.l.drawLine(13, i1, 10, i1);
                    super.l.drawLine(9, i1 - 1, 8, i1 - 2);
                    super.l.drawLine(7, i1 - 3, 7, (i1 - 7) + 1);
                    super.l.setFont(flag ? super.m : super.n);
                    super.l.setColor(Color.black);
                    super.l.drawString((String)aobj[0], 21, t);
                    int l = (super.e - s) + 4;
                    i1 = s - 15;
                    int j1 = (super.d - 10) / 2 - 2;
                    super.l.setColor(aobj != super.j ? Color.lightGray : Color.white);
                    super.l.drawLine(l + 1, j1, (l + i1) - 1, j1);
                    super.l.drawLine(l, j1 + 1, l, (j1 + 10) - 1);
                    super.l.drawLine(l + i1, j1 + 1, l + i1, (j1 + 10) - 1);
                    super.l.drawLine(l + 1, j1 + 10, l + 1 + 5, j1 + 10);
                    super.l.drawLine(l + 1 + 5, j1 + 10, l + 1 + 5, j1 + 10 + 4);
                    super.l.drawLine(l + 1 + 5, j1 + 10 + 4, l + 1 + 5 + 4, j1 + 10);
                    super.l.drawLine(l + 1 + 5 + 4, j1 + 10, (l + i1) - 1, j1 + 10);
                }
                super.l.setColor(n.g);
                super.l.drawLine(0, 0, 0, super.d);
                super.l.drawLine(super.e - 1, 0, super.e - 1, super.d);
                if(j + super.d >= super.f)
                    super.l.drawLine(0, super.f - j - 1, super.e - 1, super.f - j - 1);
                g.drawImage(super.k, 0, j, null);
                j += super.d;
            }

        }
    }

    public final int a()
    {
        i = 0;
        synchronized(super.p)
        {
            for(int j = super.o.size() - 1; j >= 0; j--)
            {
                Object aobj[];
                if(((Integer)(aobj = (Object[])super.o.elementAt(j))[1]).intValue() != 0)
                    i++;
            }

        }
        return i;
    }

    private static Color q = new Color(0x20e020);
    private static int r = 2;
    private static int s = 32;
    private int t;
    private App u;
    private Dimension v;
    private Panel w;
    private CardLayout x;
    private Label y;
    private Label z;

    static 
    {
        new Color(224, 224, 224);
    }
}
