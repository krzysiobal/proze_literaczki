// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.Dimension;
import java.awt.TextField;

public final class s extends TextField
{

    public s()
    {
    }

    public final Dimension preferredSize()
    {
        return new Dimension(0, super.minimumSize().height);
    }
}
