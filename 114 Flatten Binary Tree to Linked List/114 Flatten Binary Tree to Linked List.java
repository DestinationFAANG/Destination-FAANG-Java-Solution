Most asked problems at FAANG companies :- https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

Leetcode Link :- https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Video Solution :- https://www.youtube.com/watch?v=3IrFrQ2JSfg

**************** Java Solution ***********************


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode flattenTree(TreeNode node){
        
        if(node == null){
            return null;
        }
        
        if(node.left == null && node.right == null){
            return node;
        }
        
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);
        
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return rightTail == null ? leftTail : rightTail;
        
        
        
    }
    
    public void flatten(TreeNode root) {
        
        flattenTree(root);
        
    }
}

