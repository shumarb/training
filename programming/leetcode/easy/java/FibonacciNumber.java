import java.util.Vector;

class Solution {
    public int fib(int N) {
        Vector <Integer> fibNumbers = new Vector <Integer> ();
        for (int i = 0; i <= N; i++) {
            if (i <= 1) {
                fibNumbers.add(i);
            } else {
                fibNumbers.add(fibNumbers.get(i - 2) + fibNumbers.get(i - 1));
            }
        }
        return fibNumbers.get(N);
    }
}