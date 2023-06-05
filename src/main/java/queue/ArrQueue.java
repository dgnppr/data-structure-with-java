package queue;

public class ArrQueue<E> implements MyQueue<E> {

    private final int capacity;
    private final Object[] que;
    private final int front;
    private final int rear;

    public ArrQueue(int capacity) {
        this.capacity = capacity;
        this.que = new Object[this.capacity];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public void enqueue(E data) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    static class QueueFullException extends RuntimeException {
    }

    static class QueueEmptyException extends RuntimeException {
    }
}
