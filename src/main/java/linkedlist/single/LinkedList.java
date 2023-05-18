package linkedlist.single;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class LinkedList<E> {

    protected Node<E> head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * 연결리스트 데이터 탐색 메소드
     *
     * @param obj: 찾고자 하는 데이터
     * @param c:   Comparator
     * @return: 찾으면 data, 없으면 null
     */
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                return ptr.data;
            }
            ptr = ptr.next;
        }

        return null;
    }

    /**
     * 연결리스트 꼬리 노드 추가 메소드
     *
     * @param obj: 추가 데이터
     */
    public void addFirst(E obj) {
        head = new Node<>(obj, head);
    }

    /**
     * 연결리스트 꼬리 노드 추가 메소드
     *
     * @param obj: 추가 데이터
     */
    public void addLast(E obj) {
        if (isEmpty()) {
            addFirst(obj);
        } else {
            Node<E> ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }

            ptr.next = new Node<>(obj, null);
        }
    }

    /**
     * 헤드 노드 삭제 메소드
     */
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        head = head.next;
    }

    /**
     * 꼬리 노드 삭제 메소드
     */
    public void removeLast() {

        if (isEmpty()) {
            return;
        }

        if (isHeadOnly()) {
            removeFirst();
        } else {
            Node<E> ptr = head;
            Node<E> pre = head;

            while (ptr.next != null) {
                pre = ptr;
                ptr = ptr.next;
            }

            pre.next = null;
        }
    }

    /**
     * 선택 노드 삭제 메소드
     *
     * @param p: 선택 노드
     */
    public void remove(Node<E> p) {
        if (isEmpty()) {
            return;
        }

        if (p == head) {
            removeFirst();
        } else {
            Node<E> ptr = head;

            while (ptr.next != p) {
                ptr = ptr.next;
                if (ptr == null) {
                    return;
                }
            }

            ptr.next = p.next;
        }
    }

    /**
     * n번째에 존재하는 노드의 데이터 반환 메소드
     *
     * @param n
     * @return: n번째에 존재하는 노드의 데이터 반환
     */
    public E retrieve(int n) {
        int cnt = 0;

        if (n < 0 || isEmpty()) {
            return null;
        }

        Node<E> ptr = head;

        while (ptr != null) {
            if (cnt == n) {
                return ptr.data;
            }

            ptr = ptr.next;
            cnt++;
        }

        return null;
    }

    /**
     * 모든 노드 삭제 메소드
     */
    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }

    /**
     * 모든 노드 데이터 출력
     */
    public void dump() {
        Node<E> ptr = head;

        StringBuilder sb = new StringBuilder();
        while (ptr != null) {
            sb.append(ptr.data + " ");
            ptr = ptr.next;
        }

        System.out.println(sb);
    }

    /**
     * 모든 노드 데이터 리턴 메소드
     *
     * @return 모든 노드 데이터
     */
    public List<E> getAllNodeData() {
        if (isEmpty()) {
            return null;
        }

        Node<E> ptr = head;
        List<E> result = new ArrayList<>();

        while (ptr != null) {
            result.add(ptr.data);
            ptr = ptr.next;
        }

        return result;
    }

    /**
     * 같은 데이터 중 맨 앞 노드만 남기고 나머지 삭제
     *
     * @param obj: 데이터
     */
    public void purge(E obj, Comparator<? super E> c) {
        if (isEmpty()) {
            return;
        }

        Node<E> ptr = head;

        int cnt = 0;

        while (ptr != null) {
            Node<E> nxt = ptr.next;

            if (ptr.data == obj) {
                cnt++;

                if (cnt >= 2) {
                    remove(ptr);
                }
            }
            ptr = nxt;
        }

    }


    private boolean isHeadOnly() {
        return head.next == null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}

