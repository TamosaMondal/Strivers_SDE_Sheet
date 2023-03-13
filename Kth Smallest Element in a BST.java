/*Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
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
    int count=0;
    int smallest=0;
    public int kthSmallest(TreeNode root, int k) {
        DFS(root,k);
        return smallest;
    }
    public void DFS(TreeNode root, int k){
        if(root==null) return;
        DFS(root.left,k);
        count++;
        if(count==k){
            smallest=root.val;
            return;
        }
        DFS(root.right,k);
    }
}
