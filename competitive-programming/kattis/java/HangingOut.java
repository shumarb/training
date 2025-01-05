import java.lang.String;
import java.util.Scanner;

class HangingOut {
    private void run() {
        Scanner sc = new Scanner(System.in);
           int numLimit = sc.nextInt();
        int numEvents = sc.nextInt();
        int numRejects = 0, numTotal = 0;

        while (numEvents-- > 0) {
            String event = sc.next();
            int numPeople = sc.nextInt();
            if (event.equals("enter") && (numTotal + numPeople) <= numLimit) {
                numTotal += numPeople;
            } else if (event.equals("leave")) {
                numTotal -= numPeople;
            } else {
                numRejects += 1;
            }
        }

        System.out.println(numRejects);
        sc.close();
    }
    
    public static void main(String[] args) {
        HangingOut obj = new HangingOut();
        obj.run();
    }
}

