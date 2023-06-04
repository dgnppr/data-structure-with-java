package linkedlist.array;

public class ArrNode<E> {
    public E data;
    public int nxt;
    public int dnxt;

    public void init(E data, int nxt) {
        this.data = data;
        this.nxt = nxt;
    }
}
