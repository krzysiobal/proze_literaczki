// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;

public final class x extends Canvas
{

    public x(int l, Color color)
    {
        f = 3;
        g = 0;
        i = -1;
        i = l;
        e = color;
    }

    public x(int l, Dimension dimension, int i1)
    {
        this(l);
        d = dimension;
        j = i1;
    }

    private x(int l, Dimension dimension)
    {
        this(l, dimension, l != 0 ? dimension.width / 2 : dimension.height / 2);
    }

    public x(int l, Dimension dimension, byte byte0)
    {
        this(l, dimension);
    }

    public x(int l)
    {
        this(l, Color.white);
    }

    public x(Color color)
    {
        f = 3;
        g = 0;
        i = -1;
        e = color;
        d = b;
    }

    public x(Dimension dimension, int l)
    {
        f = 3;
        g = 0;
        i = -1;
        d = dimension;
        h = 2;
        setForeground(Color.black);
    }

    public final void a(int l, int i1)
    {
        f = 1;
        g = 2;
    }

    public final Dimension minimumSize()
    {
        if(i == -1 || d == null)
            return super.minimumSize();
        else
            return d;
    }

    public final void paint(Graphics g1)
    {
        Dimension dimension = getSize();
        if(i != -1)
        {
            g1.setColor(e);
            if(i == 0)
            {
                for(int i1 = 0; i1 < dimension.width; i1 += f)
                    g1.drawLine(i1, j, i1, j + g);

                return;
            }
            if(i == c)
            {
                for(int j1 = 0; j1 < dimension.height; j1 += 3)
                    g1.drawLine(j, j1, j, j1);

                return;
            }
        } else
        {
            if(e != null)
            {
                Color color = getBackground();
                int l1 = dimension.height;
                if(color != null)
                {
                    g1.setColor(color);
                    g1.fillRect(l1, 0, dimension.width - dimension.height, dimension.height);
                }
                g1.setColor(Color.black);
                g1.drawRect(0, 0, dimension.height - 1, dimension.height - 1);
                g1.drawRect(1, 1, dimension.height - 3, dimension.height - 3);
                g1.setColor(e);
                g1.fillRect(2, 2, dimension.height - 4, dimension.height - 4);
                return;
            }
            Color color1;
            if((color1 = getBackground()) != null)
            {
                g1.setColor(color1);
                g1.fillRect(0, 0, dimension.width, dimension.height);
            }
            if(!k)
                return;
            for(int i2 = 0; i2 < 2; i2++)
            {
                g1.setColor(i2 != 0 ? Color.white : Color.black);
                for(int l = 0; l < d.height - (i2 << 1); l++)
                {
                    int k1 = l >= (d.height - (i2 << 1) - (d.width - (i2 << 1) - h) / 2) + i2 ? d.height - (i2 << 1) - 1 - l : ((d.width - (i2 << 1) - h) + 1) / 4 - 1;
                    g1.drawLine((i2 + h + (d.width - h - (i2 << 1)) / 2) - k1, i2 + l, i2 + h + (d.width - h - (i2 << 1)) / 2 + k1, i2 + l);
                }

            }

        }
    }

    public final Dimension preferredSize()
    {
        if(d != null)
        {
            return d;
        } else
        {
            Dimension dimension = super.minimumSize();
            return new Dimension(i != 0 ? 1 : dimension.width, i != c ? 1 : dimension.height);
        }
    }

    public final void a(Color color)
    {
        if(e == color)
            return;
        e = color;
        if(i == -1)
            repaint();
    }

    public final void a(boolean flag)
    {
        k = flag;
        repaint();
    }

    public final void update(Graphics g1)
    {
        paint(g1);
    }

    private static Dimension b = new Dimension(16, 1);
    public static int a = 0;
    private static int c = 1;
    private Dimension d;
    private Color e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;

}
