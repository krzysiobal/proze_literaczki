// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.j;
import c.n;
import java.awt.*;
import java.util.StringTokenizer;

// Referenced classes of package g:
//            App

public final class i extends j
{

    public i(App app, String s)
    {
        this(app, s, null, new Object[0][]);
    }

    public i(App app, String s, String as[], int ai[], String as1[], int ai1[], String as2[])
    {
        this(app, s, as, new Object[][] {
            new Object[] {
                ai, as1
            }, new Object[] {
                ai1, as2
            }
        });
    }

    public i(App app, String s, String as[], Object aobj[][])
    {
        super(app, "-");
        c = aobj == null ? new Object[0][] : aobj;
        app.a(this);
        app = n.a(this, 8);
        aobj = new Panel();
        int k = (s = new StringTokenizer(s, "\n")).countTokens();
        ((Container) (aobj)).setLayout(new GridLayout(k, 1));
        for(; s.hasMoreTokens(); ((Container) (aobj)).add(n.g(s.nextToken())));
        app.add("Center", ((Component) (aobj)));
        (s = new Panel()).setLayout(new FlowLayout(1, 4, 0));
        if(as == null)
            if(c.length <= 1)
                as = (new String[] {
                    super.a.b("bl_ok")
                });
            else
                as = (new String[] {
                    super.a.b("bl_yes"), super.a.b("bl_no")
                });
        b = new Button[as.length];
        for(aobj = 0; aobj < as.length; aobj++)
            s.add(b[aobj] = n.c(as[aobj]));

        app.add("South", s);
        pack();
        n.a(this);
        show();
    }

    public final boolean action(Event event, Object obj)
    {
        for(int k = 0; k < b.length; k++)
            if(event.target == b[k])
            {
                if(k < c.length && c[k] != null)
                    super.a.b((int[])c[k][0], (String[])c[k][1]);
                dispose();
                return true;
            }

        return super.action(event, obj);
    }

    private Button b[];
    private Object c[][];
}
