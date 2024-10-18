// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/detect-squares/ 

// Video Solution: https://www.youtube.com/watch?v=1UooPSAHjfw


**************** Java Solution ***********************

class DetectSquares {

    // Map to store frequency of points: map of x-coordinate to (map of y-coordinate to frequency)
    private Map<Integer, Map<Integer, Integer>> pointsCount;

    public DetectSquares() {
        pointsCount = new HashMap<>();
    }

    // Adds a new point [x, y] to the data structure
    public void add(int[] point) {
        int x = point[0], y = point[1];
        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y, 0) + 1);
    }

    // Counts the number of ways to form axis-aligned squares with point [x1, y1]
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        int totalSquares = 0;

        // Check all points that share the same x-coordinate with the query point
        if (!pointsCount.containsKey(x1)) {
            return 0;
        }

        // Iterate over all y-coordinates for the current x1
        for (Map.Entry<Integer, Integer> entry : pointsCount.get(x1).entrySet()) {
            int y2 = entry.getKey();
            int countY2 = entry.getValue();

            // We need y2 to be different from y1 to form a square (side length of square)
            if (y2 == y1) {
                continue;
            }

            int sideLength = Math.abs(y2 - y1);

            // Check the two possible square points horizontally:
            // (x1 + sideLength, y1) and (x1 + sideLength, y2)
            totalSquares += countSquares(x1, y1, x1 + sideLength, y1, y2, countY2);

            // Check the two possible square points horizontally on the other side:
            // (x1 - sideLength, y1) and (x1 - sideLength, y2)
            totalSquares += countSquares(x1, y1, x1 - sideLength, y1, y2, countY2);
        }

        return totalSquares;
    }

    // Helper function to count squares formed for the given coordinates
    private int countSquares(int x1, int y1, int x3, int y3, int y2, int countY2) {
        if (pointsCount.containsKey(x3)) {
            Map<Integer, Integer> x3Points = pointsCount.get(x3);
            return x3Points.getOrDefault(y1, 0) * x3Points.getOrDefault(y2, 0) * countY2;
        }
        return 0;
    }
}
