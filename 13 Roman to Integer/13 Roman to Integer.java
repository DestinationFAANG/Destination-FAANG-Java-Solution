// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/roman-to-integer/

// Video Solution: https://www.youtube.com/watch?v=qmkr61ySQwQ

**************** Java Solution ***********************


class Solution {
    
    static Map<String, Integer> values = new HashMap<>();
    
    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }
    
    public int romanToInt(String s) {
     
        int sum = 0;
        int i = 0;
        
        while(i<s.length()){
            if(i<s.length()-1){
                String twoSymbols = s.substring(i,i+2);
                if(values.containsKey(twoSymbols)){
                    sum+= values.get(twoSymbols);
                    i = i+2;
                    continue;
                }
            }
            
            String oneSymbol = s.substring(i, i+1);
            sum +=  values.get(oneSymbol);
            i = i+1;
        }
        
        return sum;
    }
}
