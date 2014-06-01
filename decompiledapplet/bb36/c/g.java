// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;

// Referenced classes of package c:
//            n

public final class g extends Canvas
{

    public g(String s)
    {
        d = -1;
        c = s;
        n.a(1);
        e = n.a(3);
    }

    public final void a(int i)
    {
        d = i;
        repaint();
    }

    public final void paint(Graphics g1)
    {
        Dimension dimension;
        int j = (dimension = getSize()).height;
        java.awt.FontMetrics fontmetrics;
        int k = n.a(fontmetrics = g1.getFontMetrics());
        g1.clearRect(0, 0, dimension.width - 1, dimension.height - 1);
        int i = k - 6;
        k = (j - i) / 2;
        if(d > 0)
        {
            g1.setColor(Color.white);
            g1.fillRect(1, k - 3, i + 9, i + 7);
            g1.setColor(b);
            g1.fillOval(5, k, i, i);
        }
        g1.setColor(Color.black);
        g1.drawOval(5, k, i, i);
        g1.setFont(e);
        j = n.a(j, fontmetrics);
        g1.drawString(c, i + 10 + 6, j);
    }

    public final void update(Graphics g1)
    {
        paint(g1);
    }

    public final Dimension preferredSize()
    {
        return new Dimension(super.preferredSize().width, a);
    }

    private static int a = 18;
    private static Color b = new Color(0x20e020);
    private String c;
    private int d;
    private Font e;

}
