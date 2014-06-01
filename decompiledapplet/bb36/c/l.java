// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;

public final class l extends Label
{

    public l(String s, int i, int j, int k)
    {
        super(s, i);
        if(!b)
        {
            try
            {
                a = System.getProperty("os.name").startsWith("Mac");
            }
            catch(Throwable _ex) { }
            b = true;
        }
        c = j;
        d = k;
    }

    public l(String s, int i)
    {
        this(s, i, 8, 3);
    }

    public final Dimension preferredSize()
    {
        Dimension dimension = super.preferredSize();
        return new Dimension(dimension.width - (a ? 0 : c), dimension.height - (a ? 0 : d));
    }

    private static boolean a;
    private static boolean b = false;
    private int c;
    private int d;

}
