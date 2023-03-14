/*Given a Binary search tree. Your task is to complete the function which will return the Kth largest element without doing any modification in Binary Search Tree.
*/
/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    ArrayList<Integer>arr=new ArrayList<>();
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        //Your code here
        if(root==null) return 0;
        findLargest(root);
        return arr.get(arr.size()-K);
    }
    public void  findLargest(Node root){
        if(root==null) return;
        findLargest(root.left);
        arr.add(root.data);
        findLargest(root.right);
    }
}
