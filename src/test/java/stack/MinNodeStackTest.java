package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinNodeStackTest {

    MinNodeStack<Integer> stack;

    @BeforeEach
    void setUp() {
        this.stack = new MinNodeStack<>(Integer::compareTo);
    }

    @Test
    void push1() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Assertions.assertThat(stack.min()).isEqualTo(1);
        Assertions.assertThat(stack.top()).isEqualTo(5);
    }

    @Test
    void push2() {
        stack.push(5);
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assertions.assertThat(stack.min()).isEqualTo(1);
        Assertions.assertThat(stack.top()).isEqualTo(3);
    }

    @Test
    void push3() {
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        Assertions.assertThat(stack.min()).isEqualTo(1);
        Assertions.assertThat(stack.top()).isEqualTo(1);
    }

    @Test
    void pop() {
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        Assertions.assertThat(stack.min()).isEqualTo(1);

        Assertions.assertThat(stack.pop()).isEqualTo(1);
        Assertions.assertThat(stack.min()).isEqualTo(2);

        Assertions.assertThat(stack.pop()).isEqualTo(3);
        Assertions.assertThat(stack.min()).isEqualTo(2);

        Assertions.assertThat(stack.pop()).isEqualTo(2);
        Assertions.assertThat(stack.min()).isEqualTo(4);
    }

}