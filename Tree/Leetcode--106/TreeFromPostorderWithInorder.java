
import java.util.HashMap;

public class TreeFromPostorderWithInorder {

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

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        int n = inorder.length - 1;
        int m = postorder.length - 1;

        TreeNode root = constructTree(postorder, inorder, indexMap, 0, n, 0, m);
        return root;
    }

    public static TreeNode constructTree(int[] postorder, int[] inorder, HashMap<Integer, Integer> indexMap, int postIndStart, int postIndEnd, int inIdxStart, int inIdxEnd) {
        if (postIndStart > postIndEnd || inIdxStart > inIdxEnd) {
            return null;
        }
        int rootData = postorder[postIndEnd];
        int rootIndex = indexMap.get(rootData);
        TreeNode root = new TreeNode(rootData);
        int leftIndexSize = rootIndex - inIdxStart;
        int rightIndexSize = inIdxEnd - rootIndex;

        root.left = constructTree(postorder, inorder, indexMap, postIndStart, postIndStart + leftIndexSize - 1, inIdxStart, rootIndex - 1);

        root.right = constructTree(postorder, inorder, indexMap, postIndStart + leftIndexSize, postIndStart + leftIndexSize + rightIndexSize - 1, rootIndex + 1, inIdxEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(postorder, inorder);

        System.out.println("Constructed tree (postorder):");
        printPostorder(root);
    }

    // Helper function to verify tree construction
    public static void printPostorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPostorder(root.left);
        printPostorder(root.right);

    }
}
