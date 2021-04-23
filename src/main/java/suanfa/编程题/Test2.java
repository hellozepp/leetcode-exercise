package suanfa.编程题;

import java.util.ArrayList;

/**
 * 报数到100 ，到3自己退出
 * @Author: zhanglin
 * @Date: 2018/5/16
 * @Time: 下午12:46
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(new Test2().call(100));
    }

    public int call(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return (call1(list, n).get(0));
    }

    public static ArrayList<Integer> call1(ArrayList<Integer> list, int n) {
        if (list.size() == 1) {
            return list;
        }
        int[] arr = new int[n];
        new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!(i % 3 == 0)) {
                list1.add(arr[i]);
            }
        }
        return call1(list1, list1.size());
    }
}
