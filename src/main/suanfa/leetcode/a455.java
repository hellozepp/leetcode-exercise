package suanfa.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class a455 {
    public static void main(String[] args) {
        int s[] = {1,3,2,4};
        int g[] = {1,2};
        System.out.println(solution(s,g));;
    }

    private static int solution(int[] s, int[] g) {
        List<int[]> sList = Arrays.asList(s);
        Arrays.sort(s);
        Arrays.sort(g);
        int si = 0,gi = 0;
        int res =0;
        while (si!=s.length&&gi!=g.length){
            if (s[si]>=g[gi]){
                res++;si++;gi++;
            }else {
                gi++;
            }
        }
        return res;
    }
}
