package linkedlist.circular;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularDoublyLinkedListTest {
    CircularDoublyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new CircularDoublyLinkedList<>();
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
    }
}