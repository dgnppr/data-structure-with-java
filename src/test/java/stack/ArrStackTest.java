package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrStackTest {

    ArrStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrStack<>(5);
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
        Assertions.assertThat(stack.peek()).isEqualTo(1);
        stack.push(2);
        Assertions.assertThat(stack.peek()).isEqualTo(2);
        stack.push(3);
        Assertions.assertThat(stack.peek()).isEqualTo(3);
        stack.push(4);
        Assertions.assertThat(stack.peek()).isEqualTo(4);
        stack.push(5);
        Assertions.assertThat(stack.peek()).isEqualTo(5);
        Assertions.assertThatThrownBy(() -> stack.push(6)).isInstanceOf(ArrStack.StackFullException.class);
    }

    @Test
    void pop() {
        init();
        Assertions.assertThat(stack.pop()).isEqualTo(5);
        Assertions.assertThat(stack.peek()).isEqualTo(4);

        Assertions.assertThat(stack.pop()).isEqualTo(4);
        Assertions.assertThat(stack.peek()).isEqualTo(3);

        Assertions.assertThat(stack.pop()).isEqualTo(3);
        Assertions.assertThat(stack.peek()).isEqualTo(2);

        Assertions.assertThat(stack.pop()).isEqualTo(2);
        Assertions.assertThat(stack.peek()).isEqualTo(1);

        Assertions.assertThat(stack.pop()).isEqualTo(1);
        Assertions.assertThatThrownBy(() -> stack.peek()).isInstanceOf(ArrStack.StackEmptyException.class);
        Assertions.assertThatThrownBy(() -> stack.pop()).isInstanceOf(ArrStack.StackEmptyException.class);
    }

    @Test
    void peek() {
        init();
        Assertions.assertThat(stack.peek()).isEqualTo(5);
    }

    @Test
    void clear() {
        init();
        stack.clear();
        Assertions.assertThatThrownBy(() -> stack.pop()).isInstanceOf(ArrStack.StackEmptyException.class);
    }
}