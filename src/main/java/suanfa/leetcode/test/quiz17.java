package suanfa.leetcode.test;


import java.util.ArrayList;
import java.util.List;

public class quiz17 {
    private static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    List<String> list;

    public static void main(String[] args) {
        System.out.println(new quiz17().solution("234"));
    }

    private List<String> solution(String s) {
        list = new ArrayList<>();
        if (s == null || s.equals("")) {
            return list;
        }
        findConbination(s, 0, "");
        return list;
    }

    private void findConbination(String digits, int index, String s) {
        if (digits.length()==index){
            list.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letter = letterMap[c - '0'];
        for(int i= 0 ;i<letter.length();i++){
            findConbination(digits,index+1,s+letter.charAt(i));
        }

    }
}
