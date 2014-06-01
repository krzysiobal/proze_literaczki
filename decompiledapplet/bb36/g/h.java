// Decompiled Using: FrontEnd Plus v2.03 and the JAD Engine
// Available From: http://www.reflections.ath.cx
// Decompiler options: packimports(3) 

package g;

import java.util.StringTokenizer;

public final class h
{

    public static String[] a(String s)
    {
        String as[] = new String[(s = new StringTokenizer(s, "\n")).countTokens()];
        for(int i = 0; s.hasMoreTokens() && i < as.length;)
            as[i++] = s.nextToken();

        return as;
    }

    public static final Integer a = new Integer(0);
    public static final Integer b = new Integer(1);

}
