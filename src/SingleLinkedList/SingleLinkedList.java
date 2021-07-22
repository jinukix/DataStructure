package SingleLinkedList;

class Node <T>{
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class SingleLinkedList<T>{
    private Node<T> head;

    public boolean isEmpty() {
        return (getSize() == 0);
    }

    public int getSize() {
        int size = 0;
        Node<T> tempNode = this.head;
        while (tempNode!=null) {
            size++;
            tempNode = tempNode.next;
        }

        return size;
    }

    public void addNode(T elem) {
        Node<T> newNode = new Node<>(elem);

        if(isEmpty()) {
            this.head = newNode;
            return;
        }

        Node<T> tempNode = this.head;
        while (tempNode.next!=null){
            tempNode=tempNode.next;
        }
        tempNode.next = newNode;
    }

    public void insertNode(int index, T elem) {
        if (index < 0 || getSize() < index) return;

        Node<T> newNode = new Node<T>(elem);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> tempNode = this.head;
        Node<T> prevNode = null;

        for (int i = 0; i < index; i++) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        prevNode.next = newNode;
        newNode.next = tempNode;
    }

    public void updateNode(int index, T elem) {
        if (index < 0 || getSize() < index) return;

        Node<T> tempNode = head;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        tempNode.data = elem;
    }

    public void deleteNodeByData(T elem) {
        if (isEmpty()) return;

        Node<T> tempNode = head;
        Node<T> prevNode = null;

        if (tempNode.data == elem) {
            head = tempNode.next;
            return;
        }

        while (tempNode != null) {
            if (tempNode.data == elem) {
                prevNode.next = tempNode.next;
                return;
            }

            prevNode = tempNode;
            tempNode = tempNode.next;
        }
    }

    public void deleteNodeByIndex(int index) {
        if (index < 0 || getSize() < index+1) return;

        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> tempNode = head;
        Node<T> prevNode = null;

        for (int i = 0; i < index; i++) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        prevNode.next = tempNode.next;
    }

    public T getNodeDataByIndex(int index) {
        Node<T> tempNode = head;

        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }

        return tempNode.data;
    }

    public void printAll() {
        Node<T> tempNode = head;

        System.out.println("elem: ");
        for (int i = 0; i < getSize(); i++) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> singlelist = new SingleLinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            singlelist.addNode(i);
        }

        singlelist.printAll();
        singlelist.updateNode(0, -1);
        singlelist.updateNode(9, 99);
        singlelist.printAll();
        singlelist.insertNode(0, -11);
        singlelist.insertNode(5, 55);
        singlelist.insertNode(12, 111);
        singlelist.printAll();
        singlelist.deleteNodeByData(55);
        singlelist.deleteNodeByData(-11);
        singlelist.deleteNodeByData(111);
        singlelist.printAll();
        singlelist.deleteNodeByIndex(0);
        singlelist.deleteNodeByIndex(8);
        singlelist.printAll();
        System.out.println(singlelist.getNodeDataByIndex(0));
        System.out.println(singlelist.getNodeDataByIndex(7));
    }
}
