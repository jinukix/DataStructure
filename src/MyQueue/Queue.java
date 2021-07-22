package MyQueue;

class Node <T>{
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

public class Queue<T>{
    private Node<T> head;
    private Node<T> tail;
    private int count;

    Queue() { clear(); }

    public boolean isEmpty() {
        return (count==0);
    }

    public void enqueue(T elem) {
        Node<T> newNode = new Node<>(elem);

        if (isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.count++;
    }

    public T dequeue() {
        if(isEmpty()) {
            return null;
        }

        T data;
        if (this.head == this.tail) {
            data = this.head.data;
            this.head = null;
            this.tail = null;
            this.count = 0;
            return data;
        }

        Node<T> tempNode = this.head;
        data = tempNode.data;
        this.head = tempNode.next;
        this.count--;

        return data;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }

        return this.head.data;
    }

    public T back() {
        if (isEmpty()) {
            return null;
        }

        return this.tail.data;
    }

    public void printAll() {
        Node<T> temp = this.head;
        System.out.print("elem: ");
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void clear() {
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) {
        Queue<Integer> intQueue = new Queue<>();

        for (int i = 0; i < 10; i++) {
            intQueue.enqueue(i);
        }

        intQueue.printAll();
        System.out.println("dequeue: " + intQueue.dequeue());
        intQueue.printAll();
        System.out.println("front: " + intQueue.front());
        intQueue.printAll();
        System.out.println("back: " + intQueue.back());
        intQueue.printAll();
        intQueue.clear();
        intQueue.printAll();

        Queue<String> strQueue = new Queue<>();
        strQueue.enqueue("one");
        strQueue.enqueue("two");
        strQueue.enqueue("three");
        strQueue.printAll();
    }
}
