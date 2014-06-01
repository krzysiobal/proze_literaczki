// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m;

import c.i;
import c.n;
import g.App;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

// Referenced classes of package g.m:
//            e

public final class g extends i
{

    public g(App app, Frame frame, String s, Component acomponent[], e e1, int j)
    {
        super(app, frame, "-");
        b = e1;
        c = j;
        a = acomponent;
        app.a(this);
        app = n.a(this, 8);
        acomponent = new Panel();
        e1 = (s = new StringTokenizer(s, "\n")).countTokens();
        acomponent.setLayout(new GridLayout(e1, 1));
        for(; s.hasMoreTokens(); acomponent.add(n.g(s.nextToken())));
        app.add("North", acomponent);
        (s = new Panel()).setLayout(new FlowLayout(1, 4, 0));
        for(acomponent = 0; acomponent < a.length; acomponent++)
            s.add(a[acomponent]);

        app.add("Center", s);
        pack();
        n.a(this, frame);
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target instanceof Button)
        {
            obj = 0;
            do
            {
                if(obj >= a.length)
                    break;
                if(a[obj] == event.target)
                {
                    Component[] _tmp = a;
                    b.a(this, ((int) (obj)));
                    break;
                }
                obj++;
            } while(true);
            setVisible(false);
            return true;
        } else
        {
            return super.action(event, obj);
        }
    }

    public final int a()
    {
        return c;
    }

    public final void windowClosing(WindowEvent windowevent)
    {
        if(b != null)
            b.a(this, 0);
        dispose();
    }

    public final void show()
    {
        super.show();
    }

    private Component a[];
    private e b;
    private int c;
}
