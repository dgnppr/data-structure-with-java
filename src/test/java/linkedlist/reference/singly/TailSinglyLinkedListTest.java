package linkedlist.reference.singly;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class TailSinglyLinkedListTest {

    TailSinglyLinkedList<Integer> linkedList = new TailSinglyLinkedList<>();
    Comparator<Integer> comparator = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };


    @Test
    @DisplayName("맨 앞에 노드 추가")
    void addFirst() throws Exception {

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(5 - i);
        }

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData).hasSize(5);

        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(allNodeData.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("맨 뒤에 노드 추가")
    void addLast() throws Exception {

        for (int i = 0; i < 5; i++) {
            linkedList.addLast(5 - i);
        }

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData).hasSize(5);

        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(allNodeData.get(i)).isEqualTo(5 - i);
        }
    }

    @Test
    @DisplayName("맨 앞 + 맨 뒤 혼합 노드 추가")
    void addWithFirstAndLast() throws Exception {

        linkedList.addLast(3);
        linkedList.addFirst(2);
        linkedList.addLast(4);
        linkedList.addFirst(1);
        linkedList.addLast(5);

        List<Integer> allNodeData = linkedList.getAllNodeData();

        Assertions.assertThat(allNodeData).hasSize(5);

        for (int i = 0; i < 5; i++) {
            Assertions.assertThat(allNodeData.get(i)).isEqualTo(i + 1);
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

        Assertions.assertThat(allNodeData).hasSize(2);
        Assertions.assertThat(allNodeData.get(0)).isEqualTo(2);
        Assertions.assertThat(allNodeData.get(1)).isEqualTo(3);
    }

    @Test
    @DisplayName("clear test")
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
    @DisplayName("search test")
    void search() throws Exception {
        linkedList.addLast(1);
        Assertions.assertThat(linkedList.search(1, comparator)).isNotNull();
        Assertions.assertThat(linkedList.search(2, comparator)).isNull();
    }

    @Test
    @DisplayName("purge test")
    void purge() throws Exception {
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(4);
        linkedList.addLast(2);
        linkedList.addLast(2);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(3);
        linkedList.addLast(3);
        linkedList.addLast(3);
        linkedList.addLast(3);
        linkedList.addLast(4);

        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 1).count()).isEqualTo(3);
        linkedList.purge(1, comparator);
        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 1).count()).isEqualTo(1);

        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 2).count()).isEqualTo(3);
        linkedList.purge(2, comparator);
        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 2).count()).isEqualTo(1);

        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 3).count()).isEqualTo(5);
        linkedList.purge(3, comparator);
        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 3).count()).isEqualTo(1);

        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 4).count()).isEqualTo(2);
        linkedList.purge(4, comparator);
        Assertions.assertThat(linkedList.getAllNodeData().stream().filter(i -> i == 4).count()).isEqualTo(1);

    }

    @Test
    @DisplayName("retrieve test")
    void retrieve() throws Exception {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        Assertions.assertThat(linkedList.getAt(3)).isEqualTo(4);
        Assertions.assertThat(linkedList.getAt(-1)).isNull();
        Assertions.assertThat(linkedList.getAt(50)).isNull();
    }

    @Test
    @DisplayName("tail data test")
    void getTailNodeDataTest() throws Exception {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        Assertions.assertThat(linkedList.getTailNodeData()).isEqualTo(4);
        linkedList.addLast(5);
        Assertions.assertThat(linkedList.getTailNodeData()).isEqualTo(5);
        linkedList.removeLast();
        Assertions.assertThat(linkedList.getTailNodeData()).isEqualTo(4);
        linkedList.removeLast();
        Assertions.assertThat(linkedList.getTailNodeData()).isEqualTo(3);

    }
}