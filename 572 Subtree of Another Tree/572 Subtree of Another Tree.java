//LeetCode Link: https://leetcode.com/problems/subtree-of-another-tree/
//Youtube Solution: https://www.youtube.com/watch?v=YOW_-ptARNE

class Solution {
    
    public boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
        
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null){
            return false;
        }
        if(isSame(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
}
