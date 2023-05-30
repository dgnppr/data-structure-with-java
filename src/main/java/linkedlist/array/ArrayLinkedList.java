package linkedlist.array;

import linkedlist.ArrNode;

import java.util.Comparator;
import java.util.List;

public class ArrayLinkedList<E> {

    private static final int NULL = -1;
    private final int head;
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
                arr[i] = new ArrNode<E>();
            }
            this.capacity = capacity;
        } catch (OutOfMemoryError error) {
            this.capacity = 0;
        }
    }

    private int getInsertIdx() {
        if (isNotDeleted()) {
            if (this.size < this.capacity) return this.size++;
            else return NULL;
        } else {
            int delete = this.dhead;
            this.dhead = arr[delete].dnxt;
            return delete;
        }
    }

    private void deleteIdx(int idx) {
        if (isNotDeleted()) {
            this.dhead = idx;
            arr[idx].dnxt = NULL;
        } else {
            int delete = this.dhead;
            this.dhead = idx;
            arr[delete].dnxt = delete;
        }
    }

    // 삽입
    public void addAtFirst(E data) {

    }

    public void addAtLast(E data) {

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
        return null;
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


    private boolean isEmpty() {
        return this.head == NULL;
    }

    private boolean isHeadOnly() {
        return arr[this.head].nxt == NULL;
    }

    private boolean isNotDeleted() {
        return this.dhead == NULL;
    }
}