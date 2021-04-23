package leetcodeAll.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. Fraction to Recurring Decimal
 */
public class Fraction2RecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator, m = a % b;  //a分子,b分母,m余数
        Map<Long, Integer> map = new HashMap<>();
        if (m == 0)
            return a / b + "";
        StringBuilder sb = new StringBuilder();
        if (a * b < 0)
            sb.append('-');
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b).append('.');
        m = a % b;
        map.put(m, sb.length());
        while (m != 0) {
            a = m * 10;
            sb.append(a / b);
            m = a % b;
            if (map.containsKey(m))
                return sb.insert((int) map.get(m), '(').append(')').toString();
            map.put(m, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Fraction2RecurringDecimal().fractionToDecimal(1, 6));
    }
}
