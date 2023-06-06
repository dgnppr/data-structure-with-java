package stack;

import queue.ArrayQueue;

public class QueueStack<E> implements MyStack<E> {

    private final ArrayQueue<E> queue;

    public QueueStack(int capacity) {
        this.queue = new ArrayQueue<>(capacity);
    }

    @Override
    public void push(E data) {
        if (isFull()) throw new StackFullException();
        queue.enqueue(data);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.enqueue(queue.dequeue());
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        return queue.dequeue();
    }

    @Override
    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return queue.front();
    }

    @Override
    public void clear() {
        int size = queue.size();
        while (size-- > 0) {
            queue.dequeue();
        }
    }

    @Override
    public boolean isFull() {
        return queue.isFull();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
