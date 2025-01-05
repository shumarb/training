import java.util.Scanner;

class Harshad {
    
    private boolean isTest = false;

    // Method reads in number from user
    // Precon: Number is undefined
    // Postcon: Number has been assigned value that user entered
    private int readsNumber() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        return num;
    }

    // Method computes sum of digits of a number
    // Precon: Number > 0
    // Postcon: Nil
    private int computesSumOfDigits(int number) {
        int sumOfDigits = 0, val = number;
        while (val > 0) {
            int digit = val % 10;
            sumOfDigits += digit;
            val /= 10;
        }
        return sumOfDigits;
    }

    // Method computes smallest harshad number greater than or equal to value that user entered
    // Precon: Harshad number has not been computed
    // Postcon: Harshad number is been computed
    private int computesHarshadNumber(int number) {
        if (isTest) {
            System.out.println("Number user entered = " + number);
        }

        int sumOfDigits, harshadNumber = -1;

        sumOfDigits = computesSumOfDigits(number);
        
        // If number user entered is divisible by sum of its digits, then number that user entered is the harshad number
        if ((number % sumOfDigits) == 0) {
            harshadNumber = number;
        } 

        while (harshadNumber == -1) {
            number += 1;
            sumOfDigits = computesSumOfDigits(number);
            if ((number % sumOfDigits) == 0) {
                harshadNumber = number;
            }
        }

        return harshadNumber;
    }

    // Method displays harshad number >= value that user entered.
    // Precon: Harshad number has been computed
    // Postcon; Nil
    private void displaysHarshadNumber(int harshadNumber) {
        System.out.println(harshadNumber);
    }

    private void run() {
        int number = readsNumber();
        int harshadNumber = computesHarshadNumber(number);
        displaysHarshadNumber(harshadNumber);
    }

    public static void main(String[] args) {
        Harshad obj = new Harshad();
        obj.run();
    }
}
