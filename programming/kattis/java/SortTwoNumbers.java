import java.util.Scanner;

class SortTwoNumbers {

    private void run()
    {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt(), b = s.nextInt();
        s.close();

        if (a < b)
        {
            System.out.println(a + " " + b);
        } else {
            System.out.println(b + " " + a);
        }
    }
    public static void main(String[] args)
    {
        SortTwoNumbers obj = new SortTwoNumbers();
        obj.run();
    }
}
