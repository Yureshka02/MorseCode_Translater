public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    // Constructor to initialize stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    // Push element to stack
    public void push(char value) {
        if (!isFull()) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full. Cannot push value.");
        }
    }

    // Pop element from stack
    public char pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop value.");
            return '\0';  // Return null character if stack is empty
        }
    }

    // Peek at top element
    public char peek() {
        return stackArray[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Reverse a string using this custom stack
    public String reverseUsingStack(String message) {
        Stack stack = new Stack(message.length());
        for (char c : message.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
