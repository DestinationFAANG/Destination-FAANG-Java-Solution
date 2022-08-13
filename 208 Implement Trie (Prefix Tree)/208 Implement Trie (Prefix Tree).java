//Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Youtube Solution: https://www.youtube.com/watch?v=nLTqtBLhPbQ
//Leetcode Link: https://leetcode.com/problems/implement-trie-prefix-tree/

**************** Java Solution ***********************


class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}class Trie {

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
        
    }
    
    public TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i =0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)){
                node = node.get(currentChar);
            }
            else{
                return null;
            }
        }
        return node;
        
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!= null;
    }
}
