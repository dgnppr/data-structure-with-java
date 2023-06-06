package queue;

public interface MyQueue<E> {

    void enqueue(E data);

    E dequeue();

    E front();

    E rear();

    int size();

    boolean isEmpty();

    boolean isFull();
}
