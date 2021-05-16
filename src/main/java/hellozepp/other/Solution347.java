package hellozepp.other;

import com.alibaba.fastjson.JSON;

import java.util.*;


/**
 * 找出频率最高的k个数字
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * 难度2星
 *
 * [1,1,1,2,2,3] ,k=2 return [1,2]
 */
public class Solution347 {
    /**
     * 优先队列解法，事件复杂度o(nlogk)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        //将Map中所有的键存入到set集合中
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.remove());
        }
        return list;
    }

    /**
     * 分桶解法，时间复杂度 o(n)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            int frequency = map.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}