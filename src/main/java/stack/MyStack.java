package stack;

public interface MyStack<E> {
    void push(E data);

    E pop();

    E peek();

    void clear();

    boolean isFull();

    boolean isEmpty();
}
