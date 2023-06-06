package queue;

import java.util.Stack;

public class StackQueue<E> implements MyQueue<E> {

    private final Stack<E> in;
    private final Stack<E> out;
    private final int capacity;
    private int size;

    public StackQueue(int capacity) {
        this.in = new Stack<>();
        this.out = new Stack<>();
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public void enqueue(E data) {
        if (isFull()) throw new QueueFullException();
        this.in.push(data);
        this.size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new QueueEmptyException();
        moveInToOut();
        this.size--;
        return out.pop();
    }

    @Override
    public E front() {
        if (isEmpty()) throw new QueueEmptyException();
        moveInToOut();
        return out.peek();
    }

    @Override
    public E rear() {
        if (isEmpty()) throw new QueueEmptyException();
        moveOutToIn();
        return in.peek();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public boolean isFull() {
        return this.size >= this.capacity;
    }

    private void moveInToOut() {
        if (this.out.isEmpty()) {
            while (!this.in.isEmpty()) {
                this.out.push(this.in.pop());
            }
        }
    }

    private void moveOutToIn() {
        if (this.in.isEmpty()) {
            while (!this.out.isEmpty()) {
                this.in.push(this.out.pop());
            }
        }
    }
}
