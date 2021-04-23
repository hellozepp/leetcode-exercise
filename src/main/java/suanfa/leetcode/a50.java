package suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class a50 {
    public static int solution(int x ,int n){
        if (n<0){
            return 1/helper(x,n);
        }else {
            return helper(x,n);
        }
    }
    List<Integer> list = new ArrayList<>();
    private static int helper(int x, int n) {
        if (n==0){
            return 1;
        }
        int helper = helper(x, n / 2);
        if (helper%2==0){
            return helper*helper;
        }else {
            return helper*helper*x;
        }
    }

}
