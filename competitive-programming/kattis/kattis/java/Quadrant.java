import java.util.Scanner;

class Quadrant {
    
    private void run() {
        int quadrantNumber = getsQuadrantNumber();
        displaysQuadrantNumber(quadrantNumber);
    }

    private int getsQuadrantNumber() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        if (x > 0 && y > 0) {
            return 1;
        } else if (x <0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else {
            return 4;
        }
    }

    private void displaysQuadrantNumber(int quadrantNumber) {
        System.out.println(quadrantNumber);
    }

    public static void main(String[] args) {
        Quadrant obj = new Quadrant();
        obj.run();
    }
}

