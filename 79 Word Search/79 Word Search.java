//LeetCode Link: https://leetcode.com/problems/word-search/
// Youtube Explaination: 


class Solution {

    public char[][] board;
    public int rows;
    public int cols;
    
    public boolean exist(char[][] board, String word) {
    
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        
        for(int r = 0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(backtrack(r,c,word, 0)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    public boolean backtrack(int row, int col, String word, int index){
        if(index >= word.length()){
            return true;
        }
        
        if(row < 0 || row >= rows || col < 0 || col >= cols || this.board[row][col] != word.charAt(index)){
            return false;
        }
        
        int [] rowdir = {0,1,0,-1};
        int[] coldir = {1,0,-1,0};
        this.board[row][col] = '#';
        
        boolean ret = false;
        for(int d = 0; d<4; d++){
            ret = backtrack(row + rowdir[d], col + coldir[d], word, index+1);
            if(ret){
                break;
            }
        }
        board[row][col] = word.charAt(index);
        return ret;
        
    }
    
    
}
