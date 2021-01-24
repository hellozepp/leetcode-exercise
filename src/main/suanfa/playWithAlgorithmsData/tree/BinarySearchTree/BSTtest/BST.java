package suanfa.playWithAlgorithmsData.tree.BinarySearchTree.BSTtest;

public class BST<K extends Comparable<K>, V> {
    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
            left = right = null;
        }
    }

    private Node root;
    private int count;

    public BST() {
        count = 0;
        root = null;
    }

    public void insert(K key, V value) {
        this.root = insert(root, key, value);
    }

    private Node insert(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key, value);
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    private void remove(K k) {
        this.root = remove(root, k);
    }

    private Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.key) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if (k.compareTo(node.key) > 0) {
            node.right = remove(node.right, k);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                count--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.left = node.right = null;
            return successor;

        }
    }

    public void removeMin() {
        assert count != 0;
        if (this.root != null) {
            root = removeMin(root.right);
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node) {
        assert count != 0;
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
}
