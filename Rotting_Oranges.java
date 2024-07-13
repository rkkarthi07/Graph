import java.util.LinkedList;
import java.util.Queue;


class Pair{
    int first;
    int second;
    int c;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
        this.c = 0;
    } 
}
public class Rotting_Oranges {
    int mincount = Integer.MAX_VALUE;
    int row[] = {1 , 0 , -1 , 0 };
    int col[] = {0 , 1 , 0 , -1 };
    Queue<Pair> queue = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int cnt = 0;
        for(int[] g : grid){
            for(int i : g) if(i == 1) cnt++;
        }
        boolean vis[][] = new boolean[n][m];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 2){
                  Pair p  = new Pair(i , j);
                  queue.add(p);
                }
            }
        }
        mincount = bfs(grid , vis  , cnt);
        System.out.println(mincount);
        if(mincount == Integer.MAX_VALUE) mincount = -1;
        return mincount >= 0 ? mincount : cnt == 0 ? 0 : -1; 
    }
    public int bfs(int[][] grid , boolean[][] vis , int n){
        int count = 0 , o = 0;
        int s = queue.size();
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int r = cur.first;
            int c = cur.second;
            count = cur.c;
            vis[r][c] = true;
            for(int k = 0 ; k<4 ; k++){
                int nr = r+row[k];
                int nc = c+col[k];
                Pair t = new Pair(nr , nc);
                t.c = count + 1;
                if(!isBorder(t , grid) && !vis[nr][nc] && grid[nr][nc]==1) {
                    vis[nr][nc] = true;
                    queue.offer(t);
                }
            }
            o++;
        }
        return o-s == n ? count : -1;
    }
    public boolean isBorder(Pair p , int[][] grid){
        int i = p.first , j = p.second;
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
