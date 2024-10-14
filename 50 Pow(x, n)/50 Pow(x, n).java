// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/powx-n/ 

// Video Solution: https://www.youtube.com/watch?v=OUKFuUkb4p0

**************** Java Solution ***********************

class Solution {
    public double myPow(double x, int n) {
        // Handle the base case where n is 0
        if (n == 0) return 1;
        
        // Convert n to long to handle edge case when n == Integer.MIN_VALUE
        long N = n;
        
        // If n is negative, we need to handle reciprocal of x
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1;
        double currentProduct = x;
        
        // Exponentiation by squaring
        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct; // Square the base
            N /= 2; // Divide the exponent by 2
        }
        
        return result;
    }
}
