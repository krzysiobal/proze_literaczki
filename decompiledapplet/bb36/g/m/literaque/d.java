// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g.m.literaque;

import c.b;
import c.n;
import g.m.a;
import g.m.e;
import g.m.f;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.util.StringTokenizer;

// Referenced classes of package g.m.literaque:
//            e

public final class d extends a
{

    public d(e e1, g.m.b b1)
    {
        super(e1, b1);
        E = new Object();
        F = new Object();
        U = true;
        V = new int[16];
        D = c.n.a(1);
        setForeground(Color.white);
        if(j == null)
        {
            j = new Image[n.length];
            for(b1 = 0; b1 < n.length; b1++)
                j[b1] = e1.a("img/literaque/" + n[b1] + ".gif");

            a(j);
            (b1 = new Image[1])[0] = e1.a("img/literaque/let.gif");
            a(b1);
            e1 = b1[0].getWidth(this);
            int i = b1[0].getHeight(this);
            int ai[] = new int[e1 * (i + 1)];
            b1 = new PixelGrabber(b1[0], 0, 0, e1, i, ai, 0, e1);
            try
            {
                b1.grabPixels();
            }
            catch(Exception _ex) { }
            b1 = (new int[] {
                10, 10, 10, 6
            });
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            k = new Image[37];
            int i1 = 0;
            int j1 = 1;
            for(; i1 < b1.length; i1++)
            {
                for(int k1 = 0; k1 < b1[i1]; k1++)
                    k[j1++] = toolkit.createImage(new MemoryImageSource(34, 34, ai, i1 * 34 + k1 * 34 * e1, e1));

            }

            k[0] = k[1];
            o = c.b.a(j, 34, 34);
            p = c.b.a(k, 34, 34);
        }
        int[][] _tmp = q;
        (q = new int[15][15])[2][0] = 7;
        q[5][2] = 6;
        q[4][3] = 6;
        q[7][2] = 1;
        q[6][3] = 1;
        q[5][4] = 1;
        q[5][0] = 2;
        q[4][1] = 2;
        q[3][2] = 2;
        q[6][6] = 3;
        q[7][5] = 3;
        q[0][0] = 5;
        q[6][1] = 5;
        q[7][0] = 5;
        q[7][7] = 4;
        for(b1 = 0; b1 < 8; b1++)
        {
            for(e1 = b1 + 1; e1 < 8; e1++)
                q[b1][e1] = q[e1][b1];

            for(e1 = 0; e1 < 7; e1++)
                q[b1][14 - e1] = q[b1][e1];

            for(e1 = 0; e1 < 15; e1++)
                q[14 - b1][e1] = q[b1][e1];

        }

        b1 = new StringTokenizer(super.h.c("ss_values"));
        Q = new int[1 + b1.countTokens()];
        Q[0] = 0;
        e1 = 1;
        while(b1.hasMoreTokens()) 
            Q[e1++] = Integer.parseInt(b1.nextToken());
        P = new int[16][15];
        O = new int[7][4];
        N = 0;
        L = M = -1;
    }

    public final void a(boolean flag)
    {
        super.a(flag);
        if(flag)
        {
            n();
            U = true;
            return;
        }
        synchronized(E)
        {
            if(M < 15)
                M = -1;
        }
    }

    private int b(int i, int i1)
    {
        int j1 = 0;
        int k1 = 1;
        int l1 = i;
        i = i;
        for(; e(l1 - 1, i1); l1--);
        for(; e(i + 1, i1); i++);
        if(l1 == i)
            return 0;
        for(l1 = l1; l1 <= i; l1++)
        {
            int i2 = c(P[i1][l1]);
            if(P[i1][l1] < 0)
            {
                i2 *= q[i1][l1] != i2 && (q[i1][l1] != 4 || i2 != 5) ? 1 : 3;
                k1 *= q[i1][l1] != 7 ? ((int) (q[i1][l1] != 6 ? 1 : 2)) : 3;
            }
            j1 += i2;
        }

        return j1 * k1;
    }

    private int c(int i, int i1)
    {
        int j1 = 0;
        int k1 = 1;
        int l1 = i1;
        i1 = i1;
        for(; e(i, l1 - 1); l1--);
        for(; e(i, i1 + 1); i1++);
        if(l1 == i1)
            return 0;
        for(l1 = l1; l1 <= i1; l1++)
        {
            int i2 = c(P[l1][i]);
            if(P[l1][i] < 0)
            {
                i2 *= q[l1][i] != i2 && (q[l1][i] != 4 || i2 != 5) ? 1 : 3;
                k1 *= q[l1][i] != 7 ? ((int) (q[l1][i] != 6 ? 1 : 2)) : 3;
            }
            j1 += i2;
        }

        return j1 * k1;
    }

    public final void a(Graphics g1, Dimension dimension)
    {
        for(dimension = 0; dimension < 16; dimension++)
            a(dimension, g1);

    }

    private void b(int i)
    {
label0:
        {
            if(K <= i - r || K > i + r)
                return;
            boolean flag = false;
            synchronized(E)
            {
                if(G != null)
                    break label0;
            }
            return;
        }
        int i1 = G[0];
        obj;
        JVM INSTR monitorexit ;
          goto _L1
        i;
        throw i;
_L1:
        if(i1 < 0)
            i1 = -i1;
        int j1 = i1 % 64 >= Q.length ? 0 : Q[i1 % 64];
        super.d.drawImage(B[9 + ((i1 & 0x40) != 0 ? 0 : j1)], J, K - i, null);
        super.d.drawImage(C[i1 % 64], J, K - i, this);
        return;
    }

    private synchronized void a(int i, Graphics g1)
    {
label0:
        {
            int i1;
            FontMetrics fontmetrics;
            int j1;
            int k1;
            Color color;
            int l1;
            FontMetrics fontmetrics1;
            int i2;
            String s1;
            int j2;
            int k2;
            synchronized(F)
            {
                if(i >= 0 && i < 16 && super.d != null && g1 != null)
                    break label0;
            }
            return;
        }
        if(i == 0)
        {
            i1 = r - w;
            super.d.setColor(getForeground());
            super.d.fillRect(0, 0, u, r);
            super.d.setColor(n.g);
            super.d.drawRect(0, i1, u - 1, w);
            g1.drawImage(super.c, 0, -i1, null);
        }
        if(i < 15)
        {
            super.d.setColor(getForeground());
            super.d.fillRect(0, 0, u, r);
            super.d.setColor(Color.gray);
            super.d.setFont(D);
            j1 = (fontmetrics = super.d.getFontMetrics()).getAscent() - 2;
            k1 = (z - j1) / 2;
            l1 = (j1 + 1 + 2) - i * r;
            for(i2 = 0; i2 < 4; i2++)
            {
                super.d.setColor(m[i2 + 1]);
                super.d.fillRect(k1 + 1, l1 - j1, j1 - 1, j1 - 1);
                super.d.setColor(Color.white);
                super.d.drawLine(k1, l1 - j1 - 1, k1, l1 - j1 - 1);
                super.d.drawLine(k1 + j1, l1 - j1 - 1, k1 + j1, l1 - j1 - 1);
                super.d.drawLine(k1, l1 - 1, k1, l1 - 1);
                super.d.drawLine(k1 + j1, l1 - 1, k1 + j1, l1 - 1);
                l1 += j1 + 4;
                super.d.setColor(Color.gray);
                super.d.drawString(l[i2], (z - fontmetrics.stringWidth(l[i2])) / 2 + 1, l1);
                l1 += (c.n.a(fontmetrics) * 30) / 16;
            }

            i2 = 0;
            for(j2 = z; i2 < 15; j2 += r)
            {
                k2 = P[i][i2];
                synchronized(E)
                {
                    if(G != null && G[1] == i2 && G[2] == i)
                        k2 = 0;
                }
                if(k2 == 0 || k2 < 0 && !U)
                {
                    super.d.drawImage(B[q[i][i2]], j2, 0, r, r, null);
                    if(i == M && i2 == L)
                        super.d.drawImage(B[13], j2, 0, r, r, null);
                } else
                {
                    a(super.d, k2, j2, 0);
                }
                i2++;
            }

            b(w + i * r);
            super.d.setColor(n.g);
            super.d.drawLine(0, 0, 0, r);
            super.d.drawLine(u - 1, 0, u - 1, r);
            g1.drawImage(super.c, 0, w + i * r, null);
        } else
        if(i == 15)
        {
            obj1 = w + 15 * r;
            j1 = y;
            for(k1 = 0; k1 < 2; k1++)
            {
                super.d.setColor(getForeground());
                super.d.fillRect(0, 0, u, r);
                if(k1 == 0)
                {
                    super.d.setColor(Color.lightGray);
                    super.d.drawLine(z, y / 2, u - A - 1, y / 2);
                }
                l1 = 0;
                for(i2 = z; l1 < 15; i2 += r)
                {
                    if(l1 != 7)
                    {
                        j2 = P[i][l1];
                        synchronized(E)
                        {
                            if(G != null && G[1] == l1 && G[2] == i)
                                j2 = 0;
                        }
                        if(j2 == 0)
                        {
                            super.d.drawImage(B[l1 >= 7 ? 4 : 0], i2, j1, r, r, null);
                            if(i == M && l1 == L)
                                super.d.drawImage(B[13], i2, j1, r, r, null);
                        } else
                        {
                            a(super.d, j2, i2, j1);
                        }
                    }
                    l1++;
                }

                super.d.setColor(Color.gray);
                super.d.setFont(D);
                fontmetrics1 = super.d.getFontMetrics();
                s1 = S != 0 ? String.valueOf(S - 1) : ">15";
                if(S >= 0)
                    super.d.drawString(s1, (z + 7 * r + r / 2) - fontmetrics1.stringWidth(s1) / 2, j1 + c.n.a(r, fontmetrics1));
                b(((int) (obj1)));
                super.d.setColor(n.g);
                super.d.drawLine(0, 0, 0, r);
                super.d.drawLine(u - 1, 0, u - 1, r);
                if(k1 == 1)
                {
                    super.d.drawLine(0, (j1 + r + x) - 1, u, (j1 + r + x) - 1);
                    super.d.setColor(getBackground());
                    super.d.fillRect(0, j1 + r + x, u, -j1 - x);
                }
                g1.drawImage(super.c, 0, ((int) (obj1)), null);
                obj1 += r;
                j1 -= r;
            }

            if((color = getBackground()) != null)
            {
                g1.setColor(color);
                g1.fillRect(0, ((int) (obj1)), u, v - obj1);
            }
        }
        obj;
        JVM INSTR monitorexit ;
    }

    private void a(Graphics g1, int i, int i1, int j1)
    {
        if(i < 0)
            i = -i;
        int k1 = i % 64 >= Q.length ? 0 : Q[i % 64];
        g1.drawImage(B[9 + ((i & 0x40) != 0 ? 0 : k1)], i1, j1, r, r, null);
        g1.drawImage(C[i % 64], i1, j1, r, r, null);
    }

    public final int c()
    {
        return 123;
    }

    public final void a(int ai[], String as[])
    {
        synchronized(this)
        {
            if(V.length < ai.length - 2)
                V = new int[(ai.length - 2) + 16];
            for(int i = 2; i < ai.length; i++)
                V[i - 2] = ai[i];

            W = ai.length - 2;
        }
        super.g.b(as);
    }

    private static boolean d(int i, int i1)
    {
        return i >= 0 && i < 15 && i1 >= 0 && i1 < 16 && (i != 7 || i1 != 15);
    }

    public final boolean mouseDown(Event event, int i, int i1)
    {
        int j1;
        event = d(i);
        j1 = e(i1);
        if(!d(event, j1))
            return true;
        if(!super.i && j1 < 15)
            return true;
        Object obj = E;
        JVM INSTR monitorenter ;
        int ai[];
        ai = null;
        int k1 = 0;
        do
        {
            if(k1 >= N)
                break;
            if(O[k1][1] == event && O[k1][2] == j1)
            {
                ai = O[k1];
                break;
            }
            k1++;
        } while(true);
        if(ai != null) goto _L2; else goto _L1
_L1:
        if(P[j1][event] != 0)
            return true;
        if(super.i && (((a) (i = this)).h.h() == 1)) goto _L4; else goto _L3
_L3:
        true;
        obj;
        JVM INSTR monitorexit ;
        return;
_L4:
        int ai1[] = null;
        i = j1 != 15 || event >= 7 ? 0 : 1;
        for(i1 = 0; i1 < N; i1++)
        {
            ai = O[i1][2] != 15 || O[i1][1] >= 7 ? 0 : 1;
            if((i ^ ai) != 0 && (ai1 == null || O[i1][1] < ai1[1] || O[i1][1] == ai1[1] && O[i1][2] < ai1[2]))
                ai1 = O[i1];
        }

        if(ai1 != null)
        {
            i1 = ai1[2];
            P[ai1[2]][ai1[1]] = 0;
            ai1[1] = event;
            ai1[2] = j1;
            P[j1][event] = ai1[0];
            L = -1;
            M = -1;
            a(i1, getGraphics());
            if(j1 != i1)
                a(j1, getGraphics());
            n();
        }
        true;
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        G = ai;
        H = (z + event * r) - i;
        I = (w + j1 * r + (j1 >= 15 ? y : 0)) - i1;
        J = i + H;
        K = i1 + I;
        obj;
        JVM INSTR monitorexit ;
          goto _L5
        event;
        throw event;
_L5:
        return true;
    }

    public final boolean mouseDrag(Event event, int i, int i1)
    {
        int j1;
label0:
        {
            if(G == null)
                return true;
            i1 += I;
            i = i + H;
            event = this;
            j1 = K;
            event.J = i;
            event.K = i1;
            i = event.d(((d) (event)).J + ((d) (event)).r / 2);
            i1 = event.e(((d) (event)).K + ((d) (event)).r / 2);
            event.M = -1;
            if(!d(i, i1))
                break MISSING_BLOCK_LABEL_524;
            synchronized(((d) (event)).E)
            {
                if(((d) (event)).G != null)
                    break label0;
            }
            break MISSING_BLOCK_LABEL_652;
        }
        int l1;
        if((l1 = ((d) (event)).P[i1][i] != 0 && (i != ((d) (event)).G[1] || i1 != ((d) (event)).G[2]) ? 0 : 1) == 0 && (i1 == 15 && i < 7))
        {
            int j2 = -1;
            int l2 = event.d(((d) (event)).J) != i ? -1 : 1;
            int j3 = 2;
            do
            {
                if(j3 >= 14)
                    break;
                int l3;
                if((l3 = i + (j3 / 2) * l2) >= 0 && l3 < 7 && (((d) (event)).P[i1][l3] == 0 || l3 == ((d) (event)).G[1] && i1 == ((d) (event)).G[2]))
                {
                    j2 = l3;
                    break;
                }
                l2 = -l2;
                j3++;
            } while(true);
            if(j2 != -1)
            {
                if(((d) (event)).G[2] == 15)
                    ((d) (event)).P[((d) (event)).G[2]][((d) (event)).G[1]] = 0;
                for(int k3 = 0; k3 < ((d) (event)).N; k3++)
                {
                    int i4 = ((d) (event)).O[k3][1];
                    if((l1 = ((d) (event)).O[k3][2]) == i1 && (l2 == -1 && i4 > j2 && i4 <= i || l2 == 1 && i4 >= i && i4 < j2))
                    {
                        ((d) (event)).O[k3][1] += l2;
                        ((d) (event)).P[i1][((d) (event)).O[k3][1]] = ((d) (event)).O[k3][0];
                    }
                }

                if(((d) (event)).G[2] == 15)
                {
                    ((d) (event)).P[i1][i] = ((d) (event)).G[0];
                    ((d) (event)).G[1] = i;
                    ((d) (event)).G[2] = i1;
                } else
                {
                    ((d) (event)).P[i1][i] = 0;
                }
                l1 = 1;
            }
        }
        if(l1 != 0 && (((a) (event)).i || i1 == 15 && i < 7))
        {
            event.L = i;
            event.M = i1;
        }
        obj;
        JVM INSTR monitorexit ;
        break MISSING_BLOCK_LABEL_524;
        event;
        throw event;
        int k1 = event.e(((d) (event)).K);
        int i2 = event.e(((d) (event)).K + ((d) (event)).r);
        event.a(k1, event.getGraphics());
        if(i2 != k1)
            event.a(i2, event.getGraphics());
        int k2 = event.e(j1);
        int i3 = event.e(j1 + ((d) (event)).r);
        if(k2 != k1 && k2 != i2)
            event.a(k2, event.getGraphics());
        if(i3 != k1 && i3 != i2 && i3 != k2)
            event.a(i3, event.getGraphics());
        return true;
    }

    public final boolean mouseUp(Event event, int i, int i1)
    {
        event = ((Event) (E));
        JVM INSTR monitorenter ;
        if(G == null)
            return true;
        if((i = M != -1 && (super.i || M >= 15) ? 0 : 1) == 0 && P[M][L] != 0)
            i = 1;
        if(i == 0) goto _L2; else goto _L1
_L1:
        G = null;
        if(super.i)
            n();
        repaint();
        true;
        event;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = G[1];
        i1 = G[2];
        P[i1][i] = 0;
        G[1] = L;
        G[2] = M;
        P[M][L] = G[0];
        if(super.i)
            n();
        G = null;
        M = -1;
        event;
        JVM INSTR monitorexit ;
          goto _L3
        i;
        throw i;
_L3:
        event = e(K);
        i = e(K + r);
        a(event, getGraphics());
        if(i != event)
            a(i, getGraphics());
        return true;
    }

    public final void b(int ai[], String as[])
    {
        if(ai.length <= 2)
        {
            synchronized(this)
            {
                int i = -1;
                int j1 = W - 1;
                do
                {
                    if(j1 < 0)
                        break;
                    if(V[j1] == 0)
                    {
                        i = j1;
                        break;
                    }
                    j1--;
                } while(true);
                W = i + 1;
            }
            super.g.a(null);
            return;
        }
        synchronized(this)
        {
            if(W + (ai.length - 2) > V.length)
            {
                int ai1[] = new int[W + (ai.length - 2) + 16];
                for(int k1 = 0; k1 < W; k1++)
                    ai1[k1] = V[k1];

                V = ai1;
            }
label0:
            for(int i1 = 2; i1 < ai.length; i1++)
            {
                V[W++] = ai[i1];
                if(ai[i1] == 0)
                    continue;
                int l1 = (ai[i1] / 128) % 16;
                int j2 = (ai[i1] / 2048) % 16;
                int l2 = 0;
                do
                {
                    if(l2 >= N)
                        continue label0;
                    if(O[l2][1] == l1 && O[l2][2] == j2)
                    {
                        for(int i2 = l2; i2 < N - 1; i2++)
                        {
                            for(int k2 = 0; k2 < O[i2].length; k2++)
                                O[i2][k2] = O[i2 + 1][k2];

                        }

                        N--;
                        continue label0;
                    }
                    l2++;
                } while(true);
            }

        }
        super.g.a(as);
    }

    private boolean e(int i, int i1)
    {
        if(i < 0 || i >= 15 || i1 < 0 || i1 >= 15)
            return false;
        return P[i1][i] != 0;
    }

    private int c(int i)
    {
        if(i < 0)
            i = -i;
        if((i & 0x40) != 0)
            return 0;
        if((i %= 64) < Q.length)
            return Q[i];
        else
            return 0;
    }

    public final void a()
    {
        if(super.d == null || t != u || r != s)
        {
            t = u;
            s = r;
            if(super.d != null)
                super.d.dispose();
            super.c = createImage(t, s);
            super.d = super.c.getGraphics();
        }
    }

    public final void a(int i)
    {
        d d1 = this;
        for(int i1 = 0; i1 < d1.P.length - 1; i1++)
        {
            for(int k1 = 0; k1 < d1.P[i1].length; k1++)
                d1.P[i1][k1] = 0;

        }

        synchronized(E)
        {
            int j1 = 0;
            do
            {
                if(j1 >= W)
                    break;
                if(V[j1] == 0 && --i < 0)
                {
                    j1++;
                    break;
                }
                j1++;
            } while(true);
            i = 0;
            boolean flag = false;
            for(int j2 = j1; j2 < W; j2++)
            {
                if(V[j2] != 0)
                {
                    flag = true;
                    continue;
                }
                if(V[j2] != 0 || !flag)
                    continue;
                i = 1;
                break;
            }

            if(i == 0)
                j1 = W;
label0:
            for(int k2 = 0; k2 < j1; k2++)
            {
                if((i = V[k2]) == 0)
                {
                    int l1 = 0;
                    do
                    {
                        if(l1 >= P.length - 1)
                            continue label0;
                        for(int l2 = 0; l2 < P[l1].length; l2++)
                            if(P[l1][l2] < 0)
                                P[l1][l2] = -P[l1][l2];

                        l1++;
                    } while(true);
                }
                int i2 = i % 128;
                int i3 = (i / 128) % 16;
                i = (i / 2048) % 16;
                P[i][i3] = -i2;
            }

        }
        e _tmp = super.h;
        f.v();
        repaint();
    }

    public final void b()
    {
        u = super.a;
        v = super.b;
        r = (u - 16 - 8) / 15;
        int i;
        if((i = (v - 5 - 5 - 8) / 16) < r)
            r = i;
        z = (16 * (u - 15 * r)) / 24;
        A = (8 * (u - 15 * r)) / 24;
        w = (5 * (v - 16 * r)) / 18;
        if(w > r)
            w = r;
        y = (8 * (v - 16 * r)) / 18;
        if(y > r)
            y = r;
        x = (5 * (v - 16 * r)) / 18;
        if(B == null)
            B = new Image[j.length];
        a(o, B, j.length, 34, 34, r, r, Color.white.getRGB() & 0xffffff, 32);
        if(C == null)
            C = new Image[k.length];
        a(p, C, k.length, 34, 34, r, r, Color.white.getRGB() & 0xffffff, 92);
    }

    final void a(int i, boolean flag)
    {
        S = i;
        R = flag;
    }

    final void a(int ai[], int i, int i1)
    {
        boolean flag = false;
        synchronized(E)
        {
            for(int j1 = 0; j1 < N; j1++)
                O[j1][3] = 0;

label0:
            for(int k1 = i; k1 < i1; k1++)
            {
                int j2 = 0;
                do
                {
                    if(j2 >= N)
                        continue label0;
                    if(O[j2][3] == 0 && O[j2][0] == -(ai[k1] % 128))
                    {
                        O[j2][3] = 1;
                        continue label0;
                    }
                    j2++;
                } while(true);
            }

            int l1 = 0;
            for(int k2 = 0; k2 < N; k2++)
                if(O[k2][3] == 1)
                {
                    if(l1 < k2)
                    {
                        for(int j3 = 0; j3 < O[l1].length; j3++)
                            O[l1][j3] = O[k2][j3];

                    }
                    l1++;
                } else
                {
                    int k3 = O[k2][1];
                    int i4 = O[k2][2];
                    P[i4][k3] = 0;
                    flag = true;
                }

            N = l1;
            for(int l2 = 0; l2 < N; l2++)
                O[l2][3] = 0;

            for(int i3 = i; i3 < i1; i3++)
            {
                int l3 = 0;
                int j4 = -(ai[i3] % 128);
                do
                {
                    if(l3 >= N)
                        break;
                    if(O[l3][3] == 0 && O[l3][0] == j4)
                    {
                        O[l3][3] = 1;
                        break;
                    }
                    l3++;
                } while(true);
                if((l3 != N || l3 >= O.length) && O[l3][2] >= 15 && O[l3][1] <= 7)
                    continue;
                for(i = 0; i < 7 && P[15][i] != 0; i++);
                if(i == 7)
                    break;
                if(l3 < N)
                {
                    int i2 = O[l3][1];
                    int k4 = O[l3][2];
                    P[k4][i2] = 0;
                }
                O[l3][1] = i;
                O[l3][2] = 15;
                P[15][i] = j4;
                if(l3 == N)
                {
                    O[l3][0] = j4;
                    O[l3][3] = 1;
                    N++;
                }
            }

        }
        if(flag)
            repaint();
    }

    private int d(int i)
    {
        if(i < z)
            return -1;
        else
            return (i - z) / r;
    }

    private int e(int i)
    {
        if(i < w)
            return -1;
        if((i -= w) < 15 * r)
            return i / r;
        return (i -= 15 * r) >= y + r + x ? 16 : 15;
    }

    public final Dimension g()
    {
        return new Dimension(444, 466);
    }

    final void j()
    {
        T = System.currentTimeMillis();
        U = true;
    }

    final void k()
    {
        U = true;
    }

    public final void h()
    {
        Graphics g1;
        if((g1 = getGraphics()) == null)
            return;
        long l1;
        if((l1 = ((l1 = System.currentTimeMillis()) - T) % 1500L >= 750L ? 0 : 1) == U)
            return;
        if(((g.m.literaque.e)super.h).s != 1)
            return;
        U = l1;
        for(int i = 0; i < 15; i++)
        {
            boolean flag = false;
            int i1 = 0;
            do
            {
                if(i1 >= 15)
                    break;
                if(P[i][i1] < 0)
                {
                    flag = true;
                    break;
                }
                i1++;
            } while(true);
            if(flag)
                a(i, g1);
        }

    }

    final int[] l()
    {
        Object obj = E;
        JVM INSTR monitorenter ;
        int i;
        i = 0;
        for(int i1 = 0; i1 < N; i1++)
            if(O[i1][1] > 7 && O[i1][2] == 15)
                i++;

        if(i == 0)
            return null;
        int ai[];
        int j1 = 0;
        int k1 = 0;
        ai = new int[i];
        for(int l1 = 0; l1 < N; l1++)
        {
            if(O[l1][1] > 7 && O[l1][2] == 15)
            {
                ai[k1++] = -O[l1][0] % 128;
                P[O[l1][2]][O[l1][1]] = 0;
                continue;
            }
            if(j1 < l1)
            {
                for(int i2 = 0; i2 < O[l1].length; i2++)
                    O[j1][i2] = O[l1][i2];

            }
            j1++;
        }

        N = j1;
        a(15, getGraphics());
        ai;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final int[] m()
    {
        Object obj = E;
        JVM INSTR monitorenter ;
        int i;
        i = 0;
        for(int i1 = 0; i1 < N; i1++)
            if(O[i1][2] < 15)
                i++;

        if(i == 0)
            return null;
        int ai[];
        int j1 = 0;
        ai = new int[i];
        for(int k1 = 0; k1 < N; k1++)
            if(O[k1][2] < 15)
                ai[j1++] = -O[k1][0] % 128 + 128 * (O[k1][1] % 16 + 16 * (O[k1][2] % 16));

        ai;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void n()
    {
        boolean flag = true;
        boolean flag1 = true;
        int i1 = 0;
        int i = 0;
        int j1 = 0;
        int ai[] = null;
        for(int l1 = 0; l1 < N; l1++)
        {
            if(O[l1][2] == 15)
            {
                if(O[l1][1] > 7)
                    i++;
                continue;
            }
            if(O[l1][2] >= 15)
                continue;
            if(ai == null)
                ai = O[l1];
            j1++;
        }

        if(i > 0)
        {
            flag = false;
            flag1 = false;
            i = R;
        } else
        {
            i = 0;
        }
        if(ai != null && j1 > 0)
        {
            i = 0;
            flag1 = false;
            int i2 = ai[1];
            int k1 = ai[2];
            int j2 = i2;
            int k2 = i2;
            int l2 = k1;
            int i3 = k1;
            for(int j3 = 0; j3 < N; j3++)
            {
                int ai1[] = O[j3];
                if(O[j3][2] == 15)
                    continue;
                if(ai1[1] < j2)
                    j2 = ai1[1];
                else
                if(ai1[1] > k2)
                    k2 = ai1[1];
                if(ai1[2] < l2)
                    l2 = ai1[2];
                else
                if(ai1[2] > i3)
                    i3 = ai1[2];
                if(ai1[1] != i2)
                    i2 = -1;
                if(ai1[2] != k1)
                    k1 = -1;
            }

            if(i2 != -1 || k1 != -1)
            {
                i2 = i2 != -1 ? 0 : 1;
                k1 = k1 != -1 ? 0 : 1;
                int k3 = j2;
                int l3 = l2;
                do
                {
                    if(k3 >= k2 && l3 >= i3)
                        break;
                    if(P[l3][k3] == 0)
                    {
                        flag = false;
                        break;
                    }
                    k3 += i2;
                    l3 += k1;
                } while(true);
                boolean flag2 = false;
                if(P[7][7] < 0)
                {
                    if(l2 == 7 && i3 == 7 && j2 <= 7 && k2 >= 7 && k2 - j2 > 0)
                        flag2 = true;
                    else
                    if(j2 == 7 && k2 == 7 && l2 <= 7 && i3 >= 7 && i3 - l2 > 0)
                        flag2 = true;
                } else
                if(j2 == k2)
                {
                    if(e(j2, l2 - 1) || e(j2, i3 + 1))
                        flag2 = true;
                    int i4 = l2;
                    do
                    {
                        if(i4 > i3)
                            break;
                        if(e(j2 - 1, i4) || P[i4][j2] > 0 || e(j2 + 1, i4))
                        {
                            flag2 = true;
                            break;
                        }
                        i4++;
                    } while(true);
                } else
                {
                    if(e(j2 - 1, l2) || e(k2 + 1, l2))
                        flag2 = true;
                    int j4 = j2;
                    do
                    {
                        if(j4 > k2)
                            break;
                        if(e(j4, l2 - 1) || P[l2][j4] > 0 || e(j4, l2 + 1))
                        {
                            flag2 = true;
                            break;
                        }
                        j4++;
                    } while(true);
                }
                if(flag2)
                {
                    if(j1 == 7)
                        i1 += 50;
                    if(j2 == k2)
                    {
                        i1 += c(j2, l2);
                        for(int k4 = l2; k4 <= i3; k4++)
                            if(P[k4][j2] < 0)
                                i1 += b(j2, k4);

                    } else
                    {
                        i1 += b(j2, l2);
                        for(int l4 = j2; l4 <= k2; l4++)
                            if(P[l2][l4] < 0)
                                i1 += c(l4, l2);

                    }
                } else
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        ((g.m.literaque.e)super.h).a(i1, flag, i, flag1);
    }

    private static String l[] = {
        "1", "2", "3", "5"
    };
    private Color m[] = {
        new Color(240, 240, 240), new Color(249, 233, 7), new Color(109, 226, 40), new Color(89, 152, 255), new Color(249, 144, 144)
    };
    private static String n[] = {
        "t0", "t1", "t2", "t3", "star", "t4", "w2", "w3", "sel", "b0", 
        "b1", "b2", "b3", "sel", "b4"
    };
    static Image j[];
    static Image k[];
    private static int o[];
    private static int p[];
    private static int q[][];
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    private int A;
    private Image B[];
    private Image C[];
    private Font D;
    private Object E;
    private Object F;
    private int G[];
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O[][];
    private int P[][];
    private int Q[];
    private boolean R;
    private int S;
    private long T;
    private boolean U;
    private int V[];
    private int W;

}
