
// import java.lang.classfile.components.ClassPrinter;
public class myLinkedList {

    Node<Integer> head;
    int size;

    public myLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args) {

        myLinkedList obj = new myLinkedList();
        obj.insertHead(10);
        obj.insertHead(23);
        obj.insertHead(12);
        obj.insertionTail(22);
        obj.insertNode(44, 10);
        // obj.insertNode(55, 3);
        // obj.insertNode(24, 6);
        obj.insertNode(5, 5);
        obj.printList();
        // obj.deleteHead();
        // obj.deleteTail();
        // obj.deleteNode(3);
        // obj.deleteNode(25);
        // obj.printList();
        // obj.updateNode(2, 44);
        // obj.updateNode(5, 77);
        // obj.updateNode(0, 44);
        // obj.updateNode(6, 77);
        //obj.printList();
        obj.searchNode(22);
        obj.searchNode(11);
        obj.searchNode(12);
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
                System.out.println("Searched data is finded at position " + counter);
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
        }
        Node<Integer> temp = head;
        head = head.next;
        temp.next = null;
        System.out.println("Deleted at head is Successful");
        size--;
    }

    public void deleteTail() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
        }
        if (head.next == null) {
            head = null;
            System.out.println("Deleted at tail is Successful");
            size--;
            return;
        }
        Node<Integer> temp = head;
        Node<Integer> prev = null;

        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        System.out.println("Deleted at Tail is successful");
        size--;
    }

    public void deleteNode(int position) {
        if (position >= size || position < 0) {
            System.out.println("Wrong input");
            return;
        }
        if (position == 1) {
            deleteHead();
        } else if (position == size) {
            deleteTail();
        } else {
            int counter = 1;
            Node<Integer> prev = null;
            Node<Integer> temp = head;
            while (counter < position && temp != null) {
                counter++;
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
            System.out.println("Deleted at a position " + position);
            size--;
        }
    }

    public void updateNode(int position, int updatedVal) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        int counter = 1;
        Node<Integer> temp = head;
        while (counter < position && temp != null) {
            counter++;
            temp = temp.next;
        }
        if (temp != null && counter == position) {
            temp.data = updatedVal;
        } else {
            System.out.println("Size of LinkedList is smaller then position " + position);
            return;
        }

        System.out.println("Updation at position " + position + " is Successful");

    }

    public void printList() {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.println("data is --> " + temp.data);
            temp = temp.next;
        }
    }

    public void insertNode(int data, int position) {

        if (position > size + 1 || position <= 0) {
            System.out.println("Wrong input");
            return;
        }
        //head
        if (position == 1) {
            insertHead(data);
        } else if (position == size + 1) {
            insertionTail(data);
        } else {
            int counter = 1;
            Node<Integer> newNode = new Node<>(data);
            Node<Integer> temp = head;

            while (counter < position - 1 && temp != null) {
                counter++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
        System.out.println("Insertion Successful at specific Position:" + position);
    }

    public void insertHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            System.out.println("Insertion at head is Successful");

            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Insertion at head is Successful");
        size++;
    }

    public void insertionTail(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            System.out.println("Insertion at Tail is Successful");
            size++;
            return;
        }
        Node<Integer> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Insertion at Tail is Successful");
        size++;
    }
}

class Node<T> {

    T data;
    Node next;

    Node() {
        this.data = null;
    }

    Node(T data) {
        this.next = null;
        this.data = data;
    }
}
