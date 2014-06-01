// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.n;
import c.x;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Panel;
import java.awt.Window;

// Referenced classes of package g:
//            App

public final class j extends c.j
{

    public j(App app)
    {
        super(app, app.b("bl_prefs"));
        app.a(this);
        (app = n.a(this, 12)).setLayout(new BorderLayout(0, 2));
        app = super.a.a(app);
        super.a.k();
        app.add("Center", new x(0, new Dimension(250, 10), (byte)0));
        Panel panel;
        (panel = new Panel()).setLayout(new BorderLayout(0, 0));
        panel.add("West", n.a(new Component[] {
            b = n.c(super.a.b("bl_ok"))
        }, 0, 2));
        app.add("South", panel);
        pack();
        n.a(this);
        show();
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == b)
        {
            super.a.l();
            super.a.i();
            super.a.m();
            setVisible(false);
            return true;
        } else
        {
            super.a.k();
            return super.action(event, obj);
        }
    }

    public final void a()
    {
        setVisible(false);
    }

    public final void show()
    {
        super.a.j();
        super.show();
    }

    private Button b;
}
