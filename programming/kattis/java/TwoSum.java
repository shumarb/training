import java.util.Scanner;

class TwoSum {

    private void run()
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + b);
        sc.close();
    }
    public static void main(String[] args)
    {
        TwoSum obj = new TwoSum();
        obj.run();
    }
}
