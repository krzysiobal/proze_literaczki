// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.j;
import g.App;

// Referenced classes of package g.m:
//            AppMulti, h

public abstract class f extends j
{

    public f(App app, String s1)
    {
        super(app, s1);
        p = -1;
        r = null;
    }

    public final boolean m()
    {
        return (m & 8) != 0;
    }

    public final boolean n()
    {
        return (m & 4) != 0;
    }

    final boolean o()
    {
        f f1;
        return n() && (!r() || r() && !s()) && (i.e() && h.v >= i.a() || (((f1 = this).l & 2) != 0)) && !z();
    }

    public final void b(String s1)
    {
        if(s1.length() > 512)
            s1 = s1.substring(0, 512) + "...";
        c(new int[] {
            81, o
        }, new String[] {
            s1
        });
    }

    public final boolean p()
    {
        return (m & 0x10) != 0;
    }

    public final boolean q()
    {
        return s() && !n() && !m();
    }

    public final boolean r()
    {
        return (m & 2) != 0;
    }

    public final boolean s()
    {
        return (m & 1) != 0;
    }

    public final int t()
    {
        return n;
    }

    public static String c(int i1)
    {
        return "#" + (i1 + 1);
    }

    public final String c(String s1)
    {
        return h.b(s1);
    }

    public static boolean u()
    {
        return true;
    }

    public static void v()
    {
    }

    public final void c(int ai[], String as[])
    {
        h.b(ai, as);
    }

    public final void a(String s1, int i1)
    {
        c(new int[] {
            82, o, i1
        }, new String[] {
            s1
        });
    }

    public final boolean w()
    {
        return (l & 8) != 0;
    }

    public final boolean x()
    {
        return (l & 1) != 0;
    }

    final boolean y()
    {
        return (l & 0x10) != 0;
    }

    public final boolean z()
    {
        return (l & 4) != 0;
    }

    public AppMulti h;
    public h i;
    boolean j;
    boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public String r;
}
