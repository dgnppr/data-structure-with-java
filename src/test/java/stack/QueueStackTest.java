package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueStackTest {

    QueueStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new QueueStack<>(5);
    }

    private void init() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @Test
    void push() {

        stack.push(1);
        Assertions.assertThat(stack.top()).isEqualTo(1);
        stack.push(2);
        Assertions.assertThat(stack.top()).isEqualTo(2);
        stack.push(3);
        Assertions.assertThat(stack.top()).isEqualTo(3);
        stack.push(4);
        Assertions.assertThat(stack.top()).isEqualTo(4);
        stack.push(5);
        Assertions.assertThat(stack.top()).isEqualTo(5);

        Assertions.assertThat(stack.isFull()).isTrue();
        Assertions.assertThatThrownBy(() -> stack.push(6)).isInstanceOf(StackFullException.class);
    }

    @Test
    void pop() {
        init();

        Assertions.assertThat(stack.top()).isEqualTo(5);
        Assertions.assertThat(stack.pop()).isEqualTo(5);

        Assertions.assertThat(stack.top()).isEqualTo(4);
        Assertions.assertThat(stack.pop()).isEqualTo(4);

        Assertions.assertThat(stack.top()).isEqualTo(3);
        Assertions.assertThat(stack.pop()).isEqualTo(3);

        Assertions.assertThat(stack.top()).isEqualTo(2);
        Assertions.assertThat(stack.pop()).isEqualTo(2);

        Assertions.assertThat(stack.top()).isEqualTo(1);
        Assertions.assertThat(stack.pop()).isEqualTo(1);

        Assertions.assertThat(stack.isEmpty()).isTrue();
        Assertions.assertThatThrownBy(() -> stack.pop()).isInstanceOf(StackEmptyException.class);
    }

    @Test
    void clear() {
        init();
        stack.clear();
        Assertions.assertThat(stack.isEmpty()).isTrue();
    }
}