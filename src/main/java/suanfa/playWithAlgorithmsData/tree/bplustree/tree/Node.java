package suanfa.playWithAlgorithmsData.tree.bplustree.tree;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Node {
	//主树节点
	//是否为叶子节点
    protected boolean isLeaf;
    //是否为root根节点
    protected boolean isRoot;
    //父节点
    protected Node parent;
    //子节点
    protected List<Node> children;

    //子节点链表
    //前节点
    protected Node previous;
    //后节点
    protected Node next;
    //内容
    protected List<Entry<Comparable, Object>> entries;

    //构造函数，确定是否是跟节点或者叶子结点
    public Node(boolean isLeaf, boolean isRoot) {
    	 this.isLeaf = isLeaf;
    	 this.isRoot = isRoot;
         entries = new ArrayList<Entry<Comparable, Object>>();
         if (!isLeaf) {
             children = new ArrayList<Node>();
         }
    }
    //递归查找
    public Object search(Comparable str) {
        //如果是叶子节点 ，就查找并返回rowkey
        if (isLeaf) {
            for (Entry<Comparable, Object> entry : entries) {
                if (entry.getKey().compareTo(str) == 0) {
                    return entry.getValue();
                }
            }
            return null;
        }else {
            //如果key小于等于节点最左边的key，沿第一个子节点继续搜索
            if (str.compareTo(entries.get(0).getKey()) <= 0) {
                return children.get(0).search(str);
            //如果key大于节点最右边的key，沿最后一个子节点继续搜索
            }else if (str.compareTo(entries.get(entries.size()-1).getKey()) >= 0) {
                return children.get(children.size()-1).search(str);
            //否则沿比key大的前一个子节点继续搜索
            }else {
                for (int i = 0; i < entries.size(); i++) {
                    if (entries.get(i).getKey().compareTo(str) <= 0 && entries.get(i+1).getKey().compareTo(str) > 0) {
                        return children.get(i).search(str);
                    }
                }
            }
        }
        return null;
    }
    //判断是否有这个条目
    protected boolean contains(Comparable str) {
        for (Entry<Comparable, Object> entry : entries) {
            if (entry.getKey().compareTo(str) == 0) {
                return true;
            }
        }
        return false;
    }
    //将条目插入当前子树叶子节点的内容中
    protected void insertOrUpdate(Comparable str, Object rowkey){
        Entry<Comparable, Object> entry = new SimpleEntry<Comparable, Object>(str, rowkey);
        //如果关键字列表长度为0，则直接插入
        if (entries.size() == 0) {
            entries.add(entry);
            return;
        }
        //否则遍历列表
        for (int i = 0; i < entries.size(); i++) {
            //如果该关键字键值已存在，则更新
            if (entries.get(i).getKey().compareTo(str) == 0) {
                entries.get(i).setValue(rowkey);
                return;
            //出入数据
            }else if (entries.get(i).getKey().compareTo(str) > 0){
                //插入到链首
                if (i == 0) {
                    entries.add(0, entry);
                    return;
                //插入到中间
                }else {
                    entries.add(i, entry);
                    return;
                }
            }
        }
        //插入到末尾
        entries.add(entries.size(), entry);
    }
    //内容是否存在
    protected boolean existsStr(Comparable str) {
        for (Entry<Comparable, Object> entry : entries) {
            if (entry.getKey().compareTo(str) == 0) {
                return true;
            }
        }
        return false;
    }

    //构建bplustree
    protected static void validate(Node node, Tree tree) {

        //条目个数==子节点个数
        if (node.getEntries().size() == node.getChildren().size()) {
            for (int i = 0; i < node.getEntries().size(); i++) {
                Comparable str = node.getChildren().get(i).getEntries().get(0).getKey();
                if (node.getEntries().get(i).getKey().compareTo(str) != 0) {
                    node.getEntries().remove(i);
                    node.getEntries().add(i, new SimpleEntry(str, null));
                    if(!node.isRoot()){
                        validate(node.getParent(), tree);
                    }
                }
            }
        //节点为根节点且子节点>=2 或者  m/2（条目数）<=子节点个数<=m（条目数），子节点个数>2
        } else if (node.isRoot() && node.getChildren().size() >= 2
                ||node.getChildren().size() >= tree.getM() / 2
                && node.getChildren().size() <= tree.getM()
                && node.getChildren().size() >= 2) {
            node.getEntries().clear();
            for (int i = 0; i < node.getChildren().size(); i++) {
                Comparable str = node.getChildren().get(i).getEntries().get(0).getKey();
                node.getEntries().add(new SimpleEntry(str, null));
                if (!node.isRoot()) {
                    validate(node.getParent(), tree);
                }
            }
        }
    }

	//调整非叶子结点
    protected void updateInsert(Tree tree){

        validate(this, tree);

        //如果子节点数超出m，则需要分裂该节点
        if (children.size() > tree.getM()) {
            //分裂成左右两个节点
            Node left = new Node(false,false);
            Node right = new Node(false,false);
            //左右两个节点关键字长度
            int leftSize = (tree.getM() + 1) / 2 + (tree.getM() + 1) % 2;
            int rightSize = (tree.getM() + 1) / 2;
            //复制子节点到分裂出来的新节点，并更新关键字
            for (int i = 0; i < leftSize; i++){
                left.getChildren().add(children.get(i));
                left.getEntries().add(new SimpleEntry(children.get(i).getEntries().get(0).getKey(), null));
                children.get(i).setParent(left);
            }
            for (int i = 0; i < rightSize; i++){
                right.getChildren().add(children.get(leftSize + i));
                right.getEntries().add(new SimpleEntry(children.get(leftSize + i).getEntries().get(0).getKey(), null));
                children.get(leftSize + i).setParent(right);
            }

            //如果不是根节点
            if (parent != null) {
                //调整父子节点关系
                int index = parent.getChildren().indexOf(this);
                parent.getChildren().remove(this);
                left.setParent(parent);
                right.setParent(parent);
                parent.getChildren().add(index,left);
                parent.getChildren().add(index + 1, right);
                setEntries(null);
                setChildren(null);

                //父节点更新关键字
                parent.updateInsert(tree);
                setParent(null);
            //如果是根节点
            }else {
                isRoot = false;
                Node parent = new Node(false, true);
                tree.setRoot(parent);
                left.setParent(parent);
                right.setParent(parent);
                parent.getChildren().add(left);
                parent.getChildren().add(right);
                setEntries(null);
                setChildren(null);

                //更新根节点
                parent.updateInsert(tree);
            }
        }
    }

    //插入更新条目
    public void insertOrUpdate(Comparable str, Object rowkey, Tree tree){
        //如果是叶子节点
        if (isLeaf){
            //不需要分裂，直接插入或更新
            if (contains(str) || entries.size() < tree.getM()){
                insertOrUpdate(str, rowkey);
                if (parent != null) {
                    //更新父节点
                    parent.updateInsert(tree);
                }

            //需要分裂
            }else {
                //分裂成左右两个节点
                Node left = new Node(true,false);
                Node right = new Node(true,false);
                //设置链接
                if (previous != null){
                    previous.setNext(left);
                    left.setPrevious(previous);
                }
                if (next != null) {
                    next.setPrevious(right);
                    right.setNext(next);
                }
                if (previous == null){
                    tree.setHead(left);
                }

                left.setNext(right);
                right.setPrevious(left);
                previous = null;
                next = null;

                //左右两个节点条目数
                int leftSize = (tree.getM() + 1) / 2 + (tree.getM() + 1) % 2;
                int rightSize = (tree.getM() + 1) / 2;
                //复制原节点条目到分裂出来的新节点
                insertOrUpdate(str, rowkey);
                for (int i = 0; i < leftSize; i++){
                    left.getEntries().add(entries.get(i));
                }
                for (int i = 0; i < rightSize; i++){
                    right.getEntries().add(entries.get(leftSize + i));
                }

                //如果不是根节点
                if (parent != null) {
                    //调整父子节点关系
                    int index = parent.getChildren().indexOf(this);
                    parent.getChildren().remove(this);
                    left.setParent(parent);
                    right.setParent(parent);
                    parent.getChildren().add(index,left);
                    parent.getChildren().add(index + 1, right);
                    setEntries(null);
                    setChildren(null);

                    //父节点插入或更新条目
                    parent.updateInsert(tree);
                    setParent(null);
                //如果是根节点
                }else {
                    isRoot = false;
                    Node parent = new Node(false, true);
                    tree.setRoot(parent);
                    left.setParent(parent);
                    right.setParent(parent);
                    parent.getChildren().add(left);
                    parent.getChildren().add(right);
                    setEntries(null);
                    setChildren(null);

                    //更新根节点
                    parent.updateInsert(tree);
                }


            }

        //如果不是叶子节点
        }else {
            //如果条目小于等于节点最左边的条目，沿第一个子节点继续搜索
            if (str.compareTo(entries.get(0).getKey()) <= 0) {
                children.get(0).insertOrUpdate(str, rowkey, tree);
            //如果条目大于节点最右边的条目，沿最后一个子节点继续搜索
            }else if (str.compareTo(entries.get(entries.size()-1).getKey()) >= 0) {
                children.get(children.size()-1).insertOrUpdate(str, rowkey, tree);
            //否则沿比条目大的前一个子节点继续搜索
            }else {  
                for (int i = 0; i < entries.size(); i++) {  
                    if (entries.get(i).getKey().compareTo(str) <= 0 && entries.get(i+1).getKey().compareTo(str) > 0) {  
                        children.get(i).insertOrUpdate(str, rowkey, tree);  
                        break;  
                    }  
                }     
            }  
        }  
    } 
    

    public boolean isLeaf() {
  		return isLeaf;
  	}
  	public void setLeaf(boolean isLeaf) {
  		this.isLeaf = isLeaf;
  	}
  	public boolean isRoot() {
  		return isRoot;
  	}
  	public void setRoot(boolean isRoot) {
  		this.isRoot = isRoot;
  	}
  	public Node getParent() {
  		return parent;
  	}
  	public void setParent(Node parent) {
  		this.parent = parent;
  	}
  	public List<Node> getChildren() {
  		return children;
  	}
  	public void setChildren(List<Node> children) {
  		this.children = children;
  	}
  	public Node getPrevious() {
  		return previous;
  	}
  	public void setPrevious(Node previous) {
  		this.previous = previous;
  	}
  	public Node getNext() {
  		return next;
  	}
  	public void setNext(Node next) {
  		this.next = next;
  	}
  	public List<Entry<Comparable, Object>> getEntries() {
  		return entries;
  	}
  	public void setEntries(List<Entry<Comparable, Object>> entries) {
  		this.entries = entries;
  	}
}
