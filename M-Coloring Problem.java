/*Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.
*/
/*
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends

*/
class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int []color=new int[n];
        return solve(0,graph,color,m,n);
    }
    
    public boolean solve(int node,boolean [][]graph,int []color,int m,int n){
        if(node==n) return true;    //when all nodes are getting colored
        for(int i=1;i<=m;i++){
            if(isSafeToColor(graph,color,node,i,n)){
                color[node]=i;      //color the node
            
            if(solve(node+1,graph,color,m,n))return true;   //color the next node
            color[node]=0;
            
            }
        }
        return false;       //if any one node are not coloured by 1 to m colors
    }
    
    public boolean isSafeToColor(boolean [][] graph,int []color,int node,int col,int n){
        for(int i=0;i<n;i++){
            //check the adjacent node are colored with same color
            if(graph[node][i] && color[i]==col) return false;
        }
        return true;
    }
}

//TC-O(N^M)
//SC-O(N)
