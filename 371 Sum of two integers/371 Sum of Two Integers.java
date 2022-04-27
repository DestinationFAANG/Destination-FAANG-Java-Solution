class Solution {
    public int getSum(int a, int b) {
        
        //int carry = a&b << 1;
        
        while(b != 0){
            int temp = a ^ b;
            int carry = (a & b) << 1;
            a = temp;
            b = carry;
        }
        
        return a;
        
    }
}