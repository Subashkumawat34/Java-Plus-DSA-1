
public class MiddleOfTheList {

    public static class ListNode {  // Made static so you can access it outside MiddleOfTheList

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
    }  // Removed unnecessary main method and kept it simple

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheList obj = new MiddleOfTheList();

        // Example Usage (Creating a linked list):
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = obj.middleNode(head);
        System.out.println("Middle Node Value: " + middle.val); // Output: Middle Node Value: 3

        // Example with an even-length list:
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        ListNode middle2 = obj.middleNode(head2);
        System.out.println("Middle Node Value (even list): " + middle2.val); // Output: Middle Node Value (even list): 3

        // Example with a single node list:
        ListNode head3 = new ListNode(1);
        ListNode middle3 = obj.middleNode(head3);
        System.out.println("Middle Node Value (single node): " + middle3.val);  // Output: Middle Node Value (single node): 1
    }
}
