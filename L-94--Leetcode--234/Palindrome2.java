
//import java.lang.classfile.components.ClassPrinter.ListNode;
public class Palindrome2 {

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
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode tail = reverseList(middle);
        ListNode temp = head;
        while (tail != null) {
            if (tail.val != temp.val) {
                return false;
            }
            tail = tail.next;
            temp = temp.next;
        }
        return true;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
