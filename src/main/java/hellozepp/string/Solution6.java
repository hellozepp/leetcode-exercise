package hellozepp.string;


/**
 * 字符串的Z字型打印
 * 转为 zigzag 模式
 * 输入一个字符串和指定的行数，将字符以Z字型输出。
 * 三、举例
 *
 * 例如输入PAYPALISHIRING
 * 　　P A H N
 * 　　APLSIIG
 * 　　Y I R
 * 输出是PAHNAPLSIIGYIR
 * 四、思路
 * （1）首先计算最大的列数，然后根据行数和列数创建一矩阵
 *
 * （2）循环向这个矩阵中写入字符，根据一列和一斜行的顺序来写入
 *
 * （3）最后读出矩阵中的字符，其中这个矩阵可以是一个字符串
 * <p>
 * 难度2星
 */
public class Solution6 {
    public String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() == 0 || numRows >= s.length()) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            sb[j] = new StringBuilder();
        }
        int index = 0;
        while (index < s.length()) {
            for (int i = 0; i < numRows && index < s.length(); i++) {
                sb[i].append(s.charAt(index++));
            }

            for (int j = numRows - 2; index < s.length() && j >= 1; j--) {
                sb[j].append(s.charAt(index++));
            }

        }
        for (int k = 1; k < numRows; k++) {
            sb[0].append(sb[k]);
        }

        return sb[0].toString();
    }

    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows < 2) {
            return s;
        }

        StringBuilder rst = new StringBuilder();
        int lag = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += lag) {
                rst.append(s.charAt(j));
                //非首行和末行时还要加一个
                if (i > 0 && i < numRows - 1) {
                    int t = j + lag - 2 * i;
                    if (t < s.length()) {
                        rst.append(s.charAt(t));
                    }
                }
            }
        }

        return rst.toString();

    }
}