package MyStack;

public class Stack<T> {
    private int top;
    private T[] stackArr;

    @SuppressWarnings("unchecked") // 지네릭 배열 생성시 경고 -> new 연산자는 컴파일 시 타입이 정확히 무엇인지 알아야함.
    public Stack(int size) {
        this.top = -1;
        this.stackArr = (T[]) new Object[size];
    }

    public Stack() {
        this(10);
    }

    public boolean isEmpty() { return (top == -1); }

    @SuppressWarnings("unchecked")
    public void push(T elem) {
        if (top == this.stackArr.length-1){
            T[] tempArr = (T[]) new Object[this.stackArr.length+10];
            System.arraycopy(stackArr, 0, tempArr, 0, stackArr.length);
            stackArr = tempArr;
        }
        stackArr[++top] = elem;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T elem = stackArr[top];
        stackArr[top--] = null;
        return elem;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return stackArr[top];
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        if (isEmpty()) {
            return;
        }

        top = -1;
        this.stackArr = (T[]) new Object[this.stackArr.length-1];
    }

    public void printAll() {
        System.out.print("elem: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
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

        Stack<String> strStack = new Stack<>(4);
        strStack.push("one");
        strStack.push("two");
        strStack.push("three");
        strStack.push("four");
        strStack.push("five");
        strStack.printAll();
    }

}
