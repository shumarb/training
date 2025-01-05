import java.util.Scanner;

class Abracadabra {
    
    private void displaysResult() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        
        for (int i = 1; i <= num; i++) {
            System.out.println(i + " Abracadabra");
        }
    }
    
    private void run() {
        displaysResult();
    }
    
    public static void main(String[] args) {
        Abracadabra obj = new Abracadabra();
        obj.run();
    }
}
