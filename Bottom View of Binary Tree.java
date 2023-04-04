/*Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.
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
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Pairs> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.add(new Pairs(root,0));
        while(!q.isEmpty()){
            Pairs it = q.remove();
            Node n = it.node;
            int hd = it.hd;
            map.put(hd,n.data);
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
