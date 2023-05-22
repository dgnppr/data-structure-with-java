package linkedlist.singly;

import linkedlist.LinkedList;

import java.util.Comparator;
import java.util.List;

public class SinglyLinkedList<E> extends LinkedList<E> {

    @Override
    public void addAtFirst(E data) {
        head = new Node<>(data, head);
        size++;
    }

    @Override
    public void addAtFirst(Node<E> data) {
        data.nxt = head;
        size++;
    }

    @Override
    public void addAtLast(E data) {

    }

    @Override
    public void addAtLast(Node<E> data) {

    }

    @Override
    public void addAt(int idx, E data) {

    }

    @Override
    public void addAt(int idx, Node<E> data) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeMiddle() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void removeAt(int idx) {

    }

    @Override
    public void remove(Node<E> p) {

    }

    @Override
    public void removeIfDataIsEven() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E data, Comparator<? super E> c) {
        return false;
    }

    @Override
    public E getAt(int index) {
        return null;
    }

    @Override
    public E getAtFromBack(int index) {
        return null;
    }

    @Override
    public E getMiddle() {
        return null;
    }

    @Override
    public Node<E> newReversedList() {
        return null;
    }

    @Override
    public List<E> getAll() {
        return null;
    }

    @Override
    public E getStartInCycle() {
        return null;
    }

    @Override
    public E getIntersection(LinkedList<E> other) {
        return null;
    }

    @Override
    public Node<E> reverse(Node<E> head) {
        return null;
    }

    @Override
    public void purge(E data, Comparator<? super E> comparator) {

    }

    @Override
    public void deduplicate() {

    }

    @Override
    public boolean isPalindrome(Comparator<? super E> c) {
        return false;
    }

    @Override
    public Node<Integer> sum(Node<Integer> p) {
        return null;
    }

    @Override
    public void dump() {

    }
}
