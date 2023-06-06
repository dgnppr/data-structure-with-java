package queue;

import stack.ArrayStack;

public class StackQueue<E> implements MyQueue<E> {

    private final ArrayStack<E> in;
    private final ArrayStack<E> out;
    private int size;
    private final int capacity;

    public StackQueue(int capacity) {
        this.in = new ArrayStack<>(capacity);
        this.out = new ArrayStack<>(capacity);
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
        return out.top();
    }

    @Override
    public E rear() {
        if (isEmpty()) throw new QueueEmptyException();
        moveOutToIn();
        return in.top();
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
        while (!this.in.isEmpty()) {
            this.out.push(this.in.pop());
        }
    }

    private void moveOutToIn() {
        while (!this.out.isEmpty()) {
            this.in.push(this.out.pop());
        }
    }
}
