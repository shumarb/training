import java.lang.String;
import java.util.Scanner;

class Halloween {
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        String month = sc.next();
        int date = sc.nextInt();
        if ((month.equals("OCT") && date == 31) || (month.equals("DEC") && date == 25)) {
            System.out.println("yup");
        } else {
            System.out.println("nope");
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        Halloween obj = new Halloween();
        obj.run();
    }
}
