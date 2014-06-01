// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class i extends Dialog
    implements WindowListener
{

    public i(App app, Frame frame, String s)
    {
        super(frame, s);
        addWindowListener(this);
        a = app;
    }

    public void windowOpened(WindowEvent windowevent)
    {
    }

    public void windowClosed(WindowEvent windowevent)
    {
    }

    public void windowClosing(WindowEvent windowevent)
    {
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

    private App a;
}
