/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题20：表示数值的字符串
 * // 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * // 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * // “1e3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 */
package offer;

public class Java20_02_NumericStrings {
    boolean isNumeric(char[] s) {
        if (s.length == 0)
            return false;
        if ((s.length == 1) && (s[0] < '0' || s[0] > '9'))
            return false;
        if (s[0] == '+' || s[0] == '-') {
            if (s.length == 2 && (s[1] == '.'))
                return false;
        } else if ((s[0] < '0' || s[0] > '9') && s[0] != '.')
        	// 首位既不是符号也不是数字还不是小数点，当然是false
            return false;
        int i = 1;
        while ((i < s.length) && (s[i] >= '0' && s[i] <= '9'))
        	i++;
        if (i < s.length && s[i] == '.') {
            i++;
            // if(i >= s.length) return false;
            while ((i < s.length) && (s[i] >= '0' && s[i] <= '9'))
                i++;
        }
        if (i < s.length && (s[i] == 'e' || s[i] == 'E')) {
            i++;
            if ((i < s.length) && (s[i] == '+' || s[i] == '-')) {
                i++;
                if (i < s.length)
                    while ((i < s.length) && (s[i] >= '0' && s[i] <= '9'))
                        i++;
                else
                    return false;
            } else if (i < s.length) {
                while ((i < s.length) && (s[i] >= '0' && s[i] <= '9'))
                    i++;
            } else
                return false;
        }
        if (i < s.length)
            return false;
        return true;
    }
}