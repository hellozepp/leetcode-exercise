/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题19：正则表达式匹配
 * // 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 * // 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 * // 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * // 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 */
package offer;

public class Java19_RegularExpressionsMatching {
	public boolean match(char[] str, char[] pattern) {
    	if (str == null || pattern == null) {
			return false;
        }
    	int strIndex = 0;
    	int patternIndex = 0;
    	return matchCore(str, strIndex, pattern, patternIndex);
}

	public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //str到尾，pattern到尾，匹配成功
		if (strIndex == str.length && patternIndex == pattern.length) {
			return true;
        }
        //str未到尾，pattern到尾，匹配失败
		if (strIndex != str.length && patternIndex == pattern.length) {
			return false;
        }
        //str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
		if (strIndex == str.length && patternIndex != pattern.length) {
            //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
			if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
			return false;
		}
        //str未到尾，pattern未到尾
		if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            //三种可能：
                //1、模式串当前字符出现0次，即*表示当前字符出现0次，则str=str,pattern=pattern+2;
                //2、模式串当前字符出现1次，即*表示当前字符出现1次，则str=str+1,pattern=pattern+2;
                //3、模式串当前字符出现2次或2次以上，即*表示当前字符出现2次或以上，则str=str+1,pattern=pattern;
				return matchCore(str, strIndex, pattern, patternIndex + 2)//*匹配0个，跳过
                    || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//*匹配1个，跳过
                    || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } 
			else {
                //直接跳过*（*匹配到0个）
                //如果当前字符不匹配，则只能让*表示当前字符出现0次，则str=str，pattern=pattern+2;
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
      //模式串下一字符不为*
        if (pattern[patternIndex] == str[strIndex] || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}