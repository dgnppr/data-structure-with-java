package linkedlist.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class ArrayLinkedListTest {

    ArrayLinkedList<Integer> linkedList;
    Comparator<Integer> c = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

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
        Assertions.assertThat(linkedList.contains(1, c)).isFalse();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(0);
    }

    @Test
    void removeMiddle() {
        init();
        linkedList.removeMiddle();
        Assertions.assertThat(linkedList.contains(6, c)).isFalse();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(9);
    }

    @Test
    void removeAt() {
        init();
        linkedList.removeAt(3);
        Assertions.assertThat(linkedList.contains(4, c)).isFalse();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(9);
        linkedList.dump();
    }

    @Test
    void removeIfDataIsEven() {
        init();
        linkedList.removeIfDataIsEven();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(5);
        for (int i = 0; i < integers.size(); i++) {
            Assertions.assertThat(integers.get(i)).isEqualTo(2 * i + 1);
        }
        linkedList.dump();
    }

    @Test
    void clear() {
        init();
        linkedList.clear();
        List<Integer> integers = linkedList.getAll();
        Assertions.assertThat(integers).hasSize(0);
    }

    @Test
    void getAt() {
        init();
        Assertions.assertThat(linkedList.getAt(5)).isEqualTo(6);
    }

    @Test
    void getAtFromBack() {
        init();
        Assertions.assertThat(linkedList.getAtFromBack(0)).isEqualTo(10);
        Assertions.assertThat(linkedList.getAtFromBack(5)).isEqualTo(5);
        Assertions.assertThat(linkedList.getAtFromBack(9)).isEqualTo(1);
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
    void reverse() {
    }

    @Test
    void deduplicate() {
    }

    @Test
    void isPalindrome() {
    }
}