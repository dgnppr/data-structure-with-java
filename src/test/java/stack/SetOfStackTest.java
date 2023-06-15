package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetOfStackTest {

    SetOfStack<Integer> stack;

    @BeforeEach
    void setUp() {
        this.stack = new SetOfStack<>(3);
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
    }

    @Test
    void pop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        Assertions.assertThat(stack.pop()).isEqualTo(7);
        Assertions.assertThat(stack.pop()).isEqualTo(6);
        Assertions.assertThat(stack.pop()).isEqualTo(5);
        Assertions.assertThat(stack.pop()).isEqualTo(4);
        Assertions.assertThat(stack.pop()).isEqualTo(3);
        Assertions.assertThat(stack.pop()).isEqualTo(2);
        Assertions.assertThat(stack.pop()).isEqualTo(1);

        Assertions.assertThatThrownBy(() -> stack.pop()).isInstanceOf(StackEmptyException.class);
    }

    @Test
    void popAt() {

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        Assertions.assertThat(stack.popAt(1)).isEqualTo(6);
        Assertions.assertThat(stack.popAt(0)).isEqualTo(7);
        Assertions.assertThat(stack.popAt(1)).isEqualTo(3);
        Assertions.assertThat(stack.popAt(0)).isEqualTo(5);
        Assertions.assertThat(stack.popAt(1)).isEqualTo(2);
    }
}