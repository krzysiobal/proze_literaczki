// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import c.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;

// Referenced classes of package g:
//            App

public final class c extends j
    implements ActionListener
{

    public c(App app, String s)
    {
        super(app, s);
        b = s;
        app.a(this);
        (app = n.a(this, 6)).setLayout(new BorderLayout(0, 10));
        (s = new Panel()).setLayout(new BorderLayout(0, 6));
        c = new g(b);
        s.add("North", c);
        Component acomponent[] = c.e.a(super.a, e, true, 0);
        l = (e)acomponent[1];
        l.a(this);
        l.setSize(d, e);
        l.a.addActionListener(this);
        s.add("Center", acomponent[0]);
        app.add("Center", s);
        (s = new Panel()).setLayout(new BorderLayout(8, 0));
        s.add("West", m = n.c(" > "));
        s.add("Center", k = new Panel());
        app.add("South", s);
        app = f;
        pack();
        setLocation(app, app);
        f = (app + 20) % (480 - e - 100);
    }

    public final boolean action(Event event, Object obj)
    {
        if(event.target == m)
        {
            if(j == null)
            {
                j = new PopupMenu();
                j.setFont(n.a(1));
                g = new MenuItem(super.a.b("ui_block"));
                g.addActionListener(this);
                j.add(g);
                i = new MenuItem(super.a.b("chd"));
                i.addActionListener(this);
                j.add(i);
                h = new MenuItem("copy");
                h.addActionListener(this);
                j.add(h);
                add(j);
            }
            j.show(k, 0, 0);
            return true;
        } else
        {
            return super.action(event, obj);
        }
    }

    public final void b()
    {
        super.a.d(b);
    }

    public final void windowClosing(WindowEvent windowevent)
    {
        setVisible(false);
    }

    public final void actionPerformed(ActionEvent actionevent)
    {
        if((actionevent = ((ActionEvent) (actionevent.getSource()))) == l.a)
        {
            String s = (actionevent = l.a).getText();
            actionevent.setText("");
            super.a.b(b, s);
            return;
        }
        if(actionevent == g)
        {
            super.a.c("/ignore " + b);
            a();
            return;
        }
        if(actionevent == h)
        {
            l.a();
            return;
        }
        if(actionevent == i)
            super.a.e(b);
    }

    final void c()
    {
        l.b();
    }

    final void a(int i1, String s, int j1)
    {
        if(i1 == 0)
            l.a(s);
        else
        if(i1 == -1)
        {
            i1 = l.b;
            l.b();
            l.a(s + "\n" + i1);
        } else
        if(i1 == 1)
        {
            l.a(s);
            setTitle((s.startsWith(b + ":") ? "+ " : "") + b);
        }
        if(j1 != 0)
        {
            if(!isVisible())
                show();
            super.a.a(b, j1);
        }
    }

    public final void a()
    {
        super.a.i(b);
        l.c();
        dispose();
    }

    private static int d = 420;
    private static int e = 160;
    private static int f = 0;
    String b;
    g c;
    private MenuItem g;
    private MenuItem h;
    private MenuItem i;
    private PopupMenu j;
    private Panel k;
    private e l;
    private Button m;

}
