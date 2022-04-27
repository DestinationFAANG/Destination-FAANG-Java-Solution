class Solution {
  
  public int eraseOverlapIntervals(int[][] intervals) {
    
      if(intervals.length == 0){
          return 0;
      }
      
      Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
      int prev = 0; 
      int count = 0;
      
      for(int i=1;i< intervals.length; i++){
          if(intervals[prev][1] > intervals[i][0]){
              if(intervals[prev][1] > intervals[i][1]){
                  prev = i;
              }
              count++;
          }
          else{
              prev = i;
          }
      }
      return count;
  }
}