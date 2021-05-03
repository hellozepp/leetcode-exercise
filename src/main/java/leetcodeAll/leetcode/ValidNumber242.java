package leetcodeAll.leetcode;

/**
 * 65. Valid Number
 * <p>
 *     判断 2个 字符串是否由 相同的字符组成
 *     给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * Validate if a given string is numeric.
 * <p>
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false "2e10" => true
 * <p>
 * Note: It is intended for the problem statement to be ambiguous. You should gather all
 * requirements up front before implementing one.
 *
 * @author Watcher
 */
public class ValidNumber242 {

    /**
     * 设置状态标志位，耗时2ms，最快
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0)
            return false;
        s = s.trim();
        boolean hasE = false, hasDot = false, hasNum = false; // e.number标志位
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9')
                hasNum = true;
            else if (ch == '.') {
                if (hasDot || hasE) // 当前面有.或者e时直接返回false
                    return false;
                hasDot = true;
            } else if (ch == 'e') {
                if (hasE || !hasNum) // 当前面有e或者前面没有数字时返回false
                    return false;
                hasE = true;
                hasNum = false; // hasNum设置为false，后面必须有数字
            } else if (ch == '-' || ch == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') // -+号只能出现在首位或者e的下一位
                    return false;
            } else
                return false;
        }
        return hasNum; // 如果数字合法，hasNum最终一定为true
    }

    /**
     * 正则表达式版本，最简洁，耗时21ms，较慢
     *
     * @param s
     * @return
     */
    public boolean isNumber2(String s) {
        if (s == null || s.trim().length() == 0)
            return false;
        s = s.trim(); // 去掉两侧空格
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        return s.matches(regex);
    }

    /**
     * 最开始想到的方法，从开始直接匹配，考虑遇到的每一种情况。耗时2ms，最快
     *
     * @param s
     * @return
     */
    public boolean isNumber3(String s) {
        s = s.trim();
        char[] str = s.toCharArray();
        if (str.length < 1 || str == null)
            return false;
        if ((str[0] < '0' || str[0] > '9') && str.length == 1)
            return false;
        int i = (str[0] == '-' || str[0] == '+') ? 1 : 0; // 第一个有效位
        if (str[0] == '-' || str[0] == '+') {
            if (!isNumber(s.substring(1)))
                return false;
        }
        int len = str.length;
        int state = 0;
        // 0表示只有数字，1表示先遇到. 2表示先遇到E
        /*
         * if(str[i]<'0'||str[i]>'9') return false; i++; //跳过第一个有效数字
         */
        for (; i < len; i++) {
            char ch = str[i];
            if (ch == '.') {
                state = 1;
                break;
            }
            if (ch == 'e' || ch == 'E') {
                state = 2;
                break;
            }
            if (ch < '0' || ch > '9')
                return false;
        }
        // state=1，遇到了小数点
        if (state == 1) {
            i++; // 移动到小数点的下一位
            /*
             * if(str[i]<'0'||str[i]>'9'||i==len) return false; i++;
             */
            for (; i < len; i++) {
                char ch = str[i];
                if (ch == 'e' || ch == 'E') {
                    state = 2;
                    break;
                }
                if (ch < '0' || ch > '9')
                    return false;
            }
        }
        // state=2,遇到了指数位
        if (state == 2) {
            // 指数位之前必须为合法数字
            if (!isNumber(s.substring(0, i)))
                return false;
            i++; // 指数位的下一位
            if (i == len)
                return false;
            if (str[i] == '-' || str[i] == '+')
                i++;
            if (i == len)
                return false;
            for (; i < len; i++) {
                char ch = str[i];
                if (ch < '0' || ch > '9')
                    return false;
            }
        }
        return true;
    }
}
