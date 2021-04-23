package suanfa.interview;

import java.util.HashMap;

//最长不重复子串
public class 不重复不超过k的最大连续子串 {

    private static int solution(String s, int i) {
        if (s == null) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
            while (map.size() > i) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                left++;
            }
            res = Math.max(right - left + 1, res);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int s1 = solution(s, 3);
        System.out.println(s1);
    }


}
