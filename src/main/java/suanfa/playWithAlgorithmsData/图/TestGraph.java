package suanfa.playWithAlgorithmsData.图;

public class TestGraph {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');

        // 边集 假设边集是从0开始的
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        /**
         *   0 1 2 3 4 5
         * 0   1 1 1 1
         * 1     1
         * 2
         * 3
         * 4
         * 5
         * */
        g.mst();
    }
}
