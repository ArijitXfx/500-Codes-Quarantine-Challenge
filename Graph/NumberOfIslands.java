public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int noOfIsland = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    noOfIsland++;
                    dfs(grid,i,j,vis);
                }
            }
        }
        return noOfIsland;
    }
    
    public void dfs(char[][] grid,int i, int j, boolean[][] vis){
        if(isSafe(grid,i,j,vis)){
            vis[i][j] = true;
            dfs(grid,i-1,j,vis);
            dfs(grid,i+1,j,vis);
            dfs(grid,i,j+1,vis);
            dfs(grid,i,j-1,vis);
        }
    }
    
    public boolean isSafe(char[][] grid, int i, int j, boolean[][] vis){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j] == '1' &&                    !vis[i][j];
    }
}