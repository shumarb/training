import java.util.HashSet;
import java.util.Scanner;

class Modulo {

    private boolean isTest = false;

    // Method reads in numbers from user and stores only distinct numbers
    // Precon: numbers hashset is empty
    // Postcon: numbers hashset contains distinct numbers that user entered
    private void readsNumbers(HashSet <Integer> numbers) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            if (numbers.contains(num) == false) {
                numbers.add(num);
            }
        }
        if (isTest) {
            System.out.println("numbers: " + numbers);
        }
        sc.close();
    }

    // Method computes number of distinct numbers modulo 42 in numbers hashset
    // Precon: Numbers hashset contains distinct numbers that user entered
    // Postcon; Numbers of distinct numbers modulo 42 has been computed
    private int computesNumModulo(HashSet <Integer> numbers) {
        Object[] arr = numbers.toArray(); // Convert Integer object into primitive integer and store it in array
        HashSet <Integer> distinctModulo = new HashSet <Integer> ();
        
        if (isTest) {
            System.out.print("arr: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // For each integer in arr, compute its modulo and store it in hashset
        // Hashset will store num modulo 42 if it does not contain it
        for (int i = 0; i < arr.length; i++) {
            int num = ((int) arr[i]) % 42;
            if (distinctModulo.contains(num) == false) {
                distinctModulo.add(num);
            }
        }

        if (isTest) {
            System.out.println("distinctModulo: " + distinctModulo);
        }

        return distinctModulo.size();
    }


    // Method displays number of distinct numbers modulo 42
    // Precon: computesNumModulo has been executed
    // Postcon: Nil
    private void displaysNumModulo(int numModulo) {
        System.out.println(numModulo);
    }

    private void run() {
        HashSet <Integer> numbers = new HashSet <Integer> ();
        readsNumbers(numbers);
        int numModulo = computesNumModulo(numbers);
        displaysNumModulo(numModulo);
    }
    
    public static void main(String[] args) {
        Modulo obj = new Modulo();
        obj.run();
    }
}

