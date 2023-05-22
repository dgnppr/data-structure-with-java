package linkedlist;

import java.util.Comparator;
import java.util.List;

public abstract class LinkedList<E> {

    public Node<E> head;
    public Node<E> tail;
    public int size;

    // 삽입

    public abstract void addAtFirst(E data);

    public abstract void addAtFirst(Node<E> data);

    public abstract void addAtLast(E data);

    public abstract void addAtLast(Node<E> data);

    public abstract void addAt(int idx, E data);

    public abstract void addAt(int idx, Node<E> data);

    // 삭제

    public abstract void removeFirst();

    public abstract void removeMiddle();

    public abstract void removeLast();

    public abstract void removeAt(int idx);

    public abstract void remove(Node<E> p);

    public abstract void removeIfDataIsEven();

    public abstract void clear();

    // 조회

    public abstract boolean contains(E data, Comparator<? super E> c);

    public abstract E getAt(int index);

    public abstract E getAtFromBack(int index);

    public abstract E getMiddle();

    public abstract Node<E> newReversedList();

    public abstract List<E> getAll();

    public abstract E getStartInCycle();

    public abstract E getIntersection(LinkedList<E> other);

    // 수정

    public abstract Node<E> reverse(Node<E> head);

    public abstract void purge(E data, Comparator<? super E> comparator);

    public abstract void deduplicate();

    // 문제

    public abstract boolean isPalindrome(Comparator<? super E> c);

    public abstract Node<Integer> sum(Node<Integer> p);


    // 출력

    public abstract void dump();


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
