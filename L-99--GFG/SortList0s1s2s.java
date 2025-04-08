
public class SortList0s1s2s {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) { // Made static

        // Example Usage:
        SortList0s1s2s solution = new SortList0s1s2s();

        // Create a sample linked list: 1 -> 2 -> 2 -> 1 -> 2 -> 0 -> 2 -> 2
        Node head = solution.new Node(1);
        head.next = solution.new Node(2);
        head.next.next = solution.new Node(2);
        head.next.next.next = solution.new Node(1);
        head.next.next.next.next = solution.new Node(2);
        head.next.next.next.next.next = solution.new Node(0);
        head.next.next.next.next.next.next = solution.new Node(2);
        head.next.next.next.next.next.next.next = solution.new Node(2);

        // Segregate the list
        Node segregatedHead = solution.segregate(head);  // Call with object

        // Print the segregated list
        Node current = segregatedHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node segregate(Node head) {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneTail = oneHead;
        Node twoTail = twoHead;
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;
            if (temp.data == 0) {
                temp.next = null;
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                temp.next = null;
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                temp.next = null;
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = nextNode;
        }
        if (oneHead.next == null) {
            zeroTail.next = twoHead.next;
        } else {
            zeroTail.next = oneHead.next;
            oneTail.next = twoHead.next;
        }
        oneHead.next = null;
        twoHead.next = null;
        Node t1 = zeroHead;
        zeroHead = zeroHead.next;
        t1.next = null;

        return zeroHead;
    }
}

// Sort a linked list of 0s, 1s and 2s
// Difficulty: MediumAccuracy: 60.75%Submissions: 231K+Points: 4Average Time: 30m
// Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and 2s.
// Examples:
// Input: LinkedList: 1->2->2->1->2->0->2->2
// Output: 0->1->1->2->2->2->2->2
// Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
// Input: LinkedList: 2->2->0->1
// Output: 0->1->2->2
// Explanation: After arranging all the 0s,1s and 2s in the given format, the output will be 0 1 2 2.
// Expected Time Complexity: O(n).
// Expected Auxiliary Space: O(n).
// Constraints:
// 1 <= no. of nodes <= 106
// 0 <= node->data <= 2
