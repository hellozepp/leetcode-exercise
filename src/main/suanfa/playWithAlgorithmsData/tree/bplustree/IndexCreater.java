package suanfa.playWithAlgorithmsData.tree.bplustree;


import suanfa.playWithAlgorithmsData.tree.bplustree.intf.IIndexCreater;
import suanfa.playWithAlgorithmsData.tree.bplustree.tree.Tree;

public class IndexCreater implements IIndexCreater {
    private Tree bt = null;

    public IndexCreater(Tree bt) {
        this.bt = bt;
    }

    @Override
    public void insertOrUpdate(Comparable str, Object rowkey) {
        this.bt.getRoot().insertOrUpdate(str, rowkey, bt);
    }

}
