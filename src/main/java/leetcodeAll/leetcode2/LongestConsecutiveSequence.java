package leetcodeAll.leetcode2;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {

    /**
     * 直接计数法：将nums放入set
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int max = 1;
        for (int num : nums) {
            if (set.contains(num - 1))
                continue;
            int cur = num + 1;
            while (set.contains(cur))
                cur++;
            max = Math.max(max, cur - num);
        }
        return max;
    }

    /**
     * 并查集解法
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        UFS ufs = new UFS(nums);
        int max = 1;
        for (int num : nums) {
            if (ufs.fatherMap.containsKey(num - 1))
                ufs.union(num, num - 1);
            if (ufs.fatherMap.containsKey(num + 1))
                ufs.union(num, num + 1);
            max = Math.max(max, ufs.sizeMap.get(ufs.findHead(num)));
        }
        return max;
    }

    public static class UFS {
        private HashMap<Integer, Integer> fatherMap;
        private HashMap<Integer, Integer> sizeMap;

        public UFS(int[] nums) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int num : nums) {
                fatherMap.put(num, num);
                sizeMap.put(num, 1);
            }
        }

        private Integer findHead(Integer num) {
            Integer father = fatherMap.get(num);
            if (father != num)
                father = findHead(father);
            fatherMap.put(num, father);
            return father;
        }

        private boolean isSameSet(Integer num1, Integer num2) {
            return findHead(num1) == findHead(num2);
        }

        private void union(Integer num1, Integer num2) {
            Integer head1 = findHead(num1);
            Integer head2 = findHead(num2);
            if (head1 != head2) {
                int size1 = sizeMap.get(head1);
                int size2 = sizeMap.get(head2);
                if (size1 < size2) {
                    fatherMap.put(head1, head2);
                    sizeMap.put(head2, size1 + size2);
                } else {
                    fatherMap.put(head2, head1);
                    sizeMap.put(head1, size1 + size2);
                }
            }
        }
    }
}
