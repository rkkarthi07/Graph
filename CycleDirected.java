class Solution {
    // Function to detect cycle in a directed graph.
    boolean result = false;
    boolean vis[] ;
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        vis = new boolean[n];
        for(int i = 0 ; i<n ; i++){
            if(!vis[i]){
               result |=  dfs(i , adj , new boolean[n]);
                if(result) return result;
            }
        }
        return false;
    }
    public boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] cy){
        vis[node] = true;
        cy[node] = true;
        for(int k : adj.get(node)){
            if(!vis[k]){
                if(dfs(k , adj , cy)){
                    return true;
                }
            }
            else{
                if(cy[k]) return true;
            }
        }
        cy[node] = false;
        return false;
    }
}
