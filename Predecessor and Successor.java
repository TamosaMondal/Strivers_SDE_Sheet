/*There is BST given with root node with key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.

Note :- In an inorder traversal the number just smaller than target is predecessor and the number just greater than target is successor.
*/
class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       p.pre = predecessor(root,key);
       s.succ = successor(root,key);
    }
    public static Node successor(Node root,int key){
        Node succ = null;
        while(root!=null){
            if(root.data>key){
                succ = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return succ;
    }
    public static Node predecessor(Node root,int key){
        Node pre = null;
        while(root!=null){
            if(root.data>=key){
                root = root.left;
            }
            else{
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }
}
//TC-O(H)
//SC-O(1)
