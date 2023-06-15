package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreeStackUsingOneArrayTest {

    ThreeStackUsingOneArray<Integer> stack;

    @BeforeEach
    void setUp() {
        this.stack = new ThreeStackUsingOneArray<>(15);
    }

    private void init() {
        stack.pushToStack1(1);
        stack.pushToStack1(2);
        stack.pushToStack1(3);
        stack.pushToStack1(4);
        stack.pushToStack1(5);

        stack.pushToStack2(6);
        stack.pushToStack2(7);
        stack.pushToStack2(8);
        stack.pushToStack2(9);
        stack.pushToStack2(10);

        stack.pushToStack3(11);
        stack.pushToStack3(12);
        stack.pushToStack3(13);
        stack.pushToStack3(14);
        stack.pushToStack3(15);

    }

    @Test
    void push() {
        init();

        Assertions.assertThat(stack.topStack1()).isEqualTo(5);
        Assertions.assertThat(stack.topStack2()).isEqualTo(10);
        Assertions.assertThat(stack.topStack3()).isEqualTo(15);

        Assertions.assertThatThrownBy(() -> stack.pushToStack1(1)).isInstanceOf(StackFullException.class);
        Assertions.assertThatThrownBy(() -> stack.pushToStack2(1)).isInstanceOf(StackFullException.class);
        Assertions.assertThatThrownBy(() -> stack.pushToStack3(1)).isInstanceOf(StackFullException.class);
    }

    @Test
    void pop() {
        Assertions.assertThatThrownBy(() -> stack.popStack1()).isInstanceOf(StackEmptyException.class);
        Assertions.assertThatThrownBy(() -> stack.popStack2()).isInstanceOf(StackEmptyException.class);
        Assertions.assertThatThrownBy(() -> stack.popStack3()).isInstanceOf(StackEmptyException.class);

        init();

        Assertions.assertThat(stack.popStack1()).isEqualTo(5);
        Assertions.assertThat(stack.popStack2()).isEqualTo(10);
        Assertions.assertThat(stack.popStack3()).isEqualTo(15);

        Assertions.assertThat(stack.popStack1()).isEqualTo(4);
        Assertions.assertThat(stack.popStack2()).isEqualTo(9);
        Assertions.assertThat(stack.popStack3()).isEqualTo(14);

        Assertions.assertThat(stack.topStack1()).isEqualTo(3);
        Assertions.assertThat(stack.topStack2()).isEqualTo(8);
        Assertions.assertThat(stack.topStack3()).isEqualTo(13);
    }

}