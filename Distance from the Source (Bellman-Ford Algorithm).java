/*Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: If the Graph contains a negative cycle then return an array consisting of only -1.
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int [] dist=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)(1e8);
        }
        dist[S]=0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> list:edges){
                int u=list.get(0);
                int v=list.get(1);
                int wt=list.get(2);
                
                if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        //Nth Relaxation to check negetive cycle
        for(ArrayList<Integer> list:edges){
                int u=list.get(0);
                int v=list.get(1);
                int wt=list.get(2);
                
                if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                    int [] temp=new int[1];
                    temp[0]=-1;
                    return temp;
                }
            }
            
            return dist;
    }
}
//Time Complexity: O(V*E)
//Space Complexity: O(V)
