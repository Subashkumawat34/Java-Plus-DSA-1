
public class InsertionSortList {

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
        InsertionSortList solution = new InsertionSortList();

        // Create the linked list: 4 -> 2 -> 1 -> 3 -> null
        ListNode head = solution.new ListNode(0);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(1);
        head.next.next.next = solution.new ListNode(3);

        // Call the insertionSortList function
        ListNode sortedHead = solution.insertionSortList(head);

        // Print the sorted linked list
        ListNode current = sortedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Add a newline at the end
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next; // Node to be inserted
        ListNode sortedTail = head; // Tail of the sorted portion

        while (temp != null) {
            // If temp is already in the correct position
            if (temp.val >= sortedTail.val) {
                sortedTail = temp;  // Advance sortedTail
                temp = temp.next;    // Advance temp
                continue;            // Go to the next node
            }

            // Remove temp from its current position
            ListNode nextTemp = temp.next;  // Save temp.next
            sortedTail.next = nextTemp;

            ListNode prev = null;   // Previous node in the sorted portion
            ListNode t1 = head;      // Start from the head to find the insertion point

            // Find the correct position to insert temp
            while (t1 != sortedTail.next) {
                if (t1.val > temp.val) {
                    break;
                }
                prev = t1;
                t1 = t1.next;
            }

            // Insert temp at the correct position
            if (prev == null) {      // temp should be inserted at the beginning
                temp.next = head;    // temp points to the original head
                head = temp;         // temp becomes the new head
            } else {
                temp.next = t1;      // Insert temp before t1
                prev.next = temp;    // prev now points to temp
            }
            temp = nextTemp;   //Update temp
        }
        return head;
    }
}

// 147. Insertion Sort List
// Solved
// Medium
// Topics
// Companies
// Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
// The steps of the insertion sort algorithm:
// Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
// It repeats until no input elements remain.
// The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]
// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]
// Constraints:
// The number of nodes in the list is in the range [1, 5000].
// -5000 <= Node.val <= 5000
