
public class SplitCircularLLIntoTwoHaves {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Simple Pair class (you can use java.util.Pair in Java 8+)
    static class Pair<U, V> {

        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        SplitCircularLLIntoTwoHaves list = new SplitCircularLLIntoTwoHaves();

        // Create a circular linked list
        Node head = list.new Node(8);
        head.next = list.new Node(0);
        head.next.next = list.new Node(4);
        head.next.next.next = list.new Node(5);
        head.next.next.next.next = list.new Node(4);
        head.next.next.next.next.next = list.new Node(9);
        head.next.next.next.next.next.next = head; // Make it circular

        // Split the list
        Pair<Node, Node> halves = list.splitList(head);
        Node head1 = halves.first;
        Node head2 = halves.second;

        // Print the two halves
        System.out.println("First Half:");
        printList(head1);

        System.out.println("\nSecond Half:");
        printList(head2);
    }

    public Pair<Node, Node> splitList(Node head) {
        // Code here

        Node slow = head;
        Node fast = head;
        Node head1 = null;
        Node head2 = null;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head2 = slow.next;
        head1 = head;
        slow.next = head1;

        if (fast.next == head) {
            fast.next = head2;
        } else {
            fast.next.next = head2;
        }

        // Correctly close the second list
        Node curr = head2;
        while (curr.next != head2 && curr != null) {
            curr = curr.next;
        }
        if (curr != null) {
            curr.next = head2; // Ensure the second half is also circular
        }
        return new Pair<>(head1, head2);
    }

    // Helper function to print a circular linked list (prints until it loops back to the head)
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node current = head;
        int count = 0; //To prevent infinte loop
        do {
            System.out.print(current.data + " ");
            current = current.next;
            count++;
            if (count > 20) {
                break;
            }
        } while (current != head && current != null); // Stop when we loop back to the head
        System.out.println();
    }
}
