package stack;

import java.util.Stack;

public class StackOfStack<E> implements MyStack<E> {

    private Stack<Stack<E>> stk;
    private int capacity;

    public StackOfStack(int capacity) {
        this.stk = new Stack<>();
        this.capacity = capacity;
    }

    @Override
    public void push(E data) {
        if (this.stk.isEmpty() || isFull()) stk.push(new Stack<>());
        stk.peek().push(data);
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        if (isTopEmpty()) stk.pop();
        return stk.peek().pop();
    }

    @Override
    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        if (isTopEmpty()) stk.pop();
        return stk.peek().peek();
    }

    public int size() {
        return this.stk.size();
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public boolean isFull() {
        return this.stk.peek().size() >= this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return (stk.isEmpty()) || (stk.size() == 1 && isTopEmpty());
    }

    private boolean isTopEmpty() {
        return stk.peek().isEmpty();
    }
}
