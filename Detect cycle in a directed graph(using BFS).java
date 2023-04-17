/*Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
*/
//                          <-----using BFS(Topological Sort)----->
//It is Exactly same code as Topo sort
//First Copy the whole code,then we do not need to store the topo,So,just ommit it,then declare a 'cnt' variable and increse it
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        // int topo[] = new int[N];
        int indegree[] = new int[N];
        for (int i = 0; i < N; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            cnt++;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (cnt == N)
            return false;
        return true;
    }
}

//Time Complexity: O(V+E)
//Space Complexity: O(N) + O(N) ~ O(2N)
