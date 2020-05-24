/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index;    
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null)
            return null;
        index = 0;
        return bstFromPreorderUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode bstFromPreorderUtil(int[] preorder, int start, int end) {
        if (index == preorder.length || preorder[index] < start || preorder[index] > end)
            return null;
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = bstFromPreorderUtil(preorder, start, node.val);
        node.right = bstFromPreorderUtil(preorder, node.val, end);
        return node;
    }
}
