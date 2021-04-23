package leetcodeAll.leetcode2;

import others.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 133. Clone Graph
 */
public class CloneGraph {
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
        map.put(node.label, cur);
        for (UndirectedGraphNode n : node.neighbors) {
            cur.neighbors.add(cloneGraph(n));
        }
        return cur;
    }
}
