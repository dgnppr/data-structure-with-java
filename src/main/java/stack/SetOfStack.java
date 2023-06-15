package stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStack<E> implements MyStack<E> {

    private int capacity;
    private List<Stack<E>> stack;

    public SetOfStack(int capacity) {
        this.capacity = capacity;
        stack = new ArrayList<>();
    }

    @Override
    public void push(E data) {
        if (isEmpty() || isFull()) stack.add(new Stack<>());
        this.stack.get(this.stack.size() - 1).add(data);
    }

    @Override
    public E pop() {
        if (isEmpty() || stack.size() == 1 && isTopEmpty()) throw new StackEmptyException();
        if (stack.size() >= 2 && isTopEmpty()) this.stack.remove(this.stack.size() - 1);
        return this.stack.get(this.stack.size() - 1).pop();
    }

    public E popAt(int idx) {
        if (isEmpty()) throw new StackEmptyException();

        synchronize();

        int pos = this.stack.size() - idx - 1;
        if (pos < 0 || pos > this.stack.size() - 1) throw new RuntimeException();

        return this.stack.get(pos).pop();
    }

    @Override
    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        synchronize();
        return this.stack.get(this.stack.size() - 1).peek();
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    private void synchronize() {
        if (isTopEmpty()) this.stack.remove(this.stack.size() - 1);
    }

    @Override
    public boolean isFull() {
        return this.stack.get(this.stack.size() - 1).size() == this.capacity;
    }


    public boolean isTopEmpty() {
        return this.stack.get(this.stack.size() - 1).size() == 0;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.size() == 0;
    }
}
