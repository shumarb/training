package programming.leetcode.medium;

class Solution {

    public void printsArray(boolean[] arr) {
        System.out.print("Array: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    public int countPrimes(int n) {
        boolean isTest = false;
        boolean[] primeNumbers = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primeNumbers[i] = true;
        }
        if (isTest) {
            printsArray(primeNumbers);
        }

        for (int i = 2; (i * i) <= n; i++) {
            // If current number is a prime number
            // Set all of the it's multiples up to n to be false
            if (primeNumbers[i]) {
                for (int j = (i * i); j <= n; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < primeNumbers.length; i++) {
            if (i < n && primeNumbers[i]) {
                count++;
            }
        }
        return count;
    }
}