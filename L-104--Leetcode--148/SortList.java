public class SortList {

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
      SortList solution = new SortList();

      // Create the linked list: 4 -> 2 -> 1 -> 3 -> null
      ListNode head = solution.new ListNode(40);
      head.next = solution.new ListNode(-2);
      head.next.next = solution.new ListNode(1);
      head.next.next.next = solution.new ListNode(0);

      // Call the sortList function
      ListNode sortedHead = solution.sortList(head);

      // Print the sorted linked list
      ListNode current = sortedHead;
      while (current != null) {
          System.out.print(current.val + " ");
          current = current.next;
      }
      System.out.println(); // Add a newline at the end
  }

  public ListNode sortList(ListNode head) {
    return mergeSort(head);
 }

 public ListNode mergeSort(ListNode head){
    if(head == null || head.next == null){
        return head;
    }

    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;

    while(fast != null && fast.next != null){
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    prev.next = null;

    ListNode head1 = mergeSort(head);
    ListNode head2 = mergeSort(slow);
    ListNode ans = merge(head1, head2);
    return ans;
 }

 public ListNode merge(ListNode head1, ListNode head2){
    ListNode ansHead = new ListNode(-1);
    ListNode ansTail = ansHead;

    while(head1 != null && head2 != null){
        if(head1.val <= head2.val){
            ansTail.next = head1; // no need to create new node
            head1 = head1.next;
        }
        else{
            ansTail.next = head2; // no need to create new node
            head2 = head2.next;
        }
        ansTail = ansTail.next;
    }
    while(head1 != null){
        ansTail.next = head1;
        head1 = head1.next;
        ansTail = ansTail.next;
    }
    while(head2 != null){
        ansTail.next = head2;
        head2 = head2.next;
        ansTail = ansTail.next;
    }

    ListNode t1 = ansHead;
    ansHead = ansHead.next;
    t1.next = null;

    return ansHead;
 }
}