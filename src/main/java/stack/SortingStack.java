package stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class SortingStack<E> {

    Stack<E> in;
    Comparator<E> comparator;

    public SortingStack(Comparator<E> comparator) {
        in = new Stack<>();
        this.comparator = comparator;
    }

    public void push(E data) {
        in.push(data);
        sort();
    }

    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        E ret = in.pop();
        sort();
        return ret;
    }

    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return in.peek();
    }

    private void sort() {
        PriorityQueue<E> pq = new PriorityQueue<>((a, b) -> comparator.compare(b, a));

        while (!in.isEmpty()) {
            pq.add(in.pop());
        }

        while (!pq.isEmpty()) {
            in.push(pq.poll());
        }
    }

    public boolean isEmpty() {
        return in.isEmpty();
    }

}
