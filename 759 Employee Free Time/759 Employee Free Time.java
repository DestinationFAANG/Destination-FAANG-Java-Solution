// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.ca/all/759.html

// Video Solution: https://www.youtube.com/watch?v=99l7goR4y0U

**************** Java Solution ***********************


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution { // Removed the 'public' modifier
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        // Add all intervals to the priority queue
        for (List<Interval> intervals : schedule) {
            pq.addAll(intervals);
        }

        Interval prev = pq.poll();
        while (!pq.isEmpty()) {
            Interval curr = pq.poll();
            if (prev.end < curr.start) {
                // There is a gap between prev and curr, which is a common free time
                result.add(new Interval(prev.end, curr.start));
                prev = curr;
            } else {
                // Overlapping intervals, update the end time if needed
                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return result;
    }

    
}
