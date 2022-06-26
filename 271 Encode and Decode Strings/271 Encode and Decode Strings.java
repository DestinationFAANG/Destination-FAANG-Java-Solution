//Leetcode Link: https://leetcode.com/problems/encode-and-decode-strings/
//Youtube Link: 

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
        if(strs.size()==0 ){
            return Character.toString((char)258);
        }
        String separate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s);
            sb.append(separate);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        if(s.equals(Character.toString((char)258))){
            return new ArrayList();
        }
        
       String separate = Character.toString((char)257);
        
         return Arrays.asList(s.split(separate, -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
