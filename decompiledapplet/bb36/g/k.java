// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.e;
import c.j;
import c.m;
import c.n;
import c.r;
import c.v;
import c.x;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Window;
import java.net.URL;
import java.net.URLEncoder;

// Referenced classes of package g:
//            App

public final class k extends j
{

    public k(App app, String s, v v1, int ai[], String as[])
    {
        super(app, as[0]);
        int i1 = 5 + (ai[4] << 1);
        int j1 = 1 + ai[4];
        j = s;
        i = v1;
        super.a.a(this);
        (s = n.a(this, 8)).setLayout(new BorderLayout(0, 1));
        v1 = ai[4] <= 0 ? 0 : 1;
        Panel panel1;
        (panel1 = new Panel()).setBackground(Color.black);
        Panel panel2;
        (panel2 = n.a(panel1, 1)).setBackground(Color.white);
        if(v1 != 0)
        {
            Panel panel3;
            (panel3 = n.a(v1 = new Panel(), 3 * b, new String[] {
                "East", "West", "North"
            })).setLayout(new BorderLayout(0, 0));
            if(as.length > 1)
            {
                Panel panel4;
                (panel4 = new Panel()).setLayout(new GridLayout(Math.max(ai[4], 2), 1, 0, 0));
                for(int l1 = 0; l1 < ai[4]; l1++)
                {
                    int j2 = (ai[5 + (l1 << 1)] >= 0 ? ai[5 + (l1 << 1)] : 0x10000 + ai[5 + (l1 << 1)]) + (ai[5 + (l1 << 1) + 1] << 16);
                    String s2 = l1 <= 0 ? super.a.c(j2) : String.valueOf(j2);
                    panel4.add(n.a(new Component[] {
                        n.b(as[l1 + 1], 1, 8, 6), new r(), n.a(s2, 1, 8, 6)
                    }));
                }

                (panel3 = n.a(panel3, panel4, b << 1)).add("South", new x(0, Color.black));
            }
            panel2.add("North", v1);
        }
        v1 = "";
        Object obj = "";
        String as1[] = {
            "-", "-", "-", ""
        };
        for(int i2 = 0; i2 < ai.length - i1; i2++)
        {
            String s1 = as[j1 + i2];
            switch(ai[i1 + i2])
            {
            case 0: // '\0'
                as1[0] = s1;
                break;

            case 2: // '\002'
                as1[1] = s1;
                break;

            case 3: // '\003'
                as1[2] = s1;
                break;

            case 4: // '\004'
                as1[3] = s1;
                break;

            case 5: // '\005'
                v1 = s1;
                break;

            case 6: // '\006'
                obj = s1;
                break;
            }
        }

        Panel panel5;
        Panel panel6;
        (panel6 = n.a(panel5 = new Panel(), 3 * b)).setLayout(new BorderLayout(0, b));
        panel6.setFont(n.a(0));
        Panel panel7;
        (panel7 = new Panel()).setLayout(new BorderLayout(b, 0));
        try
        {
            panel7.add("West", new c.k(super.a, new URL("http://" + super.a.getCodeBase().getHost() + super.a.a("photos_url", "/photos/") + (((String) (obj)).length() <= 0 ? super.a.a("photo_none", "none.jpg") : obj))));
        }
        catch(Exception _ex) { }
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        panel7.add("Center", panel);
        for(int k1 = 0; k1 < as1.length; k1++)
        {
            if(as1[k1].length() == 0)
                continue;
            ((m) (obj = new m(as1[k1], 0, 0, 8))).b(90);
            if(k1 == 0)
                ((Component) (obj)).setFont(n.a(2));
            panel = n.a(panel, ((Component) (obj)), 0);
        }

        panel6 = n.a(panel6, panel7, 0);
        e e1;
        (e1 = new e(app, null, null, 0, 2, 60, 0)).c(false);
        e1.b(false);
        e1.b(0);
        e1.a(90);
        e1.a(true);
        panel6.add("Center", e1);
        e1.a(v1);
        panel2.add("Center", panel5);
        s.add("Center", panel1);
        ((Container) (obj = new Panel())).setLayout(new BorderLayout(0, 2 * b));
        s.add("South", ((Component) (obj)));
        obj = n.a(((Panel) (obj)), new Canvas(), 1 * b);
        if(as.length > 2)
            obj = n.a(((Panel) (obj)), n.a(new Component[] {
                d = n.c(super.a.b("ui_stats") + " >")
            }), 1 * b);
        k = String.valueOf(ai[2]);
        app = ai[2] > 0 ? ((App) ("#" + String.valueOf(ai[2]))) : "-";
        obj = n.a(((Panel) (obj = n.a(((Panel) (obj)), n.a(new Component[] {
            e = n.c(super.a.b("bl_whisper"))
        }), 1 * b))), n.a(new Component[] {
            f = n.c(super.a.b("ui_misc") + " " + app)
        }), 0 * b);
        if(ai[2] <= 0)
            f.setEnabled(false);
        l = ai[1];
        obj = n.a(((Panel) (obj = n.a(((Panel) (obj)), n.a(new Component[] {
            g = n.d(super.a.b("bl_buds"))
        }, 0, 0), b))), n.a(new Component[] {
            h = n.d(super.a.b("ui_block"))
        }, 0, 0), b * 3);
        g.setState((l & v.a) != 0);
        h.setState((l & v.b) != 0);
        n.a(((Panel) (obj = n.a(((Panel) (obj)), new x(0, Color.black), b))), n.a(new Component[] {
            c = n.c(super.a.b("bl_ok"))
        }));
        pack();
        n.a(this);
        show();
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == c)
        {
            if(((l & v.a) != 0) != g.getState())
                super.a.c((g.getState() ? "/buddy" : "/unbuddy") + " " + j);
            if(((l & v.b) != 0) != h.getState())
                super.a.c((h.getState() ? "/ignore" : "/unignore") + " " + j);
            a();
            return true;
        }
        if(event.target == e)
        {
            a();
            super.a.h(j);
            return true;
        }
        if(event.target == d)
        {
            if((event = super.a.a("stat_url", null)) != null)
                n.a(super.a, event + URLEncoder.encode(j));
            a();
            return true;
        }
        if(event.target == f)
        {
            super.a.j(k);
            a();
            return true;
        } else
        {
            return super.action(event, obj);
        }
    }

    public final void a()
    {
        try
        {
            i.d = null;
        }
        catch(Exception _ex) { }
        dispose();
    }

    private static int b = 3;
    private Button c;
    private Button d;
    private Button e;
    private Button f;
    private Checkbox g;
    private Checkbox h;
    private v i;
    private String j;
    private String k;
    private int l;

}
