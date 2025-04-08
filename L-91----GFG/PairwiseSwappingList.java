
public class PairwiseSwappingList {  // Corrected class name

    public static class Node {  // Made static and added missing closing brace

        int data;
        Node next;

        Node(int key) {  // Corrected constructor
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        // Example Usage:
        PairwiseSwappingList swapper = new PairwiseSwappingList();

        // Create a linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Swap the pairs
        Node newHead = swapper.pairwiseSwap(head);

        // Print the swapped list: 2 -> 1 -> 4 -> 3
        System.out.print("Swapped List: ");
        while (newHead != null) {
            System.out.print(newHead.data + " -> ");
            newHead = newHead.next;
        }
        System.out.println("null");
    }

    public Node pairwiseSwap(Node head) {
        // code here
        Node first = head;
        Node prev = null;

        while (first != null && first.next != null) {
            Node second = first.next;
            first.next = second.next;
            second.next = first;

            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }
            prev = first;
            first = first.next;
        }
        return head;
    }
}

// Given a singly linked list. The task is to swap elements in the linked list pairwise. For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.
// Note: You need to swap the nodes, not only the data. If only data is swapped then the driver code will print -1.
// Examples:
// Input: LinkedList: 1->2->2->4->5->6->7->8
// Output: 2->1->4->2->6->5->8->7
// Explanation: After swapping each pair considering (1,2), (2, 4), (5, 6).. so on as pairs, we get 2, 1, 4, 2, 6, 5, 8, 7 as a new linked list.
// Input: LinkedList: 1->3->4->7->9->10->1
// Output: 3->1->7->4->10->9->1
// Explanation: After swapping each pair considering (1,3), (4, 7), (9, 10).. so on as pairs, we get 3, 1, 7, 4, 10, 9, 1 as a new linked list.
// Constraints:
// 1 ≤ size of linked list ≤ 106
// 1 ≤ elements of linked list ≤ 106

