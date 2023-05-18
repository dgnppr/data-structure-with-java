package linkedlist.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayLinkedList<E> {

    private static final int NULL = -1;
    private Node<E>[] arr; // 리스트
    private int capacity; // 리스트 용량
    private int size; // 사용중인 인덱스 개수
    private int head; // 머리 노드
    private int cur; // 선택 노드
    private int deleted; // 프리 리스트의 머리 노드

    /**
     * capacity 만큼의 배열 할당
     *
     * @param capacity: 리스트 사이즈
     */
    public ArrayLinkedList(int capacity) {
        head = size = cur = deleted = NULL;

        try {
            arr = new Node[capacity];
            for (int i = 0; i < capacity; i++) {
                arr[i] = new Node<E>();
            }
            this.capacity = capacity;
        } catch (OutOfMemoryError error) {
            this.capacity = 0;
        }
    }

    /**
     * @return 다음에 삽입할 record의 인덱스
     */
    private int getInsertIdx() {
        if (isNotDeleted()) { // 삭제한 record가 없음
            if (size < capacity) {
                return ++size; // 새로운 record 사용
            } else {
                return NULL; // 용량 넘침
            }
        } else {
            int rec = deleted; // 프리 리스트에서
            deleted = arr[rec].dnxt; // 머리 rec을 꺼냄
            return rec;
        }
    }

    /**
     * @param idx: record idx를 프리 리스트에 등록
     */
    private void deleteIdx(int idx) {
        if (isNotDeleted()) { // 삭제한 record가 없음
            deleted = idx; // idx를 프리리스트의
            arr[idx].dnxt = NULL; // 머리에 등록
        } else {
            int rec = deleted; // idx를 프리리스트의
            deleted = idx; // 머리에 삽입
            arr[idx].dnxt = rec;
        }
    }

    /**
     * 노드 검색 메소드
     *
     * @param obj: 찾고자 하는 데이터
     * @param c:   E comparator
     * @return
     */
    public E search(E obj, Comparator<? super E> c) {
        int ptr = head;

        while (ptr != NULL) {
            if (c.compare(arr[ptr].data, obj) == 0) {
                cur = ptr;
                return arr[ptr].data; // 검색 성공
            }

            ptr = arr[ptr].nxt; // 다음 노드로 이동
        }

        return null;
    }

    /**
     * 헤드에 노드를 삽입
     *
     * @param obj
     */
    public void addFirst(E obj) {
        int ptr = head;

        int insertIdx = getInsertIdx();

        if (insertIdx != NULL) {
            head = cur = insertIdx;
            arr[head].init(obj, ptr);
        }
    }

    /**
     * 꼬리에 노드를 삽입
     *
     * @param obj
     */
    public void addLast(E obj) {
        if (isEmpty()) {
            addFirst(obj);
        } else {
            int ptr = head;
            while (arr[ptr].nxt != NULL) {
                ptr = arr[ptr].nxt;
            }

            int insertIdx = getInsertIdx();
            if (insertIdx != NULL) {
                arr[ptr].nxt = cur = insertIdx;
                arr[insertIdx].init(obj, NULL);
            }
        }
    }

    /**
     * 헤드 노드 삭제
     */
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        int ptr = arr[head].nxt;
        deleteIdx(head);
        head = cur = ptr;
    }

    /**
     * 꼬리 노드 삭제
     */
    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        if (isHeadOnly()) {
            removeFirst();
        } else {
            int ptr = head;
            int pre = head;

            while (arr[ptr].nxt != NULL) {
                pre = ptr;
                ptr = arr[ptr].nxt;
            }

            arr[pre].nxt = NULL;
            deleteIdx(ptr);
            cur = pre;
        }
    }

    /**
     * record p를 삭제
     *
     * @param p
     */
    public void remove(int p) {
        if (isEmpty()) {
            return;
        }

        if (p == head) {
            removeFirst();
        } else {
            int ptr = head;

            while (arr[ptr].nxt != p) {
                ptr = arr[ptr].nxt;
                if (ptr == NULL) {
                    return;
                }
            }

            arr[ptr].nxt = arr[p].nxt;
            deleteIdx(p);
            cur = ptr;
        }
    }

    /**
     * 현재 노드를 삭제
     */
    public void removeCurNode() {
        remove(cur);
    }

    /**
     * 모든 노드 삭제
     */
    public void clear() {
        while (head != NULL) {
            removeFirst();
        }
        cur = NULL;
    }

    /**
     * 모든 노드 출력
     */
    public void dump() {
        int ptr = head;
        while (ptr != NULL) {
            System.out.println(arr[ptr].data);
            ptr = arr[ptr].nxt;
        }
    }

    public List<E> getAllNodeData() {

        if (isEmpty()) {
            return null;
        }

        List<E> result = new ArrayList<>();
        int ptr = head;
        while (ptr != NULL) {
            result.add(arr[ptr].data);
            ptr = arr[ptr].nxt;
        }

        return result;
    }

    private boolean isHeadOnly() {
        return arr[head].nxt == NULL;
    }

    private boolean isNotDeleted() {
        return deleted == NULL;
    }

    private boolean isEmpty() {
        return head == NULL;
    }


    class Node<E> {
        private E data; // 데이터
        private int nxt; // next 노드 인덱스
        private int dnxt; // 삭제 리스트의 next 노드 인덱스

        void init(E data, int nxt) {
            this.data = data;
            this.nxt = nxt;
        }
    }


}
