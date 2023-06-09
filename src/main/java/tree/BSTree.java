package tree;

import java.util.Comparator;

public class BSTree<K, V> {

    private Node<K, V> root;
    private Comparator<? super K> comparator;

    public BSTree(Comparator<? super K> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public V search(K key) {
        Node<K, V> ptr = root;

        while (true) {
            if (ptr == null) return null;

            int comp = compare(key, ptr.key);

            if (comp == 0) return ptr.value;
            else if (comp < 0) ptr = ptr.left;
            else ptr = ptr.right;
        }
    }

    public void add(K key, V data) {
        if (this.root == null)
            root = new Node<>(key, data, null, null);
        else
            addNode(root, key, data);
    }

    private void addNode(Node<K, V> node, K key, V data) {
        int comp = compare(key, node.getKey());
        if (comp == 0) return;

        if (comp < 0) {
            if (node.left == null) node.left = new Node<>(key, data, null, null);
            else addNode(node.left, key, data);
        } else {
            if (node.right == null) node.right = new Node<>(key, data, null, null);
            else addNode(node.right, key, data);
        }

    }

    private int compare(K k1, K k2) {
        return (comparator == null) ? ((Comparable<K>) k1).compareTo(k2) : comparator.compare(k1, k2);
    }
}
