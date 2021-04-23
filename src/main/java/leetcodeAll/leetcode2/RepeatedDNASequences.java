package leetcodeAll.leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 10)
            return res;
        int cur = 0, mask = 0xfffff;//20bit,10个字母，每个字母占2bit
        byte[] bytes = new byte[1 << 20];
        char[] cs = s.toCharArray();
        //对字母进行编码
        char[] map = new char[256];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
        for (int i = 0; i < 9; i++)
            cur = cur << 2 | map[cs[i]];
        for (int i = 9; i < cs.length; i++) {
            cur = cur << 2 & mask | map[cs[i]];
            if (bytes[cur] == 1) {
                res.add(s.substring(i - 9, i + 1));
                bytes[cur]++;
            }
            if (bytes[cur] == 0)
                bytes[cur]++;
        }
        return res;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set = new HashSet<>(), res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String ten = s.substring(i, i + 10);
            if (!set.add(ten))
                res.add(ten);
        }
        return new ArrayList<>(res);
    }
}
