class Solution {
    public int findNumbers(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int numDigits = countsDigits(nums[i]);
            if ((numDigits % 2) == 0) {
                total += 1;
            }
        }
        return total;
    }
    
    // Method counts number of digit in number
    private int countsDigits(int number) {
        int totalDigits = 0;
        while (number != 0) {
            number /= 10;
            totalDigits += 1;
        }
        return totalDigits;
    }
}