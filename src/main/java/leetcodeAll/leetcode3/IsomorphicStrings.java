package leetcodeAll.leetcode3;

/**
 * 205. Isomorphic Strings
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] maps = new int[128];
        int[] mapt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int chs = s.charAt(i);
            int cht = t.charAt(i);
            if (maps[chs] != mapt[cht])
                return false;
            maps[chs] = i + 1;
            mapt[cht] = i + 1;
        }
        return true;
    }

    //--------------solution2----------------
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] maps = new int[128];
        int[] mapt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int chs = s.charAt(i);
            int cht = t.charAt(i);
            if (maps[chs] == 0 && mapt[cht] == 0) {
                maps[chs] = cht;
                mapt[cht] = chs;
            } else if (maps[chs] != cht)
                return false;
        }
        return true;
    }
}
