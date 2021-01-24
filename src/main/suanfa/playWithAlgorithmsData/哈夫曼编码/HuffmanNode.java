package suanfa.playWithAlgorithmsData.哈夫曼编码;

/**********哈夫曼树的节点类描述*********/
public class HuffmanNode {
    private int weight;//权重
    private int flag;//是否加入到huffman树中
    private HuffmanNode parent, lchild, rchild;//树种的结点之间的关系

    public HuffmanNode() {//构造空结点
        this(0);
    }

    public HuffmanNode(int weight) {//构造只具有权值的空结点
        this.weight = weight;
        flag = 0;
        parent = lchild = rchild = null;
    }

    public void setweight(int weight) {
        this.weight = weight;
    }

    public int getweight() {
        return weight;
    }

    public void setflag(int flag) {
        this.flag = flag;
    }

    public int getflag() {
        return flag;
    }

    public void setparent(HuffmanNode parent) {
        this.parent = parent;
    }

    public HuffmanNode getparent() {
        return parent;
    }

    public void setlchild(HuffmanNode lchild) {
        this.lchild = lchild;
    }

    public HuffmanNode getlchild() {
        return lchild;
    }

    public void setrchild(HuffmanNode rchild) {
        this.rchild = rchild;
    }

    public HuffmanNode getrchild() {
        return rchild;
    }
}