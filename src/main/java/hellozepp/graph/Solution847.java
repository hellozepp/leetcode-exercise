package hellozepp.graph;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 
 *
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 *
 * @Author: zhanglin
 * @Date: 2021/5/10
 * @Time: 1:00 AM
 */
public class Solution847 {

    class node {
        int head, cover;

        public node(int head, int cover) {
            this.head = head;
            this.cover = cover;
        }
    }

    /**
     * 方法一：广搜最短路。
     * 因为N只有12这么大， 我们可以考虑用二进制表示状态，其中若二进制表示中第i位为1表示编号为i
     * 的点在所走的路径中已经访问过，既然状态能够正确表示，剩下的就是最短路板子题了。
     * @param graph
     * @return
     */
    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        int[][] dis = new int[1 << n][n];
        Queue<node> q = new LinkedList<>();
        for (int[] dist : dis) {
            Arrays.fill(dist, n * n);
        }

        for (int i = 0; i < n; i++) {
            q.add(new node(i, 1 << i));
            dis[1 << i][i] = 0;
        }

        while (!q.isEmpty()) {
            node now = q.poll();
            int d = dis[now.cover][now.head];
            if (now.cover == (1 << n) - 1) {
                return d;
            }

            for (int child : graph[now.head]) {
                int nowCover = now.cover | (1 << child);
                if (d + 1 < dis[nowCover][child]) {
                    dis[nowCover][child] = d + 1;
                    q.add(new node(child, nowCover));
                }
            }
        }

        return -1;
    }

    /**
     * 方法二：动态规划（参考官方题解）
     *
     * 该方法大致思路和方法一相同，我们仍然用dis[cover][head]表示到head节点并且路径状态为cover的最短路径，每个状态其实是一个DAG（有向无环图），对于这类图，我们往往可以用动态规划解决。
     *
     * 对于每个head节点，下一个可能的next节点来自于与head直接相连的点集，在每次添加新节点时，如果 dist[cover2][next] > dist[cover][head] + 1，则更新路径长度 dist[cover2][next] = dist[cover][head] + 1，如果 cover = cover2，则需要在同一 cover 上再次执行松弛法，重新更新最短路径。
     *
     * 在每次cover迭代的过程中，产生的新状态cover2都满足cover2>=cover，因此这也是拓扑排序，所有路径形成了DAG。
     * @param graph
     * @return
     */
    public int shortestPathLength1(int[][] graph) {

        int n = graph.length;
        int[][] dis = new int[1 << n][n];
        for (int[] dist : dis) {
            Arrays.fill(dist, n * n);
        }

        for (int i = 0; i < n; i++) {
            dis[1 << i][i] = 0;
        }

        for (int cover = 0; cover < (1 << n); cover++) {
            boolean flag = true;
            while (flag) {
                flag = false;
                for (int head = 0; head < n; head++) {
                    int d = dis[cover][head];
                    for (int next : graph[head]) {
                        int cover2 = cover | (1 << next);
                        if (d + 1 < dis[cover2][next]) {
                            dis[cover2][next] = d + 1;
                            if (cover2 == cover) {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }

        int ans = n * n;
        for (int val : dis[(1 << n) - 1]) {
            ans = Math.min(ans, val);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        System.out.println(JSON.toJSONString(ints));
        System.out.println(JSON.toJSONString(new Solution847()
                .shortestPathLength(ints)));
    }

}
