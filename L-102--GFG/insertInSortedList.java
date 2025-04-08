
public class insertInSortedList {

    class Node { // Corrected: Added missing class definition

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        insertInSortedList solution = new insertInSortedList();

        // Example Usage:
        Node head = solution.new Node(1);
        head.next = solution.new Node(3);
        head.next.next = solution.new Node(5);
        head.next.next.next = solution.new Node(7);

        System.out.println("Original List:");
        solution.printList(head);

        int key = 4;
        head = solution.sortedInsert(head, key);

        System.out.println("\nList after inserting " + key + ":");
        solution.printList(head);

        key = 0;
        head = solution.sortedInsert(head, key);
        System.out.println("\nList after inserting " + key + ":");
        solution.printList(head);
    }

    Node sortedInsert(Node head, int key) {
        // Add your code here.
        Node newNode = new Node(key);
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data >= key) {
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (prev == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = prev.next;
            prev.next = newNode;
        }
        return head;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}





// Insert in a Sorted List
// Difficulty: EasyAccuracy: 31.37%Submissions: 137K+Points: 2Average Time: 20m
// Given a linked list sorted in ascending order and an integer called key, insert data in the linked list such that the list remains sorted.

// Examples:

// Input: LinkedList: 25->36->47->58->69->80, key: 19
// Output: 19->25->36->47->58->69->80

// Explanation: After inserting 19 the sorted linked list will look like the one in the output.
// Input: LinkedList: 50->100, key: 75
// Output: 50->75->100

// Explanation: After inserting 75 the sorted linked list will look like the one in the output.
// Constraints:
// 1 <= size of linked list <= 106
// 1 <= data of nodes <= 106