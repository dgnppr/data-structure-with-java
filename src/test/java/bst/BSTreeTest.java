package bst;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class BSTreeTest {

    BSTree<String, Integer> tree;
    Comparator<String> comparator = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    @BeforeEach
    void setUp() {
        tree = new BSTree<>(comparator);
    }

    private void init() {
        tree.add("5", 5);
        tree.add("2", 2);
        tree.add("3", 3);
        tree.add("1", 1);
        tree.add("4", 4);
        tree.add("6", 6);
        tree.add("8", 8);
        tree.add("9", 9);
        tree.add("7", 7);
    }

    @Test
    void add() {
        init();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(5);
        Assertions.assertThat(tree.search("1")).isEqualTo(1);
        Assertions.assertThat(tree.search("2")).isEqualTo(2);
        Assertions.assertThat(tree.search("3")).isEqualTo(3);
        Assertions.assertThat(tree.search("4")).isEqualTo(4);
        Assertions.assertThat(tree.search("5")).isEqualTo(5);
        Assertions.assertThat(tree.search("6")).isEqualTo(6);
        Assertions.assertThat(tree.search("7")).isEqualTo(7);
        Assertions.assertThat(tree.search("8")).isEqualTo(8);
        Assertions.assertThat(tree.search("9")).isEqualTo(9);

        Assertions.assertThat(tree.search("null")).isNull();
    }

    @Test
    void remove() {
        init();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(5);
        Assertions.assertThat(tree.remove("5")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(4);
        Assertions.assertThat(tree.remove("4")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(3);
        Assertions.assertThat(tree.remove("3")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(2);
        Assertions.assertThat(tree.remove("2")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(1);
        Assertions.assertThat(tree.remove("1")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(6);
        Assertions.assertThat(tree.remove("6")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(8);
        Assertions.assertThat(tree.remove("8")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(7);
        Assertions.assertThat(tree.remove("7")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(9);
        Assertions.assertThat(tree.remove("9")).isTrue();

        Assertions.assertThat(tree.getRoot()).isNull();
        Assertions.assertThat(tree.remove("null")).isFalse();
    }

    @Test
    void preOrder() {
        init();
        Assertions.assertThat(tree.preOrderTraversal()).containsSequence("5", "2", "1", "3", "4", "6", "8", "7", "9");
    }

    @Test
    void inOrder() {
        init();
        Assertions.assertThat(tree.inOrderTraversal()).containsSequence("1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    @Test
    void postOrder() {
        init();
        Assertions.assertThat(tree.postOrderTraversal()).containsSequence("1", "4", "3", "2", "7", "9", "8", "6", "5");
    }

    @Test
    void getMinKey() {
        init();
        Assertions.assertThat(tree.getMinKey()).isEqualTo("1");
    }

    @Test
    void getValueWithMinKey() {
        init();
        Assertions.assertThat(tree.getValueWithMinKey()).isEqualTo(1);
    }

    @Test
    void getMaxKey() {
        init();
        Assertions.assertThat(tree.getMaxKey()).isEqualTo("9");
    }

    @Test
    void getValueWithMaxKey() {
        init();
        Assertions.assertThat(tree.getValueWithMaxKey()).isEqualTo(9);
    }
}