package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortingStackTest {

    SortingStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new SortingStack<>(Integer::compareTo);
    }

    @Test
    void push() {
        stack.push(5);
        Assertions.assertThat(stack.top()).isEqualTo(5);

        stack.push(6);
        Assertions.assertThat(stack.top()).isEqualTo(5);

        stack.push(3);
        Assertions.assertThat(stack.top()).isEqualTo(3);

        stack.push(4);
        Assertions.assertThat(stack.top()).isEqualTo(3);

        stack.push(1);
        Assertions.assertThat(stack.top()).isEqualTo(1);
    }

    @Test
    void pop() {
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(4);
        stack.push(1);

        stack.pop();
        Assertions.assertThat(stack.top()).isEqualTo(3);

        stack.pop();
        Assertions.assertThat(stack.top()).isEqualTo(4);

        stack.pop();
        Assertions.assertThat(stack.top()).isEqualTo(5);

        stack.pop();
        Assertions.assertThat(stack.top()).isEqualTo(6);
    }
}