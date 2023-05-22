package linkedlist.reference.array;

import linkedlist.reference.ArrayLinkedList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class ArrayLinkedListTest {

    ArrayLinkedList<Integer> linkedList = new ArrayLinkedList<>(10);
    Comparator<Integer> comparator = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };


    @Test
    @DisplayName("addFirst 테스트")
    void addFirst() throws Exception {
        linkedList.addFirst(5);
        linkedList.addFirst(4);
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        List<Integer> result = linkedList.getAllNodeData();

        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(result.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("addLast 테스트")
    void addLast() throws Exception {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        List<Integer> result = linkedList.getAllNodeData();

        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(result.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("addFirst+ addLast 혼합")
    void addWithFirstAndLast() throws Exception {
        linkedList.addLast(3);
        linkedList.addFirst(2);
        linkedList.addLast(4);
        linkedList.addFirst(1);
        linkedList.addLast(5);

        List<Integer> result = linkedList.getAllNodeData();

        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(result.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("맨 앞 노드 삭제")
    void removeFirst() throws Exception {
        linkedList.addFirst(1);

        linkedList.removeFirst();

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData).isNull();
    }

    @Test
    @DisplayName("맨 뒤 노드 삭제")
    void removeLast() throws Exception {
        linkedList.addFirst(1);

        linkedList.removeLast();

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData).isNull();
    }

    @Test
    @DisplayName("맨 앞 + 맨 뒤 혼합 노드 삭제")
    void removeWithFirstAndLast() throws Exception {

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.removeFirst();

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData.size()).isEqualTo(2);
        Assertions.assertThat(allNodeData.get(0)).isEqualTo(2);
        Assertions.assertThat(allNodeData.get(1)).isEqualTo(3);
    }

    @Test
    @DisplayName("모든 노드 삭제")
    void clear() throws Exception {

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        linkedList.clear();

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData).isNull();
    }

    @Test
    @DisplayName("검색")
    void search() throws Exception {
        linkedList.addLast(1);

        Assertions.assertThat(linkedList.search(1, comparator)).isEqualTo(1);
        Assertions.assertThat(linkedList.search(2, comparator)).isNull();

    }

}