package linkedlist.array;

import linkedlist.ArrNode;

import java.util.*;

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

    private void delete(int idx) {
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
        if (!(0 <= idx && idx < this.size) || isFull()) return;

        if (idx == 0) {
            addAtFirst(data);
        } else {
            int cur = this.head;
            int pre = this.head;
            int cnt = 0;

            while (cur != NULL) {
                if (cnt == idx) {
                    int insertIdx = getInsertIdx();
                    arr[insertIdx].init(data, arr[pre].nxt);
                    arr[pre].nxt = insertIdx;
                    return;
                }
                pre = cur;
                cur = arr[cur].nxt;
                cnt++;
            }
        }

    }

    // 삭제
    public void removeFirst() {
        if (isEmpty()) return;

        int idx = this.head;
        this.head = arr[idx].nxt;
        delete(idx);
    }

    public void removeLast() {
        if (isEmpty()) return;

        if (isHeadOnly()) {
            removeFirst();
        } else {
            int cur = this.head;
            int pre = this.head;

            while (arr[cur].nxt != NULL) {
                pre = cur;
                cur = arr[cur].nxt;
            }
            arr[pre].nxt = NULL;
            delete(cur);
        }
    }

    public void removeMiddle() {
        if (isEmpty()) return;
        if (isHeadOnly()) removeFirst();

        int fast = this.head;
        int slow = this.head;
        int pre = this.head;

        while (fast != NULL && arr[fast].nxt != NULL) {
            fast = arr[arr[fast].nxt].nxt;
            pre = slow;
            slow = arr[slow].nxt;
        }

        arr[pre].nxt = arr[slow].nxt;
        delete(slow);
    }

    public void removeAt(int idx) {
        if (isEmpty() || idx < 0 || idx >= this.capacity) return;

        int cur = this.head;
        int pre = this.head;
        int cnt = 0;

        while (cur != NULL) {
            if (cnt == idx) {
                break;
            }
            pre = cur;
            cur = arr[cur].nxt;
            cnt++;
        }

        arr[pre].nxt = arr[cur].nxt;
        delete(cur);
    }

    public void removeIfDataIsEven() {
        if (isEmpty() || !(arr[head].data instanceof Integer)) return;

        int cur = this.head;
        int pre = NULL;

        while (cur != NULL) {
            if ((int) arr[cur].data % 2 == 0) {
                if (pre == NULL) {
                    this.head = arr[head].nxt;
                } else {
                    arr[pre].nxt = arr[cur].nxt;
                }
                delete(cur);
            } else {
                pre = cur;
            }
            cur = arr[cur].nxt;
        }

    }

    public void clear() {
        if (isEmpty()) return;

        int ptr = this.head;
        while (ptr != NULL) {
            ptr = arr[ptr].nxt;
            removeFirst();
        }

    }

    // 조회
    public boolean contains(E data, Comparator<? super E> c) {
        if (isEmpty()) return false;

        int ptr = this.head;

        while (ptr != NULL) {
            if (c.compare(arr[ptr].data, data) == 0) {
                return true;
            }
            ptr = arr[ptr].nxt;
        }

        return false;
    }

    public E getAt(int index) {
        if (isEmpty() || index < 0 || index > this.capacity) return null;

        int ptr = this.head;
        int cnt = 0;
        while (ptr != NULL) {
            if (cnt == index) return arr[ptr].data;
            ptr = arr[ptr].nxt;
            cnt++;
        }

        return null;
    }

    public E getAtFromBack(int index) {
        if (isEmpty() || index < 0 || index > this.capacity) return null;

        int ptr = this.head;
        int total = 0;

        while (ptr != NULL) {
            ptr = arr[ptr].nxt;
            total++;
        }

        return getAt(total - index - 1);
    }

    public E getMiddle() {
        if (isEmpty()) return null;

        int fast = this.head;
        int slow = this.head;

        while (fast != NULL && arr[fast].nxt != NULL) {
            fast = arr[arr[fast].nxt].nxt;
            slow = arr[slow].nxt;
        }

        return arr[slow].data;
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

    // 수정
    public void reverse() {
        if (isEmpty()) return;

        int cur = this.head;
        int pre = NULL;

        while (cur != NULL) {
            int nxt = arr[cur].nxt;
            arr[cur].nxt = pre;
            pre = cur;
            if (nxt == NULL) this.head = cur;
            cur = nxt;
        }
    }

    public void deduplicate() {
        if (isEmpty()) return;

        Set<E> vis = new HashSet<>();
        int cur = this.head;
        int pre = this.head;

        while (cur != NULL) {
            if (vis.contains(arr[cur].data)) {
                arr[pre].nxt = arr[cur].nxt;
                delete(cur);
            } else {
                vis.add(arr[cur].data);
                pre = cur;
            }
            cur = arr[cur].nxt;
        }
    }

    // 문제
    public boolean isPalindrome(Comparator<? super E> c) {
        if (isEmpty()) return false;
        if (isHeadOnly()) return true;

        int fast = this.head;
        int slow = this.head;

        while (fast != NULL && arr[fast].nxt != NULL) {
            fast = arr[arr[fast].nxt].nxt;
            slow = arr[slow].nxt;
        }

        int cur = slow;
        int pre = NULL;
        while (cur != NULL) {
            int nxt = arr[cur].nxt;
            arr[cur].nxt = pre;
            pre = cur;
            cur = nxt;
        }

        int ptr = this.head;
        while (pre != NULL && ptr != NULL) {
            if (c.compare(arr[pre].data, arr[ptr].data) != 0) return false;
            ptr = arr[ptr].nxt;
            pre = arr[pre].nxt;
        }

        return true;
    }

    public void dump() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        int ptr = this.head;
        StringBuilder rst = new StringBuilder();
        while (ptr != NULL) {
            rst.append(arr[ptr].data).append(" ");
            ptr = arr[ptr].nxt;
        }
        System.out.println(rst);
    }

    private boolean isFull() {
        return this.size >= this.capacity && !hasFreeIdx();
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