import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class Ladder {
    
    private double[] readsValues() {
        Scanner sc = new Scanner(System.in);
        double [] values = new double[2];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextDouble();
        }
        return values;
    }
    
    private void displaysLength(double length) {
        System.out.println((int) length);
    }
    
    private double computesLength(double[] values) {
        return Math.ceil(values[0] / Math.sin(values[1] / 180 * Math.PI));
    }
    
    private void run() {
        double [] values = readsValues();
        double length = computesLength(values);
        displaysLength(length);
    }
    
    public static void main(String[] args) {
        Ladder obj = new Ladder();
        obj.run();
    }
}
