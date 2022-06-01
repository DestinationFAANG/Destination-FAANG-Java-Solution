//LeeetCode Link: https://leetcode.com/problems/minimum-window-substring/
// Youtube Solution: https://youtu.be/tMx5JZSBWIE
class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }
        
        Map<Character, Integer> mapT = new HashMap<>();
        
        for(int i=0; i< t.length(); i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i),0) + 1);
        }
        
        int required = mapT.size();
        int l = 0, r =0;
        int create = 0;
        int [] ans = {-1, 0, 0};
        Map<Character, Integer> subStringMap = new HashMap<>();
        
        while(r<s.length()){
            char c = s.charAt(r);
            int count = subStringMap.getOrDefault(c,0);
            subStringMap.put(c, count + 1);
            if(mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()){
                create++;
            }
            while(l <= r && required == create){
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] >= r-l+1){
                    ans[0] = r -l +1;
                    ans[1] = l;
                    ans[2] = r;
                } 
                
                subStringMap.put(c,subStringMap.get(c) - 1);
                if(mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()){
                    create--;
                }
                l++;
            }
            r++;
        }
        
        
        if(ans[0] == -1){
            return "";
        }
        else{
            return s.substring(ans[1], ans[2]+1);   
        }
        
        
        
               
    }
}
