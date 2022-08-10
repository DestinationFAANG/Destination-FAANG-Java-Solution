//Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Leetcode Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//Youtube Solution: https://www.youtube.com/watch?v=1HUmPsyFb9U 


**************** Java Solution ***********************

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        int parentval = root.val;
        int pVal= p.val;
        int qVal = q.val;
        
        if(pVal > parentval && qVal > parentval){
           return lowestCommonAncestor(root.right, p, q);
        }
        if(pVal<parentval && qVal<parentval){
            return lowestCommonAncestor(root.left, p, q);
        }
       
        else{
            return root;
        }
    }
}
