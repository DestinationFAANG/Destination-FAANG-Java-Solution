// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.ca/all/366.html

// Video Solution: https://www.youtube.com/watch?v=VZCWLZ5PvKM

**************** Java Solution ***********************


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public List<List<Integer>> collectLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = removeLeaves(root, leaves);
            result.add(leaves);
        }
        return result;
    }

    private TreeNode
