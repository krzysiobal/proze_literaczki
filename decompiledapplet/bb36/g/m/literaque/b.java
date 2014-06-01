// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m.literaque;

import g.App;
import g.m.AppMulti;
import java.awt.*;
import java.util.StringTokenizer;

// Referenced classes of package g.m.literaque:
//            a

public final class b extends Canvas
{

    public b(AppMulti appmulti, a a1, Image image, Image image1, Image aimage[], String s)
    {
        j = a1;
        b = image;
        c = image1;
        a = new Image[aimage.length];
        for(a1 = 0; a1 < aimage.length; a1++)
            a[a1] = aimage[a1];

        a1 = new StringTokenizer(s);
        i = new int[a1.countTokens()];
        for(image = 0; image < i.length; image++)
            i[image] = 1;

        image = 0;
        do
        {
            if(!a1.hasMoreTokens())
                break;
            image1 = a1.nextToken();
            aimage = 1;
            try
            {
                aimage = Integer.parseInt(image1);
            }
            catch(Exception _ex) { }
            i[image++] = aimage;
        } while(image < i.length);
        e = a[1].getWidth(this);
        f = a[1].getHeight(this);
        d = -1;
        g = 8;
        h = 1 + (i.length - 1) / g;
        appmulti.a(this);
    }

    private int a(int i1, int j1)
    {
        if(i1 < 0 || i1 >= g * e || j1 < 0 || j1 >= h * f)
            return -1;
        if((i1 = i1 / e + g * (j1 / f)) < a.length - 2)
            return i1;
        else
            return -1;
    }

    public final boolean mouseDown(Event event, int i1, int j1)
    {
        if(d != -1)
            j.a(i[d]);
        return true;
    }

    public final boolean mouseEnter(Event event, int i1, int j1)
    {
        if((event = a(i1, j1)) != d)
        {
            d = event;
            repaint();
        }
        return true;
    }

    public final boolean mouseExit(Event event, int i1, int j1)
    {
        if((event = a(i1, j1)) != d)
        {
            d = event;
            repaint();
        }
        return true;
    }

    public final boolean mouseMove(Event event, int i1, int j1)
    {
        event = a(i1, j1);
        if(d != event)
        {
            d = event;
            repaint();
        }
        return true;
    }

    public final void paint(Graphics g1)
    {
        if(k == null || l == null)
        {
            l = createImage(e, f);
            k = l.getGraphics();
        }
        for(int i1 = 0; i1 < i.length; i1++)
        {
            k.drawImage(i1 != d ? b : c, 0, 0, this);
            k.drawImage(a[i[i1]], 0, 0, this);
            g1.drawImage(l, e * (i1 % 8), f * (i1 / 8), this);
        }

    }

    public final Dimension preferredSize()
    {
        return new Dimension(a[1].getWidth(this) * g, a[1].getHeight(this) * h);
    }

    public final void update(Graphics g1)
    {
        paint(g1);
    }

    private Image a[];
    private Image b;
    private Image c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i[];
    private a j;
    private Graphics k;
    private Image l;
}
