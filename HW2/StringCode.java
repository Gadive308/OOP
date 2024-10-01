import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str.length() == 0) return 0;

        int maxRun = 1;
        int current = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                current ++;
            } else {
                maxRun = Math.max(maxRun,current);
                current =1;
            }
        }
        maxRun = Math.max(maxRun,current);
        return maxRun;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder kq = new StringBuilder();
        for (int i = 0 ; i < str.length() ; i++) {
            char current = str.charAt(i);
            if (Character.isDigit(current)) {
                if (i+1 < str.length()) {
                    int cnt = current - '0';
                    char next = str.charAt(i+1);
                    for (int j = 0 ; j < cnt ; j++) {
                        kq.append(next);
                    }
                }
            } else {
                kq.append(current);
            }
        }
        return kq.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (len <= 0 || a.length() < len || b.length() < len) {
            return false;
        }

        Set<String> substringsA = new HashSet<>();

        for (int i = 0; i <= a.length() - len; i++) {
            substringsA.add(a.substring(i, i + len));
        }

        for (int i = 0; i <= b.length() - len; i++) {
            if (substringsA.contains(b.substring(i, i + len))) {
                return true;
            }
        }

        return false;
    }
}
