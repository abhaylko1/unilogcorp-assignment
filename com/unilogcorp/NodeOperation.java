package com.unilogcorp;

public class NodeOperation<T> {

    private Node<T> head, tail = null;
    private int size = 0;

    public void addFirst(T t) {
        Node<T> newNode = getNodeInstance(t, null, head);
        if (head != null) {
            head.previous = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T t) {
        Node<T> newNode = getNodeInstance(t, tail, null);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        size++;
    }

    public void addAtIndex(T t, int index) {

        // check if doubly linked list is empty or insertion index is 1
        if (head == null || index == 1) {
            addFirst(t);
        }
        // check if doubly linked list is empty and insertion index >1 i.e size of
        // doubly linked list
        else if (head == null && index > 1) {
            throw new RuntimeException("Doubly linked list is empty and insertion index is greater than 1");
        } else if (index == size + 1) {
            addLast(t);
        } else {
            Node<T> insertNode = getNodeInstance(t, null, null);
            Node<T> tempNode = head;
            for (int i = 1; i <= size; i++) {
                if (i == index - 1) {
                    insertNode.next = tempNode.next;
                    tempNode.next = insertNode;
                    insertNode.previous = tempNode;
                    if (insertNode.next != null) {
                        insertNode.next.previous = insertNode;
                    }
                    size++;
                    break;
                }
                tempNode = tempNode.next;
            }
        }

    }

    public Node<T> removeFirst() {

        // check if doubly linked list is empty
        if (size == 0) {
            throw new RuntimeException("Doubly linked list is empty.");
        }

        // remove first node if doubly linked list is not empty
        Node<T> firstNode = head;
        head = head.next;
        head.previous = null;
        size--;
        return firstNode;
    }

    public Node<T> removeLast() {

        // check if doubly linked list is empty
        if (size == 0) {
            throw new RuntimeException("Doubly linked list is empty.");
        }

        // remove last node if doubly linked list is not empty
        Node<T> lastNode = tail;
        if (size == 1) {
            tail = head = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return lastNode;
    }

    public Node<T> removeAtIndex(int index) {

        // check and remove if it is first element
        if (index == 1) {
            return removeFirst();
        }

        // check if delete index > size of doubly linked list then throw error
        if (index > size) {
            throw new RuntimeException("Invalid index. Index is greater than size of doubly linked list.");
        }

        // check and remove if it is last element
        if (index == size) {
            return removeLast();
        }

        // check and remove at any arbitrary index in doubly linked list
        Node<T> removeNode = getNodeInstance(null, null, null);
        Node<T> tempNode = head;
        for (int i = 1; i <= size; i++) {
            if (i == index - 1) {
                removeNode = tempNode;
                tempNode.previous = tempNode.next.previous;
                tempNode.next = tempNode.next.next;
                size--;
                break;
            }
            tempNode = tempNode.next;
        }
        return removeNode;
    }

    public int search(T t) {
        int position = -1;
        Node<T> node = head;

        // check if node is null
        if (node == null) {
            return position;
        }

        // check node if it doesn't have given element and find its position
        while (node.data != t && node.next != null) {
            ++position;
            node = node.next;
        }
        // check for last node if it doesn't contains the given element then return -1
        // else add +1 in position
        if (node.data != t) {
            return -1;
        }
        ++position;
        // return position of given element if found
        return (position + 1);
    }

    // to create instance of node
    private Node<T> getNodeInstance(T t, Node<T> previous, Node<T> next) {
        Node<T> newNode = new Node<T>(t);
        newNode.previous = previous;
        newNode.next = next;
        return newNode;
    }

    public void display() {

        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Doubly Linked List :- ");
        Node<T> temp = head;
        while (temp != null && temp.next != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.println(temp.data);

    }

}
