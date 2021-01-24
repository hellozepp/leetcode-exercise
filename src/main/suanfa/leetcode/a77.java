package suanfa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// * 求 1~n 的数组 组成长度为k的数组的所有结果集
// * input n = 4 and k = 2
// * output:
// * [
// * [2,4],
// * [3,4],
// * [2,3],
// * [1,2],
// * [1,3],
// * [1, ],
// * ]
// * <p>
// * 难度2星
public class a77 {

    public static void main(String[] args) {
        ArrayList<List<Integer>> solution = new a77().solution(4, 2);
    }

    ArrayList<List<Integer>> res;

    private ArrayList<List<Integer>> solution(int n, int k) {
        res = new ArrayList<>();
        if (k == 0 || n == 0 || n < k) {
            return res;
        }
        LinkedList<Integer> p = new LinkedList<>();
        combine(n, k, 1, p);
        return res;
    }

    private void combine(int n, int k, int start, LinkedList<Integer> c) {
        if (c.size() == k) {
            res.add((List<Integer>) c.clone());
            System.out.println("add a list,subList:" + c);
            return;
        }
        //优化 i<=n => i<=n-(k-c.size())+1
        /** k-c.size()<=n-i+1; i<=n- (k - c.size()) + 1 */
        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
//        for (int i = k;i<=n;i++){
            System.out.println("n-(k-c.size())+1:" + (n - (k - c.size()) + 1) + ",c:" + c + "," + c.size()+",i:"+i);
            c.addLast(i);
            combine(n, k, i + 1, c);
            c.removeLast();
        }
    }
}
