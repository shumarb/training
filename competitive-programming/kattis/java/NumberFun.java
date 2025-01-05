import java.util.Scanner;

class NumberFun {
    
    private boolean isTest = false;
    private Scanner sc = new Scanner(System.in);

    private int readsN() {
        int N = sc.nextInt();
        if (isTest) {
            System.out.println("N = " + N);
        }
        return N;
    }

    private int[] readsInputs() {
        int[] values = new int[3];
        for (int i = 0; i < 3; i++) {
            values[i] = sc.nextInt();
        }
        if (isTest) {
            System.out.print("Input: ");
            for (int j = 0; j < values.length; j++) {
                System.out.print(values[j] + " ");
            }
            System.out.println();
        }
        return values;
    }
    
    private void displaysResult(String result) {
        System.out.println(result);
    }

    private String computesResult(int[] values) {
        int a = values[0];
        int b = values[1];
        int c = values[2];

        if ( ((a + b) == c) || ((a - b) == c) || ((a * b) == c) || ((a / b) == c && (a % b) == 0) || ((b/ a) == c && (b % a) == 0) || ((b - a) == c) ) {
            return "Possible";
        }
        return "Impossible";
    }

    private void run() {
        int N = readsN();
        for (int i = 0; i < N; i++) {
            int[] values = readsInputs();
            String result = computesResult(values);
            displaysResult(result);
        }
    }
    
    public static void main(String[] args) {
        NumberFun obj = new NumberFun();
        obj.run();
    }
}
