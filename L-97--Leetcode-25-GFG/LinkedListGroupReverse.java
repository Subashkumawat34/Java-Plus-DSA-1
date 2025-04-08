
public class LinkedListGroupReverse {

    class Node {

        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListGroupReverse list = new LinkedListGroupReverse();
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        Node reversedHead = reverseKGroup(head, 4);

        Node current = reversedHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

    }

    public static Node reverseKGroup(Node head, int k) {
        Node prevHead = null;
        Node currHead = head;
        Node ansNode = null;

        while (currHead != null) {
            Node prev = null;
            Node curr = currHead;
            Node nextNode = null;

            int j = 0;
            while (j < k && curr != null) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
                j++;
            }

            if (prevHead == null) {
                ansNode = prev;
            } else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        return ansNode;
    }
}

//   Linked List Group Reverse
// Difficulty: HardAccuracy: 57.08%Submissions: 240K+Points: 8Average Time: 30m
// Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.
// Examples:
// Input: head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
// Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5
// Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence, the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.
// Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
// Output: 3 -> 2 -> 1 -> 5 -> 4
// Explanation: The first 3 elements 1, 2, 3 are reversed first and then left out elements 4, 5 are reversed. Hence, the resultant linked list is 3 -> 2 -> 1 -> 5 -> 4.
// Constraints:
// 1 <= size of linked list <= 105
// 1 <= data of nodes <= 106
// 1 <= k <= size of linked list 
