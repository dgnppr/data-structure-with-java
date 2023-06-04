package linkedlist.doubly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class CircularDoublyLinkedListTest {
    CircularDoublyLinkedList<Integer> linkedList;
    Comparator<Integer> c = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

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

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(10);
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    void addAtLast() {
        init();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(10);
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

        linkedList.addAt(5, 4);

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(10);
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    void removeFirst() {
        linkedList.addAtLast(1);
        linkedList.addAtLast(2);
        linkedList.addAtLast(3);

        linkedList.removeFirst();
        linkedList.removeFirst();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(1);
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 3);
        }
    }

    @Test
    void removeLast() {
        init();

        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeLast();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(7);
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    void remove() {
        init();

        linkedList.remove(9);
        linkedList.remove(8);
        linkedList.remove(0);

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(7);
        Assertions.assertThat(integers).doesNotContain(1, 9, 10);
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
        Assertions.assertThat(linkedList.contains(0, c)).isFalse();
        Assertions.assertThat(linkedList.contains(1, c)).isTrue();
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
        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i) % 2 != 0).isTrue();
        }
    }

    @Test
    void reverse() {
        init();
        linkedList.reverse();
        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(10 - i);
        }
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

        List<Integer> integers = linkedList.getAll();
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(i + 1);
        }
        Assertions.assertThat(integers).hasSize(5);

    }

    @Test
    void clear() {
        init();
        linkedList.clear();

        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).isEmpty();
    }
}