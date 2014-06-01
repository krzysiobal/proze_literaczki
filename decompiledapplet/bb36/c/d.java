// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;

public final class d extends Button
{

    public d(String s)
    {
        super(s);
        a = 0;
    }

    public d()
    {
        a = 0;
        a = 255;
    }

    public final Dimension preferredSize()
    {
        Dimension dimension = super.preferredSize();
        return new Dimension(a != 255 ? dimension.width : 0, dimension.height + 2);
    }

    private int a;
}
