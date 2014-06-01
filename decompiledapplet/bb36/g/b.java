// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.*;
import java.awt.*;

// Referenced classes of package g:
//            App

public final class b extends j
{

    public b(App app)
    {
        super(app, app.b("bl_buds") + " (0)");
        d = 0;
        c = app.b("bl_buds");
        d = 0;
        app.a(this);
        java.awt.Panel panel;
        (panel = n.a(this, 6)).setLayout(new BorderLayout(0, 10));
        app = c.c.a(app);
        b = (c)app[1];
        add("Center", app[0]);
        pack();
        n.a(this);
    }

    public final void a(int i)
    {
        if(d != i)
        {
            setTitle(c + " (" + i + ")");
            d = i;
        }
    }

    c b;
    private String c;
    private int d;
}
