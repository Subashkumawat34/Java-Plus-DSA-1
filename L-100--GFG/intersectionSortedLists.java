
public class intersectionSortedLists {

    class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        intersectionSortedLists solution = new intersectionSortedLists();

        // Create sorted linked list 1: 1 -> 2 -> 3 -> 4 -> 6
        Node head1 = solution.new Node(1);
        head1.next = solution.new Node(2);
        head1.next.next = solution.new Node(3);
        head1.next.next.next = solution.new Node(4);
        head1.next.next.next.next = solution.new Node(6);

        // Create sorted linked list 2: 2 -> 4 -> 6 -> 8
        Node head2 = solution.new Node(2);
        head2.next = solution.new Node(4);
        head2.next.next = solution.new Node(6);
        head2.next.next.next = solution.new Node(8);

        // Find the intersection
        Node intersectionHead = solution.findIntersection(head1, head2);

        // Print the intersection list
        Node current = intersectionHead;
        System.out.print("Intersection: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node findIntersection(Node head1, Node head2) {
        // code here.

        Node t1 = head1;
        Node t2 = head2;
        Node resHead = null;
        Node resTail = null;

        while (t1 != null && t2 != null) {
            if (t1.data == t2.data) {
                if (resHead == null) {
                    resHead = new Node(t1.data);
                    resTail = resHead;
                } else {
                    resTail.next = new Node(t1.data);
                    resTail = resTail.next; // Move resTail after adding the new node
                }
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.data < t2.data) {
                t1 = t1.next;
            } else {
                t2 = t2.next;
            }
        }

        return resHead;
    }
}

// Intersection Sorted Linked Lists
// Difficulty: EasyAccuracy: 48.63%Submissions: 143K+Points: 2Average Time: 20m
// Given that two linked lists are sorted in increasing order, create a new linked list representing the intersection of the two linked lists. The new linked list should be made without changing the original lists.
// Note: The elements of the linked list are not necessarily distinct.
// Examples:
// Input: LinkedList1 = 1->2->3->4->6, LinkedList2 = 2->4->6->8
// Output: 2->4->6
// Explanation: For the given two linked list, 2, 4 and 6 are the elements in the intersection.
// Input: LinkedList1 = 10->20->40->50, LinkedList2 = 15->40
// Output: 40
// Explaination:
// Constraints:
// 1 <= size of linked lists <= 104
// 1 <= node->data<= 104
