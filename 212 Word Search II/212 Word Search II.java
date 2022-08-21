//Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Youtube Solution: https://www.youtube.com/watch?v=8K2Sh9ingJA
//Leetcode Link: https://leetcode.com/problems/word-search-ii/

//**************** Java Solution ***********************


class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode(){}
}

class Solution {
    char[][] fullboard = null;
    ArrayList<String> answer = new ArrayList<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;
            for(Character letter: word.toCharArray()){
                if(node.children.containsKey(letter)){
                    node = node.children.get(letter);
                }
                else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        
        this.fullboard = board;
        
        for(int row =0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
               if(root.children.containsKey(board[row][col])){
                   backtracking(row,col,root);
               } 
            }
        }
        
        return answer;
        
    }
    
    public void backtracking(int row, int col, TrieNode parent){
        Character letter = fullboard[row][col];
        TrieNode currNode = parent.children.get(letter);
        
        if(currNode.word != null){
            answer.add(currNode.word);
            currNode.word=null;
        }
        fullboard[row][col] = '#';
        
        int[] rowOffset = {-1,0,1,0};
        int[] colOffset = {0,1,0,-1};
        
        for(int i=0; i<4; i++){
            int newRow = row+rowOffset[i];
            int newCol = col+colOffset[i];
            
            if(newRow <0 || newCol <0 || newRow >= fullboard.length || newCol >= fullboard[0].length){
                continue;
            }
            if(currNode.children.containsKey(fullboard[newRow][newCol])){
                backtracking(newRow, newCol, currNode);
            }
        }
        
        fullboard[row][col] = letter;
        
        if(currNode.children.isEmpty()){
            parent.children.remove(letter);
        }
        
        
    }
    
}
