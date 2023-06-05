package queue;

public class ArrQueue<E> implements MyQueue<E> {

    private final int capacity;
    private final Object[] que;
    private int front;
    private int rear;

    public ArrQueue(int capacity) {
        this.capacity = capacity;
        this.que = new Object[this.capacity];
        this.front = this.rear = 0;
    }

    @Override
    public void enqueue(E data) {
        if (isFull()) throw new QueueFullException();
        this.que[this.rear] = data;
        this.rear = (this.rear + 1) % this.capacity;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new QueueEmptyException();
        E data = (E) this.que[this.front];
        this.que[this.front] = null;
        this.front = (this.front + 1) % this.capacity;
        return data;
    }

    @Override
    public E front() {
        if (isEmpty()) throw new QueueEmptyException();
        return (E) this.que[this.front];
    }

    @Override
    public E rear() {
        if (isEmpty()) throw new QueueEmptyException();
        return (E) this.que[(this.rear + this.capacity - 1) % this.capacity];
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear && this.que[this.front] == null;
    }

    @Override
    public boolean isFull() {
        return this.front == this.rear % this.capacity && this.que[this.front] != null;
    }

}
