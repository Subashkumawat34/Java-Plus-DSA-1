
public class MyCircularQueue {

    int rear;
    int front;
    int size;
    int capacity;
    int circularQueue[];

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        circularQueue = new int[capacity];
        size = 0;
        front = rear = -1;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(6);
        System.out.println("Queue size: " + myCircularQueue.size());

        myCircularQueue.enqueue(10);
        myCircularQueue.enqueue(20);
        myCircularQueue.enqueue(30);
        myCircularQueue.enqueue(40);

        myCircularQueue.printQueue();

        System.out.println("\nDequeued: " + myCircularQueue.dequeue());
        System.out.println("Dequeued: " + myCircularQueue.dequeue());

        myCircularQueue.printQueue();

        System.out.println("\nFront element: " + myCircularQueue.peek());
        System.out.println("Queue size: " + myCircularQueue.size());
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        if((front == 0 && rear == capacity - 1) || (front != 0 && rear == (front - 1) % (capacity))) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return circularQueue[front];
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("CircularQueue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1 && front != 0) {
            rear = 0;
        } else {
            rear++;
        }
        circularQueue[rear] = val;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty");
            return -1;
        }
        int val = circularQueue[front];
        if (front == rear) { // Reset queue if last element is removed
            front = -1;
            rear = -1;
        } else if (rear == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return val;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("CircularQueue is Empty");
            return;
        }

        if (front <= rear) {
            for (int i = front; i <= capacity - 1; i++) {
                System.out.print(circularQueue[i]);
                if (i != rear) {
                  System.out.println(",");
              }
            }

            for (int i = 0; i <= rear; i++) {
                System.out.print(circularQueue[i]);
                if (i != rear) {
                    System.out.print(",");
                }
            }
        } else {
            for (int i = front; i < rear; i++) {
                System.out.println(circularQueue[i]);
                if (i != rear) {
                    System.out.println(",");
                }
            }
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
