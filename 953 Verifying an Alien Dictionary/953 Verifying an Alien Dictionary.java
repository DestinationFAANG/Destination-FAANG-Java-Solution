class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character,Integer> orderMap = new HashMap<>();
        
        for(int i=0; i<order.length(); i++){
            orderMap.put(order.charAt(i),i);
        }
        
        for(int i=0; i<words.length-1;i++){
            for(int j=0; j<words[i].length(); j++){
                
                
                if(j >= words[i+1].length()){
                    return false;
                }
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    int currLetter = orderMap.get(words[i].charAt(j));
                    int nextLetter = orderMap.get(words[i+1].charAt(j));
                    if(nextLetter < currLetter){
                        return false;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        
        return true;
    }
}