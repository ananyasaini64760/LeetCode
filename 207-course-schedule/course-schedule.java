class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] indegree = new int[numCourses];
        for(int u = 0; u < numCourses; u++){
            for(int v : graph.get(u)){
                indegree[v]++;
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int neighbour : graph.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                    count++;
                }
            }
        }
        if(count == numCourses){
            return true;
        }else{
            return false;
        }
    }
}