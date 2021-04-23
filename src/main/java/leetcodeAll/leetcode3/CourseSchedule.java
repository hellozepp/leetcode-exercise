package leetcodeAll.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 207. Course Schedule
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] root1 = new int[numCourses], root2 = new int[numCourses];     //root[i]的值表示第i个结点的前驱结点
        int[][] reverse = new int[prerequisites.length][2];     //反转连接
        for (int i = 0; i < numCourses; i++)        // 初始化每一个结点都指向自己
            root1[i] = root2[i] = i;
        for (int i = 0; i < reverse.length; i++) {
            reverse[i][0] = prerequisites[i][1];
            reverse[i][1] = prerequisites[i][0];
        }
        return hasCycle(root1, prerequisites) && hasCycle(root2, reverse);
    }

    private boolean hasCycle(int[] root, int[][] prerequisites) {   //判断是否有环
        for (int[] pre : prerequisites) {
            int before = pre[1], after = pre[0];
            while (root[before] != before) {    //向前回溯直到指向自己
                before = root[before];
                if (before == after)
                    return false;
            }
            root[after] = before;
        }
        return true;
    }

    //-------------solution2-------------
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];   //入度
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //邻接表
        for (int[] pre : prerequisites) {   //初始化入度和邻接表
            inDegree[pre[0]]++;
            if (!map.containsKey(pre[1]))
                map.put(pre[1], new ArrayList());
            map.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList();    //存放入度为0且存在于邻接表中的结点
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0 && map.containsKey(i))
                queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int num : map.get(cur))    // 更新cur结点的邻接结点的入度，若该邻接结点的入度为0且有后继结点则放入队列
                if (--inDegree[num] == 0 && map.containsKey(num))
                    queue.offer(num);
            map.remove(cur);
        }
        if (map.isEmpty())      //邻接表为空表示不存在环，否则邻接表非空，其中的结点入度都不为0，则表示有环
            return true;
        return false;
    }
}
