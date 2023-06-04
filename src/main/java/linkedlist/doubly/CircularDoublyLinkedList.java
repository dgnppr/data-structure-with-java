package linkedlist.doubly;

import java.util.*;

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

    public E getAt(int index) {
        if (isEmpty() || index < 0 || index >= this.size) return null;

        BiNode<E> ptr = this.head.nxt;
        int cnt = 0;
        while (ptr != this.head) {
            if (cnt == index) {
                return ptr.data;
            }
            ptr = ptr.nxt;
            cnt++;
        }

        return null;
    }

    public E getMiddle() {
        if (isEmpty()) return null;
        return getAt(this.size / 2);
    }

    public List<E> getAll() {
        List<E> result = new ArrayList<>();

        BiNode<E> ptr = this.head.nxt;
        while (ptr != this.head) {
            result.add(ptr.data);
            ptr = ptr.nxt;
        }

        return result;
    }

    public boolean contains(E data, Comparator<? super E> c) {
        if (isEmpty()) return false;

        BiNode<E> ptr = this.head.nxt;
        while (ptr != this.head) {
            if (c.compare(ptr.data, data) == 0) return true;
            ptr = ptr.nxt;
        }
        return false;
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

        BiNode<E> ptr = this.head.prev;
        ptr.prev.nxt = ptr.nxt;
        ptr.nxt.prev = ptr.prev;
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
                this.size--;
                return;
            }
            ptr = ptr.nxt;
            cnt++;
        }
    }

    public void removeIfDataIsEven() {
        if (isEmpty() || !(this.head.nxt.data instanceof Integer)) return;

        BiNode<E> cur = this.head.nxt;
        BiNode<E> pre = null;

        while (cur != this.head) {
            if ((Integer) cur.data % 2 == 0) {
                if (pre == null) {
                    this.head.nxt = cur.nxt;
                    cur.nxt.prev = this.head;
                } else {
                    pre.nxt = cur.nxt;
                    cur.nxt.prev = pre;
                }
            } else {
                pre = cur;
            }
            cur = cur.nxt;
        }
    }

    public void reverse() {
        if (isEmpty() || isOnlyOneNode()) return;

        BiNode<E> ptr = this.head.nxt;
        BiNode<E> pre = this.head.nxt;

        while (ptr != this.head) {
            BiNode<E> nxt = ptr.nxt;
            ptr.nxt = ptr.prev;
            ptr.prev = nxt;
            if (nxt == this.head) break;
            ptr = nxt;
        }
        this.head.nxt = ptr;
        this.head.prev = pre;
    }

    public void deduplicate() {
        if (isEmpty() || isOnlyOneNode()) return;

        Set<E> vis = new HashSet<>();

        BiNode<E> ptr = this.head.nxt;
        while (ptr != this.head) {
            if (vis.contains(ptr.data)) {
                ptr.prev.nxt = ptr.nxt;
                ptr.nxt.prev = ptr.prev;
                size--;
            } else {
                vis.add(ptr.data);
            }
            ptr = ptr.nxt;
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

    private boolean isOnlyOneNode() {
        return this.head.nxt.nxt == null;
    }
}
