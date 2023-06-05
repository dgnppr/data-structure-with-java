package queue;

public interface MyQueue<E> {

    void enqueue(E data);

    E dequeue();

    E peek();

    boolean isEmpty();

    boolean isFull();
}
