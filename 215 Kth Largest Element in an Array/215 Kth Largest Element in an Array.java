// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

// Video Solution: https://www.youtube.com/watch?v=kmUL7CAOSwc

**************** Java Solution ***********************
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element to maintain the heap size as k
            }
        }
        
        return minHeap.peek(); // The root of the min-heap is the kth largest element
    }
}
