package leetcodeAll.leetcode3;

import java.util.*;

/**
 * 218. The Skyline Problem
 */
public class TheSkylineProblem {

    class Node {
        int position;
        int height;
        boolean up;

        public Node(int position, int height, boolean up) {
            this.position = position;
            this.height = height;
            this.up = up;
        }
    }

    class MyCompatator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.height != o2.height)
                return o1.position - o2.position;
            if (o1.up != o2.up)
                return o1.up ? -1 : 1;
            return 0;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        Node[] nodes = new Node[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            nodes[i * 2] = new Node(buildings[i][0], buildings[i][2], true);
            nodes[i * 2 + 1] = new Node(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(nodes, new MyCompatator());
        TreeMap<Integer, Integer> htMap = new TreeMap<>();
        TreeMap<Integer, Integer> ptMap = new TreeMap<>();
        for (Node cur : nodes) {
            if (cur.up) {
                if (htMap.containsKey(cur.height))
                    htMap.put(cur.height, htMap.get(cur.height) + 1);
                else
                    htMap.put(cur.height, 1);
            } else {
                if (htMap.get(cur.height) == 1)
                    htMap.remove(cur.height);
                else
                    htMap.put(cur.height, htMap.get(cur.height) - 1);
            }
            if (htMap.isEmpty())
                ptMap.put(cur.position, 0);
            else
                ptMap.put(cur.position, htMap.lastKey());
        }
        int h = 0;
        for (Map.Entry<Integer, Integer> entry : ptMap.entrySet()) {
            int curPos = entry.getKey();
            int curHeight = entry.getValue();
            if (h != curHeight) {
                res.add(new int[]{curPos, curHeight});
            }
            h = curHeight;
        }
        return res;
    }

    //-------------------solution2------------------
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        int cur = 0, curX, curH, len = buildings.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        while (cur < len || !pq.isEmpty()) {
            curX = pq.isEmpty() ? buildings[cur][0] : pq.peek()[0];
            if (cur >= len || buildings[cur][0] > curX) {
                while (!pq.isEmpty() && pq.peek()[0] <= curX)
                    pq.poll();
            } else {
                curX = buildings[cur][0];
                while (cur < len && buildings[cur][0] == curX) {
                    pq.offer(new int[]{buildings[cur][1], buildings[cur][2]});
                    cur++;
                }
            }
            curH = pq.isEmpty() ? 0 : pq.peek()[1];
            if (res.isEmpty() || curH != res.get(res.size() - 1).get(1)) {
                List<Integer> list = new ArrayList<>();
                list.add(curX);
                list.add(curH);
                res.add(list);
            }
        }
        return res;
    }
}
