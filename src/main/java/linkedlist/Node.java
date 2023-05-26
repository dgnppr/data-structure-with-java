package linkedlist;

public class Node<E> {

    public E data;
    public Node<E> nxt;

    public Node(E data, Node<E> nxt) {
        this.data = data;
        this.nxt = nxt;
    }

    public Node(E data) {
        this.data = data;
        this.nxt = null;
    }
}
