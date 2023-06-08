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

            int comp = compare(key, ptr.getKey());

            if (comp == 0) return ptr.getValue();
            else if (comp < 0) ptr = ptr.getLeft();
            else ptr = ptr.getRight();
        }
    }

    private int compare(K k1, K k2) {
        return (comparator == null) ? ((Comparable<K>) k1).compareTo(k2) : comparator.compare(k1, k2);
    }
}
