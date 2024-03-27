// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/combination-sum-ii/

// Video Solution: https://www.youtube.com/watch?v=I6f8Za0vRxE

**************** Java Solution ***********************


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // Early termination if the remaining sum becomes negative
            if (target - candidates[i] < 0) {
                break;
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }

}
