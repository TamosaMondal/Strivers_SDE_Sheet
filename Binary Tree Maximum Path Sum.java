/*A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.
*/
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
    public int maxPathSum(TreeNode root) {
        int maximum[]=new int[1];
        maximum[0]=Integer.MIN_VALUE;
        maxPathDown(root,maximum);
        return maximum[0];
    }
    public int maxPathDown(TreeNode node,int maximum[]){
        if(node==null){
            return 0;
        }
        int left=Math.max(0,maxPathDown(node.left,maximum));
        int right=Math.max(0,maxPathDown(node.right,maximum));
        maximum[0]=Math.max(maximum[0],left+right+node.val);
        return Math.max(left,right)+node.val;
    }
}
