package ru.vsu.cs.logic;

public class SelfQueue<T> implements Queue<T> {
    private int size = 0;
    private Node<T> tail;
    private Node<T> head;

    @Override
    public boolean offer(T t) {
        if (t == null) {
            return false;
        }
        if (isEmpty()) {
            tail = new Node<>(t);
            head = tail;
        } else {
            tail.next = new Node<>(t);
            tail = tail.next;
        }
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Очередь пуста");
        }
        T el = head.item;
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return el;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T el = head.item;
        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return el;
    }

    @Override
    public T element() {
        if (isEmpty()) {
            throw new RuntimeException("Очередь пуста");
        }
        return head.item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.item;
    }

    private static class Node<E> {
        E item;
        Node next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

        Node(E element) {
            this.item = element;
            this.next = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> cur = head;
        while (cur != null) {
            stringBuilder.append(cur.item);
            stringBuilder.append(" ");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }
}
