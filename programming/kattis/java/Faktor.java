import java.util.Scanner;

class Faktor {
    
    private void displaysNumScientists(int ans) {
        System.out.println(ans);
    }
    
    private int getsResult() {
        Scanner sc = new Scanner(System.in);
        int numArticles = sc.nextInt();
        int impactFactor = sc.nextInt();
        sc.close();
        return 1 + (numArticles * (impactFactor - 1));
    }
    
    private void run() {
        int numScientists = getsResult();
        displaysNumScientists(numScientists);
    }
    
    public static void main(String[] args) {
        Faktor obj = new Faktor();
        obj.run();
    }
}

