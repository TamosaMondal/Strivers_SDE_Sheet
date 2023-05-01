/*The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Do it in-place.
*/
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n = matrix.length;
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                if (matrix[i][j]==-1) {       //its not possible to reach it
                    matrix[i][j] =(int)(1e9);
                }
                if(i==j) matrix[i][j]=0;    //case of diagonal
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j],
                                            matrix[i][k] + matrix[k][j]);
                }
            }
        }
        /*for (int i = 0; i < n; i++) {
                if(matrix[i][i]<0){
                    System.out.println("There exist a Negetive cycle..")
                }
          }
        */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int)(1e9)) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
//Time Complexity: O(V3)
//Space Complexity: O(V2)

