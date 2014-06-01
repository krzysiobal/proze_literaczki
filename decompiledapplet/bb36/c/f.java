// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import g.h;
import java.awt.*;
import java.util.Vector;

// Referenced classes of package c:
//            o, a, n

public final class f extends o
{

    private f(App app, Scrollbar scrollbar)
    {
        super(scrollbar);
        u = new Dimension(190, 340);
        t = app;
    }

    public static Component[] a(App app)
    {
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 3));
        Scrollbar scrollbar = new Scrollbar();
        app = new f(app, scrollbar);
        Panel panel1;
        (panel1 = new Panel()).setLayout(new BorderLayout(0, 0));
        panel1.add("Center", app);
        app.b = new a(app);
        ((o) (app)).b.a(new String[] {
            ""
        }, new double[] {
            1.0D
        }, new int[] {
            -1
        }, new boolean[] {
            true
        }, 1);
        panel1.add("North", ((o) (app)).b);
        panel.add("Center", panel1);
        (panel1 = new Panel()).setLayout(new BorderLayout(0, 0));
        panel1.add("Center", scrollbar);
        panel1.add("North", new a(app));
        panel.add("East", panel1);
        return (new Component[] {
            panel, app
        });
    }

    public final Dimension minimumSize()
    {
        return u;
    }

    public final Dimension preferredSize()
    {
        return u;
    }

    public final void a(Object obj, int i)
    {
        Object aobj[];
        if((aobj = (Object[])obj)[1] == h.a || aobj[2] != null)
            i = 0;
        super.o.insertElementAt(obj, i);
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
            t.l.setVisible(false);
            t.h((String)((Object[])super.j)[0]);
        }
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
            repaint();
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
                s = (r + i) - n.a(g) - 1;
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
                boolean flag = false;
                String s1 = "";
                String s2 = null;
                if(aobj != null)
                {
                    s1 = (String)aobj[0];
                    s2 = (String)aobj[2];
                    flag = aobj == super.j;
                }
                super.l.setColor(flag ? n.e : getBackground());
                super.l.fillRect(0, 0, super.e, super.d);
                if(aobj != null)
                {
                    super.l.setFont(s2 == null ? super.n : super.m);
                    super.l.setColor(Color.black);
                    super.l.drawString(s2 == null ? s1 : s1 + s2, 12, s);
                    super.l.setColor(q);
                    super.l.drawLine(1, super.d - 1, super.e - 2, super.d - 1);
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

    private static Color q = new Color(224, 224, 224);
    private static int r = 8;
    private int s;
    private App t;
    private Dimension u;

}
