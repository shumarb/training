import java.util.Scanner;

class JudgingMoose {


    private void run() {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        sc.close();

        if (l == 0 && r == 0) {
            System.out.println("Not a moose");
        } else {
            if (l == r) {
                System.out.println("Even " + (l + r));
            } else {
                if (l > r) {
                    System.out.println("Odd " + (l * 2));
                } else {
                    System.out.println("Odd " + (r * 2));
                } 
            }
        }
    }
    
    public static void main(String[] args) {
        JudgingMoose obj = new JudgingMoose();
        obj.run();
    }
}
