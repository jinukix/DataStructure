public class MyStack<T> {
    private int top;
    private int size;
    private T stackArr[];

    @SuppressWarnings("unchecked") // 지네릭 배열 생성시 경고 -> new 연산자는 컴파일 시 타입이 정확히 무엇인지 알아야함.
    public MyStack(int size) {
        this.top = -1;
        this.size = size;
        this.stackArr = (T[]) new Object[this.size];
    }

    public MyStack() {
        this(10);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == this.size-1);
    }

    public void push(T elem) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            stackArr[++top] = elem;
            System.out.println("insert: " + elem);
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else {
            T elem = stackArr[top];
            stackArr[top--] = null;
            System.out.println("pop: " + elem);
            return elem;
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else {
            System.out.println("peek: " + stackArr[top]);
            return stackArr[top];
        }
    }

    @SuppressWarnings("unchecked") // 지네릭 배열 생성시 경고 -> new 연산자는 컴파일 시 타입이 정확히 무엇인지 알아야함.
    public void clear() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            top = -1;
            this.stackArr = (T[]) new Object[this.size];
            System.out.println("stack is clear");
        }
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            System.out.print("elem: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArr[i] + " ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        stack.printAll();
    }

}
