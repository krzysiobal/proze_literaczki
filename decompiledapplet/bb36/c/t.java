// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;


// Referenced classes of package c:
//            u

public final class t extends Thread
{

    public t(u u1, int i)
    {
        a = true;
        e = i;
        b = u1;
        f = -1;
        start();
    }

    public t(u u1)
    {
        this(u1, 4);
    }

    public final void a(int i, int j, int k)
    {
        c = System.currentTimeMillis();
        f = i;
        g = j;
        h = k;
    }

    public final void a()
    {
        f = -1;
    }

    public final long b()
    {
        return System.currentTimeMillis() - c;
    }

    public final void run()
    {
        long l = -1L;
        int i = -1;
        int j = 0;
        while(a) 
        {
            long l1;
            if((l1 = System.currentTimeMillis()) / 1000L != l)
            {
                b.a(l1);
                l = l1 / 1000L;
            }
            b.b();
            if(0L > 0L && l1 > 0L)
            {
                d = 0L;
                u _tmp = b;
            }
            long l2;
            if(f != -1 && ((l2 = (int)(((long)(g * 200) + (long)(h <= 0 ? -1 : 1) * (l1 - c) + (long)(h <= 0 ? 750 : '\0')) / 1000L)) != (long)j || f != i))
            {
                b.a(f, (int)l2);
                j = (int)l2;
                i = f;
            }
            try
            {
                Thread.sleep((long)(1000 / e) - l1 % (long)(1000 / e));
            }
            catch(Exception _ex) { }
        }
    }

    public boolean a;
    private u b;
    private long c;
    private long d;
    private int e;
    private int f;
    private int g;
    private int h;
}
