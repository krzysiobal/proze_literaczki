// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m.literaque;

import c.n;
import g.App;
import g.m.AppMulti;
import g.m.a;
import g.m.d;
import g.m.f;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Event;
import java.awt.Label;
import java.awt.Window;

// Referenced classes of package g.m.literaque:
//            a, d

public final class e extends g.m.e
{

    public e(AppMulti appmulti, int ai[], String as[])
    {
        super(appmulti, ai, as, new boolean[] {
            false, false, false
        });
    }

    public final String j()
    {
        return c("bl_defs");
    }

    public final boolean keyDown(Event event, int k)
    {
        if(!q() || !super.e.a(super.n))
            return super.keyDown(event, k);
        if(k == 1009)
        {
            if(s == 0)
                A();
            else
            if(s == 1)
            {
                b(5, 4);
                super.c.show(super.d, "0");
            }
            return true;
        } else
        {
            return super.keyDown(event, k);
        }
    }

    private void A()
    {
        if(t.isEnabled())
        {
            int ai[] = ((g.m.literaque.d)super.b).m();
            a(5, 1, ai.length, ai);
        }
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == t)
            A();
        else
        if(event.target == u)
        {
            if((event = ((g.m.literaque.d)super.b).l()) != null)
                a(5, 2, event.length, event);
        } else
        if(event.target == v)
            b(5, 3);
        else
        if(event.target == w)
            b(5, 4);
        else
        if(event.target == x)
            b(5, 5);
        else
            return super.action(event, obj);
        super.c.show(super.d, "0");
        return true;
    }

    public final void f()
    {
        Component acomponent[] = a("1", null, new String[] {
            " OK (F2) ", c("bl_exch"), c("bl_pass")
        }, true);
        t = (Button)acomponent[0];
        u = (Button)acomponent[1];
        v = (Button)acomponent[2];
        y = (Label)acomponent[3];
        acomponent = a("2", null, new String[] {
            " " + c("bl_acc") + " (F2) ", c("bl_nocheck")
        }, false);
        w = (Button)acomponent[0];
        x = (Button)acomponent[1];
    }

    public final void d()
    {
        if(!q())
        {
            super.c.show(super.d, "0");
            return;
        }
        boolean flag = super.e.a(super.n);
        if(s == 0)
        {
            if(z != null)
                z.setVisible(false);
            super.c.show(super.d, flag ? "1" : "0");
            ((g.m.literaque.d)super.b).k();
            return;
        }
        if(s == 1)
        {
            if(z != null)
                z.setVisible(false);
            super.c.show(super.d, flag ? "2" : "0");
            ((g.m.literaque.d)super.b).j();
            return;
        }
        if(s == 2)
        {
            if(!flag)
            {
                if(z != null)
                    z.setVisible(false);
            } else
            {
                if(z == null)
                    z = new g.m.literaque.a(this, d.j[10], d.j[12], d.k);
                z.show();
            }
            super.c.show(super.d, "0");
        }
    }

    public final a e()
    {
        return new g.m.literaque.d(this, super.g);
    }

    public final d g()
    {
        return new d(this, 2, true, true, null, "(0)", null);
    }

    public final void a(boolean flag, boolean flag1)
    {
        if(!flag)
        {
            super.b.a(false);
            if(z != null)
                z.setVisible(false);
            return;
        }
        super.b.a(s == 0);
        if(z != null)
            if(s == 2)
                z.show();
            else
                z.setVisible(false);
        if(flag1)
            ((f) (flag = this)).h.g();
    }

    public final String a(int k)
    {
        return n.a(c("win_pln"), String.valueOf(k + 1));
    }

    public final int a(int ai[], int k, int l)
    {
        if(ai[k] == 5)
        {
            if(k + 2 > l)
                return k;
            int i1;
            int j1 = ((i1 = ai[k + 1] < 0 ? 0x10000 + ai[k + 1] : ai[k + 1]) / 384) % 8;
            int k1 = i1 / 3072;
            if(k + 2 + j1 > l)
                return k;
            for(l = 0; l < 2; l++)
                super.e.b(l, "(" + (i1 / 6 / (l <= 0 ? 1 : 8)) % 8 + ")");

            s = i1 % 3;
            ((g.m.literaque.d)super.b).a(k1, (i1 / 3) % 2 != 0);
            ((g.m.literaque.d)super.b).a(ai, k + 2, k + 2 + j1);
            return k + 2 + j1;
        } else
        {
            return super.a(ai, k, l);
        }
    }

    public final boolean i()
    {
        return false;
    }

    public final void a()
    {
        if(z != null)
            z.dispose();
        super.a();
    }

    final void a(int k, boolean flag, boolean flag1, boolean flag2)
    {
        t.setEnabled(flag && s == 0);
        u.setEnabled(flag1 && s == 0);
        v.setEnabled(flag2 && s == 0);
        if(!flag)
            k = 0;
        y.setText(String.valueOf(k));
    }

    private Button t;
    private Button u;
    private Button v;
    private Button w;
    private Button x;
    private Label y;
    int s;
    private g.m.literaque.a z;
}
