/*There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        
        int color[]=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(checkBipartite(i,adj,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
// colors a component 
    public boolean checkBipartite(int i,ArrayList<ArrayList<Integer>>adj,int color[]){
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=0;

        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int e:adj.get(node)){
                if(color[e]==-1){// if the adjacent node is yet not colored
                    color[e]=1-color[node];// you will give the opposite color of the node 
                    q.add(e);
                }
                else if(color[e]==color[node]){// is the adjacent guy having the same color 
                    return false;
                }
            }
            
        }
        return true;

    }
}
