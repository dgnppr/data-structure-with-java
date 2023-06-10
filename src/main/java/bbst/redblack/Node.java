package bbst.redblack;

public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> left, right;
    private boolean color;
    private int size;
}
