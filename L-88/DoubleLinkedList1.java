
public class DoubleLinkedList1 {

    Node<Integer> head;
    Node<Integer> tail;
    int size;

    public DoubleLinkedList1() {
        this.head = null;
        this.size = 0;
        this.tail = null;
    }

    public static void main(String[] args) {

        DoubleLinkedList1 obj = new DoubleLinkedList1();
        obj.insertHead(11);
        obj.insertHead(22);
        obj.insertTail(33);
        obj.insertNode(23, 2);
        obj.insertNode(45, 1);
        obj.printList();
        //obj.updateNode(4, 88);
        // obj.printList();
        // System.out.println();
        // obj.printReverseList();
        obj.deleteHead();
        obj.deleteTail();
        obj.deleteNode(3);
        obj.deleteNode(6);
        obj.printList();
    }

    public boolean searchNode(int searchedVal) {
        if (head == null) {
            System.out.println("LinkedList is empty");
            return false;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (temp != null) {
            if (temp.data == searchedVal) {
                System.out.println("Searched data is found at position " + counter);
                return true;
            }
            counter++;
            temp = temp.next;
        }
        System.out.println("Searching data is not found");
        return false;
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node<Integer> temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        temp.next = null;
        System.out.println("Deleted at head is Successful");
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            System.out.println("Deleted at tail is Successful");
            size--;
            return;
        }
        Node<Integer> temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        System.out.println("Deleted at Tail is successful");
        size--;
    }

    public void deleteNode(int position) {
        if (position >= size || position < 0) {
            System.out.println("Wrong input");
            return;
        }

        if (position == 0) { // Head deletion
            deleteHead();
        } else if (position == size - 1) { // Tail deletion
            deleteTail();
        } else {
            int counter = 1;
            Node<Integer> prev = head;
            while (counter < position) {
                prev = prev.next;
                counter++;
            }
            Node<Integer> temp = prev.next;
            prev.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = prev;
            }
            temp.prev = null;
            temp.next = null;
            System.out.println("Deleted node at position " + position);
            size--;
        }
    }

    public void updateNode(int position, int updatedVal) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (position < 1 || position > size) {
            System.out.println("Invalid position");
            return;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (counter < position) {
            temp = temp.next;
            counter++;
        }
        temp.data = updatedVal;
        System.out.println("Updation at position " + position + " is Successful");
    }

    public void printList() {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println("data is --> " + temp.data);
            temp = temp.next;
        }
    }

    public void printReverseList() {
        Node<Integer> temp = tail;
        while (temp != null) {
            System.out.println("data is --> " + temp.data);
            temp = temp.prev;
        }
    }

    public void insertNode(int data, int position) {
        if (position > size + 1 || position <= 0) {
            System.out.println("Wrong input");
            return;
        }
        if (position == 1) {
            insertHead(data);
        } else if (position == size + 1) {
            insertTail(data);
        } else {
            int counter = 1;
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;
            while (counter < position - 1) {
                temp = temp.next;
                counter++;
            }
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            newNode.prev = temp;
            temp.next = newNode;
            size++;
            System.out.println("Insertion Successful at specific Position:" + position);
        }
    }

    public void insertHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Insertion at head is Successful");
        size++;
    }

    public void insertTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Insertion at Tail is Successful");
        size++;
    }
}

class Node<T> {

    T data;
    Node<T> next;
    Node<T> prev;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
