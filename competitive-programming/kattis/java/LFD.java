import java.util.Scanner;

class LFD {

    private boolean isTest = false;
    private Scanner sc = new Scanner(System.in);
    
    private int findsFactorial(int N) {
        int factorial = 1;
        for (int i = 2; i <= N; i++) {
            factorial *= i;
        }
        return factorial;
    }

    private void displaysLfd(int lfd) {
        System.out.println(lfd);
    }

    private void run() {
        int T = sc.nextInt();
        if (isTest) {
            System.out.println("T = " + T);
        }
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int factorial = findsFactorial(N);
            if (isTest) {
                System.out.println(N + "! = " + factorial);
            }
            int lfd = factorial % 10;
            displaysLfd(lfd);
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        LFD obj = new LFD();
        obj.run();
    }
}

