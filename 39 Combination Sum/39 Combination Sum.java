class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<>();
        
        backTrack(target, res, combination, 0, candidates);
        return res;
    }
    
    public void backTrack(int target, List<List<Integer>> res, List<Integer> combination, 
                          int start, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<Integer>(combination));
        }
        else if(target <0){
            return;
        }
        
        for(int i=start; i<candidates.length; i++){
            combination.add(candidates[i]);
            backTrack(target-candidates[i], res, combination, i, candidates);
            combination.remove(combination.size()-1);
        }
    }
}
    