package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinArrayStackTest {

    MinArrayStack<Integer> stack;

    @BeforeEach
    void setUp() {
        this.stack = new MinArrayStack<>(5, Integer::compareTo);
    }

    @Test
    void push() {
        stack.push(5);
        Assertions.assertThat(stack.min()).isEqualTo(5);

        stack.push(3);
        Assertions.assertThat(stack.min()).isEqualTo(3);

        stack.push(2);
        Assertions.assertThat(stack.min()).isEqualTo(2);
    }

    @Test
    void pop() {
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Assertions.assertThat(stack.min()).isEqualTo(1);

        stack.pop();
        Assertions.assertThat(stack.min()).isEqualTo(2);

        stack.pop();
        Assertions.assertThat(stack.min()).isEqualTo(3);

        stack.pop();
        Assertions.assertThat(stack.min()).isEqualTo(4);

        stack.pop();
        Assertions.assertThat(stack.min()).isEqualTo(5);

        stack.pop();
        Assertions.assertThatThrownBy(() -> stack.pop()).isInstanceOf(StackEmptyException.class);
    }
}