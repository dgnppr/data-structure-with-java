package bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    MyBSTree<Integer, Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree<>(Integer::compareTo);
    }

    @Test
    @DisplayName("빈 트리에 노드를 추가하면 그 노드는 루트 노드가 된다.")
    void addAtRoot() {

        //when
        tree.add(1, 100);

        //then
        assertThat(tree.contains(1)).isTrue();
        assertThat(tree.getRoot().value).isEqualTo(100);
        assertThat(tree.getRoot().key).isEqualTo(1);
        assertThat(tree.contains(1)).isTrue();
        assertThat(tree.search(1).value).isEqualTo(100);
    }

    @Test
    @DisplayName("노드보다 큰 값을 가진 노드를 추가하면 오른쪽 노드에 위치한다.")
    void addAtRight() {

        //when
        tree.add(1, 100);
        tree.add(2, 200);

        //then
        assertThat(tree.contains(2)).isTrue();
        assertThat(tree.getRoot().right.key).isEqualTo(2);
        assertThat(tree.getRoot().right.value).isEqualTo(200);
    }

    @Test
    @DisplayName("노드보다 작은 값을 가진 노드를 추가하면 오른쪽 노드에 위치한다.")
    void addAtLeft() {

        //when
        tree.add(1, 100);
        tree.add(-1, -100);

        //then
        assertThat(tree.contains(-1)).isTrue();
        assertThat(tree.getRoot().left.key).isEqualTo(-1);
        assertThat(tree.getRoot().left.value).isEqualTo(-100);
    }

    @Test
    void remove() {
    }

    @Test
    @DisplayName("노드의 서브트리에서 노드의 후임자를 가져온다.")
    void getSuccessor() {
        //given
        tree.add(2, 1);
        tree.add(1, 1);
        tree.add(33, 1);
        tree.add(0, 1);
        tree.add(25, 1);
        tree.add(40, 1);
        tree.add(11, 1);
        tree.add(34, 100);
        tree.add(7, 1);
        tree.add(12, 1);
        tree.add(36, 1);
        tree.add(13, 1);

        //when
        Node<Integer, Integer> successor = tree.getSuccessor(33);

        //then
        assertThat(successor.key).isEqualTo(34);
        assertThat(successor.value).isEqualTo(100);
    }

    @Test
    @DisplayName("비어있는 트리에서 후임자를 가져오면 null을 반환한다.")
    void getSuccessorAtEmptyTree() {
        //when
        Node<Integer, Integer> successor = tree.getSuccessor(33);

        //then
        assertThat(successor).isNull();
    }

    @Test
    @DisplayName("키가 존재하지 않는 트리에서 후임자를 가져오면 null을 반환한다.")
    void getSuccessorAtEmptyKey() {
        //given
        tree.add(2, 1);
        tree.add(1, 1);
        tree.add(33, 1);
        tree.add(0, 1);
        tree.add(25, 1);
        tree.add(40, 1);
        tree.add(11, 1);
        tree.add(34, 100);
        tree.add(7, 1);
        tree.add(12, 1);
        tree.add(36, 1);
        tree.add(13, 1);

        //when
        Node<Integer, Integer> successor = tree.getSuccessor(Integer.MAX_VALUE);

        //then
        assertThat(successor).isNull();
    }

    @Test
    @DisplayName("자신보다 큰 노드가 존재하는 서브 트리가 존재하지 않을때 후임자를 가져오면 null을 반환한다.")
    void getSuccessorAtEmptyRightSubtree() {
        //given
        tree.add(2, 1);
        tree.add(1, 1);
        tree.add(33, 1);
        tree.add(0, 1);
        tree.add(25, 1);
        tree.add(40, 1);
        tree.add(11, 1);
        tree.add(34, 100);
        tree.add(7, 1);
        tree.add(12, 1);
        tree.add(36, 1);
        tree.add(13, 1);

        //when
        Node<Integer, Integer> successor = tree.getSuccessor(40);

        //then
        assertThat(successor).isNull();
    }

    @Test
    void getPredecessor() {
    }

    @Test
    void postOrderTraversal() {
    }

    @Test
    void inOrderTraversal() {
    }

    @Test
    void preOrderTraversal() {
    }
}