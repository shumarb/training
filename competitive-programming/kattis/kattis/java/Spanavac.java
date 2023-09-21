import java.util.Scanner;

class Spanavac {
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int numHours = sc.nextInt();
        int numMinutes = sc.nextInt();
        
        if (numMinutes < 45) {
            if (numHours == 0) {
                numHours = 23;
            } else {
                numHours -= 1;
            }
            numMinutes = numMinutes + 60 - 45;
        } else {
            numMinutes -= 45;
        }
        
        System.out.println(numHours + " " + numMinutes);
    }
    
    public static void main(String[] args) {
        Spanavac obj = new Spanavac();
        obj.run();
    }
}

