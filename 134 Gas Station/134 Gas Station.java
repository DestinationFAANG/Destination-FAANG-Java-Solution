// Most asked problems at FAANG companies: https://docs.google.com/spreadsheets/d/1hzP8j7matoUiJ15N-RhsL5Dmig8_E3aP/edit#gid=1377915986

// Leetcode Link: https://leetcode.com/problems/gas-station/

// Video Solution: https://www.youtube.com/watch?v=ENDr9IfRMMw

**************** Java Solution ***********************
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            
            // If tank is negative, reset the starting index and tank balance
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }
        
        // If total gas is less than total cost, return -1
        if (totalGas < totalCost) {
            return -1;
        }
        
        return startIndex;
    }

}
