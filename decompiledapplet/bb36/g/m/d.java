// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.*;
import java.awt.*;

// Referenced classes of package g.m:
//            e, f

public final class d extends Panel
{

    public d(e e1, int i1, boolean flag, boolean flag1, Color acolor[], String s, Component acomponent[])
    {
        p = e1;
        e1 = i1 != 2 || !flag1 ? 0 : 1;
        a = i1 + i1 % 2;
        c = 0;
        d = new m[a];
        h = new Button[a];
        i = new Button[a];
        l = new Panel[a];
        k = new Panel[a];
        n = new CardLayout[a];
        m = new CardLayout[a];
        if(flag)
            e = new Label[a];
        if(flag1)
            f = new Label[a];
        if(s != null)
            g = new Label[a];
        if(acolor != null)
            j = new x[a];
        if(e1 != 0)
            o = new x[a];
        setLayout(new GridLayout(a / 2, 2, 4, 6));
        for(acomponent = 0; acomponent < a; acomponent++)
        {
            Panel panel;
            (panel = new Panel()).setLayout(new BorderLayout(0, a > 1 ? 4 : 1));
            if(e1 != 0)
                panel.add("North", o[acomponent] = new x(new Dimension(25, 17), 2));
            Panel panel1;
            (panel1 = new Panel()).setBackground(a.a);
            panel1.setLayout(new BorderLayout(0, 1));
            Panel panel3;
            Panel panel4;
            (panel4 = c.n.a(panel3 = new Panel(), 1, new String[] {
                "East", "West", "North"
            })).setFont(c.n.a(0));
            panel4.setForeground(Color.lightGray);
            Object obj;
            ((Container) (obj = new Panel())).setLayout(new GridLayout(1, 2, 0, 0));
            ((Container) (obj)).setLayout(new BorderLayout(0, 0));
            if(acolor != null)
                ((Container) (obj)).add("West", j[acomponent] = new x(acolor[acomponent]));
            Object obj1;
            ((Component) (obj1 = c.n.b(p.c(acomponent), 0, 2, 9))).setBackground(a.a);
            ((Component) (obj1)).setFont(c.n.a(0));
            ((Container) (obj)).add(acolor == null ? "West" : "Center", ((Component) (obj1)));
            if(s != null)
            {
                ((Component) (obj1 = c.n.b(s + "     ", acolor == null ? 0 : 2, 2, 8))).setFont(c.n.a(0));
                ((Container) (obj)).add(acolor == null ? "Center" : "East", g[acomponent] = ((Label) (obj1)));
            }
            panel4.add("Center", ((Component) (obj)));
            panel1.add("North", panel3);
            ((Container) (obj1 = new Panel())).setLayout(new BorderLayout(0, 0));
            l[acomponent] = new Panel();
            l[acomponent].setLayout(n[acomponent] = new CardLayout());
            panel4 = c.n.a(panel3 = new Panel(), 1, new String[] {
                "East", "West", "South"
            }, 0);
            d[acomponent] = new m("", 0, 0, -4);
            d[acomponent].setFont(c.n.a(5));
            d[acomponent].setBackground(Color.white);
            d[acomponent].setForeground(Color.black);
            panel4.add("Center", d[acomponent]);
            k[acomponent] = new Panel();
            k[acomponent].setLayout(m[acomponent] = new CardLayout());
            ((Component) (obj = c.n.g(""))).setBackground(Color.white);
            k[acomponent].add("0", ((Component) (obj)));
            k[acomponent].add("x", i[acomponent] = c.n.a("x", 3));
            panel4.add("East", k[acomponent]);
            l[acomponent].add("name", panel3);
            h[acomponent] = c.n.c(p.c("bl_sit"));
            l[acomponent].add("but", h[acomponent]);
            ((Container) (obj1)).add("Center", l[acomponent]);
            panel1.add("Center", ((Component) (obj1)));
            panel.add("Center", panel1);
            if(flag || flag1)
            {
                Panel panel2;
                (panel2 = new Panel()).setLayout(new GridLayout(1, 2, 3, 0));
                if(flag)
                {
                    e[acomponent] = p.a(g.m.e.b(0), 1, 0, 4);
                    Color color;
                    if((color = p.getBackground()) != null)
                        e[acomponent].setBackground(color.brighter());
                    panel2.add(e[acomponent]);
                }
                if(flag1)
                {
                    f[acomponent] = c.n.b("00:00", flag ? 1 : 0, 0, 4);
                    if(!flag && a <= 2)
                        f[acomponent].setFont(c.n.a(6));
                    panel2.add(f[acomponent]);
                } else
                {
                    panel2.add(new Canvas());
                }
                if(!flag)
                    panel2.add(new Canvas());
                panel.add("South", panel2);
            }
            if(acomponent < i1)
                add(panel);
            else
                add(new Panel());
        }

    }

    public d(e e1, int i1, boolean flag, boolean flag1, Color acolor[])
    {
        this(e1, 2, true, true, null, null, null);
    }

    public final int a()
    {
        return b;
    }

    public final boolean a(int i1)
    {
        return i1 == b && i1 != -1;
    }

    public final void b(int i1)
    {
        b = i1;
        if(o == null)
            return;
        for(int j1 = 0; j1 < a; j1++)
            o[j1].a(j1 == i1);

    }

    public final void a(int i1, boolean flag)
    {
        d[i1].setForeground(flag ? Color.black : Color.lightGray);
        d[i1].repaint();
    }

    public final void a(int i1, String s)
    {
        d[i1].a(s == null ? "--" : s);
        m[i1].show(k[i1], (c & 1 << i1) == 0 || s == null ? "0" : "x");
        n[i1].show(l[i1], "name");
    }

    public final void a(int i1, int j1)
    {
        if(e == null)
            return;
        if(i1 < 0 || i1 >= e.length)
        {
            return;
        } else
        {
            e[i1].setText(p.b(j1));
            return;
        }
    }

    public final void b(int i1, boolean flag)
    {
        d[i1].a("");
        h[i1].setEnabled(flag);
        n[i1].show(l[i1], "but");
    }

    public final void b(int i1, String s)
    {
        if(g == null)
            return;
        if(i1 < 0 || i1 >= g.length)
        {
            return;
        } else
        {
            g[i1].setText(s);
            return;
        }
    }

    public final void b(int i1, int j1)
    {
        if(f == null)
            return;
        if(i1 < 0 || i1 >= f.length)
        {
            return;
        } else
        {
            f[i1].setText(j1 >= 0 ? j1 / 60 + ":" + (j1 % 60) / 10 + j1 % 60 % 10 : "(?)");
            return;
        }
    }

    public final int a(Object obj)
    {
        for(int i1 = 0; i1 < h.length; i1++)
            if(h[i1] == obj)
                return i1;

        return -1;
    }

    public final int b(Object obj)
    {
        for(int i1 = 0; i1 < i.length; i1++)
            if(i[i1] == obj)
                return i1;

        return -1;
    }

    public final void c(int i1)
    {
        for(int j1 = 0; j1 < a; j1++)
            if((i1 & 1 << j1) != (c & 1 << j1))
                m[j1].show(k[j1], (i1 & 1 << j1) == 0 ? "0" : "x");

        c = i1;
    }

    private int b;
    private int c;
    public int a;
    private m d[];
    private Label e[];
    private Label f[];
    private Label g[];
    private Button h[];
    private Button i[];
    private x j[];
    private Panel k[];
    private Panel l[];
    private CardLayout m[];
    private CardLayout n[];
    private x o[];
    private e p;
}
