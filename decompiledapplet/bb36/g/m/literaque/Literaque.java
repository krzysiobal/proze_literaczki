// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m.literaque;

import g.App;
import g.m.AppMulti;
import g.m.e;

// Referenced classes of package g.m.literaque:
//            c, e

public class Literaque extends AppMulti
{

    public Literaque()
    {
        super.t = "_bb";
    }

    public final synchronized App a(App app)
    {
        App app1 = w;
        w = app;
        return app1;
    }

    public final Object[][] d()
    {
        return c.a;
    }

    public final e c(int ai[], String as[])
    {
        return new g.m.literaque.e(this, ai, as);
    }

    private static App w;
}
