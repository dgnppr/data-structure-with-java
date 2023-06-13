package stack;

import java.util.Comparator;

public class MinArrayStack<E> extends ArrayStack<E> {

    private int minIdx;
    private Comparator<E> comparator;

    public MinArrayStack(int capacity, Comparator<E> comparator) {
        super(capacity);
        this.comparator = comparator;
        this.minIdx = -1;
    }

    @Override
    public void push(E data) {
        if (super.isEmpty()) {
            this.minIdx = this.ptr;
        } else {
            if (comparator.compare(data, (E) this.stk[this.minIdx]) < 0) {
                this.minIdx = this.ptr;
            }
        }
        super.push(data);
    }

    @Override
    public E pop() {
        if (super.isEmpty()) throw new StackEmptyException();
        if (this.ptr - 1 == this.minIdx) {
            if (this.ptr - 1 == 0)
                this.minIdx = -1;
            else
                this.minIdx = searchNxtMinIdx();
        }

        return super.pop();
    }

    public E min() {
        if (super.isEmpty()) throw new StackEmptyException();
        return (E) this.stk[this.minIdx];
    }

    private int searchNxtMinIdx() {
        if (this.ptr - 1 <= 0) {
            return 0;
        }

        int cur = this.ptr - 2;
        int idx = cur;
        E min = (E) this.stk[cur];
        while (cur >= 0) {
            if (comparator.compare((E) this.stk[cur], min) < 0) {
                min = (E) this.stk[cur];
            }
            cur--;
        }

        return idx;

    }
}
