package linkedlist.singly;

import linkedlist.Node;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void removeFirst() {

        init();

        linkedList.removeFirst();

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 2);
        }

        Assertions.assertThat(linkedList.getHead()).isEqualTo(2);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    @DisplayName("단일 노드로 이루어진 연결리스트 맨 앞 노드 삭제")
    void removeFirstInSingleNodeList() {

        linkedList.addAtFirst(1);

        linkedList.removeFirst();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).isEmpty();
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

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(1);
        Assertions.assertThat(integers.get(0)).isEqualTo(2);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(2);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(2);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(1);
    }

    @Test
    void removeLast() {
        linkedList.addAtLast(1);
        linkedList.removeLast();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).isEmpty();
        Assertions.assertThat(linkedList.getHead()).isNull();
        Assertions.assertThat(linkedList.getTail()).isNull();
        Assertions.assertThat(linkedList.getSize()).isZero();
    }

    @Test
    @DisplayName("단일 노드 연결리스트 맨 뒤 노드 삭제")
    void removeLastInSingleNodeList() {
        linkedList.addAtFirst(1);

        linkedList.removeLast();
        List<Integer> integers = linkedList.getAll();

        Assertions.assertThat(integers).isEmpty();
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

        List<Integer> integers = linkedList.getAll();

        Assertions.assertThat(integers).hasSize(1);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(1);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(1);
    }

    @Test
    void removeAt() {
        init();

        linkedList.removeAt(7);

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(9);
        Assertions.assertThat(integers).doesNotContain(8);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeMiddle() {

        init();

        linkedList.removeMiddle();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(9);
        Assertions.assertThat(integers).doesNotContain(6);
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

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(9);
        Assertions.assertThat(integers).doesNotContain(7);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeHead() {

        Node<Integer> head = new Node<>(1);
        linkedList.addAtLast(head);

        linkedList.remove(head);

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).isEmpty();
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

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(10);
        Assertions.assertThat(integers).doesNotContain(11);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void removeIfDataIsEven() {
        init();

        linkedList.removeIfDataIsEven();
        List<Integer> integers = linkedList.getAll();

        integers.stream().forEach(i -> Assertions.assertThat(i % 2 != 0).isTrue());
        Assertions.assertThat(integers).hasSize(5);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(9);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(5);

    }

    @Test
    void clear() {
        init();

        linkedList.clear();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).isEmpty();
    }

    @Test
    void contains() {
        init();

        Comparator<Integer> c = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Assertions.assertThat(linkedList.contains(5, c)).isTrue();
        Assertions.assertThat(linkedList.contains(20, c)).isFalse();
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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(10 - i);
        }

        Assertions.assertThat(linkedList.getHead()).isEqualTo(10);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(1);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void purge() {
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

        Assertions.assertThat(linkedList.isPalindrome(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        })).isTrue();
    }

    @Test
    void sum() {
    }
}