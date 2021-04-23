package suanfa.playWithAlgorithmsData.tree;


import suanfa.playWithAlgorithmsData.tree.bplustree.IndexCreater;
import suanfa.playWithAlgorithmsData.tree.bplustree.IndexSearcher;
import suanfa.playWithAlgorithmsData.tree.bplustree.tree.Tree;

public class Sample {
    public static void main(String[] args) {
        Tree bt = new Tree(8);
        //此处没有实现降低树的深度，根据我面试的时候说的那个hash可以先把数据分片，然后分布式的做这个树，这样数据量大也会搜索速度更快
        IndexCreater ic = new IndexCreater(bt);
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                ic.insertOrUpdate("str" + i, "xxx" + i);
            }
        }
        IndexSearcher is = new IndexSearcher(bt);
        String str = "str11";
        System.out.print(is.search(str));

    }

}
