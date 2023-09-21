import java.lang.String;
import java.util.Scanner;

class Hiss {
    
    private String readsWord() {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        sc.close();
        return word;
    }
    
    private void displaysResult(boolean isDoubleS) {
        if (isDoubleS) {
            System.out.println("hiss");
        } else {
            System.out.println("no hiss");
        }
    }
    
    private boolean computesResult(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            char currChar = word.charAt(i);
            char nextChar = word.charAt(i + 1);
            if (currChar == 's' && nextChar == 's') {
                return true;
            }
        }
        return false;
    }
    
    private void run() {
        String word = readsWord();
        boolean isDoubleS = computesResult(word);
        displaysResult(isDoubleS);
    }
    
    public static void main(String[] args) {
        Hiss obj = new Hiss();
        obj.run();
    }    
}
