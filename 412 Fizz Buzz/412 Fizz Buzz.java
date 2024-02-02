// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/fizz-buzz/

// Video Solution: https://www.youtube.com/watch?v=E3eO7jTFElU

**************** Java Solution ***********************

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // Number is divisible by both 3 and 5
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                // Number is divisible by 3
                result.add("Fizz");
            } else if (i % 5 == 0) {
                // Number is divisible by 5
                result.add("Buzz");
            } else {
                // Number is not divisible by 3 or 5
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
