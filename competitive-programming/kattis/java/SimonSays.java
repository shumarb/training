import java.util.Scanner;

class SimonSays {
    private void run() {
        Scanner sc = new Scanner(System.in);
        boolean isTest = false;

        int N = sc.nextInt();
        sc.nextLine(); // enter tab from N

        while (N-- > 0) {
            String line = sc.nextLine();
            if (line.contains("Simon says") && line.length() > 11) {
                if (isTest) {
                    System.out.println("Show balance words: " + line.substring(11));
                }
                System.out.println(line.substring(11));
            }
        }
        sc.close();
    }
    public static void main(String[] args) {
        SimonSays obj = new SimonSays();
        obj.run();
    }
}