class Solution {
    public int[][] highFive(int[][] items) {
        
        Map<Integer, Queue<Integer>> scores = new TreeMap<>();
        
        for(int[] item: items){
            int id = item[0];
            int score = item[1];
            
            if(!scores.containsKey(id)){
                scores.put(id, new PriorityQueue<>((a,b) -> b-a));
            }
            scores.get(id).add(score);
        }
        
        List<int[]> ans = new ArrayList<>();
        
        for(int id:scores.keySet()){
            int sum=0;
            
            for(int i=0; i<5; i++){
                sum = sum+scores.get(id).poll();
            }
            
            ans.add(new int[]{id, sum/5});
        }
        
        int[][] ansArray = new int[ans.size()][];
        
        return ans.toArray(ansArray);
    }
}