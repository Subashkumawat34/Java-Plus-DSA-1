
import java.util.HashMap;

public class TreeFromPreorderWithInorder {

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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        // Map value -> index for inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return constructTree(preorder, inorder, indexMap,
                0, preorder.length - 1,
                0, inorder.length - 1);
    }

    public static TreeNode constructTree(int[] preorder, int[] inorder, HashMap<Integer, Integer> indexMap, int preStart, int preEnd, int inStart, int inEnd) {
        // Base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element of preorder is always the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Root index in inorder traversal
        int rootIndex = indexMap.get(rootVal);

        // Number of nodes in left subtree
        int leftSize = rootIndex - inStart;

        // Build left subtree
        root.left = constructTree(preorder, inorder, indexMap,
                preStart + 1, preStart + leftSize,
                inStart, rootIndex - 1);

        // Build right subtree
        root.right = constructTree(preorder, inorder, indexMap,
                preStart + leftSize + 1, preEnd,
                rootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Constructed tree (preorder):");
        printPreorder(root);
    }

    // Helper function to verify tree construction
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Medium
// Topics
// premium lock icon
// Companies
// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]
// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]
// Constraints:
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder and inorder consist of unique values.
// Each value of inorder also appears in preorder.
// preorder is guaranteed to be the preorder traversal of the tree.
// inorder is guaranteed to be the inorder traversal of the tree.
//Preorder--> Root is fixed but there is no gurrentee for left and right subtree
//Postorder--> Root is not fixed but there is no gurrentee for left and right subtree
//inorder--> Root is not fixed but there is gurrentee for left and right subtree. 
//If we know the root, we can easily findout left and right subtree.
