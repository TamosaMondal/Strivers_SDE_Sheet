/*Given the root of a binary tree, return the inorder traversal of its nodes' values.
*/

//                       <---: MORRIS TRAVERSAL:--->(Threaded Binary Tree)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList <>();
        TreeNode cur=root;
        while (cur != null) {
            if (cur.left==null) {//if there is no left element
                inorder.add(cur.val);
                cur =cur.right;
            }else{
                TreeNode prev = cur.left;
                while (prev.right !=null && prev.right != cur) {//if there exsit a right and the right is not pointing himself
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;//create the thread
                    cur = cur.left;
                } else {
                    prev.right = null;  //cut the thread
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
}
//TC-O(N)
//SC-O(1)
