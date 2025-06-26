
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NArrayTraversal {

    // Definition for an N-ary tree node
    static class Node {

        public int val;                 // Node value
        public List<Node> children;     // List of child nodes

        // Constructor with value only (for leaf nodes)
        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        // Constructor with value and children list
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Method to perform level-order traversal (BFS) on an N-ary tree
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();  // Final result list

        // Edge case: if tree is empty
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();  // Queue for BFS
        queue.offer(root);  // Add root to the queue

        // Process nodes level by level
        while (!queue.isEmpty()) {
            int size = queue.size();            // Number of nodes at current level
            ArrayList<Integer> levelList = new ArrayList<>();  // List to store current level values

            // Traverse all nodes at the current level
            while (size-- > 0) {
                Node node = queue.poll();       // Remove node from front of queue
                levelList.add(node.val);        // Add node's value to current level list

                // Add all children of the current node to the queue
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }

            // Add the current level list to the result
            res.add(levelList);
        }

        return res;
    }

    // Main method to build tree and test the traversal
    public static void main(String[] args) {
        // Creating leaf nodes
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        // Creating node 3 with children 5 and 6
        List<Node> children3 = new ArrayList<>();
        children3.add(node5);
        children3.add(node6);
        Node node3 = new Node(3, children3);

        // Creating node 2 and node 4 (leaf nodes)
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        // Creating root node 1 with children 2, 3, and 4
        List<Node> children1 = new ArrayList<>();
        children1.add(node2);
        children1.add(node3);
        children1.add(node4);
        Node root = new Node(1, children1);

        // Create an object of the class and call levelOrder traversal
        NArrayTraversal traversal = new NArrayTraversal();
        List<List<Integer>> result = traversal.levelOrder(root);

        // Print the result level by level
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
