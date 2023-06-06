package queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackQueueTest {

    StackQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new StackQueue<>(5);
    }

    private void init() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }

    @Test
    void enqueue() {
        queue.enqueue(1);
        Assertions.assertThat(queue.front()).isEqualTo(1);
        Assertions.assertThat(queue.rear()).isEqualTo(1);

        queue.enqueue(2);
        Assertions.assertThat(queue.front()).isEqualTo(1);
        Assertions.assertThat(queue.rear()).isEqualTo(2);

        queue.enqueue(3);
        Assertions.assertThat(queue.front()).isEqualTo(1);
        Assertions.assertThat(queue.rear()).isEqualTo(3);

        queue.enqueue(4);
        Assertions.assertThat(queue.front()).isEqualTo(1);
        Assertions.assertThat(queue.rear()).isEqualTo(4);

        queue.enqueue(5);
        Assertions.assertThat(queue.front()).isEqualTo(1);
        Assertions.assertThat(queue.rear()).isEqualTo(5);

        Assertions.assertThat(queue.isFull()).isTrue();
        Assertions.assertThatThrownBy(() -> queue.enqueue(6)).isInstanceOf(QueueFullException.class);
    }

    @Test
    void dequeue() {
        init();

        Assertions.assertThat(queue.dequeue()).isEqualTo(1);
        Assertions.assertThat(queue.dequeue()).isEqualTo(2);
        Assertions.assertThat(queue.dequeue()).isEqualTo(3);
        Assertions.assertThat(queue.dequeue()).isEqualTo(4);
        Assertions.assertThat(queue.dequeue()).isEqualTo(5);

        Assertions.assertThat(queue.isEmpty()).isTrue();
        Assertions.assertThatThrownBy(() -> queue.dequeue()).isInstanceOf(QueueEmptyException.class);
    }

}