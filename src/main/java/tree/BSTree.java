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

        while (ptr != null) {
            int diff = compare(key, ptr.key);

            if (diff == 0)
                return ptr.value;
            else if (diff < 0)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }

        return null;
    }

    public void add(K key, V value) {
        if (this.root == null) {
            this.root = new Node<>(key, value, null, null);
        } else {
            Node<K, V> ptr = this.root;

            while (true) {
                int diff = compare(key, ptr.key);
                if (diff == 0) return;

                if (diff < 0) {
                    if (ptr.left == null) {
                        ptr.left = new Node<>(key, value, null, null);
                        return;
                    } else {
                        ptr = ptr.left;
                    }
                } else {
                    if (ptr.right == null) {
                        ptr.right = new Node<>(key, value, null, null);
                        return;
                    } else {
                        ptr = ptr.right;
                    }
                }
            }
        }
    }

    public boolean remove(K key) {
        Node<K, V> ptr = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        // Search node which has same key
        while (true) {
            if (ptr == null) return false;

            int diff = compare(key, ptr.key);
            if (diff == 0) break;

            parent = ptr;
            if (diff < 0) {
                isLeftChild = true;
                ptr = ptr.left;
            } else {
                isLeftChild = false;
                ptr = ptr.right;
            }
        }

        // Remove Node
        if (ptr.left == null) { // When node has no left child node
            if (isRootNode(ptr)) this.root = ptr.right;
            else if (isLeftChild) parent.left = ptr.right;
            else parent.right = ptr.right;

        } else if (ptr.right == null) { // When node has no right child
            if (isRootNode(ptr)) this.root = ptr.left;
            else if (isLeftChild) parent.left = ptr.left;
            else parent.right = ptr.left;

        } else { // When node has left and right child
            parent = ptr;

            // 1.Search largest node in left subtree
            Node<K, V> left = ptr.left;
            isLeftChild = true;
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }

            // 2.Move largest node to target node
            ptr.key = left.key;
            ptr.value = left.value;

            // 3.Remove left node
            if (isLeftChild) parent.left = left.left;
            else parent.right = left.left;
        }

        return true;
    }

    public void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.println(node);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }

    public void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.println(node);
        inOrderTraversal(node.right);
    }

    public Node getRoot() {
        return this.root == null ? null : this.root;
    }

    private int compare(K k1, K k2) {
        return (comparator == null) ? ((Comparable<K>) k1).compareTo(k2) : comparator.compare(k1, k2);
    }

    private boolean isRootNode(Node<K, V> ptr) {
        return ptr == this.root;
    }
}
