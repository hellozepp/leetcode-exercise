package suanfa.playWithAlgorithmsData.图;

import suanfa.playWithAlgorithmsData.MyStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图
 * @author Administrator
 *
 */
public class Graph {
    //顶点数组
    private Vertex[] vertexList;
    //邻接矩阵
    private int[][] adjMat;
    //顶点的最大数目
    private int maxSize = 20;
    //当前顶点
    private int nVertex;

    public Graph() {
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
    }

    public Graph(int maxSize) {
        this.maxSize = maxSize;
        vertexList = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
    }

    /**
     * 添加顶点
     */
    public void addVertex(char label) {
        vertexList[nVertex++] = new Vertex(label);
    }

    /**
     * 添加边
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVertex; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    //深度优先, 跟广度优先唯一区别是深度用栈
    public void dfs() {
        MyStack stack = new MyStack();
        //首先访问0号顶点
        vertexList[0].wasVisited = true;
        //压入栈中
        stack.push(0);
        while (!stack.isEmpty()) {
            //获得一个未访问过的邻接点
            int v = getAdjUnvisitedVertex((int) stack.peek());
            if (v == -1) {
                displayVertex(v);
                //弹出一个顶点
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                stack.push(v);
            }
        }

        //搜索完以后，要将访问信息修改
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }

    }

    public void bfs() {
        Vertex[] vertexListHelper = new Vertex[maxSize];
        for (int i = 0; i < nVertex; i++) {
            vertexListHelper[i] = new Vertex(vertexList[i].label);
        }
        // 访问0号顶点
        vertexListHelper[0].wasVisited = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        // 顶点坐标需要是从0开始的
        queue.offer(0);
        vertexListHelper[0].wasVisited = true;
        while (!queue.isEmpty()) {
            int v = getAdjUnvisitedVertex(queue.peek());
            if (v == -1) {
                System.out.println(vertexListHelper[queue.poll()].label);
            } else {
                vertexListHelper[v].wasVisited = true;
                queue.offer(v);
            }
        }
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    //无权无向图的最小生成树 跟深度优先区别是在压入的时候即打印边
    // 概念: 图的生成树是它的一颗含有其所有顶点的无环连通子图，一幅加权图的最小生成树(MST)是它的一颗权值(树中的所有边的权值之和)最小的生成树
    // https://blog.csdn.net/daaikuaichuan/article/details/80572495
    // 克鲁斯卡尔: 对所有加权图的有权边排序,从小到大访问,如果有环就跳过这个边
    // 迪杰斯特拉:
    // 普里姆算法: 从顶点访问下一个点,取权最小的,然后把访问过的顶点保存,每次取保存节点到下一个节点最小的边
    // 【Note】：
    //（1）复杂度分析：克鲁斯卡尔算法的时间复杂度为O(eloge)；普里姆算法的时间复杂度为，邻接矩阵：O(v^2)，邻接表：O(elog2v)。
    // v 为点集合,u 为顶点,e 为边集合
    //（2）克鲁斯卡尔算法主要针对边展开，边数少时效率会很高，所以对于稀疏图有优势而普利姆算法对于稠密图，即边数非常多的情况会好些。
    // Prim是计算最小生成树的算法，比如为N个村庄修路，怎么修花销最少。MST一般用于无向图
    // Dijkstra是计算最短路径的算法，比如从a村庄走到其他任意村庄的距离。最短路径一般作用有向图访问指定的 U-A
    public void mst() {
        MyStack stack = new MyStack();
        //首先访问0号顶点
        vertexList[0].wasVisited = true;
        //压入栈中
        stack.push(0);
        while (!stack.isEmpty()) {
            //当前顶点
            int currentVertex = (int) stack.peek();
            //获得一个未访问过的邻接点
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                //弹出一个顶点
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                stack.push(v);
                displayVertex(currentVertex);
                System.out.print("-");
                displayVertex(v);
                System.out.print(" ");
            }
        }

        //搜索完以后，要将访问信息修改
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].wasVisited = false;
        }
    }

}
