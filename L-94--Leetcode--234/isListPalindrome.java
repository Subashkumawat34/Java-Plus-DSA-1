
public class isListPalindrome {

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
        isListPalindrome solution = new isListPalindrome();

        // Example 1: Palindrome list
        isListPalindrome.ListNode head1 = solution.new ListNode(1);
        head1.next = solution.new ListNode(2);
        head1.next.next = solution.new ListNode(2);
        head1.next.next.next = solution.new ListNode(1);
        System.out.println(solution.isPalindrome(head1)); // Output: true

        // Example 2: Non-palindrome list
        isListPalindrome.ListNode head2 = solution.new ListNode(1);
        head2.next = solution.new ListNode(2);
        head2.next.next = solution.new ListNode(3);
        System.out.println(solution.isPalindrome(head2)); // Output: false

    }

    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode newListHead = null;

        // Reverse first half while finding the middle
        while (fast != null && fast.next != null) {

            //prev = slow;
            //slow = slow.next;
            fast = fast.next.next;

            ListNode node = new ListNode(slow.val);
            node.next = newListHead;
            newListHead = node;

            prev = slow;
            slow = slow.next;

        }

        // If the list has an odd number of elements, skip the middle node
        if (fast != null) {
            slow = slow.next;
        }

        // Compare reversed first half with second half
        while (newListHead != null && slow != null) {
            if (slow.val != newListHead.val) {
                return false;
            }
            slow = slow.next;
            newListHead = newListHead.next;
        }

        return true;
    }
}
