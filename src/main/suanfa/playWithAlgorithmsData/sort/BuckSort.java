package suanfa.playWithAlgorithmsData.sort;

import java.util.ArrayList;

public class BuckSort {

    /**
     * Radix sort an array of string. Assume all char are a-z (alph table) 基数排序
     * 对字符串数组进行基数排序。假设所有字符都是a-z（alph表）
     * 比如，"bcao", "bcrd", "cmed", "glpq" 这四个字符串，在第一趟桶排序后，顺序是："bcrd"，"cmed"，"bcao"，"glpq"。即，根据最后一个字符来排序。
     *
     * @param arr
     * @param stringLen All have same length
     */
    public static void raidxSort(String[] arr, int stringLen) {
        final int BUCKETS = 26;
        ArrayList<ArrayList<String>> buckets = new ArrayList<>();


        for (int i = 0; i < BUCKETS; i++)
            buckets.add(new ArrayList<String>());

        for (int pos = stringLen - 1; pos >= 0; pos--)// 一共进行stringLen趟排序
        {
            for (String s : arr)
                buckets.get(s.charAt(pos) - 'a').add(s);// 根据比较的字符将 字符串放到相应的桶中

            int idx = 0;
            for (ArrayList<String> listStr : buckets) {
                for (String str : listStr)
                    arr[idx++] = str;//将桶中的数据放回到原数组中
                listStr.clear();//清空桶中的数据,以便下一趟排序做准备
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"bcao", "bcrd", "cmed", "glpq"};
        raidxSort(arr, 4);
        for (String str : arr) {
            System.out.println(str);
        }
    }
}