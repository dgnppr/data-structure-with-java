package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueStack<E> implements MyStack<E> {

    private final Deque<E> queue;
    private final int capacity;
    private int size;

    public QueueStack(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayDeque<>();
        this.size = 0;
    }

    @Override
    public void push(E data) {
        if (isFull()) throw new StackFullException();
        queue.push(data);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.push(queue.pollFirst());
        }
        this.size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        this.size--;
        return queue.pollFirst();
    }

    @Override
    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return queue.peek();
    }

    @Override
    public void clear() {
        int size = queue.size();
        while (size-- > 0) {
            queue.pop();
        }
    }

    @Override
    public boolean isFull() {
        return this.size >= this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
