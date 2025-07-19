class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int neighbour : graph[node]){
                        if(color[neighbour] == 0){
                            color[neighbour] = -color[node];
                            q.add(neighbour);
                        }
                        else if(color[neighbour] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}