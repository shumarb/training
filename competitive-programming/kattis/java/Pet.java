import java.util.Scanner;

class Pet {
    
    private void readsScores(int[][] scores) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }
    
    private void displaysResults(int[][] scores) {
        int maxScore = 0, winningIndex = 0;
        
        // Computes result of first participant
        for (int i = 0; i < scores[0].length; i++) {
            maxScore += scores[0][i];
        }
        
        for (int i = 1; i < scores.length; i++) {
            int currScore = 0;
            for (int j = 0; j < scores[i].length; j++) {
                currScore += scores[i][j];
            }
            if (currScore > maxScore) {
                maxScore = currScore;
                winningIndex = i;
            }
        }
        
        winningIndex += 1; // 1-based counting
        System.out.println(winningIndex + " " + maxScore);
    }
    
    private void run() {
        int[][] scores = new int[5][4];
        readsScores(scores);
        displaysResults(scores);
    }
    
    public static void main(String[] args) {
        Pet obj = new Pet();
        obj.run();
    }
}
