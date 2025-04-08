// LeetCode Problem 141: Linked List Cycle

public class LinkedListCycle {

    // ListNode definition (often defined separately, but including here for completeness)
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeMinus4 = new ListNode(4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeMinus4;
        nodeMinus4.next = node2; // Create a cycle

        LinkedListCycle solution = new LinkedListCycle();
        boolean hasCycle = solution.hasCycle(head);
        System.out.println("Has cycle: " + hasCycle);

        ListNode cycleNode = solution.foundNodeOfCycle(head);
        if (cycleNode != null) {
            System.out.println("Cycle founded at : " + cycleNode.val);
        } else {
            System.out.println("No cycle found.");
        }

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) { //Check the edge cases
            return false; // Empty list or single node list cannot have a cycle
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {  // Correct null check!
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle found
    }

    public ListNode foundNodeOfCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle possible
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle found, now find the start of the cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Start of the cycle
            }
        }

        return null; // No cycle found
    }
}
