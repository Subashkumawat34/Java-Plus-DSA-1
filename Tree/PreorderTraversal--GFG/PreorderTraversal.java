
import java.util.ArrayList;

public class PreorderTraversal {

    // TreeNode class to represent each node in the binary tree
    public static class Node {

        int data;
        Node left;
        Node right;

        // Constructor to create a node with given data
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Preorder traversal method: Root -> Left -> Right
    public static ArrayList<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    // Helper method to perform recursive traversal
    public static void preorderHelper(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.data);                  // Visit root
        preorderHelper(root.left, res);     // Traverse left subtree
        preorderHelper(root.right, res);    // Traverse right subtree
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

        ArrayList<Integer> result = preorderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }
}


//https://www.geeksforgeeks.org/problems/preorder-traversal/1
