//Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

//Leetcode Link: https://leetcode.com/problems/validate-binary-search-tree/
//Solution: https://www.youtube.com/watch?v=QaCMLopSwWI
**************** Java Solution ***********************

class Solution {
    public Integer prev;
    public boolean isValidBST(TreeNode root) {
        
        prev = null;
        return inOrder(root);
        
    }
    
    public boolean inOrder(TreeNode root){
        if(root == null){
            return true;
        }
        
        if(!inOrder(root.left)){
            return false;
        }
        
        if(prev != null && root.val<= prev){
            return false;
        }
        prev = root.val;
        return inOrder(root.right);
        
    }
}
