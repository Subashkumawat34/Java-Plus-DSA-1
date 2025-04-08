//import java.lang.classfile.components.ClassPrinter.ListNode;

public class reverseList {

    public class ListNode { // Changed the inner class name to ListNode

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
        // Example usage (optional):
        reverseList solution = new reverseList();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        head.next.next.next.next.next = solution.new ListNode(5);

        // Reverse the list
        ListNode reversedHead = solution.reverseListMethod2(head);

        // Print the reversed list (optional)
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline for clarity
    }

    public ListNode reverseListMethod1(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    public ListNode reverseListMethod2(ListNode head) {
      if(head == null || head.next == null){
          return head;
      }
      ListNode last = reverseListMethod2(head.next);
      head.next.next = head;
      head.next = null;
      return last;
  }

}
