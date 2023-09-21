import java.util.Arrays;
import java.util.Scanner;

class CS {
    
    private Scanner sc = new Scanner(System.in);
    
    private int readsQ() {
        int Q = sc.nextInt();
        return Q;
    }
    
    private void displaysAns(int ans) {
        System.out.println(ans);
    }
    
    private int computesAns(int Q) {
        int[] val = new int[Q];
        int count = 0;
        for (int i = 0; i < val.length; i++) {
            val[i] = sc.nextInt();
            if (val[i] < 0) {
                count += 1;
            }
        }
        return count;
    }
    
    private void run() {
        int Q = readsQ();
        int ans = computesAns(Q);
        displaysAns(ans);
    }
    public static void main(String[] args) {
        CS obj = new CS();
        obj.run();
    }    
}
