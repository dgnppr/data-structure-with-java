package linkedlist.doubly;

import linkedlist.BiNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class DoublyLinkedListTest {

    DoublyLinkedList<Integer, BiNode<Integer>, DoublyLinkedList> linkedList;
    Comparator<Integer> c = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

    @BeforeEach
    void setUp() {
        linkedList = new DoublyLinkedList<>();
    }

    private void init() {
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
        init();

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
        linkedList.addAtFirst(new BiNode<>(10));
        linkedList.addAtFirst(new BiNode<>(9));
        linkedList.addAtFirst(new BiNode<>(8));
        linkedList.addAtFirst(new BiNode<>(7));
        linkedList.addAtFirst(new BiNode<>(6));
        linkedList.addAtFirst(new BiNode<>(5));
        linkedList.addAtFirst(new BiNode<>(4));
        linkedList.addAtFirst(new BiNode<>(3));
        linkedList.addAtFirst(new BiNode<>(2));
        linkedList.addAtFirst(new BiNode<>(1));

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
        linkedList.addAtLast(new BiNode<>(1));
        linkedList.addAtLast(new BiNode<>(2));
        linkedList.addAtLast(new BiNode<>(3));
        linkedList.addAtLast(new BiNode<>(4));
        linkedList.addAtLast(new BiNode<>(5));
        linkedList.addAtLast(new BiNode<>(6));
        linkedList.addAtLast(new BiNode<>(7));
        linkedList.addAtLast(new BiNode<>(8));
        linkedList.addAtLast(new BiNode<>(9));
        linkedList.addAtLast(new BiNode<>(10));

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
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(6);
        linkedList.addAtLast(7);
        linkedList.addAtLast(8);
        linkedList.addAtLast(9);
        linkedList.addAtLast(10);

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
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(6);
        linkedList.addAtLast(7);
        linkedList.addAtLast(8);
        linkedList.addAtLast(9);
        linkedList.addAtLast(10);

        linkedList.addAt(4, new BiNode<>(5));

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(10);
    }

    @Test
    void append() {

        init();
        DoublyLinkedList<Integer, BiNode<Integer>, DoublyLinkedList> other = new DoublyLinkedList();

        other.addAtLast(11);
        other.addAtLast(12);
        other.addAtLast(13);
        other.addAtLast(14);
        other.addAtLast(15);

        linkedList.append(other);

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(15);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(15);
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
    void removeMiddle() {
        init();
        linkedList.removeMiddle();
        Assertions.assertThat(linkedList.getAll()).doesNotContain(6);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeLast() {
        init();
        linkedList.removeLast();

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }

        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(9);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeAt() {
        init();
        linkedList.removeAt(5);
        Assertions.assertThat(linkedList.getAll()).doesNotContain(6);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void remove() {
        BiNode<Integer> node = new BiNode<>(5);

        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(node);
        linkedList.addAtLast(6);
        linkedList.addAtLast(7);
        linkedList.addAtLast(8);
        linkedList.addAtLast(9);
        linkedList.addAtLast(10);

        linkedList.remove(node);

        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(10);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(9);
    }

    @Test
    void removeIfDataIsEven() {
        init();

        linkedList.removeIfDataIsEven();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(5);
        Assertions.assertThat(linkedList.getHead()).isEqualTo(1);
        Assertions.assertThat(linkedList.getTail()).isEqualTo(9);
        Assertions.assertThat(linkedList.getSize()).isEqualTo(5);
    }

    @Test
    void clear() {
        init();
        linkedList.clear();
        Assertions.assertThat(linkedList.getAll()).isEmpty();
        Assertions.assertThat(linkedList.isEmpty()).isTrue();
        Assertions.assertThat(linkedList.getSize()).isZero();
    }

    @Test
    void contains() {
        init();

        Assertions.assertThat(linkedList.contains(0, c)).isFalse();
        Assertions.assertThat(linkedList.contains(5, c)).isTrue();
        Assertions.assertThat(linkedList.contains(10, c)).isTrue();
        Assertions.assertThat(linkedList.contains(11, c)).isFalse();
    }

    @Test
    void getAt() {
        init();
        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(5)).isEqualTo(6);
        Assertions.assertThat(linkedList.getAt(9)).isEqualTo(10);
        Assertions.assertThat(linkedList.getAt(10)).isNull();
    }

    @Test
    void getAtFromBack() {
        init();
        Assertions.assertThat(linkedList.getAtFromBack(0)).isEqualTo(10);
        Assertions.assertThat(linkedList.getAtFromBack(5)).isEqualTo(5);
        Assertions.assertThat(linkedList.getAtFromBack(9)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAtFromBack(10)).isNull();
    }

    @Test
    void getMiddle() {
        init();
        Assertions.assertThat(linkedList.getMiddle()).isEqualTo(6);
    }

    @Test
    void getStartInCycle() {
    }

    @Test
    void getIntersection() {
        init();

        DoublyLinkedList<Integer, BiNode<Integer>, DoublyLinkedList> list1 = new DoublyLinkedList();
        DoublyLinkedList<Integer, BiNode<Integer>, DoublyLinkedList> list2 = new DoublyLinkedList();

        list1.addAtLast(12);
        list1.addAtLast(5);
        list1.addAtLast(4);
        list1.addAtLast(3);

        list2.addAtLast(7);
        list2.addAtLast(8);
        list2.addAtLast(9);


        list1.addAtLast(linkedList.head);
        list2.addAtLast(linkedList.head);

        Assertions.assertThat(list1.getIntersection(list2)).isEqualTo(1);
    }

    @Test
    void reverse() {
    }

    @Test
    void deduplicate() {
    }

    @Test
    void isPalindrome() {
    }

    @Test
    void sum() {
    }

    @Test
    void testReverse() {
    }

    @Test
    void dump() {
    }
}