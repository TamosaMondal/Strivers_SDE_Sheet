/*Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.
*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    public ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer>result=new ArrayList<Integer>();
      leftSideView(root,result,0);
      return result;
    }
    public void leftSideView(Node node,List<Integer>result,int level){
        if(node==null) return;
        if(level==result.size()){
            result.add(node.data);
        }
        leftSideView(node.left,result,level+1);
        leftSideView(node.right,result,level+1);
    }
}
//TC-O(N)
//SC-O(H)
