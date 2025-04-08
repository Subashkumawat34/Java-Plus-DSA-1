
public class MyQueue {

    int rear;
    int front;
    int size;
    int capacity;
    int queue[];

    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
        front = rear = -1;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(6);
        System.out.println("Queue size: " + myQueue.size());

        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);

        myQueue.printQueue();

        System.out.println("\nDequeued: " + myQueue.dequeue());
        System.out.println("Dequeued: " + myQueue.dequeue());

        myQueue.printQueue();

        System.out.println("\nFront element: " + myQueue.peek());
        System.out.println("Queue size: " + myQueue.size());
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = val;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = queue[front];
        if (front == rear) { // Reset queue if last element is removed
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        size--;
        return val;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i]);
            if (i < rear) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
