package queue;

public class NodeQueue<E> implements MyQueue<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;

    @Override
    public void enqueue(E data) {
        if (isEmpty()) {
            this.front = this.rear = new Node<>(data, null);
        } else {
            Node<E> node = new Node<>(data, null);
            this.rear.nxt = node;
            this.rear = node;
        }

        this.size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new QueueEmptyException();
        E data = this.front.data;
        this.front = this.front.nxt;
        this.size--;
        return data;
    }

    @Override
    public E front() {
        if (isEmpty()) throw new QueueEmptyException();
        return this.front.data;
    }

    @Override
    public E rear() {
        if (isEmpty()) throw new QueueEmptyException();
        return this.rear.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.front == null;
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
