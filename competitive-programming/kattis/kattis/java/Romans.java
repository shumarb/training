import java.lang.Math;
import java.util.Scanner;

class Romans {

    private double readsEngMiles() {
        Scanner sc = new Scanner(System.in);
        double engMiles = sc.nextDouble();
        sc.close();
        return engMiles;
    }

    private void displaysRomanPaces(double romanPaces) {
        System.out.println((int) romanPaces);
    }

    private double computesRomanPaces(double engMiles) {
        return Math.round(engMiles * 1000.0 * 5280.0 / 4854.0);
    }

    private void run() {
        double engMiles = readsEngMiles();
        double romanPaces = computesRomanPaces(engMiles);
        displaysRomanPaces(romanPaces);
    }
    public static void main(String[] args) {
        Romans obj = new Romans();
        obj.run();
    }
}

