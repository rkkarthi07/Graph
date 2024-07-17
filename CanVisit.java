import java.util.*;
class canVisit {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> f = new ArrayList<>(rooms.get(0));
        for(int i : f) queue.add(i);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            vis[cur] = true;
            for(int k : rooms.get(cur)){
                if(!vis[k]){
                    queue.add(k);
                }
            }
        }
        vis[0] = true;
        for(boolean b : vis) if(!b) return b;
        return true;
    }
}