package leetcodeAll.leetcode2;

/**
 * 165. Compare Version Numbers
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = s1.length >= s2.length ? s1.length : s2.length;
        for (int i = 0; i < len; i++) {
            int v1 = i < s1.length ? Integer.valueOf(s1[i]) : 0;
            int v2 = i < s2.length ? Integer.valueOf(s2[i]) : 0;
            if (v1 > v2)
                return 1;
            if (v1 < v2)
                return -1;
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = s1.length <= s2.length ? s1.length : s2.length;
        for (int i = 0; i < len; i++) {
            int v1 = Integer.valueOf(s1[i]), v2 = Integer.valueOf(s2[i]);
            if (v1 > v2)
                return 1;
            else if (v1 < v2)
                return -1;
            else
                continue;
        }
        if (s1.length == s2.length)
            return 0;
        String[] s = s1.length > s2.length ? s1 : s2;
        boolean flag = s1.length > s2.length ? true : false;
        for (int i = len; i < s.length; i++)
            if (Integer.valueOf(s[i]) != 0)
                return flag ? 1 : -1;
        return 0;
    }
}
