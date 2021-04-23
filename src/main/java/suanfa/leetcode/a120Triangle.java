package suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;

public class a120Triangle {
    /**
     * 给点数组 求从上到下的最短距离每次下移的时候 可以移动到相邻的位置
     * <p>
     * For example, given the following triangle
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * <p>
     * 难度2.5星
     * <p>
     * FIXME
     * @param arr
     */
    public int[] solution(ArrayList<List<Integer>> arr) {
        return null;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();    //行数
        if (row == 0) return 0;

        int[][] res = new int[row][row];  //记录从第一行到每个点的最小值
        int minSum = Integer.MAX_VALUE;       //记录最小的sum
        List<Integer> list0 = triangle.get(0);  //第1行只有一个数，
        if (list0.size() == 0)
            return 0;
        if (row == 1)
            return list0.get(0);
        res[0][0] = list0.get(0);
        for (int i = 1; i < row; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    res[i][j] = res[i - 1][j] + list.get(j);
                } else if (j == list.size() - 1) {
                    res[i][j] = res[i - 1][j - 1] + list.get(j);
                } else {
                    res[i][j] = Math.min(res[i - 1][j - 1], res[i - 1][j]) + list.get(j);
                }
                if (i == row - 1) {
                    if (minSum > res[i][j])
                        minSum = res[i][j];
                }
            }
        }
        return minSum;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();    //行数
        if (row == 0) return 0;

        int[] res = new int[row + 1];       //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了

        for (int i = row - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                res[j] = Math.min(res[j + 1], res[j]) + list.get(j);//最后一行的最小值就是当前数
            }
        }

        return res[0];
    }
    public int quiz(List<List<Integer>> triangle){
        int row = triangle.size();
        if (row==0){
            return 0;
        }
        int[] res =new int[row+1];
        for (int i =row-1;i>=0;i--){
            List<Integer> li = triangle.get(i);
            for (int j=0;j<li.size();j++){
                res[j]=Math.min(res[j+1],res[j])+li.get(j);
            }
        }
        return res[0];
    }


    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> li1 = new ArrayList<>();
        li1.add(2);
        ArrayList<Integer> li2 = new ArrayList<>();
        li2.add(3);
        li2.add(4);
        ArrayList<Integer> li3 = new ArrayList<>();
        li3.add(6);
        li3.add(5);
        li3.add(7);
        ArrayList<Integer> li4 = new ArrayList<>();
        li4.add(4);
        li4.add(1);
        li4.add(8);
        li4.add(3);
        lists.add(li1);
        lists.add(li2);
        lists.add(li3);
        lists.add(li4);
        int i = new a120Triangle().quiz(lists);
        System.out.println(i);
    }
}
