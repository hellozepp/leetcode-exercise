package leetcodeAll.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 210. Course Schedule II
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses], inDegree = new int[numCourses];   //入度
        int index = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //邻接表
        for (int[] pre : prerequisites) {   //初始化入度和邻接表
            inDegree[pre[0]]++;
            if (!map.containsKey(pre[1]))
                map.put(pre[1], new ArrayList<>());
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();    //存放入度为0的结点
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.containsKey(cur))
                for (int num : map.get(cur))    // 更新cur结点的邻接结点的入度，若该邻接结点的入度为0则放入队列
                    if (--inDegree[num] == 0)
                        queue.offer(num);
            res[index++] = cur;
        }
        if (index == numCourses)
            return res;
        return new int[0];
    }

    //-----------------------Solution2-----------
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses], inDegree = new int[numCourses];   //入度
        int index = 0;
        ArrayList<Integer>[] map = new ArrayList[numCourses];   //邻接表
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            if (map[pre[1]] == null)
                map[pre[1]] = new ArrayList<>();
            map[pre[1]].add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();    //存放入度为0的结点
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            if (map[cur] != null)
                for (int num : map[cur])
                    if (--inDegree[num] == 0)
                        queue.offer(num);
        }
        if (index == numCourses)
            return res;
        return new int[0];
    }
}
