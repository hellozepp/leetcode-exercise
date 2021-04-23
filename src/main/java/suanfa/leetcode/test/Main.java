package suanfa.leetcode.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(Integer.parseInt(new StringBuffer().append(num).reverse().toString())+num);
        }
    }
}