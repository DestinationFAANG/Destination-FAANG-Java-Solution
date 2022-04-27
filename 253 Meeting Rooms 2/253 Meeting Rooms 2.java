class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0){
            return 0;
        }
        
        int[] start= new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i=0; i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int startptr = 0;
        int endptr = 0;
        
        int result = 0;
        
        while(startptr< start.length){
            
            if(start[startptr] >= end[endptr]){
                result--;
                endptr++;
            }
            result++;
            startptr++;
        }
        
        return result;
    }
}