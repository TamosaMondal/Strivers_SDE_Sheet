/*You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
*/
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V+1];
        visited[0]=true;
        ArrayList<Integer> res = new ArrayList<>();
        dfs(0,visited,adj,res);
        return res;
    }
    public static void dfs(int node ,boolean vis[],ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list){
        vis[node]=true;
        list.add(node);
        for(Integer it : adj.get(node)){
            if(vis[it]==false) {
                dfs(it ,vis,adj, list);
            }
        }
    }
}
//TC-O(N)+(2*E)
//SC-O(N)
