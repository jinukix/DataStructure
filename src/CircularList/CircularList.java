package CircularList;

import SingleLinkedList.SingleLinkedList;

class Node <T>{
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class CircularList<T> {
    private Node<T> tail;

    public boolean isEmpty() {
        return (tail==null);
    }

    public int getSize() {
        if (isEmpty()) return 0;

        int size = 1;
        Node<T> tempNode = this.tail.next;
        while (tempNode != tail) {
            tempNode = tempNode.next;
            size++;
        }

        return size;
    }

    public void addNode(T elem) {
        Node<T> newNode = new Node<T>(elem);

        if (isEmpty()) {
            tail = newNode;
            newNode.next = tail;
            return;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
    }

    public void insertNode(int index, T elem) {
        if (index < 0 || getSize() < index) return;
        if (index == getSize()) {
            addNode(elem);
            return;
        }

        Node<T> newNode = new Node<T>(elem);
        Node<T> prevNode = tail;
        Node<T> tempNode = tail.next;

        for (int i = 0; i < index; i++) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        newNode.next = tempNode;
        prevNode.next = newNode;
    }

    public void deleteNodeByData(T elem) {
        if (isEmpty()) return;

        Node<T> prevNode = tail;
        Node<T> tempNode = tail.next;

        while (tempNode != tail) {
            if (tempNode.data == elem) {
                prevNode.next = tempNode.next;
                return;
            }

            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        if (tempNode.data == elem){
           prevNode.next = tempNode.next;
           tail = prevNode;
        }
    }

    public void deleteNodeByIndex(int index) {
        if (index < 0 || getSize() < index) return;

        Node<T> prevNode = tail;
        Node<T> tempNode = tail.next;

        for (int i = 0; i < index; i++) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        if (tempNode == tail) {
            prevNode.next = tempNode.next;
            tail = prevNode;
        } else {
            prevNode.next = tempNode.next;
        }
    }

    public T getNode(int index) {
        if (index < 0 || getSize() < index) return null;

        Node<T> tempNode = tail.next;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.data;
    }

    public void printAll() {
        System.out.print("elem: ");

        if (isEmpty()) {
            System.out.println("is empty");
            return;
        }

        Node<T> tempNode = tail.next;
        while (tempNode != tail) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.data);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularList<Integer> circularList = new CircularList<Integer>();

        for (int i = 1; i < 10; i++) {
            circularList.addNode(i);
        }

        circularList.printAll();

        circularList.insertNode(0, 0);
        circularList.insertNode(5, 55);
        circularList.insertNode(11, 111);
        circularList.printAll();

        circularList.deleteNodeByIndex(11);
        circularList.deleteNodeByIndex(0);
        circularList.deleteNodeByIndex(7);
        circularList.printAll();

        circularList.deleteNodeByData(55);
        circularList.printAll();

        System.out.println(circularList.getNode(4));
    }
}
