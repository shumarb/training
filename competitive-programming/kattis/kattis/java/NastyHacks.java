import java.util.Scanner;

class NastyHacks {
    
    private Scanner sc = new Scanner(System.in);
    
    private int readsN() {
        int N = sc.nextInt();
        return N;
    }
    
    private int computesResult() {
        int[] val = new int[3];
        for (int i = 0; i < val.length; i++) {
            val[i] = sc.nextInt();
        }
        
        return ((val[1] - val[2]) - val[0]);
    }
    
    private void displaysResult(int result) {
        if (result > 0) {
            System.out.println("advertise");
        } else if (result < 0) {
            System.out.println("do not advertise");
        } else {
            System.out.println("does not matter");
        }
    }
    
    private void run() {
        int N = readsN();
        for (int i = 0; i < N; i++) {
            int result = computesResult();
            displaysResult(result);
        }
    }
    
    public static void main(String[] args) {
        NastyHacks obj = new NastyHacks();
        obj.run();
    }    
}
