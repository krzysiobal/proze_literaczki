// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import java.io.*;
import java.net.Socket;

// Referenced classes of package g:
//            App, f

public final class g
    implements Runnable
{

    public g(App app, String s, int l, int ai[], String as[])
    {
        k = app;
        b = s;
        c = l;
        e = ai;
        f = as;
        (new Thread(this)).start();
    }

    public final void a(long l)
    {
        long l1;
        if((l1 = (l - d) / 1000L) > 30L)
            a(null, null);
    }

    public final void a()
    {
        try
        {
            h.close();
            return;
        }
        catch(Exception _ex)
        {
            g = false;
        }
    }

    private static int a(String s)
    {
        int l = 0;
        for(int i1 = s.length() - 1; i1 >= 0; i1--)
        {
            char c1;
            if((c1 = s.charAt(i1)) == 0)
            {
                l += 2;
                continue;
            }
            if(c1 < '\177')
            {
                l++;
                continue;
            }
            if(c1 < '\u07FF')
                l += 2;
            else
                l += 3;
        }

        return l;
    }

    public final int b()
    {
        return c;
    }

    private static Object[] a(DataInputStream datainputstream)
    {
        int ai[] = null;
        String as[] = null;
        try
        {
            int l = datainputstream.readInt();
            short word0 = datainputstream.readShort();
            short word1 = datainputstream.readShort();
            int i1 = 8 + (word0 << 1);
            ai = new int[word0];
            for(int j1 = 0; j1 < word0; j1++)
                ai[j1] = datainputstream.readShort();

            word0 = new String[word1];
            for(int k1 = 0; k1 < word1; k1++)
            {
                word0[k1] = datainputstream.readUTF();
                datainputstream.readByte();
                i1 += a(word0[k1]) + 3;
            }

            for(int l1 = 0; l1 < l - i1; l1++)
                datainputstream.readByte();

        }
        catch(Exception _ex)
        {
            return null;
        }
        return (new Object[] {
            ai, word0
        });
    }

    public final void run()
    {
        k.a(this, k.a("msg_connecting", "..."));
        try
        {
            Thread.sleep(100L);
        }
        catch(Exception _ex) { }
        (new f(k, this)).start();
        h = null;
        try
        {
            h = new Socket(b, c);
            j = new DataOutputStream(new BufferedOutputStream(h.getOutputStream()));
            i = new DataInputStream(new BufferedInputStream(h.getInputStream()));
        }
        catch(Exception _ex)
        {
            h = null;
        }
        if(h == null)
        {
            k.a(this, -1);
            return;
        }
        if(!k.a(this, 1))
        {
            a();
            return;
        }
        g = true;
        a = null;
        a(e, f);
        do
        {
            Object aobj[];
            if(!g || (aobj = a(i)) == null)
                break;
            try
            {
                String as[] = (String[])aobj[1];
                int ai[] = (int[])aobj[0];
                g g1 = this;
                d = System.currentTimeMillis();
                if(ai.length != 0)
                    switch(ai[0])
                    {
                    case -1: 
                        if(as.length > 0)
                            g1.a = as[0];
                        g1.g = false;
                        break;

                    case 1: // '\001'
                        App _tmp = g1.k;
                        App.e();
                        g1.a(null, null);
                        break;

                    default:
                        if(g1.k != null)
                            g1.k.a(ai, as);
                        break;
                    }
            }
            catch(Exception _ex) { }
        } while(true);
        a();
        k.a(this, 0);
    }

    public final void a(int ai[], String as[])
    {
        String as1[] = as;
        int l = as != null ? as.length : 0;
        int ai1[] = ai;
        as = ai != null ? ((String []) (ai.length)) : 0;
        ai = this;
        if(g)
        {
            if(a(((g) (ai)).j, as, ai1, l, as1) == 0)
                ai.g = false;
            ai.d = System.currentTimeMillis();
        }
    }

    private static synchronized int a(DataOutputStream dataoutputstream, int l, int ai[], int i1, String as[])
    {
        int j1;
        j1 = 8 + (l << 1);
        for(int k1 = 0; k1 < i1; k1++)
            j1 += a(as[k1]) + 3;

        dataoutputstream.writeInt(j1);
        dataoutputstream.writeShort(l);
        dataoutputstream.writeShort(i1);
        for(int l1 = 0; l1 < l; l1++)
            dataoutputstream.writeShort(ai[l1]);

        for(int i2 = 0; i2 < i1; i2++)
        {
            dataoutputstream.writeUTF(as[i2]);
            dataoutputstream.writeByte(0);
        }

        dataoutputstream.flush();
        return j1;
        JVM INSTR pop ;
        return 0;
    }

    private String b;
    private int c;
    private long d;
    private int e[];
    private String f[];
    public String a;
    private boolean g;
    private Socket h;
    private DataInputStream i;
    private DataOutputStream j;
    private App k;
}
