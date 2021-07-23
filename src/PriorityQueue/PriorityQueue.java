package PriorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap;

    PriorityQueue() {
        heap = new ArrayList<>();
        heap.add(0); // 0번째 인덱스는 사용 x
    }

    /*
    삽입
    1. 리스트의 마지막에 삽입.
    2. 3번 과정 반복
    3. 부모노드와 비교한뒤 우선순위가 더 높다면 부모노드와 위치를 바꿔줍니다.
     */

    public void insert(int data) {
        heap.add(data);
        int p = heap.size()-1;

        while (p > 1 && heap.get(p/2) > heap.get(p)) {
            int temp = heap.get(p/2);
            heap.set(p/2, data);
            heap.set(p, temp);
            p/=2;
        }
    }

    /*
    반환
    1. 루트 노드(우선순위가 가장 높은)를 반환한다.
    2. 가장 마지막 노드를 루트 노드로 가지고 온다
    3. 4~5번 과정을 반복
    4. 왼쪽 자식과 오른쪽 자식 중 우선순위가 높은 노드와 루트 노드를 비교한다.
    5-1. 루트 노드가 더 우선순위가 높다면 break;
    5-2. 루트 노드가 더 우선순위가 낮다면 위치를 서로 바꿔준 뒤 다시 반복.
     */
    public int pop() {
        if (heap.size()-1 < 1) return 0;

        int deleteData = heap.get(1);

        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int pos = 1;

        while (pos*2 < heap.size()) {
            int minPos = pos*2;
            int min = heap.get(minPos);

            if (pos*2+1 < heap.size() && min > heap.get(pos*2+1)) {
                minPos = pos*2 + 1;
                min = heap.get(minPos);
            }

            if (min > heap.get(pos)) break;

            int temp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, temp);
            pos = minPos;
        }

        return deleteData;
    }

    void printAll() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        for (int i = 10; i > 0; i--) {
            priorityQueue.insert(i);
        }

        priorityQueue.printAll();
        System.out.println(priorityQueue.pop());
        priorityQueue.printAll();
        priorityQueue.insert(-111);
        priorityQueue.printAll();
        priorityQueue.insert(-222);
        priorityQueue.printAll();
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        System.out.println(priorityQueue.pop());
        priorityQueue.printAll();
        System.out.println(priorityQueue.pop());
        priorityQueue.printAll();
        System.out.println(priorityQueue.pop());
        priorityQueue.printAll();
    }
}
