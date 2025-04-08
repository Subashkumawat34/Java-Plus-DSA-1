
public class DoubleQueue {

    int rear;
    int front;
    int size;
    int capacity;
    int circularQueue[];

    public DoubleQueue(int capacity) {
        this.capacity = capacity;
        circularQueue = new int[capacity];
        size = 0;
        front = rear = -1;
    }

    public static void main(String[] args) {
        DoubleQueue myCircularQueue = new DoubleQueue(6);
        System.out.println("Queue size: " + myCircularQueue.size());

        myCircularQueue.enqueueFront(10);
        myCircularQueue.enqueueRear(20);
        myCircularQueue.enqueueFront(30);
        myCircularQueue.enqueueRear(40);

        myCircularQueue.printQueue();

        System.out.println("\nDequeued Front: " + myCircularQueue.dequeueFront());
        System.out.println("Dequeued Rear: " + myCircularQueue.dequeueRear());

        myCircularQueue.printQueue();

        System.out.println("\nFront element: " + myCircularQueue.peekFront());
        System.out.println("Rear element: " + myCircularQueue.peekRear());
        System.out.println("Queue size: " + myCircularQueue.size());
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return circularQueue[front];
    }

    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return circularQueue[rear];
    }

    public void enqueueRear(int val) {
        if (isFull()) {
            System.out.println("CircularQueue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity; // Circular increment
        }
        circularQueue[rear] = val;
        size++;
    }

    public void enqueueFront(int val) {
        if (isFull()) {
            System.out.println("CircularQueue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity; // Circular decrement
        }
        circularQueue[front] = val;
        size++;
    }

    public int dequeueRear() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty");
            return -1;
        }
        int val = circularQueue[rear];
        if (front == rear) { // Reset queue if last element is removed
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity; // Circular decrement
        }
        size--;
        return val;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty");
            return -1;
        }
        int val = circularQueue[front];
        if (front == rear) { // Reset queue if last element is removed
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity; // Circular increment
        }
        size--;
        return val;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is Empty");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(circularQueue[i]);
            if (i == rear) {
                break;
            }
            System.out.print(", ");
            i = (i + 1) % capacity; // Circular increment
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}
