// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/largest-number/

// Video Solution: https://www.youtube.com/watch?v=q6tyGuVVbfE

**************** Java Solution ***********************

class Solution {
    public String largestNumber(int[] nums) {
        // Convert int array to String array, so we can sort later
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator
        Arrays.sort(asStrs, new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });

        // If, after being sorted, the largest number is `0`, the entire number is zero
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}
