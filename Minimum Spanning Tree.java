/*Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
*/
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<ArrayList<Integer>>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        int wt=edges[i][2];
	        
	        ArrayList<Integer>temp1=new ArrayList<>();
	        ArrayList<Integer>temp2=new ArrayList<>();
	        
	        temp1.add(v);
	        temp1.add(wt);
	        
	        temp2.add(u);
	        temp2.add(wt);
	        
	        adj.get(u).add(temp1);
	        adj.get(v).add(temp2);
	    }
	    PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.first-y.first);
	    int visit[]=new int[V];
	    
	    //(weight,node)
	    pq.add(new Pair(0,0));
	    int sum=0;
	    while(!pq.isEmpty()){
	        int wt=pq.peek().first;
	        int node=pq.peek().second;
	        pq.poll();
	        
	        if(visit[node]==1) continue;//if it is already visited then simply skip it
	        visit[node]=1;//if it is not visited then add it to the mst
	        sum+=wt;
	        
	        for(int i=0;i<adj.get(node).size();i++){
	            int adjNode=adj.get(node).get(i).get(0);
	            int edgeWeight=adj.get(node).get(i).get(1);
	            
	            if(visit[adjNode]==0){//if it is not part of the mst yet
	                pq.add(new Pair(edgeWeight,adjNode));
	            }
	        }
	    }
	    return sum;
	    
	}
}
//Time Complexity: O(E*logE) + O(E*logE)~ O(E*logE)
//Space Complexity: O(E) + O(V)
