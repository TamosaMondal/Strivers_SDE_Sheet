/*Given a weighted, undirected and connected graph of V vertices and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that  edge . You are given the source vertex S and You to Find the shortest distance of all the vertex's from the source vertex S. You have to return a list of integers denoting shortest distance between each node and Source vertex S.
 

Note: The Graph doesn't contain any negative weight cycle.

 
*/
class Pair{
    int node;
    int distance;
    Pair(int distance,int node){
        this.node=node;
        this.distance=distance;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        
        dist[S]=0;
        pq.add(new Pair(0,S));
        
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            int dis=pq.peek().distance;
            pq.poll();
            
            for(int i=0;i<adj.get(node).size();i++){
                int adjNode=adj.get(node).get(i).get(0);
                int edgeWeight=adj.get(node).get(i).get(1);
                
                if(dis+edgeWeight<dist[adjNode]){
                    dist[adjNode]=dis+edgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
            
        }
        return dist;
        
    }
}

