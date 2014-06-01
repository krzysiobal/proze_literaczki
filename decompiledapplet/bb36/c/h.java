// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import g.App;
import java.awt.*;

// Referenced classes of package c:
//            j, n

public final class h extends j
{

    public h(App app, int i, String as[], boolean flag, String s)
    {
        super(app, "copy");
        app.a(this);
        (app = n.a(this, 8)).setLayout(new BorderLayout(0, 4));
        (i = new TextArea(18, 81)).setEditable(false);
        i.setBackground(Color.white);
        i.setFont(n.a(flag ? 4 : 1));
        flag = false;
_L4:
        flag;
        JVM INSTR ifgt 112;
           goto _L1 _L2
_L1:
        break MISSING_BLOCK_LABEL_81;
_L2:
        break; /* Loop/switch isn't completed */
        i.append(as[0] + "\n");
        flag++;
        if(true) goto _L4; else goto _L3
_L3:
        app.add("Center", i);
        pack();
        show();
        return;
    }
}
