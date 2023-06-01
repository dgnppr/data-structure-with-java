package linkedlist.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ArrayLinkedListTest {

    ArrayLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new ArrayLinkedList<>(20);
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
    }

    @Test
    void addAtLast() {
        init();

        List<Integer> integers = linkedList.getAll();

        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
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
    }

    @Test
    void removeFirst() {
        init();

        linkedList.removeFirst();
        linkedList.removeFirst();
        linkedList.removeFirst();

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 4);
        }
    }

    @Test
    void removeLast() {
        init();
        linkedList.removeLast();
        linkedList.removeLast();

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < 8; i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    void removeLastWithHeadOnly() {
        linkedList.addAtLast(1);
        linkedList.removeLast();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(0);
    }

    @Test
    void removeMiddle() {
        init();
        linkedList.removeMiddle();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(9);
    }

    @Test
    void removeAt() {
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
    void getStartInCycle() {
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
}