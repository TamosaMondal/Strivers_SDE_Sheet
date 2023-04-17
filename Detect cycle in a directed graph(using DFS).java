/*Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
*/
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[] = new int[V];
        int dfsVis[] = new int[V];
        
        for(int i = 0;i<V;i++) {
        	if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
        	}
        }
        return false;
    }
    public static boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1;
        dfsVis[node] = 1;
        //traverse all the adjacent nodes
        for(Integer neighbor: adj.get(node)) {
        	if(vis[neighbor] == 0) {//if the adjacent node is not visited
                if(checkCycle(neighbor, adj, vis, dfsVis) == true) {
                	return true;
            	}
        	} else if(dfsVis[neighbor] == 1) {//if it visited in vis and dfsVis together
            	return true;
        	}
        }
        dfsVis[node] = 0;
        return false;
    }
}*/
//Time Complexity: O(V + E)
//Space Complexity: O(V)
