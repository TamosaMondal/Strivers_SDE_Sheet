/*Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
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
    public int diameterOfBinaryTree(TreeNode root) {
        int []maximum=new int[1];
        height(root,maximum);
        return maximum[0];
    }
    public int height(TreeNode node,int []maximum){
        if(node==null){
            return 0;
        }
        int leftHeight=height(node.left,maximum);
        int rightHeight=height(node.right,maximum);
        maximum[0]=Math.max(maximum[0],leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
