package linkedlist.doubly;

import linkedlist.BiNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DoublyLinkedListTest {

    DoublyLinkedList<Integer, BiNode<Integer>, DoublyLinkedList> linkedList;

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
    }

    @Test
    void removeIfDataIsEven() {
    }

    @Test
    void clear() {
    }

    @Test
    void contains() {
    }

    @Test
    void getAt() {
    }

    @Test
    void getAtFromBack() {
    }

    @Test
    void getMiddle() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getStartInCycle() {
    }

    @Test
    void getIntersection() {
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