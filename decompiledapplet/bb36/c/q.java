// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;

public final class q extends Panel
{

    public q()
    {
    }

    public final Dimension preferredSize()
    {
        if(a > 0)
            return new Dimension(super.preferredSize().width, a <= 0 ? super.preferredSize().height : a);
        else
            return super.preferredSize();
    }

    public final void a(int i)
    {
        a = i;
    }

    private int a;
}
