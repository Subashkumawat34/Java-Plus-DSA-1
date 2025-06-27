
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            //Move to the left
            if (node != null) {
                stack.push(node);
                node = node.left;
            } //move to the right
            else if (stack.peek().right != null) {
                node = stack.peek().right;
            } //print the node
            else {
                TreeNode temp = stack.pop();
                res.add(temp.val);

                while (!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    res.add(temp.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Manually creating the tree from [1,2,3,4,5,null,8,null,null,6,7,9]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        List<Integer> result = postorderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }
}

// https://leetcode.com/problems/binary-tree-postorder-traversal/
// 145. Binary Tree Postorder Traversal
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return the postorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [3,2,1]
// Explanation:
// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,6,7,5,2,9,8,3,1]
// Explanation:
// Example 3:
// Input: root = []
// Output: []
// Example 4:
// Input: root = [1]
// Output: [1]
// Constraints:
// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
