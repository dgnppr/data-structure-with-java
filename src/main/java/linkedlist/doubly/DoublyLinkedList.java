package linkedlist.doubly;

import linkedlist.LinkedList;

import java.util.*;

public class DoublyLinkedList<E, K extends BiNode<E>, L extends DoublyLinkedList> extends LinkedList<E, K, L> {

    public BiNode<E> head;
    public BiNode<E> tail;

    @Override
    public void addAtFirst(E data) {
        if (isEmpty()) {
            this.head = this.tail = new BiNode<>(data, null, null);
        } else {
            this.head = new BiNode<>(data, this.head, null);
        }
        size++;
    }

    @Override
    public void addAtLast(E data) {
        if (isEmpty()) {
            addAtFirst(data);
        } else {
            if (this.tail != null) {
                BiNode<E> node = new BiNode<>(data, null, this.tail);
                this.tail.nxt = node;
                this.tail = node;
            }
            size++;
        }
    }

    @Override
    public void addAtFirst(K node) {
        if (isEmpty()) {
            this.head = this.tail = node;
        } else {
            node.nxt = this.head;
            this.head.prev = node;
            this.head = node;
        }
        size++;
    }

    @Override
    public void addAtLast(K node) {
        if (isEmpty()) {
            addAtFirst(node);
        } else {
            this.tail.nxt = node;
            node.prev = this.tail;
            tail = node;
            size++;
        }
    }

    @Override
    public void addAt(int idx, E data) {

        if (idx < 0 || idx > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (isEmpty() || idx == 0) {
            addAtFirst(data);
        } else if (idx == size - 1) {
            addAtLast(data);
        } else {
            int cnt = 0;
            BiNode<E> cur = this.head;
            BiNode<E> pre = this.head;
            while (cur != null) {
                if (cnt == idx) {
                    BiNode<E> node = new BiNode<>(data);
                    pre.nxt = node;
                    node.prev = pre;
                    cur.prev = node;
                    node.nxt = cur;
                    size++;
                    return;
                }

                pre = cur;
                cur = cur.nxt;
                cnt++;
            }
        }

    }

    @Override
    public void addAt(int idx, K node) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (isEmpty() || idx == 0) {
            addAtFirst(node);
        } else if (idx == size - 1) {
            addAtLast(node);
        } else {
            int cnt = 0;
            BiNode<E> cur = this.head;
            BiNode<E> pre = this.head;
            while (cur != null) {
                if (cnt == idx) {
                    pre.nxt = node;
                    node.prev = pre;
                    cur.prev = node;
                    node.nxt = cur;
                    size++;
                    return;
                }

                pre = cur;
                cur = cur.nxt;
                cnt++;
            }
        }
    }

    @Override
    public void append(L other) {

        if (isEmpty()) {
            this.head = this.tail = other.head;
        } else {
            this.tail.nxt = other.head;
            other.head.prev = this.tail;
            this.tail = other.tail;
        }

        this.size += other.size;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        if (isHeadOnly()) {
            head = tail = null;
        } else {
            BiNode<E> ptr = this.head;
            head = ptr.nxt;
            ptr.prev = null;
        }

        size--;
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        if (isHeadOnly()) {
            removeFirst();
        } else {
            this.tail = this.tail.prev;
            this.tail.nxt = null;
            size--;
        }
    }

    @Override
    public void removeMiddle() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
        }

        removeAt(this.size / 2);
    }

    @Override
    public void removeAt(int idx) {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        if (idx < 0 || idx > this.size) {
            System.out.println("Invalid Index");
            return;
        }

        if (idx == 0) {
            removeFirst();
        } else if (idx == this.size - 1) {
            removeLast();
        } else {
            int cnt = 0;
            BiNode<E> cur = this.head;
            BiNode<E> pre = this.head;
            while (cur != null) {
                if (cnt == idx) {
                    pre.nxt = cur.nxt;
                    if (cur.nxt != null) cur.nxt.prev = pre;
                    size--;
                    return;
                }
                pre = cur;
                cur = cur.nxt;
                cnt++;
            }
        }
    }

    @Override
    public void remove(K p) {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        if (head == p) {
            removeFirst();
        } else if (tail == p) {
            removeLast();
        } else {
            BiNode<E> cur = head;

            while (cur.nxt != p) {
                cur = cur.nxt;
                if (cur == null) {
                    return;
                }
            }

            cur.nxt = cur.nxt.nxt;
            cur.nxt.prev = cur;
            size--;
        }
    }

    @Override
    public void removeIfDataIsEven() {

        if (!(head.data instanceof Integer)) {
            System.out.println("Not valid Generic");
            return;
        }

        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        BiNode<E> cur = head;
        BiNode<E> pre = null;

        while (cur != null) {
            if ((Integer) cur.data % 2 == 0) {
                if (pre == null) {
                    if (cur.nxt != null) {
                        head = cur.nxt;
                        head.prev = null;
                    } else {
                        head = tail = null;
                    }
                } else {
                    pre.nxt = cur.nxt;
                    if (cur.nxt != null) {
                        cur.nxt.prev = pre;
                    } else {
                        tail = pre;
                    }
                }
                size--;
            } else {
                pre = cur;
            }
            cur = cur.nxt;
        }
    }

    @Override
    public void clear() {

        BiNode<E> ptr = this.head;

        while (ptr != null) {
            removeFirst();
            ptr = ptr.nxt;
        }

    }

    @Override
    public boolean contains(E data, Comparator<? super E> c) {
        if (isEmpty()) return false;

        BiNode<E> ptr = this.head;

        while (ptr != null) {
            if (c.compare(ptr.data, data) == 0) {
                return true;
            }
            ptr = ptr.nxt;
        }

        return false;
    }

    @Override
    public E getAt(int index) {
        if (isEmpty() || index < 0 || index >= this.size) return null;

        BiNode<E> ptr = this.head;
        int cnt = 0;

        while (ptr != null) {
            if (cnt == index) {
                return ptr.data;
            }
            ptr = ptr.nxt;
            cnt++;
        }

        return null;
    }

    @Override
    public E getAtFromBack(int index) {
        if (isEmpty() || index < 0 || index >= size) return null;
        return getAt(size - index - 1);
    }

    @Override
    public E getMiddle() {
        if (isEmpty()) return null;
        else return getAt(size / 2);
    }

    @Override
    public List<E> getAll() {
        BiNode<E> ptr = this.head;
        List<E> rst = new ArrayList<>();

        while (ptr != null) {
            rst.add(ptr.data);
            ptr = ptr.nxt;
        }

        return rst;
    }

    @Override
    public E getStartInCycle() {
        if (isEmpty() || isHeadOnly()) return null;

        BiNode<E> fast = this.head;
        BiNode<E> slow = this.head;

        while (fast != null && fast.nxt != null) {
            fast = fast.nxt.nxt;
            slow = slow.nxt;

            if (fast == slow) {
                break;
            }
        }

        slow = this.head;

        while (slow != fast) {
            slow = slow.nxt;
            fast = fast.nxt;
        }

        return slow.data;
    }

    @Override
    public E getIntersection(L other) {

        int dist = this.size - other.size;

        BiNode<E> ptr1 = this.head;
        BiNode<E> ptr2 = other.head;

        if (dist > 0) {
            int cnt = dist;
            while (cnt-- > 0) {
                ptr1 = ptr1.nxt;
            }
        } else if (dist < 0) {
            int cnt = -dist;
            while (cnt-- > 0) {
                ptr2 = ptr2.nxt;
            }
        }

        while (ptr1 != ptr2) {
            ptr1 = ptr1.nxt;
            ptr2 = ptr2.nxt;
        }

        return ptr1.data;
    }

    @Override
    public void reverse() {
        if (isEmpty() || isHeadOnly()) return;

        BiNode<E> cur = this.head;
        BiNode<E> pre = null;

        while (cur != null) {
            BiNode<E> nxt = cur.nxt;

            if (pre == null) tail = cur;
            cur.nxt = pre;
            cur.prev = nxt;

            if (nxt == null) head = cur;
            pre = cur;
            cur = nxt;
        }
    }

    @Override
    public void deduplicate() {
        if (isEmpty() || isHeadOnly()) return;
        Set<E> vis = new HashSet<>();

        BiNode<E> ptr = this.head;

        while (ptr != null) {
            if (vis.contains(ptr.data)) {
                if (ptr == tail) {
                    removeLast();
                } else {
                    ptr.prev.nxt = ptr.nxt;
                    ptr.nxt.prev = ptr.prev;
                    size--;
                }
            } else {
                vis.add(ptr.data);
            }

            ptr = ptr.nxt;
        }
    }

    @Override
    public boolean isPalindrome(Comparator<? super E> c) {
        if (isEmpty()) return false;

        if (isHeadOnly()) return true;

        int cnt = 0;
        BiNode<E> ptr = this.head;

        while (ptr != null) {
            if (cnt++ == this.size / 2) {
                break;
            }
            ptr = ptr.nxt;
        }

        BiNode<E> ptr1 = this.head;
        BiNode<E> ptr2 = reverse((K) ptr);

        while (ptr1 != null && ptr2 != null) {
            if (c.compare(ptr1.data, ptr2.data) != 0) return false;
            ptr1 = ptr1.nxt;
            ptr2 = ptr2.nxt;
        }

        return true;
    }

    @Override
    public L sum(K p) {
        if (!(this.head.data instanceof Integer) || !(p.data instanceof Integer)) return null;

        DoublyLinkedList<Integer, BiNode<Integer>, L> result = new DoublyLinkedList<>();

        BiNode<E> ptr1 = this.head;
        BiNode<E> ptr2 = p;

        int extra = 0;
        while (ptr1 != null && ptr2 != null) {
            int sum = (Integer) ptr1.data + (Integer) ptr2.data + extra;
            result.addAtLast(sum % 10);
            extra = sum / 10;
            ptr1 = ptr1.nxt;
            ptr2 = ptr2.nxt;
        }

        while (ptr1 != null) {
            int sum = (Integer) ptr1.data + extra;
            result.addAtLast(sum % 10);
            extra = sum / 10;
            ptr1 = ptr1.nxt;
        }

        while (ptr2 != null) {
            int sum = (Integer) ptr2.data + extra;
            result.addAtLast(sum % 10);
            extra = sum / 10;
            ptr2 = ptr2.nxt;
        }

        return (L) result;
    }

    @Override
    public K reverse(K node) {

        BiNode<E> cur = node;
        BiNode<E> pre = null;

        while (cur != null) {
            BiNode<E> nxt = cur.nxt;

            cur.nxt = pre;
            cur.prev = nxt;

            pre = cur;
            cur = nxt;
        }

        return (K) pre;
    }

    @Override
    public void dump() {
        BiNode<E> ptr = this.head;

        StringBuilder sb = new StringBuilder();
        while (ptr != null) {
            sb.append(ptr.data).append(" ");
            ptr = ptr.nxt;
        }
        System.out.println(sb);
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean isHeadOnly() {
        return this.head.nxt == null;
    }

    @Override
    public E getHead() {
        return this.head.data;
    }

    @Override
    public E getTail() {
        return this.tail.data;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
