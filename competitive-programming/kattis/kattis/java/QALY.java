import java.text.DecimalFormat;
import java.util.Scanner;

class QALY {
    
    private void displaysQalyVal(double qalyVal) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(qalyVal));
    }
    
    private double computesQalyVal() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double sum = 0;
        while (N-- > 0) {
            double[] val = new double[2];
            for (int i = 0; i < val.length; i++) {
                val[i] = sc.nextDouble();
            }
            sum += (val[0] * val[1]);
        }
        return sum;
    }
    
    private void run() {
        double qalyVal = computesQalyVal();
        displaysQalyVal(qalyVal);
    }
    
    public static void main(String[] args) {
        QALY obj = new QALY();
        obj.run();
    }    
}
