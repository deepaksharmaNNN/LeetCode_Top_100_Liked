class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }
        int tm = 0;
        int cnt = 0;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(q.size() > 0){
            Pair pair = q.poll();
            int r = pair.row;
            int c = pair.col;
            int t = pair.time;
            tm = Math.max(t, tm);
            for(int i = 0; i < 4; i++){
                int newRow = r + delRow[i];
                int newCol = c + delCol[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                grid[newRow][newCol] == 1 && vis[newRow][newCol] == 0){
                    q.offer(new Pair(newRow, newCol, t + 1));
                    vis[newRow][newCol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != cntFresh) return -1;
        return tm;
    }
}