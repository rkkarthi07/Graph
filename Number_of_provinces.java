import java.util.*;
class Solution {
    public int Number_of_provinces(int[][] ar) {
        List<List<Integer>> list = new ArrayList<>();
        int n = ar.length;
        boolean vis[] = new boolean[n];
        for(int i = 0 ; i<n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(ar[i][j] == 1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int count  = 0;
        for(int i = 0 ; i<n ; i++){
           if(!vis[i]){
            count++;
            dfs(list , vis , i);
           }
        }
        return count;
    }
    public void dfs(List<List<Integer>> list , boolean[] vis , int node){
         vis[node] = true;
         for(int k : list.get(node)){
            if(!vis[k])
            dfs(list , vis , k);
         }
    }
}
