package suanfa.playWithAlgorithmsData.tree.bplustree;


import suanfa.playWithAlgorithmsData.tree.bplustree.intf.IIndexSearcher;
import suanfa.playWithAlgorithmsData.tree.bplustree.tree.Tree;

public class IndexSearcher implements IIndexSearcher {
    private Tree bt = null;

    public IndexSearcher(Tree bt) {
        this.bt = bt;
    }

    @Override
    public Object search(Comparable str) {
        return this.bt.getRoot().search(str);
    }

}
