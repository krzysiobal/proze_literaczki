// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import g.App;

public final class h
{

    public h(App app, int ai[], int i, int j, String as[], int k, int l)
    {
        e = app;
        ai[2] %= 16;
        b = new int[j];
        for(app = 0; app < j; app++)
            b[app] = ai[i + app];

        a = new String[l];
        for(app = 0; app < l; app++)
        {
            ai = as[k + app].indexOf('/');
            a[app] = ai >= 0 ? as[k + app].substring(0, ai) : as[k + app];
        }

        c = String.valueOf(b[1]);
        d = "#" + c;
    }

    public final int a()
    {
        if(b[2] > 2)
        {
            if((b[2] - 3) % 2 == 0)
                return e.b(1 + (b[2] - 3) / 2);
            else
                return (e.b(1 + (b[2] - 3) / 2) + e.b(1 + (b[2] - 3) / 2 + 1)) / 2;
        } else
        {
            return 0;
        }
    }

    public final int b()
    {
        int i = 0;
        for(int j = 3; j < b.length; j++)
            if(b[j] == 0)
                i++;

        return i;
    }

    public final int c()
    {
        int i = 0;
        for(int j = 3; j < b.length; j++)
            if(b[j] == 1 || b[j] == 2)
                i++;

        return i;
    }

    public final String a(int i)
    {
        return a[i + 1];
    }

    public final int b(int i)
    {
        return b[i + 3];
    }

    public final boolean d()
    {
        return b[2] == 2;
    }

    public final boolean c(int i)
    {
        return b[2] == 0 || b[2] >= 3 && i >= a();
    }

    public final boolean e()
    {
        return b[2] == 0 || b[2] >= 3;
    }

    public final void a(int ai[], String as[])
    {
        if(ai.length < 3)
            return;
        ai[2] %= 16;
        b = ai;
        a = as;
        for(ai = 0; ai < a.length; ai++)
            if((as = a[ai].indexOf('/')) >= 0)
                a[ai] = a[ai].substring(0, as);

    }

    String a[];
    int b[];
    public String c;
    public String d;
    private App e;
}
