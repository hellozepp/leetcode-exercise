package suanfa.playWithAlgorithmsData.tree.bplustree.intf;

public interface IIndexSearcher {
    //查询匹配的条目内容，返回rowkey
    public Object search(Comparable str);
}
