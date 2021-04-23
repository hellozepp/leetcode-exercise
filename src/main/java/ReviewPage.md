# Review Page

This page summarize the solutions of all problems. For thoughts,ideas written in English, refer to deach individual solution. 
New problems will be automatically updated once added.
--------------------------------------------
**快速索引**

<!--GFM-TOC -->
- [50.Pow(x, n)](#50-powx-n)
- [100.Same Tree](#100-same-tree)
- [150.Evaluate Reverse Polish Notation](#150-evaluate-reverse-polish-notation)
- [150.Evaluate Reverse Polish Notation](#150-evaluate-reverse-polish-notation)
<!--GFM-TOC -->

-------------------------
### 1. [Two Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/TwoSum.java)      
- Level: Easy      
- Tags: Array, Hash Table
      

- 哈希表
- 可以使用hashmap，或者自定义一个数组当做伪哈希表

---------------
### 2. [Add Two Numbers](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/AddTwoNumbers.java)    
- Level: Medium     
- Tags:  Linked List, Math
- 注意链表的开始和结尾，需要考虑是否进位
- `ListNode preHead = new ListNode(-1); // new listnode for return`
> 有时候新建一个头结点，会有助于返回结果。这道题新建preHead，最后返回preHead.next
- 最后一位相加后如果产生进位，则需要新建一个值为1的节点

--------------------
### 3. [Longest Substring Without Repeating Characters](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LongestSubstringWithoutRepeatingCharacters.java) 	
- Level: Medium		
- Tags: Hash Table, Two Pointers, String
- 使用长度为128的数组，可以模拟哈希表:int[] chars = new int[128];  chars[i] = index;//i为字符的ASCII值，index为该字符在原字符串中的下标值。
```
		for (int i = 0, j = 0; j < s.length(); j++) {
 			i = Math.max(i, chars[s.charAt(j)]);	
 			max = Math.max(max, j - i);
 			chars[s.charAt(j)] = j;
		}
```		
-----------------------
### 4. [Median of Two Sorted Arrays](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MedianOfTwoSortedArrays.java) 	
- Level: Hard		
- Tags: Array, Binary Search, Divide and Conquer 
- 借用二分查找的思维解决两个数组中中位数的问题，等价于求第k个数：kth(当k分别等于  `left = (m + n + 1) / 2, right = (n + m + 2) / 2; // 下中位数
和上中位数，相加除以2即为中位数)`
>  M[m]和N[n]是长度为m和n的有序数组，假设始终有m <= n,求;kM = M[i]和kN = N[j]是其第k/2个数，若kM > kN,则kth必不在N[0-j]，否则kth必不在M[0-i]，去掉必不存在的部分，求递归求第k-i(k-j)个数即可
```
 		int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
		if (nums1[i - 1] > nums2[j - 1])
			return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
		else
			return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
```			
- 注意递归结束条件：
 
 		if (m > n)
			return findKth(nums2, nums1, k);
		if (m == 0)
			return nums2[k - 1];
		if (k == 1)
			return Math.min(nums1[0], nums2[0]);
			
---------------------
### 5. [Longest Palindromic Substring](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LongestPalindromicSubstring.java) 
- Levle: Medium	
- Tags: String, Dynamic Programming
- 暴力拓展，遍历每一个字符，以此字符为中心向两边拓展，求最大回文长度
- 马拉车算法：求字符串中的最大回文子串长度

------------------------------
### 6. [ZigZag Conversion](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ZigZagConversion.java) 
- Level: Medium		
- Tags: String 
- 找数学规律，把字符串换成012345，便于发现规律

-------------------------------
### 7. [Reverse Integer](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ReverseInteger.java)	
- Level: Easy	
- Tags: Math 
- 按位翻转，或者直接转换成字符串，调用StringBuilder的reverse方法

--------------------------------------
### 8. [String to Integer (atoi)](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/StringToInteger.java) 
- Level: Medium		
- Tags: Math, String
- String.trim() 方法可以移除字符串两侧的空格
- 调用Integer转换数字的时候，用try catch 来处理非法字符：报异常则返回非法输入 

-----------------------------------
### 9. [Palindrome Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/PalindromeNumber.java) 
- Level: Easy 	
- Tags:  Math
- while循环按位计算，如果只是判断回文数字，可以只转换一半
```
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}
		return (x == rev || x == rev / 10);
```
---------------------------------
### 10. [Regular Expression Matching](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RegularExpressionMatching.java) 
- Level: Hard	
- Tags: String, Dynamic Programming, BackTracking 
- 递归改动态规划：用二维数组记录递归的状态，可以省掉重复计算
> 详情参考代码

---------------------------
### 11. [Container With Most Water](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ContainerWithMostWater.java) 
- Level： Medium   
- Tags： Array, Two Pointers 
- 限制容量大小的一定是短板，所以短板指针向长板移动，相乘的结果有可能比原来更大，如果长板向短板移动，乘积一定比原来更小
- 状态转移，数学关系判断

---------------------------
### 12. [Integer to Roman](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/IntegerToRoman.java) 
- Level: Medium	
- Tags: Math, String 
- 整数的每一位对应一个罗马数字，123 = 100 + 20 + 3，用3个罗马数字即可表示
- 记录每一个罗马数字对应的整数
> `return nums4[num / 1000] + nums3[(num % 1000) / 100] + nums2[(num % 100) / 10] + nums1[num % 10];`

------------------------------
### 13. [Roman to Integer](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RomanToInteger.java) 
- Level: Easy		
- Tags: Math, String
-  把罗马数字转换成整数放入数组，累加求和，当出现当前数小于后面的数，说明是特殊情况
- 从整体考虑，不要沦陷进细节中

----------------------
### 14. [Longest Common Prefix](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LongestCommonPrefix.java)	
- Level: Easy		
- Tags: String 
- 很无聊的题，虽然官方Solution中给出了多种方法，这道题依旧很烂
- 从左到右依次判断最长前缀，借助一个获取两个字符串共同前缀的函数，一旦遇到字符串为空，直接返回""
- 讨论区有人给出二分法查找共同前缀长度，运行速度比直接匹配快2ms（二分法5ms，直接匹配7ms），其实差距不大，没必要用二分法

-------------------------------
### 15. [3Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/threeSum.java)
- Level: Medium
- Tags: Array, Two Pointers 
- 先排序，遍历数组确定第一个数，剩下两个数从两头遍历
- 注意一定要跳过不需要计算的数，不然会浪费大量时间
> 第一个数不需要重复选取，第二第三个数选定后不需要选取相等的数
```
		if (i == 0 || nums[i] != nums[i - 1]) {···}
		
		if (nums[j] + nums[k] == a) {
			listAll.add(Arrays.asList(nums[i], nums[j], nums[k]));
			while (j < k && nums[j] == nums[j + 1])
				j++;
			while (j < k && nums[k] == nums[k - 1])
				k--;
			j++;
			k--;
		}
```

-------------------------------
### 16. [3Sum Closest](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Sum3Closest.java)
- Level: Medium
- Tags: Array, Two Pointers 
- 双指针问题，一大一小往中间移动
- 和3Sum类似，区别在于这里需要返回三个数值之和，所求的三个数之和需要与输入最接近，可以使用math函数
```
					if (diff > Math.abs(a + nums[j] + nums[k] - target)) {
						diff = Math.abs(a + nums[j] + nums[k] - target);
						res = a + nums[j] + nums[k];
					}
```
- 具体细节参考代码

---------------------
### 17. [Letter Combinations of a Phone Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LetterCombinationsOfAPhoneNumber.java) 
- Level: Medium
- Tags: String, Backtracking
- 遍历字符数组和list，按顺序拼接，注意使用LinkedList，因为LinkedList增删快。详情参考代码

- 回溯法： 不熟悉，有待了解



----------------------
### 18. [4Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Sum4.java)
- Level: Medium
- Tags: Array, Hash Table, Two Pointers
- 类似于3Sum和2Sum，先确定两个数，然后从两端筛选其余两个数。
- 注意过滤条件，过滤掉不符合的情况，可以极大地提高代码的运行效率
> 过滤条件设置不足时耗时46ms，超过77%，新增几个过滤之后耗时14ms，超过100%
- 详情参考代码



-----------------------
### 19. [Remove Nth Node From End of List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RemoveNthNodeFromEndOfList.java)
- Level: Medium
- Tags: LinkedList, Two Pointers
- 设置指向头结点的结点，最后返回 preHead.next
```
	ListNode preHead = new ListNode(-1);	
	preHead.next = head;
```
- 注意结点移动的边界
- 其余参考代码


-------------------
### 20. [Valid Parentheses](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ValidParentheses.java)
- Level: Easy
- Tags: String, Stack 
- 用栈实现括号匹配，或者自定义数组模仿栈
- 详情参考代码

---------
### 21. [Merge Two Sorted Lists](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MergeTwoSortedLists.java)
- Level: Easy
- Tags: LinkedList
- 注意开始部分的null值判断，如果其中一个为null，直接返回另一个
- 非递归版： 新建头结点，依次判断两个链表的值，最后链接上剩余部分
- 递归版： 简单实用，想法值得借鉴
```
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
```

-------------
### 22. [Generate Parentheses](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/GenerateParentheses.java)
- Level: Medium
- Tags: String, BackTracking 
- 回溯法，用StringBuilder代替String拼接，可以提速些许
- 注意right < left 过程中，右括号的长度一定不大左括号
```
		if (left + right == n * 2)
			list.add(str.toString());
		if (left < n) {
			backtrack(list, str.append("("), left + 1, right, n);
			str.deleteCharAt(str.length() - 1);
		}
		if (right < left) {
			backtrack(list, str.append(")"), left, right + 1, n);
			str.deleteCharAt(str.length() - 1);
		}
```
- 还有遍历集合拼接法，详情参考代码


----------------
### 23. [Merge k Sorted Lists](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MergeKSortedLists.java)
- Level: Hard
- Tags: LinkedList, Heap, Divide and Conquer 
- 归并排序思路对多路链表归并，需要先实现两路归并
- 归并过程如下：
```
		while (len > 1) {
			for (int i = 0; i < len / 2; i++) {
				lists[i] = merge2List(lists[i], lists[len - 1 - i]);
			}
			len = (len + 1) / 2;
		}
```
- 同样可以利用优先级队列，相当于堆排序过程，速度较归并慢一点，详情参考代码

---------------------
### 24. [Swap Nodes in Pairs](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SwapNodesInPairs.java)
- Level: Medium
- Tags: LinkedList 
- 递归版：简单明了，就是不知道是否符合题目常数空间复杂度的要求
- 非递归版：额外空间少，速度上差不多
> 非递归版注意设置节点的先驱节点，新建一个用于返回的头节点即可
- 详情参考代码


------------------------
### 25. [Reverse Nodes in k-Group](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ReverseNodesInKGroup.java)
- Level: Hard
- Tags: LinkedList
- 递归版：容易实现
- 非递归版，叫麻烦，注意重排后的端点连接
- 详情参考代码

-----------------------
### 26. [Remove Duplicates from Sorted Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RemoveDuplicatesFromSortedArray.java)
- Level: Easy
- Tags: Array, Two Pointers 
- 设置一个不重复元素的下标，自增覆盖···
- 无意义的一道题

------------------
### 27. [Remove Element](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RemoveElement.java)
- Level: Easy
- Tags: Array, Two Pointers
- 类似于26题，同样无聊的一题
- 毫无参考必要

-----------------------
### 28. [Implement strStr()](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ImplementStrStr.java)
- Level: Easy
- Tags: String, Two Pointers
- 烂题三连发，自定义实现String.indexOf()函数
- 拼手速的题

-------------------
### 29. [Divide Two Integers](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/DivideTwoIntegers.java)
- Level: Medium
- Tags: Math, Binary Search 
- 利用二分查找思路。
```
		while (dvs <= dvd) {
			long tmp = dvs;
			int mul = 1;
			while (dvd > (tmp << 1)) {
				tmp <<= 1;
				mul <<= 1;
			}
			res += mul;
			dvd -= tmp;
		}
```

------------------
### 30. [Substring with Concatenation of All Words](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SubstringWithConcatenationOfAllWords.java)
- Level: Hard
- Tags: Hash Table, Two Pointers, String 
- 双指针滑动窗口问题，重点掌握，参考代码
- 将字符串存入哈希表，滑动窗口过程中修改字符串对应的个数，根据不同状态做出相应处理
- 窗口右边往右移动，修改map数值，窗口左边往右移动时，恢复map的数值
- 思路：
> 将words数组中的字符串存入hashmap，值为出现次数。然后开始遍历字符串s，外层循环从0到word[0].length-1，内层循环从i到最后(需判断最后是否越界)，内层循环每次增加一个word的长度，这样外层循环完毕后刚好遍历完所有情况。（注意，words中的每一个word长度相同，所以才可以这样遍历）
维持一个滑动窗口，左右边界都只向右移动，每次先移动right，窗口大小表示匹配到的word个数，随着移动而增大或减小。移动right，如果map中存在当前字符串，修改map中对应word的个数，一旦发现当前需要修改的个数已经为0，说明出现了多余的字符串，窗口需要更新，这时候开始移动窗口左边界，直到左边界滑过与当前字符串相同的字符串，滑动左边界的同时把map中对应字符串的个数加回来。  如果当前map中找不到cur（当前字符串），说明cur之前的窗口已经没用了，重置窗口大小为0，将left到right的map值加回来，然后从下一个位置重新开始匹配。
当窗口大小与words长度相同时，说明s中从left到right+wLen这一部分刚好可以匹配words，将left存入list即可。

------------------
### 31. [Next Permutation](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/NextPermutation.java)
- Level: Medium
- Tags: Array 
- 从右到左找到第一个小于右边的数，然后在这个数的右边再从右到左找到第一个大于这个数的数，交换这两个数，然后再将这个数右边的数逆序即可。
- 详情参考代码

------------------------
### 32. [Next Permutation](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/NextPermutation.java)
- Level: Hard
- Tags: String, Dynamic Programming
- 简易版，利用栈实现，栈中存放下标值，配合辅助状态数组实现。
- 升级版，利用动态规划实现。注意状态转移和情况分析

----------------------
### 33. [Search in Rotated Sorted Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SearchInRotatedSortedArray.java)
- Level: Medium
- Tags: Array, Binary Search
- 变异的二分查找：根据反转点的位置来区分查找范围，根据大小关系可确定一种唯一的二分方向，其余的是另一方向。
- 比如，当反转点在左边(561234)时，若```nums[mid] < target && nums[hi] >= target``` 则target必在mid与hi之间，否则在lo与mid之间
- 可实现递归与非递归，具体参考代码

--------------------------
### 34. [Find First and Last Position of Element in Sorted Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/FindFirstAndLastPositionOfElementInSortedArray.java)
- Level: Medium
- Tags: Array, Binary Search
- 二分查找相同数字的长度
- 注意边界数值判断即可，具体参考代码

------------------
### 35. [Search Insert Position](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SearchInsertPosition.java)
- Level: Medium
- Tags: Array, Binary Search
- 考察二分查找的下标转移，如果二分查找结束时尚未找到目标，则lo=hi+1，且nums[lo]>target,nums[hi]<target，插入位置应该是lo，或者hi+1

---------------------
### 36. [Valid Sudoku](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ValidSudoku.java)
- Level: Medium
- Tags: Hash Table
- 出题不严谨
- 可以记录每一个数的行列号，配上String形式的标志，放入set中，一旦出现重复的，返回false
- 或者利用三个数组分别记录行列和块，可以用一维数组实现，用每一个数的二进制记录状态
- 具体参考代码

-----------------------
### 37. [Sudoku Solver](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SudokuSolver.java)
- Level: Hard
- Tags: Hash Table, BackTracking
- 填充数独，回溯问题。注意回溯的终止条件和递归入口，及状态回溯
- 详情参考代码

--------------------------------
### 38. [Count and Say](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/CountAndSay.java)
- Level: Easy
- Tags: String
- 迭代，递归调用，字符串拼接。
- 把字符串切割成字符数组，用StringBuilder代替String可以提高效率

---------------------
### 39. [Combination Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/combinationSum.java)
- Level: Medium
- Tags: Array, BackTracking
- 回溯，DFS，勤加练习，注意终止条件和递归时的状态变化
- 疑问？：回溯过程用到的集合，ArrayList的耗时比Linkedlist要快1-2ms，不知道为什么？

-------------------
### 40. [Combination Sum II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/CombinationSumII.java)
- Level: Medium
- Tags: Array, BackTracking
- 与39题类似，区别在于这里数组中有重复的数，且不可重复使用
- 代码和39题的几乎一样，区别在于这里解决每个数只用一次需要在递归的时候从index+1开始，解决返回集合中的重复元素需要增加过滤条件：
```
//这个if可以过滤掉重复结果集合，因为递归调用已经遍历了重复元素有可能有效的情况，下次循环的时候就没必要再次调用了。
if (i > index && candidates[i] == candidates[i - 1])
	continue;
```


-------------------
### 41. [First Missing Positive](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/FirstMissingPositive.java)
- Level: Hard
- Tags: Array 
- 将数组中的整数放到对应的下标处，最后遍历数组找到第一个没有归位的下标，返回下标+1
- 注意：越界则不需要处理，需要交换的两个值相等也不需要处理

----------------------
### 42. [Trapping Rain Water](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/TrappingRainWater.java)
- Level: Hard
- Tags: Array, Two Pointers, Stack
- 一开始用削减方法实现，耗时16ms，比较直观，容易理解，具体参考代码
- 双指针方法实现较为快捷，以左右两边较短的一边为有效方向，保存有效方向的最大高度，每次更新最大高度或者计算存水量。
- 双指针每次移动指针，有两种状态，要么更新长度，要么计算结果
- 简化版双指针：耗时多了2ms，但是代码少了一半，利用三目运算符达到赋值和递增的目的
```
while (left < right) {
	int lower = height[left] <= height[right] ? left++ : right--;
	maxHeight = Math.max(maxHeight, height[lower]);
	res += maxHeight - height[lower];
}
```

-----------------------
### 43. [Multiply Strings](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MultiplyStrings.java)
- Level: Medium
- Tags: Math, String
- 两个数相乘，第i位与第j位相乘后的数位于第i+j位上，将乘积所在位相等的数累加，最后再相加，处理进位。
```
	//int[] mul = new int[n1.length+n2.length-1]; 存放了所有对应为乘积
	for(int i=0;i<n1.length;i++){
		for(int j=0;j<n2.length;j++){
			mul[i+j]+=(n1[i] - '0') * (n2[j] - '0');
		}
	}
```
- 另有两种方法，详情参考代码

------------------------
### 44. [Wildcard Matching](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/WildcardMatching.java)
- Level: Hard
- Tags: String, BackTracking, Dynamic Programming, Greedy
- 记录p串最后一个出现的*的位置，一旦不符合条件，p从新从这个位置出发匹配。
- 动态规划版本：参考代码。
- dfs：遇到*时，循环比较s剩余部分和p剩余部分。

-----------------------
### 45. [Jump Game II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/JumpGameII.java)
- Level: Hard
- Tags: Array, Greedy
- 贪心和bfs
- 两种思维：1，维护一个最远位置和当前位置(当前的下一步所能达到的最远位置)，每次往前走一步，每次更新最远位置，当i超过了当前位置，就跳一步到最远位置，当i超过了最远位置，说明困在了原地。
- 2，每次检测能达到的最远位置，更新下一步


------------------
### 46. [Permutations](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Permutations.java)
- Level: Medium
- Tags: BackTracking
- 回溯，每次都从头开始添加，跳过已经添加的即可。
```
	if (list.size() == nums.length)
		res.add(new ArrayList<>(list));
	else {
		for (int i = 0; i < nums.length; i++) {
			if (!list.contains(nums[i])) {
				list.add(nums[i]);
				backtrack(nums, res, list);
				list.remove(list.size() - 1);
			}
		}
	}
```


--------------------
### 47. [Permutations II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/PermutationsII.java)
- Level: Medium
- Tags: BackTracking
- 回溯，需要维护一个状态数组，已添加过的或者和前一个数值相等且前一个未添加过，则跳过。
```
	if (list.size() == nums.length)
		res.add(new ArrayList<>(list));
	else {
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
				continue;
			list.add(nums[i]);
			used[i] = true;
			backtrack(nums, res, list, used);
			list.remove(list.size() - 1);
			used[i] = false;
		}
	}
```

---------------------
### 48. [Rotate Image](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RotateImage.java)
- Level: Medium
- Tags: Array
- 矩阵顺时针旋转90°
- 1，先转置，再逐行逆序 注意转置时的索引开始 

```

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			matrix[i][j] = matrix[i][j] ^ matrix[j][i];
			matrix[j][i] = matrix[i][j] ^ matrix[j][i];
			matrix[i][j] = matrix[i][j] ^ matrix[j][i];
		}
	}
```
- 2，直接转圈交换，参考代码

--------------------
### 49. [Group Anagrams](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/GroupAnagrams.java)
- Level: Medium
- Tags: Hash Table, String 
- 哈希表
- 添加list到返回集合中时：不需要再次遍历map，直接添加到res即可，引用对象，res中存放的时地址值
- 可以用素数表示每一个字符，一个字符串转化成每一个字符对应素数的乘积，作为key值存入map，可以省去直接对str中字符排序，时间复杂度上要提升一些


-----------------------
### 50. [Pow(x, n)](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/PowXN.java)
- Level: Medium
- Tags: Math, Binary Search
- 二分法：
- 直接二分递增
- 二分递归调用
- 参考代码


-----------------
### 51. [N-Queens](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/N_Queens.java)
- Level: Hard
- Tags: BackTracking
- 回溯：每一行必须找到一个有效位置，所以，不需要外层循环。（参考代码）
- 可以使用一个一维数组记录列的情况，使用两个一维数组记录每一个对角线的特征：
```
	boolean[] cols = new boolean[n],rDiag = new boolean[2 * n - 1], cDiag = new boolean[2 * n - 1];
	cols[col] = true;
	rDiag[row + col] = true;
	cDiag[n - 1 + col - row] = true;
```




--------------------
### 52. [N-Queens II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/N_QueenII.java)
- Level: Hard
- Tags: BackTracking
- 上一道题的简化版
- 详情参考代码

--------------------
### 53. [Maximum Subarray](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MaximumSubarray.java)
- Level: Easy
- Tags: Array, Divide and Conquer, Dynamic Programming
- 依次累加，若为负数，重置为0即可


------------------------
### 54. [Spiral Matrix](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SpiralMatrix.java)
- Level: Medium
- Tags: Array
- 旋转打印二维数组，取左上角和右下角，顺时针打印，然后每次往右下和左上缩进。
- 注意当只有一行或者一列的时候，直接输出。

-----------------------------
### 55. [Jump Game](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/JumpGame.java)
- Level: Medium
- Tags: Array, Greedy 
- 简化版跳跃游戏，当i>next时返回false
- 详情参考代码

-----------------------------
### 56. [Merge Intervals](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MergeIntervals.java)
- Level: Medium
- Tags: Array, Sort
- 两种方案：
- 1，直接排序，从头判断合并
- 2，将start和end单独放进一维数组，遍历start，当start[i+1]>end[i]时，说明出现断裂，将前面的添加到结果集，然后下次从i+1作为新的开始。
```
	for (int i = 0, j = 0; i < size; i++) {
		if (i == size - 1 || starts[i + 1] > ends[i]) {
			res.add(new Interval(starts[j], ends[i]));
			j = i + 1;
		}
	}
```

---------------
### 57. [Insert Interval](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/InsertInterval.java)
- Level: Hard
- Tags: Array, Sort
- 56题的升级版，直接用56题的方法改一下也能通过，不过耗时略长
- 关键在于如何将新的区间插入到合适的位置
- 只需要在 `cur.start > newInterval.end`时插入newInterval，然后将cur赋值给newInterval，最后需要将newInterval加入结果集
```
	else if (cur.start > newInterval.end) {
		res.add(newInterval);
		newInterval = cur;
```
- 详情参考代码



------------------
### 58. [Length of Last Word](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LengthOfLastWord.java)
- Level: Easy
- Tags: String
- 去掉结尾空格，计算从最后到前一个空格的长度即可
- 自定义指针计数比调用String类方法要快


--------------
### 59. [Spiral Matrix II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SpiralMatrixII.java)
- Level: Medium
- Tags: Array
- 54题的变形，同样的方法，改成逐个填数字就行。参考代码


---------------------
### 60. [Permutation Sequence](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/PermutationSequence.java)
- Level: Medium
- Tags: Math, BackTracking
- 直接回溯超时
- 每次根据k和n-1!决定首位的数字，循环或者递归即可。
- 详情参考代码


-------------------
### 61. [Rotate List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RotateList.java)
- Level: Medium
- Tags: Linked List, Two Pointers 
- 记录头结点或者先连成环，再找到最终的切断点即可。
- 注意k值需要对链表长度取余，节省没必要的运算

------------------------
### 62. [Unique Paths](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/UniquePaths.java)
- Level: Medium
- Tags: Array, Dynamic Programming
- 动态规划，当前路径总数等于左边的+上边的。`dp[i][j] = dp[i - 1][j] + dp[i][j - 1];`
- 循环相加即可，只需要初始化`dp[0][1] = 1;`
- 具体参考代码

-----------------
### 63. [Unique Paths II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/UniquePathsII.java)
- Level: Medium
- Tags: Array, Dynamic Programming
- 动态规划，62题的变种，只需要跳过障碍即可
```

	if (obstacleGrid[i - 1][j - 1] == 1)
			continue;
```


----------------------
### 64. [Minimum Path Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MinimumPathSum.java)
- Level: Medium
- Tags: Array, Dynamic Programming
- 前两题的进化版：
- 当前位置的结果同样只与左边和上边有关。
- 只需要在原数组的基础上叠加，首行和首列不参与比较大小，且初始位置需要跳过。
- 具体参考代码

---------------------
### 65. [Valid Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ValidNumber.java) 	
- Level: Hard		
- Tags: Math, String 
- 设置状态标志位，每一个位置都对应一个状态。注意hasE = true后将hasNum设为false
>	`boolean hasE = false, hasDot = false, hasNum = false; // e.number标志位`
- 正则表达式：
>	`String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";`

-----------------------
### 66. [Plus One](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/PlusOne.java)
- Level: Easy
- Tags: Math, Array
- 注意进位标志即可。若最后一位仍旧进位再新建一个长度加一的数组，否则返回原数组
- 再原数组上直接运算

--------------------
### 67. [Add Binary](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/AddBinary.java)
- Level: Easy
- Tags: Math, String
- 注意长度不同和进位即可，参考代码
- 可采如下措施保证第一个字符串的长度始终不小于第二个
```
	if (a.length() < b.length())
		return addBinary(b, a);
```

-------------------
### 68. [Text Justification](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/TextJustification.java)
- Level: Hard
- Tags: String
- 字符串操作，尽量使用StringBuilder代替String操作字符串。
- 边界条件和细节方面多加注意
- 其余参考代码

-------------------------------
### 69. [Sqrt(x)](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Sqrtx.java)
- Level: Easy
- Tags: Math, Binary Search
- 二分查找，两种方式见代码
- 二分过程中注意： `while(start <= end){···}  start = mid + 1; end = mid - 1;`

-----------------

### 70. [Climbing Stairs](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ClimbingStairs.java)
- Level: Easy
- Tags: Dynamic Programming 
- 暴力递归超时
- 最简单的动态规划，记忆前面的数值

---------------
### 71. [Simplify Path](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SimplifyPath.java)
- Level: Easy
- Tags: String, Stack
- 使用String.split()切割和栈可简单实现
- 也可以维护一个下标，在数组上直接操作，用下标和数组模拟栈的功能
- 有更快的实现方式，但更复杂一些，将字符串转换成字符数组，考虑各种情况后得到最后结果。参见代码

-----------------------
### 72. [Edit Distance](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/EditDistance.java)
- Level: Hard
- Tags: String, Dynamic Programming
- 经典动态规划，参考牛客网直通BAT算法精讲 动态规划2
- 两种实现方式参见代码

-------------------
### 73. [Set Matrix Zeroes](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SetMatrixZeroes.java)
- Level: Medium
- Tags: Array
- O(m+n)和O(n)时间复杂度容易实现
- O(1)空间复杂度：不使用额外空间的方法类似，就是把第一行和第一列作为标记。  首先  先判断第一行第一列是否含有0，并用两个bool变量记录起来。其次，遍历其他行和列，如果有0，就把该元素所在的行和列  分别记录起来，即把第一列的该行置0，把第一行的该列置为0；比如 ` matrix[1][2]==0`,那么，把`matrix[i][0]`和`matrix[0][j]`都置零。这样，遍历一遍之后就把所有的行和列都在第一行和第一列中体现出来。接下来就是，根据第一行和第一列的0元素，把其所在的行和列置0，不包括第一行和第一列。再接下来，就是根据前面的boolean标记判断是否把第一行和第一列置零。

-------------------
### 74. [Search a 2D Matrix](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Searcha2DMatrix.java)
- Level: Medium
- Tags: Array, Binary Search
- 从左下角开始找
- 可利用二分查找提高速度

-----------------
### 75. [Sort Colors](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SortColors.java)
- Level: Medium
- Tags: Array, Two Pointers, Sort
- 荷兰国旗问题，和优化后的快速排序中的一次排序方法一样
- 维护一个less，一个more，根据当前的值来移动两个指针
- 顺便复习优化后的随机快排：  [quickSort](https://github.com/lanrengufeng/ZuoShenSuanFa/blob/master/src/chuji/Class2.java)

-------------------------
### 76. [Minimum Window Substring](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MinimumWindowSubstring.java)
- Level: Hard
- Tags: Hash Table, Two Pointers, String
- 字符的hashmap可以使用int数组实现
- 转换关系和循环边界条件参见代码

---------------------
### 77. [Combinations](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Combinations.java)
- Level: Medium
- Tags: BackTracking
- 回溯：注意设置过滤条件
```
	for (int i = index; i <= n; i++) {
		if (n - i + 1 + list.size() < k)
			return;
		list.add(i);
		backtrack(res, list, i + 1, n, k);
		list.remove(list.size() - 1);
	}
```


------------------------
### 78. [Subsets](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/Subsets.java)
- Level: Medium|Java| 
- Tags: BackTracking, Array, Bit Manipulation ||
- 最直接的回溯，不需要任何条件设置，直接回溯调用即可

----------------
### 79. [Word Search](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/WordSearch.java)
- Level: Medium
- Tags: BackTracking, Array
- 审题很重要
- 关键在于从数组中找到和字符串的首字符相同的字符，然后再进入回溯
- 回溯过程中只需要考虑当前字符的上下左右
```

	used[i][j] = true;
	if (backtrack(board, word, used, i, j + 1, index + 1) || backtrack(board, word, used, i + 1, j, index + 1)
			|| backtrack(board, word, used, i, j - 1, index + 1) || backtrack(board, word, used, i - 1, j, index + 1))
		return true;
	else
		used[i][j] = false;
```

------------------
### 80. [Remove Duplicates from Sorted Array II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RemoveDuplicatesFromSortedArrayII.java)
- Level: Medium
- Tags: Array, Two Pointers
- 两种方案：
- 1，维护一个Boolean标志，一旦首次出现重复值时置true，根据数组的值和flag来更改数组的值
- 2，i是有效位，则只需要判断数组当前值cur和nums[i-2]是否相等即可。
```

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		}
		return i;
	}
```

---------------------
### 81. [Search in Rotated Sorted Array II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SearchInRotatedSortedArrayII.java)
- Level: Medium
- Tags: Array, Binary Search
- 二分查找  [Search in Rotated Sorted Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SearchInRotatedSortedArray.java) 的升级版
- 1，利用递归，一旦出现中点和端点相等的情况，舍弃一半，返回两种情况的或值。  参考代码中的递归实现方式
- 2，和之前一样，不过在区分反转点的时候，加一个mid等于端点值得情况，一旦如此，则hi--，即此时只缩减一位，直到不冲突的时候再使用二分。

-------------------------
### 82. [Remove Duplicates from Sorted List II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RemoveDuplicatesFromSortedListII.java)
- Level: Medium
- Tags: Linked List
- 节点通过引用地址传值，直接赋值，赋的是地址值
- 递归版 
- 循环递归版
- 参考代码 

----------------------
### 83. [Remove Duplicates from Sorted List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RemoveDuplicatesFromSortedList.java)
- Level: Easy
- Tags: Linked List
- 简单的节点转移，细心点即可
- 递归实现更简单

--------------------
### 84. [Largest Rectangle in Histogram](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LargestRectangleInHistogram.java)
- Level: Hard
- Tags: Array, Stack
- 暴力解法耗时贼长
- 使用一个栈，存放遍历过的每一个数，保证栈中的数是非递减的，一旦出现比栈顶小的数，则更新最大值，并将栈中大于此数的值改为这个数。
- 其实不需要栈，可以在原数组上直接修改，比使用栈更方便简单，原理同使用栈一样。
- 详情参考代码

-------------------------
### 85. [Maximal Rectangle](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MaximalRectangle.java)
- Level: Hard
- Tags: Array, Hash Table, Dynamic Programming, Stack
- 做一个长度为原矩阵宽度一样的数组，```int[] heights = new int[n];``` 用来存放当前列1的最大连续高度，循环遍历matrix的每一行，统计当前行对应的heights
- 对每一行的heights数组，利用 84. [Largest Rectangle in Histogram](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/LargestRectangleInHistogram.java) 的结论，求出最终结果。
- heights数组可以复用，详情参见代码
- 本题相当于m行个84题对应的柱状图，调用m次84题的方法即可

-----------------------
### 86. [Partition List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/PartitionList.java)
- Level: Medium
- Tags: Linked List, Two Pointers
- 新建头结点
- 新建头结点的引用，表示当前节点，当前节点第一次起作用时，相当于更改头结点的next指针，之后当前节点指向别的对象，不再和头结点指向同一个位置。
- 所以不需要下面这样赋初值
```

	if(preHead.next==null)
		preHead.next = head;
```


------------------------
### 87. [Scramble String](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ScrambleString.java)
- Level: Hard
- Tags: String, Dynamic Programming
- 剪枝后的递归比动态规划要快
- 递归遍历所有情况，可首先判断当前字符串的字符数量和组成情况是否一样，来削减递归深度

--------------------
### 88. [Merge Sorted Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/MergeSortedArray.java)
- Level: Easy
- Tags: Array, Two Pointers
- 从前往后插入数据，需要大小为m+n的辅助空间
- 从后往前插入数据，直接插入到nums1即可，不需要额外空间，且只要nums2中的数据用完，全部数据便已经就位

---------------------
### 89. [Gray Code](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/GrayCode.java)
- Level: Medium
- Tags: Backtracking
- 每次从后往前遍历list，增加2^i即可。
- 或者使用异或操作，从0开始，代码如下，perfect
```

	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		n = 1 << n;
		for (int i = 0; i < n; i++)
			res.add(i ^ (i >> 1));
		return res;
	}
```

------------------
### 90. [Subsets II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SubsetsII.java)
- Level: Medium
- Tags: Array, Backtracking
- 经典回溯，跳过重复元素即可
```

	if (i > index && nums[i] == nums[i - 1])
		continue;
```

---------------
### 91. [Decode Ways](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/DecodeWays.java)
- Level: Medium
- Tags: String, Dynamic Programming ||
- 关键在于处理中间的0
- 开头为0或者中间有连续的0直接返回0，中间有0则 `dp[i + 1] = dp[i] = dp[i - 1];`

-----------------
### 92. [Reverse Linked List II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ReverseLinkedListII.java)
- Level: Medium
- Tags: Linked List
- 设置头结点用于返回结果
- 记录需要翻转的链表的第一个结点的前置结点，用于连接反转后的链表
- 从需要翻转的第一个结点开始往后遍历，将其插入到最后一个结点的后面，直至遍历到最后一个结点为止，然后将前面记录的前置结点与当前结点连接，返回头结点的下一个结点即可

---------------------
### 93. [Restore IP Addresses](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RestoreIPAddresses.java)
- Level: Medium
- Tags: String, Backtracking
- 注意不能出现以0打头的两位及以上的数，或者大于255的数
- 可使用集合完成回溯过程
- 也可以申请一个长度为字符串长度加3的字符数组，用于存储最终的ip地址，比使用集合效率更高

-------------------
### 94. [Binary Tree Inorder Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/BinaryTreeInorderTraversal.java)
- Level: Medium
- Tags: Hash Table, Stack, Tree
- 中序遍历二叉树
- 递归版，打印放中间即可
- 非递归版，借助于栈，先遍历左子树，直到为null，弹出栈顶并打印，转向右子树

--------------------
### 95. [Unique Binary Search Trees II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/UniqueBinarySearchTreesII.java)
- Level: Medium
- Tags: Dynamic Programming, Tree
- 递归遍历，哈希表记录状态

-------------
### 96. [Unique Binary Search Trees](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/UniqueBinarySearchTrees.java)
- Level: Medium
- Tags: Dynamic Programming, Tree
- 卡特兰数
- 动态规划

-----------------
### 97. [Interleaving String](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/InterleavingString.java)
- Level: Hard
- Tags: Dynamic Programming, String
- 暴力递归会超时，可以做一个map记录递归状态，耗时0ms
- 正常的动态规划耗时2-5ms，比记录状态的递归要慢一点

--------------------------
### 98. [Validate Binary Search Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/ValidateBinarySearchTree.java)
- Level: Medium
- Tags: Tree, DFS
- 平衡搜索二叉树的性质：中序遍历一定是严格递增序列
- 所以，可以中序遍历二叉树，一旦出现非递增的情况直接返回false

---------------
### 99. [Recover Binary Search Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/RecoverBinarySearchTree.java)
- Level: Hard
- Tags: Tree, DFS
- 交换的结点一定是逆序的地方
- 设置短路标志，但是短路后效果并没有改善，不知道为什么

--------------------------
### 100. [Same Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode/SameTree.java)
- Level: Easy
- Tags: Tree, DFS
- 递归判断，参见代码

---------------
### 101. [Symmetric Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SymmetricTree.java)
- Level: Easy
- Tags: Tree, DFS, BFS 
- 递归与迭代实现
- 迭代使用辅助栈，每次放两个结点进去

--------------
### 102. [Binary Tree Level Order Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreeLevelOrderTraversal.java)
- Level: Medium
- Tags: Tree, BFS 
- 迭代版使用双端队列，记录最右结点
- 递归版直接往list中添加，记录level：
```$xslt
    public List<List<Integer>> levelOrderRecur(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;
            levelTraversal(root, 0, res);
            return res;
        }
    
    private void levelTraversal(TreeNode root, int level, List<List<Integer>> res) {
        if (root != null) {
            if (res.size() == level)
                res.add(new ArrayList<>());
            res.get(level).add(root.val);
            levelTraversal(root.left, level + 1, res);
            levelTraversal(root.right, level+1, res);
        }
    }
```

-----------------
### 103. [Binary Tree Zigzag Level Order Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreeZigzagLevelOrderTraversal.java)
- Level: Medium
- Tags: Tree, BFS, Stack
- 迭代版使用两个辅助栈，加入顺序不同
- 递归版直接往list中添加，记录level，最后再将偶数位的集合做反转，和102题的递归版相比，只是多了如下两行代码：
``` 
    for (int i = 1; i < res.size(); i += 2)
        Collections.reverse(res.get(i));
```

----------------
### 104. [Maximum Depth of Binary Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MaximumDepthOfBinaryTree.java)
- Level: Easy
- Tags: Tree, DFS
- 递归三行代码搞定：
```
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
```

-------------------------
### 105. [Construct Binary Tree from Preorder and Inorder Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ConstructBinaryTreeFromPreorderAndInorderTraversal.java)
- Level: Medium
- Tags: Array, Tree, DFS
- 递归版的三个版本，参考具体代码

------------------
### 106. [Construct Binary Tree from Inorder and Postorder Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ConstructBinaryTreeFromInorderAndPostorderTraversal.java)
- Level: Medium
- Tags: Array, Tree, DFS
- 递归实现，与105题的差别在于，先排右孩子，再排左孩子，数组长度减下标为实际下标
- 耗时1ms
```
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    }
    int inIndex = 0, posIndex = 0;
    private TreeNode buildTree(int[] inorder, int[] postorder, int val) {
        if (inIndex >= inorder.length || inorder[inorder.length - inIndex - 1] == val)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length - ++posIndex]);
        root.right = buildTree(inorder, postorder, root.val);
        inIndex++;
        root.left = buildTree(inorder, postorder, val);
        return root;
    }
```
- 其余递归方法，根据105题修改即可

-----------------
### 107. [Binary Tree Level Order Traversal II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreeLevelOrderTraversalII.java)
- Level: Easy
- Tags: Tree, BFS
- 与102题逻辑一样，区别在于，在遍历过所有结点后，反转结果集即可。

------------------
### 108. [Convert Sorted Array to Binary Search Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ConvertSortedArrayToBinarySearchTree.java)
- Level: Easy
- Tags: Tree, DFS
- 每次取数组的中间位置插入结点，左孩子递归数组的左部分，右孩子递归数组的右部分。

---------------------
### 109. [Convert Sorted List to Binary Search Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ConvertSortedListToBinarySearchTree.java)
- Level: Medium
- Tags: Linked List, Tree, DFS
- 将链表转换成数组，采用108题的思路解答
- 直接使用链表递归，每次找到链表的中点作为二叉树结点，左边和右边继续递归

----------------
### 110. [Balanced Binary Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BalancedBinaryTree.java)
- Level: Easy
- Tags: Tree, DFS
- 求左右孩子的最大深度，一旦深度差大于1直接短路返回。

----------------------
### 111. [Minimum Depth of Binary Tree](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MinimumDepthOfBinaryTree.java)
- Level: Easy
- Tags: Tree, DFS, BFS
- 额外判断根结点的左右子结点是否为空

---------------------
### 112. [Path Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PathSum.java)
- Level: Easy
- Tags: Tree, DFS
- 结点为null直接返回false，左右子结点都为空则判断sum是否等于当前结点的值，否则继续递归。

--------------------
### 113. [Path Sum II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PathSumII.java)
- Level: Medium
- Tags: Tree, DFS
- 递归调用自身，将集合定义在外面即可。
```
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(list));
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        list.remove(list.size() - 1);
        return res;
    }

```

-------------------
### 114. [Flatten Binary Tree to Linked List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/FlattenBinaryTreeToLinkedList.java)
- Level: Medium
- Tags: Tree, DFS
- 找到左子树的最右结点，插入右子树和当前结点之间

--------------------
### 115. [Distinct Subsequences](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/DistinctSubsequences.java)
- Level: Hard
- Tags: Dynamic Programming, String
- 动态规划递推公式：
```
    if (cs[i - 1] == ct[j - 1])
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    else
        dp[i][j] = dp[i - 1][j];
```
- 另一种方案参见代码

--------------------
### 116. [Populating Next Right Pointers in Each Node](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PopulatingNextRightPointersInEachNode.java)
- Level: Medium
- Tags: Tree, DFS
- 使用队列层次遍历简单实现
- 直接迭代实现，记录每一层的最左结点，两层循环即可。
```
    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode cur = level;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level = level.left;
        }
    }
```


--------------
### 117. [Populating Next Right Pointers in Each Node II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PopulatingNextRightPointersInEachNodeII.java)
- Level: Medium
- Tags: Tree, DFS
- 116题的升级版，设置一个前驱结点，用于访问下一层的首个有效结点

------------------
### 118. [Pascal's Triangle](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PascalsTriangle.java)
- Level: Easy
- Tags: Array
- 遍历累加

------------------
### 119. [Pascal's Triangle II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PascalsTriangleII.java)
- Level: Easy
- Tags: Array
- 同上

-----------------
### 120. [Triangle](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/Triangle.java)
- Level: Medium
- Tags: Array, Dynamic Programming
- 动态规划：
1，从上到下+从右到左        
2，从下到上+从左到右

----------------
### 121. [Best Time to Buy and Sell Stock](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BestTimeToBuyAndSellStock.java)
- Level: Easy
- Tags: Array
- 当前值-最小值，求最大的一个结果即可

------------------
### 122. [Best Time to Buy and Sell Stock](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BestTimeToBuyAndSellStock.java)
- Level: Easy
- Tags: Array, Greedy


---------------------
### 123. [Best Time to Buy and Sell Stock III](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BestTimeToBuyAndSellStockIII.java)
- Level: Hard
- Tags: Array, Dynamic Programming
- 暴力动态规划，耗时长
- 做两个数组，一个存放以当天截止的最大收益，一个存放以当天开始的最大收益，最后对应位置相加求最大值。
- 直接求：
```
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int buy1 = Integer.MIN_VALUE, profit1 = 0;
        int buy2 = Integer.MIN_VALUE, profit2 = 0;
        for (int p : prices) {
            buy1 = Math.max(buy1, -p);
            profit1 = Math.max(profit1, p + buy1);
            buy2 = Math.max(buy2, profit1 - p);
            profit2 = Math.max(profit2, p + buy2);
        }
        return profit2;
    }
```

--------------
### 124. [Binary Tree Maximum Path Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreeMaximumPathSum.java)
- Level: Hard
- Tags: DFS
```
    public int maxPathSum(TreeNode root) {
        help(root);
        return res;
    }

    private int res = Integer.MIN_VALUE;

    private int help(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int rootVal = root.val;
        int leftVal = Math.max(help(root.left), 0);
        int rightVal = Math.max(0, help(root.right));
        res = Math.max(res, rootVal + leftVal + rightVal);
        return rootVal + Math.max(leftVal, rightVal);
    }
```


------------------
### 125. [Valid Palindrome](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ValidPalindrome.java)
- Level: Easy
- Tags: Two Pointers, String
- 双指针逐个比较，跳过非数字字母字符即可

----------------
### 126. [Word Ladder II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/WordLadderII.java)
- Level: Hard
- Tags: Array, String, BackTracking, BFS
- 单向搜寻邻居单词，如果反向，需要反转map中的k-v映射
- 将list转换为set，求解邻居过程中，移除已经访问过的字符串

------------------
### 127. [Word Ladder](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/WordLadder.java)
- Level: Medium
- Tags:  BFS
- 126的简化版

-----------------
### 128. [Longest Consecutive Sequence](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/LongestConsecutiveSequence.java)
- Level: Hard
- Tags:  Array, Union Find
- 并查集可实现O(n)时间复杂度，但实际上耗时较长
- 另可以将数据存入set中，检测通过while循环查找后一个数是否存在，如下：
> 
```
    for (int num : nums) {
        if (set.contains(num - 1))
            continue;
        int cur = num + 1;
        while (set.contains(cur))
            cur++;
        max = Math.max(max, cur - num);
    }
```
----------------------
### 129. [Sum Root to Leaf Numbers](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SumRoot2LeafNumbers.java)
- Level: Medium
- Tags:  Tree, DFS
- 利用辅助函数深度遍历二叉树即可，如下所示：
```
   public int sumNumbers(TreeNode root) {
       return sum(root, 0);
   }

   private int sum(TreeNode root, int val) {
       if (root == null)
           return 0;
       int cur = val * 10 + root.val;
       if (root.left == null && root.right == null)
           return cur;
       return sum(root.left, cur) + sum(root.right, cur);
   } 
```


--------------
### 130. [Surrounded Regions](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SurroundedRegions.java)
- Level: Medium
- Tags:  BFS, DFS, Union Find
- 遍历边界的O，通过感染方法将与之毗连的O全部设为Y，最后整体遍历，将O转为X，将Y转回O即可

-----------------
### 131. [Palindrome Partitioning](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PalindromePartitioning.java)
- Level: Medium
- Tags:  BackTracking
- 自左至右判断子串是否为回文，回溯添加入集合

-------------------
### 132. [Palindrome Partitioning II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PalindromePartitioningII.java)
- Level: Hard
- Tags: Dynamic Programming
- 从每一个位置和旁边位置向两边扩，同时更新最右边的位置的值。 `dp[right] = min(dp[right],dp[left-1]+1)`
```$java
    public int minCut(String s) {
        if (s == null || s.isEmpty())
            return 0;
        int[] min = new int[s.length()];
        for (int i = 1; i < min.length; i++)
            min[i] = i;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            help(cs, i, i, min);
            help(cs, i, i + 1, min);
        }
        return min[min.length - 1];
    }

    private void help(char[] cs, int left, int right, int[] min) {
        while (left >= 0 && right < cs.length && cs[left] == cs[right]) {
            if (left == 0)
                min[right] = 0;
            else
                min[right] = Math.min(min[right], min[left - 1] + 1);
            left--;
            right++;
        }
    }
```

--------------------
### 133. [Clone Graph](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/CloneGraph.java)
- Level: Medium		
- Tags: BFS, DFS, Graph
- 遍历图，设置map，一旦新建一个节点就放入map

-------------------
### 134. [Gas Station](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/GasStation.java)
- Level: Medium		
- Tags: Greedy
```
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0, sum = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                res = i + 1;
            }
        }
        total += sum;
        return total < 0 ? -1 : res;
    }
```

---------------------
### 135. [Candy](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/Candy.java)
- Level: Hard		
- Tags: Greedy
- 自左至右加一遍，大于左边的则+1，否则为1；从右到左加一遍，大于右边的则和1+右边的取最值，否则不变。
```
    public int candy(int[] ratings) {
        if (ratings.length < 2)
            return ratings.length;
        int len = ratings.length;
        int[] nums = new int[len];
        int sum = 0;
        nums[0] = 1;
        for (int i = 1; i < len; i++)
            nums[i] = ratings[i] > ratings[i - 1] ? 1 + nums[i - 1] : 1;
        sum += nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            nums[i] = ratings[i] > ratings[i + 1] ? Math.max(nums[i], 1 + nums[i + 1]) : nums[i];
            sum += nums[i];
        }
        return sum;
    }
```

-----------------------------
### 136.[Single Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SingleNumber.java)
- Level: Easy		
- Tags: Hash Table, Bit Manipulation
- 异或和即为所求


-------------------
### 137. [Single Number II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SingleNumberII.java)
- Level: Medium		
- Tags: Hash Table, Bit Manipulation
- 方法一： 统计每一位置上1的个数，然后对3取余后和1相与即可
- 方法二： `https://cloud.tencent.com/developer/article/1131945`
```
public int singleNumber(int[] nums) {
    int a = 0, b = 0;
    for (int num : nums) {
        a = (a ^ num) & ~b;
        b = (b ^ num) & ~a;
    }
    return a;
}
```

---------------------
### 138. [Copy List with Random Pointer](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/CopyListWithRandomPointer.java)
- Level: Medium		
- Tags: Hash Table, Linked List
- 先在每一个结点后复制一个结点，连接在原链表内，再遍历每一个结点的随机指针，按顺序连接复制结点的随机指针，最后分开结点。

----------------------
### 139. [Word Break](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/WordBreak.java)
- Level: Medium		
- Tags: Dynamic Programming, BackTracking 
- 用hashmap记录状态，或者动态规划，用Boolean数组记录状态。
- 只要找到一种情况满足要求即可

----------------------
### 140. [Word Break II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/WordBreakII.java)	
- Level: Hard		
- Tags: Dynamic Programming, BackTracking 
- 深度优先搜索：
>	参考代码理解

----------------------
### 141. [Linked List Cycle](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/LinkedListCycle.java)
- Level: Easy		
- Tags: Linked List, Two Pointers
- 快慢指针相遇则有环

---------------------
### 142. [Linked List Cycle II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/LinkedListCycleII.java)
- Level: Medium		
- Tags: Linked List, Two Pointers
- 快慢指针相遇后都变慢指针，一个原地开始，一个从头开始，再次相遇则为入环点

-------------------
### 143. [Reorder List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ReorderList.java)
- Level: Medium		
- Tags: Linked List, Two Pointers
- 将后半段逆序后再依次插入前半段，注意边界条件和跳出条件
---------------------------
### 144. [Binary Tree Preorder Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreePreorderTraversal.java)
- Level: Medium		
- Tags: Tree
- 递归遍历
- 使用辅助栈迭代遍历
- Morris遍历

--------------
### 145. [Binary Tree Postorder Traversal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreePostorderTraversal.java)
- Level: Hard		
- Tags: Tree
- 递归遍历
- 使用辅助栈迭代遍历
- Morris遍历
-------------------
### 146. [LRU Cache](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/LRUCache.java)
- Level: Hard		
- Tags: Design
- 哈希表+双向链表，参见代码

--------------------
### 147. [Insertion Sort List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/InsertionSortList.java)
- Level: Medium		
- Tags: Linked List, Sort
- 设置返回链表的前置节点，依次将头结点插入到新的链表中

------------------
### 148. [Sort List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SortList.java)
- Level: Medium		
- Tags: Linked List, Sort
- 链表版归并排序，但有说此方法空间复杂度为O(lgn)，具体常数空间度复杂度方法参见网上代码
-------------------
### 149. [Max Points on a Line](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MaxPointsOnALine.java)
|Hard|Java| Hash Table, Math ||
- Level: Hard		
- Tags: Hash Table, Math
- 注意重合的点
- 注意double的精度丢失，不能直接用斜率存储，需要用分数形式存储，采用欧几里得算法计算最大公约数
- 欧几里得算法：
```
private int gcd(int y, int x) {
    if (x == 0)
        return y;
    return gcd(x, y % x);
}
```

-------------------------
### 150. [Evaluate Reverse Polish Notation](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/EvaluateReversePolishNotation.java)
- Level: Medium		
- Tags: Stack
- 使用栈，数字入栈，操作符出栈计算后再入栈
- 递归方法：比直接使用栈耗时更短，从右到左计算，参见代码中的第三种解法。

----------------
### 151. [Reverse Words in a String](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ReverseWordsInAString.java)
- Level: Medium		
- Tags: String
- 两边和中间有多余的空格
- 直接从右到左截取，不需要翻转，反倒更快

-------------------
### 152. [Maximum Product Subarray](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MaximumProductSubarray.java)
- Level: Medium		
- Tags: Array, Dynamic Programming
- 每次取最大值和最小值，遇到负值时交换最大最小值
```
if (nums[i] < 0) {
    int tmp = max;
    max = min;
    min = tmp;
}
max = Math.max(nums[i], nums[i] * max);
min = Math.min(nums[i], nums[i] * min);
res = Math.max(res, max);
```
------------------------
### 153. [Find Minimum in Rotated Sorted Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/FindMinimumInRotatedSortedArray.java)
- Level: Medium		
- Tags: Array, Binary Search
- 二分查找，一旦符合`nums[left] <= nums[right]`返回`nums[leftr]`即可
----------------------
### 154. [Find Minimum in Rotated Sorted Array II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/FindMinimumInRotatedSortedArrayII.java)
- Level: Hard		
- Tags: Array, Binary Search
- 与153题解法思路相近，区别在于，若nums[mid]和nums[left]相等时，执行left++，即并不是每一次都进行折半，最后返回nums[right]

--------------------------
### 155. [Min Stack](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MinStack.java)
- Level: Easy		
- Tags: Stack, Design
- 使用两个栈实现
- 一个栈+一个有value和min属性的Node类实现
- 一个栈+一个min属性实现，push的时候有如下操作：
```
public void push(int x) {
    if (x <= min) {
        stack.push(min);
        min = x;
    }
    stack.push(x);
}
```
--------------------------
### 160. [Intersection of Two Linked Lists](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/IntersectionOfTwoLinkedLists.java)
- Level: Easy		
- Tags: Linked List
- 方法一：记录两个链表的长度，根据长度差，让更长的链表先移动diff步，随后一起移动，直到相遇或为null
- 方法二：同时从头移动两个结点，移动到末尾null后从另一链表的表头开始，直到两结点相同则返回
```
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA, curB = headB;
    while (curA != curB) {
        curA = curA == null ? headB : curA.next;
        curB = curB == null ? headA : curB.next;
    }
    return curA;
}
```
-----------------------
### 162. [Find Peak Element](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/FindPeakElement.java)
- Level: Easy		
- Tags: Array, Binary Search
- 二分搜索，如果`nums[mid]>nums[mid+1]`则peak点一定在左边，否则在右边
```
public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1, mid;
    while (left < right) {
        mid = left + (right - left >> 1);
        if (nums[mid] > nums[mid + 1])
            right = mid;
        else
            left = mid + 1;
    }
    return left;
}
```
---------------------------
### 164. [Maximum Gap](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/maximumGap.java)
- Level: Hard
- Tags: Array, Sort
- 左神算法视频初级班讲过
- 基于桶排序求最大间隔，设置len+1个桶，最大间隔必在不同的桶间产生

------------------------
### 165. [Compare Version Numbers](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/CompareVersionNumbers.java)
- Level: Medium
- Tags: String
- 去掉.后组成字符串数组，从左到右作比较，若其中一个越界则默认为0
-----------------------
### 166. [Fraction to Recurring Decimal](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/Fraction2RecurringDecimal.java)
- Level: Medium
- Tags: Hash Table, Math
- 根据余数是否重复出现判定小数部分是否进入循环，将余数和对应的位置存入hashmap
------------------
### 167. [Two Sum II - Input array is sorted](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/TwoSumII.java)
- Level: Easy
- Tags: Array, Two Pointers
- 双指针往中间移动，根据当前数的和与target的大小判断从哪边移动或者返回结果
-----------------------
### 168. [Excel Sheet Column Title](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ExcelSheetColumnTitle.java)
- Level: Easy
- Tags: Math
- 十进制转26进制
```
public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
        sb.append((char) ((n - 1) % 26 + 'A'));
        n = (n - 1) / 26;
    }
    return sb.reverse().toString();
}
```
--------------------------
### 169. [Majority Element](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MajorityElement.java)
- Level: Easy
- Tags: Array
- 利用快排的partition过程，若`p[1] - p[0] + 1 > nums.length / 2`则返回nums[p[0]]，否则根据两侧剩余空间判断从哪边继续partition
- 直接计数，相同则+1，不同-1 若计数为0则更新数字
```
public int majorityElement(int[] nums) {
    int pre = nums[0], cnt = 0;
    for (int num : nums) {
        if (cnt == 0)
            pre = num;
        if (num == pre)
            cnt++;
        else
            cnt--;
    }
    return pre;
}
```
----------------------
### 171. [Excel Sheet Column Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ExcelSheetColumnNumber.java)
- Level: Easy
- Tags: Math
- 26进制转10进制
```
public int titleToNumber(String s) {
    char[] cs = s.toCharArray();
    int res = 0;
    for (char ch:cs)
        res = res * 26 + ch - 64;
    return res;
}
```
----------------------------
### 172. [Factorial Trailing Zeroes](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/FactorialTrailingZeroes.java)
- Level: Easy
- Tags: Math
- 累加除以5的结果
```
public int trailingZeroes2(int n) {
    int res = 0;
    while (n > 4) {
        n /= 5;
        res += n;
    }
    return res;
}
```
- 递归版见代码
------------------
### 173. [Binary Search Tree Iterator](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BSTIterator.java)
- Level: Medium
- Tags: Stack, Tree, Design
- 题意不明，具体看代码
------------------------
### 174. [Dungeon Game](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/DungeonGame.java)
- Level: Hard
- Tags: Dynamic Programming
- 从下到上动态规划
- 从右下角开始计算需要的最少血量，向上向左移动的时候血量和1取最大值
-----------------------
### 179. [Largest Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/LargestNumber.java)
- Level: Medium
- Tags: Sort
- 先排序，自定义比较器
- 转换成字符串进行排序，str1+str2和str2+str1进行比较 
```
Arrays.sort(arr, (o1, o2) -> {
    String a = o1 + o2;
    String b = o2 + o1;
    return b.compareTo(a);
});
```

--------------------------
### 187. [Repeated DNA Sequences](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/RepeatedDNASequences.java)
- Level: Medium
- Tags: Hash Table, Bit Manipulation
- 方法一，用两个set，存放每一位开始的长度为10的字符串，如果放不进去则表明出现过，将其存入另一个set，最后返回另一个set即可
- 方法二，Bit Manipulation位操作；设置一个掩码 `int mask = 0xfffff;//20bit,10个字母，每个字母占2bit` 对ACGT进行编码 
`map['A'] = 0;map['C'] = 1;map['G'] = 2;map['T'] = 3;` 从左至右获取当前序列的二进制状态`cur = cur << 2 | map[cs[i]];`
设置 `byte[] bytes = new byte[1 << 20];` 用于记录所有字符序列对应的值，通过如下操作进行判断
```
for (int i = 9; i < cs.length; i++) {
    cur = cur << 2 & mask | map[cs[i]];
    if (bytes[cur] == 1) {
        res.add(s.substring(i - 9, i + 1));
        bytes[cur]++;
    }
    if (bytes[cur] == 0)
        bytes[cur]++;
}
```
- 总的来说就是，编码+状态转移和判断+位操作 ☆☆☆☆☆

---------------------------
### 188. [Best Time to Buy and Sell Stock IV](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BestTimeToBuyAndSellStockIV.java)
- Level: Hard
- Tags: Array, Dynamic Programming
- 根据123题修改可得

----------------------
---------------------------
### 189. [Rotate Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/RotateArray.java)
- Level: Easy
- Tags: Array
- 分成两段反转数组，然后反转整个数组
------------------------------
### 190. [Reverse Bits](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/ReverseBits.java)
- Level: Easy
- Tags: Bit Manipulation
- 移位时使用无符号移位
```
public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
        res = (res << 1) + n % 2;
        n >>= 1;
    }
    return res;
}
```

-------------------------
### 191. [Number of 1 Bits](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/NumberOf1Bits.java)
- Level: Easy
- Tags: Bit Manipulation
- 方法一：n每次与1进行&操作，累加结果，n每次无符号右移一位
- 方法二：n每次与n-1进行&操作，计数累加

-------------------
### 198. [House Robber](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/HouseRobber.java)
- Level: Easy
- Tags: Dynamic Programming
- 取或者不取当前的数
- 递推公式： `f(x)=max(f(x-2)+nums[x], f(x-1))`

------------------------------------
### 199. [Binary Tree Right Side View](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/BinaryTreeRightSideView.java)
- Level: Medium
- Tags: Tree, DFS, BFS
- 层次遍历，将每一层最右边的节点的值放入集合
- 层次遍历的方式：1迭代，使用队列；2递归：通过`list.size()==level`判断是否到了新的一层
- 方法二：通过递归层次遍历改进，递归时从右子树开始，每到了新的一层就将此时的值加入结果集

------------------------
### 200. [Number of Islands](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/NumberOfIslands.java)
- Level: Medium
- Tags: Union Find, DFS, BFS
- 方法一：DFS
- 方法二：并查集，并且将二维矩阵转换为一维序号表示节点，用数组代替哈希表

----------------------------
### 201. [Bitwise AND of Numbers Range](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/BitwiseANDofNumbersRange.java)
- Level: Medium
- Tags: Bit Manipulation
- 找到所有数字中左边一样的部分，m和n不断右移一位，直到相等，然后m左移相同位数即为结果

------------------------
### 202. [Happy Number](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/HappyNumber.java)
- Level: Easy
- Tags: Hash Table, Math
- 不断进行平方和运算，结果肯定会出现小于10的数，该数为1或7则返回true，否则返回false
- 可调用自身递归运算
--------------------
### 203. [Remove Linked List Elements](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/RemoveLinkedListElements.java)
- Level: Easy
- Tags: Linked List
- 先找到合适的头结点，然后再依次检查后面的结点

--------------------
### 204. [Count Primes](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/CountPrimes.java)
- Level: Easy
- Tags: Hash Table, Math
- 记录状态，循环排除
- 如果一个数i是素数，那么i一定是奇数（除了2），且`i*i+2*N*i // N为正整数`一定不是素数
-------------------------
### 205. [Isomorphic Strings](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/IsomorphicStrings.java)
- Level: Easy
- Tags: Hash Table
- 定义两个映射表，表示两个字符串互相的映射（使用长度为128的数组即可）
- 只有两个位置都为0才需要赋值，否则比较map中的值，不等则返回false
--------------------------
### 206. [Reverse Linked List](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/ReverseLinkedList.java)
- Level: Easy
- Tags: Linked List
- 设置前驱结点翻转链表

----------------
### 207. [Course Schedule](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/CourseSchedule.java)
- Level: Medium
- Tags: DFS, BFS, Graph, Topologicla Sort
- 从入度着手即BFS，从出度着手即DFS
- 使用拓扑排序判断有向图是否有环
--------------------------
### 208. [Implement Trie (Prefix Tree)](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/ImplementTrie.java)
- Level: Medium
- Tags: Design, Trie
- 前缀树，设计一种数据结构，每一层有26个结点，长度为26的数组即可，可根据字符-'a'的值作为结点的位置。另外每一个结点都需要维持一个boolean变量，表示当前结点是否是结束节点
- 详情参见代码
---------------------
### 209. [Minimum Size Subarray Sum](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/MinimumSizeSubarraySum.java)
- Level: Medium
- Tags: Array, Two Pointers, Binary Search
- 双指针，右侧一直往右，直到满足要求，然后左侧一直往右，直到不满足，左侧指针移动时更新最小长度
--------------------------
### 210. [Course Schedule II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/CourseScheduleII.java)
- Level: Medium
- Tags: DFS, BFS, Graph, Topologicla Sort
- 入度为0的结点为可以直接上的课程
- 通过建立邻接表和更新入度解决
-----------------------------
### 211. [Add and Search Word - Data structure design](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/AddAndSearchWordDataStructureDesign.java)
- Level: Medium
- Tags: Backtracking, Design, Trie
- 构造字典树，添加操作不便，查找操作需要匹配通配符
- 查找时采用回溯方法，遇到通配符则遍历当前这一层，非空即进入回溯。
------------------
### 212. [Word Search II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/WordSearchII.java)
- Level: Hard
- Tags: Backtracking, Trie
- 回溯+字典树
- 字典树中添加单词属性，回溯过程中更改当前字符
----------------
### 213.[House Robber II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/HouseRobberII.java)
- Level: Medium
- Tags: Dynamic Programming
- 类似于198题，对于排成一圈的房间，第一个和最后一个必然只能偷一个，所以问题从第1到第n-1个房间和第2到第n个房间，两者取最大值。即把数组拆分成两个
----------------------
### 214. [Shortest Palindrome](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/ShortestPalindrome.java)
- Level: Hard
- Tags: String
- 利用KMP中求解next数组的方式，多求一位next数组，即可找出最长回文前缀。ps，将字符串翻转后加一个冗余字符，拼接至原字符串后面，然后再求next数组
- 利用双指针前后对照检测，找出回文前缀，求出最终结果的前缀后缀，中间部分递归求解。ps，如果原字符串存在回文前缀，那么一定可以被检测到
--------------------------------
### 215. [Kth Largest Element in an Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/KthLargestElementInAnArray.java)
- Level: Medium
- Tags: Divide and Conquer, Heap
- Kth问题，方法一，基于快排的partition过程
- BFPRT算法
- LeetCode实际耗时，优化后的随机快排partition反而耗时更长，且BFPRT算法耗时更长。与理论有较大出入。
------------------------
### 216. [Combination Sum III](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/CombinationSumIII.java)
- Level: Medium
- Tags: Array, Backtracking
- 回溯，从小到大地加入list中，符号要求则加入结果集

-------------------
### 217. [Contains Duplicate](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/ContainsDuplicate.java)
- Level: Easy
- Tags: Array, Hash Table
- 桶排序或者使用哈希表
--------------------------
### 218. [The Skyline Problem](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/TheSkylineProblem.java)
- Level: Hard
- Tags: Divide and Conquer, Heap, Binary Indexed Tree, Segment Tree
- 基本的思想是对输入buildings做一个线性扫描，并且只处理它的两个点（即开始点和结束点）；
- 还有一个关键点是要使用一个优先队列(priority_queue)来记录所有处于"alive"状态的buildings（处于alive状态的建筑是指那么在后面的变量过程中可能会被使用到的建筑）；
- 优先队列需要根据高度和结束点x坐标来进行排序（优先队列的队首元素是高度值最大，如果存在高度值相同的点，结束点x坐标大的点位于队首）；
- 对buildings执行迭代操作，找到当前正在处理的点（即可能的拐点），当前正在处理的点要么是下一个building的开始点，要么是优先队列中队首元素的结束点；
- 如果当前的building的开始点的x坐标大于优先队列中队首元素的结束点x坐标，那么首先处理优先队列中的队首元素：将优先队列中的元素弹出直到它为空或者找到第一个结束点x坐标大于当前处理点的。
- 否则，如果当前的building的开始点x坐标小于等于优先队列中堆首元素的结束点x坐标，那么处理当前的building：将它的高度和结束点x坐标放到优先队列中；判断高度值是否发生了变化，如果发生了变化，将它放入到结果集中。
- ![img](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/files/skyline.bmp)
-------------------
### 240. [Search a 2D Matrix II](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode3/Searcha2DMatrixII.java)
- Level: Medium
- Tags: Binary Search, Divide and Conquer
- 从左下角开始，往右上角移动
- 74题的升级版
---------------
### 260. [Single Number III](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/SingleNumberIII.java)
- Level: Medium		
- Tags: Hash Table, Bit Manipulation
- 取异或和sum，找到sum中的一个1， `sum &= -sum` ，然后根据当前位置是否为1把原数组分为两部分，再求异或和即可

--------------------
### 421. [Maximum XOR of Two Numbers in an Array](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/MaximumXORofTwoNumbersinanArray.java)
- Level: Medium		
- Tags: Bit Manipulation, Trie
- 前缀树方法。详情参见代码，或者左神算法视频进阶7视频
---------------------
### 437. [Path Sum III](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode2/PathSumIII.java)
- Level: Easy
- Tags: Tree
- 递归调用自身和辅助方法，遍历所有以当前结点开头的满足条件情况
- 递归辅助函数，查询以当前结点结尾的所有满足条件的情况，新建数组保存已遍历的所有结点的和

------------------



---------------------------
### 865. [Smallest Subtree with all the Deepest Nodes](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/SmallestSubtreeWithAllTheDeepestNodes.java)	
- Level: Medium	
- Tags: Tree 
- 利用平衡二叉树的性质，若最深节点只有一个，直接返回此节点，否则返回所有最深节点共同的父节点，即返回左右子树深度一样的节点
- 求二叉树某一节点的深度：
```
	private int depthOfNode(TreeNode n) {
		if (n == null)
			return 0;
		return Math.max(depthOfNode(n.left), depthOfNode(n.right)) + 1;
	}
```
	
---------------------
### 866. [Prime Palindrome](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/PrimePalindrome.java)	
- Level: Medium	
- Tags: Math 
- 一开始实现一种很复杂的方法，构建回文时考虑数字的左半边，累加左半边，需要注意进位时构建回文的方法转换。具体参考代码
- 作弊版：将1-Integer.MaxValue范围内的回文素数放进数组，然后找到比当前数字大的下一个回文素数。这方法，真的是，作弊啊啊啊啊
>	假如数据量有限且可查询得到，必要时候直接拿来用，有奇效

-----------------------------
### 867. [Transpose Matrix](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/TransposeMatrix.java)	
- Level:Easy	
- Tags: Array
- 二维数组的转置，ij互换即可

----------------------------------
### 868. [Binary Gap](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/BinaryGap.java)	
- Level: Easy
- Tags: Math
- 查找二进数据中两个1的最大距离，首先定位到第一个1，然后再计算距离。
- 可以用一个循环实现，设置一个初始值`int cur = -32; `表示当前1的位置，每次遇到1后重置cur
 ```		
			while (n > 0) {
				if ((n & 1) == 1) {
					res = Math.max(res, cur);
					cur = 0;
				}
				n >>= 1;
				cur++;
			}
  ```
- 把while循环该成for循环好像会快一点点

-------------
### 869. [Reordered Power of 2](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/ReorderedPowerOf2.java) 
- Level: Medium
- Tags: Math
- 思路就是把一个整数转换成这些数字可以组成的最大数，然后从1开始匹配2的n次方，一旦匹配到直接返回true，结束循环条件如下：
```	
 		change(m)的作用是重排数字，返回最大组成的数
		while (n > change(m) || n > m) {
			m *= 2;
			if (n == change(m))
				return true;
		}
		return n == change(m);
```
- 注意重排数字后int接收可能越界，用long接收

- 还可以根据每一个整数的数字组成来判断输入是否可以重组成为2的n次幂
```
	//记录整数中每一个数字出现的次数： 11234400 =>21122 第i位表示i出现过几次
	public int counter(int N) {
		int res = 0;
		for (; N > 0; N /= 10)
			res += (int) Math.pow(10, N % 10);
		return res;
	}
```

---------------
### 870. [Advantage Shuffle](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/AdvantageShuffle.java)
- Level: Medium
- Tags: Math, HashMap 
- 田忌赛马？
- 对A排序，把B的value和index映射放入map，然后根据value排序，从A的最大值开始匹配B的最大值，小于等于就匹配B的次最大值
- 详情参考代码，有详细注释
- 更新：使用优先级队列代替哈希表效果更好，而且给结果集赋值部分可以优化为一次循环赋值完毕。
- 优先级队列：
```
		//队列中存放数组，数组中存放B中的元素值和下标，然后自定义比较器以元素值排序
		//jdk1.8以后可以使用lambda表达式：PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(10, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});
```
- 循环赋值部分：
```
		int start = 0, end = len - 1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();	//堆顶的数组，存放着B中的最大值和下标
			int bIndex = cur[0];
			int bVal = cur[1];
			if (A[end] > bVal)
				res[bIndex] = A[end--];		//A>B则令当下标对应的值为A。双指针思路
			else
				res[bIndex] = A[start++];	//否则依次获取A的最小值赋值给当前下标
		}	
```


--------------------------




-----------------------
### 872. [Leaf-Similar Trees](https://github.com/lanrengufeng/LeetCodeEx/blob/master/src/leetcode9/LeafSimilarTrees.java)
- Level: Easy
- Tags: Tree
- 任意一种方式遍历二叉树，将叶节点放入集合，对比两个集合即可。
- 复习非递归遍历二叉树方法

-----------------------------


--------------------------
