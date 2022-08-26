//Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Youtube solution: https://www.youtube.com/watch?v=QubWUx59QCk
//Leetcode Link: https://leetcode.com/problems/top-k-frequent-elements/0

//**************** Java Solution ***********************


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(k == nums.length){
            return nums;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        for(int n:nums){
            count.put(n, count.getOrDefault(n,0) +1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> count.get(a)-count.get(b));
        
        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = heap.poll();
        }
        
        return ans;
        
        
        
        
    }
}
