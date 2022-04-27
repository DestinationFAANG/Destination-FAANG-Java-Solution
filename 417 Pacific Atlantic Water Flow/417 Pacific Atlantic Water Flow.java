class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        if (heights.length == 0 || heights[0].length == 0){
            return new ArrayList<>();
        } 
        
        int row = heights.length;
        int col = heights[0].length;
        
        boolean[][] pacificReachable = new boolean[row][col];
        boolean[][] atlanticReachable = new boolean[row] [col];
        
        for(int i=0; i<row; i++){
            dfs(i, 0, pacificReachable,heights);
            dfs(i,col-1, atlanticReachable, heights);
        }
        
        for(int i=0; i<col; i++){
            dfs(0,i, pacificReachable, heights);
            dfs(row-1, i, atlanticReachable, heights);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j]){
                    result.add(List.of(i,j));
                }
            }
        }
        
        return result;
    }
    
    public void dfs (int row, int col, boolean[][] reachable, int[][] heights){
        
        int [][] directions = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}};
        
        reachable[row][col] = true;
        
        for(int[] dir: directions){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            
            if(newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length){
                continue;
            }
            
            if (reachable[newRow][newCol]){
                continue;
            }
            
            if(heights[newRow][newCol] < heights[row][col]){
                continue;
            }
            
            dfs(newRow, newCol, reachable, heights);
        }
        
        
        
        
    }
  
}