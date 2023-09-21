import java.util.Scanner;

class Bijele {
    
    private int[] initialisesArray() {
        int[] numCorrect = {1, 1, 2, 2, 2, 8};
        return numCorrect;
    }
    
    private int[] readsInput() {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[6];
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        sc.close();
        return input;
    }
    
    private void displaysAns(int[] ans) {
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
    
    private int[] computesAns(int[] numCorrectPieces, int[] input) {
        int[] ans = new int[6];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = numCorrectPieces[i] - input[i];
        }
        return ans;
    }
    
    private void run() {
        int[] numCorrectPieces = initialisesArray();
        int[] input = readsInput();
        int[] ans = computesAns(numCorrectPieces, input);
        displaysAns(ans);
    }
    public static void main(String[] args) {
        Bijele obj = new Bijele();
        obj.run();
    }    
}
