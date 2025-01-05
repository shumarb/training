import java.util.Scanner;

class Dice {

    private boolean isTest = false;
    
    private double[] readsInputs() {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        sc.close();
        double[] inputDoubles = new double[input.length];
        for (int i = 0; i < inputDoubles.length; i++) {
            inputDoubles[i] = Double.parseDouble(input[i]);
        }
        if (isTest) {
            System.out.print("InputDoubles: ");
            for (int i = 0; i < input.length; i++) {
                System.out.print(inputDoubles[i] + " ");
            }
            System.out.println();
        }
        return inputDoubles;
    }
    
    private void displaysResult(double[] values) {
        if (values[0] == values[1]) {
            int ans = (int) values[0] + 1;
            System.out.println(ans);
        } else {
            int min = (int) (values[0] + 1.0);
            int max = (int) (values[1] + 1.0);
            for (int i = min; i <= max; i++) {
                System.out.println(i);
            }
        }
    }
    
    private void confirmsMinAndMax(double[] values) {
        if (values[0] > values[1]) {
            double temp = values[0];
            values[0] = values[1];
            values[1] = temp;
        }
    }

    private void run() {
        double[] values = readsInputs();
        confirmsMinAndMax(values);
        displaysResult(values);
    }
    
    public static void main(String[] args) {
        Dice obj = new Dice();
        obj.run();
    }
}
