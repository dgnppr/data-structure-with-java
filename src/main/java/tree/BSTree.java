package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

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
        if (isEmpty()) {
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

    public List<K> preOrderTraversal() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;
        Stack<Node<K, V>> stack = new Stack<>();
        List<K> rst = new ArrayList<>();

        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                rst.add(ptr.key);
                stack.push(ptr);
                ptr = ptr.left;
            }

            ptr = stack.pop();
            ptr = ptr.right;
        }

        return rst;
    }

    public List<K> inOrderTraversal() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;
        Stack<Node<K, V>> stack = new Stack<>();
        List<K> rst = new ArrayList<>();

        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }

            ptr = stack.pop();
            rst.add(ptr.key);
            ptr = ptr.right;

        }
        return rst;
    }

    public List<K> postOrderTraversal() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;
        Node<K, V> prev = null;
        Stack<Node<K, V>> stack = new Stack<>();
        List<K> rst = new ArrayList<>();

        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }

            ptr = stack.peek();

            if (ptr.right == null || ptr.right == prev) {
                ptr = stack.pop();
                rst.add(ptr.key);
                prev = ptr;
                ptr = null;
            } else {
                ptr = ptr.right;
            }
        }

        return rst;
    }

    public K getMinKey() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;

        while (ptr.left != null) {
            ptr = ptr.left;
        }

        return ptr.key;
    }

    public V getValueWithMinKey() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;

        while (ptr.left != null) {
            ptr = ptr.left;
        }

        return ptr.value;
    }

    public K getMaxKey() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;

        while (ptr.right != null) {
            ptr = ptr.right;
        }

        return ptr.key;

    }

    public V getValueWithMaxKey() {
        if (isEmpty()) return null;

        Node<K, V> ptr = this.root;

        while (ptr.right != null) {
            ptr = ptr.right;
        }

        return ptr.value;

    }

    public Node<K, V> getRoot() {
        return isEmpty() ? null : this.root;
    }

    private boolean isEmpty() {
        return this.root == null;
    }

    private int compare(K k1, K k2) {
        return (comparator == null) ? ((Comparable<K>) k1).compareTo(k2) : comparator.compare(k1, k2);
    }

    private boolean isRootNode(Node<K, V> ptr) {
        return ptr == this.root;
    }
}
