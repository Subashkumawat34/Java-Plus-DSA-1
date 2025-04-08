
public class ReversrNodesInKGroup {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {

        ReversrNodesInKGroup solution = new ReversrNodesInKGroup();

        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        head.next.next.next.next.next = solution.new ListNode(6);
        head.next.next.next.next.next.next = solution.new ListNode(7);
        head.next.next.next.next.next.next.next = solution.new ListNode(8);
        head.next.next.next.next.next.next.next.next = solution.new ListNode(9);

        // Specify k (group size)
        int k = 3;

        // Call the reverseKGroup function
        ListNode newHead = solution.reverseKGroup(head, k);

        // Print the resulting linked list
        ListNode current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline at the end
    }

    public int len(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int N = len(head);
        int groups = N / k;

        ListNode prevHead = null;
        ListNode currHead = head;
        ListNode ansNode = null;

        for (int i = 0; i < groups; i++) {
            ListNode prev = null;
            ListNode curr = currHead;
            ListNode nextNode = null;
            for (int j = 0; j < k; j++) {
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if (prevHead == null) {
                ansNode = prev;
            } else {
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }
        prevHead.next = currHead;
        return ansNode;
    }
}

// 25. Reverse Nodes in k-Group
// Solved
// Hard
// Topics
// Companies
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]
// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]
// Constraints:
// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
