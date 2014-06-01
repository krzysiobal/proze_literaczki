// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.*;
import java.awt.*;

// Referenced classes of package g:
//            App

public final class d extends j
{

    public d(App app)
    {
        super(app, app.b("bl_cs"));
        app.a(this);
        java.awt.Panel panel;
        (panel = n.a(this, 6)).setLayout(new BorderLayout(0, 10));
        app = f.a(app);
        b = (f)app[1];
        panel.add("Center", app[0]);
        pack();
        n.a(this);
    }

    f b;
}
