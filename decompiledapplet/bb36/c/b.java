// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;
import java.awt.image.*;

public abstract class b extends Canvas
    implements Runnable
{

    public b()
    {
        i = new Object();
    }

    public void a(Graphics g1, Dimension dimension)
    {
        g1.drawImage(c, Math.max(0, (dimension.width - e) / 2), Math.max(0, (dimension.height - f) / 2), null);
    }

    public final void a(Image aimage[])
    {
        MediaTracker mediatracker = new MediaTracker(this);
        for(int k = 0; k < aimage.length; k++)
            mediatracker.addImage(aimage[k], 0);

        try
        {
            mediatracker.waitForAll(60000L);
            return;
        }
        catch(Exception _ex)
        {
            return;
        }
    }

    public static int[] a(Image aimage[], int k, int l)
    {
        k = new int[aimage.length * 34 * 34];
        for(l = 0; l < aimage.length; l++)
        {
            PixelGrabber pixelgrabber;
            (pixelgrabber = new PixelGrabber(aimage[l], 0, 0, 34, 34, k, l * 34, aimage.length * 34)).setColorModel(ColorModel.getRGBdefault());
            try
            {
                pixelgrabber.grabPixels();
            }
            catch(Exception _ex) { }
        }

        return k;
    }

    public void a()
    {
        if(d == null || a > e || b > f)
        {
            e = a;
            f = b;
            if(d != null)
                d.dispose();
            c = createImage(e, f);
            d = c.getGraphics();
        }
    }

    public void paint(Graphics g1)
    {
        Dimension dimension = getSize();
        boolean flag = true;
        if(dimension.width != a || dimension.height != b)
        {
            a = dimension.width;
            b = dimension.height;
            j = true;
            if(d != null)
                synchronized(i)
                {
                    h = System.currentTimeMillis() + 250L;
                    if(g == null)
                        (g = new Thread(this)).start();
                    flag = false;
                }
        }
        if(flag && j && System.currentTimeMillis() >= h)
        {
            j = false;
            b();
            a();
        }
        a(g1, dimension);
    }

    public void b()
    {
    }

    public void run()
    {
_L2:
        long l1;
label0:
        {
            long l = System.currentTimeMillis();
            l1 = 0L;
            synchronized(i)
            {
                if((l1 = h - l) >= 0L)
                    break label0;
                g = null;
            }
            break; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_50;
        exception;
        throw exception;
        try
        {
            Thread.sleep(l1);
        }
        catch(Exception _ex) { }
        if(true) goto _L2; else goto _L1
_L1:
        repaint();
        return;
    }

    public final void a(int ai[], Image aimage[], int k, int l, int i1, int j1, int k1, 
            int l1, int i2)
    {
        l = new int[j1 * k1];
        i1 = new MediaTracker(this);
        MemoryImageSource memoryimagesource = new MemoryImageSource(j1, k1, l, 0, j1);
        int j2 = k * 34;
        double d1 = 34D / (double)j1;
        double d2 = 34D / (double)k1;
        double d3 = d1 * d2;
        double d4 = d1 <= 1.0D ? d1 : 1.0D;
        double d5 = d2 <= 1.0D ? d2 : 1.0D;
        double ad[] = new double[4];
        int ai1[] = new int[4];
        for(int k2 = 0; k2 < k; k2++)
        {
            for(int l2 = 0; l2 < k1; l2++)
            {
                for(int i3 = 0; i3 < j1; i3++)
                {
                    double d6 = (double)i3 * d1;
                    double d7 = (double)l2 * d2;
                    int j3 = (int)d6;
                    int k3 = (int)d7;
                    int l3 = (int)((d6 + d1) - 1E-008D);
                    int i4 = (int)((d7 + d2) - 1E-008D);
                    for(int j4 = 0; j4 < 4; j4++)
                        ad[j4] = 0.0D;

                    int k4 = k3 * j2 + k2 * 34;
                    for(k3 = k3; k3 <= i4; k3++)
                    {
                        double d8 = k3;
                        for(int l4 = j3; l4 <= l3; l4++)
                        {
                            double d9;
                            double d10;
                            if((d9 = l4) < d6)
                                d10 = 1.0D * (d9 + 1.0D < d6 + d1 ? (d9 + 1.0D) - d6 : d4);
                            else
                                d10 = 1.0D * (d9 + 1.0D > d6 + d1 ? (d6 + d1) - d9 : d4);
                            if(d8 < d7)
                                d10 *= d8 + 1.0D < d7 + d2 ? (d8 + 1.0D) - d7 : d5;
                            else
                                d10 *= d8 + 1.0D > d7 + d2 ? (d7 + d2) - d8 : d5;
                            int i5 = ai[k4 + l4];
                            if(l1 != 0 && i5 >>> 24 == 0)
                                i5 = l1;
                            for(int j5 = 0; j5 < 4; j5++)
                                ad[j5] += (double)(i5 >>> (j5 << 3) & 0xff) * d10;

                        }

                        k4 += j2;
                    }

                    for(k3 = 0; k3 < 4; k3++)
                        ai1[k3] = (int)Math.round(ad[k3] / d3);

                    k3 = ai1[0] | ai1[1] << 8 | ai1[2] << 16;
                    l[l2 * j1 + i3] = k3 | ((k3 | 0xff000000) == l1 || ai1[3] <= i2 ? 0 : 255) << 24;
                }

            }

            aimage[k2] = Toolkit.getDefaultToolkit().createImage(memoryimagesource);
            i1.addImage(aimage[k2], 0);
            try
            {
                i1.waitForAll();
            }
            catch(Exception _ex) { }
            i1.removeImage(aimage[k2]);
        }

    }

    public void update(Graphics g1)
    {
        paint(g1);
    }

    public int a;
    public int b;
    private int e;
    private int f;
    public Image c;
    public Graphics d;
    private Thread g;
    private long h;
    private Object i;
    private boolean j;

    static 
    {
        new Color(250, 0, 4);
    }
}
