
import java.util.ArrayList;

public class PostorderTraversal {

    public static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void postorderHelper(Node root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }

        postorderHelper(root.left, res);
        postorderHelper(root.right, res);
        res.add(root.data);
    }

    public static ArrayList<Integer> postorderTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
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

        ArrayList<Integer> result = postorderTraversal(root);
        System.out.println("postorder Traversal: " + result);
    }
}


//https://www.geeksforgeeks.org/problems/postorder-traversal/1
