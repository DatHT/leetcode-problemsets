package TwoPointer;

import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int checkChild = 0;
        int checkCookie = 0;
        while (checkChild < g.length && checkCookie < s.length) {
            if (g[checkChild] <= s[checkCookie]) {
                checkChild++;
                count++;
            }
            checkCookie++;
        }
        return count;
    }
    public int findContentChildren1(int[] g, int[] s) {
        if (s.length == 0 || g.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        if (s[s.length - 1] < g[0]) return 0;
        int pos = 0;
        int end = s.length;
        for (int i = 0; i < g.length; i ++) {
            if (s[0] >= g[i] && pos != 0) {
                pos = i;
            }
            if (s[s.length - 1] < g[i]) {
                end = i;
                break;
            }
        }
        if (end < s.length) return end - pos;
        return Math.min(Math.abs(s.length - pos), g.length);
    }
}
