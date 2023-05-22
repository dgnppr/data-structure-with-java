package linkedlist.reference.singly;

import linkedlist.reference.SinglyLinkedList;

public class TailSinglyLinkedList<E> extends SinglyLinkedList<E> {

    private Node<E> tail;


    /**
     * 헤드 노드 추가
     *
     * @param data
     */
    @Override
    public void addFirst(E data) {
        head = new Node<>(data, head);
        if (isHeadOnly()) tail = head;
        size++;
    }

    /**
     * 꼬리 노드 추가
     *
     * @param data
     */
    @Override
    public void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<E> ptr = head;
            while (ptr.nxt != null) {
                ptr = ptr.nxt;
            }
            ptr.nxt = new Node<>(data, null);
            tail = ptr.nxt;
            size++;
        }
    }

    /**
     * 머리 노드 삭제
     */
    public void removeFirst() {
        if (isEmpty()) return;

        if (isHeadOnly()) tail = null;
        head = head.nxt;
        size--;
    }

    /**
     * 꼬리 노드 삭제
     */
    public void removeLast() {
        if (isEmpty()) return;

        if (isHeadOnly()) {
            removeFirst();
        } else {
            Node<E> ptr = head;
            Node<E> pre = head;

            while (ptr.nxt != null) {
                pre = ptr;
                ptr = ptr.nxt;
            }

            pre.nxt = null;
            tail = pre;
            size--;
        }
    }

    /**
     * 선택 노드 삭제 메소드
     *
     * @param p: 선택 노드
     */
    public void remove(Node<E> p) {
        if (isEmpty()) {
            return;
        }

        if (p == head) {
            removeFirst();
        } else if (p == tail) {
            removeLast();
        } else {
            Node<E> ptr = head;
            while (ptr.nxt != p) {
                ptr = ptr.nxt;
                if (ptr == null) {
                    return;
                }
            }
            ptr.nxt = p.nxt;
            size--;
        }
    }

    public E getTailNodeData() {
        if (isEmpty()) return null;
        return tail.data;
    }

}
