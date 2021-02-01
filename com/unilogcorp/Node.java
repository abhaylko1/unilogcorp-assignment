package com.unilogcorp;

public class Node<T> {

    T data;
    Node<T> previous;
    Node<T> next;

    Node(T t) {
        data = t;
    }

}
