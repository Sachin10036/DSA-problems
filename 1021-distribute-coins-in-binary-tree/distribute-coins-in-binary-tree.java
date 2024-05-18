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
    private int moves;

    private int traverse(TreeNode node) {
        if (node == null) return 0;
        int leftExcess = traverse(node.left);
        int rightExcess = traverse(node.right);
        int totalExcess = node.val + leftExcess + rightExcess - 1;
        moves += Math.abs(totalExcess);
        return totalExcess;
    }

    public int distributeCoins(TreeNode root) {
        moves = 0;
        traverse(root);
        return moves;
    }
}