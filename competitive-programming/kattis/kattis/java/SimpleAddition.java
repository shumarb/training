import java.math.BigInteger;
import java.util.Scanner;

class SimpleAddition {

    private boolean isTest = false;

    private void run() {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        if (isTest) {
            System.out.println("a = " + a + ", b = " + b);
        }
        BigInteger sum = a.add(b);
        System.out.println(sum);
        sc.close();
    }
    
    public static void main(String[] args) {
        SimpleAddition obj = new SimpleAddition();
        obj.run();
    }
}
