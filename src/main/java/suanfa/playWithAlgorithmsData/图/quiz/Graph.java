package suanfa.playWithAlgorithmsData.图.quiz;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    //当前顶点
    private int nVertex;
    private int[][] adjMat;
    private Vertex[] vertexList;
    private int maxSize;
    private MyStack stack;

    public Graph() {
        nVertex = 0;
        maxSize = 20;
        stack = new MyStack();
        adjMat = new int[maxSize][maxSize];
        vertexList = new Vertex[maxSize];
    }

    public void addVertex(char a) {
        vertexList[nVertex++] = new Vertex(a);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void DFS() {
        vertexList[0].isVisited = true;
        System.out.println(vertexList[0].label);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitedAdjMat(stack.peek());
            if (v != -1) {
                System.out.println(vertexList[v].label);
                vertexList[v].isVisited = true;
                stack.push(v);
            } else {
                stack.pop();
            }
        }
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].isVisited = false;
        }
    }

    public void BFS() {
        vertexList[0].isVisited = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        vertexList[0].isVisited = true;
        while (!queue.isEmpty()) {
            int peek = queue.peek();
            int v = getUnvisitedAdjMat(peek);
            if (v == -1) {
                System.out.println(vertexList[queue.poll()].label);
            } else {
                queue.offer(v);
                vertexList[v].isVisited = true;
            }
        }
        for (int i = 0; i < nVertex; i++) {
            vertexList[i].isVisited = false;
        }
    }

    public int getUnvisitedAdjMat(int v) {
        for (int i = 0; i < nVertex; ++i) {
            if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    class Vertex {
        private char label;
        public boolean isVisited;

        public Vertex() {
        }

        public Vertex(char label) {
            this.label = label;
        }

        public char getLabel() {
            return label;
        }

        public void setLabel(char label) {
            this.label = label;
        }
    }

    class MyStack {
        private int maxSize = 20;
        int top;
        int[] arr;

        public MyStack() {
            arr = new int[10];
            top = -1;
        }

        public MyStack(int maxSize) {
            arr = new int[maxSize];
            top = -1;
        }

        public int peek() {
            if (top == -1) {
                return -1;
            }
            return arr[top];
        }

        public void push(int i) {
            arr[++top] = i;
        }

        public int pop() {
            return arr[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(0, 5);

        g.BFS();
    }
}
