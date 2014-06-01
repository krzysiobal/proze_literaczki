// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;

// Referenced classes of package c:
//            n

public final class k extends Canvas
{

    public k(Applet applet, URL url)
    {
        d = applet;
        c = url;
    }

    public final void paint(Graphics g)
    {
        Dimension dimension = n.a;
        g.setColor(a);
        g.drawRect(0, 0, dimension.width - 1, dimension.height - 1);
        if(b == null)
        {
            if(d == null)
                return;
            b = d.getImage(c);
        }
        g.drawImage(b, 1, 1, this);
    }

    public final Dimension preferredSize()
    {
        return n.a;
    }

    public final void update(Graphics g)
    {
        paint(g);
    }

    private static Color a = new Color(64, 64, 64);
    private Image b;
    private URL c;
    private Applet d;

}
