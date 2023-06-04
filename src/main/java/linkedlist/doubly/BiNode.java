package linkedlist.doubly;

import linkedlist.singly.Node;

public class BiNode<E> extends Node<E> {

    public BiNode<E> nxt;
    public BiNode<E> prev;

    public BiNode() {
        super(null);
        this.nxt = this.prev = this;
    }

    public BiNode(E data, BiNode<E> nxt, BiNode<E> prev) {
        super(data);
        this.nxt = nxt;
        this.prev = prev;
    }

    public BiNode(E data) {
        super(data);
        this.nxt = this.prev = null;
    }
}
