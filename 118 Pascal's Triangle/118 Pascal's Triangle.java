// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Leetcode Link: https://leetcode.com/problems/pascals-triangle/
//Video Solution: https://www.youtube.com/watch?v=f0EEHwaY3HY

//**************** Java Solution ***********************


class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for(int row = 1; row<numRows; row++){
            
            List<Integer> r = new ArrayList<>();
            List<Integer> prevList = ans.get(row-1);

            r.add(1);
            for(int j=1; j<row; j++){
                r.add(prevList.get(j-1)+prevList.get(j));
            }
            r.add(1);
            ans.add(r);
        }
        return ans;

        
    }
}
