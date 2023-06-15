package stack;

public class ThreeStackUsingOneArray<E> {

    private Object[] arr;
    private int limit;
    private int stack1Ptr, stack2Ptr, stack3Ptr;
    private int stack1Limit, stack2Limit, stack3Limit;

    public ThreeStackUsingOneArray(int capacity) {
        if (capacity < 3) throw new RuntimeException("Invalid parameter");
        this.arr = new Object[capacity];

        this.limit = capacity / 3;

        this.stack1Limit = limit;
        this.stack2Limit = 2 * limit;
        this.stack3Limit = 3 * limit;

        this.stack1Ptr = 0;
        this.stack2Ptr = stack1Ptr + limit;
        this.stack3Ptr = stack2Ptr + limit;
    }

    public void pushToStack1(E data) {
        if (isFull(stack1Ptr, stack1Limit)) throw new StackFullException();
        this.arr[stack1Ptr++] = data;
    }

    public void pushToStack2(E data) {
        if (isFull(stack2Ptr, stack2Limit)) throw new StackFullException();
        this.arr[stack2Ptr++] = data;
    }

    public void pushToStack3(E data) {
        if (isFull(stack3Ptr, stack3Limit)) throw new StackFullException();
        this.arr[stack3Ptr++] = data;
    }

    public E popStack1() {
        if (isEmpty(stack1Ptr, stack1Limit)) throw new StackEmptyException();
        return (E) this.arr[--stack1Ptr];
    }

    public E popStack2() {
        if (isEmpty(stack2Ptr, stack2Limit)) throw new StackEmptyException();
        return (E) this.arr[--stack2Ptr];
    }

    public E popStack3() {
        if (isEmpty(stack3Ptr, stack3Limit)) throw new StackEmptyException();
        return (E) this.arr[--stack3Ptr];
    }

    public E topStack1() {
        if (isEmpty(stack1Ptr, stack1Limit)) throw new StackEmptyException();
        return (E) this.arr[stack1Ptr - 1];
    }

    public E topStack2() {
        if (isEmpty(stack2Ptr, stack2Limit)) throw new StackEmptyException();
        return (E) this.arr[stack2Ptr - 1];
    }

    public E topStack3() {
        if (isEmpty(stack3Ptr, stack3Limit)) throw new StackEmptyException();
        return (E) this.arr[stack3Ptr - 1];
    }

    public boolean isFull(int ptr, int limit) {
        return ptr >= limit;
    }

    public boolean isEmpty(int ptr, int limit) {
        return limit - ptr == this.limit;
    }
}
