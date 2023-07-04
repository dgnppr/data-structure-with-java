package stack;

import java.util.Set;
import java.util.Stack;

public class StackConverter {

    static Set<Character> operations = Set.of('+', '-', '*', '/', '(', ')');
    private Set<Character> lowPriority = Set.of('+', '-');
    private Set<Character> highPriority = Set.of('*', '/');

    public String covertToPrefixExpression(String infixExpr) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = infixExpr.toCharArray();
        StringBuilder ret = new StringBuilder();

        for (char ch : charArray) {

        }


        return ret.toString();
    }

    public String covertToSuffixExpression(String infixExpr) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = infixExpr.toCharArray();
        StringBuilder ret = new StringBuilder();

        for (char ch : charArray) {
            if (!operations.contains(ch)) {
                ret.append(ch);
            } else {
                if (stack.isEmpty() || ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        ret.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && (lowerThanStackTop(stack.peek(), ch) || equalWithStackTop(stack.peek(), ch))) {
                        ret.append(stack.pop());
                    }

                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            ret.append(stack.pop());
        }

        return ret.toString();
    }

    private boolean lowerThanStackTop(char top, char ch) {
        return lowPriority.contains(ch) && highPriority.contains(top);
    }

    private boolean equalWithStackTop(char top, char ch) {
        return (highPriority.contains(ch) && highPriority.contains(top)) || (lowPriority.contains(ch) && lowPriority.contains(top));
    }

}
