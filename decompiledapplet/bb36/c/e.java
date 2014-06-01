// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import g.c;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.*;

// Referenced classes of package c:
//            d, h, j, m, 
//            n

public final class e extends Canvas
    implements ActionListener, AdjustmentListener
{

    public e(App app, Scrollbar scrollbar, TextField textfield, int i1, int j1, int k1, int l1)
    {
        r = g;
        s = h;
        w = 6;
        G = true;
        H = true;
        I = false;
        J = false;
        b = "";
        K = new Vector();
        L = new Vector();
        k = c.n.a(i1);
        l = c.n.a(j1);
        x = k1;
        y = l1;
        a = textfield;
        n = app;
        E = 100;
        if(scrollbar != null)
        {
            m = scrollbar;
            m.addAdjustmentListener(this);
            e();
        }
        setBackground(Color.white);
        if(i == null)
            i = DateFormat.getDateInstance();
        if(j == null)
            j = DateFormat.getTimeInstance(3);
    }

    public static Component[] a(App app, int i1, boolean flag, int j1)
    {
        (flag = new Panel()).setLayout(new BorderLayout(0, 3));
        TextField textfield;
        (textfield = new TextField()).setFont(c.n.a(1));
        if(j1 == 1)
        {
            (j1 = new Panel()).setLayout(new BorderLayout(0, 0));
            j1.add("Center", textfield);
            j1.add("East", new d());
            flag.add("South", j1);
        } else
        if(j1 == 0)
            flag.add("South", textfield);
        j1 = new Scrollbar();
        app = new e(app, j1, textfield, 1, 3, i1, d);
        flag.add("Center", app);
        flag.add("East", j1);
        return (new Component[] {
            flag, app
        });
    }

    public final void a(c c1)
    {
        q = c1;
    }

    public final void actionPerformed(ActionEvent actionevent)
    {
        a();
    }

    public final void adjustmentValueChanged(AdjustmentEvent adjustmentevent)
    {
        if(adjustmentevent.getSource() == m && m != null)
        {
            synchronized(this)
            {
                t = m.getValue();
            }
            repaint();
        }
    }

    public final void a()
    {
        if(p != null)
            p.dispose();
        p = new h(n, 1, new String[] {
            b
        }, false, null);
    }

    private int a(String s1, boolean flag)
    {
        if(F == null)
            return 0;
        flag = null;
        int i1 = 0;
        if(!I && s1.startsWith("** "))
        {
            L.addElement(flag = r);
            L.addElement(f);
        } else
        if(!I && s1.startsWith("[") && s1.endsWith("]") && L.size() == 0)
        {
            L.addElement(flag = s);
            L.addElement(f);
            J = true;
            s1 = s1.substring(1, s1.length() - 1);
        } else
        {
            L.addElement(null);
            int j1;
            if((j1 = I ? -1 : s1.indexOf(':')) == -1)
            {
                L.addElement(f);
            } else
            {
                String s2 = s1.substring(0, j1 + 1);
                L.addElement(s2);
                i1 = 0 + F[1].stringWidth(s2);
                s1 = (n.h ? "" : " ") + s1.substring(j1 + 1).trim() + (n.h ? " " : "");
            }
        }
        int l1 = 0;
        int k1;
        while((k1 = s1.length()) > 0) 
        {
            if(i1 + F[0].stringWidth(s1) >= u - 2 * w)
                if((k1 = c.m.a(s1, F[0], u - 2 * w - i1)) > 0)
                {
                    if((i1 = s1.lastIndexOf(' ', k1)) < k1)
                    {
                        int i2;
                        i2 = (i2 = s1.indexOf(' ', k1 + 1)) >= 0 ? i2 : s1.length();
                        if(F[0].stringWidth(s1.substring(i1 + 1, i2)) < u - 2 * w - y)
                            k1 = i1 + 1;
                    }
                } else
                if(c.m.a(s1, F[0], u - 2 * w - y) == 0)
                    k1 = 1;
            if(l1 > 0)
            {
                L.addElement(flag);
                L.addElement(e);
            }
            L.addElement(s1.substring(0, k1));
            s1 = s1.substring(k1).trim();
            l1++;
            i1 = y;
        }
        return l1;
    }

    public final void a(String s1)
    {
        String s2 = i.format(new Date());
        synchronized(this)
        {
            boolean flag = t >= (M * C + c) - v || v == 0;
            s1 = new StringTokenizer(s1, "\n");
            do
            {
                if(!s1.hasMoreTokens())
                    break;
                String s3;
                if(!(s3 = s1.nextToken()).equals(""))
                {
                    if(!I && s3.startsWith("** [") && s3.endsWith("]"))
                        try
                        {
                            Date date = new Date(Long.parseLong(s3.substring(4, s3.length() - 1)) * 1000L);
                            String s4;
                            if((s4 = i.format(date)).equals(s2))
                                s4 = j.format(date);
                            s3 = "** " + s4;
                        }
                        catch(Exception _ex) { }
                    K.addElement(s3);
                    b += s3 + "\n";
                    M += a(s3, true);
                }
            } while(true);
            if(((e) (s1 = this)).G && (flag || t > (M * C + c) - v))
                t = (M * C + c) - v;
            if(t < 0)
                t = 0;
        }
        e();
        repaint();
    }

    public final void b()
    {
        K.removeAllElements();
        J = false;
        b = "";
        if(m != null)
            m.setValue(t = 0);
        d();
        e();
        repaint();
    }

    public final boolean mouseDown(Event event, int i1, int j1)
    {
        if(!event.metaDown())
        {
            if(J && t + j1 < C && L.size() > 2)
            {
                J = false;
                L.setElementAt("...", 2);
                L.setElementAt(null, 0);
                if(K.size() > 0)
                {
                    b = b.substring(((String)K.elementAt(0)).length());
                    K.setElementAt("...", 0);
                }
                if(q != null)
                    q.b();
                repaint();
            }
            return true;
        }
        if(o == null)
        {
            o = new PopupMenu();
            o.setFont(c.n.a(1));
            (event = new MenuItem("copy")).addActionListener(this);
            o.add(event);
            add(o);
        }
        o.show(this, i1, j1);
        return true;
    }

    public final void paint(Graphics g1)
    {
        Object obj = getSize();
        if(z == null || ((Dimension) (obj)).width != u || ((Dimension) (obj)).height != v)
        {
            synchronized(this)
            {
                boolean flag = t >= (M * C + c) - v || v == 0;
                u = ((Dimension) (obj)).width;
                v = ((Dimension) (obj)).height;
                if(z == null || B < u)
                {
                    if(z != null)
                        z.dispose();
                    if(C == 0 || F == null)
                    {
                        F = new FontMetrics[2];
                        g1.setFont(k);
                        F[0] = g1.getFontMetrics();
                        g1.setFont(l);
                        F[1] = g1.getFontMetrics();
                        C = ((c.n.a(F[0]) + 2) * E) / 100;
                        D = c.n.a(C, F[0]);
                    }
                    A = createImage(u, C);
                    z = A.getGraphics();
                    B = u;
                    int _tmp = C;
                }
                if(m != null)
                {
                    m.setUnitIncrement(C);
                    m.setBlockIncrement(C * 5);
                }
                d();
                if(((e) (obj = this)).G && (flag || t > (M * C + c) - v))
                    t = (M * C + c) - v;
                if(t < 0)
                    t = 0;
            }
            e();
        }
        synchronized(this)
        {
            int j1 = (t / C) * 3;
            int i1 = -(t % C);
            z.setFont(k);
            for(; i1 < v; i1 += C)
            {
                z.setColor(getBackground());
                z.fillRect(0, 0, u, C);
                if(j1 < L.size() - 2)
                {
                    z.setColor(Color.black);
                    int k1 = w;
                    Color color = (Color)L.elementAt(j1++);
                    String s1 = (String)L.elementAt(j1++);
                    String s2 = (String)L.elementAt(j1++);
                    if(color != null)
                        z.setColor(color);
                    if(s1 == e)
                        k1 += y;
                    else
                    if(s1 != f)
                    {
                        z.setFont(l);
                        int l1 = F[1].stringWidth(s1);
                        z.drawString(s1, n.h ? u - k1 - l1 : k1, D);
                        k1 += l1;
                        z.setFont(k);
                    }
                    if(!n.h)
                        z.drawString(s2, k1, D + (color != s ? 0 : 1));
                    else
                        z.drawString(s2, u - k1 - F[0].stringWidth(s2), D);
                    if(color != null)
                        z.setColor(Color.black);
                }
                if(H)
                {
                    z.setColor(n.g);
                    z.drawLine(0, 0, 0, C);
                    z.drawLine(u - 1, 0, u - 1, C);
                    if(i1 <= 0)
                        z.drawLine(0, 0 - i1, u - 1, 0 - i1);
                    if(i1 >= v - C)
                        z.drawLine(0, v - i1 - 1, u - 1, v - i1 - 1);
                    z.setColor(Color.white);
                    if(i1 <= 1)
                        z.drawLine(1, 1 - i1, u - 2, 1 - i1);
                    if(i1 >= v - C - 1)
                        z.drawLine(1, v - i1 - 2, u - 2, v - i1 - 2);
                }
                g1.drawImage(A, 0, i1, null);
            }

        }
    }

    public final Dimension preferredSize()
    {
        return new Dimension(super.preferredSize().width, x);
    }

    public final void c()
    {
        try
        {
            ((Panel)a.getParent()).remove(a);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    private void d()
    {
        L.removeAllElements();
        M = 0;
        int i1 = 0;
        for(int j1 = K.size(); i1 < j1; i1++)
            M += a((String)K.elementAt(i1), true);

    }

    public final void a(boolean flag)
    {
        I = true;
    }

    public final void b(boolean flag)
    {
        G = false;
    }

    public final void a(int i1)
    {
        E = 90;
    }

    public final void b(int i1)
    {
        w = 0;
    }

    public final void c(boolean flag)
    {
        H = false;
    }

    public final void update(Graphics g1)
    {
        if(g1 == null)
        {
            return;
        } else
        {
            paint(g1);
            return;
        }
    }

    private void e()
    {
        if(m != null)
            m.setValues(t, v, 0, M * C + c);
    }

    private static int c = 3;
    private static int d = 14;
    private static String e = "";
    private static String f = "-";
    private static Color g = new Color(32, 48, 80);
    private static Color h = new Color(32, 32, 32);
    private static DateFormat i;
    private static DateFormat j;
    private Font k;
    private Font l;
    private Scrollbar m;
    public TextField a;
    private App n;
    private PopupMenu o;
    private h p;
    private c q;
    private Color r;
    private Color s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Graphics z;
    private Image A;
    private int B;
    private int C;
    private int D;
    private int E;
    private FontMetrics F[];
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    public String b;
    private Vector K;
    private Vector L;
    private int M;

}
