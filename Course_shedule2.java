import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_shedule2 {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[n];
        for(int a[] : prerequisites){
            int course = a[0];
            int pre = a[1];
            if(adj[pre] == null){
               adj[pre] = new ArrayList<>();
            }
            adj[pre].add(course);
            indegree[course]++;
        }
        
        for(int i = 0 ; i<n ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            } 
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            ans.add(cur);
            if(adj[cur] != null){
                for(int nxt : adj[cur]){
                    indegree[nxt]--;
                    if(indegree[nxt] == 0){
                        queue.offer(nxt);
                    }
                }
            }
        }
       int[] res = new int[ans.size()];
       for(int i = 0 ; i < ans.size() ; i++){
        res[i] = ans.get(i);
       }
       return res.length == n ? res : new int[0];
    }
}
