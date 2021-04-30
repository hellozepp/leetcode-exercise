/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题38：字符串的排列
 * // 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * // 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
package offer;
import java.util.*;

public class Java38_StringPermutation {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if (str == null || str.length() == 0) {
		    return res;
		}
		 char[] charArray = str.toCharArray();
		 HashSet<String> set = new HashSet<String>();
		 PermutationCore(charArray, set, 0);
		 res.addAll(set);
		 Collections.sort(res);
		 return res;
	  }
	
	private void PermutationCore(char[] charArray, HashSet<String> res, int beginIndex) {
		if (charArray == null || charArray.length == 0 || beginIndex < 0 || beginIndex > charArray.length - 1) {
			return;
			}
		if (beginIndex == charArray.length - 1) {
			//递归的出口
			res.add(String.valueOf(charArray));
			}
		else {
			for (int i = beginIndex; i < charArray.length; i++) {
				//将第一个字符与后面的字符交换
				swap(charArray, i , beginIndex);
				//对后面所有的字符进行全排列
				PermutationCore(charArray, res, beginIndex + 1);
				//再将之前交换的字符交换回来，以便第一个字符再与其他字符交换
				swap(charArray, i, beginIndex);
				}
			}
		}
	private void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		}
 }