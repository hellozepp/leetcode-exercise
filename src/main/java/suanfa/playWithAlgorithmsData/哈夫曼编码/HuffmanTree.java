package suanfa.playWithAlgorithmsData.哈夫曼编码;

public class HuffmanTree {
    public int[][] huffmanCoding(int[] w) {
        int n = w.length;
        int m = 2 * n - 1;
        HuffmanNode[] HN = new HuffmanNode[m];//生成一个元素为哈夫曼树结点的数组
        int i;
        for (i = 0; i < n; i++) {
            HN[i] = new HuffmanNode(w[i]);//生成哈夫曼树的叶子结点
        }
        for (i = n; i < m; i++) {
            HuffmanNode min1 = selectMin(HN, i - 1);
            min1.setflag(1);
            HuffmanNode min2 = selectMin(HN, i - 1);//上面找到的那个flag已标志为１,所以不会再次寻找
            min2.setflag(1);//找到所有节点中权重最小的结点加入到哈夫曼树中
            HN[i] = new HuffmanNode();
            min1.setparent(HN[i]);
            min2.setparent(HN[i]);
            HN[i].setlchild(min1);
            HN[i].setrchild(min2);
            HN[i].setweight(min1.getweight() + min2.getweight());//修改两个结点的父节点，及权重
        }
        int[][] HuffCode = new int[n][n];//分配n个字符编码存储空间
        for (int j = 0; j < n; j++) {//数组
            int start = n - 1;

//从后开始　对HuffCode数组每个结点的下标由后向前填充，保证编码的前缀相同00...　huffCode[0][6]=1 huffCode[0][5]=0

//则huffCode 为００００　０００１即小标为１的一个哈夫曼结点的哈夫曼变慢
            for (HuffmanNode c = HN[j], p = c.getparent(); p != null; c = p, p = p.getparent()) {
                if (p.getlchild().equals(c)) HuffCode[j][start--] = 0;
                else HuffCode[j][start--] = 1;
            }//对同一个结点的路径做遍历
            HuffCode[j][start--] = -1;//对剩余的路径为填充－１
        }//对n个叶子结点的路径做遍历
        return HuffCode;//返回哈夫曼编码数组
    }

    private HuffmanNode selectMin(HuffmanNode[] HN, int end) {
        HuffmanNode min = HN[end];
        for (int i = 0; i <= end; i++) {
            HuffmanNode h = HN[i];
            if (h.getflag() == 0 && h.getweight() < min.getweight())
                min = h;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] w = {23, 11, 5, 3, 29, 14, 7, 8};
        HuffmanTree t = new HuffmanTree();
        int[][] HN = t.huffmanCoding(w);
        System.out.println("哈弗满编码为：");
        for (int i = 0; i < HN.length; i++) {//n个叶子结点
            System.out.print(w[i] + "： ");
            for (int j = 0; j < HN[i].length; j++) {//每个叶子结点对应一个结点的n个编码位置做遍历
                if (HN[i][j] == -1) {//值输出有路径的编码位（n位中的后几位）
                    for (int k = j + 1; k < HN[i].length; k++)
                        System.out.print(HN[i][k]);
                    break;
                }
            }
            System.out.println();

        }
    }
}
