
import java.util.ArrayList;

public class inorderTraversal {

    public static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorderHelper(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left, res);     // Left
        res.add(root.data);                // Root
        inorderHelper(root.right, res);    // Right
    }

    public static ArrayList<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);  // Expected: [4, 2, 5, 1, 3]
    }
}
//https://www.geeksforgeeks.org/problems/inorder-traversal-iterative/1
