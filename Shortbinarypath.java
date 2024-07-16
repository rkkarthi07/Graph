import java.util.*;
class Shortbinarypath {
    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        
        int n = grid.length, m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1)); 
        
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            
            if (cur.first == n - 1 && cur.second == m - 1) {
                return cur.level;
            }

            for (int i = 0; i < 8; i++) {
                int nr = cur.first + dir[i][0];
                int nc = cur.second + dir[i][1];
                
                if (isBoundary(grid, nr, nc) || grid[nr][nc] == 1) continue;

                queue.add(new Pair(nr, nc, cur.level + 1));
                grid[nr][nc] = 1; 
            }
        }
        return -1; 
    }

    public static boolean isBoundary(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}

class Pair {
    int first;
    int second;
    int level;
    
    Pair(int n1, int n2, int l) {
        this.first = n1;
        this.second = n2;
        this.level = l;
    }
}
