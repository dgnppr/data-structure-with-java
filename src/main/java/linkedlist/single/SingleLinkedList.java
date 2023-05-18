package linkedlist.single;

import java.util.*;

public class SingleLinkedList<E> {

    protected Node<E> head;
    protected int size;

    /**
     * 데이터 탐색
     *
     * @param data: 탐색 데이터
     * @param c:    comparator
     * @return 탐색 데이터
     */
    public E search(E data, Comparator<? super E> c) {

        if (isEmpty()) return null;

        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(ptr.data, data) == 0) {
                return ptr.data;
            }
            ptr = ptr.nxt;
        }
        return null;
    }

    /**
     * 헤드 노드 추가
     *
     * @param data
     */
    public void addFirst(E data) {
        head = new Node<>(data, head);
        size++;
    }

    /**
     * 꼬리 노드 추가
     *
     * @param data
     */
    public void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<E> ptr = head;
            while (ptr.nxt != null) {
                ptr = ptr.nxt;
            }
            ptr.nxt = new Node<>(data, null);
            size++;
        }
    }

    /**
     * 머리 노드 삭제
     */
    public void removeFirst() {
        if (isEmpty()) return;

        head = head.nxt;
        size--;
    }

    /**
     * 꼬리 노드 삭제
     */
    public void removeLast() {
        if (isEmpty()) return;

        if (isHeadOnly()) {
            removeFirst();
        } else {
            Node<E> ptr = head;
            Node<E> pre = head;

            while (ptr.nxt != null) {
                pre = ptr;
                ptr = ptr.nxt;
            }

            pre.nxt = null;
            size--;
        }
    }

    /**
     * 선택 노드 삭제 메소드
     *
     * @param p: 선택 노드
     */
    public void remove(Node<E> p) {
        if (isEmpty()) return;

        if (p == head) {
            removeFirst();
        } else {
            Node<E> ptr = head;
            while (ptr.nxt != p) {
                ptr = ptr.nxt;
                if (ptr == null) {
                    return;
                }
            }
            ptr.nxt = p.nxt;
            size--;
        }
    }

    /**
     * 연결 리스트의 모든 데이터 조회
     *
     * @return 데이터 List
     */
    public List<E> getAllNodeData() {
        if (isEmpty()) {
            return null;
        }

        List<E> result = new ArrayList<>();
        Node<E> ptr = head;

        while (ptr != null) {
            result.add(ptr.data);
            ptr = ptr.nxt;
        }

        return result;
    }


    /**
     * 같은 데이터 중 맨 앞 노드만 남기고 나머지 삭제
     *
     * @param data: 삭제 데이터
     * @param c:    comparator
     */
    public void purge(E data, Comparator<? super E> c) {

        if (isEmpty()) return;

        Node<E> ptr = head;
        int cnt = 0;

        while (ptr != null) {
            if (c.compare(ptr.data, data) == 0) {
                if (cnt >= 1) {
                    remove(ptr);
                }

                cnt++;
            }
            ptr = ptr.nxt;
        }
    }

    /**
     * 앞에서 k번째 원소 데이터 조회
     *
     * @param k: 인덱스
     * @return 헤드 노드에서 idx 뒤에 위치한 노드의 데이터
     */
    public E getDataFromFront(int k) {
        if (isEmpty() || k > size) return null;

        Node<E> ptr = head;
        int idx = 0;

        while (ptr != null && idx <= k) {
            if (idx == k) {
                return ptr.data;
            }
            ptr = ptr.nxt;
            idx++;
        }

        return null;
    }

    /**
     * 뒤에서 k번쨰 원소 데이터 조회
     *
     * @param k: 인덱스
     * @return 헤드 노드에서 idx 뒤에 위치한 노드의 데이터
     */
    public E getDataFromBack(int k) {
        if (isEmpty() || k > size || k < 0) return null;

        k = (size - k - 1);
        Node<E> ptr = head;
        int idx = 0;

        while (ptr != null && idx <= k) {
            if (idx == k) {
                return ptr.data;
            }
            ptr = ptr.nxt;
            idx++;
        }

        return null;
    }

    /**
     * 중간 위치 노드 데이터 조회
     *
     * @return 중간 위치 노드 데이터
     */
    public E getMiddleNodeData() {
        return getDataFromFront(size / 2);
    }

    /**
     * 연결 리스트 중복 없애기
     */
    public void deduplicate() {
        if (isEmpty()) return;

        Set<E> nodeDataSet = new HashSet<>();
        Node<E> ptr = head;

        while (ptr != null) {
            if (nodeDataSet.contains(ptr.data)) {
                remove(ptr);
            } else {
                nodeDataSet.add(ptr.data);
            }
            ptr = ptr.nxt;
        }
    }

    public void clear() {
        if (isEmpty()) return;

        while (!isEmpty()) {
            removeFirst();
        }
    }


    protected boolean isHeadOnly() {
        return head.nxt == null;
    }

    protected boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    static class Node<E> {
        protected final E data;
        protected Node<E> nxt;

        public Node(E data, Node<E> nxt) {
            this.data = data;
            this.nxt = nxt;
        }
    }

}
