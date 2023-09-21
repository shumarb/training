import java.text.DecimalFormat;
import java.util.Scanner;

class AboveAverage {

    private void run() {
        Scanner sc = new Scanner(System.in);
        boolean isTest = false;
        int N = sc.nextInt();

        while (N-- > 0) {
            double numStudents = sc.nextDouble();
            int[] scores = new int[(int) numStudents];
            double average = 0, total = 0, count = 0; 
            DecimalFormat df = new DecimalFormat("0.000");

            for (int i = 0; i < scores.length; i++) {
                scores[i] = sc.nextInt();
                total += scores[i];
            }

           average = total / numStudents;
           if (isTest) {
                System.out.print("scores: ");
                for (int i = 0; i < scores.length; i++) {
                    System.out.print(scores[i] + " ");
                }
                System.out.println();
                System.out.println("total = " + total + ", numStudents = " + numStudents + " ");
                System.out.println("average = " + average);
            }

            for (int i = 0; i < scores.length; i++) {
                if (scores[i] > average) {
                    count++;
                }
            }
            System.out.println(df.format((count / numStudents) * 100) + "%");
        }
        sc.close();
    }

    public static void main(String[] args) {
        AboveAverage obj = new AboveAverage();
        obj.run();
    }
}
