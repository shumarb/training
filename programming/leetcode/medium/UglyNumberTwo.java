package programming.leetcode.medium;

class Solution {
    
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        int numberOfMultiplesOf2 = 0;
        int numberOfMultiplesOf3 = 0;
        int numberOfMultiplesOf5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        int currentUglyNumber = 1;
        uglyNumbers[0] = 1;
  
        for (int i = 1; i < n; i++) {
            currentUglyNumber = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = currentUglyNumber;

            if (currentUglyNumber == nextMultipleOf2) {
                nextMultipleOf2 = uglyNumbers[++numberOfMultiplesOf2] * 2;
            }
            if (currentUglyNumber == nextMultipleOf3) {
                nextMultipleOf3 = uglyNumbers[++numberOfMultiplesOf3] * 3;
            } 
            if (currentUglyNumber == nextMultipleOf5) {
                nextMultipleOf5 = uglyNumbers[++numberOfMultiplesOf5] * 5;
            }
        } 
        
        return currentUglyNumber;
    }
}
