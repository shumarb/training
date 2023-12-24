import java.lang.Integer;
import java.lang.String;
import java.util.Scanner;

class HelpPhD {
    private boolean isTest = false;
    private Scanner sc = new Scanner(System.in);

    // Method reads in N from user
    private int readsN() {
        int N = sc.nextInt();
        if (isTest) {
            System.out.println("N = " + N);
        }
        return N;
    }

    // Method returns numeric value of character
    private String computesSum(String line) {
        char[] charLine = line.toCharArray();
        int sum = 0, nextStartIndex = 0, a, b;
        String aString = "", bString = "";

        // Find integer value of a in terms of string
        for (int i = 0; i < charLine.length; i++) {
            char currChar = charLine[i];
            aString += currChar;
            if (charLine[i + 1] == '+') {
                nextStartIndex = i + 2;
                break;
            }
        }
        // Find integer value of b in terms of string
        for (int i = nextStartIndex; i < charLine.length; i++) {
            char currChar = charLine[i];
            bString += currChar;
        }
        if (isTest) {
            System.out.println("aString = " + aString + ", bString = " + bString);
        }

        a = Integer.parseInt(aString);
        b = Integer.parseInt(bString);
        sum = a + b;
        if (isTest) {
            System.out.println("a = " + a + ", b = " + b + ", sum = " + sum);
        }

        return Integer.toString(sum);
    }

    // Method displays correct answer to user
    private void displaysMessage(String answer) {
        System.out.println(answer);
    }

    // Method reads in N queries from user and displays correct result for each
    private void processesNQueries(int N) {
        for (int i = 0; i < N; i++) {
            String line = sc.next(), answer;
            if (isTest) {
                System.out.println("line = " + line);
            }
            if (line.equals("P=NP")) {
                answer = "skipped";
            } else {
                answer = computesSum(line);
            }
            displaysMessage(answer);
        }
    }

    private void run() {
        int N = readsN();
        processesNQueries(N);
    }
    
    public static void main(String[] args) {
        HelpPhD obj = new HelpPhD();
        obj.run();
    }
}
