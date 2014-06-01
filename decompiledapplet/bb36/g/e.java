// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import java.awt.Label;

// Referenced classes of package g:
//            App

final class e extends Thread
{

    public e(App app)
    {
        a = app;
    }

    public final void run()
    {
        String s = a.a.getText();
        for(int i = 8; i > 0; i--)
        {
            a.a.setText(s + " ... " + i);
            try
            {
                Thread.sleep(1000L);
            }
            catch(Exception _ex) { }
        }

        a.a();
    }

    private App a;
}
