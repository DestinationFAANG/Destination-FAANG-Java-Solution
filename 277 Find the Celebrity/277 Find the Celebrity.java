// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/find-the-celebrity/

// Video Solution: https://www.youtube.com/watch?v=lqdgGNGPS68

**************** Java Solution ***********************


/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    private int numOfPeople;
    
    public int findCelebrity(int n) {
        numOfPeople = n;
        int celebCandiate = 0;
        
        for(int i=0; i<n; i++){
            if(knows(celebCandiate, i)){
                celebCandiate = i;
            }
        }
        
        if(isCelebrity(celebCandiate)){
            return celebCandiate;
        }
        
        return -1;
        
    }
    
    public boolean isCelebrity(int i){
        
        for(int j=0; j<numOfPeople; j++){
            if(i==j){
                continue;
            }
            if(knows(i,j) || !knows(j,i)){
                return false;
            }
        }
        
        return true;
        
    }
}
