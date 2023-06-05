package stack;

public interface MyStack<E> {
    void push(E data);

    E pop();

    E top();

    void clear();

    boolean isFull();

    boolean isEmpty();
}
