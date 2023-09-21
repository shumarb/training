import java.lang.Math;
import java.util.Scanner;

class Sibice {
    
    private double computesDiagonal(double W, double H) {
        W *= W;
        H *= H;
        return Math.floor(Math.sqrt((H + W)));
    }
    
    private void displaysResult(boolean isFit) {
        if (isFit) {
            System.out.println("DA");
        } else {
            System.out.println("NE");
        }
    }
    
    private boolean computesResult(double V, double D, double W, double H) {
        return (V <= D || V <= W || V <= H);
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double W = sc.nextInt();
        double H = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            double V = sc.nextInt();
            double D = computesDiagonal(W, H);
            boolean isFit = computesResult(V, D, W, H);
            displaysResult(isFit);
        }
    }
    
    public static void main(String[] args) {
        Sibice obj = new Sibice();
        obj.run();
    }
}

