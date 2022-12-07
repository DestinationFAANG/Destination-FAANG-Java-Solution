// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/copy-list-with-random-pointer/

// Video Solution: https://www.youtube.com/watch?v=vy7ZJ4TdyS8

// **************** Java Solution ***********************


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    HashMap<Node, Node> visitedNode = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
   
        if(head == null){
            return null;
        }
        
        if(this.visitedNode.containsKey(head)){
            return this.visitedNode.get(head);
        }
        
           Node node = new Node(head.val, null, null);
           
           this.visitedNode.put(head, node);
           node.next = copyRandomList(head.next);
           node.random = copyRandomList(head.random);
           
           return node;
           
    }
}
