package DoubleLinkedList;

class Node <T>{
    T data;
    Node<T> front;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class DoubleLinkedList <T> {
    private Node<T> head;
    private Node<T> tail;

    public boolean isEmpty() {return head==null;}

    public int getSize() {
        int size = 0;
        Node<T> tempNode = this.head;
        while (tempNode!=null) {
            size++;
            tempNode = tempNode.next;
        }

        return size;
    }

    public void printAll() {
        Node<T> tempNode = head;

        System.out.print("elem: ");
        for (int i = 0; i < getSize(); i++) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void pushBack(T elem) {
        Node<T> newNode = new Node<T>(elem);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.front = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void pushFront(T elem) {
        Node<T> newNode = new Node<T>(elem);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.next = head;
        head.front = newNode;
        head = newNode;
    }

    public T popBack() {
        T data = tail.data;
        tail = tail.front;
        tail.next = null;
        return data;
    }

    public T popFront() {
        T data = head.data;
        head = head.next;
        head.front = null;
        return data;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleList = new DoubleLinkedList<Integer>();
        for (int i = 1; i < 10; i++) {
            doubleList.pushBack(i);
        }
        doubleList.printAll();
        for (int i = 1; i < 10; i++) {
            doubleList.pushFront(-i);
        }
        doubleList.printAll();
        System.out.println(doubleList.popBack());
        doubleList.printAll();
        System.out.println(doubleList.popFront());
        doubleList.printAll();
    }
}

