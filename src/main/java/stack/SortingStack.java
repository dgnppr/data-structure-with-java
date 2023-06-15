package stack;

import java.util.Comparator;
import java.util.Stack;

public class SortingStack<E> {

    private Stack<E> stk;
    private Comparator<E> comparator;

    public SortingStack(Comparator<E> comparator) {
        this.stk = new Stack<>();
        this.comparator = comparator;
    }

    public void push(E data) {
        this.stk.push(data);
        this.stk = mergeSort(this.stk);
    }

    public E pop() {
        if (isEmpty()) throw new StackEmptyException();
        E ret = stk.pop();
        this.stk = mergeSort(this.stk);
        return ret;
    }


    public E top() {
        if (isEmpty()) throw new StackEmptyException();
        return stk.peek();
    }

    // Time: O(N^2) Space: O(N)
    private void sort() {
        Stack<E> tmp = new Stack<>();

        // Find Position
        while (!stk.isEmpty()) {
            E pop = stk.pop();
            while (!tmp.isEmpty() && this.comparator.compare(pop, tmp.peek()) < 0) {
                stk.push(tmp.pop());
            }
            tmp.push(pop);
        }

        // Sort
        while (!tmp.isEmpty()) {
            stk.push(tmp.pop());
        }
    }

    // Time: O(NlogN)
    public Stack<E> mergeSort(Stack<E> stack) {
        if (stack.size() <= 1) {
            return stack;
        }

        Stack<E> leftStack = new Stack<>();
        Stack<E> rightStack = new Stack<>();

        int mid = stack.size() / 2;

        // 주어진 스택을 두 개의 스택으로 분할
        for (int i = 0; i < mid; i++) {
            leftStack.push(stack.pop());
        }
        while (!stack.isEmpty()) {
            rightStack.push(stack.pop());
        }

        // 분할된 스택들을 재귀적으로 정렬
        leftStack = mergeSort(leftStack);
        rightStack = mergeSort(rightStack);

        // 정렬된 스택들을 병합
        Stack<E> mergedStack = new Stack<>();
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            if (this.comparator.compare(leftStack.peek(), rightStack.peek()) < 0) {
                mergedStack.push(leftStack.pop());
            } else {
                mergedStack.push(rightStack.pop());
            }
        }
        while (!leftStack.isEmpty()) {
            mergedStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            mergedStack.push(rightStack.pop());
        }

        // 최종적으로 병합된 스택 반환
        while (!mergedStack.isEmpty()) {
            stack.push(mergedStack.pop());
        }

        return stack;
    }

    public boolean isEmpty() {
        return stk.isEmpty();
    }

}
