
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int val) {
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        queue1.offer(val);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue1.poll();
        return val;
    }

    public int peek() {
        if (queue1.isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        int val = queue1.peek();
        return val;
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(7);
        System.out.println(stack.peek());
    }
}
