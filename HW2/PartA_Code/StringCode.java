import java.util.*;
public class StringCode {
    static String blowup(String str) {
        String s = "";
        if (str.length() == 0) return "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (('0' <= str.charAt(i)) && (str.charAt(i) <= '9')) {
                for(int j = 1; j <= str.charAt(i) - '0'; j++) {
                    s += str.charAt(i + 1);
                }
            }
            else s += str.charAt(i);
        }
        if ('0' > str.charAt(str.length() - 1) || '9' < str.charAt(str.length() - 1))
            s += str.charAt(str.length() - 1);
        return s;
    }

    static int maxRun(String str) {
        if(str.length() == 0) return 0;
        int m = 1, d = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) d++;
            else {
                m = Math.max(m, d);
                d = 1;
            }

        }
        return Math.max(m, d);
    }

    static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> s = new HashSet<> ();
        for(int i = 0; i <= a.length() - len; i++) {
            s.add(a.substring(i, i + len));
        }
        for(int i = 0; i <= b.length() - len; i++) {
            if(s.contains(b.substring(i, i + len)))
                return true;
        }
        return false;
    }

}