//Leetcode Link: https://leetcode.com/problems/same-tree/
//Youtube Link: https://www.youtube.com/watch?v=yi7ym5R5aYI


**************** Java Solution ***********************



class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
