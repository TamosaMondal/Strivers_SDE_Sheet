/*Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
*/
class Solution
{
    public static class Pairs {
        Node node;
        int hd;
        public Pairs(Node node ,int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Pairs> q = new LinkedList<Pairs>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.add(new Pairs(root,0));
        while(!q.isEmpty()){
            Pairs it = q.remove();
            Node n = it.node;
            int hd = it.hd;
            if(map.get(hd) == null) map.put(hd, n.data); 
            if(n.left!=null)q.add(new Pairs(n.left,hd-1));
            if(n.right!=null)q.add(new Pairs(n.right,hd+1));
        }
        for(Map.Entry<Integer,Integer> val : map.entrySet()){
            ans.add(val.getValue());
        }
        return ans;
    }
}

//TC-O(N)
//SC-O(N)
