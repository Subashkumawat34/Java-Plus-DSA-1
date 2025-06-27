
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTreeTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            //move to the left
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                //print the node value
                node = stack.pop();
                res.add(node.val);

                //move to the right
                node = node.right;
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
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.right.right.right = new TreeNode(9);

        List<Integer> result = inorderTraversal(root);
        System.out.println("Preorder Traversal: " + result);
    }
}

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// 94. Binary Tree Inorder Traversal
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,3,2]
// Explanation:
// Example 2:
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
// Output: [4,2,6,5,7,1,3,9,8]
// Explanation:
// Example 3:
// Input: root = []
// Output: []
// Example 4:
// Input: root = [1]
// Output: [1]
// Constraints:
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
