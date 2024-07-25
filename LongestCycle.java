class Solution {
    int ans  = -1;
    int[] edge;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        edge = new int[n];
        for(int i = 0 ; i<n ; i++){
            edge[i] = edges[i];
        }
        int[] dis = new int[n];
        boolean[] vis = new boolean[n];
        for(int i = 0 ; i<n ; i++){
            if(!vis[i]){
                dfs(dis , vis , new boolean[n] , i , 0);
            }
        }
        return ans;
    }
    public void dfs(int[] dis ,boolean[] vis,boolean[] extra , int node , int d){
        if(node != - 1){
            if(!vis[node]){
                vis[node] = true;
                extra[node] = true;
                dis[node] = d;
                dfs(dis , vis ,extra , edge[node] , d+1);
                extra[node] = false;
            }
            else if(extra[node]){
                ans = Math.max(d - dis[node] , ans);
            }
        }
    }
}
