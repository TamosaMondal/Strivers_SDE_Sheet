/*Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null ||inorder.length!=postorder.length){
            return null;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    public TreeNode constructTree(int []inorder,int inStart,int inEnd,int []postorder,int postStart,int postEnd,HashMap<Integer,Integer>map){
        if(postStart>postEnd ||inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(postorder[postEnd]);
        TreeNode leftchild = constructTree(inorder, inStart, inRoot-1, postorder, postStart, postStart+inRoot-inStart-1, map);
        TreeNode rightchild = constructTree(inorder,inRoot+1, inEnd, postorder, postStart+inRoot-inStart, postEnd-1, map);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
