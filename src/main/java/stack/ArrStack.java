package stack;

public class ArrStack<E> implements MyStack<E> {

    private final int capacity;
    private final Object[] stk;
    private int ptr;

    public ArrStack(int capacity) {
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
