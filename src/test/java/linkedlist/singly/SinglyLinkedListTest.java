package linkedlist.singly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

    SinglyLinkedList<Integer, Node<Integer>, SinglyLinkedList> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new SinglyLinkedList<>();
    }

    private void init() {
        linkedList.addAtLast(new Node<>(1));
        linkedList.addAtLast(new Node<>(2));
        linkedList.addAtLast(new Node<>(3));
        linkedList.addAtLast(new Node<>(4));
        linkedList.addAtLast(new Node<>(5));
        linkedList.addAtLast(new Node<>(6));
        linkedList.addAtLast(new Node<>(7));
        linkedList.addAtLast(new Node<>(8));
        linkedList.addAtLast(new Node<>(9));
        linkedList.addAtLast(new Node<>(10));
    }

    @Test
    void addAtFirst() {

        linkedList.addAtFirst(10);
        linkedList.addAtFirst(9);
        linkedList.addAtFirst(8);
        linkedList.addAtFirst(7);
        linkedList.addAtFirst(6);
        linkedList.addAtFirst(5);
        linkedList.addAtFirst(4);
        linkedList.addAtFirst(3);
        linkedList.addAtFirst(2);
        linkedList.addAtFirst(1);

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void addAtLast() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(5);
        linkedList.addAtLast(6);
        linkedList.addAtLast(7);
        linkedList.addAtLast(8);
        linkedList.addAtLast(9);
        linkedList.addAtLast(10);


        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void addNodeAtFirst() {
        linkedList.addAtFirst(new Node<>(10));
        linkedList.addAtFirst(new Node<>(9));
        linkedList.addAtFirst(new Node<>(8));
        linkedList.addAtFirst(new Node<>(7));
        linkedList.addAtFirst(new Node<>(6));
        linkedList.addAtFirst(new Node<>(5));
        linkedList.addAtFirst(new Node<>(4));
        linkedList.addAtFirst(new Node<>(3));
        linkedList.addAtFirst(new Node<>(2));
        linkedList.addAtFirst(new Node<>(1));

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void addNodeAtLast() {
        linkedList.addAtLast(new Node<>(1));
        linkedList.addAtLast(new Node<>(2));
        linkedList.addAtLast(new Node<>(3));
        linkedList.addAtLast(new Node<>(4));
        linkedList.addAtLast(new Node<>(5));
        linkedList.addAtLast(new Node<>(6));
        linkedList.addAtLast(new Node<>(7));
        linkedList.addAtLast(new Node<>(8));
        linkedList.addAtLast(new Node<>(9));
        linkedList.addAtLast(new Node<>(10));

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void addAt() {
        linkedList.addAtLast(new Node<>(1));
        linkedList.addAtLast(new Node<>(2));
        linkedList.addAtLast(new Node<>(3));
        linkedList.addAtLast(new Node<>(4));
        linkedList.addAtLast(new Node<>(6));
        linkedList.addAtLast(new Node<>(7));
        linkedList.addAtLast(new Node<>(8));
        linkedList.addAtLast(new Node<>(9));
        linkedList.addAtLast(new Node<>(10));

        linkedList.addAt(4, 5);

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void addNodeAt() {
        linkedList.addAtLast(new Node<>(1));
        linkedList.addAtLast(new Node<>(2));
        linkedList.addAtLast(new Node<>(3));
        linkedList.addAtLast(new Node<>(4));
        linkedList.addAtLast(new Node<>(6));
        linkedList.addAtLast(new Node<>(7));
        linkedList.addAtLast(new Node<>(8));
        linkedList.addAtLast(new Node<>(9));
        linkedList.addAtLast(new Node<>(10));

        linkedList.addAt(4, new Node<>(5));

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void removeFirst() {
        init();

        linkedList.removeFirst();

        Assertions.assertThat(linkedList.getAll()).containsSequence(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(2);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    @DisplayName("단일 노드로 이루어진 연결리스트 맨 앞 노드 삭제")
    void removeFirstInSingleNodeList() {
        linkedList.addAtFirst(1);

        linkedList.removeFirst();

        Assertions.assertThat(linkedList.getAll()).isEmpty();
        Assertions.assertThat(linkedList.getHead()).isNull();
        Assertions.assertThat(linkedList.getTail()).isNull();
        Assertions.assertThat(linkedList.getSize()).isEqualTo(0);
    }

    @Test
    @DisplayName("2개 노드로 이루어진 연결리스트 맨 앞 노드 삭제")
    void removeFirstInTwoNodeList() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);

        linkedList.removeFirst();

        Assertions.assertThat(linkedList.getAll()).containsOnly(2);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(2);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(2);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(1);
    }

    @Test
    void removeLast() {
        linkedList.addAtLast(1);
        linkedList.removeLast();

        Assertions.assertThat(linkedList.getAll()).isEmpty();
        Assertions.assertThat(linkedList.getHead()).isNull();
        Assertions.assertThat(linkedList.getTail()).isNull();
        Assertions.assertThat(linkedList.getSize()).isZero();
    }

    @Test
    @DisplayName("단일 노드 연결리스트 맨 뒤 노드 삭제")
    void removeLastInSingleNodeList() {
        linkedList.addAtFirst(1);

        linkedList.removeLast();

        Assertions.assertThat(linkedList.getAll()).isEmpty();
        Assertions.assertThat(linkedList.getHead()).isNull();
        Assertions.assertThat(linkedList.getTail()).isNull();
        Assertions.assertThat(linkedList.getSize()).isZero();
    }


    @Test
    @DisplayName("2개 노드 연결리스트 맨 뒤 노드 삭제")
    void removeLastInTwoNodeList() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);

        linkedList.removeLast();

        Assertions.assertThat(linkedList.getAll()).containsOnly(1);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(1);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(1);
    }

    @Test
    void removeAt() {
        init();

        linkedList.removeAt(7);

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 9, 10);
        Assertions.assertThat(linkedList.getAll()).doesNotContain(8);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeMiddle() {
        init();

        linkedList.removeMiddle();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).doesNotContain(6);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void remove() {

        Node<Integer> target = new Node<>(7);

        linkedList.addAtLast(new Node<>(1));
        linkedList.addAtLast(new Node<>(2));
        linkedList.addAtLast(new Node<>(3));
        linkedList.addAtLast(new Node<>(4));
        linkedList.addAtLast(new Node<>(5));
        linkedList.addAtLast(new Node<>(6));
        linkedList.addAtLast(target);
        linkedList.addAtLast(new Node<>(8));
        linkedList.addAtLast(new Node<>(9));
        linkedList.addAtLast(new Node<>(10));

        linkedList.remove(target);

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).doesNotContain(7);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeHead() {

        Node<Integer> head = new Node<>(1);
        linkedList.addAtLast(head);

        linkedList.remove(head);

        Assertions.assertThat(linkedList.getAll()).isEmpty();
        Assertions.assertThat(linkedList.getHead()).isNull();
        Assertions.assertThat(linkedList.getTail()).isNull();
        Assertions.assertThat(linkedList.getSize()).isZero();
    }

    @Test
    void removeTail() {

        init();

        Node<Integer> tail = new Node<>(11);
        linkedList.addAtLast(tail);

        linkedList.remove(tail);

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void removeIfDataIsEven() {
        init();

        linkedList.removeIfDataIsEven();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 3, 5, 7, 9);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 3, 5, 7, 9);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(9);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(5);

    }

    @Test
    void clear() {
        init();

        linkedList.clear();

        Assertions.assertThat(linkedList.getAll()).isEmpty();
    }

    @Test
    void contains() {
        init();

        Assertions.assertThat(linkedList.contains(5, Integer::compareTo)).isTrue();
        Assertions.assertThat(linkedList.contains(20, Integer::compareTo)).isFalse();
    }

    @Test
    void getAt() {
        init();

        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(5)).isEqualTo(6);
    }

    @Test
    void getAtFromBack() {
        init();

        Assertions.assertThat(linkedList.getAtFromBack(0)).isEqualTo(10);
        Assertions.assertThat(linkedList.getAtFromBack(1)).isEqualTo(9);
    }

    @Test
    void getMiddle() {
        init();

        Assertions.assertThat(linkedList.getMiddle()).isEqualTo(6);
    }

    @Test
    void getStartInCycle() {
        Node<Integer> node = new Node<>(5);

        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(node);
        linkedList.addAtLast(6);
        linkedList.addAtLast(7);
        linkedList.addAtLast(8);
        linkedList.addAtLast(9);
        linkedList.addAtLast(new Node<>(10, node));

        Assertions.assertThat(linkedList.getStartInCycle()).isEqualTo(5);
    }

    @Test
    void getIntersection() {
        init();

        SinglyLinkedList<Integer, Node<Integer>, SinglyLinkedList> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer, Node<Integer>, SinglyLinkedList> list2 = new SinglyLinkedList<>();

        list1.addAtLast(11);
        list1.addAtLast(12);
        list1.addAtLast(13);
        list1.addAtLast(14);
        list1.addAtLast(15);
        list1.append(this.linkedList);

        list2.addAtLast(16);
        list2.addAtLast(17);
        list2.addAtLast(18);
        list2.addAtLast(19);
        list2.addAtLast(20);
        list2.addAtLast(21);
        list2.addAtLast(22);
        list2.append(this.linkedList);

        Assertions.assertThat(list1.getIntersection(list2)).isEqualTo(1);
    }

    @Test
    void reverse() {
        init();

        linkedList.reverse();

        Assertions.assertThat(linkedList.getAll()).containsSequence(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        Assertions.assertThat(linkedList.getAll()).containsOnly(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(10);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(1);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void deduplicate() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(2);
        linkedList.addAtLast(1);
        linkedList.addAtLast(1);
        linkedList.addAtLast(3);

        linkedList.deduplicate();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(3);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(3);
    }

    @Test
    void isPalindrome() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(3);
        linkedList.addAtLast(2);
        linkedList.addAtLast(1);

        Assertions.assertThat(linkedList.isPalindrome(Integer::compareTo)).isTrue();
    }
}