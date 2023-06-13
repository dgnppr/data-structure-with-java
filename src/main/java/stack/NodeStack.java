package stack;

public class NodeStack<E> implements MyStack<E> {

    private Node<E> top;

    @Override
    public void push(E data) {
        if (isEmpty()) {
            top = new Node<>(data, null);
        } else {
            Node<E> node = new Node<>(data, this.top);
            top = node;
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        E data = top.data;
        top = top.nxt;
        return data;
    }

    @Override
    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    static class Node<E> {
        private E data;
        private Node<E> nxt;

        public Node(E data, Node<E> nxt) {
            this.data = data;
            this.nxt = nxt;
        }
    }
}
