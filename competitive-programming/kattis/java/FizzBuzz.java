import java.util.Scanner;

class FizzBuzz {
    
    private int[] readsVal() {
        Scanner sc = new Scanner(System.in);
        int[] val = new int[3];
        for (int i = 0; i < val.length; i++) {
            val[i] = sc.nextInt();
        }
        sc.close();
        return val;
    }
    
    private void displaysResult(int[] val) {
        for (int i = 1; i <= val[val.length - 1]; i++) {
            if ((i % val[0]) == 0 && (i % val[1]) != 0) {
                System.out.println("Fizz");
            } else if ((i % val[0]) != 0 && (i % val[1]) == 0) {
                System.out.println("Buzz");
            } else if ((i % val[0]) == 0 && (i % val[1]) == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);
            }
        }
    }
    
    private void run() {
        int[] val = readsVal();
        displaysResult(val);
    }
    
    public static void main(String[] args) {
        FizzBuzz obj = new FizzBuzz();
        obj.run();
    }
}
