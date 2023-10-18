// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link:https://leetcode.com/problems/find-median-from-data-stream/

// Video Solution: https://www.youtube.com/watch?v=IKpM6Q8wTIY

**************** Java Solution ***********************

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> b - a);  // max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>();  // min heap

    // Adds a number into the data structure.
    public void addNum(int num) {
        lo.offer(num);  // Add to max heap

        hi.offer(lo.poll());  // balancing step

        if (lo.size() < hi.size()) {  // maintain size property
            lo.offer(hi.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}
