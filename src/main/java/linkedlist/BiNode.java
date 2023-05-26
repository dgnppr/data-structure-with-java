package linkedlist;

public class BiNode<E> extends Node<E> {

    public Node<E> prev;

    public BiNode(E data, Node<E> nxt, Node<E> prev) {
        super(data, nxt);
        this.prev = prev;
    }

    public BiNode(E data, Node<E> prev) {
        super(data);
        this.prev = prev;
    }

    public BiNode(E data) {
        super(data);
        this.prev = null;
    }
}
