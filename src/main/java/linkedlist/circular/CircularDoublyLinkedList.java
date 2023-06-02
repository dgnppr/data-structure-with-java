package linkedlist.circular;

import linkedlist.BiNode;

public class CircularDoublyLinkedList<E> {

    private final BiNode<E> head;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = new BiNode<>(null);
    }


    public void addAtFirst(E data) {
        if (isEmpty()) {
            this.head.nxt = new BiNode<>(data, null, this.head);
        } else {
            BiNode<E> ptr = this.head.nxt;
            BiNode<E> node = new BiNode<>(data, ptr, this.head);
            this.head.nxt = ptr.prev = node;
        }
        this.size++;
    }

    public void addAtLast(E data) {
        if (isEmpty()) {
            addAtFirst(data);
        } else {

        }
    }

    private boolean isEmpty() {
        return head.nxt == null;
    }
}
