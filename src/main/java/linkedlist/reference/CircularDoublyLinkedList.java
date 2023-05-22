package linkedlist.reference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CircularDoublyLinkedList<E> {

    private final Node<E> head;
    private Node<E> cur;

    public CircularDoublyLinkedList() {
        head = cur = new Node<E>();
    }


    /**
     * 선택 노드를 다음 노드로 변경
     *
     * @return 성공 true, 실패 false
     */
    public boolean next() {
        if (isEmpty() || cur.nxt == head) {
            return false;
        }
        cur = cur.nxt;
        return true;
    }

    /**
     * 선택 노드를 이전 노드로 변경
     *
     * @return 성공 true, 실패 false
     */
    public boolean prev() {
        if (isEmpty() || cur.pre == head) {
            return false;
        }
        cur = cur.pre;
        return true;
    }


    /**
     * 이중 연결리스트 데이터 탐색
     *
     * @param obj : 찾고자 하는 데이터
     * @param c   : comparator
     * @return
     */
    public E search(E obj, Comparator<? super E> c) {

        Node<E> ptr = getHeadNxt();

        while (ptr != head) {
            if (c.compare(ptr.data, obj) == 0) {
                cur = ptr;
                return obj;
            }

            ptr = ptr.nxt;
        }

        return null;
    }

    /**
     * 선택 노드 바로 뒤에 노드 삽입
     *
     * @param obj
     */
    public void add(E obj) {
        Node<E> node = new Node<>(obj, cur, cur.nxt);
        cur.nxt = cur.nxt.pre = node;
        cur = node;
    }

    /**
     * 가장 앞에 노드 추가
     *
     * @param obj
     */
    public void addFirst(E obj) {
        cur = head;
        add(obj);
    }

    /**
     * 가장 마지막에 노드 추가
     *
     * @param obj
     */
    public void addLast(E obj) {
        cur = getHeadPre();
        add(obj);
    }


    /**
     * 선택 노드 삭제
     */
    public void removeCur() {
        if (isEmpty()) {
            return;
        }

        cur.pre.nxt = cur.nxt;
        cur.nxt.pre = cur.pre;

        cur = cur.pre;

        if (cur == head) {
            cur = head.nxt;
        }
    }

    /**
     * 특정 노드 삭제
     *
     * @param p: 삭제할 노드
     */
    public void remove(Node<E> p) {
        if (isEmpty()) {
            return;
        }

        Node<E> ptr = getHeadNxt();

        while (ptr != head) {
            if (ptr == p) {
                cur = p;
                removeCur();
                break;
            }

            ptr = ptr.nxt;
        }
    }

    /**
     * 헤드 노드 삭제
     */
    public void removeFirst() {
        cur = getHeadNxt();
        removeCur();
    }

    /**
     * 꼬리 노드 삭제
     */
    public void removeLast() {
        cur = getHeadPre();
        removeCur();
    }

    /**
     * 모든 노드 삭제
     */
    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }

    public List<E> getAllNodeData() {
        if (isEmpty()) {
            return null;
        }

        Node<E> ptr = getHeadNxt();
        List<E> result = new ArrayList<>();

        while (ptr != head) {
            result.add(ptr.data);
            ptr = ptr.nxt;
        }

        return result;
    }


    /**
     * 연결리스트 모든 노드의 데이터 출력
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("List Empty");
            return;
        }

        Node<E> ptr = getHeadNxt();

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.nxt;
        }
    }

    private Node<E> getHeadPre() {
        return head.pre;
    }

    private Node<E> getHeadNxt() {
        return head.nxt;
    }

    private boolean isEmpty() {
        return head.nxt == head;
    }

    static class Node<E> {

        E data;
        Node<E> pre;
        Node<E> nxt;


        public Node() {
            data = null;
            pre = nxt = this;
        }

        /**
         * @param data: data
         * @param pre:  previous node
         * @param nxt:  next node
         */
        public Node(E data, Node<E> pre, Node<E> nxt) {
            this.data = data;
            this.pre = pre;
            this.nxt = nxt;
        }

    }


}
