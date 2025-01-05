import java.util.Scanner;

class NSum {

    private void run()
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < N; i++)
        {
            int value = sc.nextInt();
            sum += value;
        }

        sc.close();
        System.out.println(sum);
    }
    public static void main(String[] args)
    {
        NSum obj = new NSum();
        obj.run();
    }
}
