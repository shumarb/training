class Solution {
    public int addDigits(int num) {
        int sumOfDigits = 0;
        
        while (true) {
            while (num != 0) {
                sumOfDigits += (num % 10);
                num /= 10;
            }
            
            if (sumOfDigits < 10) {
                break;
            }
            
            num = sumOfDigits;
            sumOfDigits = 0;
        }
        
        return sumOfDigits;
    }
}