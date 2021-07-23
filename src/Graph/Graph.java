package Graph;

import Queue.MyQueue;

import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Graph <T>{
    Node[] graph;
    final int graphCount;

    Graph(int graphCount) {
        graph = new Node[graphCount];
        this.graphCount = graphCount;
    }

    Graph() {this(10);}

    public void addEdge(int start, int end) {
        Node newNode = new Node(end);

        if (graph[start] == null) {
            graph[start] = newNode;
        } else {
            graph[start].next = newNode;
        }
    }

    public void deleteEdge(int start, int end) {
        if (graph[start] == null) return;

        Node prevNode = null;
        Node tempNode = graph[start];

        while(tempNode.next != null && tempNode.data != end) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        if (tempNode.data == end) {
            if (prevNode == null) {
                graph[start] = tempNode.next;
            } else {
                prevNode.next = tempNode.next;
            }
        }
    }

    public void ShowGraphEdge(int start) {
        Node tempNode = graph[start];
        System.out.print(start);

        while (tempNode != null) {
            System.out.print(" => " + tempNode.data);
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void DeapthFirstSearch(int start) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(start);
        boolean[] visited = new boolean[this.graphCount];
        System.out.print("DFS:");

        while (!stack.isEmpty()) {
            int visitedNum = stack.pop();
            System.out.print(" => " + visitedNum);
            Node tempNode = graph[visitedNum];

            while (tempNode != null) {
                if (!visited[tempNode.data]) {
                    stack.push(tempNode.data);
                    visited[tempNode.data] = true;
                }

                tempNode = tempNode.next;
            }
        }
        System.out.println();
    }

    public void BreadthFirstSearch(int start) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(start);
        boolean[] visited = new boolean[this.graphCount];
        System.out.print("BFS:");

        while (!queue.isEmpty()) {
            int visitedNum = queue.dequeue();

            System.out.print(" => " + visitedNum);
            Node tempNode = graph[visitedNum];

            while (tempNode != null) {
                if (!visited[tempNode.data]) {
                    queue.enqueue(tempNode.data);
                    visited[tempNode.data] = true;
                }

                tempNode = tempNode.next;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Graph graph = new Graph(9);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 3);
        graph.addEdge(2, 8);

        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);

        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(4, 3);

        graph.addEdge(5, 7);
        graph.addEdge(6, 5);
        graph.addEdge(7, 6);

        graph.addEdge(8, 0);
        graph.addEdge(8, 7);

        for (int i = 0; i < 9; i++) {
            graph.ShowGraphEdge(i);
        }

        graph.BreadthFirstSearch(1);
        graph.DeapthFirstSearch(1);
    }
}
