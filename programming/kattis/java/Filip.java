import java.util.Scanner;

class Filip {

    // Method reads in 2 values from user
    private String[] readsValues() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();
        return line.split(" ");
    }

    // Method displays string array containing 2 values that user entered
    private void displaysValues(String[] arr) {
        System.out.print("arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method reverses each value
    private void reversesValues(String[] values) {
       String ARev = "", BRev = "";
       for (int i = values[0].length() - 1; i >= 0; i--) {
           ARev += values[0].charAt(i);
       }
       for (int i = values[1].length() - 1; i >= 0; i--) {
           BRev += values[1].charAt(i);
       }   
       values[0] = ARev;
       values[1] = BRev;
    }

    // Method finds larger number among 2 numbers
    private String findsLargerNumber(String[] values) {
        if (Integer.parseInt(values[0]) > Integer.parseInt(values[1])) {
            return values[0];
        }
        return values[1];
    }

    // Method displays the larger number
    private void displaysLargerNumber(String largerNumber) {
        System.out.println(largerNumber);
    }

    private void run() {
        boolean isTest = false;
        String[] values = readsValues();
        if (isTest) {
            displaysValues(values);
        }
        reversesValues(values);
        if (isTest) {
            displaysValues(values);
        }
        String largerNumber = findsLargerNumber(values);
        displaysLargerNumber(largerNumber);
    }
    
    public static void main(String[] args) {
        Filip obj = new Filip();
        obj.run();
    }
}
