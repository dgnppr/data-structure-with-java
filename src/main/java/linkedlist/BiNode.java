package linkedlist;

public class BiNode<E> extends Node<E> {

    public BiNode<E> nxt;
    public BiNode<E> prev;

    public BiNode(E data, BiNode<E> nxt, BiNode<E> prev) {
        super(data);
        this.nxt = nxt;
        this.prev = prev;
    }
    
    public BiNode(E data) {
        super(data);
        this.prev = null;
    }
}
