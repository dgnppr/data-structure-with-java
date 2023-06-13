package stack;

public class ArrayStack<E> implements MyStack<E> {

    protected final int capacity;
    protected final Object[] stk;
    protected int ptr;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stk = new Object[this.capacity];
        this.ptr = 0;
    }

    @Override
    public void push(E data) {
        if (isFull()) throw new StackFullException();
        this.stk[this.ptr++] = data;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        return (E) this.stk[--this.ptr];
    }

    @Override
    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return (E) this.stk[this.ptr - 1];
    }

    @Override
    public void clear() {
        this.ptr = 0;
    }

    @Override
    public boolean isFull() {
        return this.ptr >= this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return this.ptr <= 0;
    }

}
