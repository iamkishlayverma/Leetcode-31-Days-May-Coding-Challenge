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
class Count {
    int c = 0;
    int res = 0;
}
class Solution {
    public void kthSmallestUtil(TreeNode root, int k, Count count) {
        if (root == null || count.c >= k)
            return;
        kthSmallestUtil(root.left, k, count);
        count.c++;
        if (count.c == k)
            count.res = root.val;
        kthSmallestUtil(root.right, k, count);
    }
    public int kthSmallest(TreeNode root, int k) {
        Count count = new Count();
        kthSmallestUtil(root, k, count);
        return count.res;
    }
}
