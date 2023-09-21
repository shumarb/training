import java.util.Scanner;

class Tarifa {
    private boolean isTest = false;
    
    private void displaysResult(int numMegaBytes) {
        System.out.println(numMegaBytes);
    }

    private int getsResult() {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        if (isTest) {
            System.out.println("X = " + X + ", N = " + N);
        }
        int remainder = X;
        while (N-- > 0) {
            int usage = sc.nextInt();
            if (isTest) {
                System.out.println("usage = " + usage);
            }
            remainder -= usage;
            remainder += X; // Top-up for next month
        }
        return remainder; 
    }

    private void run() {
        int numMegaBytes = getsResult();
        displaysResult(numMegaBytes);
    }

    public static void main(String[] args) {
        Tarifa obj = new Tarifa();
        obj.run();
    }
}

