import java.lang.Integer;
import java.util.Scanner;

class Reverse {
    
    private int readsN() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        return N;
    }
    
    private void displaysRevN(int revN) {
        System.out.println(revN);
    }
    
    private int computesReverse(int N) {
        String binN = Integer.toBinaryString(N);
        String revBinN = "";
        for (int i = binN.length() - 1; i >= 0; i--) {
            revBinN += binN.charAt(i);
        }
        int revInt = Integer.parseInt(revBinN, 2);
        return revInt;
    }
    
    private void run() {
        int N = readsN();
        int revN = computesReverse(N);
        displaysRevN(revN);
    }
    
    public static void main(String[] args) {
        Reverse obj = new Reverse();
        obj.run();
    }    
}
