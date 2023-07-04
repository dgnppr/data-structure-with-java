# LinkedList

### 구현

#### [Singly Linked List](./singly/SinglyLinkedList.java)

#### [Doubly Linked List](./doubly/DoublyLinkedList.java)

#### [Array Linked List](./array/ArrayLinkedList.java)

#### [Circular Doubly Linked List](./doubly/CircularDoublyLinkedList.java)

```java
public abstract class LinkedList<E, K extends Node<E>, L extends LinkedList> {

    public Node<E> head;
    public Node<E> tail;
    public int size = 0;

    // 삽입

    public abstract void addAtFirst(E data);

    public abstract void addAtFirst(K node);

    public abstract void addAtLast(E data);

    public abstract void addAtLast(K node);

    public abstract void addAt(int idx, E data);

    public abstract void addAt(int idx, K node);

    public abstract void append(L other);

    // 삭제

    public abstract void removeFirst();

    public abstract void removeMiddle();

    public abstract void removeLast();

    public abstract void removeAt(int idx);

    public abstract void remove(K p);

    public abstract void removeIfDataIsEven();

    public abstract void clear();

    // 조회

    public abstract boolean contains(E data, Comparator<? super E> c);

    public abstract E getAt(int index);

    public abstract E getAtFromBack(int index);

    public abstract E getMiddle();

    public abstract List<E> getAll();

    public abstract E getStartInCycle();

    public abstract E getIntersection(L other);

    // 수정

    public abstract void reverse();

    public abstract void deduplicate();

    // 문제

    public abstract boolean isPalindrome(Comparator<? super E> c);

    public abstract L sum(K p);

    public abstract K reverse(K node);


    // 출력

    public abstract void dump();

    // Util

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isHeadOnly() {
        return head.nxt == null;
    }

    public E getHead() {
        return (head == null) ? null : head.data;
    }

    public E getTail() {
        return (tail == null) ? null : tail.data;
    }

    public int getSize() {
        return size;
    }

}

```

