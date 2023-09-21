import java.util.Scanner;

class Oddities {
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int N = sc.nextInt();
            if ((N % 2) != 0) {
                System.out.println(N + " is odd");
            } else {
                System.out.println(N + " is even");
            }
        }
    }
    
    public static void main(String[] args) {
        Oddities obj = new Oddities();
        obj.run();
    }
}

