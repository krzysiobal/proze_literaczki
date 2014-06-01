// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.a;
import c.h;
import c.j;
import c.m;
import c.n;
import c.o;
import c.p;
import c.q;
import c.r;
import c.t;
import c.u;
import c.v;
import c.w;
import c.x;
import g.App;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.util.EventObject;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package g.m:
//            f, AppMulti, a, b, 
//            c, d, g, h

public abstract class e extends f
    implements p, u, ActionListener, ComponentListener, FocusListener
{

    public e(AppMulti appmulti, int ai[], String as[], boolean aflag[])
    {
        super(appmulti, "");
        B = new Vector();
        Z = false;
        ad = new Hashtable();
        super.h = appmulti;
        super.q = (ai[2] / 16) % 3;
        super.i = new g.m.h(super.h, ai, 0, ai.length, as, 0, as.length);
        Object obj;
        super.o = ((g.m.h) (obj = super.i)).b[1];
        setTitle(n.a(appmulti.b("l_tab"), String.valueOf(super.o)));
        ab = getTitle();
        if(aflag == null)
            aflag = (new boolean[] {
                true, true, true
            });
        appmulti.a(this);
        (ai = n.a(this, 8)).addComponentListener(this);
        (as = new Panel()).setLayout(new BorderLayout(8, 4));
        ai.add("Center", as);
        x = new q();
        x.setLayout(new BorderLayout());
        (ai = new Panel()).setLayout(new BorderLayout(0, 4));
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        ((Container) (obj = new Panel())).setLayout(new BorderLayout(4, 0));
        ((Component) (obj)).setBackground(a.a);
        ((Component) (obj)).setForeground(Color.white);
        ((x) (obj = new x(0, new Dimension(2, 2), 0))).a(a.a);
        ((x) (obj)).a(1, 2);
        ai.add("North", ((Component) (obj)));
        T = new m(n.a(c("l_tab"), ((g.m.h) (obj = super.i)).c) + "   " + ((g.m.h) (obj = super.i)).a[0], ((App) (super.h)).h ? 2 : 0, 0, 0);
        T.a(0);
        T.setFont(n.a(3));
        T.setForeground(Color.black);
        appmulti.a(T);
        panel.add("North", T);
        (appmulti = new x(0, new Dimension(g.m.a.b(n.b()), 12), 2)).a(Color.black);
        panel.add("Center", appmulti);
        ai.add("Center", panel);
        x.add("North", ai);
        (appmulti = new Panel()).setLayout(new BorderLayout(0, 4));
        (appmulti = new Panel()).setLayout(new BorderLayout(0, n.c() ? 5 : 20));
        e = g();
        Object obj1 = appmulti;
        obj = this;
        ((Container) (obj1)).add("North", ((e) (obj)).e);
        (obj = this).d = new Panel();
        ((e) (obj)).d.setLayout(obj.c = new CardLayout());
        obj1 = new Panel();
        ((e) (obj)).d.add("0", ((Component) (obj1)));
        ((e) (obj)).f();
        appmulti.add("Center", d = ((e) (obj)).d);
        (ai = new Panel()).setLayout(new BorderLayout(0, 0));
        (panel = new Panel()).setLayout(new FlowLayout(1, 0, 0));
        if(C == null)
        {
            panel.add(C = n.c(c("bl_start")));
            C.setEnabled(false);
        }
        panel.add(new r());
        panel.add(M = n.c(c("bl_invite")));
        K = new PopupMenu();
        PopupMenu popupmenu = K;
        boolean aflag1[] = aflag;
        obj = this;
        try
        {
            if(aflag1[0])
            {
                obj.G = new MenuItem(((f) (obj)).c("bl_resign"));
                ((e) (obj)).G.addActionListener(((ActionListener) (obj)));
                popupmenu.add(((e) (obj)).G);
            }
            if(aflag1[1])
            {
                obj.H = new MenuItem(((f) (obj)).c("bl_draw"));
                ((e) (obj)).H.addActionListener(((ActionListener) (obj)));
                popupmenu.add(((e) (obj)).H);
            }
            if(aflag1[2])
            {
                obj.I = new MenuItem(((f) (obj)).c("bl_undo"));
                ((e) (obj)).I.addActionListener(((ActionListener) (obj)));
                popupmenu.add(((e) (obj)).I);
            }
        }
        catch(Exception _ex) { }
        if(K.getItemCount() > 0)
        {
            panel.add(new r());
            panel.add(D = n.b(" >> "));
            panel.add(new r());
            panel.add(L = new Panel());
            add(K);
        }
        ai.add("Center", panel);
        (aflag = new x(0, new Dimension(220, 20), 4)).a(Color.black);
        ai.add("South", aflag);
        appmulti.add("South", ai);
        x.add("Center", appmulti);
        y = new q();
        y.setLayout(new BorderLayout(0, 1));
        w = new Panel();
        w.setLayout(z = new CardLayout());
        aflag = new Vector();
        appmulti = c.e.a(super.h, 100 + (n.c() ? -30 : 0), false, 0);
        u = (c.e)appmulti[1];
        u.a.addActionListener(this);
        w.add(String.valueOf(aflag.size()), appmulti[0]);
        if((appmulti = c("sw_chat")).length() < 5)
            appmulti = " " + appmulti + " ";
        aflag.addElement(appmulti);
        boolean aflag2[] = aflag;
        aflag1 = w;
        obj = this;
        appmulti = j();
        appmulti = g.m.b.a(((e) (obj)), 2, appmulti == null ? null : (obj.E = n.c(appmulti = appmulti)));
        obj.g = (b)appmulti[1];
        aflag1.add(String.valueOf(aflag2.size()), appmulti[0]);
        aflag2.addElement(((f) (obj)).c("sw_history"));
        (appmulti = new Panel()).setLayout(new BorderLayout(8, 0));
        ai = (new Component[] {
            N = n.c(c("bl_boot"))
        });
        N.enable(false);
        appmulti.add("West", n.a(ai, 0));
        appmulti.add("Center", U = n.c("op:", 0));
        appmulti = c.w.a(this, appmulti, 10, 100, false, true, true);
        super.h.c(v = (w)appmulti[1]);
        w.add(String.valueOf(aflag.size()), appmulti[0]);
        aflag.addElement(c("sw_users"));
        appmulti = new Panel();
        ai = getBackground();
        appmulti.setBackground(ai == null ? Color.lightGray : n.a(ai));
        w.add(String.valueOf(aflag.size()), appmulti);
        aflag.addElement(c("sw_setup"));
        (appmulti = n.a(appmulti, 4)).setFont(n.a(1));
        a(appmulti);
        y.add("Center", w);
        t = new a(this, 1, ((App) (super.h)).h);
        t.a(aflag, 0);
        y.add("North", t);
        x.add("South", y);
        as.add("Center", x);
        as.add("West", b = e());
        pack();
        show();
        A = new t(this);
        super.h.a(this);
    }

    public void windowClosing(WindowEvent windowevent)
    {
        WindowEvent windowevent1;
        if(!(windowevent = this).z() || ((((f) (windowevent1 = windowevent)).l & 0x40) == 0) || (!windowevent.s() || !windowevent.r()) && (!windowevent.y() || windowevent.p()))
        {
            ((f) (windowevent)).h.b(new int[] {
                73, ((f) (windowevent)).o
            }, new String[0]);
            windowevent.a();
        }
    }

    public boolean action(Event event, Object obj)
    {
        if(event.target == M)
        {
            if(!x())
                return true;
            if(f == null)
                f = new c(this, this);
            f.show();
            return true;
        }
        int i1;
        if(event.target == N)
        {
            if(!x())
                return true;
            v.a(1 - v.d(), Color.red, "x", 4);
        } else
        if(event.target == O)
        {
            obj = O.getSelectedIndex();
            event = this;
            a("ttype", super.q == 1 || obj <= 0 ? obj << 1 : obj < 8 ? obj + 2 : 2);
        } else
        if(event.target == R)
            a("gtype", R.getState() ? 0 : 1);
        else
        if(event.target == P)
            try
            {
                a("tm", Integer.parseInt(P.getSelectedItem()));
            }
            catch(Exception _ex) { }
        else
        if(event.target == Q)
            try
            {
                a("tg", Integer.parseInt(Q.getSelectedItem()));
            }
            catch(Exception _ex) { }
        else
        if(event.target == S)
            a("ud", S.getState() ? 1 : 0);
        else
        if(event.target == C)
            c(new int[] {
                85, super.o
            }, null);
        else
        if(event.target == F)
        {
            obj = 2;
            event = this;
            c(1, ((int) (obj)));
        } else
        if(event.target == D)
        {
            if(L != null)
                K.show(L, 0, 0);
        } else
        if((i1 = e.a(event.target)) != -1)
        {
            obj = i1;
            event = this;
            c(new int[] {
                83, ((f) (event)).o, obj
            }, null);
        } else
        if((i1 = e.b(event.target)) != -1)
        {
            obj = i1;
            event = this;
            c(new int[] {
                84, ((f) (event)).o, obj
            }, null);
        } else
        if(event.target == E && E != null)
            c(new int[] {
                94, super.o
            }, null);
        else
            return super.action(event, obj);
        return true;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if((actionevent = ((ActionEvent) (actionevent.getSource()))) == u.a)
        {
            String s1 = (actionevent = u.a).getText().trim();
            actionevent.setText("");
            if(!s1.equals(""))
                b(s1);
            return;
        }
        ActionEvent actionevent1;
        if(actionevent == G)
        {
            actionevent1 = actionevent = this;
            actionevent = 4;
            actionevent = actionevent1;
            actionevent1.c(new int[] {
                a.f, ((f) (actionevent)).o, 4, actionevent.B()
            }, null);
            return;
        }
        if(actionevent == H)
        {
            int i1 = 1;
            actionevent = this;
            c(1, i1);
            return;
        }
        if(actionevent == I)
        {
            byte byte0 = 2;
            actionevent = this;
            c(1, byte0);
            return;
        }
        if(actionevent == J)
        {
            byte byte1 = 4;
            actionevent = this;
            c(1, byte1);
        }
    }

    public final boolean c()
    {
        return g != null && !g.a();
    }

    public final void a(Window window, int i1)
    {
        try
        {
            window = ((g)window).a();
            if(i1 == 0)
                c(2, window);
            else
            if(i1 == 1)
            {
                c(3, window);
            } else
            {
                if(i1 == 2)
                {
                    window = 1;
                    i1 = window;
                    window = 3;
                    window = this;
                    c(new int[] {
                        a.f, ((f) (window)).o, 3, i1, 1, window.B()
                    }, null);
                }
                return;
            }
        }
        catch(Exception _ex) { }
    }

    private boolean A()
    {
        return z() && m() && !w() && !p();
    }

    public final void a(v v1, int i1)
    {
        if((i1 = v.d()) != 0)
        {
            v.a(0);
            b("/boot " + v1.c);
            return;
        } else
        {
            super.h.g(v1.c);
            return;
        }
    }

    public void componentHidden(ComponentEvent componentevent)
    {
    }

    public void componentMoved(ComponentEvent componentevent)
    {
    }

    public void componentResized(ComponentEvent componentevent)
    {
        componentevent = componentevent.getComponent().getSize();
        if(aa == 0)
            aa = x.minimumSize().width;
        int i1 = aa;
        int j1 = g.m.a.b(n.b());
        if(i1 < j1)
            i1 = j1;
        i1 = ((Dimension) (componentevent)).width - 8 - i1;
        j1 = ((Dimension) (componentevent)).width - (((Dimension) (componentevent)).width * 30) / 100;
        b.a(i1 >= j1 ? j1 : i1, ((Dimension) (componentevent)).height);
        b.invalidate();
        y.a((((Dimension) (componentevent)).height * 35) / 100);
        y.invalidate();
        validate();
    }

    public void componentShown(ComponentEvent componentevent)
    {
    }

    public void d()
    {
        c.show(d, "0");
    }

    public abstract g.m.a e();

    public void f()
    {
    }

    public final Component[] a(String s1, String s2, String as[], boolean flag)
    {
        s2 = new Component[0 + (as == null ? 0 : as.length) + (flag ? 1 : 0)];
        int i1 = 0;
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        Panel panel1 = new Panel();
        Object obj;
        if((obj = getBackground()) != null)
            panel1.setBackground(((Color) (obj)).darker());
        ((Container) (obj = n.a(panel1, 5))).setLayout(new BorderLayout(4, 2));
        if(as != null)
        {
            Panel panel2;
            (panel2 = new Panel()).setLayout(new FlowLayout(0, 0, 0));
            for(int j1 = 0; j1 < as.length; j1++)
            {
                if(j1 > 0)
                    panel2.add(new r(3));
                panel2.add(s2[i1++] = n.c(as[j1]));
            }

            ((Container) (obj)).add(flag ? "West" : "Center", panel2);
        }
        if(flag)
            ((Container) (obj)).add("Center", s2[i1] = n.c("", 0));
        panel.add("North", panel1);
        d.add(s1, panel);
        return s2;
    }

    public d g()
    {
        return new d(this, 2, true, true, null);
    }

    public void a(boolean flag, boolean flag1)
    {
        b.a(flag);
        if(flag1)
            ((f) (flag = this)).h.g();
    }

    private int B()
    {
        return (int)(A.b() / 100L);
    }

    public final int h()
    {
        return super.h.o();
    }

    public String a(int i1)
    {
        return c("win_pl" + (i1 = i1));
    }

    public int a(int ai[], int i1, int j1)
    {
        if(ai[i1] == 1)
        {
            if(i1 + 3 > j1)
                return i1;
            j1 = ai[i1 + 1];
            int k1 = ai[i1 + 2] % 2;
            int l1 = e.a();
            if(j1 < 0)
                j1 += 0x10000;
            X = ai[i1 + 2] >= -1 ? null : "";
            if(ai[i1 + 2] < -1)
                l1 = -(ai[i1 + 2] / 4);
            A.a(l1, j1, k1);
            i1 += 3;
        } else
        if(ai[i1] == 3)
        {
            if(i1 + 2 > j1)
                return i1;
            super.j = ai[i1 + 1] != 0;
            i1 += 2;
        }
        return i1;
    }

    public void focusGained(FocusEvent focusevent)
    {
    }

    public void focusLost(FocusEvent focusevent)
    {
    }

    public boolean i()
    {
        return true;
    }

    public String j()
    {
        return null;
    }

    public final void a(int ai[], String as[])
    {
        if(ai.length < 2)
            return;
        switch(ai[0])
        {
        case 82: // 'R'
        case 83: // 'S'
        default:
            break;

        case 92: // '\\'
            b.b(ai, as);
            return;

        case 93: // ']'
            if(ai.length < 3 || as.length <= 0)
                return;
            Window window;
            if(as.length > 0)
            {
                g g1;
                (g1 = new g(super.h, this, as[0], new Button[] {
                    n.c(c("bl_yes")), n.c(c("bl_no")), n.c(c("bl_no") + "+")
                }, this, ai[ai.length - 1])).show();
                window = (Window)ad.put(s, g1);
            } else
            {
                window = (Window)ad.remove(new Integer(ai[2]));
            }
            if(window != null)
            {
                window.dispose();
                return;
            }
            break;

        case 91: // '['
            b.a(ai, as);
            return;

        case 81: // 'Q'
            if(as.length <= 0)
                return;
            u.a(as[0]);
            if(ai.length > 2 && t.c != 0)
            {
                t.a(0, true);
                t.repaint();
                return;
            }
            break;

        case 89: // 'Y'
            if(ai.length >= 2 && as.length >= ai.length - 2)
            {
                a(as, ai, 2);
                return;
            }
            break;

        case 88: // 'X'
            if(ai.length >= 5)
            {
                super.l = ai[2];
                super.m = ai[3];
                super.n = ai[4];
                int l2 = super.n;
                e e1 = this;
                g.m.a _tmp = b;
                g.m.a.e();
                D();
                return;
            }
            break;

        case 90: // 'Z'
            if(ai.length < 3 || ai.length < 3 + ai[2] + 1)
                break;
            if(A != null)
                A.a();
            int i1;
            if((i1 = ai[3 + ai[2]]) == 0)
                break;
            int l1;
            as = (l1 = 3 + ai[2] + 1) + i1;
            if(ai.length < as)
                break;
            for(int i2 = 0; ai.length >= as + i1; i2++)
            {
                for(int j2 = 0; j2 < i1; j2++)
                {
                    int l3 = ai[as + j2];
                    int k3 = ai[l1 + j2];
                    int i3 = i2;
                    e e2 = this;
                    if(k3 == 1)
                    {
                        e2.e.a(i3, l3);
                        continue;
                    }
                    if(k3 == 2)
                    {
                        e2.e.b(i3, l3);
                        continue;
                    }
                    if(k3 == 3)
                        e2.e.a(i3, l3 != 0);
                }

                as += i1;
            }

            if(ai[2] > 0)
                e.b(ai[3]);
            if(ai[2] > 1)
            {
                int j3 = ai[4];
                e e3 = this;
                if(j3 != ((f) (e3)).p)
                {
                    e3.p = j3;
                    if(j3 != 8)
                    {
                        if(e3.s())
                            e3.r = j3 != 9 ? j3 >= 0 ? e3.a(j3) : n.a(e3.c("los_pln"), String.valueOf(-j3)) : e3.c("win_draw");
                    } else
                    {
                        e3.r = null;
                    }
                }
            }
            X = null;
            int k2 = 3 + ai[2];
            int j1;
            for(as = 5; as < k2 && (j1 = a(ai, as, k2)) != as; as = j1);
            D();
            return;

        case 87: // 'W'
            if(ai.length >= 3)
            {
                e.a(ai[2] / 2, ai[2] % 2 != 0);
                return;
            }
            break;

        case 94: // '^'
            if(as.length <= 0)
                return;
            if(W != null)
                W.dispose();
            W = new h(super.h, 1, as, true, null);
            return;

        case 84: // 'T'
            if(as.length <= 0)
                return;
            v v1;
            if((v1 = super.h.k(as[0])) != null)
                v.a(v1);
            if((x() || z()) && !s())
            {
                ((f) (ai = this)).h.g();
                return;
            }
            break;

        case 85: // 'U'
            if(as.length <= 0)
                return;
            v v2;
            if((v2 = super.h.k(as[0])) != null)
            {
                v.b(v2);
                return;
            }
            break;

        case 86: // 'V'
            for(int k1 = 0; k1 < as.length; k1++)
            {
                v v3;
                if((v3 = super.h.k(as[k1])) != null)
                    v.a(v3);
            }

            break;
        }
    }

    public void a()
    {
        if(Z)
            return;
        Z = true;
        try
        {
            A.a = false;
        }
        catch(Exception _ex) { }
        super.h.b(this);
        try
        {
            f.a();
        }
        catch(Exception _ex) { }
        v.a();
        if(u != null)
            u.c();
        try
        {
            null.getParent().remove(null);
        }
        catch(Exception _ex) { }
        try
        {
            W.dispose();
        }
        catch(Exception _ex) { }
        dispose();
    }

    public final void a(int i1, int j1, int k1, int ai[])
    {
        (i1 = new int[k1 + 4 + 1])[0] = a.e;
        i1[1] = super.o;
        i1[2] = 5;
        i1[3] = j1;
        for(j1 = 0; j1 < k1; j1++)
            i1[j1 + 4] = ai[j1];

        i1[k1 + 4] = B();
        c(i1, null);
    }

    public final void a(int i1, int j1, int k1)
    {
        c(new int[] {
            a.e, super.o, 5, 1, k1, B()
        }, null);
    }

    public final void b(int i1, int j1)
    {
        c(new int[] {
            a.e, super.o, 5, j1, B()
        }, null);
    }

    private void c(int i1, int j1)
    {
        c(new int[] {
            a.f, super.o, i1, j1, B()
        }, null);
    }

    public static String b(int i1)
    {
        return String.valueOf(i1);
    }

    public final void a(int i1, int j1)
    {
        if(X != null)
        {
            X = j1 >= 0 ? j1 / 60 + ":" + (j1 % 60) / 10 + j1 % 60 % 10 : "(?)";
            b(false);
            return;
        } else
        {
            e.b(i1, j1);
            return;
        }
    }

    public final void b()
    {
        b.h();
    }

    public final void a(long l1)
    {
        super.h.b(l1);
    }

    private void a(boolean flag)
    {
        if(!super.k)
            R.setEnabled(flag);
        for(int i1 = 0; i1 < B.size(); i1++)
            ((Component)B.elementAt(i1)).setEnabled(flag);

    }

    private void a(Panel panel)
    {
        Panel panel1;
        Panel panel2;
        Object obj;
        Object obj1;
        String as[];
        String as1[];
        (panel1 = new Panel()).setLayout(new GridLayout(1, 2, 3, 3));
        (panel2 = new Panel()).setLayout(new BorderLayout(2, 2));
        panel1.add(panel2);
        panel2 = n.a(panel2, V = n.c(c("ui_misc"), 0));
        V.setEnabled(false);
        O = n.a(new String[] {
            c("tb_ttpub")
        });
        if(super.q != 1)
        {
            for(int i1 = 0; i1 < 7; i1++)
                O.add(super.h.c(i1 % 2 != 0 ? (super.h.b(1 + i1 / 2) + super.h.b(1 + i1 / 2 + 1)) / 2 : super.h.b(1 + i1 / 2)) + "+");

        }
        O.add(c("tb_ttprv"));
        n.a(panel2, n.a(new Component[] {
            O
        }));
        O.setEnabled(false);
        ((Container) (obj = new Panel())).setLayout(new BorderLayout(2, 2));
        panel1.add(((Component) (obj)));
        obj = n.a(((Panel) (obj)), n.g(""));
        R = n.d(c("tb_gtnrt") + " (x)");
        n.a(((Panel) (obj)), n.a(new Component[] {
            R
        }, 0));
        if(super.q != 0)
        {
            R.setState(super.q == 1);
            R.setEnabled(false);
            super.k = true;
        }
        panel = n.a(panel, panel1, 3);
        (panel1 = new Panel()).setLayout(new GridLayout(1, 2, 3, 0));
        panel1.setBackground(panel.getBackground());
        if(((f) (obj = this)).h.q().length > 1)
        {
            obj = panel2 = new Panel();
            panel2.setLayout(new BorderLayout(0, 3));
            Label label = n.c(c("tb_tr_game"), 0);
            B.addElement(label);
            obj = n.a(((Panel) (obj)), label, 3);
            B.addElement(Q = n.a(super.h.q()));
            obj = n.a(((Panel) (obj)), n.a(new Component[] {
                Q
            }, 0));
            if(i())
            {
                B.addElement(S = n.d(c("tb_noundo")));
                n.a(((Panel) (obj)), n.a(new Component[] {
                    S
                }, 0));
            }
            panel1.add(panel2);
        } else
        {
            panel1.add(new Panel());
        }
        (panel2 = new Panel()).setLayout(new BorderLayout(0, 0));
        obj1 = panel2;
        obj = this;
        as1 = super.h.p();
        as1;
        as = as1;
        JVM INSTR ifnull 750;
           goto _L1 _L2
_L1:
        break MISSING_BLOCK_LABEL_651;
_L2:
        break MISSING_BLOCK_LABEL_750;
        if(as.length > 1)
        {
            Panel panel3 = ((Panel) (obj1));
            ((Container) (obj1)).setLayout(new BorderLayout(0, 3));
            obj1 = n.c(((f) (obj)).c("tb_tr_add"), 0);
            ((e) (obj)).B.addElement(obj1);
            panel3 = n.a(panel3, ((Component) (obj1)), 3);
            ((e) (obj)).B.addElement(obj.P = n.a(as));
            n.a(panel3, n.a(new Component[] {
                ((e) (obj)).P
            }, 0));
        }
        panel1.add(panel2);
        n.a(panel, panel1);
        return;
    }

    public static void k()
    {
    }

    private void a(String as[], int ai[], int i1)
    {
        for(i1 = 0; i1 < ai.length - 2; i1++)
        {
            int j1 = ai[i1 + 2];
            if(as[i1].equalsIgnoreCase("ttype"))
            {
                int k1 = j1;
                j1 = this;
                O.select(super.q == 1 || k1 <= 1 ? k1 / 2 : k1 != 2 ? k1 - 2 : 8);
                continue;
            }
            if(as[i1].equalsIgnoreCase("gtype"))
            {
                if(!super.k)
                    R.setState(j1 == 0);
                continue;
            }
            if(as[i1].equalsIgnoreCase("tm"))
            {
                if(P != null)
                    P.select(String.valueOf(j1));
                continue;
            }
            if(as[i1].equalsIgnoreCase("tg"))
            {
                if(Q != null)
                    Q.select(String.valueOf(j1));
                continue;
            }
            if(as[i1].equalsIgnoreCase("ud"))
            {
                if(S != null)
                    S.setState(j1 != 0);
                continue;
            }
            if(as[i1].startsWith("op:") && U != null)
                U.setText("op: " + as[i1].substring(3));
        }

    }

    private void C()
    {
        for(int i1 = 0; i1 < e.a; i1++)
        {
            g.m.h h1;
            if(i1 < (h1 = super.i).b.length - 3)
            {
                if(super.i.b(i1) == 1)
                {
                    e.a(i1, super.i.a(i1));
                    continue;
                }
                if(super.i.b(i1) != 3)
                {
                    e.b(i1, o() && super.i.b(i1) == 0);
                    continue;
                }
            }
            e.a(i1, null);
        }

        b(true);
    }

    public final void b(int ai[], String as[])
    {
        super.i.a(ai, as);
        T.a(n.a(c("l_tab"), ((g.m.h) (ai = super.i)).c) + "   " + ((g.m.h) (ai = super.i)).a[0]);
        C();
    }

    private void D()
    {
        int i1 = e.a();
        d();
        int j1 = !A() && (!q() || !e.a(super.n)) ? 0 : 1;
        boolean flag = j1;
        e e1 = this;
        if(flag != e1.ac)
        {
            e1.ac = flag;
            e1.setTitle((flag ? "+ " : "") + e1.ab);
        }
        C.setEnabled(A());
        e1 = 0;
        if((!s() || !r()) && (!y() || p()))
            e1 = !x() || s() && !m() ? ((e) (z() ? ((e) (1 << super.n)) : 0)) : 15;
        e.c(e1);
        e1 = !z() || !q() ? 0 : 1;
        if(G != null)
            G.setEnabled(z() && s() && !m());
        if(H != null)
            H.setEnabled(e1 && i1 != super.n);
        if(F != null)
            F.setEnabled(e1 && !super.j);
        if(I != null)
            I.setEnabled(e1 && !super.j);
        i1 = !e1 || i1 != super.n || i1 == -1 ? 0 : 1;
        a(i1, i1 && !Y);
        Y = i1;
        V.setEnabled(x());
        O.setEnabled(x());
        M.setEnabled(x());
        N.setEnabled(x());
        a(x() && !s());
        C();
    }

    public void update(Graphics g1)
    {
        if(g1 == null)
        {
            if(t != null)
            {
                z.show(w, String.valueOf(t.c));
                return;
            }
        } else
        {
            super.update(g1);
        }
    }

    private void b(boolean flag)
    {
        String s1 = null;
        int i1 = 0;
        boolean flag1 = false;
        if(p())
            s1 = "aw_rnd";
        else
        if(n())
        {
            if(o())
                s1 = "pr_sit";
            else
            if(s())
                s1 = "aw_pls";
            else
            if(z())
            {
                if(!m())
                {
                    s1 = "aw_opp";
                    if(!super.i.e())
                        flag1 = true;
                    else
                    if((i1 = super.i.a()) <= 0);
                } else
                if(!w())
                    s1 = s() ? "pr_stcn" : "pr_st";
                else
                    s1 = "aw_st";
            } else
            {
                s1 = "aw_opp";
                if(!super.i.e())
                    flag1 = true;
                else
                if((i1 = super.i.a()) > 0)
                    s1 = "aw_opp";
            }
        } else
        if(m())
            if(z() && !w())
                s1 = s() ? "pr_stcn" : "pr_st";
            else
                s1 = "aw_st";
        if(s1 != null)
        {
            s1 = c(s1);
            if(i1 > 0)
                s1 = s1 + "\n(" + super.h.c(i1) + "+)";
            else
            if(flag1)
                s1 = s1 + "\n(" + c("bl_invite") + ")";
            if(X != null)
                s1 = s1 + "\n" + X;
            b.a(g.h.a((super.r == null ? "" : super.r + "\n") + s1));
        } else
        {
            b.a(null);
        }
        if(flag)
        {
            b.repaint();
            return;
        } else
        {
            b.a(b.getGraphics());
            return;
        }
    }

    public static boolean l()
    {
        return true;
    }

    public final Image a(String s1)
    {
        return super.h.a(s1);
    }

    private static Integer s = new Integer(2);
    public g.m.a b;
    public CardLayout c;
    public Panel d;
    private a t;
    private c.e u;
    private w v;
    private Panel w;
    private q x;
    private q y;
    private CardLayout z;
    public d e;
    private t A;
    private Vector B;
    private Button C;
    private Button D;
    private Button E;
    private Button F;
    private MenuItem G;
    private MenuItem H;
    private MenuItem I;
    private MenuItem J;
    private PopupMenu K;
    private Panel L;
    private Button M;
    private Button N;
    private Choice O;
    private Choice P;
    private Choice Q;
    private Checkbox R;
    private Checkbox S;
    private m T;
    private Label U;
    private Label V;
    c f;
    private h W;
    private String X;
    private boolean Y;
    private boolean Z;
    private int aa;
    private String ab;
    private boolean ac;
    private Hashtable ad;
    public b g;

}
