import java.util.Arrays;
import java.util.Scanner;

class ABC {

    private boolean isTest = false;
    private Scanner sc = new Scanner(System.in);

    // Method reads in numbers from user
    // Precon: numbers array contains no numbers
    // Postcon: numbers array stores values entered by user sorted in increasing order
    private void readsNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int num = sc.nextInt();
            numbers[i] = num;
        }
        Arrays.sort(numbers);
        if (isTest) {
            System.out.print("Numbers: ");
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
    }

    // Method reads in letters from user
    // Precon: letters array is empty
    // Postcon: letters array contains characters of string entered by user
    private void readsCharacters(char[] letters) {
        String str = sc.next();
        if (isTest) {
            System.out.println("str = " + str);
        }
        for (int i = 0; i < letters.length; i++) {
            letters[i] = str.charAt(i);
        }
        if (isTest) {
            System.out.print("Letters: ");
            for (int i = 0; i < letters.length; i++) {
                System.out.print(letters[i] + " ");
            }
            System.out.println();
        }
    }

    // Method displays numbers according to ordering of letters
    // Precon: numbers and letters arrays contain values that user has entered
    // Postcon: Nil
    private void displaysNumbers(int[] numbers, char[] letters) {
        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            switch (letter) {
                case 'A':
                    System.out.print(numbers[0] + " ");
                    break;
                case 'B':
                    System.out.print(numbers[1] + " ");
                    break;
                case 'C':
                    System.out.print(numbers[2] + " ");
                    break;
            }
        }
    }

    private void run() {
        int[] numbers = new int[3];
        char[] letters = new char[3];
        readsNumbers(numbers);
        readsCharacters(letters);
        displaysNumbers(numbers, letters);
    }
    
    public static void main(String[] args) {
        ABC obj = new ABC();
        obj.run();
    }
}
