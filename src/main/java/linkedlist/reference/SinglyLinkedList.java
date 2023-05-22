package linkedlist.reference;

import java.util.*;

public class SinglyLinkedList<E> extends LinkedList<E> {


    /**
     * 데이터 탐색
     *
     * @param data: 탐색 데이터
     * @param c:    comparator
     * @return 탐색 데이터
     */
    @Override
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
    @Override
    public void addFirst(E data) {
        head = new Node<>(data, head);
        size++;
    }


    @Override
    public void addNodeAtFirst(Node<E> node) {
        node.nxt = head;
        head = node;
        size++;
    }

    /**
     * 꼬리 노드 추가
     *
     * @param data
     */
    @Override
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

    @Override
    public void addNodeAtLast(Node<E> node) {
        if (isEmpty()) {
            addNodeAtFirst(node);
            return;
        }

        Node<E> ptr = this.head;

        while (ptr.nxt != null) {
            ptr = ptr.nxt;
        }

        ptr.nxt = node;
        size++;
    }

    /**
     * 머리 노드 삭제
     */
    @Override
    public void removeFirst() {
        if (isEmpty()) return;

        head = head.nxt;
        size--;
    }

    /**
     * 꼬리 노드 삭제
     */
    @Override
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
    @Override
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
     * 짝수 정수를 가진 노드 삭제
     */
    @Override
    public void removeEvenData() {
        if (isEmpty() || !(head.data instanceof Integer)) return;

        Node<E> cur = head;
        Node<E> pre = null;

        while (cur != null) {
            if ((int) cur.data % 2 == 0) {
                if (pre == null) head = cur.nxt;
                else pre.nxt = cur.nxt;
            } else {
                pre = cur;
            }
            cur = cur.nxt;
        }
    }


    /**
     * 사이클 시작점 데이터 반환
     *
     * @return
     */
    @Override
    public E getFirstDataInCycle() {
        if (isEmpty() || isHeadOnly()) return null;

        Node<E> slow = head;
        Node<E> fast = head.nxt;

        // 1. 사이클 찾기
        while (slow != fast) {
            if (fast == null || fast.nxt == null) return null;
            slow = slow.nxt;
            fast = fast.nxt.nxt;
        }

        // 2. 사이클 시작점 데이터 리턴
        slow = head;
        while (slow != fast.nxt) {
            slow = slow.nxt;
            fast = fast.nxt;
        }

        return slow.data;
    }


    /**
     * 연결 리스트의 모든 데이터 조회
     *
     * @return 데이터 List
     */
    @Override
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
     * 연결 리스트 뒤집어서 반환
     *
     * @return 데이터 List
     */
    @Override
    public SinglyLinkedList<E> getNewReverseLinkedList() {
        if (isEmpty()) return null;

        Node<E> ptr = head;
        SinglyLinkedList<E> ret = new SinglyLinkedList<>();

        while (ptr != null) {
            ret.addFirst(ptr.data);
            ptr = ptr.nxt;
        }

        return ret;
    }


    @Override
    public Node<E> reverseList(Node<E> head) {
        Node<E> prev = null;
        Node<E> cur = head;

        while (cur != null) {
            Node<E> nxt = cur.nxt;
            cur.nxt = prev;
            prev = cur;
            cur = nxt;
        }

        return prev;
    }


    /**
     * 정수형 연결 리스트의 합
     *
     * @param list2: 정수형 연결 리스트
     * @return
     */
    @Override
    public SinglyLinkedList<Integer> sumOfIntegerLinkedList(SinglyLinkedList<Integer> list2) {
        if (this.isEmpty() && list2.isEmpty()) return null;
        else if (this.isEmpty() || list2.isEmpty()) return this.isEmpty() ? list2 : (SinglyLinkedList<Integer>) this;

        Node<Integer> ptr1 = (Node<Integer>) this.head;
        Node<Integer> ptr2 = list2.head;
        SinglyLinkedList<Integer> ret = new SinglyLinkedList<>();

        int extra = 0;
        while (ptr1 != null && ptr2 != null) {
            int sum = ptr1.data + ptr2.data + extra;

            if (sum < 10) extra = 0;
            else extra = 1;

            ret.addFirst(sum % 10);

            ptr1 = ptr1.nxt;
            ptr2 = ptr2.nxt;
        }

        while (ptr1 != null) {
            int sum = ptr1.data + extra;

            if (sum < 10) extra = 0;
            else extra = 1;

            ret.addFirst(sum % 10);
            ptr1 = ptr1.nxt;
        }

        while (ptr2 != null) {
            int sum = ptr2.data + extra;

            if (sum < 10) extra = 0;
            else extra = 1;

            ret.addFirst(sum % 10);
            ptr2 = ptr2.nxt;
        }

        if (extra > 0) {
            ret.addFirst(extra);
        }

        return ret.getNewReverseLinkedList();
    }

    /**
     * 회문 테스트
     *
     * @param c: comparator
     * @return 회문이면 true 아니면 false
     */
    @Override
    public boolean isPalindrome(Comparator<? super E> c) {

        if (isEmpty()) return false;
        else if (isHeadOnly()) return true;

        Node<E> slow = head;
        Node<E> fast = head;

        // 1. 중간 지점 찾기 찾는다
        while (fast != null && fast.nxt != null) {
            slow = slow.nxt;
            fast = fast.nxt.nxt;
        }

        // 2. 중간 지점 이후의 노드들을 역순으로 뒤집는다.
        Node<E> reversedHead = reverseList(slow);

        // 3. 앞쪽과 뒤쪽의 노드들을 순차적으로 비교
        Node<E> p1 = head;
        Node<E> p2 = reversedHead;

        while (p1 != null && p2 != null) {
            if (c.compare(p1.data, p2.data) != 0) return false;

            p1 = p1.nxt;
            p2 = p2.nxt;
        }

        return true;
    }

    /**
     * 같은 데이터 중 맨 앞 노드만 남기고 나머지 삭제
     *
     * @param data: 삭제 데이터
     * @param c:    comparator
     */
    @Override
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
    @Override
    public E getAt(int k) {
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
     * 뒤에서 k번째 원소 데이터 조회
     *
     * @param k: 인덱스
     * @return 헤드 노드에서 idx 뒤에 위치한 노드의 데이터
     */
    @Override
    public E getAtFromBack(int k) {
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
    @Override
    public E getMiddleNodeData() {
        return getAt(size / 2);
    }

    /**
     * 교집합 노드 조회
     *
     * @param other 비교 연결 리스트
     * @return 교집합 노드 Set
     */
    @Override
    public Node<E> getIntersectionNode(LinkedList<E> other) {
        if (this.isEmpty() || other.isEmpty()) return null;

        Set<Node<E>> nodeSet = new HashSet<>();

        Node<E> ptr = this.head;

        while (ptr != null) {
            nodeSet.add(ptr);
            ptr = ptr.nxt;
        }

        Node<E> otherPtr = other.head;
        while (otherPtr != null) {
            if (nodeSet.contains(otherPtr)) return otherPtr;
            otherPtr = otherPtr.nxt;
        }
        return null;
    }

    /**
     * 중복 없애기
     */
    @Override
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

    /**
     * 연결 리스트 처음부터 모든 노드의 데이터 출력
     */
    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("LinkedList is Empty");
            return;
        }

        StringBuilder sb = new StringBuilder();
        Node<E> ptr = head;
        while (ptr != null) {
            sb.append(ptr.data + " ");
            ptr = ptr.nxt;
        }
        System.out.println(sb);
    }

    @Override
    public void clear() {
        if (isEmpty()) return;

        while (!isEmpty()) {
            removeFirst();
        }
    }


}
