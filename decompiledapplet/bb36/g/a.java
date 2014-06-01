// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.*;
import java.awt.*;

// Referenced classes of package g:
//            App

public final class a extends j
{

    public a(App app, String s, Object aobj[])
    {
        super(app, s);
        g = s;
        f = aobj;
        super.a = app;
        app.a(this);
        (app = n.a(this, 8)).setLayout(new BorderLayout(0, b));
        app = n.a(app, n.a(new Component[] {
            n.f(s)
        }), 2 * b);
        (s = new Panel()).setLayout(new BorderLayout(0, 2 * b));
        app.add("South", s);
        s = n.a(s, n.a(new Component[] {
            d = n.c(super.a.b("bl_whisper"))
        }), 2 * b);
        e = n.d(super.a.b("bl_buds"));
        e.setState(true);
        (app = new x(0, Color.black)).setSize(150, 1);
        n.a(s = n.a(s = n.a(s, app, b), n.a(new Component[] {
            e
        }, 0, 4), b << 1), n.a(new Component[] {
            c = n.c(super.a.b("bl_ok"))
        }, 0, 0), b);
        pack();
        n.a(this);
        show();
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == c)
        {
            if(!e.getState())
                super.a.c("/unbuddy " + g);
            a();
            return true;
        }
        if(event.target == d)
        {
            a();
            super.a.h(g);
            return true;
        } else
        {
            return super.action(event, obj);
        }
    }

    public final void a()
    {
        try
        {
            f[5] = null;
        }
        catch(Exception _ex) { }
        dispose();
    }

    private static int b = 3;
    private Button c;
    private Button d;
    private Checkbox e;
    private Object f[];
    private String g;

}
