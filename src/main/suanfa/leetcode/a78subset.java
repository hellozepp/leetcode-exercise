package suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class a78subset {
    public List<List<Integer>> solution(int[] arr){
        if (arr==null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res,list,arr,0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] arr,int index) {
        res.add(new ArrayList<Integer>(list));
        for (int i=index;i<arr.length;i++){
            list.add(arr[i]);
            helper(res,list,arr,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new a78subset().solution(new int[]{1,2,3}));
    }

}
