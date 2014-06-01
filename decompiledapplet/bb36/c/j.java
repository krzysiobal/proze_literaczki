// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class j extends Frame
    implements WindowListener
{

    public j(App app, String s)
    {
        super(s);
        addWindowListener(this);
        a = app;
    }

    public void dispose()
    {
        super.dispose();
    }

    public void a()
    {
        dispose();
    }

    public void show()
    {
        super.show();
    }

    public void windowOpened(WindowEvent windowevent)
    {
    }

    public void windowClosed(WindowEvent windowevent)
    {
    }

    public void windowClosing(WindowEvent windowevent)
    {
        a();
    }

    public void windowIconified(WindowEvent windowevent)
    {
    }

    public void windowDeiconified(WindowEvent windowevent)
    {
    }

    public void windowActivated(WindowEvent windowevent)
    {
        if(a != null)
            a.a(true);
    }

    public void windowDeactivated(WindowEvent windowevent)
    {
        if(a != null)
            a.a(false);
    }

    public App a;
}
