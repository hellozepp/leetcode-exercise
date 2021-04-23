package leetcodeAll.leetcode2;

/**
 * 171. Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for (char ch:cs)
            res = res * 26 + ch - 64;
        return res;
    }
}
