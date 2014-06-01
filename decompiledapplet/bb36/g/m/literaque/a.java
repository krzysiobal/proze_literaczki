// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m.literaque;

import c.i;
import c.n;
import g.App;
import g.m.e;
import g.m.f;
import java.awt.*;

// Referenced classes of package g.m.literaque:
//            b, e

public final class a extends i
{

    public a(g.m.literaque.e e1, Image image, Image image1, Image aimage[])
    {
        super(((f) (e1)).h, e1, e1.c("ft_blspec"));
        a = e1;
        ((f) (a)).h.a(this);
        java.awt.Panel panel;
        (panel = n.a(this, 4)).add("North", n.g(e1.c("ft_blspec")));
        panel.add("Center", new b(((f) (e1)).h, this, image, image1, aimage, e1.c("tl_ord")));
        pack();
        n.a(this, e1);
    }

    public final void a(int j)
    {
        a.a(5, 1, j);
        setVisible(false);
    }

    private g.m.literaque.e a;
}
