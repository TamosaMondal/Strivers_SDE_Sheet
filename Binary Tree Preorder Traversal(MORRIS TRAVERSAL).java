/*Given the root of a binary tree, return the preorder traversal of its nodes' values.
*/

//                      <---: MORRIS TRAVERSAL:--->(Threaded Binary Tree)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> preorder = new ArrayList <>();
        TreeNode cur=root;
        while (cur != null) {
            if (cur.left==null) {//if there is no left element
                preorder.add(cur.val);
                cur =cur.right;
            }else{
                TreeNode prev = cur.left;
                while (prev.right !=null && prev.right != cur) {//if there exsit a right and the right is not pointing himself
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;//create the thread
                    preorder.add(cur.val);
                    cur = cur.left;
                } else {
                    prev.right = null;  //cut the thread
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }
}
//TC-O(N)
//SC-O(1)
