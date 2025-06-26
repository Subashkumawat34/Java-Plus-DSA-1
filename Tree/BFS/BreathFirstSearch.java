
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

    // TreeNode class to represent each node in the binary tree
    public static class TreeNode<E> {

        E data;
        TreeNode<E> left;
        TreeNode<E> right;

        // Constructor to create a node with given data
        public TreeNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // BFS function to traverse the tree level by level
    public ArrayList<Integer> BFS(TreeNode<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();

        // If tree is empty, return empty result
        if (root == null) {
            return res;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);  // Add root to the queue

        // Traverse while queue is not empty
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();  // Get the front node from the queue
            res.add(node.data);  // Add its data to the result list

            // Add left child to queue if it exists
            if (node.left != null) {
                queue.offer(node.left);
            }

            // Add right child to queue if it exists
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Create an object of the class to use non-static method BFS
        BreathFirstSearch bfs = new BreathFirstSearch();

        // Build a sample binary tree
        /*
                  1
                 / \
                2   3
               / \   \
              4   5   6
         */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);

        // Call BFS and print result
        ArrayList<Integer> bfsResult = bfs.BFS(root);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
