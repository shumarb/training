import java.util.Scanner;

class TTS {

    private void displaysWinner(String winner) {
        System.out.println(winner);
    }

    private String getsWinner() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        if ((N % 2) == 0) {
            return "Bob";
        }
        return "Alice";
    }

    private void run() {
        String winner = getsWinner();
        displaysWinner(winner);
    }
    public static void main(String[] args) {
        TTS obj = new TTS();
        obj.run();
    }
}
