// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.*;
import g.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

// Referenced classes of package g.m:
//            a, e, f, h, 
//            i

public abstract class AppMulti extends App
    implements p, u, ActionListener, Runnable
{

    public AppMulti()
    {
        z = new Hashtable();
        A = new Vector();
        B = new Object();
    }

    public abstract g.m.e c(int ai[], String as[]);

    public final void f()
    {
        if(super.i != null)
            return;
        c.n.b();
        super.i = new Panel();
        String _tmp = super.b;
        super.q = false;
        w = new Hashtable();
        x = new Hashtable();
        v = 0;
        X = "";
        super.u = -2;
        Panel panel = c.n.a(super.i, 1 + App.k);
        Panel panel1;
        (panel1 = new Panel()).setLayout(new BorderLayout(0, 4));
        T = new Panel();
        T.setLayout(Q = new CardLayout());
        T.add("nolist", new r());
        T.add("list", W = c.n.a(new String[0]));
        Panel panel2 = new Panel();
        Y = c.n.f("");
        panel1.add("West", c.n.a(new Component[] {
            G = c.n.c(" " + b("bl_newtab") + " "), new r(), panel2, T, new r(), new r(), Y
        }));
        if(!c())
            panel1.add("East", c.n.a(new Component[] {
                super.n = c.n.c(b("bl_buds")), new r(), super.o = c.n.c(b("bl_cs")), new r(), super.p = c.n.c(b("bl_prefs"))
            }));
        panel1.add("South", new x(0));
        (panel2 = new Panel()).setLayout(new BorderLayout(App.k, App.k - 1));
        Panel panel3;
        (panel3 = new Panel()).setLayout(new BorderLayout(0, 0));
        S = new Panel();
        S.setLayout(P = new CardLayout());
        S.add("none", new r());
        S.add("partner", c.n.a(new Component[] {
            H = c.n.c(b("bl_partinv"))
        }, 0));
        S.add("boot", c.n.a(new Component[] {
            I = c.n.c(b("tu_bcan") + " / " + b("bl_boot"))
        }, 0));
        panel3.add("West", S);
        Panel panel4;
        (panel4 = new Panel()).setLayout(new BorderLayout(0, 0));
        panel4.add("West", new d());
        panel3.add("Center", panel4);
        Object aobj1[] = c.w.a(this, panel3, 230, 10, false, false);
        b(C = (w)aobj1[1]);
        panel2.add("Center", aobj1[0]);
        panel.add("East", panel2);
        R = new Panel();
        R.setLayout(new BorderLayout(App.k, App.k - 1));
        Object aobj[] = g.m.i.a(this, false);
        y = (g.m.i)aobj[1];
        R.add("Center", aobj[0]);
        U = new Panel();
        U.setLayout(new BorderLayout(0, 0));
        L = new a(this);
        L.a(0);
        aobj = (new String[] {
            "x"
        });
        aobj1 = (new boolean[] {
            true
        });
        double ad[] = {
            100D
        };
        int ai[] = {
            20
        };
        L.a(((String []) (aobj)), ad, ai, ((boolean []) (aobj1)), 0);
        L.b(20);
        L.a(false);
        ((Container) (aobj = new Panel())).setLayout(new BorderLayout(App.k, 0));
        ((Container) (aobj)).add("West", L);
        ((Container) (aobj)).add("Center", new r());
        U.add("North", ((Component) (aobj)));
        aobj = c.e.a(this, 100, false, 1);
        super.m = (e)aobj[1];
        super.m.a.addActionListener(this);
        U.add("Center", aobj[0]);
        ((Container) (aobj = new Panel())).setLayout(new BorderLayout(0, 0));
        ((Container) (aobj)).add("West", c.n.a(new Component[] {
            J = c.n.c(b("sw_chat"))
        }));
        ((Container) (aobj)).add("East", new s());
        V = ((Component) (aobj));
        R.add("South", V);
        panel.add("Center", R);
        panel.add("North", panel1);
        add("lounge", super.i);
        if(super.f)
            (new Thread(this)).start();
    }

    public final void e(int l)
    {
        g.m.e e1;
        if((e1 = (g.m.e)x.get(String.valueOf(l))) == null)
        {
            b(new int[] {
                72, l
            }, null);
            return;
        } else
        {
            e1.toFront();
            return;
        }
    }

    public final void a(g.m.e e1)
    {
        x.put(String.valueOf(((f) (e1)).o), e1);
    }

    public final void b(g.m.e e1)
    {
        x.remove(String.valueOf(((f) (e1)).o));
    }

    public final int o()
    {
        return !super.q ? 0 : 1;
    }

    public final boolean h()
    {
        return true;
    }

    public final String[] p()
    {
        return F;
    }

    public final String[] q()
    {
        return E;
    }

    public final void a(v v1, int l)
    {
        int i1;
        if((i1 = C.d()) == 2)
        {
            C.a(0);
            if(l != 0)
            {
                l = v1.c;
                v1 = this;
                b(new int[] {
                    76, 1
                }, new String[] {
                    l
                });
                return;
            } else
            {
                g(v1.c);
                return;
            }
        }
        if(i1 == 1 && l != 0 && M == 1)
        {
            C.a(0);
            new i(this, v1.c, new String[] {
                b("tu_bcan"), b("bl_boot")
            }, new int[] {
                77, 0
            }, new String[] {
                v1.c
            }, new int[] {
                20
            }, new String[] {
                "/boot " + v1.c
            });
            return;
        }
        if(M == 2)
        {
            if(v1.a(2) == 0)
            {
                new i(this, v1.c, new String[] {
                    "info", b("tu_bacc"), b("tu_brej"), b("bl_boot")
                }, new Object[][] {
                    new Object[] {
                        new int[] {
                            61
                        }, new String[] {
                            v1.c
                        }
                    }, new Object[] {
                        new int[] {
                            77, 1
                        }, new String[] {
                            v1.c
                        }
                    }, new Object[] {
                        new int[] {
                            77, 0
                        }, new String[] {
                            v1.c
                        }
                    }, new Object[] {
                        new int[] {
                            20
                        }, new String[] {
                            "/boot " + v1.c
                        }
                    }
                });
                return;
            } else
            {
                new i(this, v1.c, new String[] {
                    "info", b("tu_bcan"), b("bl_boot")
                }, new Object[][] {
                    new Object[] {
                        new int[] {
                            61
                        }, new String[] {
                            v1.c
                        }
                    }, new Object[] {
                        new int[] {
                            77, 0
                        }, new String[] {
                            v1.c
                        }
                    }, new Object[] {
                        new int[] {
                            20
                        }, new String[] {
                            "/boot " + v1.c
                        }
                    }
                });
                return;
            }
        } else
        {
            g(v1.c);
            return;
        }
    }

    public final v k(String s1)
    {
        return (v)z.get(s1);
    }

    public final void a(w w1)
    {
        synchronized(B)
        {
            A.removeElement(w1);
        }
    }

    public final void b(w w1)
    {
        synchronized(B)
        {
            w1.a(z);
            A.addElement(w1);
        }
    }

    public final void a(int ai[], String as[])
    {
        if(ai[0] >= 80)
        {
            if(ai.length < 2)
                return;
            g.m.e e1;
            if((e1 = (g.m.e)x.get(String.valueOf(ai[1]))) != null)
                e1.a(ai, as);
            return;
        }
        switch(ai[0])
        {
        case 73: // 'I'
            if(ai.length >= 2)
                if(ai.length == 2)
                {
                    g.m.e e2;
                    if((e2 = (g.m.e)x.get(String.valueOf(ai[1]))) != null)
                        e2.toFront();
                    return;
                } else
                {
                    c(ai, as);
                    return;
                }
            break;

        case 74: // 'J'
            g.m.e e3;
            if(ai.length >= 2 && (e3 = (g.m.e)x.get(String.valueOf(ai[1]))) != null)
            {
                e3.a();
                return;
            }
            break;

        case 72: // 'H'
            h h1;
            if(ai.length >= 2 && (h1 = (h)w.remove(String.valueOf(ai[1]))) != null)
            {
                y.b(h1);
                return;
            }
            break;

        case 70: // 'F'
            if(as.length <= 0 || ai.length < 3)
                break;
            h h2;
            if((h2 = (h)w.get(String.valueOf(ai[1]))) == null)
            {
                h2 = new h(this, ai, 0, ai.length, as, 0, as.length);
                w.put(String.valueOf(ai[1]), h2);
                y.a(h2);
                return;
            }
            h2.a(ai, as);
            y.a(h2, true);
            g.m.e e4;
            if((e4 = (g.m.e)x.get(String.valueOf(ai[1]))) != null)
            {
                e4.b(ai, as);
                return;
            }
            break;

        case 71: // 'G'
            if(ai.length < 3)
                break;
            w.clear();
            int l = ai[1];
            int l1 = ai[2];
            int j2 = 3;
            int l2 = 0;
            int j3 = l;
            l1 = l1;
            do
            {
                if(j2 >= ai.length)
                    break;
                if(l == -1)
                {
                    j3 = ai[j2];
                    j2++;
                    l1 = 1 + (j3 - 2);
                }
                if(j2 + j3 > ai.length || l2 + l1 > as.length)
                    break;
                h h3 = new h(this, ai, j2 - 1, j3 + 1, as, l2, l1);
                h h4;
                w.put((h4 = h3).c, h3);
                l2 += l1;
                j2 += j3;
            } while(true);
            y.a(w);
            return;

        case 75: // 'K'
            if(as.length >= 2 && ai.length >= 2)
            {
                new i(this, as[0] + (as.length < 3 ? "" : "\n" + as[2]), null, new int[] {
                    72, ai[1]
                }, null, new int[] {
                    74, ai[1]
                }, new String[] {
                    as[1]
                });
                return;
            }
            break;

        case 24: // '\030'
            if(as.length <= 0)
                return;
            v v1;
            if((v1 = (v)z.remove(as[0])) != null)
            {
                v1.c();
                return;
            }
            break;

        case 25: // '\031'
            if(as.length <= 0)
                return;
            v v2;
            if((v2 = (v)z.get(as[0])) == null)
            {
                v2 = new v(this, as[0], O, ai, 1, ai.length);
                z.put(as[0], v2);
                synchronized(B)
                {
                    for(Enumeration enumeration1 = A.elements(); enumeration1.hasMoreElements(); ((w)enumeration1.nextElement()).a(v2));
                }
                break;
            } else
            {
                v2.a(O, ai, 1, ai.length);
                return;
            }

        case 27: // '\033'
            if(ai.length < 3)
                break;
            z.clear();
            int i1 = ai[1];
            int i2 = ai[2];
            int k2 = 3;
            for(int i3 = 0; k2 + i1 <= ai.length && i3 + 1 + i2 <= as.length; i3++)
            {
                z.put(as[i3], new v(this, as[i3], O, ai, k2, k2 + i1));
                k2 += i1;
            }

            synchronized(B)
            {
                for(Enumeration enumeration = A.elements(); enumeration.hasMoreElements(); ((w)enumeration.nextElement()).a(z));
            }
            break;

        case 61: // '='
            if(as.length <= 0)
                return;
            v v3;
            if((v3 = (v)z.get(as[0])) == null)
                break;
            try
            {
                ((k)v3.d).a();
            }
            catch(Exception _ex) { }
            v3.d = new k(this, as[0], v3, ai, as);
            return;

        case 76: // 'L'
            if(as.length <= 0)
                return;
            X = as[0];
            Y.setText(X);
            int j1 = 0;
            if(ai.length > 1)
                j1 = ai[1];
            if(j1 < 0)
            {
                if(Z == null)
                    Z = new t(this, 1);
                Z.a(0, -j1 * 5, -1);
            } else
            if(Z != null)
            {
                Z.a();
                Z.a = false;
            }
            Y.getParent().getParent().validate();
            return;

        case 30: // '\036'
            for(int k1 = 0; k1 + 1 < as.length; k1 += 2)
            {
                String s1 = as[k1 + 1];
                Object obj1 = as[k1];
                ai = this;
                if(((String) (obj1)).equalsIgnoreCase("set_tournaments"))
                {
                    try
                    {
                        ai.N = Integer.parseInt(s1);
                    }
                    catch(Exception _ex) { }
                    if(((AppMulti) (ai)).N != 0)
                        ((AppMulti) (ai)).y.a(0);
                    ai.r();
                    ((AppMulti) (ai)).G.enable(((AppMulti) (ai)).N == 0);
                    continue;
                }
                if(((String) (obj1)).equalsIgnoreCase("set_cols"))
                {
                    try
                    {
                        ai.O = Integer.parseInt(s1);
                    }
                    catch(Exception _ex) { }
                    obj1 = ((AppMulti) (ai)).C;
                    ai = ai;
                    if(((AppMulti) (ai)).N != 0)
                        ai.a(((w) (obj1)), 2, 4, 1);
                    else
                        ai.a(((w) (obj1)), 4, 16, 0);
                    continue;
                }
                if(((String) (obj1)).equalsIgnoreCase("set_chat") && s1.equals("0") && (obj1 = ((AppMulti) (ai)).J.getParent()) != null)
                    ((Container) (obj1)).remove(((AppMulti) (ai)).J);
            }

            return;

        case 32: // ' '
            if(ai.length < 2)
                return;
            if(W.countItems() > 0)
                super.m.b();
            W.removeAll();
            if(as.length > 0)
            {
                for(StringTokenizer stringtokenizer = new StringTokenizer(as[0], "\n"); stringtokenizer.hasMoreTokens(); W.addItem(stringtokenizer.nextToken()));
                W.select(ai[1]);
            }
            Q.show(T, as.length <= 0 ? "nolist" : "list");
            T.getParent().getParent().validate();
            return;

        case 77: // 'M'
            if(ai.length < 2)
                break;
            if(as.length <= 0)
                return;
            if(as.length == 1)
            {
                new i(this, as[0], null, new int[] {
                    76, 1
                }, null, new int[] {
                    76, 0
                }, null);
                return;
            } else
            {
                new i(this, as[0], null, new int[] {
                    76, 2
                }, new String[] {
                    as[1]
                }, new int[] {
                    76, 0
                }, new String[] {
                    as[1]
                });
                return;
            }

        case 22: // '\026'
            if(ai.length >= 2)
            {
                M = ai[1];
                r();
                return;
            }
            break;

        case 33: // '!'
            if(ai.length >= 2)
            {
                v = ai[1];
                y.b();
                return;
            }
            break;

        case 23: // '\027'
        case 26: // '\032'
        case 28: // '\034'
        case 29: // '\035'
        case 31: // '\037'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
        case 44: // ','
        case 45: // '-'
        case 46: // '.'
        case 47: // '/'
        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
        case 65: // 'A'
        case 66: // 'B'
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
        default:
            super.a(ai, as);
            break;
        }
    }

    private void r()
    {
        if(M != 1) goto _L2; else goto _L1
_L1:
        P;
        S;
        "boot";
          goto _L3
_L2:
        P;
        S;
        N != 2 ? "none" : "partner";
_L3:
        show();
    }

    public final void j(String s1)
    {
        try
        {
            e(Integer.parseInt(s1.trim()));
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public final void c(String s1, String s2)
    {
        super.c(s1, s2);
        if(s1.equalsIgnoreCase("set_tab_mt"))
        {
            D = c.n.a(s2);
            return;
        }
        if(s1.equalsIgnoreCase("set_tab_at"))
        {
            F = c.n.a(s2);
            return;
        }
        if(s1.equalsIgnoreCase("set_tab_gt"))
        {
            E = c.n.a(s2);
            return;
        }
        if(s1.equalsIgnoreCase("set_rank"))
        {
            s2 = (s1 = new StringTokenizer(s2)).countTokens() / 2;
            super.d = new int[s2];
            super.c = new Color[s2];
            int l = 0;
            do
            {
                if(!s1.hasMoreTokens())
                    break;
                int i1 = 0;
                try
                {
                    i1 = Integer.parseInt(s1.nextToken());
                }
                catch(Exception _ex) { }
                if(!s1.hasMoreTokens())
                    break;
                s2 = c.n.e(s1.nextToken());
                super.d[l] = i1;
                super.c[l] = s2;
                l++;
            } while(true);
        }
    }

    public final void d(String s1, String s2)
    {
        if(s1.equalsIgnoreCase("cht"))
            c(s2.equals("1") || s2.equalsIgnoreCase("true"));
        super.d(s1, s2);
    }

    private void c(boolean flag)
    {
        if(U == null)
            return;
        if(flag)
        {
            R.remove(V);
            R.add("South", U);
        } else
        {
            R.remove(U);
            R.add("South", V);
        }
        R.validate();
    }

    public final void m()
    {
        boolean flag;
        int l;
        Enumeration enumeration;
        flag = true;
        l = o();
        enumeration = x.elements();
_L2:
        if(!enumeration.hasMoreElements())
            break; /* Loop/switch isn't completed */
        g.m.e e1 = (g.m.e)enumeration.nextElement();
        g.m.e.k();
        e1.b;
        if(!flag)
            break MISSING_BLOCK_LABEL_58;
        if(g.m.a.d() == l)
            return;
        flag = false;
        g.m.a.i();
        continue; /* Loop/switch isn't completed */
        JVM INSTR pop ;
        if(true) goto _L2; else goto _L1
_L1:
    }

    public final void c(w w1)
    {
        a(w1, (O & 4) == 0 ? 0 : 4, -1, 0);
    }

    public final void d(w w1)
    {
        if((O & 4) != 0)
        {
            a(w1, 4, 1, 2);
            return;
        } else
        {
            a(w1, 1, 0, 1);
            return;
        }
    }

    private void a(w w1, int l, int i1, int j1)
    {
        int k1;
        String as[] = new String[k1 = 1 + (l == 0 ? 0 : 1) + (i1 == 0 ? 0 : 1)];
        double ad[] = new double[k1];
        int ai[] = new int[k1];
        int ai1[] = new int[k1];
        boolean aflag[] = new boolean[k1];
        as[0] = ".";
        ai1[0] = 0;
        ad[0] = 1.0D;
        ai[0] = -1;
        aflag[0] = true;
        int l1 = 1;
        for(int i2 = 0; i2 < 2; i2++)
        {
            int j2;
            if((j2 = i2 != 0 ? i1 : l) != 0)
            {
                as[l1] = ".";
                ai1[l1] = j2;
                aflag[l1] = j2 == 1;
                ad[l1] = 0.25D;
                ad[0] -= 0.25D;
                ai[l1] = j2 != 16 ? ((int) (j2 != 2 ? 50 : 40)) : 30;
                l1++;
            }
        }

        w1.a(as, ai1, ad, ai, aflag, j1);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        if(super.m == null)
            return;
        if(actionevent.getSource() == super.m.a)
        {
            String s1 = (actionevent = super.m.a).getText().trim();
            actionevent.setText("");
            if(!s1.equals(""))
                c(s1);
        }
    }

    public boolean action(Event event, Object obj)
    {
        if(event.target == null)
        {
            if((event = (v)((o) (C)).j) != null)
                h(((v) (event)).c);
            return true;
        }
        if(event.target == null)
        {
            if((event = (v)((o) (C)).j) != null)
                g(((v) (event)).c);
            return true;
        }
        if(event.target == G)
        {
            obj = K == null ? null : ((Object) (new String[] {
                K.getState() ? "pls=2" : "pls=4"
            }));
            event = this;
            b(new int[] {
                71
            }, ((String []) (obj)));
            return true;
        }
        if(event.target == W)
        {
            c("/join " + W.getSelectedItem());
            return true;
        }
        if(event.target == I)
        {
            C.a(1 - C.d());
            return true;
        }
        if(event.target == H)
        {
            if(C.d() != 0)
                C.a(0);
            else
                C.a(2, Color.gray, "+", 4);
            return true;
        }
        if(event.target == J)
        {
            c(true);
            return true;
        } else
        {
            return super.action(event, obj);
        }
    }

    public final void n()
    {
        if(x != null)
        {
            for(Enumeration enumeration = x.elements(); enumeration.hasMoreElements();)
                try
                {
                    ((g.m.e)enumeration.nextElement()).a();
                }
                catch(Exception _ex) { }

        }
        super.n();
    }

    public void update(Graphics g)
    {
        if(g != null)
            super.update(g);
        if(L.c == 0)
            c(false);
    }

    public void run()
    {
        while(!super.g) 
        {
            int l = 0;
            while(l < 8) 
            {
                if(super.u >= 0)
                {
                    super.u++;
                    if(super.u == App.j)
                        b(false);
                }
                try
                {
                    Thread.sleep(125L);
                }
                catch(Exception _ex) { }
                l++;
            }
        }
    }

    public final void a(int l, int i1)
    {
        if(Y != null)
        {
            Y.setText(X + (i1 >= 0 ? i1 / 60 + ":" + (i1 % 60) / 10 + i1 % 60 % 10 : "(?)"));
            Y.getParent().getParent().validate();
        }
    }

    public final void b()
    {
    }

    public final void a(long l)
    {
    }

    private Hashtable w;
    private Hashtable x;
    private g.m.i y;
    private Hashtable z;
    private Vector A;
    private Object B;
    private w C;
    private String D[];
    private String E[];
    private String F[];
    private Button G;
    private Button H;
    private Button I;
    private Button J;
    private Checkbox K;
    private a L;
    private int M;
    public int v;
    private int N;
    private int O;
    private CardLayout P;
    private CardLayout Q;
    private Panel R;
    private Panel S;
    private Panel T;
    private Panel U;
    private Component V;
    private Choice W;
    private String X;
    private Label Y;
    private t Z;
}
