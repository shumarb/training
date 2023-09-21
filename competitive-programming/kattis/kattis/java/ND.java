import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class ND {
    
    private String[] readsWords() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split(" ");
        return words;
    }
    
    private void displaysOutput(boolean isDuplicate) {
        if (isDuplicate) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
    
    private boolean checksDuplicates(String[] words) {
        HashSet <String> distinctWords = new HashSet <String> ();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (distinctWords.contains(word)) {
                return true;
            } else {
                distinctWords.add(word);
            }
        }
        return false;
    }
    
    private void run() {
        String[] words = readsWords();
        boolean isDuplicate = checksDuplicates(words);
        displaysOutput(isDuplicate);
    }
    
    public static void main(String[] args) {
        ND obj = new ND();
        obj.run();
    }    
}
