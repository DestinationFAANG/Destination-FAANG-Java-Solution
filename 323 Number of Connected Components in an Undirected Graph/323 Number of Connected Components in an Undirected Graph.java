class Solution {
    public int countComponents(int n, int[][] edges) {
    
        int counter = 0;
        int[] visited = new int[n];
        
        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                counter++;
                dfs(adjList,visited, i);
            }
        }
        
        return counter;
    }
    
    public void dfs(List<Integer>[] adjList, int[] visited, int node){
        visited[node] = 1;
        
        for(int i=0; i<adjList[node].size(); i++){
            if(visited[adjList[node].get(i)] == 0){
                dfs(adjList, visited, adjList[node].get(i));
            }
        }
    }
    
    
}