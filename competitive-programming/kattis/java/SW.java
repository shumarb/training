import java.lang.String;
import java.util.Scanner;

class SW {

    private boolean isTest = false;
    private String readsSequence() {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        sc.close();
        return word;
    }
    
    private void displaysPoints(int points) {
        System.out.println(points);
    }
    
    private int computesLetter(String sequence, char letter) {
        int numLetter = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == letter) {
                numLetter += 1;
            }
        }
        return numLetter;
    }

    private double computesNumSets(double numT, double numC, double numG) {
        if (numT > 0 && numC > 0 && numG > 0) {
            return 7 * Math.min(numG, Math.min(numT, numC));
        } else if (numT == numC && numT == numG && numC == numG) {
            return 7 * numT;
        }
        return 0;
    }
    
    private int computesScore(String sequence) {
        double numT = computesLetter(sequence, 'T');
        double numC = computesLetter(sequence, 'C');
        double numG = computesLetter(sequence, 'G');
        double numSets = computesNumSets(numT, numC, numG);
        if (isTest) {
            System.out.println("numT = " + numT + ", numC = " + numC + ", numG = " + numG);
            System.out.println("numSets = " + numSets);
        }
        double result = Math.pow(numT, 2.0) + Math.pow(numC, 2.0) + Math.pow(numG, 2.0);
        return (int) (result + numSets);
    }
    
    private void run() {
        String sequence = readsSequence();
        int points = computesScore(sequence);
        displaysPoints(points);
    }
    
    public static void main(String[] args) {
        SW obj = new SW();
        obj.run();
    }
}
