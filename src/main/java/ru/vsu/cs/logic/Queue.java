package ru.vsu.cs.logic;

public interface Queue<T> {
    T element();
    boolean offer(T obj);
    T peek();
    T poll();
    T remove();
}

