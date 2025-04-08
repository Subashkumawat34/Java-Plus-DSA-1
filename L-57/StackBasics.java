//java collection frameworks
// Stack<Integer> myClass = new Stack<>();
// myClass.Push();
// myClass.pop();

import java.util.Scanner;

//Stack implementation using array
public class StackBasics {

    int stack[];
    int size;
    int top;

    public StackBasics(int stackSize) {
        stack = new int[stackSize];
        size = stackSize;
        top = -1;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of Stack ");
        Scanner Sc = new Scanner(System.in);
        int n = Sc.nextInt();
        StackBasics stack = new StackBasics(n);
        System.out.println(stack.calculateSize());
        stack.pushOperation(12);
        stack.pushOperation(11);
        stack.pushOperation(12);
        stack.pushOperation(11);
        stack.printStack();
        System.out.println(stack.calculateSize());
        stack.popVal();
        stack.popVal();
        stack.printStack();
        System.out.println(stack.isEmpty());
    }

    //Push operation 
    public void pushOperation(int element) {
        if (top >= size - 1) {
            System.out.println("Stack is Full ");
            return;
        }
        top++;
        stack[top] = element;
    }

    //Check stack is empty or not
    public boolean isEmpty() {

        return top <= -1;
    }

    //calculate size
    public int calculateSize() {
        System.out.println("size of stack is ");
        return top + 1;
    }

    //find top or peack value
    public int peekVal() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    //pop operation
    public int popVal() {
        int val = peekVal();
        if (val != Integer.MIN_VALUE) {
            top--;
        }
        return val;
    }

    //Print StackArray
    public void printStack() {
        System.out.println("Printing Stack ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);

            if (i != top) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}