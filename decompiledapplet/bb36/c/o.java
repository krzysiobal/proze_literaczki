// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package c;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.*;

// Referenced classes of package c:
//            a, n

public abstract class o extends Canvas
    implements AdjustmentListener
{

    public o(Scrollbar scrollbar)
    {
        o = new Vector();
        p = new Object();
        if(scrollbar != null)
        {
            a = scrollbar;
            a.addAdjustmentListener(this);
        }
        setBackground(Color.white);
        n = c.n.a(1);
        m = c.n.a(3);
    }

    public void adjustmentValueChanged(AdjustmentEvent adjustmentevent)
    {
        if(adjustmentevent.getSource() == a && a != null)
        {
            c = a.getValue();
            repaint();
        }
    }

    public final void a(Object obj)
    {
        synchronized(p)
        {
            a(obj, o.size());
            d(obj);
        }
        c();
        repaint();
    }

    public void a(Object obj, boolean flag, int i1)
    {
        a(obj, false);
    }

    public final void a(Object obj, boolean flag)
    {
        if(flag)
            synchronized(p)
            {
                o.removeElement(obj);
                a(obj, o.size());
            }
        repaint();
    }

    public final void b(Object obj)
    {
        synchronized(p)
        {
label0:
            {
                int i1 = o.size() * d - f;
                byte byte0;
                if(c > i1)
                    byte0 = 1;
                else
                if(c == i1)
                    byte0 = 0;
                else
                    byte0 = -1;
                c(obj);
                o.removeElement(obj);
                if(obj == j)
                    j = null;
                i1 -= d;
                if(byte0 == -1)
                {
                    if(c <= i1)
                        break label0;
                } else
                if(byte0 == 0)
                {
                    c = i1;
                    break label0;
                }
                c -= d;
            }
            if(c < 0)
                c = 0;
        }
        break MISSING_BLOCK_LABEL_155;
        obj;
        throw obj;
        c();
        repaint();
        return;
    }

    public final void a(Hashtable hashtable)
    {
        synchronized(p)
        {
            for(int i1 = o.size() - 1; i1 >= 0; i1--)
            {
                Object obj2 = o.elementAt(0);
                c(obj2);
                o.removeElementAt(0);
            }

            j = null;
            Object obj3;
            for(Enumeration enumeration = hashtable.elements(); enumeration.hasMoreElements(); o.addElement(obj3))
            {
                obj3 = enumeration.nextElement();
                d(obj3);
            }

            c = 0;
        }
        synchronized(p)
        {
            for(int j1 = 1; j1 < o.size(); j1++)
            {
                Object obj4 = o.elementAt(j1);
                o.removeElementAt(j1);
                a(obj4, j1);
            }

        }
        c();
        repaint();
    }

    public void c(Object obj)
    {
    }

    public void d(Object obj)
    {
    }

    public abstract void a(Object obj, int i1);

    public final void a(int i1, boolean flag)
    {
        synchronized(p)
        {
            h = i1;
            i = flag;
            for(i1 = 1; i1 < o.size(); i1++)
            {
                flag = ((boolean) (o.elementAt(i1)));
                o.removeElementAt(i1);
                a(flag, i1);
            }

        }
    }

    public final void b()
    {
        a(h, i);
        repaint();
    }

    public void update(Graphics g1)
    {
        if(g1 != null)
        {
            paint(g1);
            return;
        }
        if(b != null)
        {
            a(b.c, b.d);
            repaint();
        }
    }

    public final void c()
    {
        a.setValues(c, f - 1, 0, o.size() * d);
    }

    public Scrollbar a;
    public a b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public Object j;
    public Image k;
    public Graphics l;
    public Font m;
    public Font n;
    public Vector o;
    public Object p;
}
