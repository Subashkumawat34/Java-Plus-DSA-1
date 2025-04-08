public class DeleteMidNodeOfList {

    public class ListNode { 

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        DeleteMidNodeOfList solution = new DeleteMidNodeOfList(); 
        
        ListNode head = solution.new ListNode(1);  
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);

        // Print the original list
        System.out.println("Original List:");
        solution.printList(head);

        ListNode newHead = solution.deleteMiddleNode(head);

        // Print the modified list
        System.out.println("\nList after deleting middle node:");
        solution.printList(newHead);


    }

    // Function to delete the middle node of a linked list
    public ListNode deleteMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; 
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;  
            slow = slow.next;
        }

       
        prev.next = slow.next;

        return head;
    }

    // Helper function to print the linked list (for testing)
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Function to check if the linked list has a cycle - kept for reference
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}