package suanfa.playWithAlgorithmsData.UnionFind.unionFildTest;

public class unionTest {
    int[] parent;
    int[] rank;
    int count;

    public unionTest(int count) {
        parent = new int[count];
        rank = new int[count];
        this.count = count;
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int i) {
        assert i >= 0 && i < count : "查找的索引不存在";
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean isConnected(int i, int j) {
        assert i >= 0 && i < count && j >= 0 && j < count;
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        assert i >= 0 && i < count && j >= 0 && j < count;
        int p = find(i);
        int q = find(j);
        if (p == q) {
            return;
        } else if (rank[p] > rank[q]) {
            parent[q] = p;
        } else if (rank[p] < rank[q]) {
            parent[p] = q;
        } else {
            parent[q] = p;
            rank[p]++;
        }
    }

    public void println() {
        for (int i : parent) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        unionTest unionTest = new unionTest(10);
        unionTest.println();
        System.out.println("\n" + unionTest.find(3));
        unionTest.println();
        unionTest.union(1, 3);
        unionTest.println();


    }
}
