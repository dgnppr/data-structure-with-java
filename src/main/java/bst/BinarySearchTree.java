package bst;

import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<K, V> implements MyBSTree<K, V> {

    private Node<K, V> root;
    private Comparator<K> comparator;

    public BinarySearchTree(Comparator<K> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    @Override
    public Node<K, V> search(K key) {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;

        while (ptr != null) {
            int diff = comparator.compare(ptr.key, key);

            if (diff == 0) return ptr;
            else if (diff < 0) ptr = ptr.right;
            else ptr = ptr.left;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return search(key) != null;
    }

    @Override
    public boolean add(K key, V value) {
        Node<K, V> node = new Node<>(key, value, null, null);

        if (isEmpty()) {
            this.root = node;
            return true;
        } else {
            Node<K, V> ptr = this.root;
            Node<K, V> parent = this.root;
            boolean isLeftChild = true;

            while (ptr != null) {
                int diff = comparator.compare(ptr.key, key);

                parent = ptr;
                if (diff == 0) return false;
                else if (diff < 0) {
                    ptr = ptr.right;
                    isLeftChild = false;
                } else {
                    ptr = ptr.left;
                    isLeftChild = true;
                }
            }

            if (isLeftChild) parent.left = node;
            else parent.right = node;

            return true;
        }
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Node<K, V> getSuccessor(K key) {
        if (isEmpty() || !contains(key)) return null;

        Node<K, V> node = search(key);

        if (node.right == null) return null;

        Node<K, V> successor = node.right;
        while (successor.left != null) {
            successor = successor.left;
        }

        return successor;
    }

    @Override
    public Node<K, V> getPredecessor(K key) {
        return null;
    }

    @Override
    public List<K> postOrderTraversal() {
        return null;
    }

    @Override
    public List<K> inOrderTraversal() {
        return null;
    }

    @Override
    public List<K> preOrderTraversal() {
        return null;
    }

    @Override
    public Node<K, V> getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }
}
