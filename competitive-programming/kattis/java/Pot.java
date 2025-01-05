import java.lang.Math;
import java.util.Scanner;

class Pot {
    
    private Scanner sc = new Scanner(System.in);
    
    private int readsN() {
        int N = sc.nextInt();
        return N;
    }
    
    private void displaysVal(int val) {
        System.out.println(val);
    }
    
    private int computesVal(int N) {
        int val = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int pow = num % 10;
            num /= 10;
            val += Math.pow((double) num, (double) pow);
        }
        return val;
    }
    
    private void run() {
        int N = readsN();
        int val = computesVal(N);
        displaysVal(val);
    }
    
    public static void main(String[] args) {
        Pot obj = new Pot();
        obj.run();
    }    
}

