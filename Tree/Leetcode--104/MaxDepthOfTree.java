
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfTree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        // Build tree corresponding to:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root);
        System.out.println("Maximum Depth of Tree: " + depth);
    }
}

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
// 104. Maximum Depth of Binary Tree
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3
// Example 2:
// Input: root = [1,null,2]
// Output: 2
// Constraints:
// The number of nodes in the tree is in the range [0, 104].
// -100 <= Node.val <= 100
