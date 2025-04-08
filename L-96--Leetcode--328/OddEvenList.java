
public class OddEvenList {

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

    public static void main(String[] args) {  // Corrected main method signature
        OddEvenList solution = new OddEvenList();

        // Create the linked list: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> null
        ListNode head = solution.new ListNode(2);
        head.next = solution.new ListNode(1);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(5);
        head.next.next.next.next = solution.new ListNode(6);
        head.next.next.next.next.next = solution.new ListNode(4);
        head.next.next.next.next.next.next = solution.new ListNode(7);

        // Call the oddEvenList function
        ListNode newHead = solution.oddEvenList(head); // Corrected method call

        // Print the resulting linked list
        ListNode current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline at the end
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (odd.next != null && even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

// 328. Odd Even Linked List
// Solved
// Medium
// Topics
// Companies
// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
// The first node is considered odd, and the second node is even, and so on.
// Note that the relative order inside both the even and odd groups should remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.
// Example 1:
// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]
// Example 2:
// Input: head = [2,1,3,5,6,4,7]
// Output: [2,3,6,7,1,5,4]
// Constraints:
// The number of nodes in the linked list is in the range [0, 104].
// -106 <= Node.val <= 106
