package linkedlist.doubly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularDoublyLinkedListTest {
    CircularDoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new CircularDoublyLinkedList<>();
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

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    void addAtLast() {
        init();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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

        linkedList.addAt(5, 4);

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    void removeFirst() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);

        linkedList.removeFirst();
        linkedList.removeFirst();

        Assertions.assertThat(linkedList.getAll()).containsOnly(3);
    }

    @Test
    void removeLast() {
        init();

        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void remove() {
        init();

        linkedList.remove(9);
        linkedList.remove(8);
        linkedList.remove(0);

        Assertions.assertThat(linkedList.getAll()).containsSequence(2, 3, 4, 5, 6, 7, 8);
        Assertions.assertThat(linkedList.getAll()).containsOnly(2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    void getAt() {
        init();

        Assertions.assertThat(linkedList.getAt(0)).isEqualTo(1);
        Assertions.assertThat(linkedList.getAt(9)).isEqualTo(10);
    }

    @Test
    void contains() {
        init();

        Assertions.assertThat(linkedList.contains(0, Integer::compareTo)).isFalse();
        Assertions.assertThat(linkedList.contains(1, Integer::compareTo)).isTrue();
    }

    @Test
    void getMiddle() {
        init();

        Assertions.assertThat(linkedList.getMiddle()).isEqualTo(6);
    }

    @Test
    void removeIfDataIsEven() {
        init();

        linkedList.removeIfDataIsEven();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 3, 5, 7, 9);
    }

    @Test
    void reverse() {
        init();

        linkedList.reverse();

        Assertions.assertThat(linkedList.getAll()).containsSequence(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        Assertions.assertThat(linkedList.getAll()).containsOnly(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
    }

    @Test
    void deduplicate() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(1);
        linkedList.addAtLast(1);
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(2);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);
        linkedList.addAtLast(4);
        linkedList.addAtLast(4);
        linkedList.addAtLast(5);
        linkedList.addAtLast(4);

        linkedList.deduplicate();

        Assertions.assertThat(linkedList.getAll()).containsSequence(1, 2, 3, 4, 5);
        Assertions.assertThat(linkedList.getAll()).containsOnly(1, 2, 3, 4, 5);

    }

    @Test
    void clear() {
        init();

        linkedList.clear();

        Assertions.assertThat(linkedList.getAll()).isEmpty();
    }
}