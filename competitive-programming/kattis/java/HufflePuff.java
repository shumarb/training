import java.util.Scanner;

class HufflePuff {
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        for (int i = 0; i < N; i++) {
            sc.next();
        }
        sc.close();
        System.out.println(P);
    }
    
    public static void main(String[] args) {
        HufflePuff obj = new HufflePuff();
        obj.run();
    }
}
