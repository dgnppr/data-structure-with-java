package linkedlist.circular;

import linkedlist.BiNode;

import java.util.ArrayList;
import java.util.List;

public class CircularDoublyLinkedList<E> {

    private final BiNode<E> head;
    private int size;

    public CircularDoublyLinkedList() {
        this.head = new BiNode<>();
    }

    public void addAtFirst(E data) {
        BiNode<E> nxt = this.head.nxt;
        nxt.prev = this.head.nxt = new BiNode<>(data, nxt, this.head);
        this.size++;
    }

    public void addAtLast(E data) {
        BiNode<E> tail = this.head.prev;
        tail.nxt = this.head.prev = new BiNode<>(data, this.head, tail);
        this.size++;
    }

    public void addAt(E data, int index) {
        if (isEmpty() || index < 0 || index >= this.size) return;

        BiNode<E> ptr = this.head.nxt;
        int cnt = 0;

        while (ptr != this.head) {
            if (cnt == index) {
                ptr.prev.nxt = ptr.prev = new BiNode<>(data, ptr, ptr.prev);
                size++;
                return;
            }
            ptr = ptr.nxt;
            cnt++;
        }
    }

    public List<E> getAll() {
        List<E> result = new ArrayList<>();

        BiNode<E> ptr = head.nxt;
        while (ptr != this.head) {
            result.add(ptr.data);
            ptr = ptr.nxt;
        }

        return result;
    }

    public void removeFirst() {
        if (isEmpty()) return;

        BiNode<E> ptr = this.head.nxt;
        ptr.prev.nxt = ptr.nxt;
        ptr.nxt.prev = ptr.prev;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) return;

        BiNode<E> tail = this.head.prev;
        tail.prev.nxt = tail.nxt;
        tail.nxt.prev = tail.prev;
        size--;
    }

    public void remove(int index) {
        if (isEmpty() || index < 0 || index >= this.size) return;

        BiNode<E> ptr = this.head.nxt;
        int cnt = 0;

        while (ptr != this.head) {
            if (cnt == index) {
                ptr.prev.nxt = ptr.nxt;
                ptr.nxt.prev = ptr.prev;
                size--;
                return;
            }
            ptr = ptr.nxt;
            cnt++;
        }
    }

    public void clear() {
        if (isEmpty()) return;

        BiNode<E> ptr = this.head.nxt;
        while (ptr != this.head) {
            removeFirst();
            ptr = ptr.nxt;
        }
    }

    private boolean isEmpty() {
        return head.nxt == null;
    }
}
