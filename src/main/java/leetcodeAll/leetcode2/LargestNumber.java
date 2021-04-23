package leetcodeAll.leetcode2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. Largest Number
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = String.valueOf(nums[i]);
        Arrays.sort(arr, (o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return b.compareTo(a);
        });
        if (arr[0].charAt(0) == '0')
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);
        return sb.toString();
    }



    private int judge2(String num1, String num2) {
        String a = num1 + num2;
        String b = num2 + num1;
        return b.compareTo(a);
    }

    public String largestNumber2(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = nums[i];
        Arrays.sort(arr, new MyComparator());
        if (arr[0] == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (Integer num : arr)
            sb.append(num);
        return sb.toString();
    }

    private int judge(Integer o1, Integer o2) {
        long a = Long.valueOf(o1 + "" + o2);
        long b = Long.valueOf(o2 + "" + o1);
        if (a > b)
            return -1;
        else if (a < b)
            return 1;
        else
            return 0;
//        char[] cs1 = (o1 + "" + o2).toCharArray();
//        char[] cs2 = (o2 + "" + o1).toCharArray();
//        for (int i = 0; i < cs1.length; i++)
//            if (cs1[i] - cs2[i] > 0)
//                return -1;
//            else if (cs1[i] - cs2[i] < 0)
//                return 1;
//        return 0;
    }

    private class MyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            long a = Long.valueOf(o1 + "" + o2);
            long b = Long.valueOf(o2 + "" + o1);
            if (a > b)
                return -1;
            else if (a < b)
                return 1;
            else
                return 0;
        }
    }
}
