package bst;

import java.util.List;

public interface MyBSTree<K, V> {

    Node<K, V> getRoot();

    Node<K, V> search(K key);

    boolean contains(K key);

    boolean add(K key, V value);

    boolean remove(K key);

    Node<K, V> getSuccessor(K key);

    Node<K, V> getPredecessor(K key);

    List<K> postOrderTraversal();

    List<K> inOrderTraversal();

    List<K> preOrderTraversal();
}
