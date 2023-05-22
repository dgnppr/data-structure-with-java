package linkedlist.reference;

import java.util.Comparator;
import java.util.List;

public abstract class LinkedList<E> {

    public Node<E> head;
    public int size;

    // 삽입

    public abstract void addFirst(E obj);

    public abstract void addNodeAtFirst(Node<E> node);

    public abstract void addLast(E obj);

    public abstract void addNodeAtLast(Node<E> node);

    // 삭제

    public abstract void removeFirst();

    public abstract void removeLast();

    public abstract void remove(Node<E> node);

    public abstract void removeEvenData();

    public abstract void clear();


    // 조회

    public abstract E search(E data, Comparator<? super E> c);

    public abstract E getAt(int k);

    public abstract E getAtFromBack(int k);

    public abstract E getMiddleNodeData();

    public abstract LinkedList<E> getNewReverseLinkedList();

    public abstract List<E> getAllNodeData();

    public abstract E getFirstDataInCycle();

    public abstract Node<E> getIntersectionNode(LinkedList<E> other);

    public abstract void print();

    // 변경

    public abstract Node<E> reverseList(Node<E> head);

    public abstract void purge(E data, Comparator<? super E> c);

    public abstract void deduplicate();


    // 기타
    public abstract boolean isPalindrome(Comparator<? super E> c);

    public abstract LinkedList<Integer> sumOfIntegerLinkedList(SinglyLinkedList<Integer> list2);


    // Util

    public boolean isHeadOnly() {
        return head.nxt == null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    // Node

    public static class Node<E> {
        public final E data;
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

}

