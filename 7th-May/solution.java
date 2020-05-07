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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode parentOfX = null, parentOfY = null;
        while (true) {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;
            parentOfX = null;
            parentOfY = null;
            while (nodeCount > 0) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                    if (temp.left.val == x) {
                        parentOfX = temp;
                    } else if (temp.left.val == y) {
                        parentOfY = temp;
                    }                    
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    if (temp.right.val == x) {
                        parentOfX = temp;
                    } else if (temp.right.val == y) {
                        parentOfY = temp;
                    } 
                }
                if (parentOfX != null && parentOfY != null && parentOfX != parentOfY) {
                    return true;
                }
                nodeCount--;
            }
        }
        return false;
    }
}
