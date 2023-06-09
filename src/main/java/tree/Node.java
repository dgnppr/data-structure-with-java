package tree;

import lombok.Getter;

@Getter
public class Node<K, V> {

    public K key;
    public V value;
    public Node<K, V> left;
    public Node<K, V> right;

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }


}
