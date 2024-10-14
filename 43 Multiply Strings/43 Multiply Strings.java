// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/multiply-strings/ 

// Video Solution: https://www.youtube.com/watch?v=1Hftrgb30BQ


**************** Java Solution ***********************

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";  // If one of the numbers is 0, the result is 0.
        
        // Initialize an array to hold the result of the multiplication.
        int[] result = new int[num1.length() + num2.length()];
        
        // Reverse both num1 and num2 for easier calculations (rightmost digits come first).
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                // Multiply digits
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;
                
                // Find positions in the result array where to add the product.
                int posLow = i + j + 1;
                int posHigh = i + j;
                
                // Add multiplication result to the current position and handle carry
                int sum = mul + result[posLow];
                
                result[posLow] = sum % 10; // Set the current position to the remainder
                result[posHigh] += sum / 10; // Add the carry to the next higher position
            }
        }
        
        // Convert the result array into a string.
        StringBuilder product = new StringBuilder();
        for (int num : result) {
            // Skip leading zeros.
            if (!(product.length() == 0 && num == 0)) {
                product.append(num);
            }
        }
        
        // Return the product string.
        return product.length() == 0 ? "0" : product.toString();
    }
}
