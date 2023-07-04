package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackConverterTest {

    StackConverter stackConverter;

    @BeforeEach
    void setUp() {
        this.stackConverter = new StackConverter();
    }

    @Test
    void covertToPrefixExpression() {
    }

    @Test
    void covertToSuffixExpression() {
        Assertions.assertThat(stackConverter.covertToSuffixExpression("1*(2+3)")).isEqualTo("123+*");
        Assertions.assertThat(stackConverter.covertToSuffixExpression("1+2*3")).isEqualTo("123*+");
        Assertions.assertThat(stackConverter.covertToSuffixExpression("1+2")).isEqualTo("12+");
        Assertions.assertThat(stackConverter.covertToSuffixExpression("1+2*3-4/5")).isEqualTo("123*+45/-");
    }
}