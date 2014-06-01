// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;


// Referenced classes of package g:
//            App, g

final class f extends Thread
{

    public f(App app, g g)
    {
        b = app;
        a = g;
    }

    public final void run()
    {
        try
        {
            Thread.sleep(8000L);
        }
        catch(Exception _ex) { }
        b.a(a, -1);
    }

    private g a;
    private App b;
}
