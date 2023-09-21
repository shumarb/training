import java.math.BigInteger;
import java.util.Scanner;

class Candies {

    private void run() {
        Scanner sc = new Scanner(System.in);
        boolean isTest = false;
        int T = sc.nextInt();
        if (isTest) {
            System.out.println("T = " + T);
        }
        while (T-- > 0) {
            sc.nextLine();
            long numChildren = sc.nextLong();
            if (isTest) {
                System.out.println("numChildren = " + numChildren);
            }
            BigInteger total = BigInteger.ZERO;
            for (long i = 0; i < numChildren; i++) {
                total = total.add(BigInteger.valueOf(sc.nextLong()));
            }
            BigInteger remainder = total.mod(BigInteger.valueOf(numChildren));
            if (isTest) {
                System.out.print("total = " + total + ", numChildren = " + numChildren);
                System.out.println("remainder = " + remainder);
            }
            if (BigInteger.ZERO.equals(total.mod(BigInteger.valueOf(numChildren)))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
        sc.close();
    }
    public static void main(String[] args) {
        Candies obj = new Candies();
        obj.run();
    }
}
