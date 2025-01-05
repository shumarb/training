import java.util.Vector;
import java.util.Scanner;

class MissingNumbers {

    private boolean isTest = false;
    private Scanner sc = new Scanner(System.in);

    // Method reads in number from user
    // Precon: Nil
    // Postcon: Number that user entered is stored in either array or integer variable
    private int readsNumber() {
        int number = sc.nextInt();
        if (isTest) {
            System.out.println("number entered: " + number);
        }
        return number;
    }

    // Method reads in numbers that user enters and stores it in form of a Pair object
    // Precon: User has keyed in n
    // Postcon: numbers vector contains n Pair objects that contain values that user entered
    private void storesNumbers(Vector <Integer> numbers, int n) {
        for (int i = 0; i < n; i++) {
            int val = readsNumber();
            numbers.add(val);
        }

        if (isTest) {
            System.out.println("--------------------------");
            System.out.println("Numbers Vector: ");
            for (int i = 0; i < numbers.size(); i++) {
                Integer currNum = numbers.get(i);
                System.out.println(currNum);
            }
            System.out.println("--------------------------");
        }
    }

    // Method checks for any missing numbers
    // Precon: Numbers that user entered has been stored in the form of Pair objects
    // Postcon: There is at least 1 missing number
    private boolean checksNumbers(Vector <Integer> numVector) {
        int lastNum = numVector.get(numVector.size() - 1);
        if (isTest) {
            System.out.println("lastNum = " + lastNum);
        }

        for (int i = 1; i <= lastNum; i++) {
            if (numVector.contains(i) == false) {
                if (isTest) {
                    System.out.println("Missing Number: " + i);
                }
                return true;
            }
        }

        return false;
    }

    // Method displays missing numbers
    // Precon: There is at least 1 missing number among numbers user entered
    // Postcon: Nil
    private void displaysMissingNumbers(Vector <Integer> numVector) {
        int lastNum = numVector.get(numVector.size() - 1);
        for (int i = 1; i <= lastNum; i++) {
            if (numVector.contains(i) == false) {
                System.out.println(i);
            }
        }
    }

    // Method displays success message
    // Precon: No missing numbers found among numbers that user entered
    // Postcon: Nil
    private void displaysMessage() {
        System.out.println("good job");
    }

    private void run() {
        int n = readsNumber();
        Vector <Integer> numVector = new Vector <Integer> ();
        storesNumbers(numVector, n);
        boolean isMissing = checksNumbers(numVector);
        if (isMissing) {
            displaysMissingNumbers(numVector);
        } else {
            displaysMessage();
        }
    }
    
    public static void main(String[] args) {
        MissingNumbers obj = new MissingNumbers();
        obj.run();
    }
}
