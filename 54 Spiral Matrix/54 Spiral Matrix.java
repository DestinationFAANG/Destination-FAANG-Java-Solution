// LeetCode Link: https://leetcode.com/problems/spiral-matrix/
// Youtube Solution: https://www.youtube.com/watch?v=xUpnTpzMqfI

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int visited = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int row = 0, col = 0;
        
        int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
        
        int currentdirection = 0, changedirection = 0;
        
        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        matrix[0][0] = visited;
        while(changedirection<2){
            while(row + directions[currentdirection][0] >= 0 &&
                    row + directions[currentdirection][0] < rows &&
                    col + directions[currentdirection][1] >= 0 && 
                    col + directions[currentdirection][1] < columns &&
                    matrix[row+directions[currentdirection][0]][col + directions[currentdirection][1]] != visited){
                    
                    changedirection = 0;
                row = row + directions[currentdirection][0];
                col = col + directions[currentdirection][1];
                
                ans.add(matrix[row][col]);
                matrix[row][col] = visited;
            }
            currentdirection = (currentdirection + 1) % 4;
            changedirection++;
        }
        return ans;
        
    }
}
