import java.util.Scanner;

class R2 {
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int R1 = sc.nextInt();
        int S  = sc.nextInt();
        sc.close();
        int R2 = (2 * S) - R1;
        System.out.println(R2);
    }
    
    public static void main(String[] args) {
        R2 obj = new R2();
        obj.run();
    }
}

