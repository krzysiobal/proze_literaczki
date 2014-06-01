// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.net.URL;
import java.util.*;

// Referenced classes of package g:
//            a, b, c, d, 
//            e, g, h, i, 
//            j

public abstract class App extends Applet
{

    public abstract App a(App app);

    public App()
    {
        b = "";
        z = new Hashtable();
        A = new Hashtable();
        P = true;
        t = null;
        U = null;
        V = null;
        f = true;
        C = false;
        e = false;
        D = true;
    }

    public void init()
    {
        H = new Hashtable();
        I = new Hashtable();
        J = new Hashtable();
        K = new Hashtable();
        r = "";
        ab = new String[G];
        ac = 0;
        ad = 0;
        setLayout(v = new CardLayout());
        try
        {
            getAppletContext().showDocument(new URL(getDocumentBase(), a("status_url", ((String) (null)))), "stat");
        }
        catch(Exception _ex) { }
        h = a("rtl", false);
        getGraphics();
        c.n.a();
        setBackground(c.n.e(a("bgcolor", "8fcfef")));
        setForeground(Color.black);
        add("status", a = new Label("-", 1));
        if(D || !c())
        {
            e(y[0]);
            return;
        } else
        {
            p();
            return;
        }
    }

    public final void a(g.g g1, String s1)
    {
        if(g1 == w)
            a.setText(s1);
    }

    public final boolean a(g.g g1, int i1)
    {
label0:
        {
            if(g1 == null)
                return false;
            switch(i1)
            {
            default:
                break label0;

            case -1: 
                if(g1 != w)
                    return false;
                w = null;
                g1 = g1.b();
                for(i1 = 0; i1 < y.length; i1++)
                    if(g1 == y[i1] && i1 < y.length - 1)
                    {
                        e(y[i1 + 1]);
                        return false;
                    }

                if(D)
                    a.setText("connect fail (?)");
                else
                    p();
                return false;

            case 0: // '\0'
                if(g1 == x)
                {
                    x = null;
                    if(i == null && !D)
                    {
                        p();
                        break label0;
                    }
                    i1 = 1;
                    g1 = g1.a;
                    try
                    {
                        if(g1 == null)
                        {
                            a.setText(a("msg_disconnected", "disconnected (?)"));
                            if(z.size() > 0)
                                i1 = 0;
                        } else
                        if(g1.startsWith(":"))
                            a.setText("LOGIN FAIL");
                        else
                            a.setText(g1);
                    }
                    catch(Exception _ex) { }
                    v.show(this, "status");
                    if(i1 != 0)
                        break label0;
                    if(g1 == null && !g)
                        (new g.e(this)).start();
                }
                n();
                return false;

            case 1: // '\001'
                if(g1 != w)
                {
                    return false;
                } else
                {
                    w = null;
                    x = g1;
                    return true;
                }
            }
        }
        return false;
    }

    private void e(int i1)
    {
        String s1;
        if((s1 = a("sid", "")).equals(""))
            s1 = "g" + (int)(10D + Math.random() * 100D);
        App app;
        if((app = a(this)) == this)
            break MISSING_BLOCK_LABEL_92;
        if(app.x == null)
        {
            app.a.setText("-");
            app.v.show(this, "status");
            return;
        }
        try
        {
            app.o();
        }
        catch(Exception exception) { }
        String s2 = null;
        try
        {
            s2 = getCodeBase().getHost();
        }
        catch(Exception _ex) { }
        if(s2 == null)
            s2 = "localhost";
        w = new g.g(this, s2, i1, new int[] {
            b("port", 1)
        }, new String[] {
            s1, b = a("lang", "pl"), "j", a("room", ""), ""
        });
        return;
    }

    public final void a()
    {
        e(y[0]);
    }

    public void destroy()
    {
        o();
    }

    private void o()
    {
        g = true;
        try
        {
            x.a();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public final boolean c()
    {
        return a("sid", "").equals("guest");
    }

    public Object[][] d()
    {
        return new Object[0][0];
    }

    public final Image a(String s1)
    {
        if(A.containsKey(s1))
            return (Image)A.get(s1);
        Image image = null;
        Object aobj[] = null;
        Object aobj1[][] = d();
        int i1 = 0;
        do
        {
            if(i1 >= aobj1.length)
                break;
            if(s1.equals(aobj1[i1][0]))
            {
                aobj = (Object[])aobj1[i1][1];
                break;
            }
            i1++;
        } while(true);
        if(aobj != null)
            image = c.n.a((long[])aobj[0], (byte[])aobj[1]);
        if(image == null)
            try
            {
                image = s1.startsWith("/") ? getImage(new URL(getCodeBase().getProtocol() + "://" + getCodeBase().getHost() + s1)) : getImage(getCodeBase(), s1);
            }
            catch(Exception _ex) { }
        A.put(s1, image);
        return image;
    }

    public String getParameter(String s1)
    {
        if(getAppletContext() != null)
            return super.getParameter(s1);
        else
            return null;
    }

    public final String b(String s1)
    {
        String s2;
        if((s2 = (String)z.get(s1)) != null)
            return s2;
        else
            return a(s1, s1);
    }

    public static boolean e()
    {
        return false;
    }

    private void a(Object aobj[], int i1, String s1)
    {
        aobj[1] = new Integer(i1);
        if(i1 == 0)
        {
            aobj[2] = s1 == null ? "" : ((Object) (s1));
            return;
        }
        if(s1 != null)
        {
            if((i1 = s1.indexOf(":")) == -1)
            {
                aobj[3] = s1.equals("") ? "" : ((Object) (b("ui_misc") + " " + s1));
                aobj[4] = null;
                return;
            }
            aobj[3] = null;
            aobj[4] = s1.substring(i1 + 1);
        }
    }

    public void a(int ai[], String as[])
    {
        ai[0];
        JVM INSTR tableswitch 18 53: default 1762
    //                   18 1736
    //                   19 1762
    //                   20 160
    //                   21 359
    //                   22 1762
    //                   23 1651
    //                   24 1762
    //                   25 1762
    //                   26 1762
    //                   27 1762
    //                   28 1316
    //                   29 1135
    //                   30 1762
    //                   31 1618
    //                   32 1762
    //                   33 1762
    //                   34 1255
    //                   35 271
    //                   36 1762
    //                   37 1762
    //                   38 1762
    //                   39 1762
    //                   40 1762
    //                   41 1762
    //                   42 1762
    //                   43 1762
    //                   44 1762
    //                   45 1762
    //                   46 1762
    //                   47 1762
    //                   48 1762
    //                   49 1762
    //                   50 1762
    //                   51 1665
    //                   52 1059
    //                   53 1076;
           goto _L1 _L2 _L1 _L3 _L4 _L1 _L5 _L1 _L1 _L1 _L1 _L6 _L7 _L1 _L8 _L1 _L1 _L9 _L10 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L11 _L12 _L13
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        if(as.length <= 0)
            return;
        if(m != null)
            m.a(as[0]);
        if(!as[0].startsWith("** ") && !as[0].startsWith(" \n"))
        {
            if(ad >= G)
            {
                ac = (ac + 1) % G;
                ad--;
            }
            ab[(ac + ad) % G] = as[0];
            ad++;
            return;
        }
        break; /* Loop/switch isn't completed */
_L10:
        if(as.length <= 0)
            return;
        I.clear();
        String s1;
        for(StringTokenizer stringtokenizer = new StringTokenizer(as[0]); stringtokenizer.hasMoreElements(); I.put(s1, ((Object) (new Object[] {
    s1, h.b, null
}))))
            s1 = stringtokenizer.nextToken();

        if(N != null)
        {
            N.a(I);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if(as.length < 2)
            break; /* Loop/switch isn't completed */
        int i1 = ai.length <= 1 ? 0 : ai[1];
        int k2 = ai.length <= 2 ? 1 : ai[2];
        String s2 = as[1];
        ai = (g.c)J.get(s2);
        if(k2 == 0)
        {
            if(ai != null)
            {
                ai.a(k2, as[0], i1);
                return;
            }
            if((ai = ((int []) ((Object[])K.get(s2)))) == null)
                K.put(s2, ai = ((int []) (new Object[] {
                    "", h.a
                })));
            ai[0] = (String)ai[0] + "\n" + as[0];
            if(i1 != 0)
            {
                as = 0;
                k2 = new StringTokenizer((String)ai[0], "\n");
                do
                {
                    if(!k2.hasMoreTokens())
                        break;
                    String s4;
                    if(!(s4 = k2.nextToken()).startsWith("** "))
                        as++;
                } while(true);
                Object aobj5[] = (Object[])I.get(s2);
                as = " (" + as + ")";
                if(aobj5 != null)
                {
                    aobj5[2] = as;
                    if(N != null)
                        N.a(((Object) (aobj5)), true);
                } else
                {
                    Object aobj6[];
                    I.put(s2, ((Object) (aobj6 = (new Object[] {
                        s2, h.a, as
                    }))));
                    if(N != null)
                        N.a(((Object) (aobj6)));
                }
                as = ((Integer)ai[1]).intValue() != 0 ? 0 : 1;
                ai[1] = new Integer(i1);
                if(as != 0)
                    r();
                return;
            }
            if(I.containsKey(s2))
                break; /* Loop/switch isn't completed */
            as = ((String []) (new Object[] {
                s2, h.a, null
            }));
            I.put(s2, as);
            if(N != null)
                N.a(as);
            return;
        }
        if(k2 == -1)
        {
            if(ai != null)
            {
                ai.a(k2, as[0], i1);
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        if(k2 == -2)
        {
            if(ai != null)
                ai.c();
            if(K.containsKey(s2) && ((Integer)(ai = ((int []) ((Object[])K.remove(s2))))[1]).intValue() != 0)
                r();
            if(!I.containsKey(s2))
                break; /* Loop/switch isn't completed */
            ai = ((int []) (I.remove(s2)));
            if(N != null)
                N.b(ai);
            return;
        }
        if(ai == null && i1 == 0)
        {
            if((ai = ((int []) ((Object[])K.get(s2)))) == null)
                K.put(s2, ((Object) (new Object[] {
                    as[0], h.a
                })));
            else
                ai[0] = (String)ai[0] + "\n" + as[0];
        } else
        {
            if(ai == null)
                ai = c(s2, i1);
            ai.a(k2, as[0], i1);
        }
        if(I.containsKey(s2))
            break; /* Loop/switch isn't completed */
        ai = ((int []) (new Object[] {
            s2, h.a, null
        }));
        I.put(s2, ai);
        if(N != null)
            N.a(ai);
        return;
_L12:
        if(as.length <= 0)
        {
            return;
        } else
        {
            new i(this, as[0]);
            return;
        }
_L13:
        Object aobj[];
        Object aobj7[];
        if(as.length <= 0)
            return;
        ai = as;
        ai = ai;
        as = as[0];
        ai = this;
        aobj7 = (Object[])H.get(as);
        aobj7;
        aobj = aobj7;
        JVM INSTR ifnull 1134;
           goto _L14 _L15
_L14:
        try
        {
            ((a)aobj[5]).a();
        }
        catch(Exception _ex) { }
        aobj[5] = new a(ai, as, aobj);
_L15:
        return;
_L7:
        for(int j1 = 0; j1 < ai.length - 1 && j1 << 1 < as.length; j1++)
        {
            Object aobj3[];
            if((aobj3 = (Object[])H.get(as[j1 << 1])) == null)
                continue;
            String s3 = (j1 << 1) + 1 >= as.length ? null : as[(j1 << 1) + 1];
            a(aobj3, ai[j1 + 1], s3);
            if(O != null)
                O.a(((Object) (aobj3)), true);
        }

        if(L != null)
        {
            L.a(O.a());
            return;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if(ai.length < 2)
            break; /* Loop/switch isn't completed */
        for(int k1 = 1; k1 < ai.length; k1++)
        {
            g.c c1;
            if((c1 = (g.c)J.get(as[k1 - 1])) != null && c1.c != null)
                c1.c.a(ai[k1]);
        }

        return;
_L6:
        if(ai.length < 2)
            break; /* Loop/switch isn't completed */
        if(ai[1] == 0)
        {
            H.clear();
            for(int l1 = 0; l1 < as.length - 1; l1 += 2)
            {
                Object aobj4[] = {
                    as[l1], h.a, as[l1 + 1], null, null, null
                };
                H.put(as[l1], ((Object) (aobj4)));
            }

            if(O != null)
                O.a(H);
        } else
        if(ai[1] == 1)
        {
            if(ai.length < 3 || as.length < 2 || H.contains(as[0]))
                break; /* Loop/switch isn't completed */
            Object aobj1[] = {
                as[0], new Integer(ai[2]), "", null, null, null
            };
            a(aobj1, ai[2], as[1]);
            H.put(as[0], ((Object) (aobj1)));
            if(O != null)
                O.a(((Object) (aobj1)));
        } else
        if(ai[1] == -1)
        {
            if(as.length <= 0)
                return;
            Object aobj2[];
            if((aobj2 = (Object[])H.get(as[0])) == null)
                break; /* Loop/switch isn't completed */
            H.remove(as[0]);
            if(O != null)
                O.b(((Object) (aobj2)));
        }
        if(L != null)
        {
            L.a(O.a());
            return;
        }
        break; /* Loop/switch isn't completed */
_L8:
        for(int i2 = 0; i2 + 1 < as.length; i2 += 2)
            c(as[i2], as[i2 + 1]);

        q();
        return;
_L5:
        if(as.length <= 0)
        {
            return;
        } else
        {
            k(as[0]);
            return;
        }
_L11:
        z.clear();
        for(int j2 = 0; j2 < as.length; j2 += 2)
            z.put(as[j2], as[j2 + 1]);

        f();
        if(o != null)
        {
            U = o.getBackground();
            V = o.getForeground();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if(ai.length >= 2 && as.length >= 2)
        {
            r = as[0];
            s = as[1];
        }
    }

    public abstract void f();

    private void p()
    {
        f();
        q();
    }

    private void q()
    {
        v.show(this, "lounge");
    }

    private boolean a(String s1, boolean flag)
    {
        if(Integer.parseInt(getParameter(s1)) != 0)
            return true;
        return false;
        JVM INSTR pop ;
        return false;
    }

    private int b(String s1, int i1)
    {
        return Integer.parseInt(getParameter(s1));
        JVM INSTR pop ;
        return 1;
    }

    public final String a(String s1, String s2)
    {
        String s3 = null;
        try
        {
            s3 = getParameter(s1);
        }
        catch(Exception _ex) { }
        if(s3 != null)
            return s3;
        else
            return s2;
    }

    public final void g()
    {
        App app = null;
        app = this;
        if(P)
            try
            {
                Toolkit.getDefaultToolkit().beep();
                return;
            }
            catch(Throwable _ex) { }
    }

    public final void c(String s1)
    {
        if(s1.length() > 512)
            s1 = s1.substring(0, 512) + "...";
        b(new int[] {
            20
        }, new String[] {
            s1
        });
    }

    public final void b(String s1, String s2)
    {
        if(s2.length() > 512)
            s2 = s2.substring(0, 512) + "...";
        b(new int[] {
            21
        }, new String[] {
            s1, s2
        });
    }

    public final void a(String s1, int i1)
    {
        b(new int[] {
            25, i1
        }, new String[] {
            s1
        });
    }

    public final void d(String s1)
    {
        b(new int[] {
            23
        }, new String[] {
            s1
        });
    }

    public final void e(String s1)
    {
        b(new int[] {
            24
        }, new String[] {
            s1
        });
    }

    public final void b(int ai[], String as[])
    {
        if(x != null)
            x.a(ai, as);
    }

    public final void b(long l1)
    {
        if(x != null)
            x.a(l1);
    }

    public final void a(boolean flag)
    {
        if(flag)
        {
            flag = u >= j;
            u = -2;
            if(flag)
                b(true);
            return;
        } else
        {
            u = 0;
            return;
        }
    }

    public final void b(boolean flag)
    {
        if(f)
            b(new int[] {
                flag ? 63 : 64
            }, ((String []) (null)));
    }

    public boolean h()
    {
        return false;
    }

    public final void f(String s1)
    {
        b(new int[] {
            53
        }, new String[] {
            s1
        });
    }

    public final void g(String s1)
    {
        b(new int[] {
            61
        }, new String[] {
            s1
        });
    }

    public final void i()
    {
        App app;
        b(new int[] {
            52
        }, new String[] {
            "noi=" + ((app = this).Q ? "1" : "0") + "&nop=" + (app.R ? "1" : "0") + "&prb=" + (app.S ? "1" : "0") + "&snd=" + (app.P ? "1" : "0") + (app.t == null ? "" : "&" + app.t + "=" + (app.q ? "1" : "0")) + app.T
        });
    }

    public void c(String s1, String s2)
    {
        if(s1.equals("set_langsymbols"))
        {
            s1 = new StringTokenizer(s2);
            B = new String[s1.countTokens()];
            for(s2 = 0; s2 < B.length; s2++)
                B[s2] = "(" + s1.nextToken() + ")";

        }
    }

    public final void j()
    {
        if(aa != null)
            aa.setState(q);
        W.setState(Q);
        X.setState(R);
        Y.setState(S);
        Y.enable(!R);
        Z.setState(P);
    }

    public final void k()
    {
        Y.enable(!X.getState());
        Z.enable(h());
        W.enable(h());
    }

    public final void a(Component component)
    {
        Color color;
        if((color = getBackground()) != null)
            component.setBackground(color);
    }

    public void d(String s1, String s2)
    {
        boolean flag = s2.equals("1") || s2.equalsIgnoreCase("true");
        if(s1.equalsIgnoreCase("noi"))
        {
            Q = flag;
            return;
        }
        if(s1.equalsIgnoreCase("nop"))
        {
            R = flag;
            return;
        }
        if(s1.equalsIgnoreCase("prb"))
        {
            S = flag;
            return;
        }
        if(s1.equalsIgnoreCase("snd"))
        {
            P = flag;
            return;
        }
        boolean flag1 = false;
        if(t != null && s1.equalsIgnoreCase(t))
        {
            flag1 = true;
            q = flag;
        }
        if(!flag1 && s1.startsWith("_"))
            T += "&" + s1 + "=" + s2;
    }

    public final void l()
    {
        if(aa != null)
            q = aa.getState();
        Q = W.getState();
        R = X.getState();
        S = Y.getState();
        P = Z.getState();
    }

    private void k(String s1)
    {
        s1 = new StringTokenizer(s1, "&");
        T = "";
        do
        {
            if(!s1.hasMoreTokens())
                break;
            String s2;
            int i1;
            if((i1 = (s2 = s1.nextToken()).indexOf('=')) != -1)
            {
                String s3 = s2.substring(0, i1);
                s2 = s2.substring(i1 + 1);
                d(s3, c.n.a(s2, "%3F", "&"));
            }
        } while(true);
    }

    private void r()
    {
        int i1 = 0;
        Object obj = K.elements();
        do
        {
            if(!((Enumeration) (obj)).hasMoreElements())
                break;
            Object aobj[];
            if(((Integer)(aobj = (Object[])((Enumeration) (obj)).nextElement())[1]).intValue() > 0)
                i1++;
        } while(true);
        obj = b("bl_cs");
        o.setLabel(i1 != 0 ? obj + " (" + i1 + ")" : ((String) (obj)));
        o.getParent().getParent().validate();
        if(U != null && V != null)
        {
            o.setBackground(i1 <= 0 ? U : E);
            o.setForeground(i1 <= 0 ? V : F);
        }
    }

    public final void h(String s1)
    {
        g.c c1;
        if((c1 = (g.c)J.get(s1)) == null)
        {
            c(s1, 0);
            return;
        } else
        {
            c1.show();
            return;
        }
    }

    private g.c c(String s1, int i1)
    {
        g.c c1 = new g.c(this, s1);
        g.c c2 = c1;
        App app = this;
        J.put(c2.b, c2);
        app.b(new int[] {
            22, 1
        }, new String[] {
            c2.b
        });
        Object aobj[];
        if((aobj = (Object[])I.get(s1)) != null && aobj[1] == h.b)
            c1.a(1, "[\u25B6 " + b("chr") + "]", 0);
        Object aobj1[];
        if((aobj1 = (Object[])K.get(s1)) != null)
        {
            K.remove(s1);
            s1 = ((Integer)aobj1[1]).intValue();
            c1.a(0, (String)aobj1[0], ((int) (i1 != 0 ? 0 : ((int) (s1)))));
            if(s1 > 0)
            {
                if(aobj != null)
                {
                    aobj[2] = null;
                    if(N != null)
                        N.a(((Object) (aobj)), false);
                }
                r();
            }
        }
        c1.show();
        return c1;
    }

    final void i(String s1)
    {
        J.remove(s1);
        b(new int[] {
            22, 0
        }, new String[] {
            s1
        });
    }

    public void m()
    {
    }

    public final Panel a(Panel panel)
    {
        String s1;
        if((s1 = t) != null && !s1.equals("_bb"))
            s1 = null;
        panel.setLayout(new BorderLayout(0, 4));
        if(s1 != null)
            panel = c.n.a(panel = c.n.a(panel, c.n.a(new Component[] {
                aa = c.n.d(b("p_sympi"))
            }), 4), new x(0, new Dimension(250, 10), (byte)0), 4);
        return panel = c.n.a(panel = c.n.a(panel = c.n.a(panel = c.n.a(panel, c.n.a(new Component[] {
            W = c.n.d(b("p_igninv"))
        }), 4), c.n.a(new Component[] {
            X = c.n.d(b("p_ignprv"))
        }), 4), c.n.a(new Component[] {
            Y = c.n.d(b("p_prvbud"))
        }), 4), c.n.a(new Component[] {
            Z = c.n.d(b("p_bp"))
        }), 4);
    }

    public void j(String s1)
    {
    }

    public boolean action(Event event, Object obj)
    {
        if(event.target == p)
        {
            if(M == null)
                M = new g.j(this);
            M.show();
            return true;
        }
        if(event.target == n)
        {
            if(L == null)
            {
                L = new b(this);
                (O = L.b).a(H);
                L.a(O.a());
            }
            L.show();
        } else
        if(event.target == o)
        {
            if(l == null)
            {
                l = new d(this);
                (N = l.b).a(I);
            }
            l.show();
        }
        return super.action(event, obj);
    }

    public void n()
    {
        g.c c1;
        for(Enumeration enumeration = J.elements(); enumeration.hasMoreElements(); (c1 = (g.c)enumeration.nextElement()).a());
        try
        {
            M.a();
        }
        catch(Exception _ex) { }
        try
        {
            L.a();
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public final String a(int i1)
    {
        if(B == null)
            return null;
        if(i1 >= 0 && i1 < B.length)
            return B[i1];
        else
            return null;
    }

    public final int b(int i1)
    {
        if(d != null)
            return 1 + d[i1];
        else
            return 0;
    }

    public final String c(int i1)
    {
        if(i1 == 0)
            return "-";
        else
            return String.valueOf(i1);
    }

    public final String d(int i1)
    {
        if(i1 < 0)
            return "";
        int j1 = i1 / 1000;
        i1 %= 1000;
        if(j1 == 0 && i1 == 0)
            return "?";
        else
            return (j1 * 5) / 10 + "." + (j1 * 5) % 10;
    }

    Label a;
    private CardLayout v;
    private g.g w;
    private g.g x;
    public String b;
    private int y[] = {
        17001, 443, 23
    };
    private Hashtable z;
    private Hashtable A;
    public Color c[];
    public int d[];
    private String B[];
    private boolean C;
    public boolean e;
    public boolean f;
    private boolean D;
    public boolean g;
    public boolean h;
    public Panel i;
    private static Color E = new Color(240, 32, 16);
    private static Color F = new Color(240, 240, 240);
    public static int j = 2;
    public static int k = 6;
    private static int G = 20;
    private Hashtable H;
    private Hashtable I;
    private Hashtable J;
    private Hashtable K;
    private b L;
    public d l;
    private g.j M;
    private f N;
    private c O;
    public e m;
    public Button n;
    public Button o;
    public Button p;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    public boolean q;
    public String r;
    public String s;
    private String T;
    public String t;
    private Color U;
    private Color V;
    private Checkbox W;
    private Checkbox X;
    private Checkbox Y;
    private Checkbox Z;
    private Checkbox aa;
    private String ab[];
    private int ac;
    private int ad;
    public int u;

}
