//Best Leetcode problems for FAANG: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986
//Youtube Solution: https://www.youtube.com/watch?v=Z7Kr2b4d9fE
//Leetcode Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/

//**************** Java Solution ***********************


class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean word = false;
    public TrieNode() {}
}

class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for(char ch: word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node=node.children.get(ch);
        }
        node.word = true;
    }
    
    public boolean searchInNode(String word, TrieNode node){
        for(int i=0; i<word.length(); i++){
            char ch= word.charAt(i);
            if(!node.children.containsKey(ch)){
                if(ch == '.'){
                    for(char x: node.children.keySet()){
                        TrieNode child = node.children.get(x);
                        if(searchInNode(word.substring(i+1),child)){
                            return true;
                        }
                    }
                }
                return false;
                
            }
            else{
                node = node.children.get(ch);
            }
        }
        
        return node.word;
        
    }
    public boolean search(String word) {
        return searchInNode(word, trie);
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
