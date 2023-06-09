package tree;

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
        tree.add("key15", 15);
        tree.add("key12", 12);
        tree.add("key11", 11);
        tree.add("key13", 13);
        tree.add("key10", 10);
        tree.add("key14", 14);
        tree.add("key18", 18);
    }

    @Test
    void add() {
        tree.add("key3", 3);
        tree.add("key1", 1);
        tree.add("key4", 4);
        tree.add("key2", 2);
        tree.add("key5", 5);

        Assertions.assertThat(tree.getRoot().value).isEqualTo(3);
        Assertions.assertThat(tree.search("key1")).isEqualTo(1);
        Assertions.assertThat(tree.search("key2")).isEqualTo(2);
        Assertions.assertThat(tree.search("key3")).isEqualTo(3);
        Assertions.assertThat(tree.search("key4")).isEqualTo(4);
        Assertions.assertThat(tree.search("key5")).isEqualTo(5);

        Assertions.assertThat(tree.search("null")).isNull();
    }

    @Test
    void remove() {
        tree.add("key3", 3);
        tree.add("key1", 1);
        tree.add("key4", 4);
        tree.add("key2", 2);
        tree.add("key5", 5);

        Assertions.assertThat(tree.getRoot().value).isEqualTo(3);
        Assertions.assertThat(tree.remove("key3")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(2);
        Assertions.assertThat(tree.remove("key2")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(1);
        Assertions.assertThat(tree.remove("key1")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(4);
        Assertions.assertThat(tree.remove("key4")).isTrue();

        Assertions.assertThat(tree.getRoot().value).isEqualTo(5);
        Assertions.assertThat(tree.remove("key5")).isTrue();

        Assertions.assertThat(tree.getRoot()).isNull();
        Assertions.assertThat(tree.remove("null")).isFalse();
    }

    @Test
    void preOrder() {
        init();
        tree.preOrderTraversal(tree.getRoot());
    }

    @Test
    void inOrder() {
        init();
        tree.inOrderTraversal(tree.getRoot());
    }

    @Test
    void postOrder() {
        init();
        tree.postOrderTraversal(tree.getRoot());
    }
}