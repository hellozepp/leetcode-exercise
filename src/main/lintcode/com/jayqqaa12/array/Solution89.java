package com.jayqqaa12.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 gray code
 * <p>
 * 难度 2星
 *
 * @REVIEW
 */
public class Solution89 {

    /**
     * 根据公式来
     * <p>
     * G(i) = i^ (i/2).
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1 << n; i++) {
            list.add(i ^ i >> 1);// ^ 异或运算
//            list.add(i ^ i /2);
        }


        return list;
    }

    public static void main(String[] args) {
        System.out.println(1 << 3);//8 = 2^3
        System.out.println(8 >> 1);//4 = 8/2
        System.out.println(16 >> 1);//8 = 16/2
        System.out.println(22 >> 1);//11 = 22/2
        System.out.println(11 >> 1);//5 1011 -> 0101(5)
        System.out.println(13 >> 1);//6 整除
        System.out.println(0 >> 1);// 0
        System.out.println(1 >> 1);// 0
        System.out.println(new Solution89().grayCode(4));
//        [0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8]
//        [0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8]
    }
}
