package linkedlist.singly;

import linkedlist.LinkedList;

import java.util.*;

public class SinglyLinkedList<E, K extends Node<E>, L extends SinglyLinkedList> extends LinkedList<E, K, L> {

    @Override
    public void addAtFirst(E data) {
        head = new Node<>(data, head);
        if (tail == null) tail = head;
        size++;
    }

    @Override
    public void addAtLast(E data) {
        if (isEmpty()) {
            addAtFirst(data);
            return;
        } else {
            Node<E> ptr = head;
            while (ptr.nxt != null) {
                ptr = ptr.nxt;
            }
            ptr.nxt = new Node<>(data, null);
            tail = ptr.nxt;
        }
        size++;
    }

    @Override
    public void addAtFirst(K node) {
        node.nxt = head;
        if (tail == null) tail = node;
        head = node;
        size++;
    }

    @Override
    public void addAtLast(K node) {
        if (isEmpty()) {
            addAtFirst(node);
            return;
        } else {
            Node<E> ptr = head;
            while (ptr.nxt != null) {
                ptr = ptr.nxt;
            }
            ptr.nxt = node;
            tail = node;
        }
        size++;
    }

    @Override
    public void addAt(int idx, E data) {

        if (idx < 0 || idx > size) {
            System.out.println("Out of index");
            return;
        }

        if (idx == 0) {
            addAtFirst(data);
        } else if (idx == size) {
            addAtLast(data);
        } else {

            int cnt = 0;

            Node<E> cur = head;
            Node<E> pre = head;

            while (cur != null) {
                if (cnt == idx) {
                    pre.nxt = new Node<>(data, cur);
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
            System.out.println("Out of index");
            return;
        }

        if (idx == 0) {
            addAtFirst(node);
        } else if (idx == size) {
            addAtLast(node);
        } else {

            int cnt = 0;

            Node<E> cur = head;
            Node<E> pre = head;

            while (cur != null) {
                if (cnt == idx) {
                    pre.nxt = node;
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
        if (isEmpty() || other.isEmpty()) return;
        this.tail.nxt = other.head;
        this.tail = other.tail;
        this.size += other.getSize();
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        if (isHeadOnly()) tail = null;
        head = head.nxt;
        size--;
    }

    @Override
    public void removeMiddle() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
        }

        removeAt(size / 2);
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

            Node<E> ptr = head;
            while (ptr.nxt != tail) {
                ptr = ptr.nxt;
            }

            ptr.nxt = null;
            tail = ptr;
            size--;
        }

    }

    @Override
    public void removeAt(int idx) {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            int cnt = 0;

            Node<E> cur = head;
            Node<E> pre = head;

            while (cur != null) {

                if (cnt == idx) {
                    pre.nxt = cur.nxt;
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
            Node<E> ptr = head;

            while (ptr.nxt != p) {
                ptr = ptr.nxt;
                if (ptr.nxt == null) {
                    return;
                }
            }

            ptr.nxt = p.nxt;
            size--;
        }
    }

    @Override
    public void removeIfDataIsEven() {

        if (isEmpty() || !(head.data instanceof Integer)) return;

        Node<E> ptr = head;
        Node<E> pre = null;

        while (ptr != null) {
            if ((Integer) ptr.data % 2 == 0) {
                if (pre == null) {
                    head = ptr.nxt;
                    if (ptr == tail) tail = null;
                } else {
                    pre.nxt = ptr.nxt;
                    if (ptr == tail) tail = pre;
                }
                size--;
            } else {
                pre = ptr;
            }
            ptr = ptr.nxt;
        }
    }

    @Override
    public void clear() {

        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node<E> ptr = head;
        while (ptr != null) {
            removeFirst();
            ptr = ptr.nxt;
        }
    }

    @Override
    public boolean contains(E data, Comparator<? super E> c) {

        Node<E> ptr = head;

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
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return null;
        } else if (index < 0 || index > size) {
            System.out.println("Out of index");
            return null;
        }

        if (index == 0) {
            return head.data;
        } else if (index == size - 1) {
            return tail.data;
        } else {
            int cnt = 0;
            Node<E> ptr = head;
            while (ptr != null) {
                if (cnt == index) {
                    return ptr.data;
                }

                ptr = ptr.nxt;
                cnt++;
            }
        }

        return null;
    }

    @Override
    public E getAtFromBack(int index) {
        return getAt(size - index - 1);
    }

    @Override
    public E getMiddle() {
        return getAt(size / 2);
    }

    @Override
    public List<E> getAll() {

        if (isEmpty()) {
            return new ArrayList<>();
        }

        List<E> rst = new ArrayList<>();
        Node<E> ptr = head;

        while (ptr != null) {
            rst.add(ptr.data);
            ptr = ptr.nxt;
        }

        return rst;
    }

    @Override
    public E getStartInCycle() {
        if (isEmpty() || isHeadOnly()) return null;

        Node<E> slow = this.head;
        Node<E> fast = this.head.nxt;

        while (slow != fast) {
            if (fast == null || fast.nxt == null) return null;
            slow = slow.nxt;
            fast = fast.nxt.nxt;
        }

        slow = head;
        while (slow != fast.nxt) {
            slow = slow.nxt;
            fast = fast.nxt;
        }

        return slow.data;
    }

    @Override
    public E getIntersection(L other) {
        if (this.isEmpty() || other.isEmpty() || this.tail != other.tail) return null;

        int thisSize = this.size;
        int otherSize = other.size;

        Node<E> shorter = (thisSize < otherSize) ? this.head : other.head;
        Node<E> longer = (thisSize < otherSize) ? other.head : this.head;

        int cnt = 0;
        while (cnt != Math.abs(thisSize - otherSize)) {
            longer = longer.nxt;
            cnt++;
        }

        while (longer != shorter) {
            shorter = shorter.nxt;
            longer = longer.nxt;
        }

        return longer.data;
    }

    @Override
    public void reverse() {

        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        Node<E> cur = head;
        Node<E> pre = null;

        while (cur != null) {
            Node<E> nxt = cur.nxt;

            cur.nxt = pre;
            if (pre == null) {
                pre = cur;
                tail = pre;
            }

            pre = cur;
            cur = nxt;

            if (nxt == null) {
                head = pre;
                return;
            }
        }

    }

    @Override
    public void deduplicate() {
        if (isEmpty() || isHeadOnly()) return;

        Set<E> vis = new HashSet<>();
        Node<E> cur = head;
        Node<E> pre = null;

        while (cur != null) {
            if (!vis.contains(cur.data)) {
                vis.add(cur.data);
                pre = cur;
            } else {
                pre.nxt = cur.nxt;
                size--;
                if (cur == tail) tail = pre;
            }
            cur = cur.nxt;
        }
    }

    @Override
    public boolean isPalindrome(Comparator<? super E> c) {
        if (isEmpty()) return false;
        if (isHeadOnly()) return true;

        Node<E> cur = head;
        int cnt = 0;
        while (cur != null) {
            if (cnt == size / 2) {
                break;
            }
            cnt++;
            cur = cur.nxt;
        }

        Node<E> list1 = head;
        Node<E> list2 = reverse((K) cur);

        while (list1 != null && list2 != null) {
            if (c.compare(list1.data, list2.data) != 0) return false;
            list1 = list1.nxt;
            list2 = list2.nxt;
        }

        return true;

    }


    @Override
    public K reverse(K node) {
        Node<E> cur = node;
        Node<E> pre = null;

        while (cur != null) {
            Node<E> nxt = cur.nxt;
            cur.nxt = pre;
            pre = cur;
            cur = nxt;
        }

        return (K) pre;

    }

    @Override
    public L sum(K p) {
        return null;
    }

    @Override
    public void dump() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        Node<E> ptr = head;
        StringBuilder rst = new StringBuilder();
        while (ptr != null) {
            rst.append(ptr.data).append(" ");
            ptr = ptr.nxt;
        }

        System.out.println(rst);
    }
}
