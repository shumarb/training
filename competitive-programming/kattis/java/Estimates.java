import java.util.Scanner;

class Estimates {
    
    private Scanner sc = new Scanner(System.in);
    
    private void displaysEstimate(int estimates) {
        System.out.println(estimates);
    }
    
    private int readsEstimate() {
        String val = sc.next();
        return val.length();
    }
    
    private void run() {
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int estimate = readsEstimate();
            displaysEstimate(estimate);
        }
    }
    
    public static void main(String[] args) {
        Estimates obj = new Estimates();
        obj.run();
    }
}
