package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackOfStackTest {

    StackOfStack<Integer> stack;

    private void init() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
    }

    @BeforeEach
    void setUp() {
        this.stack = new StackOfStack<>(5);
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

        stack.push(6);
        Assertions.assertThat(stack.top()).isEqualTo(6);
        Assertions.assertThat(stack.size()).isEqualTo(2);

        stack.push(7);
        Assertions.assertThat(stack.top()).isEqualTo(7);

        stack.push(8);
        Assertions.assertThat(stack.top()).isEqualTo(8);

        stack.push(9);
        Assertions.assertThat(stack.top()).isEqualTo(9);

        stack.push(10);
        Assertions.assertThat(stack.top()).isEqualTo(10);

        Assertions.assertThat(stack.isFull()).isTrue();
        Assertions.assertThat(stack.size()).isEqualTo(2);

        stack.push(11);
        Assertions.assertThat(stack.top()).isEqualTo(11);
        Assertions.assertThat(stack.size()).isEqualTo(3);
    }

    @Test
    void pop() {
        init();

        Assertions.assertThat(stack.top()).isEqualTo(11);
        Assertions.assertThat(stack.pop()).isEqualTo(11);

        Assertions.assertThat(stack.top()).isEqualTo(10);
        Assertions.assertThat(stack.pop()).isEqualTo(10);

        Assertions.assertThat(stack.top()).isEqualTo(9);
        Assertions.assertThat(stack.pop()).isEqualTo(9);

        Assertions.assertThat(stack.top()).isEqualTo(8);
        Assertions.assertThat(stack.pop()).isEqualTo(8);

        Assertions.assertThat(stack.top()).isEqualTo(7);
        Assertions.assertThat(stack.pop()).isEqualTo(7);

        Assertions.assertThat(stack.top()).isEqualTo(6);
        Assertions.assertThat(stack.pop()).isEqualTo(6);

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
    }
}