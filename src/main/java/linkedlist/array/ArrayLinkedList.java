package linkedlist.array;

import linkedlist.ArrNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayLinkedList<E> {

    private static final int NULL = -1;
    private int head;
    private int dhead;
    private ArrNode<E>[] arr;
    private int size;
    private int capacity;

    public ArrayLinkedList(int capacity) {
        this.head = this.dhead = NULL;
        this.size = 0;
        try {
            this.arr = new ArrNode[capacity];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ArrNode<>();
            }
            this.capacity = capacity;
        } catch (OutOfMemoryError error) {
            this.capacity = 0;
        }
    }

    private int getInsertIdx() {
        if (hasFreeIdx()) {
            int ret = this.dhead;
            this.dhead = arr[ret].dnxt;
            return ret;
        } else {
            if (isFull()) return NULL;
            else return this.size++;
        }
    }

    private void deleteIdx(int idx) {
        if (hasFreeIdx()) {
            int nxt = this.dhead;
            this.dhead = idx;
            arr[idx].dnxt = nxt;
        } else {
            this.dhead = idx;
            arr[idx].dnxt = NULL;
        }
    }

    // 삽입
    public void addAtFirst(E data) {
        if (isFull()) return;

        int nxt = this.head;
        int idx = getInsertIdx();

        this.head = idx;
        arr[head].init(data, nxt);
    }

    public void addAtLast(E data) {
        if (isFull()) return;

        if (isEmpty()) {
            addAtFirst(data);
        } else {
            int ptr = this.head;
            while (arr[ptr].nxt != NULL) {
                ptr = arr[ptr].nxt;
            }

            int idx = getInsertIdx();
            arr[ptr].nxt = idx;
            arr[idx].init(data, NULL);
        }
    }

    public void addAt(int idx, E data) {

    }

    // 삭제
    public void removeFirst() {

    }

    public void removeMiddle() {

    }

    public void removeLast() {

    }

    public void removeAt(int idx) {

    }

    public void removeIfDataIsEven() {

    }

    public void clear() {

    }

    // 조회
    public boolean contains(E data, Comparator<? super E> c) {
        return false;
    }

    public E getAt(int index) {
        return null;
    }

    public E getAtFromBack(int index) {
        return null;
    }

    public E getMiddle() {
        return null;
    }

    public List<E> getAll() {
        List<E> result = new ArrayList<>();

        int ptr = this.head;

        while (ptr != NULL) {
            result.add(arr[ptr].data);
            ptr = arr[ptr].nxt;
        }

        return result;
    }

    public E getStartInCycle() {
        return null;
    }

    // 수정
    public void reverse() {

    }

    public void deduplicate() {

    }

    // 문제
    public boolean isPalindrome(Comparator<? super E> c) {
        return false;
    }

    // 출력
    public void dump() {

    }

    private boolean isFull() {
        return this.size >= this.capacity;
    }

    private boolean isEmpty() {
        return this.head == NULL;
    }

    private boolean isHeadOnly() {
        return arr[this.head].nxt == NULL;
    }

    private boolean hasFreeIdx() {
        return this.dhead != NULL;
    }
}