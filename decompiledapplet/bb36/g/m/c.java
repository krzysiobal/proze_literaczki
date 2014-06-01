// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.*;
import g.App;
import java.awt.*;
import java.awt.event.WindowEvent;

// Referenced classes of package g.m:
//            AppMulti, e, f

public final class c extends j
    implements p
{

    public c(e e1, Frame frame)
    {
        super(((f) (e1)).h, e1.c("bl_invite"));
        c = e1;
        Object obj;
        if((obj = e1.getBackground()) != null)
            setBackground(((java.awt.Color) (obj)));
        obj = n.a(this, 10);
        java.awt.Component acomponent[] = w.a(this, null, 300, 320, true, true);
        ((f) (e1)).h.d(b = (w)acomponent[1]);
        ((f) (e1)).h.b(b);
        ((Container) (obj)).add("Center", acomponent[0]);
        pack();
        if(frame != null)
        {
            n.a(this, frame);
            return;
        } else
        {
            n.a(this);
            return;
        }
    }

    public final void a(v v1, int i)
    {
        if(i == 0)
        {
            c.c(new int[] {
                95, ((f) (c)).o, 0
            }, new String[] {
                v1.c
            });
            setVisible(false);
            return;
        } else
        {
            super.a.g(v1.c);
            return;
        }
    }

    public final void windowClosing(WindowEvent windowevent)
    {
        setVisible(false);
    }

    public final void a()
    {
        c.f = null;
        ((f) (c)).h.a(b);
        b.a();
        dispose();
    }

    private w b;
    private e c;
}
