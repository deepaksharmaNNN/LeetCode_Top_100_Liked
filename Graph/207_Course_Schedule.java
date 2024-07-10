class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            inDegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(q.size() > 0){
            int curr = q.poll();
            list.add(curr);
            for(int nbr : graph.get(curr)){
                inDegree[nbr]--;
                if(inDegree[nbr] == 0){
                    q.offer(nbr);
                }
            }
        }
        if(list.size() == n) return true;
        return false;
    }
}