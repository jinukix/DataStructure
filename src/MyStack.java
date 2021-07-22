public class MyStack<T> {
    private int top;
    private T[] stackArr;

    @SuppressWarnings("unchecked") // 지네릭 배열 생성시 경고 -> new 연산자는 컴파일 시 타입이 정확히 무엇인지 알아야함.
    public MyStack(int size) {
        this.top = -1;
        this.stackArr = (T[]) new Object[size];
    }

    public MyStack() {
        this(10);
    }

    public boolean isEmpty() { return (top == -1); }

    @SuppressWarnings("unchecked")
    public void push(T elem) {
        if (top == this.stackArr.length-1){
            T[] tempArr = (T[]) new Object[this.stackArr.length+10];
            System.arraycopy(stackArr, 0, tempArr, 0, stackArr.length);
            stackArr = tempArr;
            System.out.println("stack size up");
        }
        stackArr[++top] = elem;
        System.out.println("push: " + elem);
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("fail pop. stack is empty");
            return null;
        }

        T elem = stackArr[top];
        stackArr[top--] = null;
        System.out.println("pop: " + elem);
        return elem;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("fail peek. stack is empty");
            return null;
        }

        System.out.println("peek: " + stackArr[top]);
        return stackArr[top];
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        if (isEmpty()) {
            System.out.println("fail clear. stack is empty");
            return;
        }

        top = -1;
        this.stackArr = (T[]) new Object[this.stackArr.length-1];
        System.out.println("stack is clear");
    }

    public void printAll() {
        if (isEmpty()) {
            System.out.println("fail print. stack is empty");
            return;
        }

        System.out.print("elem: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        for (int i = 0; i < 5; i++) {
            intStack.push(i);
        }

        intStack.printAll();
        System.out.println("pop: " + intStack.pop());
        intStack.printAll();
        System.out.println("peek: " + intStack.peek());
        intStack.printAll();
        intStack.clear();
        intStack.printAll();

        MyStack<String> strStack = new MyStack<>(4);
        strStack.push("one");
        strStack.push("two");
        strStack.push("three");
        strStack.push("four");
        strStack.push("five");
        strStack.printAll();
    }

}
