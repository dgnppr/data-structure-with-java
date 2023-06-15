package stack;

import java.util.Comparator;

public class MinNodeStack<E> {

    private MinNode<E> top;
    private Comparator<E> comparator;

    public MinNodeStack(Comparator<E> comparator) {
        this.top = null;
        this.comparator = comparator;
    }

    public void push(E data) {
        if (isEmpty()) {
            this.top = new MinNode<>(data, null, data);
        } else {
            E min = this.top.min;
            MinNode<E> node;
            if (comparator.compare(data, min) < 0) node = new MinNode<>(data, this.top, data);
            else node = new MinNode<>(data, this.top, min);
            this.top = node;
        }
    }

    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        E data = this.top.data;
        this.top = this.top.nxt;
        return data;
    }

    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return this.top.data;
    }

    public E min() {
        if (isEmpty()) throw new StackEmptyException();
        return this.top.min;
    }

    public boolean isEmpty() {
        return this.top == null;
    }


    static class MinNode<E> {
        E data;
        MinNode<E> nxt;
        E min;

        public MinNode(E data, MinNode<E> nxt, E min) {
            this.data = data;
            this.nxt = nxt;
            this.min = min;
        }
    }

}
